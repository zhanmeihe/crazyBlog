var cxWin;
var cxForm;
var addWin;
var addForm;
var modWin;
var modForm;
var addOrMod;
var showUrl,addUrl;

$(document).ready(init);

//初始化方法

function init(){
	sm=new Ext.grid.CheckboxSelectionModel();

	/******************************grid配置开始*********************************************/
		//定义store
	 gridStore = new Ext.data.Store({ 
			remoteSort:true,//远程排序，默认false，为本地排序
			proxy:new Ext.data.HttpProxy({
				url:ctx+"/dynasearch/ExtQuery/getData.do?queryid=wzxx&WZLX="+WZLX
			}),
			autoLoad:false,
			reader:new Ext.qy.cx.JsonReader({  
				fields:['WZID','WZLX','WZBT','DJRMC','DJSJ','FJURL']  
			})
		}
	);
		//定义分页工具栏
	 pageBar = new Ext.PagingToolbar({
			id:'pageBar',
			store:gridStore,  
			pageSize:30, 
	     	displayInfo:true,  
	     	displayMsg:'显示第{0}条到{1}条记录，一共{2}条' 
	});
	
	 grid = new Ext.grid.GridPanel({
		region:"center",
		id:'gridPanel',
		renderTo:"gridDiv",
		width:document.documentElement.clientWidth-20,	
		height:document.documentElement.clientHeight-90,
		store:gridStore,
		autoScroll:true,
		frame:false,
		sm:sm,
		bbar:pageBar,//将分页工具栏放置在底部，放在顶部配置名称为tbar
		colModel: new Ext.grid.ColumnModel({
			columns:[ 
				new Ext.grid.RowNumberer({}),
				sm,
				{header:'编号',hidden:false, dataIndex:'WZID', menuDisabled:true,align:'left',width:80},
				{header:'标题',hidden:false, dataIndex:'WZBT', menuDisabled:true,align:'left',width:400,renderer:function(value,meta,record){
						//return "<a href='"+record.data["FJURL"]+"'>"+value+"</a>";
						//'"+record.data["FJURL"].split(",")[0]+"'
						return "<a href=\"javascript:downFile('"+record.data["FJURL"].split(",")[0]+"')\">"+value+"</a>";
				}},
				{header:'登记人',hidden:false, dataIndex:'DJRMC', menuDisabled:true,align:'left',width:100},
				{header:'登记时间',hidden:false, dataIndex:'DJSJ', menuDisabled:true,align:'center',width:150}
			]
		}),
		listeners:{
			rowdblclick:function(grid){
				var record = grid.getSelectionModel().getSelected();
			}
		},
		viewConfig: 
		{forceFit: false},
		stripeRows:true,
		loadMask:true,//store加载时是否形成遮罩，默认false
		autoScroll:true
	});	
	 
	
	 cxForm = new Ext.form.FormPanel({
			width:600,
			id:"cxformPanel",
			autoHeight:true,
			border:false,
			frame:false,
			layout:"form",
			autoScroll:true,
			style:"padding:5px",
			items:[
				new Ext.Panel({
					layout:"column",
					anchor:"100%",
					border:false,
					defaults:{
						border:false					
					},
					items:[
					{
						columnWidth:1/2,
						layout:"form",
						labelWidth:90,
						labelAlign:"right",
						defaults:{
							anchor:"100%"
						},
						items:[
							new Ext.form.TextField({
								fieldLabel:"编号",
								name:"WZID"
							})
						]
					},
					{
						columnWidth:1/2,
						layout:"form",
						labelWidth:90,
						labelAlign:"right",					
						defaults:{
							anchor:"100%"
						},
						items:[
							new Ext.form.TextField({
								fieldLabel:"标题",
								name:"WZBT"
							})
						]
					}					
				]
			})
		],
		buttonAlign:"right",
		buttons:[
			{
				text:"查询",
				handler:cx
			},
			{
				text:"重置",
				handler:function(){
					cxForm.form.reset();
				}
			}
			
		],
		keys:[{ //处理键盘回车事件     
         key:Ext.EventObject.ENTER,     
         fn:cx,     
         scope:this    
   	  }]
	});	
	
	cxWin = new Ext.Window({
		width:600,
		resizable:false,
		autoHeight:true,
		title:"查询条件",
		layout:"fit",
		bodyStyle:"background-color:#fff",
		closeAction:"hide",
		buttonAlign:"center",
		items:[
			cxForm
		]
	});
	
	addForm = new Ext.form.FormPanel({
			width:600,
			id:"addformPanel",
			autoHeight:true,
			border:false,
			frame:false,
			layout:"form",
			labelAlign:"right",
			autoScroll:true,
			fileUpload: true,
        	url: 'uploder.jsp',
			//url:ctx+"/ueditor/jsp/fileUp.jsp",
			style:"padding:5px",
			items:[
							new Ext.form.TextField({
								fieldLabel:"标题",
								name:"WZBT",
								id:"WZBT",
								anchor:'85%'
							}),
							new Ext.form.TextField({
								fieldLabel:"附件",
								name:"FJURL",
								id:"FJURL",
								inputType:"file",
								anchor:'85%'
							}),{html:'<input id="resetForm" type="reset" style="display:none;">',border:false}
		],
		buttonAlign:"center",
		buttons:[
			{
				text:"保存",
				handler:uploadFile
			},
			{
				text:"取消",
				handler:function(){
					addWin.hide();
				}
			}
			
		],
		keys:[{ //处理键盘回车事件     
         key:Ext.EventObject.ENTER,     
         fn:uploadFile,     
         scope:this    
   	  }]
	});
	addWin = new Ext.Window({
		width:600,
		resizable:false,
		autoHeight:true,
		title:"内容",
		layout:"fit",
		bodyStyle:"background-color:#fff",
		closeAction:"hide",
		buttonAlign:"center",
		items:[
			addForm
		]
	});
	modForm = new Ext.form.FormPanel({
			width:600,
			id:"modformPanel",
			autoHeight:true,
			border:false,
			frame:false,
			layout:"form",
			labelAlign:"right",
			autoScroll:true,
			style:"padding:5px",
			items:[
							new Ext.form.TextField({
								fieldLabel:"标题",
								name:"WZBT_MOD",
								id:"WZBT_MOD",
								anchor:'85%'
							}),
							new Ext.form.Hidden({
								name:"WZID",
								id:"WZID"
							})	
		],
		buttonAlign:"center",
		buttons:[
			{
				text:"保存",
				handler:uploadFile
			},
			{
				text:"取消",
				handler:function(){
					modWin.hide();
				}
			}
			
		],
		keys:[{ //处理键盘回车事件     
         key:Ext.EventObject.ENTER,     
         fn:uploadFile,     
         scope:this    
   	  }]
	});
	modWin = new Ext.Window({
		width:600,
		resizable:false,
		autoHeight:true,
		title:"内容",
		layout:"fit",
		bodyStyle:"background-color:#fff",
		closeAction:"hide",
		buttonAlign:"center",
		items:[
			modForm
		]
	});
	Ext.EventManager.onWindowResize(function(){
		grid.setWidth(document.documentElement.clientWidth-20);
		grid.setHeight(document.documentElement.clientHeight-90);
	});
	loadStore('', 'gridPanel', 'pageBar');
}

