<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0,viewport-fit=cover">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">


        <script nonce="" type="text/javascript">
            window.logs = {
                pagetime: {}
            };
            window.logs.pagetime['html_begin'] = (+new Date());
        </script>
        <title></title>
        
<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/0.2.0/weui.css">
<link rel="stylesheet" href="https://res.wx.qq.com/open/libs/weui/1.1.1/weui.css">
<link rel="stylesheet" href="//res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/profile/index41b944.css">
<link rel="stylesheet" type="text/css" href="//res.wx.qq.com/mmbizwap/zh_CN/htmledition/style/page/pages/video42593c.css" />

    </head>
    <body id="" class="zh_CN    ">
        
        <link rel="dns-prefetch" href="//res.wx.qq.com">
<link rel="dns-prefetch" href="//mmbiz.qpic.cn">
<link rel="shortcut icon" type="image/x-icon" href="//res.wx.qq.com/mmbizwap/zh_CN/htmledition/images/icon/common/favicon22c41b.ico">
<script nonce="" type="text/javascript">
    String.prototype.html = function(encode) {
        var replace =["&#39;", "'", "&quot;", '"', "&nbsp;", " ", "&gt;", ">", "&lt;", "<", "&yen;", "¥", "&amp;", "&"];
        
		
		
		
		
        
        var replaceReverse = ["&", "&amp;", "¥", "&yen;", "<", "&lt;", ">", "&gt;", " ", "&nbsp;", '"', "&quot;", "'", "&#39;"];
	    var target;
	    if (encode) {
	    	target = replaceReverse;
	    } else {
	    	target = replace;
	    }
        for (var i=0,str=this;i< target.length;i+= 2) {
             str=str.replace(new RegExp(target[i],'g'),target[i+1]);
        }
        return str;
    };

    window.isInWeixinApp = function() {
        return /MicroMessenger/.test(navigator.userAgent);
    };

    window.getQueryFromURL = function(url) {
        url = url || 'http://qq.com/s?a=b#rd'; 
        var tmp = url.split('?'),
            query = (tmp[1] || "").split('#')[0].split('&'),
            params = {};
        for (var i=0; i<query.length; i++) {
            var arg = query[i].split('=');
            params[arg[0]] = arg[1];
        }
        if (params['pass_ticket']) {
        	params['pass_ticket'] = encodeURIComponent(params['pass_ticket'].html(false).html(false).replace(/\s/g,"+"));
        }
        return params;
    };

    (function() {
	    var params = getQueryFromURL(location.href);
        window.uin = params['uin'] || "777" || '';
        window.key = params['key'] || "777" || '';
        window.wxtoken = params['wxtoken'] || '';
        window.pass_ticket = params['pass_ticket'] || '';
        window.appmsg_token = "986_0UJ6eG%2B8hxxw%2FpyDs08GIIv26v8QCIrvg_fSEw~~";
    })();

    function wx_loaderror() {
        if (location.pathname === '/bizmall/reward') {
            new Image().src = '/mp/jsreport?key=96&content=reward_res_load_err&r=' + Math.random();
        }
    }

</script>

<script nonce="" type="text/javascript">
            window.no_moon_ls = 0;
    </script>
        
<div class="profile_container">
    <script type="text/javascript">
        if (window.location != window.parent.location) { 
            window.location.href = 'http://mp.weixin.qq.com/mp/readtemplate?t=wxm-cannot-open#wechat_redirect';
        }
        var pass_ticket = "7xmsOSJ9Zkeb83eITsmmp481bXpluSV+ouWPpT0fGnLCPvI75jpgNYQBUHu+7pN0" || "";
        var uin = "777" || "";
        var key = "777" || "";
    </script>
    
    <div class="weui-search-bar" title="搜索" role="search" aria-label="搜索公众号文章" id="js_search" style="display:none;">
        <div class="weui-search-bar__form" style="-webkit-user-select:none;-khtml-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;">
            <label class="weui-search-bar__label">
                <i class="weui-icon-search"></i>
                <span>搜索</span>
            </label>
        </div>
    </div>
    <div class="profile_info appmsg">
        <span class="radius_avatar profile_avatar">
            <img src="http://wx.qlogo.cn/mmhead/Q3auHgzwzM4R3Hwm1K6R2KzVwQpbdPpYsbxaA3sdyCEbmrrA5CaoIQ/0" id="icon">
        </span>
        <strong class="profile_nickname" id="nickname">
            北京移动        </strong>
                <p class="profile_desc">
                        北京移动唯一官方指定公众号！&nbsp;信息一键查询、业务在线办理、最新优惠资讯，还有更多免费流量、话费、积分活动等你来参与~~                    </p>
    

    </div>

    
    <div class="profile-operator" id="js_operator"> 
        
        <a href="javascript:void(0);" id="js_btn_view_profile" class="weui-btn weui-btn_plain-primary" >发消息</a>
        <a href="javascript:void(0);" id="js_btn_add_contact" class="weui-btn weui-btn_plain-primary" style="display:none;">关注</a>
    </div>

    

    <script type="text/html" id="js_reward_area_tpl">
        {{each money as m}}
            <a href="javascript:;" class="reward-list__item" data-price="{{m/100}}">
                <span class="reward-list__item-inner">
                {{m/100}} <span class="currency">元</span>
                </span>
            </a>
        {{/each}}
    </script>

    <script type="text/javascript">
        var is_ok = 1; 
        var scene = "126" || ""; 
        var a8scene = "3"; 
        var session_us = ""; 

        (function() {
            var is_android = /(Android)/i.test(navigator.userAgent);
            
            var __JSAPI__ = {
                ready: function(onBridgeReady) {
                    var _onBridgeReady = function() {
                        if (!!onBridgeReady) {
                            onBridgeReady();
                        }
                    };
                    
                    if (typeof top.window.WeixinJSBridge == "undefined" || !top.window.WeixinJSBridge.invoke) {
                        
                        if (top.window.document.addEventListener) {
                            top.window.document.addEventListener('WeixinJSBridgeReady', _onBridgeReady, false);
                        } else if (top.window.document.attachEvent) {
                            top.window.document.attachEvent('WeixinJSBridgeReady', _onBridgeReady);
                            top.window.document.attachEvent('onWeixinJSBridgeReady', _onBridgeReady);
                        }
                    } else {
                        
                        _onBridgeReady();
                    }
                },
                invoke: function(methodName, args, callback) {
                    this.ready(function() {
                        
                        if (typeof top.window.WeixinJSBridge != "object" ) {
                            alert("请在微信中打开此链接！");
                            return false;
                        }
                        top.window.WeixinJSBridge.invoke(methodName, args, function(ret){
                            if (!!callback) {
                                callback.apply(window, arguments);
                                var err_msg = ret && ret.err_msg ? ", err_msg-> " + ret.err_msg : "";
                                console.info("[jsapi] invoke->" + methodName + err_msg);
                            }
                        });
                    });
                }
            }
            var __Ajax__ = function(obj) {

                var type = (obj.type || 'GET').toUpperCase();
                var async = typeof obj.async == 'undefined' ? true : obj.async;
                var url = obj.url;
                var xhr = new XMLHttpRequest();
                var timer = null;
                var data = null;

                if (typeof obj.data == "object"){
                    var d = obj.data;
                    data = [];
                    for(var k in d) {
                        if (d.hasOwnProperty(k)){
                            data.push(k + "=" + encodeURIComponent(d[k]));
                        }
                    }
                    data = data.join("&");
                }else{
                    data = typeof obj.data  == 'string' ? obj.data : null;
                }

                xhr.open(type, url, async);
                var _onreadystatechange = xhr.onreadystatechange; 

                xhr.onreadystatechange = function() {
                    
                    if (typeof _onreadystatechange == 'function') {
                        _onreadystatechange.apply(xhr);
                    }
                    if ( xhr.readyState == 3 ) {
                        obj.received && obj.received(xhr);
                    }
                    if ( xhr.readyState == 4 ) {
                        xhr.onreadystatechange = null;
                        var status = xhr.status;
                        if ( status >= 200 && status < 400 ) {
                            var responseText = xhr.responseText;
                            var resp = responseText;
                            if (obj.dataType == 'json'){
                                try{
                                    resp = eval("(" + resp + ")");
                                }catch(e){
                                    obj.error && obj.error(xhr);
                                    return;
                                }
                            }
                            obj.success && obj.success(resp);
                        } else {
                            obj.error && obj.error(xhr);
                        }
                        clearTimeout(timer);
                        obj.complete && obj.complete();
                        obj.complete = null;
                    }
                };
                if( type == 'POST' ){
                    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                }
                xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
                if( typeof obj.timeout != 'undefined' ){
                    timer = setTimeout(function(){
                        xhr.abort("timeout");
                        obj.complete && obj.complete();
                        obj.complete = null;
                    }, obj.timeout);
                }
                try{
                    xhr.send(data);
                } catch ( e ) {
                    obj.error && obj.error();
                }
            }
            if (navigator.userAgent.indexOf("WindowsWechat") != -1) { 
                __Ajax__({
                    type: 'POST',
                    dataType: 'json',
                    url: '/mp/profile_ext?action=urlcheck&uin=' + window.uin + '&key=' + window.key + '&pass_ticket=' + window.pass_ticket + "&appmsg_token=" + window.appmsg_token + '&a8scene=' + a8scene + '&session_us=' + session_us,
                    data: {
                        __biz: 'MjM5Nzg1NTQyMQ==',
                        scene: scene,
                        url_list: ''
                    },
                    success: function(res) {}
                });
                return ;
            }
            __JSAPI__.invoke('getRouteUrl', {}, function(res) { 
                if (res.err_msg.indexOf('ok') != -1) {
                    var url = res.urls;
                    if (is_android) {
                        url = JSON.parse(url);
                    }
                    __Ajax__({
                        type: 'POST',
                        dataType: 'json',
                        url: '/mp/profile_ext?action=urlcheck&uin=' + window.uin + '&key=' + window.key + '&pass_ticket=' + window.pass_ticket + "&appmsg_token=" + window.appmsg_token + '&a8scene=' + a8scene + '&session_us=' + session_us,
                        data: {
                            __biz: 'MjM5Nzg1NTQyMQ==',
                            scene: scene,
                            url_list: JSON.stringify({url_list: url})
                        },
                        success: function(res) {
                            if (res.is_ok == 0) {
                                
                                document.getElementById('js_btn_add_contact').style.display = 'none';
                                
                                is_ok = 0;
                            } else {
                                
                                
                                
                                is_ok = 1;
                            }
                        }
                    });
                } else { 
                    
                    
                    
                    __Ajax__({
                        type: 'POST',
                        dataType: 'json',
                        url: '/mp/profile_ext?action=urlcheck&uin=' + window.uin + '&key=' + window.key + '&pass_ticket=' + window.pass_ticket + "&appmsg_token=" + window.appmsg_token + '&a8scene=' + a8scene + '&session_us=' + session_us,
                        data: {
                            __biz: 'MjM5Nzg1NTQyMQ==',
                            scene: scene,
                            url_list: ''
                        },
                        success: function(res) {}
                    });
                }
            });
        })();
    </script>
    
        


    <div class="weui_category_title js_tag">所有消息</div>
    <div class="weui-panel">
    <div class="weui-panel__hd" id="selectType" style="display: none;">
        <div class="weui-dropdown-tips" id="showSelectedType">
                        全部        </div>
        历史消息    </div>
    <div class="weui-panel__bd appmsg_history_container" id="js_container"></div>
    </div>

    <div id="select_tpl">
    <div class="weui-mask" id="iosMask" style="display: none"></div>
    <div class="weui-actionsheet" id="iosActionsheet">
        <div class="weui-actionsheet__menu">
        <div class="weui-actionsheet__cell confirmType" data-type="all">全部</div>
        <div class="weui-actionsheet__cell confirmType" data-type="video">视频</div>
        </div>
        <div class="weui-actionsheet__action">
        <div class="weui-actionsheet__cell confirmType" id="iosActionsheetCancel" data-type="cancel">取消</div>
        </div>
    </div>
    </div>
