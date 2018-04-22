// loanDetail
$(function () {
    $.asset["slideInfoIndex"] = 999999;
    $.asset["slideMaskIndex"] = $.asset["slideInfoIndex"]-1;
    $.asset["ruleParams"]={}; // 节点属性参数
    $.asset["ruleParamsPath"]={}; // 连线属性
    $.asset["ruleOrPath"]=0;
    $.asset["allKeys"]={};
    $.asset["ruleProps"] = {
            "ruleCond_NUMBER":{"==":"等于","&gt;":"大于","&lt;":"小于","&gt;=":"大于等于","&lt;=":"小于等于","!=":"不等于"},
            "ruleCond_STRING":{"==":"等于","!=":"不等于"},
           
        };
    // 初始化侧边栏
    $.ruleFlowProps.init();

    function changeRuleName(obj){
        var e=$(this).parents(".ruleStrategy").eq(0);
        $('[name="ruleTitleName"]',e).value(obj);
    }
    var dbclick_r;
    var dbclick_scr;
});
(function($){
    $.ruleFlowProps = $.fn.ruleFlowProps={
        init:function(paramsJson){ // paramsJson参数json {'toggleCallback':callback}
            if(!paramsJson) paramsJson={};
            $.asset["lastGroupAdd"] = 0;
            $.asset["lastFieldAdd"] = 0;
            $.asset["minActionInterval"] = 500;
            //初始化字典
            $.ruleFlowProps.initDict();
            // 初始化基本事件
            $.ruleFlowProps.initEvents(paramsJson);
          //初始化dom操作 包括（添加条件，添加规则等）
            $.ruleFlowProps.initDomOperate();
         },
         //初始化字典
         initDict: function () {
             $.get("queryDepGroRole.do?method=queryDepGroRole", function (result) {
                 var u = "";
                 var O = "";
                 var t="";
                 var s=eval('(' + result + ')');
                 $.each(s.orgInfo, function (i, item) {              
                     u += " <div class='mho_form_group'><label> <input type='checkbox' name='orgInfo' value='" + item.orgOid + "'>" + item.orgName + "</label></div>";
                 });
                 $(".mho_orgInfo").append(u);
                 $.each(s.roleInfo, function (i, item) {
                    O += " <div class='mho_form_group'><label> <input type='checkbox' name='roleInfo' value='" + item.roleId + "'>" + item.roleName + "</label></div>";
                 });
                 $(".mho_roleInfo").append(O);
                 $.each(s.groupInfo, function (i, item) {
                     t += " <div class='mho_form_group'><label> <input type='checkbox' name='groupInfo' value='" + item.wpId + "'>" + item.wpName + "</label></div>";
                  });
                  $(".mho_groupInfo").append(t);
             });
             
             $.get("queryKeyWord.do?method=queryKeyWord", function (result) {
                 var u = "";
                 var s=eval('(' + result + ')');
                 $.each(s.keyWord, function (i, item) {
                     u += "<option data-type="+item.kwType+" value=" + item.kwCode + ">" + item.kwDescription + "</option>";
                    
                 });
                 $.asset["allKeys"]=u; // 结束节点属性参数
                
             });
             
         },
        initEvents:function(paramsJson){
            // 当窗口变化时调用重置方法
            $(window).resize(function () {
                $.ruleFlowProps.resetHg();
            });
            $.ruleFlowProps.resetHg();

            $.asset["slideScroll"] = false;
            $(".rulePropDetailSlide .slideInfoContent").scroll(function(){ // 滚动，删除下拉框
                $.asset["slideScroll"] = true;
                $(document).trigger("click");
            });

            var $detail = $(".rulePropDetailSlide");
            $detail.css("z-index",$.asset["slideInfoIndex"]) // 设置层优先级
                .on("click",".slideControler",function(){ // 侧边栏切换
                    $.ruleFlowProps.slideToggle(paramsJson['toggleCallback']||null);
                })
                .on("click",".movePoint",function(event){ // 拖拽模块静止toggle
                    return false;
                });
        
        },
        	hideFieldPanel:function(){
            $(".fbarBack.addDropdownPanel .dropdownPanel.active").each(function(i){
                $(this).removeClass("active").html("");
            });
        },
        resetHg:function(){
            var winh = $(window).height();
            var sTop = $(document).scrollTop();
            var navHg = 55;
            if (sTop <= navHg) {
                $(".rulePropDetailSlide").css({"top": (navHg - sTop) + "px","bottom": "auto","height": (winh - navHg - 2 )+"px"});
            } else {
                $(".rulePropDetailSlide").css({"top": "auto","bottom": "2px","height": (winh - 3)+"px"});
            }
        },
        slideToggle:function(callback,oper){
            if(callback) (callback)();
            oper = $.trim(oper);
            var visible = $(".rulePropDetailSlide").outerWidth()==0?false:true;
            if(oper=="show"){
                if(!visible) $.ruleFlowProps.slideLeftShow();
            }else{
                if(visible) $.ruleFlowProps.slideLeftHide();
            }
        },
        slideLeftHide:function () {
            $(".rulePropDetailSlide").animate({
                "width": "0"
            }, 250, function(){
                $(".rulePropDetailSlide").css("border-left","0");
            });
            $("body").css("overflow","auto"); // body 溢出显示
            $(".slideMask").remove();
        },
        slideLeftShow:function (speed, callback) {
            $(".rulePropDetailSlide")
                .css("border-left","1px solid #ddd")
                .animate({
                    "width": "800px"
                }, 400, function(){
                    // 显示后调整侧边栏上滚动距离
                    $(".slideInfoContent").scrollTop(0);
                });
/*            $("body").css("overflow","hidden").append("<div class='slideMask' onclick=\"$('#slideInfoDetail .slideControler').trigger('click');\" style='z-index:"+$.asset["slideMaskIndex"]+";'></div>");
*/        },
		initPageDataOfPath:function(id,_path,r){
			 $('[name="rectId"]').val(id);
	            dbclick_r=r;
	            dbclick_scr=_path;	
	            if($.asset["ruleParamsPath"][id])
	            {
	            	var e = $(".ruleGroup");
                    $("#ruleList").empty();
                    var rlist=$.asset["ruleParamsPath"][id];
                    if(rlist)
                    {
                            var rule=rlist;
                            var c = $("#cdtnTemplates .ruleStrategyPath").clone();
                            var d = $("#ruleList", e);
                            d.append(c);
                            var $lastRuleChild=$("#ruleList").children(":last");
                            //初始化风险决策字典
                            $('.rulesConds [data-name="rulesCondsOperator"]', $lastRuleChild).val(rule.logicOperator);
                            $('[name="ruleName"]', $lastRuleChild).val(rule.name);
                            $('[name="rueNo"]', $lastRuleChild).val(rule.rueNo);
                            $('[name="ruleType"]', $lastRuleChild).val(rule.ruleType);
                            
                            if(rule.conds)
                            {
                                for(var j=0;j<rule.conds.length;j++)
                                {
                                    var cond=rule.conds[j];
                                    if("&&"==cond.logicOperator&&cond.conds)
                                    {
                                        for(var k=0;k<cond.conds.length;k++)
                                        {
                                            var $lastCondChild;
                                            if(k==0)
                                            {
                                                var d = $(".panel-conds-ul", $lastRuleChild);
                                                var c = $("#cdtnTemplates .conds-group-item-OfAnd").clone();
                                                d.append(c);
                                                $lastCondChild= $(".panel-conds-ul li:last-child  .conds-group-list li:last-child",$lastRuleChild);
                                                $('[name="customLogicOperator"]', $lastCondChild).val(cond.logicOperator);

                                            }
                                            else
                                            {
                                                var d = $(".panel-conds-ul li:last-child .conds-group-list", $lastRuleChild);
                                                var c = $("#cdtnTemplates .conds-group-item-OfAnd .conds-group-list>li").clone();
                                                d.append(c);
                                                $lastCondChild= $(".panel-conds-ul li:last-child  .conds-group-list li:last-child",$lastRuleChild);
                                            }

                                            var condValue=cond.conds[k];
                                            $("select[name='condProperty']", $lastCondChild).empty();
                                            $('[name="condProperty"]', $lastCondChild).append($.asset["allKeys"]);
                                            $('[name="condProperty"]', $lastCondChild).val(condValue.property);
                                            $.ruleFlowProps.handlers.initOperatorValue($lastCondChild,"init");
                                            $('[name="condOperator"]', $lastCondChild).val(condValue.operator);
                                            $('[name="condValue"]', $lastCondChild).val(condValue.value);

                                        }
                                    }
                                    else if("||"==cond.logicOperator&&cond.conds) {
                                        for (var k = 0; k < cond.conds.length; k++) {
                                            var $lastCondChild;
                                            if (k == 0) {
                                                var d = $(".panel-conds-ul", $lastRuleChild);
                                                var c = $("#cdtnTemplates .conds-group-item-OfOr").clone();
                                                d.append(c);
                                                $lastCondChild = $(".panel-conds-ul li:last-child  .conds-group-list li:last-child", $lastRuleChild);
                                                $('[name="customLogicOperator"]', $lastCondChild).val(cond.logicOperator);
                                            }
                                            else {
                                                var d = $(".panel-conds-ul li:last-child .conds-group-list", $lastRuleChild);
                                                var c = $("#cdtnTemplates .conds-group-item-OfOr .conds-group-list>li").clone();
                                                d.append(c);
                                                $lastCondChild = $(".panel-conds-ul li:last-child  .conds-group-list li:last-child", $lastRuleChild);
                                            }

                                            var condValue = cond.conds[k];
                                            $("select[name='condProperty']", $lastCondChild).empty();
                                            $('[name="condProperty"]', $lastCondChild).append($.asset["allKeys"]);
                                            $('[name="condProperty"]', $lastCondChild).val(condValue.property);
                                            $.ruleFlowProps.handlers.initOperatorValue($lastCondChild,"init");
                                            $('[name="condOperator"]', $lastCondChild).val(condValue.operator);
                                            $('[name="condValue"]', $lastCondChild).val(condValue.value);

                                        }
                                    }
                                }
                            }
                    }
				  }
				else{
				    var e = $(".ruleGroup");
				    $("#ruleList").empty();
				    $('[name="activityName"]').val("");
				    var c = $("#cdtnTemplates .ruleStrategyPath").clone();
				    var d = $("#ruleList", e);
				    d.append(c);
				}
	            $.asset["ruleOrPath"]=1;
				$.ruleFlowProps.slideToggle(null,"show"); 
		},
        //初始化页面数据
        initPageData:function(id,_rect,r){
            $('[name="rectId"]').val(id);
            dbclick_r=r;
            dbclick_scr=_rect;
            if($.asset["ruleParams"][id])
            {
                var e = $(".ruleGroup");
                $("#ruleList").empty();
                var c = $("#cdtnTemplates .ruleStrategy").clone();
                var d = $("#ruleList", e);
                d.append(c);
                $('[name="activityName"]',d).val($.asset["ruleParams"][id].activityName);
                $('[name="activityNo"]',d).val($.asset["ruleParams"][id].activityNo);
                $('[name="activityType"]',d).val($.asset["ruleParams"][id].activityType);
                $('[name="backWay"]',d).val($.asset["ruleParams"][id].backWay);
                $('[name="content"]',d).val($.asset["ruleParams"][id].content);
                $('[name="allowSynergy"]',d).val($.asset["ruleParams"][id].allowSynergy);
                $('[name="allowEnd"]',d).val($.asset["ruleParams"][id].allowEnd);
                $('[name="allowCountersign"]',d).val($.asset["ruleParams"][id].allowCountersign);
                $('[name="allowCopy"]',d).val($.asset["ruleParams"][id].allowCopy);
                $('[name="allowRetroactive"]',d).val($.asset["ruleParams"][id].allowRetroactive);
                
                
                $('[name="handlers"]',d).val($.asset["ruleParams"][id].handlers);
                var orgInfo=$.asset["ruleParams"][id].orgInfo;
                var groupInfo=$.asset["ruleParams"][id].groupInfo;
                var roleInfo=$.asset["ruleParams"][id].roleInfo;
                for(var i=0;i<orgInfo.length;i++){  
                    $("input[name='orgInfo']",d).each(function(){  
                        if($(this).val()==orgInfo[i]){  
                            $(this).attr("checked","checked");  
                        }  
                    })  
                }  
                for(var i=0;i<groupInfo.length;i++){  
                    $("input[name='groupInfo']",d).each(function(){  
                        if($(this).val()==groupInfo[i]){  
                            $(this).attr("checked","checked");  
                        }  
                    })  
                }  
                for(var i=0;i<roleInfo.length;i++){  
                    $("input[name='roleInfo']",d).each(function(){  
                        if($(this).val()==roleInfo[i]){  
                            $(this).attr("checked","checked");  
                        }  
                    })  
                }  
                if($.asset["ruleParams"][id].isMessage)
                	{
                	$('[name="isMessage"]',d).attr("checked","checked"); ;
                	}
                
                $('[name="isMessageTemp"]').val($.asset["ruleParams"][id].isMessageTemp);
                if($.asset["ruleParams"][id].isMessageNext)
            	{
            	$('[name="isMessageNext"]',d).attr("checked","checked"); ;
            	}
               
                $('[name="isMessageTempNext"]').val($.asset["ruleParams"][id].isMessageTempNext);
                if($.asset["ruleParams"][id].isMessageHistory)
            	{
            	$('[name="isMessageHistory"]',d).attr("checked","checked"); ;
            	}
               
               
                $('[name="isMessageTempHistory"]').val($.asset["ruleParams"][id].isMessageTempHistory);
                
                if($.asset["ruleParams"][id].notification)
            	{
            	$('[name="notification"]',d).attr("checked","checked"); ;
            	}
            }
            else{
                var e = $(".ruleGroup");
                $("#ruleList").empty();
                $('[name="activityName"]').val("");
                var c = $("#cdtnTemplates .ruleStrategy").clone();
                var d = $("#ruleList", e);
                d.append(c);
                $('[name="isMessage"]',d).attr('checked',false)
                 $('[name="isMessageNext"]',d).attr('checked',false)
                  $('[name="isMessageHistory"]',d).attr('checked',false)
                   $('[name="notification"]',d).attr('checked',false)
            }
            $.ruleFlowProps.slideToggle(null,"show"); 
            $('#ruleList .ruleStrategy .qxControl .mho_accordion_body .mho_tabs .mho_tabs_nav li').on('click', function() {
        		debugger;
        		var $tabs = $(this).closest('.mho_tabs');
        		$(this).siblings('li').removeClass('mho_active');
        		$(this).addClass('mho_active');
        		$tabs.find('.mho_tab_panel').removeClass('mho_active');
        		$tabs.find('.mho_tab_panel').eq($(this).index()).addClass('mho_active');
        	});
            $.asset["ruleOrPath"]=2;
        },
        initDomOperate:function () {
            var a = $("#slideInfoDetail");
            a.on("click",".ruleStratrgySave",//暂存节点信息
                    function () {
                    var rList=$("#ruleList");
                    var rectId = $('[name="rectId"]').val();
                    var rules = {};
                   if(2==$.asset["ruleOrPath"]){
	                    $.ruleFlowProps.handlers.addElementByCond(rectId, rList, rules).done(function(f) {
	                    	MessageBox.alert('提示',"成功");
	                    }).fail(function(f) {
	                    	MessageBox.alert('提示', f)
	                    }).always(function() {
	                    
	                    })
                   }
                   else if(1==$.asset["ruleOrPath"])
                	   {
                	   $.ruleFlowProps.handlers.addElementByCondPath(rectId, rList, rules).done(function(f) {
	                    	MessageBox.alert('提示',"成功");
	                    }).fail(function(f) {
	                    	MessageBox.alert('提示', f)
	                    }).always(function() {
	                    
	                    })
                	   }
                }).on("click", ".addCustomGroupOfAnd",//添加与条件
                function(event) {
                    event.stopPropagation();
                    var e = $(this).parents(".panel-conds-cdsm").eq(0);
                    var d = $(".panel-conds-ul", e);
                    var c = $("#cdtnTemplates .conds-group-item-OfAnd").clone();
                    d.append(c);
                    var $li=$li=$("li:last-child  .conds-group-list li:last-child",d);
                    $('[name="condProperty"]', $li).append($.asset["allKeys"]);
                    $.ruleFlowProps.handlers.initOperatorValue(d);//根据条件值初始化操作值
                    $.ruleFlowProps.handlers.initOperatorChange();//条件值改变时，进行的操作
                }).on("click", ".addCustomGroupOfOr",//添加或条件
                function(event) {
                    event.stopPropagation();
                    var e = $(this).parents(".panel-conds-cdsm").eq(0);
                    var d = $(".panel-conds-ul", e);
                    var c = $("#cdtnTemplates .conds-group-item-OfOr").clone();
                    d.append(c);
                    var $li=$li=$("li:last-child  .conds-group-list li:last-child",d);
                    $('[name="condProperty"]', $li).append($.asset["allKeys"]);
                    $.ruleFlowProps.handlers.initOperatorValue(d);//根据条件值初始化操作值
                    $.ruleFlowProps.handlers.initOperatorChange();//条件值改变时，进行的操作
                }).on("click", ".addCustItemOfAnd",//添加与单条件
                function(event) {
                    event.stopPropagation();
                    var d = $(this).parents(".conds-group-list").eq(0);
                    var c = $("#cdtnTemplates .conds-group-item-OfAnd .conds-group-list>li").clone();
                    d.append(c);
                    var $li=$("li:last-child",d);
                    $('[name="condProperty"]', $li).append($.asset["allKeys"]);
                    $.ruleFlowProps.handlers.initOperatorValue(d,"single");//根据条件值初始化操作值
                    $.ruleFlowProps.handlers.initOperatorChange();//条件值改变时，进行的操作
                }).on("click", ".addCustItemOfOr",//添加或单条件
                function(event) {
                    event.stopPropagation();
                    var d = $(this).parents(".conds-group-list").eq(0);
                    var c = $("#cdtnTemplates .conds-group-item-OfOr .conds-group-list>li").clone();
                    d.append(c);
                    var $li=$("li:last-child",d);
                    $('[name="condProperty"]', $li).append($.asset["allKeys"]);
                    $.ruleFlowProps.handlers.initOperatorValue(d,"single");//根据条件值初始化操作值
                    $.ruleFlowProps.handlers.initOperatorChange();//条件值改变时，进行的操作
                }).on("click", ".deleteCustItem",//删除条件
                function(event) {
                    event.stopPropagation();
                    var c = $(this).parents(".conds-group-item-delete").eq(0);
                    var e = $(this).parents("li").eq(0);
                    if (c.length) {
                        var d = e.index();
                        var f = e.siblings().length;
                        if (d == 0 && f == 0) {
                            c.remove()
                        } else {
                            var s=e.parents(".panel-conds-cdsm").eq(0);
                            e.remove()
                            if(s.find("li").length==0)
                            {
                                $(".conds-group-stragy",s).css("display","none");
                            }
                        }
                    } else {
                        var s=e.parents(".panel-conds-cdsm").eq(0);
                        e.remove()
                        if(s.find("li").length==0)
                        {
                            $(".conds-group-stragy",s).css("display","none");
                        }
                    }
                })

        },
        handlers: {
        	 //初始化条件选项内容
            initOperatorValue:function (b,c) {
                var $li;
                if(c!=null&&"single"==c)
                {
                    $li=$("li:last-child",b);
                }
                else if(c!=null&&"init"==c)
                {
                    $li=b;
                }
                else{
                    $li=$("li:last-child  .conds-group-list li:last-child",b);
                }
                var dataType =  $('[name="condProperty"]', $li).find("option:selected").attr("data-type");
                $.ruleFlowProps.handlers.initOperatorValuebydataType(dataType,$li);


            },
          //根据属性类型改变条件选项值
            initOperatorValuebydataType:function (dataType,$li) {
                function optionGenerator(dict){
                    var o = "";
                    for(var temp in dict){
                        o+= "<option value='"+temp+"'>"+dict[temp]+"</option>";
                    }
                    return o;
                }
                $("select[name='condOperator']",$li).empty();
                if(dataType=="DOUBLE"||dataType=="INT"){

                    $("select[name='condOperator']",$li).append(optionGenerator($.asset["ruleProps"]["ruleCond_NUMBER"]));

                }
               else  if(dataType=="STRING"){

                    $("select[name='condOperator']",$li).append(optionGenerator($.asset["ruleProps"]["ruleCond_STRING"]));

                }
            },
          //条件属性改变时所进行的操作（条件为‘闭区间范围’）
            initOperatorChange:function () {
                $('[name="condProperty"]').change(function () {
                    var $li=$(this).parents("li").eq(0);
                    var dataType=$(this).find("option:selected").attr("data-type");
                    $.ruleFlowProps.handlers.initOperatorValuebydataType(dataType,$li);
                })
            },
            //删除数组指定元素
            removeByValue:  function (arr, val) {
                for (var i = 0; i < arr.length; i++) {
                    if (arr[i] == val) {
                        arr.splice(i, 1);
                        break;
                    }
                 }
            },
            addElementByCondPath:function (rectId, rList, rules) {
            	 var f = $.Deferred();
                 var t = $.ruleFlowProps.processParams.checkParams(rList);
               
                     var rule=t;
                     if(!$.trim(rule.name))
                     {
                         f.reject("请输入规则名称");
                         return f.promise()
                     }
                     if(!$.trim(rule.rueNo))
                     {
                         f.reject("请输入规则序号");
                         return f.promise()
                     }
                     if(!$.trim(rule.ruleType))
                     {
                         f.reject("请选择规则类型");
                         return f.promise()
                     }
                     if(!rule.conds.length){
                         f.reject("请添加规则名称为'"+$.trim(rule.name)+"'的条件");
                         return f.promise()
                     }
                     for(var m=0;m<rule.conds.length;m++)
                     {
                          if(rule.conds[m].conds)
                          {
                              for(var j=0;j<rule.conds[m].conds.length;j++)
                              {
                                  var ruleCond=rule.conds[m].conds[j];
                                  if (!$.trim(ruleCond["property"])) {
                                      f.reject("请选择属性");
                                      return f.promise()
                                  }
                                  if (!$.trim(ruleCond["operator"])) {
                                      f.reject("请选择条件");
                                      return f.promise()
                                  }
                                  if (!$.trim(ruleCond["value"])) {
                                      f.reject("请输入条件值");
                                      return f.promise()
                                  }
                                  if (ruleCond["rightValueType"] == "input" && ruleCond["propertyDataType"] == "INT") {
                                      var N = /^-?\d+$/;
                                      if (!N.test(ruleCond["value"])) {
                                          f.reject("条件值'" + ruleCond["propertyStr"] + "'需要为整数");
                                          return f.promise()
                                      }
                                  } else {
                                      if (ruleCond["rightValueType"] == "input" && ruleCond["propertyDataType"] == "DOUBLE") {
                                          var N = /^-?\d+(\.?\d+)?$/;
                                          if (!N.test(ruleCond["value"])) {
                                              f.reject("条件值'" + ruleCond["propertyStr"] + "'需要为数值");
                                              return f.promise()
                                          }
                                      }
                                  }
                              }
                          }
                     }
                     $.asset["ruleParamsPath"][rectId]=t;
                 $(dbclick_r).trigger('textchange', [t.name, dbclick_scr]);
                 f.resolve("操作成功");
                 return f.promise()
             },
            //添加规则节点内容
            addElementByCond:function (rectId, rList, rules) {
                var f = $.Deferred();
                var ruleList = {};
                ruleList.activityName=$.trim($('[name="activityName"]',rList).val());
                ruleList.activityNo=$.trim($('[name="activityNo"]',rList).val());
                ruleList.activityType=$.trim($('[name="activityType"]',rList).val());
              
                ruleList.backWay=$.trim($('[name="backWay"]',rList).val());
                ruleList.content=$.trim($('[name="content"]',rList).val());
                
                ruleList.allowSynergy=$.trim($('[name="allowSynergy"]',rList).val());
                ruleList.allowEnd=$.trim($('[name="allowEnd"]',rList).val());
              
                
                ruleList.allowCountersign=$.trim($('[name="allowCountersign"]',rList).val());
                ruleList.allowCopy=$.trim($('[name="allowCopy"]',rList).val());
                ruleList.allowRetroactive=$.trim($('[name="allowRetroactive"]',rList).val());
                
                ruleList.handlers=$.trim($('[name="handlers"]',rList).val());
               
                var orgInfo =[]; 
                $("input[name='orgInfo']:checked",rList).each(function(){ 
                	orgInfo.push($(this).val()); 
                }); 
                ruleList.orgInfo=orgInfo;
               
                var groupInfo =[]; 
                $("input[name='groupInfo']:checked",rList).each(function(){ 
                	groupInfo.push($(this).val()); 
                }); 
                ruleList.groupInfo=groupInfo;
              
                var roleInfo =[]; 
                $("input[name='roleInfo']:checked",rList).each(function(){ 
                	roleInfo.push($(this).val()); 
                }); 
                ruleList.roleInfo=roleInfo;
                
                ruleList.isMessage=$("input[name='isMessage']:checked",rList).size()>0?$("input[name='isMessage']:checked",rList)[0].checked:false;
                ruleList.isMessageTemp=$.trim($('[name="isMessageTemp"]',rList).val());
                
                ruleList.isMessageNext=$("input[name='isMessageNext']:checked",rList).size()>0?$("input[name='isMessageNext']:checked",rList)[0].checked:false;
                ruleList.isMessageTempNext=$.trim($('[name="isMessageTempNext"]',rList).val());
                ruleList.isMessageHistory=$("input[name='isMessageHistory']:checked",rList).size()>0?$("input[name='isMessageHistory']:checked",rList)[0].checked:false;
                
                
                ruleList.isMessageTempHistory=$.trim($('[name="isMessageTempHistory"]',rList).val());
                ruleList.notification=$("input[name='notification']:checked",rList).size()>0?$("input[name='notification']:checked",rList)[0].checked:false;
                var rule=ruleList;
                if(!$.trim(rule.activityName))
                {
                    f.reject("请输入活动名称");
                    return f.promise()
                }
                if(!$.trim(rule.activityNo))
                {
                    f.reject("请输入活动序号");
                    return f.promise()
                }
                if(!$.trim(rule.activityType))
                {
                    f.reject("请选择活动类型");
                    return f.promise()
                }
                if(!$.trim(rule.backWay))
                {
                    f.reject("请选择退回方式");
                    return f.promise()
                }
                $.asset["ruleParams"][rectId]=ruleList;
                $(dbclick_r).trigger('textchange', [ruleList.activityName, dbclick_scr]);
                f.resolve("操作成功");
                return f.promise()
            },
        },
        processParams:{
            //节点属性操作（）
            checkParams:function (rList) {
            	 var rule = {};
            	 var domEle=rList;
                 rule.logicOperator = $('.rulesConds [data-name="rulesCondsOperator"]', domEle).val() || "";
                 rule.name=$.trim($('[name="ruleName"]', domEle).val() || "");
                 rule.rueNo=$.trim($('[name="rueNo"]', domEle).val() || "");
                 rule.ruleType=$.trim($('[name="ruleType"]', domEle).val());
                 rule.conds = [];
                 $(".panel-conds-ul>li", domEle).each(function(d, f) {
                     var h = $(f);
                     function c(i) {
                         var j = {};
                         j.property = $.trim($('[name="condProperty"]', i).val());
                         j.propertyStr = $.trim($('[name="condProperty"]', i).find("option:selected").text());
                         j.operator = $.trim($('[name="condOperator"]', i).val());
                         j.propertyDataType = $.trim($('[name="condProperty"]', i).find("option:selected").attr("data-type"));
                         j.rightValueType = "input";
                         j.value = $.trim($('[name="condValue"]', i).val());
                         return j
                     }
                     var e = {};
                     if (h.hasClass("conds-group-item-OfOr")) {
                         e.logicOperator = $('[name="customLogicOperator"]', h).val();
                         e.type = "context";

                     } else if (h.hasClass("conds-group-item-OfAnd")) {
                         e.logicOperator = $('[name="customLogicOperator"]', h).val();
                         e.type = "context";
                         }

                     e.conds = [];
                     $(".conds-group-list>li", h).each(function(i, j) {
                         e.conds.push(c(j))
                     });
                     rule.conds.push(e)

                 });
                
                return rule;
            }
        }
    };
})(jQuery);