function showWin(){
	cxWin.show();
	cxForm.getForm().reset();
}

function cx(){
    cxWin.hide();
	var s = cxForm.getForm().getValues();
	loadStore(s, 'gridPanel', 'pageBar');
}
function add(){
	addOrMod="add";
	addWin.show();
	addForm.getForm().reset();
	
}
function xg(){
	var select=sm.getSelections();
	if(select.length!=1){
		alert("请选择一条记录进行修改");
		return;
	}
	if(select.length==1){
		modForm.getForm().reset();
		Ext.getCmp("WZID").setValue(select[0].data["WZID"]);
		Ext.getCmp("WZBT_MOD").setValue(select[0].data["WZBT"]);
		addOrMod="mod";
		modWin.show();
  }else{
	  alert("请选择一项修改");
  }
	
}
function del(){
	var flag=0
	var select=sm.getSelections();
	if(select.length==0){
		alert( "请选择您要删除的数据");
		return;
	}
	if(confirm("确定删除吗？")){
		 for(var j=0;j<select.length;j++){
		 	 var WZID=select[j].data['WZID']
			 url = "common.Common.commonDelete";
			 var result = doService(url,"sqlid","wzxx","WZID",WZID);
			 if(result){
				//alert( "删除成功");
				flag++;
			 }
		}
	}
	if(flag==select.length){
		//cxForm.form.reset();
		alert( "删除成功");
		loadStore(null, 'gridPanel', 'pageBar');
	}
}
function uploadFile(){
	if(addOrMod=="add"){
		if($("#WZBT").val()==""||$("#WZBT").val()==null){
		alert("请填写标题内容！");
		return;
		}
		if($("#FJURL").val()==""||$("#FJURL").val()==null){
			alert("请上传附件！");
			return;
		}
		
		addForm.getForm().submit({
					waitMsg:"load...",
                    success: function(form, action){
                        if(action.result.state=="SUCCESS"){
                        		var returnObj=postService("common.Common.commonInsert", { "sqlid":"wzxx","WZLX":WZLX,"WZBT":$("#WZBT").val(),"SFFJWZ":"Y","FJURL":action.result.url+","+action.result.original,"USERID":userId,"ORGID":orgId}) ;
                        	  if(returnObj!=null){
					    	   		if(returnObj.success){
							  			alert("添加成功！");
							  			hideAddWin();
							   		}
					    	   }
					    	   else{
							   		alert("添加失败！");
							   }
                        }else{
                        	alert("添加失败！");
                        }
                    },
                    failure: function(){
                        Ext.Msg.alert('提示信息', '添加失败');
                    }
                });
    }else if(addOrMod=="mod"){
    	if($("#WZBT_MOD").val()==""||$("#WZBT_MOD").val()==null){
			alert("请填写标题内容！");
			return;
		}
    	var returnObj=postService("common.Common.commonUpdate", { "sqlid":"wzxx","WZID":$("#WZID").val(),"WZBT":$("#WZBT_MOD").val(),"USERID":userId,"ORGID":orgId}) ;
                        	  if(returnObj!=null){
					    	   		if(returnObj.success){
							  			alert("修改成功！");
							  			hideModWin();
							   		}
					    	   }
					    	   else{
							   		alert("修改失败！");
							   }
    }
}
function hideAddWin(){
	addWin.hide();
	$("#resetForm").click();
	addForm.getForm().reset();
	modForm.getForm().reset();
	loadStore("", 'gridPanel', 'pageBar');
}
function hideModWin(){
	modWin.hide();
	addForm.getForm().reset();
	modForm.getForm().reset();
	loadStore("", 'gridPanel', 'pageBar');
}
function downFile(value){
	window.open(ctx+"/ueditor/jsp/"+value);
}