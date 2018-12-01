var utils      = require("./util"),
    bodyParser = require("body-parser"),
    path       = require("path"),
    fs         = require("fs"),
    Promise    = require("promise");
var basicTimeSeconds = 1;
var randomTimeSeconds = 1;

// 历史页跳转时间
var basicTimeSecondsPro = 10;
var randomTimeSecondsPro = 10;
var isRootCAFileExists = require("./certMgr.js").isRootCAFileExists(),
    interceptFlag      = false;

// e.g. [ { keyword: 'aaa', local: '/Users/Stella/061739.pdf' } ]
var mapConfig = [],
    configFile = "mapConfig.json";
function saveMapConfig(content,cb){
    new Promise(function(resolve,reject){
        var anyproxyHome = utils.getAnyProxyHome(),
            mapCfgPath   = path.join(anyproxyHome,configFile);

        if(typeof content == "object"){
            content = JSON.stringify(content);
        }
        resolve({
            path    :mapCfgPath,
            content :content
        });
    })
    .then(function(config){
        return new Promise(function(resolve,reject){
            fs.writeFile(config.path, config.content, function(e){
                if(e){
                    reject(e);
                }else{
                    resolve();
                }
            });
        });
    })
    .catch(function(e){
        cb && cb(e);
    })
    .done(function(){
        cb && cb();
    });
}
function getMapConfig(cb){
    var read = Promise.denodeify(fs.readFile);

    new Promise(function(resolve,reject){
        var anyproxyHome = utils.getAnyProxyHome(),
            mapCfgPath   = path.join(anyproxyHome,configFile);

        resolve(mapCfgPath);
    })
    .then(read)
    .then(function(content){
        return JSON.parse(content);
    })
    .catch(function(e){
        cb && cb(e);
    })
    .done(function(obj){
        cb && cb(null,obj);
    });
}

setTimeout(function(){
    // load saved config file
    getMapConfig(function(err,result){
        if(result){
            mapConfig = result;
        }
    });
},1000);