</div>





        
        <script nonce="">
    var __DEBUGINFO = {
        debug_js : "//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/debug/console34c264.js",
        safe_js : "//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/safe/moonsafe34c264.js",
        res_list: []
    };
</script>

<script nonce="" type="text/javascript">
(function() {
	var totalCount = 0,
			finishCount = 0;

	function _loadVConsolePlugin() {
		window.vConsole = new window.VConsole();
		while (window.vConsolePlugins.length > 0) {
			var p = window.vConsolePlugins.shift();
			window.vConsole.addPlugin(p);
		}
	}
	
	function _addVConsole(uri, cb) {
		totalCount++;
		var url = '//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/vconsole/' + uri;
		var node = document.createElement('SCRIPT');
		node.type = 'text/javascript';
		node.src = url;
		node.setAttribute('nonce', '');
		if (cb) {
			node.onload = cb;
		}
		document.getElementsByTagName('head')[0].appendChild(node);
	}
	if (
		(document.cookie && document.cookie.indexOf('vconsole_open=1') > -1)
		|| location.href.indexOf('vconsole=1') > -1
	) {
		window.vConsolePlugins = [];
		_addVConsole('3.0.0/vconsole.min.js', function() {
			
			_addVConsole('plugin/vconsole-mpopt/1.0.1/vconsole-mpopt.js', _loadVConsolePlugin);
		});
	}
})();
</script>
        
        <script>window.__moon_host = 'res.wx.qq.com';window.moon_map = {"cdg_module/dist/sdk.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/cdg_module/dist/sdk40d8ef.js","new_video/plugin/frameAd.html.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/new_video/plugin/frameAd.html40c91a.js","new_video/plugin/imgAd.html.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/new_video/plugin/imgAd.html3dd294.js","biz_wap/utils/ajax_load_js.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/ajax_load_js3d3b85.js","new_video/player.html.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/new_video/player.html410d1c.js","biz_wap/utils/openUrl.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/openUrl424c53.js","biz_common/utils/report.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/report3518c6.js","a/wxopen_card.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/a/wxopen_card41b040.js","new_video/plugin/frameAd.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/new_video/plugin/frameAd41b4d4.js","new_video/plugin/imgAd.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/new_video/plugin/imgAd371664.js","biz_wap/utils/hashrouter.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/hashrouter34c264.js","biz_wap/jsapi/log.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/jsapi/log34c264.js","new_video/plugin_base.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/new_video/plugin_base292ed8.js","biz_wap/utils/device.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/device3e2bd7.js","pages/video_plugin/base.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/video_plugin/base2e481d.js","pages/video_ctrl.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/video_ctrl4047ec.js","pages/create_txv.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/create_txv401e7e.js","pages/video_error.html.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/video_error.html40526b.js","biz_common/tmpl.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/tmpl3518c6.js","new_video/ctl.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/new_video/ctl41b4d4.js","new_video/player.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/new_video/player41b4d4.js","new_video/plugin/ad.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/new_video/plugin/ad41b040.js","new_video/plugin/proxy.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/new_video/plugin/proxy4047ec.js","biz_common/dom/attr.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/dom/attr3518c6.js","pages/report.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/report41b4d4.js","pages/version4video.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/version4video40c91a.js","biz_wap/utils/storage.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/storage34c264.js","biz_wap/utils/localstorage.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/localstorage36c4f2.js","pages/video_plugin/video_monitor.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/video_plugin/video_monitor3d3b85.js","pages/loadscript.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/loadscript3d3b85.js","pages/iframe_communicate.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/iframe_communicate409b7e.js","biz_wap/zepto/touch.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/zepto/touch34c264.js","biz_wap/utils/log.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/log34c264.js","biz_wap/utils/ajax_wx.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/ajax_wx405300.js","biz_common/utils/respTypes.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/respTypes3518c6.js","biz_common/utils/wxgspeedsdk.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/wxgspeedsdk3518c6.js","biz_common/template-2.0.1-cmd.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/template-2.0.1-cmd3518c6.js","biz_common/utils/url/parse.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/url/parse36ebcf.js","biz_common/utils/monitor.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/monitor3518c6.js","appmsg/malicious_wording.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/malicious_wording3dd66a.js","pages/qq_video_info.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/qq_video_info42576a.js","biz_common/utils/emoji_data.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/emoji_data3518c6.js","history/profile_history_v2.html.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/history/profile_history_v2.html41d22f.js","biz_common/utils/string/html.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/utils/string/html410c03.js","appmsg/cdn_img_lib.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/cdn_img_lib41931e.js","pages/video_communicate_adaptor.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/pages/video_communicate_adaptor41b4d4.js","biz_wap/zepto/zepto.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/zepto/zepto34c264.js","biz_wap/zepto/fx.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/zepto/fx3baab7.js","biz_wap/utils/fakehash.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/fakehash38c7af.js","biz_wap/jsapi/pay.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/jsapi/pay34c264.js","appmsg/log.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/log300330.js","biz_wap/jsapi/core.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/jsapi/core3d3b85.js","biz_wap/utils/ajax.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/ajax4257f4.js","history/performance.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/history/performance3717bc.js","biz_wap/utils/mmversion.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/utils/mmversion3de208.js","biz_common/dom/event.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_common/dom/event3a25e9.js","history/template_helper.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/history/template_helper24f185.js","history/profile_history_v2.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/history/profile_history_v241b4d4.js","biz_wap/zepto/event.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/zepto/event34c264.js","biz_wap/zepto/fx_methods.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/zepto/fx_methods3baab7.js","appmsg/profile.js":"//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/appmsg/profile41b944.js"};</script><script type="text/javascript">window.__wxgspeeds={}; window.__wxgspeeds.moonloadtime=+new Date()</script><script  type="text/javascript" src="//res.wx.qq.com/mmbizwap/zh_CN/htmledition/js/biz_wap/moon415acd.js"></script>
