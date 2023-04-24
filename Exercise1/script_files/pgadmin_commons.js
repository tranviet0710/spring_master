"use strict";(self.webpackChunk=self.webpackChunk||[]).push([[196],{34439:(e,t,r)=>{var n,i;r(82772),r(69826),r(41539);var o,a=r(73819),s=(o=r(96486))&&o.__esModule?o:{default:o};n=[r(91669),r(55112),r(61329),r(67507)],void 0===(i=function(e,t,r){var n=t.Browser=t.Browser||{};return n.Collection||(n.Collection=function(){},s.default.extend(n.Collection,s.default.clone(n.Node),{Init:function(){this.node_initialized||(this.node_initialized=!0,t.Browser.add_menus([{name:"refresh",node:this.type,module:this,applies:["object","context"],callback:"refresh",priority:2,label:e("Refresh")}]),t.unsupported_nodes&&-1==s.default.indexOf(t.unsupported_nodes,this.type)&&("database"==this.type&&this.allowConn||"database"!=this.type)&&(t.Browser.add_menus([{name:"show_query_tool",node:this.type,module:this,applies:["context"],callback:"show_query_tool",priority:998,label:e("Query Tool")}]),t.Browser.add_menus([{name:"search_objects",node:this.type,module:this,applies:["context"],callback:"show_search_objects",priority:997,label:e("Search Objects...")}]),t.enable_psql&&t.Browser.add_menus([{name:"show_psql_tool",node:this.type,module:this,applies:["context"],callback:"show_psql_tool",priority:998,label:e("PSQL Tool")}])))},hasId:!1,is_collection:!0,collection_node:!0,hasCollectiveStatistics:!0,canDrop:!0,canDropCascade:!0,selectParentNodeOnDelete:!1,showProperties:function(e,t,r){var i=r.$container.find(".obj_properties").first();(0,a.getPanelView)(n.tree,i[0],n,r._type)},generate_url:function(e,i){var o={properties:"obj",children:"nodes",drop:"obj"},a=this,s=n.tree.getTreeNodeHierarchy(e),l=i in o?o[i]:i;return r.generate_url(t.Browser.URL,s,l,a.node,(function(e,t){return t!=a.type}))},show_query_tool:function(){t.Tools.SQLEditor&&t.Tools.SQLEditor.showQueryTool("",t.Browser.tree.selected())},show_search_objects:function(){t.Tools.SearchObjects&&t.Tools.SearchObjects.show_search_objects("",t.Browser.tree.selected())},show_psql_tool:function(e){var t=e||{},r=n.tree,i=t.item||r.selected(),o=i?r.itemData(i):void 0;n.psql.psql_tool(o,i,!0)}})),n.Collection}.apply(t,n))||(e.exports=i)},25260:(e,t,r)=>{r(69070),Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var n=o(r(18237)),i=o(r(55112));function o(e){return e&&e.__esModule?e:{default:e}}var a=i.default.Browser=i.default.Browser||{};a.Events=new n.default;var s=a;t.default=s},14497:(e,t,r)=>{var n,i;r(68309),r(32564),r(24812);var o,a=(o=r(96486))&&o.__esModule?o:{default:o};n=[r(55112),r(19755),r(35816)],void 0===(i=function(e,t){var r=e.Browser=e.Browser||{},n=window.wcDocker,i=window.wcIFrame;return e.Browser.Frame=function(e){a.default.extend(this,a.default.pick(e,["name","title","width","height","showTitle","isCloseable","isPrivate","url","icon","onCreate","isLayoutMember","isRenamable"]))},a.default.extend(e.Browser.Frame.prototype,{name:"",title:"",width:300,height:600,showTitle:!0,isClosable:!0,isRenamable:!1,isPrivate:!1,isLayoutMember:!1,url:"",icon:"",panel:null,frame:null,onCreate:null,load:function(e){var o=this;o.panel||e.registerPanelType(this.name,{title:o.title,isPrivate:o.isPrivate,isLayoutMember:o.isLayoutMember,onCreate:function(e){var s;e.initSize(o.width,o.height),null===(s=e.showTitle)||void 0===s||s||e.title(!1),e.icon(o.icon),e.closeable(!!o.isCloseable),e.renamable(o.isRenamable);var l=t('<div style="position:absolute;top:0 !important;width:100%;height:100%;display:table;z-index:0;">');e.layout().addItem(l),o.panel=e;var d=new i(l,e);e.frameData={pgAdminName:o.name,frameInitialized:!1,embeddedFrame:d},""!=o.url&&"about:blank"!=o.url?setTimeout((function(){d.openURL(o.url),e.frameData.frameInitialized=!0,r.Events.trigger("pgadmin-browser:frame:urlloaded:"+o.name,d,o.url,self)}),50):(d.openURL("about:blank"),e.frameData.frameInitialized=!0,r.Events.trigger("pgadmin-browser:frame:urlloaded:"+o.name,d,o.url,self)),o.events&&a.default.isObject(o.events)&&a.default.each(o.events,(function(t,r){t&&a.default.isFunction(t)&&e.on(r,t)})),a.default.each([n.EVENT.UPDATED,n.EVENT.VISIBILITY_CHANGED,n.EVENT.BEGIN_DOCK,n.EVENT.END_DOCK,n.EVENT.GAIN_FOCUS,n.EVENT.LOST_FOCUS,n.EVENT.CLOSED,n.EVENT.BUTTON,n.EVENT.ATTACHED,n.EVENT.DETACHED,n.EVENT.MOVE_STARTED,n.EVENT.MOVE_ENDED,n.EVENT.MOVED,n.EVENT.RESIZE_STARTED,n.EVENT.RESIZE_ENDED,n.EVENT.RESIZED,n.EVENT.SCROLLED],(function(t){e.on(t,o.eventFunc.bind(e,t))})),o.onCreate&&a.default.isFunction(o.onCreate)&&o.onCreate.apply(o,[e,d])}})},eventFunc:function(e){var t=this.frameData.pgAdminName;try{r.Events.trigger("pgadmin-browser:frame",e,this,arguments),r.Events.trigger("pgadmin-browser:frame:"+e,this,arguments),t&&(r.Events.trigger("pgadmin-browser:frame-"+t,e,this,arguments),r.Events.trigger("pgadmin-browser:frame-"+t+":"+e,this,arguments))}catch(e){console.warn(e.stack||e)}}}),e.Browser.Frame}.apply(t,n))||(e.exports=i)},67507:(e,t,r)=>{var n,i;function o(e){return o="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e},o(e)}r(47042),r(68309),r(91038),r(78783),r(74916),r(82526),r(41817),r(32165),r(79753),r(96649),r(96078),r(9653),r(69070),r(47941),r(57327),r(38880),r(89554),r(54747),r(49337),r(33321),r(24812),r(66992),r(41539),r(33948),r(82772),r(32564),r(26699),r(32023),r(92222),r(69826),r(3843),r(83710);var a=r(92705),s=c(r(55958)),l=c(r(96486)),d=c(r(2832));function c(e){return e&&e.__esModule?e:{default:e}}function p(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function u(e,t,r){return(t=function(e){var t=function(e,t){if("object"!==o(e)||null===e)return e;var r=e[Symbol.toPrimitive];if(void 0!==r){var n=r.call(e,t||"default");if("object"!==o(n))return n;throw new TypeError("@@toPrimitive must return a primitive value.")}return("string"===t?String:Number)(e)}(e,"string");return"symbol"===o(t)?t:String(t)}(t))in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function f(e,t){var r="undefined"!=typeof Symbol&&e[Symbol.iterator]||e["@@iterator"];if(!r){if(Array.isArray(e)||(r=function(e,t){if(!e)return;if("string"==typeof e)return h(e,t);var r=Object.prototype.toString.call(e).slice(8,-1);"Object"===r&&e.constructor&&(r=e.constructor.name);if("Map"===r||"Set"===r)return Array.from(e);if("Arguments"===r||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(r))return h(e,t)}(e))||t&&e&&"number"==typeof e.length){r&&(e=r);var n=0,i=function(){};return{s:i,n:function(){return n>=e.length?{done:!0}:{done:!1,value:e[n++]}},e:function(e){throw e},f:i}}throw new TypeError("Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}var o,a=!0,s=!1;return{s:function(){r=r.call(e)},n:function(){var e=r.next();return a=e.done,e},e:function(e){s=!0,o=e},f:function(){try{a||null==r.return||r.return()}finally{if(s)throw o}}}}function h(e,t){(null==t||t>e.length)&&(t=e.length);for(var r=0,n=new Array(t);r<t;r++)n[r]=e[r];return n}n=[r(91669),r(55112),r(61329),r(44092),r(7027),r(25260)],void 0===(i=function(e,t,r,n){var i=window.wcDocker,o=t.Browser=t.Browser||{};return o.Node?o.Node:(o.Nodes=o.Nodes||{},o.Node=function(){},o.Node.extend=function(e,t){var r,n=this;if(r=function(){return n.apply(this,arguments)},l.default.extend(r,n,l.default.omit(e,"callbacks")),r.callbacks=l.default.extend({},n.callbacks,e.callbacks),null!=t&&!t)return r;var i,o,a=f(l.default.keys(r.callbacks));try{for(a.s();!(i=a.n()).done;){var s=i.value;"function"==typeof r.callbacks[o=s]&&(r.callbacks[o]=r.callbacks[o].bind(r))}}catch(e){a.e(e)}finally{a.f()}return r.Init.apply(r),this.Init.apply(r),r},l.default.extend(t.Browser.Node,{type:void 0,label:"",sqlAlterHelp:"",sqlCreateHelp:"",dialogHelp:"",epasHelp:!1,title:function(e,t){return e.label+(t?" - "+t.label:"")},hasId:!0,Init:function(){var r=this;if(!r.node_initialized){if(r.node_initialized=!0,t.Browser.add_menus([{name:"refresh",node:r.type,module:r,applies:["object","context"],callback:"refresh",priority:2,label:e("Refresh..."),enable:!0}]),r.canEdit&&t.Browser.add_menus([{name:"show_obj_properties",node:r.type,module:r,applies:["object","context"],callback:"show_obj_properties",priority:999,label:e("Properties..."),data:{action:"edit"},enable:l.default.isFunction(r.canEdit)?function(){return!!r.canEdit.apply(r,arguments)}:!!r.canEdit}]),r.canDrop&&(t.Browser.add_menus([{name:"delete_object",node:r.type,module:r,applies:["object","context"],callback:"delete_obj",priority:r.dropPriority,label:r.dropAsRemove?e("Remove %s",r.label):e("Delete/Drop"),data:{url:"drop",data_disabled:e("The selected tree node does not support this option.")},enable:l.default.isFunction(r.canDrop)?function(){return!!r.canDrop.apply(r,arguments)}:!!r.canDrop}]),r.canDropCascade&&t.Browser.add_menus([{name:"delete_object_cascade",node:r.type,module:r,applies:["object","context"],callback:"delete_obj",priority:3,label:e("Drop Cascade"),data:{url:"delete"},enable:l.default.isFunction(r.canDropCascade)?function(){return r.canDropCascade.apply(r,arguments)}:!!r.canDropCascade}])),-1==l.default.indexOf(t.unsupported_nodes,r.type)){var n=function(e){return!("database"!=(null==e?void 0:e._type)||null==e||!e.allowConn)||"database"!=(null==e?void 0:e._type)};t.Browser.add_menus([{name:"show_query_tool",node:r.type,module:r,applies:["context"],callback:"show_query_tool",priority:998,label:e("Query Tool"),enable:n}]),t.Browser.add_menus([{name:"search_objects",node:r.type,module:t.Tools.SearchObjects,applies:["context"],callback:"show_search_objects",priority:997,label:e("Search Objects..."),icon:"fa fa-search",enable:n}]),t.enable_psql&&t.Browser.add_menus([{name:"show_psql_tool",node:this.type,module:this,applies:["context"],callback:"show_psql_tool",priority:998,label:e("PSQL Tool")}])}r.hasScriptTypes&&l.default.isArray(r.hasScriptTypes)&&r.hasScriptTypes.length>0&&l.default.each(r.hasScriptTypes,(function(n){var i=e("%s Script",n.toUpperCase());n=n.toLowerCase(),t.Browser.add_menus([{name:"show_script_"+n,node:r.type,module:r,applies:["object","context"],callback:"show_script",priority:4,label:i,category:e("Scripts"),data:{script:n,data_disabled:e("The selected tree node does not support this option.")},enable:r.check_user_permission}])}))}},check_user_permission:function(e,t,r){if("server_group"==e._type||"server"==e._type)return!1;if("database"==e._type&&!e.allowConn)return!1;var n=o.tree.getTreeNodeHierarchy(t);return-1==l.default.indexOf(["create","insert","update","delete"],r.script)||(!("role"!=e.type||!n.server.user.can_create_role)||!!(n.server&&(n.server.user.is_superuser||n.server.user.can_create_db)||n.schema&&n.schema.can_create))},addUtilityPanel:function(e,t,r){var n=window.document.body,i=document.createElement("div"),a=r||o.docker;n.insertBefore(i,n.firstChild);var s=screen.width<700?.95*screen.width:.5*screen.width,d=screen.height<500?.95*screen.height:.4*screen.height;l.default.isUndefined(e)||l.default.isNull(e)||(s=e),l.default.isUndefined(t)||l.default.isNull(t)||(d=t);var c=(n.offsetWidth-s)/2,p=(n.offsetHeight-d)/4,u=a.addPanel("utility_props",window.wcDocker.DOCK.FLOAT,void 0,{w:s,h:d,x:c,y:p});return setTimeout((function(){u.moveable(!1)}),0),n.removeChild(i),u},registerDockerPanel:function(e,t,r){var n=e||o.docker,i=n.findPanels(t);i&&1==i.length||(i=new o.Panel(function(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?p(Object(r),!0).forEach((function(t){u(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):p(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}({name:t,showTitle:!0,isCloseable:!0,isPrivate:!0,isLayoutMember:!1,canMaximise:!0,content:'<div class="obj_properties container-fluid h-100"></div>'},r)),i.load(n))},registerUtilityPanel:function(e){var t=e||o.docker,r=t.findPanels("utility_props");if(!r||1!=r.length){(r=new o.Panel({name:"utility_props",showTitle:!0,isCloseable:!0,isPrivate:!0,isLayoutMember:!1,canMaximise:!0,elContainer:!0,content:'<div class="obj_properties"></div>',onCreate:function(e,t){t.classList.add("pg-no-overflow")},events:{}})).load(t)}},register_node_panel:function(){var e=o.docker.findPanels("node_props");if(!e||1!=e.length){(e=new o.Panel({name:"node_props",showTitle:!0,isCloseable:!0,isPrivate:!0,isLayoutMember:!1,canMaximise:!0,elContainer:!0,content:'<div class="obj_properties"></div>',onCreate:function(e,t){t.classList.add("pg-no-overflow")},events:{}})).load(o.docker)}},hasScriptTypes:["create"],canEdit:!0,canDrop:!1,canDropCascade:!1,dropAsRemove:!1,dropPriority:2,selectParentNodeOnDelete:!1,callbacks:{show_obj_properties:function(r,a){var d,c=o.tree,p=r&&r.item||a||c.selected(),u=p?c.itemData(p):void 0,f=this,h=f.title.apply(this,[u]);if(o.Node.register_node_panel(),u){var b=this,m=l.default.isArray(this.parent_type)?function(e){return-1!=l.default.indexOf(b.parent_type,e._type)}:function(e){return b.parent_type==e._type},y=function(){var e,r,n,a,s=window.document.body,l=document.createElement("div");s.insertBefore(l,s.firstChild),e=screen.width<800?t.toPx(l,"95%","width",!0):(e=t.toPx(l,b.width||o.stdW.default+"px","width",!0))<=o.stdW.sm?o.stdW.sm:e<=o.stdW.md?o.stdW.md:o.stdW.lg,r=screen.height<600?t.toPx(l,"95%","height",!0):(r=t.toPx(l,b.height||o.stdH.default+"px","height",!0))<=o.stdH.sm?o.stdH.sm:r<=o.stdH.md?o.stdH.md:o.stdH.lg,n=(s.offsetWidth-e)/2,a=(s.offsetHeight-r)/4,e>window.innerWidth&&(n=0,e=window.innerWidth),r>window.innerHeight&&(a=0,r=window.innerHeight);var d=o.docker.addPanel("node_props",i.DOCK.FLOAT,void 0,{w:e+"px",h:r+"px",x:n+"px",y:a+"px"});return s.removeChild(l),d};if("create"==r.action){if(b.parent_type&&!m(u))for(;p&&c.hasParent(p);){p=c.parent(p);var _=c.itemData(p);if(m(_)){u=_;break}}if(!u||null!=this.parent_type&&!m(u))return;h=e("Create - %s",this.label),"server"==this.type&&(h=e("Register - %s",this.label)),d=y(),setTimeout((function(){f.showProperties(p,u,d,r.action)}),10)}else{if(o.Node.panels&&o.Node.panels[u.id]&&o.Node.panels[u.id].$container)if((d=o.Node.panels[u.id]).$container.attr("action-mode")){var v=e('Are you sure want to stop editing the properties of %s "%s"?');"edit"==r.action&&(v=e('Are you sure want to reset the current changes and re-open the panel for %s "%s"?')),s.default.confirm(e("Edit in progress?"),n.sprintf(v,f.label.toLowerCase(),u.label),(function(){setTimeout((function(){f.showProperties(p,u,d,r.action)}),10)}),null).show()}else setTimeout((function(){f.showProperties(p,u,d,r.action)}),10);else o.Node.panels=o.Node.panels||{},d=o.Node.panels[u.id]=y(),setTimeout((function(){f.showProperties(p,u,d,r.action)}),10)}d.title(h),d.icon("icon-"+this.type),d.focus()}},delete_obj:function(t,r){var n=t||{url:"drop"},i=this,a=o.tree,c=n.item||r||a.selected(),p=c?a.itemData(c):void 0;if(p){i=o.Nodes[p._type];var u,f,h=l.default.unescape(p.label);if("delete"==n.url){if(u=e('Are you sure you want to drop %s "%s" and all the objects that depend on it?',i.label.toLowerCase(),p.label),f=e("DROP CASCADE %s?",i.label),!(l.default.isFunction(i.canDropCascade)?i.canDropCascade.apply(i,[p,c]):i.canDropCascade))return void s.default.error(e('The %s "%s" cannot be dropped.',i.label,p.label),1e4)}else if(i.dropAsRemove?(u=e('Are you sure you want to remove %s "%s"?',i.label.toLowerCase(),p.label),f=e("Remove %s?",i.label)):(u=e('Are you sure you want to drop %s "%s"?',i.label.toLowerCase(),p.label),f=e("Drop %s?",i.label)),!(l.default.isFunction(i.canDrop)?i.canDrop.apply(i,[p,c]):i.canDrop))return void s.default.error(e('The %s "%s" cannot be dropped/removed.',i.label,p.label),1e4);s.default.confirm(f,u,(function(){(0,d.default)().delete(i.generate_url(c,n.url,p,!0)).then((function(e){var t=e.data;if(2!=t.success){if(0==t.success)s.default.alert(t.errormsg,t.info);else{var r=!0;if(i.selectParentNodeOnDelete){var n=a.parent(c);setTimeout((function(){a.select(n)}),10),r=!1}o.removeTreeNode(c,r)}return!0}s.default.error(t.info,null)})).catch((function(t){var r,n,o,a,l=null===(r=t.request)||void 0===r?void 0:r.responseText;if(417==(null===(n=t.request)||void 0===n?void 0:n.status)||410==(null===(o=t.request)||void 0===o?void 0:o.status)||500==(null===(a=t.request)||void 0===a?void 0:a.status))try{var d=t.response.data;l=d.info||d.errormsg}catch(e){console.warn(e.stack||e)}s.default.alert(e('Error dropping/removing %s: "%s"',i.label,h),l)}))}))}},show_script:function(e,r){var n,i,a=e.script,s=o.tree,l=r||s.selected(),d=l?s.itemData(l):void 0;d&&(n=o.Nodes[d._type],i="insert"==a?"insert_sql":"update"==a?"update_sql":"delete"==a?"delete_sql":"select"==a?"select_sql":"exec"==a?"exec_sql":"sql",t.Tools.SQLEditor.showQueryTool(n.generate_url(l,i,d,!0),l,a))},show_query_tool:function(r,n){var i=o.get_preference("sqleditor","copy_sql_to_query_tool"),a=o.tree,s=n||a.selected(),l=s?a.itemData(s):void 0;if(l)if(i.value&&!l._type.includes("coll-")){var d={script:l._type.toLowerCase(),data_disabled:e("The selected tree node does not support this option.")};o.Node.callbacks.show_script(d)}else t.Tools.SQLEditor.showQueryTool("",s)},show_psql_tool:function(e){var t=e||{},r=o.tree,n=t.item||r.selected(),i=n?r.itemData(n):void 0;o.psql.psql_tool(i,n,!0)},change_server_background:function(e,t){if(e&&t){var r=o.tree.getTreeNodeHierarchy(e).server;if(r)if(-1!==e.path.indexOf(r.id)){var n=r.icon.split(" ")[1]||null,i=r.icon.split(" ")[2]||"";if(n){var a,s="pga_server_"+r._id+"_bgcolor",l=document.createElement("style");l.setAttribute("id",s),l.setAttribute("type","text/css"),l.innerText="\n              .".concat(s," .file-label {\n                border-radius: 3px;\n                margin-bottom: 2px;\n                background: ").concat(n," !important;\n              }\n              ").concat(i?"\n              .".concat(s," span.file-name {\n                color: ").concat(i," !important;\n              }\n              "):"","\n            "),null===(a=document.querySelector('style[id="'.concat(s,'"]')))||void 0===a||a.remove(),document.head.appendChild(l),o.tree.addCssClass(e,s)}}}},added:function(e,r){-1!==o.tree.getData(e)._type.indexOf("coll-")&&setTimeout((function(){var r=t.Browser.Nodes[o.tree.getData(e).nodes[0]];r.clear_cache.apply(r)}),0),o.Events.trigger("pgadmin:browser:tree:expand-from-previous-tree-state",e),o.Node.callbacks.change_server_background(e,r)},selected:function(e,r,n){var i=n||o,a=i.tree,s=r||a.itemData(e);return t.Browser.enable_disable_menus.apply(i,[e]),s&&i&&"properties"in i.panels&&i.panels.properties&&i.panels.properties.panel&&i.panels.properties.panel.isVisible()&&this.showProperties(e,s,i.panels.properties.panel),o.Events.trigger("pgadmin:browser:tree:update-tree-state",e),!0},removed:function(e){var t=this;setTimeout((function(){t.clear_cache.apply(t,e)}),0)},refresh:function(e,t){var r=this,n=o.tree,i=t&&n.itemData(t);o.Events.trigger("pgadmin:browser:tree:refresh",t||o.tree.selected(),{success:function(){r.callbacks.selected.apply(r,[t,i,o])}})},opened:function(e){var t=o.tree,r=o.get_preference("browser","auto_expand_sole_children");if(r&&r.value&&1==t.children(e).length){var n=t.first(e);if(n._loaded)t.open(n),t.select(n);else var i=setInterval((function(){n._loaded&&(t.open(n),t.select(n),a())}),200),a=function(){clearInterval(i)}}else if(1==t.children(e).length){var s=t.first(e);t.select(s)}o.Events.trigger("pgadmin:browser:tree:update-tree-state",e)},closed:function(e){o.Events.trigger("pgadmin:browser:tree:remove-from-tree-state",e)}},showProperties:function(t,r,n,i){var d=this,c=n.$container.find(".obj_properties").first(),p=function(){var e=o.tree.getTreeNodeHierarchy(t);(0,a.getNodeView)(d.type,e,"properties",r,"tab",c[0],this,b)}.bind(n),u=function(){i&&"properties"==i&&(i="edit"),this.$container.attr("action-mode",i),this.icon(l.default.isFunction(d.node_image)?d.node_image.apply(d,[r]):d.node_image||"icon-"+d.type),(0,a.removeNodeView)(c[0]);var n=o.tree.getTreeNodeHierarchy(t);(0,a.getNodeView)(d.type,n,i,r,"dialog",c[0],this,b,(function(t){t.node&&(h(t.node,n),0===t.success&&s.default.alert(e("Error"),e(t.errormsg)))}))}.bind(n),f=function(e,r,n){setTimeout((function(){e.clear_cache.apply(e,t)}),0);try{o.Events.trigger("pgadmin:browser:tree:add",l.default.clone(r),l.default.clone(n))}catch(e){console.warn(e.stack||e)}this.close()}.bind(n,d),h=function(e,n,i){var a=r,s=n,l=i;setTimeout((function(){e.clear_cache.apply(e,t)}),0),o.Events.trigger("pgadmin:browser:tree:update",a,s,l,{success:function(e,t,r){o.Events.trigger("pgadmin:browser:node:updated",e,t,r),o.Events.trigger("pgadmin:browser:node:"+t._type+":updated",e,t,r)}}),this.close()}.bind(n,d),b=u.bind(n);i?("create"==i&&(h=f),"properties"!=i?u():p()):(b=function(){setTimeout((function(){d.callbacks.show_obj_properties.apply(d,[{action:"edit",item:t}])}),0)}.bind(n),p())},_find_parent_node:function(e,t,r){if(this.parent_type)if(r=r||e.itemData(t),l.default.isString(this.parent_type)){if(this.parent_type==r._type)return t;for(;e.hasParent(t);)if(t=e.parent(t),r=e.itemData(t),this.parent_type==r._type)return t}else{if(l.default.indexOf(this.parent_type,r._type)>=0)return t;for(;e.hasParent(t);)if(t=e.parent(t),r=e.itemData(t),l.default.indexOf(this.parent_type,r._type)>=0)return t}return null},generate_url:function(e,t,n,i,a,s){var d={create:"obj",drop:"obj",edit:"obj",properties:"obj",statistics:"stats"},c=this,p=-1/0,u=l.default.isUndefined(e)||l.default.isNull(e)?a||{}:o.tree.getTreeNodeHierarchy(e),f=t in d?d[t]:t,h=i&&n._type==c.type?encodeURIComponent(n._id):"";if(c.parent_type)if(l.default.isString(c.parent_type)){var b=u[c.parent_type];b&&(p=b.priority)}else l.default.each(c.parent_type,(function(e){var t=u[e];t&&p<t.priority&&(p=t.priority)}));var m=p;s&&u[s]&&(m=u[s].priority);return r.generate_url(o.URL,u,f,c.type,(function(e){return e.priority<=m||e.priority==p}),h)},cache:function(e,t,r,i){var o=this.cached=this.cached||{},a=e,s=t&&t[r]&&t[r].priority||0;if(t&&l.default.each(l.default.sortBy(l.default.values(l.default.pickBy(t,(function(e){return e.priority<=s}))),(function(e){return e.priority})),(function(e){a=n.sprintf("%s_%s",a,encodeURI(e._id))})),l.default.isUndefined(i)){var d=o[a];return!l.default.isUndefined(d)&&d.at-Date.now()>3e5&&(d=void 0),d}return o[a]={data:i,at:Date.now(),level:r}},clear_cache:function(e){this.cached={};o.Events.trigger("pgadmin:browser:node:"+this.type+":cache_cleared",e,this)},cache_level:function(e,t){if(e){if(t&&this.type in e)return this.type;if(l.default.isArray(this.parent_type)){for(var r in this.parent_type)if(r in e)return r;return this.type}return this.parent_type}}}),t.Browser.Node)}.apply(t,n))||(e.exports=i)},70242:(e,t,r)=>{var n,i;r(68309),r(24812),r(89554),r(41539),r(32564),r(69826),r(26699);var o,a=r(73819),s=(o=r(96486))&&o.__esModule?o:{default:o};n=[r(55112),r(35816)],void 0===(i=function(e){var t=e.Browser=e.Browser||{},r=window.wcDocker;return e.Browser.Panel=function(e){s.default.extend(this,s.default.pick(e,["name","title","width","height","showTitle","isCloseable","isPrivate","isLayoutMember","content","icon","events","onCreate","elContainer","canHide","limit","extraClasses","canMaximise"]))},s.default.extend(e.Browser.Panel.prototype,{name:"",title:"",width:300,height:600,showTitle:!0,isCloseable:!0,isPrivate:!1,isLayoutMember:!0,content:"",icon:"",panel:null,onCreate:null,elContainer:!1,canMaximise:!1,limit:null,extraClasses:null,load:function(e,n){var i=this;i.panel||e.registerPanelType(i.name,{title:i.title,isPrivate:i.isPrivate,limit:i.limit,isLayoutMember:i.isLayoutMember,onCreate:function(e){if(e.panelData={pgAdminName:i.name},e.initSize(i.width,i.height),i.showTitle){var o='<a href="#" tabindex="-1" class="panel-link-heading">'+(n||i.title)+"</a>";e.title(o),""!=i.icon&&e.icon(i.icon)}else e.title(!1);var l=document.createElement("div");l.setAttribute("class","pg-panel-content"),l.innerHTML=i.content,s.default.isNull("extraClasses")||l.classList.add(i.extraClasses),e.maximisable(!!i.canMaximise),e.closeable(!!i.isCloseable),e.layout().addItem(l),i.panel=e,i.events&&s.default.isObject(i.events)&&s.default.each(i.events,(function(t,r){t&&s.default.isFunction(t)&&e.on(r,t)})),s.default.each([r.EVENT.UPDATED,r.EVENT.VISIBILITY_CHANGED,r.EVENT.BEGIN_DOCK,r.EVENT.END_DOCK,r.EVENT.GAIN_FOCUS,r.EVENT.LOST_FOCUS,r.EVENT.CLOSED,r.EVENT.BUTTON,r.EVENT.ATTACHED,r.EVENT.DETACHED,r.EVENT.MOVE_STARTED,r.EVENT.MOVE_ENDED,r.EVENT.MOVED,r.EVENT.RESIZE_STARTED,r.EVENT.RESIZE_ENDED,r.EVENT.RESIZED,r.EVENT.SCROLLED],(function(t){e.on(t,i.eventFunc.bind(e,t))})),i.onCreate&&s.default.isFunction(i.onCreate)&&i.onCreate.apply(i,[e,l]),["dragover","drop"].forEach((function(e){l.addEventListener(e,(function(e){e.stopPropagation(),e.preventDefault()}))})),i.elContainer&&(e.pgElContainer=l,s.default.each([r.EVENT.RESIZED,r.EVENT.ATTACHED,r.EVENT.DETACHED,r.EVENT.VISIBILITY_CHANGED],(function(t){e.on(t,i.resizedContainer.bind(e))})),i.resizedContainer.apply(e)),"dashboard"!=e._type&&"processes"!=e._type||(0,a.getPanelView)(t.tree,l,t,e._type),t.onPreferencesChange("dashboards",(function(){(0,a.getPanelView)(t.tree,l,t,e._type)})),t.onPreferencesChange("graphs",(function(){(0,a.getPanelView)(t.tree,l,t,e._type)})),s.default.each([r.EVENT.CLOSED,r.EVENT.VISIBILITY_CHANGED],(function(t){e.on(t,i.handleVisibility.bind(e,t))})),t.Events.on("pgadmin-browser:tree:selected",(function(){e.isVisible()&&"properties"!==e._type&&(0,a.getPanelView)(t.tree,l,t,e._type)})),t.Events.on("pgadmin:database:connected",(function(){e.isVisible()&&"properties"!==e._type&&(0,a.getPanelView)(t.tree,l,t,e._type)})),t.Events.on("pgadmin-browser:tree:refreshing",(function(){e.isVisible()&&"properties"!==e._type&&(0,a.getPanelView)(t.tree,l,t,e._type)}))}})},eventFunc:function(e){var r=this.panelData.pgAdminName;try{t.Events.trigger("pgadmin-browser:panel",e,this,arguments),t.Events.trigger("pgadmin-browser:panel:"+e,this,arguments),r&&(t.Events.trigger("pgadmin-browser:panel-"+r,e,this,arguments),t.Events.trigger("pgadmin-browser:panel-"+r+":"+e,this,arguments))}catch(e){console.warn(e.stack||e)}},resizedContainer:function(){var e=this;if(e.pgElContainer&&!e.pgResizeTimeout){if(!e.isVisible())return clearTimeout(e.pgResizeTimeout),void(e.pgResizeTimeout=null);e.pgResizeTimeout=setTimeout((function(){var t=e.width(),r="xs";e.pgResizeTimeout=null,t>=480&&(r="sm"),t>=768&&(r="md"),t>=992&&(r="lg"),t>=1200&&(r="xl"),e.pgElContainer.setAttribute("el",r)}),100)}},handleVisibility:function(e){var r=t.docker.findPanels(this._type)[0],n=r.isVisible(),i=r.layout().scene().find(".pg-panel-content");n&&["dashboard","statistics","dependencies","dependents","sql","processes"].includes(r._type)&&"panelVisibilityChanged"==e&&(0,a.getPanelView)(t.tree,i[0],t,this._type),"panelClosed"==e&&"dashboard"==r._type&&(0,a.getPanelView)(t.tree,i[0],t,this._type,!1)}}),e.Browser.Panel}.apply(t,n))||(e.exports=i)}}]);