module.exports = {
    token: Date.now(),
    summary:function(){
        var tip = "the default rule for AnyProxy.";
        if(!isRootCAFileExists){
            tip += "\nRoot CA does not exist, will not intercept any https requests.";
        }
        return tip;
    },

    shouldUseLocalResponse : function(req,reqBody){
        // intercept all options request
        var simpleUrl = (req.headers.host || "") + (req.url || "");
        mapConfig.map(function(item){
            var key = item.keyword;
            if(simpleUrl.indexOf(key) >= 0){
                req.anyproxy_map_local = item.local;
                return false;
            }
        });


        return !!req.anyproxy_map_local;
    },

    dealLocalResponse : function(req,reqBody,callback){
        if(req.anyproxy_map_local){
            fs.readFile(req.anyproxy_map_local,function(err,buffer){
                if(err){
                    callback(200, {}, "[AnyProxy failed to load local file] " + err);
                }else{
                    var header = {
                        'Content-Type': utils.contentType(req.anyproxy_map_local)
                    };
                    callback(200, header, buffer);
                }
            });
        }
    },

    replaceRequestProtocol:function(req,protocol){
    },

    replaceRequestOption : function(req,option){
        var newOption = option;
        if(/google/i.test(newOption.headers.host)){
            newOption.hostname = "www.baidu.com";
            newOption.port     = "80";
        }
        return newOption;
    },

    replaceRequestData: function(req,data){
    },

    replaceResponseStatusCode: function(req,res,statusCode){
    },

    replaceResponseHeader: function(req,res,header){
    },

    // Deprecated
    // replaceServerResData: function(req,res,serverResData){
    // return serverResData;
    // },

    replaceServerResDataAsync: function(req,res,serverResData,callback){
    	 if(/map\/getmasssendmsg\?__biz/i.test(req.url)){// 当链接地址为公众号历史消息页面时(第一种页面形式)
             if(serverResData.toString() !== ""){
                 try {// 防止报错退出程序
                     var reg = /msgList = (.*?);/;// 定义历史消息正则匹配规则
                     var ret = reg.exec(serverResData.toString());// 转换变量为string
                     HttpPost(ret[1],req.url,"/crazy_blog/getMsgJson");// 这个函数是后文定义的，将匹配到的历史消息json发送到自己的服务器
                     var http = require('http');
                     
                     http.get('http://192.168.1.121/crazy_blog/getWxHis', function(res) {// 这个地址是自己服务器上的一个程序，目的是为了获取到下一个链接地址，将地址放在一个js脚本中，将页面自动跳转到下一页。后文将介绍getWxHis.php的原理。
                         res.on('data', function(chunk){
                        	 console.log("*********正则匹配成功*****");
                        	 callback(chunk+serverResData);// 将返回的代码插入到历史消息页面中，并返回显示出来
                         })
                     });
                 }catch(e){// 如果上面的正则没有匹配到，那么这个页面内容可能是公众号历史消息页面向下翻动的第二页，因为历史消息第一页是html格式的，第二页就是json格式的。
                      try {
                         var json = JSON.parse(serverResData.toString());
                         if (json.general_msg_list != []) {
                         HttpPost(json.general_msg_list,req.url,"/crazy_blog/getMsgJson");// 这个函数和上面的一样是后文定义的，将第二页历史消息的json发送到自己的服务器
                         console.log("************则没有匹配到**************");
                         }
                      }catch(e){
                        console.log(e);// 错误捕捉
                      }
                     callback(serverResData);// 直接返回第二页json内容
                 }
             }
         }else if(/mp\/profile_ext\?action=home/i.test(req.url)){// 当链接地址为公众号历史消息页面时(第二种页面形式)
             try {
            	 
                 var reg = /var msgList = \'(.*?)\';/;// 定义历史消息正则匹配规则（和第一种页面形式的正则不同）
                 var ret = reg.exec(serverResData.toString());// 转换变量为string
                 HttpPost(ret[1],req.url,"/crazy_blog/getMsgJson");// 这个函数是后文定义的，将匹配到的历史消息json发送到自己的服务器
                 var content = serverResData.toString();
                // var http = require('http');
                 // http.get('http://192.168.1.121/crazy_blog/getWxHis',
					// function(res) {//
					// 这个地址是自己服务器上的一个程序，目的是为了获取到下一个链接地址，将地址放在一个js脚本中，将页面自动跳转到下一页。后文将介绍getWxHis.php的原理。
                    // res.on('data', function(chunk){
                    	 console.log("************公众号历史消息(没有翻页Home)**************"+serverResData);
                    	 var scrollDownJs = '<script type="text/javascript">var end = document.createElement("p");document.body.appendChild(end);(function scrollDown(){end.scrollIntoView();setTimeout(scrollDown,Math.floor(Math.random()*5000+5000));})();</script>'
                 			content = content.replace("<!--headTrap<body></body><head></head><html></html>-->","").replace("<!--tailTrap<body></body><head></head><html></html>-->","");
                 			content = content.replace("</body>",scrollDownJs + "\n</body>");
                 			serverResData = content;
                 			console.log("************公众号历史消息######**************"+serverResData);
                 			callback(serverResData);
                         // callback(chunk+serverResData);//
							// 将返回的代码插入到历史消息页面中，并返回显示出来
                   // })
               // });
             }catch(e){
                 callback(serverResData);
             }
         }else if(/mp\/profile_ext\?action=getmsg/i.test(req.url)){// 第二种页面表现形式的向下翻页后的json
             try {
                 var json = JSON.parse(serverResData.toString());
                 if (json.general_msg_list != []) {
                     HttpPost(json.general_msg_list,req.url,"/crazy_blog/getMsgJson");// 这个函数和上面的一样是后文定义的，将第二页历史消息的json发送到自己的服务器
                     console.log("************公众号历史消息(翻页后的json)**************");
                 }
             }catch(e){
                 console.log(e);
             }
             callback(serverResData);
         }else if(/mp\/getappmsgext/i.test(req.url)){// 当链接地址为公众号文章阅读量和点赞量时
             try {
            	 var haeder = JSON.stringify(req.headers);
                 HttpPost(serverResData+'skip'+haeder,req.url,"/crazy_blog/getMsgExt");// 函数是后文定义的，功能是将文章阅读量点赞量的json发送到服务器
                 console.log("*********文章阅读量和点赞量**********");
             }catch(e){

             }
             callback(serverResData);
         }else if(/s\?__biz/i.test(req.url) || /mp\/rumor/i.test(req.url)){// 当链接地址为公众号文章时（rumor这个地址是公众号文章被辟谣了）
             try {
                 var http = require('http');
                 http.get('http://192.168.1.121/crazy_blog/getWxPost', function(res) {// 这个地址是自己服务器上的另一个程序，目的是为了获取到下一个链接地址，将地址放在一个js脚本中，将页面自动跳转到下一页。后文将介绍getWxPost.php的原理。
                     res.on('data', function(chunk){
                    	 var delayTime = Math.floor(Math.random()*randomTimeSeconds+basicTimeSeconds);
                 		// 实质是注入头部meta标签，跳转至下一个网页
                 		var insertJs = '<meta http-equiv="refresh" content="' + delayTime + ';url=' + chunk + '" />';
                 		// 此刻改变了serverResData的内容，返回至微信客户端中
                 		serverResData = serverResData.toString().replace('</title>', '</title>' + insertJs);			
                 		callback(serverResData);
                         console.log("*********公众号文章详情**********"+chunk+serverResData);
                     })
                 });
             }catch(e){
            	 console.log("*********异常公众号文章详情**********");
                 callback(serverResData);
                 
             }
         }else{
        	 console.log("*********其他公众号文章详情**********");
             callback(serverResData);
             
         }
    },

    pauseBeforeSendingResponse: function(req,res){
    },

    shouldInterceptHttpsReq:function(req){
        return interceptFlag;
    },

    // [beta]
    // fetch entire traffic data
    fetchTrafficData: function(id,info){},

    setInterceptFlag: function(flag){
        interceptFlag = flag && isRootCAFileExists;
    },

    _plugIntoWebinterface: function(app,cb){

        app.get("/filetree",function(req,res){
            try{
                var root = req.query.root || utils.getUserHome() || "/";
                utils.filewalker(root,function(err, info){
                    res.json(info);
                });
            }catch(e){
                res.end(e);
            }
        });

        app.use(bodyParser.json());
        app.get("/getMapConfig",function(req,res){
            res.json(mapConfig);
        });
        app.post("/setMapConfig",function(req,res){
            mapConfig = req.body;
            res.json(mapConfig);

            saveMapConfig(mapConfig);
        });

        cb();
    },

    _getCustomMenu : function(){
        return [
            // {
            // name:"test",
            // icon:"uk-icon-lemon-o",
            // url :"http://anyproxy.io"
            // }
        ];
    }
};

function HttpPost(str,url,path) {// 将json发送到服务器，str为json内容，url为历史消息页面地址，path是接收程序的路径和文件名
    var http = require('http');
    var data = {
    		str: encodeURIComponent(str),
            url: encodeURIComponent(url)
    };
    content = require('querystring').stringify(data);
    var options = {
        method: "POST",
        host: "localhost",// 注意没有http://，这是服务器的域名。
        port: 80,
        path: path,// 接收程序的路径和文件名
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
            "Content-Length": content.length
        }
    };
    var req = http.request(options, function (res) {
        res.setEncoding('utf8');
        res.on('data', function (chunk) {
            console.log('BODY: ' + chunk);
        });
    });
    req.on('error', function (e) {
        console.log('problem with request: ' + e.message);
    });
    req.write(content);
    req.end();
}

