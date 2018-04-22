(function($){
var myflow = $.myflow;

$.extend(true,myflow.config.rect,{
	attr : {
	r : 8,
	fill : '#fff',
	stroke : '#149de4',
	"stroke-width" : 2
   },
    ruleProps:{
        logicOperator: "&&",
        type: "context",
        rules: []
    },
    onDbclick:function(id,_rect,r){
        $.ruleFlowProps.initPageData(id,_rect,r);
    },

});
$.extend(true,myflow.config.path,{
    onDbclick:function(id,_path,r){
        $.ruleFlowProps.initPageDataOfPath(id,_path,r);
    },

});
$.extend(true,myflow.config.props.props,{
	name : {name:'name', label:'名称', value:'新建流程', editor:function(){return new myflow.editors.inputEditor();}},
	key : {name:'key', label:'标识', value:'', editor:function(){return new myflow.editors.inputEditor();}},
	desc : {name:'desc', label:'描述', value:'', editor:function(){return new myflow.editors.inputEditor();}}
});

$.extend(true,myflow.config.tools.states,{
	start : {
				showType: 'image',
				type : 'start',
				name : {text:'<<start>>'},
				text : {text:'开始'},
				img : {src : 'component/workflow/configuration/drawing/img/48/start_event_empty.png',width : 48, height:48},
				attr : {width:50 ,heigth:50 },
				},
			end : {showType: 'image',type : 'end',
				name : {text:'<<end>>'},
				text : {text:'结束'},
				img : {src : 'component/workflow/configuration/drawing/img/48/end_event_terminate.png',width : 48, height:48},
				attr : {width:50 ,heigth:50 },
				},
			'end-cancel' : {showType: 'image',type : 'end-cancel',
				name : {text:'<<end-cancel>>'},
				text : {text:'取消'},
				img : {src : 'component/workflow/configuration/drawing/img/48/end_event_cancel.png',width : 48, height:48},
				attr : {width:50 ,heigth:50 },
				},
			'end-error' : {showType: 'image',type : 'end-error',
				name : {text:'<<end-error>>'},
				text : {text:'错误'},
				img : {src : 'component/workflow/configuration/drawing/img/48/end_event_error.png',width : 48, height:48},
				attr : {width:50 ,heigth:50 },
				},
			state : {showType: 'text',type : 'state',
				name : {text:'<<state>>'},
				text : {text:'活动'},
				img : {src : 'component/workflow/configuration/drawing/img/48/task_empty.png',width : 48, height:48},
				},
			fork : {showType: 'image',type : 'fork',
				name : {text:'<<fork>>'},
				text : {text:'分支'},
				img : {src : 'component/workflow/configuration/drawing/img/48/gateway_parallel.png',width :48, height:48},
				attr : {width:50 ,heigth:50 },
				},
			join : {showType: 'image',type : 'join',
				name : {text:'<<join>>'},
				text : {text:'合并'},
				img : {src : 'component/workflow/configuration/drawing/img/48/gateway_parallel.png',width :48, height:48},
				attr : {width:50 ,heigth:50 },
				},
			task : {showType: 'text',type : 'task',
				name : {text:'<<task>>'},
				text : {text:'任务'},
				img : {src : 'component/workflow/configuration/drawing/img/48/task_empty.png',width :48, height:48},
				}
});
})(jQuery);