<script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script type="text/javascript">

    
    var username = "" || "gh_acfa349a623b";
    var is_subscribed = "1" * 1;
    var action = "home" || "";
    var bizacct_type = "" || "";
    var can_msg_continue = '1' * 1;
    var headimg = "http://wx.qlogo.cn/mmhead/Q3auHgzwzM4R3Hwm1K6R2KzVwQpbdPpYsbxaA3sdyCEbmrrA5CaoIQ/0" || "";
    var nickname = "北京移动" || "";
    var is_banned = "0" * 1;
    var __biz = "MjM5Nzg1NTQyMQ==";
    var next_offset = "11" * 1;
    
    var use_video_tab = "1" || "";
    var video_count = "1" || "";
    var real_type = "0" || "";
    var defaultHistoryType = (real_type == "43") ? "video" : "all";

    var appmsgid = "" || ""; 
    var idx = "" || ""; 
    var reprint_biz = "" || ""; 
    var reprint_appmsgid = "" || ""; 
    var reprint_idx = "" || ""; 
    var timestamp = "" || ""; 
    

    var vid = '';
    var url = '';
    if (/\//.test(url)) url = encodeURIComponent(url); 

    window.cgiData = {
        appid: "wx3be6367203f983ac",
        timestamp: "1544372078",
        noncestr: "v7ln1zgEwwV0XbMVTw4X",
        signature: "c2f223e22d03b693b2fe1d6e69f8668db327321e",
    }

        var msgList = '{&quot;list&quot;:[{&quot;comm_msg_info&quot;:{&quot;id&quot;:1000000629,&quot;type&quot;:49,&quot;datetime&quot;:1544175923,&quot;fakeid&quot;:&quot;2397855421&quot;,&quot;status&quot;:2,&quot;content&quot;:&quot;&quot;},&quot;app_msg_ext_info&quot;:{&quot;title&quot;:&quot;‼️双十二送福利，12GB免费领‼️&quot;,&quot;digest&quot;:&quot;双十二送福利，可以领12.12GB全国流量哦~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226811,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710461&amp;amp;idx=1&amp;amp;sn=0818e8613fa1b1fdbc50e79df8389d0a&amp;amp;chksm=bcbd97af8bca1eb91059855788608c9cfe27477d6acd3f7d5814ad9efbf1089a695b05effac0&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2FdecemberRichMan2018%2Findex.do&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=decemberRichMan2018#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAe6qeslJGHZ5CU4nI5dLNMWljAiarvblL7RWEvrK8Rxy1ickn7XtSCPoH25fANV8v2k1SWx6B29oVg\\/0?wx_fmt=jpeg&quot;,&quot;subtype&quot;:9,&quot;is_multi&quot;:1,&quot;multi_app_msg_item_list&quot;:[{&quot;title&quot;:&quot;钜惠‼️5GB全国流量=?.99元‼️&quot;,&quot;digest&quot;:&quot;流量拼购，立省43元，还送爱奇艺会员哦~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226803,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710461&amp;amp;idx=2&amp;amp;sn=45cdc2246decd61cd9e50fdf5773de1b&amp;amp;chksm=bcbd97af8bca1eb97c5ff7de1ef1b81d0a149abf9c617a38cfa0b3f4bb22326a7138faf8491b&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2FdecemberRichMan2018%2Findex.do&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=decemberRichMan2018#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAe6qeslJGHZ5CU4nI5dLNMNpv06jx7lWKuvfDJpVlKRkdAhlUFQSvxicPRzukm9sX9I3ibFrXHSfeA\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;岁末有礼，最高送您3GB！&quot;,&quot;digest&quot;:&quot;岁末有礼，参与活动最高送您3GB！流量特惠，12GB仅需12元！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226804,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710461&amp;amp;idx=3&amp;amp;sn=d2a19a7b6bb1b3ae6f7dc5af2f5a802c&amp;amp;chksm=bcbd97af8bca1eb9df2989d6c0217a4a6dfd50e4bc930764b184291c018b7db52ea0b03c9987&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2Fredirect%2FdispenseRequest.action&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=projt20181204#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAe6qeslJGHZ5CU4nI5dLNMVKRwiaibYOLG5xK0oKjK90TVID4GNbQic1YxC1tYkkQfyNlQtksAU1NGw\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;90元大礼包，限时免费领取！&quot;,&quot;digest&quot;:&quot;免费送1GB流量和价值90元生活畅享派年包，手慢无~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226809,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710461&amp;amp;idx=4&amp;amp;sn=3ff4d4f0db70650dd8677717a5e2aa26&amp;amp;chksm=bcbd97af8bca1eb9eaa19b37ef4cb126adf0858a1255c49635ba817da86b852497056ea5355c&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;https:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2Fredirect%2FdispenseRequest.action&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=shcxp2018#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAe6qeslJGHZ5CU4nI5dLNMB5dpiafdbfzuQUq6hEWnQWJSXa3zw1GP7yFPcp4xUmnF4FN9RTR1BzA\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;擦屏刮刮乐，最高5GB任性送！&quot;,&quot;digest&quot;:&quot;年底回馈送流量，最高35GB免费送给你~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226806,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710461&amp;amp;idx=5&amp;amp;sn=296884842c6d4c7b9cb5ba10a87fc1bf&amp;amp;chksm=bcbd97af8bca1eb9d30eff1a2b57dade486ae5ba0cdb609add6d69af8919148201b222c91e8c&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2Fscratch2018%2Findex.do&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=channel#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAe6qeslJGHZ5CU4nI5dLNMyYkaEDLH322WkEdc3cetHKIcAYicOqkTORryz4sL8jjWZAKiaibawOfqA\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;【biu~】2019放假指南新鲜出炉，“五一”只放一天假！&quot;,&quot;digest&quot;:&quot;2019年怎么拼假才最high？&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226808,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710461&amp;amp;idx=6&amp;amp;sn=c72b55e400dcf59b47393676d2a6e354&amp;amp;chksm=bcbd97af8bca1eb9c8f0e49b8f743f70e3bc8967c19693e502f22998a4437982eeb1c62945b0&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAe6qeslJGHZ5CU4nI5dLNMSwR3PjxGtljH2JywbfHWI3Viau0MLBiaNSLOrt6nEudVEEoKVSGK6NBw\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}],&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;duration&quot;:0,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}},{&quot;comm_msg_info&quot;:{&quot;id&quot;:1000000623,&quot;type&quot;:49,&quot;datetime&quot;:1543568509,&quot;fakeid&quot;:&quot;2397855421&quot;,&quot;status&quot;:2,&quot;content&quot;:&quot;&quot;},&quot;app_msg_ext_info&quot;:{&quot;title&quot;:&quot;人人领取1.5GB‼️万元豪礼等你来抢‼️&quot;,&quot;digest&quot;:&quot;宝宝大赛报名倒计时，仅剩最后4天，抓紧来报名吧~还有机会夺取万元大奖哦~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226699,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710403&amp;amp;idx=1&amp;amp;sn=ee1fe3346084f98ea9e085a3ff5bd7dc&amp;amp;chksm=bcbd97918bca1e877df36b394e260efa1103bba873bfde7d31c87c3a32b8712cd7b80c3be6fd&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBSUuwXLBGRtrIW1Ajib8bbrdOohEHtPCB6dtuyESHUJlV5yTz8TibjYKue1KZudJh2I2htSbDfWlnw\\/0?wx_fmt=jpeg&quot;,&quot;subtype&quot;:9,&quot;is_multi&quot;:0,&quot;multi_app_msg_item_list&quot;:[],&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;duration&quot;:0,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}},{&quot;comm_msg_info&quot;:{&quot;id&quot;:1000000598,&quot;type&quot;:49,&quot;datetime&quot;:1542945921,&quot;fakeid&quot;:&quot;2397855421&quot;,&quot;status&quot;:2,&quot;content&quot;:&quot;&quot;},&quot;app_msg_ext_info&quot;:{&quot;title&quot;:&quot;宝宝大赛火爆开启‼️人人领取1.5GB‼️万元豪礼等你来抢‼️&quot;,&quot;digest&quot;:&quot;家有萌宝吗？快来报名捣蛋杯宝宝大赛吧，晒娃还有机会夺取万元大奖哦~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226577,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710227&amp;amp;idx=1&amp;amp;sn=68b939d35c1712daa84ece16187946ea&amp;amp;chksm=bcbd94418bca1d57c34ffdbd3e37db6ba8b5a05414d5728ccd89288657918cba36cbd3d5e30f&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAE07ThmKibP8GicuR4FGfRc1riaIZWShdQRkzAibMbbBfTAFGTSbnGkzaxx9UMiabHVtmBHPWk0HvkzNw\\/0?wx_fmt=jpeg&quot;,&quot;subtype&quot;:9,&quot;is_multi&quot;:1,&quot;multi_app_msg_item_list&quot;:[{&quot;title&quot;:&quot;免费送流量‼️15GB+‼️&quot;,&quot;digest&quot;:&quot;感恩“移”路有你，参与“比战力赢流量活动”，最高可得15GB+流量哦~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226540,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710227&amp;amp;idx=2&amp;amp;sn=87aeda4eac5e7242129d41d909c44be0&amp;amp;chksm=bcbd94418bca1d574a2507de7b5b14316fedd491508cf5c6027d06256899023fff4760340081&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2Fthanksgiving2018%2Findex.do&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=thanksgiving2018#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMCEiciauacYDMYiaddnKOIibjRGq3Zq97XbHVbOVHceYVxyPrsHotOuibZj4SQcqyiauRHbzFmmiaj2AsibYw\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;免费送会员，流量更超值~&quot;,&quot;digest&quot;:&quot;感恩送会员，让你在这个冬天更加温暖！快来领哦~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226541,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710227&amp;amp;idx=3&amp;amp;sn=5c6a9ee275605e47292a6a6356b89aae&amp;amp;chksm=bcbd94418bca1d57f22f0aa20c438047d0f34c3c8430b056c206c534879c5d20bcba0c0283b0&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2Fredirect%2FdispenseRequest.action&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=txtvxxyy#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMCEiciauacYDMYiaddnKOIibjRG8efsh7rL96tibB9qL783UFQJ7vtr7xYDvheiaZml9yicpTPmp9gCoY6nQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;咪咕视频会员仅需9.9元！&quot;,&quot;digest&quot;:&quot;咪咕视频钻石会员畅看超多热剧，还送30GB流量哦~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226542,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710227&amp;amp;idx=4&amp;amp;sn=2a90119be3ef41ec18150c34ec5c3ecb&amp;amp;chksm=bcbd94418bca1d576a957bd1b08ef230bb0bb03c08cc0631afa1c9504d9576c7057e459f9a09&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/cmscdn.bmcc.com.cn:8001\\/contentProject\\/H5\\/ad6bc84d7108483087b1d11a9beac5b4\\/ad6bc84d7108483087b1d11a9beac5b4.html?contactid=4&amp;amp;channelCode=10001&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMCEiciauacYDMYiaddnKOIibjRGqL0aY7bxmkv90hiazqbNnfAYiaLiaJX44xSrOU2BZrhM3sErGlUNBlRtw\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;【biu~】谢谢你~送你500MB~&quot;,&quot;digest&quot;:&quot;感恩的心，感谢有你，伴我朝夕，让我能够做更好的自己。2018，感谢你！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226544,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710227&amp;amp;idx=5&amp;amp;sn=0774d055bb4fcac27fdec66cd421ff8d&amp;amp;chksm=bcbd94418bca1d57ddaff609f2be9890315bc682a53a4ac5111b1b9019215f8734a46548a81c&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMCEiciauacYDMYiaddnKOIibjRGJWTCe1rMyp8FpnrECjHJA0ibVjvTO77QdiaIbVCmtnLsw9aqYp6Ny5Rg\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}],&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;duration&quot;:0,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}},{&quot;comm_msg_info&quot;:{&quot;id&quot;:1000000593,&quot;type&quot;:49,&quot;datetime&quot;:1542365024,&quot;fakeid&quot;:&quot;2397855421&quot;,&quot;status&quot;:2,&quot;content&quot;:&quot;&quot;},&quot;app_msg_ext_info&quot;:{&quot;title&quot;:&quot;‼️暖心福利，最高送您50GB‼️&quot;,&quot;digest&quot;:&quot;北京移动送好礼，参与活动，最高可得50GB！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226500,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710150&amp;amp;idx=1&amp;amp;sn=1a69a02468f0ad88ba14fd899b0f055d&amp;amp;chksm=bcbd94948bca1d824140daff4d47bebfe6d18a724881656637763e6dcc60bcb73fde3b77f7ad&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2FflowHeroNovember2018%2Findex.do&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=flowHeroNovember2018#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBVFFianfR7zDWd2RWREQ4ChnWKxdJL7DztdiaamDhUvccDicqDuMD1WhTO0R8MwAtsKyYsI2F2Fg1Jg\\/0?wx_fmt=jpeg&quot;,&quot;subtype&quot;:9,&quot;is_multi&quot;:1,&quot;multi_app_msg_item_list&quot;:[{&quot;title&quot;:&quot;流量包低至1元‼️最高赠送60GB&quot;,&quot;digest&quot;:&quot;2019年流量包1元起预售，赠送费用即刻返还，还可免费立享等额流量！！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226494,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710150&amp;amp;idx=2&amp;amp;sn=b9e6a690484fff068e2ab2aa8ce4a5c9&amp;amp;chksm=bcbd94948bca1d82f494ea5e6772a6d61a5a6764a60e632b9861314c0702d655fdba7c0d63a4&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;https:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2Fredirect%2FdispenseRequest.action&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=llbycfhd#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBVFFianfR7zDWd2RWREQ4Ch3t5ZXpBcw99YRicy9IrNQo9LEA48pqGHCNK0xbRnDrCcmwE8xsUB0NQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;限时福利，DIY你的专属名片！&quot;,&quot;digest&quot;:&quot;限时福利&nbsp;，1GB流量&amp;amp;和彩印免费领，先到先得哦~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226497,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710150&amp;amp;idx=3&amp;amp;sn=f50731260bd673f9f98824ac381e2ca6&amp;amp;chksm=bcbd94948bca1d8245be2f64b234400067dd01c1942ce1d8a5095b13138996fce5784a4229ff&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;https:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2Fredirect%2FdispenseRequest.action&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=hcyx#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBVFFianfR7zDWd2RWREQ4Chyjq9YNcZrkmX40TOplcIJ1C7UV9piazLOyUgqTRV8Ayk6InWurMAvIw\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;邀好友领流量，最高1.6GB！&quot;,&quot;digest&quot;:&quot;好东西要分享，邀请好友来手厅，最高1.6GB流量免费领！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226498,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710150&amp;amp;idx=4&amp;amp;sn=b7aa46794fb2ba00fd5402d98c57bc61&amp;amp;chksm=bcbd94948bca1d82c57bb8e88d8a04aefde940535777b035692a911386673c59b1155d9c98d5&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;https:\\/\\/app.10086.cn\\/df4eE0&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBVFFianfR7zDWd2RWREQ4Ch4uKHmEhj1LvJlGg96gRU3ibHHLgMe1cub9UabaVHoRRxbxx3AUCJlJw\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;【biu~】不得不看的急救小知识！（送500MB）&quot;,&quot;digest&quot;:&quot;平安诚可贵，生命价更高，学会应急自救，再活500年！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226459,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710150&amp;amp;idx=5&amp;amp;sn=29f541fbc10788853d26fd119f3ce0fa&amp;amp;chksm=bcbd94948bca1d82eb971f532552b8c2b7033c72af6ebc10b02c98b7d40772f6f0750961be80&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMC8v5icZCGQNAGa44LH6yjWhQ9CG9atcVrqDTFLJtw7SsMU9UU43qgyogU5bfqRG68H2zn79fG2aQw\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}],&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;duration&quot;:0,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}},{&quot;comm_msg_info&quot;:{&quot;id&quot;:1000000589,&quot;type&quot;:49,&quot;datetime&quot;:1541760461,&quot;fakeid&quot;:&quot;2397855421&quot;,&quot;status&quot;:2,&quot;content&quot;:&quot;&quot;},&quot;app_msg_ext_info&quot;:{&quot;title&quot;:&quot;海量免费流量，点我领取！&quot;,&quot;digest&quot;:&quot;你准备好了吗？戳进来，带你一起狂欢~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226414,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710064&amp;amp;idx=1&amp;amp;sn=ddbab8e8f238b4902d121fa4ab6f6cd7&amp;amp;chksm=bcbd95228bca1c34574f6dbd90ed80ca4299ea350a13e37f6edc50c2dd6fae9567a452231f7b&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2FflowHolidayActivity%2Findex.do&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=flowHolidayActivity#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBIRABQhY9NlBeHuTEslwMCIC9v1ic4Q4bs9lsNKafYjCgLLHlWB8m2IVibibnIyMyMKP5SR6cM8Cdxg\\/0?wx_fmt=jpeg&quot;,&quot;subtype&quot;:9,&quot;is_multi&quot;:1,&quot;multi_app_msg_item_list&quot;:[{&quot;title&quot;:&quot;开启流量之城，领取隐藏福利！&quot;,&quot;digest&quot;:&quot;玩游戏抢流量，流量之城你做主~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226399,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710064&amp;amp;idx=2&amp;amp;sn=a3c8a0e2beae8d28f67ff589939ae9f8&amp;amp;chksm=bcbd95228bca1c341b8afc51766b81aa5491de9da6689e109ec14dcf12ebe28cb98466d770de&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;https:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2Fredirect%2FdispenseRequest.action&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=llbycfhd#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBIRABQhY9NlBeHuTEslwMCicLnRZI9IN9FEHQ6LPNAv4wsfFVibOmmp6IPKSGxy5DhaoIc0ycGnwPQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;流量上上签‼️天天狂抽10GB‼️&quot;,&quot;digest&quot;:&quot;签到、翻牌，天天领免费流量~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226400,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710064&amp;amp;idx=3&amp;amp;sn=6906bdc44a0e517451ca1cf14420999d&amp;amp;chksm=bcbd95228bca1c340229fa63b225b452e375f11a7a2ad89530ad90afe5acfddf3e8ef756ce7b&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2FoctoberDoubleEleven2018%2Findex.do&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=octoberDoubleEleven2018#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBIRABQhY9NlBeHuTEslwMC4ubchjUdERPxO675FA5M0KwGn1SpNGS6IQiar6EwD0fLBpVcicIeqgvQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;移动营业厅送1GB，快来Pick！&quot;,&quot;digest&quot;:&quot;1GB流量、购机补贴、流量放心用卡、宽带等，一大波优惠来袭~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226401,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710064&amp;amp;idx=4&amp;amp;sn=35b6cf2da08223c698feb175601b74d8&amp;amp;chksm=bcbd95228bca1c3471f5fcb3c75e73b41f40b28cc6e5f1d3bb5fdd05534fc6aa7b61aa10aead&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBIRABQhY9NlBeHuTEslwMCH7vhBtXq2qBmRTicc78qf0P6zPRrqOhelazbzV7AeibFZ2O2DuibY1LmQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;最高1.5GB免费送，百分百中奖！&quot;,&quot;digest&quot;:&quot;手机、流量、话费......聚惠双11~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226402,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710064&amp;amp;idx=5&amp;amp;sn=af03a28f2ee46d905164081156ead449&amp;amp;chksm=bcbd95228bca1c347de0d0212ad27c35f12c58039308c2c6278e99b7660a0654df3eb7512ac1&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2Fredirect%2FdispenseRequest.action%3FisActivity%3Dtrue&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=dtenth18#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBIRABQhY9NlBeHuTEslwMCf31lVZeK9FOjibiboibibPicLvibMJIexn0n5oZXyTQmz6p0slKIiaowYTQSg\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;【biu~】我绝不承认这是我的11.11！（含500MB）&quot;,&quot;digest&quot;:&quot;你是这样过的一天吗？&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226407,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677710064&amp;amp;idx=6&amp;amp;sn=313b484a15ce4e34f2a4beb7679e7f37&amp;amp;chksm=bcbd95228bca1c349c9609fea53664d4b20874f0bb6b4d85c4c3295fcd6746b3c78458a2f71c&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBIRABQhY9NlBeHuTEslwMCBosHf6c8d8BjhMhPdmEKX45I6gqPibyiasJksPlaapicztfpb4TD8ITog\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}],&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;duration&quot;:0,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}},{&quot;comm_msg_info&quot;:{&quot;id&quot;:1000000555,&quot;type&quot;:49,&quot;datetime&quot;:1539771077,&quot;fakeid&quot;:&quot;2397855421&quot;,&quot;status&quot;:2,&quot;content&quot;:&quot;&quot;},&quot;app_msg_ext_info&quot;:{&quot;title&quot;:&quot;官宣‼️9.9GB抽2次‼️重阳送流量‼️&quot;,&quot;digest&quot;:&quot;重阳九九，流量人人有，豪送9.9GB！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226110,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709764&amp;amp;idx=1&amp;amp;sn=67940450a5dfc36f3d4513b9ddc9df31&amp;amp;chksm=bcbd92168bca1b0008a6e52acaa893abb07970e6f8265bb783b5955a1f734c88641d02b81710&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMDKJbBQFCeXia7j2twwPsQvF21DIeDUxBJJNgQvZ6fWHJCdvvQOKmBwMQ3zXmWwH5I2d5mW0iabbEZQ\\/0?wx_fmt=jpeg&quot;,&quot;subtype&quot;:9,&quot;is_multi&quot;:1,&quot;multi_app_msg_item_list&quot;:[{&quot;title&quot;:&quot;DIY重阳明信片，领1.5GB！&quot;,&quot;digest&quot;:&quot;制作专属你的重阳明信片，还可以领1.5GB流量大奖哦~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226080,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709764&amp;amp;idx=2&amp;amp;sn=824efe61d9cf7f0ee4231ae3940dfb0e&amp;amp;chksm=bcbd92168bca1b00d3a42539fe4f23d19c2a81b15535fa29f81979cee473832cfedb94bd3042&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAbVqDtbjTjwE7XAHCKsfTgH0nnqxErlqtLibHNzwJOFSEjGUGuInwicItAl3EwEVIPgWxibZknlHbQQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;10元5GB，还送腾讯视频会员哦~&quot;,&quot;digest&quot;:&quot;恭喜您被选中为“流量锦鲤”，10元5GB，还送腾讯视频会员哦~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226081,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709764&amp;amp;idx=3&amp;amp;sn=bca2aaa8207981ebca649c7fb1231ecb&amp;amp;chksm=bcbd92168bca1b00913953bc9d984314ad9f6871acfcf2ff7b366080eb81917f6548370a798c&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAbVqDtbjTjwE7XAHCKsfTguMgZmyE9CdUNuP9x6O8kGTKByHKibhiak3I4NCtHGpv6vkE1nEmCNSCQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;️️流量不够用？点我一招搞定！&quot;,&quot;digest&quot;:&quot;全国流量放心用，告别蹭WIFI的日子~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226108,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709764&amp;amp;idx=4&amp;amp;sn=44c8935f8c4ed5d523e28c1d5bb67348&amp;amp;chksm=bcbd92168bca1b00c90879774d1166de0155f15f095e9a03fdedcdd07cb17edd732a0ba10d6d&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMDKJbBQFCeXia7j2twwPsQvFZJsEYoJNoN6mibicM81gvUr6p3IaZscC9r86tfIpOYktHKvb4DGV445w\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;【biu~】你陪我长大，我陪你变老（送500MB）&quot;,&quot;digest&quot;:&quot;从前你保护我，今后我守护你~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226083,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709764&amp;amp;idx=5&amp;amp;sn=eb4159376c1c9498ac852f4aefbf89b2&amp;amp;chksm=bcbd92168bca1b00f854d571bf5ea6f07ec0715fd6fa6eeba71fc254c4f63302698bc5685492&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAbVqDtbjTjwE7XAHCKsfTgsFibBAiaHMHBKHIfR7X0mexBicGO5ibtsgUEgcV9iadckDstgaDgAJPaOzg\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}],&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;duration&quot;:0,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}},{&quot;comm_msg_info&quot;:{&quot;id&quot;:1000000553,&quot;type&quot;:49,&quot;datetime&quot;:1539338955,&quot;fakeid&quot;:&quot;2397855421&quot;,&quot;status&quot;:2,&quot;content&quot;:&quot;&quot;},&quot;app_msg_ext_info&quot;:{&quot;title&quot;:&quot;接令！最高领30GB、2000元话费！&quot;,&quot;digest&quot;:&quot;北京移动十月赠礼，参与活动，流量话费等你来拿！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226057,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709709&amp;amp;idx=1&amp;amp;sn=10836f79c76d23609b8bd5dd6090b03c&amp;amp;chksm=bcbd925f8bca1b49e60b90e233bd4e36e0d305792911dad0b710c5ce21087405a9e8a701fac1&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2FflowHeroOctober2018%2Findex.do&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=flowHeroOctober2018#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAfPRttFbEl1VswuwTcdSmXsTr3qcib8ULwxUgLyCJK7BmyIAhtH2BqrnaHISSHW1PJxiaQaFclpRQA\\/0?wx_fmt=jpeg&quot;,&quot;subtype&quot;:9,&quot;is_multi&quot;:1,&quot;multi_app_msg_item_list&quot;:[{&quot;title&quot;:&quot;送流量！送门票！速来！&quot;,&quot;digest&quot;:&quot;不就是流量吗？再送你60GB+40GB够不够~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226036,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709709&amp;amp;idx=2&amp;amp;sn=ba6842fa4d2b84ee7922df593bf77441&amp;amp;chksm=bcbd925f8bca1b49623ef90fba731849dde6fab0c77eb67514e50ffee775be4dfabba58c72a9&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBCN50buZjOs2SEWTqia1d2KpJFb4Vg6V4yiblDmetoicMgkOx53YgortTOkiaic8Z9bnUp4ibswLeJhfLw\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;【戳】你忙，我替你守护！&quot;,&quot;digest&quot;:&quot;和目智能摄像头，安全、便捷、智能，让你忙无牵挂，时刻更爱家！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226037,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709709&amp;amp;idx=3&amp;amp;sn=e316571c8a81c2d1d8a03bcbd3c04fe6&amp;amp;chksm=bcbd925f8bca1b49fde0a3c1ca0163fdbbb2a6bc8886136548b2a574e5ebbbdccba0e3f612f0&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBCN50buZjOs2SEWTqia1d2K9NfG9CicF2fMxdQ8VVxfa1qyt7LnU2lCOD9M7fvt1ib71JwgXGDQngAA\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;互联网时代，用数据说话！&quot;,&quot;digest&quot;:&quot;移动高速上网——互联网世界的高速公路！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226059,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709709&amp;amp;idx=4&amp;amp;sn=4e3e7f0d9af95d8c44ed07ed16def1fc&amp;amp;chksm=bcbd925f8bca1b49ab597ab0e8c5c6a543ea4a9d71b26f4fb2a21340123243336df967ec5ba0&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAfPRttFbEl1VswuwTcdSmXSsarBZZicOzm8fzichzicY7wcjtPxsicPmS47NR2L7OZjOPocmZPNV2hpQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;邀请好友赢好礼，最高1.6GB！&quot;,&quot;digest&quot;:&quot;.&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226060,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709709&amp;amp;idx=5&amp;amp;sn=c72eb06196084e581a55a5cbbb8f9c30&amp;amp;chksm=bcbd925f8bca1b49553dd2a86d38206e9e21a8c4aaf94b918cc22df9e4d2bae8da8349e7b8f0&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/sc.bj.chinamobile.com\\/activity\\/loading\\/loading.html?actname=friendstask&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAfPRttFbEl1VswuwTcdSmXxwjYl2JWVvJGBrsSrtQdWxwgDnvibMSiba5SAEbyaxTWAWDAX0sByy0Q\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;【biu~】常被误解的几大职业，快来看看有没有你的~(含500MB)&quot;,&quot;digest&quot;:&quot;每份职业都有各自的艰辛，你的职业被人误解过吗？&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530226040,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709709&amp;amp;idx=6&amp;amp;sn=3be41d9186b780224df50a39f6ca8568&amp;amp;chksm=bcbd925f8bca1b49caecacc6663db2cdea637b4133af7c3a7eba98fc654817bba1143bc4d33a&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBCN50buZjOs2SEWTqia1d2K1KOTUynEXRmY4DvnmLgFMCojc0l8dvgK8pcrqwQJWk2uhmPGd7OYvg\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}],&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;duration&quot;:0,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}},{&quot;comm_msg_info&quot;:{&quot;id&quot;:1000000551,&quot;type&quot;:49,&quot;datetime&quot;:1538285611,&quot;fakeid&quot;:&quot;2397855421&quot;,&quot;status&quot;:2,&quot;content&quot;:&quot;&quot;},&quot;app_msg_ext_info&quot;:{&quot;title&quot;:&quot;欢度国庆，免费送你1GB全国流量！&quot;,&quot;digest&quot;:&quot;祖国母亲生日快乐！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225968,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709631&amp;amp;idx=1&amp;amp;sn=dddaf5ee8bf5940daa1c65d96d8ccf88&amp;amp;chksm=bcbd92ed8bca1bfb6593b4f158351e1f49660665388adc030e2bca2765a0999d2610a82442b0&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMD0xLSQFic86mztYkKM5owytBfKsZlLH0wWmoxlfFnABNib8c9AibxLQ66rILp48UIzastjCVp0PvpCQ\\/0?wx_fmt=jpeg&quot;,&quot;subtype&quot;:9,&quot;is_multi&quot;:1,&quot;multi_app_msg_item_list&quot;:[{&quot;title&quot;:&quot;【戳】把家装进手机，守护0距离&quot;,&quot;digest&quot;:&quot;和目摄像头，预存话费优惠购！智能生活，有声有色。&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225970,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709631&amp;amp;idx=2&amp;amp;sn=d091795ca6a655f3a68751b58741a8b0&amp;amp;chksm=bcbd92ed8bca1bfbf070b25b10e6eea39b7da43fe9efe48ba7807d69731adae6e981e3bdf068&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMD0xLSQFic86mztYkKM5owytDkJgTN2LEDzzRE7oyvsFo6ZLCZIgsdOuBQiaXfufnZcC8gssejrj1JQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;视频流量免费领，30GB等你拿！&quot;,&quot;digest&quot;:&quot;嗨享定向流量，乐度美好生活&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225971,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709631&amp;amp;idx=3&amp;amp;sn=8891cc6e12cd23061ff70e43fd4d1206&amp;amp;chksm=bcbd92ed8bca1bfbc95db4a93630ad9a112407ba928a1259e5496251f81cff68a738248a964c&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMD0xLSQFic86mztYkKM5owyt2DR2TrDAe5XWgJrnakbvP0ISaBCHammcnj7pB4PB93iaPwicvictKhXFw\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;穿越时空，查看您的专属账单！&quot;,&quot;digest&quot;:&quot;“准确、及时、清晰”，全球通俱乐部带您了解“账单攻略”！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225972,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709631&amp;amp;idx=4&amp;amp;sn=4ff3150f9a071fb641afbd890b7a12a4&amp;amp;chksm=bcbd92ed8bca1bfb11bea91555ed6eca141174c41481f3384b5a9ad90690b6b27ff250542fae&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMD0xLSQFic86mztYkKM5owytWaJht4ldMluLRQpN0BReibF2dbfiawYnAmYAfWN4mUWUuxlHPLCB7POQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;抢流量，瓜分100000000MB！&quot;,&quot;digest&quot;:&quot;1亿MB流量大放送，等您来抢！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225973,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709631&amp;amp;idx=5&amp;amp;sn=52ecd46594c5a96c58a691c89f51307c&amp;amp;chksm=bcbd92ed8bca1bfbafff2507147c7f34a59955287b98fe634fe5aba092a9342b31f9de049c8a&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMD0xLSQFic86mztYkKM5owytHFe1YFbg9SIW5kRibfmsuBJwEiaKUzE6PEicKpyD459vBPAxlqNhgAkUw\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;【biu~】解密小长假真相（内含500MB）&quot;,&quot;digest&quot;:&quot;国庆狂欢，送你500MB流量！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225916,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709631&amp;amp;idx=6&amp;amp;sn=9626bfcb72d89b2b2240ccf53ee97e5a&amp;amp;chksm=bcbd92ed8bca1bfb4007a0f3233aab96ca5ca5c43d6a12ae1215ef6e58a6924faeb5720b613d&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBDHebKEL50AOXO1icLQ2t1F6H8IZdvby6H0qA6PqagWlZJN6owbNibQD0JEdrrWSiaJkicVF2pDfWEvg\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}],&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;duration&quot;:0,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}},{&quot;comm_msg_info&quot;:{&quot;id&quot;:1000000544,&quot;type&quot;:49,&quot;datetime&quot;:1537520715,&quot;fakeid&quot;:&quot;2397855421&quot;,&quot;status&quot;:2,&quot;content&quot;:&quot;&quot;},&quot;app_msg_ext_info&quot;:{&quot;title&quot;:&quot;【中秋送送送】最高3GB全国流量！&quot;,&quot;digest&quot;:&quot;中秋节快乐！灵魂画手画月亮，最高赢取3GB流量！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225872,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709534&amp;amp;idx=1&amp;amp;sn=3635ebfdaee2e96a46d2465dbdf268e8&amp;amp;chksm=bcbd930c8bca1a1a7dd365551c3ce07f9563ccc7ec0fde7b2ec593f083bb2e3af647b4695086&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2FmidAutumn2018%2Findex.do&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=midAutumn2018#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAYfM0leMLOrCM6lzf7SppkKM7kZbtIEGfxHOTIHChY0UIoHJ9ujPsPMl5icTAB3xp86RpoQUzC4eA\\/0?wx_fmt=jpeg&quot;,&quot;subtype&quot;:9,&quot;is_multi&quot;:1,&quot;multi_app_msg_item_list&quot;:[{&quot;title&quot;:&quot;免费流量人人有，最高30GB！&quot;,&quot;digest&quot;:&quot;北京移动邀你来传流量英雄令，30GB流量、2000元话费等你领！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225875,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709534&amp;amp;idx=2&amp;amp;sn=6baa1a320d1f9ac75711f4509aa111d2&amp;amp;chksm=bcbd930c8bca1a1a414acb70be0cc1d0f2fe39691eb3ff8b3f8bf8df3b0f3fc42225f5db2638&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2FflowHero2018%2Findex.do&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=flowHero2018#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAYfM0leMLOrCM6lzf7SppkyRh4j3sGLiaqHzRrsNVe9NZCdoSu1SX5MFsamXRnhicV99SZAgFicZEiag\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;境外流量十元起，出游不用愁！&quot;,&quot;digest&quot;:&quot;境外流量任性玩，每天仅需10元，随时随地自由畅享！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225876,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709534&amp;amp;idx=3&amp;amp;sn=f1e22fac83076dc97b8cb55609978f69&amp;amp;chksm=bcbd930c8bca1a1a38b7d1ab25d8a8f69b5265c6ad5fc73ccd297e94f9b9fe39db00cdc91f26&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;https:\\/\\/service.bj.10086.cn\\/m\\/gmseckill\\/showLxsIndex.action?saleId=0000004&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAYfM0leMLOrCM6lzf7Sppk38csicCpaXQAEqLjJDlJ2GnN2C3nwdSG3aut8kCPubJ3icqGw9vvcAYQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;叮！你有60GB假期补贴待领取！&quot;,&quot;digest&quot;:&quot;嗨包免费送，假期肆意嗨！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225877,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709534&amp;amp;idx=4&amp;amp;sn=68560a5a0853321d46d0cb7f7526fba3&amp;amp;chksm=bcbd930c8bca1a1a6606f2db5e597230873dcba1562d39960d36b7b1fc742ab56bea27baa0c7&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAYfM0leMLOrCM6lzf7Sppkw7vcGAic54tXkcLQsnQF8BKu7Xj7B8xTta5f26ibGZ3DTdo1ZibbfBZZA\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;校招ING|青春不悔，相约移动！&quot;,&quot;digest&quot;:&quot;校园招聘火热报名中，机会转瞬即逝，行动吧！少年！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225878,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709534&amp;amp;idx=5&amp;amp;sn=6c9942f9623efe00a9117656e7b59aa8&amp;amp;chksm=bcbd930c8bca1a1adda4ddd78f602d520eb69a4da95dd192b208afad1a5c0d2c6dcd1a2237ec&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;https:\\/\\/company.dajie.com\\/nb\\/vsite\\/chMobile_2019\\/index.html?from=singlemessage&amp;amp;isappinstalled=0&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMAYfM0leMLOrCM6lzf7SppkI7G5JJVkSiawIM3YYyqEkGzuwoe1pvtKtFjGltZTUrW62zgYZtRXEmw\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;【biu】奇葩月饼大赛-抢500MB&quot;,&quot;digest&quot;:&quot;吃月饼大赛来袭，来晒一下你吃过的奇葩月饼吧~&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225885,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709534&amp;amp;idx=6&amp;amp;sn=237bb83597165b752a4b39df24b4155d&amp;amp;chksm=bcbd930c8bca1a1a863360d4d6ac8ce30aad0be6a4fe169727ca69867836a5da6bb7076ddf62&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMCEBlNWiahceE4UrvD32okgYLE2IqpANbo1miaTJlHhITqOc0tJf4ghiav5KfulWO9QicianP1ib68GYlew\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}],&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;duration&quot;:0,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}},{&quot;comm_msg_info&quot;:{&quot;id&quot;:1000000518,&quot;type&quot;:49,&quot;datetime&quot;:1536318494,&quot;fakeid&quot;:&quot;2397855421&quot;,&quot;status&quot;:2,&quot;content&quot;:&quot;&quot;},&quot;app_msg_ext_info&quot;:{&quot;title&quot;:&quot;【最高1GB】助力公益送福彩体验券！&quot;,&quot;digest&quot;:&quot;北京移动联手中国福彩邀您一起玩游戏献爱心！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225691,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709358&amp;amp;idx=1&amp;amp;sn=cd6ec6d67a64d92f73f79513d6929d97&amp;amp;chksm=bcbd93fc8bca1aeaea949d5129866d80ce618af0f66252d61abde5b653db72e3a99aef46f330&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2FlotteryActivity2018%2Findex.do&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=lotteryActivity2018#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBTlxGBDKNDB7RWbmR8hGwTFzLadVj7QdfNJmSiaiahicWmy4Eb9K3Rjw00aQsibxPD8W0zpnfdFm9qKQ\\/0?wx_fmt=jpeg&quot;,&quot;subtype&quot;:9,&quot;is_multi&quot;:1,&quot;multi_app_msg_item_list&quot;:[{&quot;title&quot;:&quot;【送】2000MB扫码领取！&quot;,&quot;digest&quot;:&quot;全民扫流量霸气归来，2000MB轻松拿！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225706,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709358&amp;amp;idx=2&amp;amp;sn=ea25780bfd6e9ad2aa07340ec90c0a65&amp;amp;chksm=bcbd93fc8bca1aea53b5573499fd7d87e3d84e10ebdf94c0b49b575d48a92eb0de779abd86bb&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;http:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2FoldDaiNew201807%2Findex.do&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=oldDaiNew201807#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBTlxGBDKNDB7RWbmR8hGwTKO6DlPveribZexxnTzJZw33p3bA72JUHPYJYFPXibE0ySS4D1wR0Z43g\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;30GB免费送2个月，速领！&quot;,&quot;digest&quot;:&quot;30GB免费2个月+15元百度外卖会员，任性玩肆意嗨！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225707,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709358&amp;amp;idx=3&amp;amp;sn=d58f9dd4594b187acc068835e2e2d41c&amp;amp;chksm=bcbd93fc8bca1aea73921fb06bdd0bfb505868bfbcab7af0022fb66770523f016c1c1d53fdb0&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;https:\\/\\/open.weixin.qq.com\\/connect\\/oauth2\\/authorize?appid=wx7858699aca01b75f&amp;amp;redirect_uri=http%3A%2F%2Fserviceimg.bmcc.com.cn%2Fweixin%2Fredirect%2FdispenseRequest.action&amp;amp;response_type=code&amp;amp;scope=snsapi_base&amp;amp;state=hbh5#wechat_redirect&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBTlxGBDKNDB7RWbmR8hGwTVAl82LiaGTKBBmAUShEmLUhiaGSIAHibVkjaoeWsomGiajhk0NccgkmbbQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;9重好礼+1GB流量=10全10美！&quot;,&quot;digest&quot;:&quot;开学季，流量风暴来袭！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225708,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709358&amp;amp;idx=4&amp;amp;sn=2c4e48d926b2db9bf434cd2956fb915b&amp;amp;chksm=bcbd93fc8bca1aeadbee3da23c9e8b9623db45b6e4d80046027a3010e178e04733d4d4ad1713&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBTlxGBDKNDB7RWbmR8hGwTNmUgxLWTSdaf3QXh5wYUOwFypibFw3J0icnarLHEUWVf8ibkckb4qtj6g\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;那些你不得不知道的热点！&quot;,&quot;digest&quot;:&quot;惊人，原来手机不离手的人在做这些事情！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225709,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709358&amp;amp;idx=5&amp;amp;sn=a5509c08260a4e64cb320735bbe6e9e5&amp;amp;chksm=bcbd93fc8bca1aea08a52703152b36e4de0ff6816a9d2e6eb09baa604cbf8f4e12ce83b701ed&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBTlxGBDKNDB7RWbmR8hGwTXd6f5JEAy9vFMoCYgbqDG1Xk22Wu0mONPTyicictVicjFJ3N0SDrqhBnw\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0},{&quot;title&quot;:&quot;【biu~】老师喊你领月饼啦！&quot;,&quot;digest&quot;:&quot;确认过眼神，他们就是我老师的样子！&quot;,&quot;content&quot;:&quot;&quot;,&quot;fileid&quot;:530225677,&quot;content_url&quot;:&quot;http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5Nzg1NTQyMQ==&amp;amp;mid=2677709358&amp;amp;idx=6&amp;amp;sn=9dd93d28400694a35937834a4c977bcb&amp;amp;chksm=bcbd93fc8bca1aead7c65f1b824c81239e7dd3eafc181ff28299c210d03384fb6567665a4b92&amp;amp;scene=27#wechat_redirect&quot;,&quot;source_url&quot;:&quot;&quot;,&quot;cover&quot;:&quot;http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/2fzib31icCSMBTlxGBDKNDB7RWbmR8hGwT6t5kvJ1O5EzLdr6Uj1ooW9fW6YrgLXFZIeFFia0vabZ7GsINxzEzNoQ\\/0?wx_fmt=jpeg&quot;,&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;duration&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}],&quot;author&quot;:&quot;&quot;,&quot;copyright_stat&quot;:100,&quot;duration&quot;:0,&quot;del_flag&quot;:1,&quot;item_show_type&quot;:0,&quot;audio_fileid&quot;:0,&quot;play_url&quot;:&quot;&quot;,&quot;malicious_title_reason_id&quot;:0,&quot;malicious_content_type&quot;:0}}]}';
        if(!!window.__initCatch){
        window.__initCatch({
            idkey : 29711,
            startKey : 60,
            badjsId: 47,
            
            reportOpt : {
                username : username,
            }
        });
    }

    seajs.use("appmsg/profile.js");
</script>

    </body>
    <script nonce="" type="text/javascript">document.addEventListener("touchstart", function() {},false);</script>
</html>

