webpackJsonp([1],{"+R7H":function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("Form",{ref:"addForm",staticClass:"addForm",attrs:{model:e.userInfo,"label-width":120}},[n("FormItem",{attrs:{label:"uid",prop:"uid"}},[n("Input",{attrs:{placeholder:"请输入用户uid"},model:{value:e.userInfo.uid,callback:function(t){e.userInfo.uid=t},expression:"userInfo.uid"}})],1),e._v(" "),n("FormItem",{attrs:{label:"测试账号",prop:"test"}},[n("Tooltip",{attrs:{placement:"top",content:"测试账号开播不验证保证金，不上排行榜"}},[n("i-switch",{attrs:{size:"large"},model:{value:e.userInfo.test,callback:function(t){e.userInfo.test=t},expression:"userInfo.test"}},[n("span",{slot:"open"},[e._v("是")]),e._v(" "),n("span",{slot:"close"},[e._v("否")])])],1)],1),e._v(" "),n("FormItem",{attrs:{label:"用户角色",prop:"roleType"}},[n("Select",{attrs:{placeholder:"请选择"},model:{value:e.roleType,callback:function(t){e.roleType=t},expression:"roleType"}},[n("Option",{attrs:{value:"owner"}},[e._v("卖家")]),e._v(" "),n("Option",{attrs:{value:"assistant"}},[e._v("小二")])],1)],1),e._v(" "),"owner"===e.roleType?n("div",[n("FormItem",{attrs:{label:"真实姓名",prop:"name"}},[n("Input",{attrs:{placeholder:"请输入"},model:{value:e.userInfo.name,callback:function(t){e.userInfo.name=t},expression:"userInfo.name"}})],1),e._v(" "),e.userInfo.test?e._e():n("div",[n("FormItem",{attrs:{label:"联系电话"}},[n("Input",{attrs:{placeholder:"请输入"},model:{value:e.userInfo.phone,callback:function(t){e.userInfo.phone=t},expression:"userInfo.phone"}})],1),e._v(" "),n("FormItem",{attrs:{label:"经营品类"}},[n("Input",{attrs:{placeholder:"请输入"},model:{value:e.userInfo.category,callback:function(t){e.userInfo.category=t},expression:"userInfo.category"}})],1),e._v(" "),n("FormItem",{attrs:{label:"主营商品"}},[n("Input",{attrs:{placeholder:"请输入"},model:{value:e.userInfo.mainCommodity,callback:function(t){e.userInfo.mainCommodity=t},expression:"userInfo.mainCommodity"}})],1),e._v(" "),n("FormItem",{attrs:{label:"身份证图片"}},[n("img-updater",{model:{value:e.userInfo.idCardImgs,callback:function(t){e.userInfo.idCardImgs=t},expression:"userInfo.idCardImgs"}})],1),e._v(" "),n("FormItem",{attrs:{label:"身份证号"}},[n("Input",{attrs:{placeholder:"请输入"},model:{value:e.userInfo.idCard,callback:function(t){e.userInfo.idCard=t},expression:"userInfo.idCard"}})],1),e._v(" "),n("FormItem",{attrs:{label:"商品样本"}},[n("img-updater",{model:{value:e.userInfo.sample,callback:function(t){e.userInfo.sample=t},expression:"userInfo.sample"}})],1),e._v(" "),n("FormItem",{attrs:{label:"入驻类型"}},[n("Select",{attrs:{placeholder:"请选择"},model:{value:e.userInfo.sellerType,callback:function(t){e.userInfo.sellerType=t},expression:"userInfo.sellerType"}},[n("Option",{attrs:{value:"1",disabled:!!e.id&&2===e.userInfo.sellerType}},[e._v("企业")]),e._v(" "),n("Option",{attrs:{value:"2",disabled:!!e.id&&2!==e.userInfo.sellerType}},[e._v("个人")]),e._v(" "),n("Option",{attrs:{value:"3",disabled:!!e.id&&2===e.userInfo.sellerType}},[e._v("个体户")])],1)],1),e._v(" "),"2"!==e.userInfo.sellerType?n("div",[n("FormItem",{attrs:{label:"营业执照"}},[n("img-updater",{model:{value:e.userInfo.bizLicPic,callback:function(t){e.userInfo.bizLicPic=t},expression:"userInfo.bizLicPic"}})],1),e._v(" "),n("FormItem",{attrs:{label:"实体店照片"}},[n("img-updater",{model:{value:e.userInfo.physicalStorePic,callback:function(t){e.userInfo.physicalStorePic=t},expression:"userInfo.physicalStorePic"}})],1)],1):e._e(),e._v(" "),n("FormItem",{attrs:{label:"会员照片"}},[n("img-updater",{model:{value:e.userInfo.memberPic,callback:function(t){e.userInfo.memberPic=t},expression:"userInfo.memberPic"}})],1),e._v(" "),n("FormItem",{attrs:{label:"淘宝链接"}},[n("Input",{attrs:{placeholder:"请输入"},model:{value:e.userInfo.taobao,callback:function(t){e.userInfo.taobao=t},expression:"userInfo.taobao"}})],1),e._v(" "),n("FormItem",{attrs:{label:"微博名称"}},[n("Input",{attrs:{placeholder:"请输入"},model:{value:e.userInfo.weibo,callback:function(t){e.userInfo.weibo=t},expression:"userInfo.weibo"}})],1),e._v(" "),n("FormItem",{attrs:{label:"微信名称"}},[n("Input",{attrs:{placeholder:"请输入"},model:{value:e.userInfo.wechat,callback:function(t){e.userInfo.wechat=t},expression:"userInfo.wechat"}})],1),e._v(" "),"2"===e.userInfo.sellerType?n("div",[n("FormItem",{attrs:{label:"艺术家身份证明"}},[n("img-updater",{model:{value:e.userInfo.artistIdPic,callback:function(t){e.userInfo.artistIdPic=t},expression:"userInfo.artistIdPic"}})],1),e._v(" "),n("FormItem",{attrs:{label:"技术专业毕业证"}},[n("img-updater",{model:{value:e.userInfo.techGradCertPic,callback:function(t){e.userInfo.techGradCertPic=t},expression:"userInfo.techGradCertPic"}})],1),e._v(" "),n("FormItem",{attrs:{label:"拍卖行送拍记录证明"}},[n("img-updater",{model:{value:e.userInfo.auctionRecordPic,callback:function(t){e.userInfo.auctionRecordPic=t},expression:"userInfo.auctionRecordPic"}})],1),e._v(" "),n("FormItem",{attrs:{label:"职称证明"}},[n("img-updater",{model:{value:e.userInfo.titleCertPic,callback:function(t){e.userInfo.titleCertPic=t},expression:"userInfo.titleCertPic"}})],1)],1):e._e()],1)],1):"assistant"===e.roleType?n("div",[n("FormItem",{attrs:{label:"卖家uid"}},[n("Input",{attrs:{placeholder:"请输入"},model:{value:e.userInfo.sellerId,callback:function(t){e.userInfo.sellerId=t},expression:"userInfo.sellerId"}})],1)],1):e._e(),e._v(" "),n("FormItem",[n("Button",{attrs:{type:"primary"},on:{click:e.commitData}},[e._v("提交")]),e._v(" "),n("Button",{staticStyle:{"margin-left":"8px"},attrs:{type:"ghost"}},[e._v("取消")])],1)],1)},a=[],i={render:r,staticRenderFns:a};t.a=i},"+skl":function(e,t){},"1ygp":function(e,t){},"5bgQ":function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[e._l(e.currentImgList,function(t){return n("div",{staticClass:"demo-upload-list"},["finished"===t.status?[n("img",{attrs:{src:t.url}}),e._v(" "),n("div",{staticClass:"demo-upload-list-cover"},[n("Icon",{attrs:{type:"ios-eye-outline"},nativeOn:{click:function(n){e.handleView(t.url)}}}),e._v(" "),n("Icon",{attrs:{type:"ios-trash-outline"},nativeOn:{click:function(n){e.handleRemove(t)}}})],1)]:[t.showProgress?n("Progress",{attrs:{percent:t.percentage,"hide-info":""}}):e._e()]],2)}),e._v(" "),n("Upload",{ref:"upload",staticStyle:{display:"inline-block",width:"58px"},attrs:{"show-upload-list":!1,"default-file-list":e.imgList,"on-success":e.handleSuccess,accept:"image/*",format:["jpg","jpeg","png"],"max-size":2048,"on-format-error":e.handleFormatError,"on-exceeded-size":e.handleMaxSize,"before-upload":e.handleBeforeUpload,multiple:"",type:"drag",action:"/tools/bs2/saveSingleFile"}},[n("div",{staticStyle:{width:"58px",height:"58px"}},[n("Icon",{staticStyle:{"line-height":"58px"},attrs:{type:"camera",size:"30"}})],1)]),e._v(" "),n("Modal",{attrs:{title:"查看图片"},model:{value:e.visible,callback:function(t){e.visible=t},expression:"visible"}},[n("img",{staticStyle:{width:"100%"},attrs:{src:e.imgPath}})])],2)},a=[],i={render:r,staticRenderFns:a};t.a=i},AVp8:function(e,t,n){"use strict";var r=n("l1i1");t.a={name:"user-permission-editor",components:{},model:{prop:"openDialog",event:"finished"},props:{openDialog:!1},data:function(){return{opened:!1,userPermission:{uid:"",permission:"",type:""},selectedPermission:"",permissions:[]}},methods:{onPermissionChanged:function(e){this.selectedPermission=this.permissions[e]},sendData:function(){var e=this.userPermission.uid,t=[];e&&(t=e.split("\n"),t=t.map(function(e){return Number(e)}));var n={uid:t,permission:this.userPermission.permission,type:Number(this.userPermission.type)};this.addData(n)},addData:function(e){var t=this;this.$http.post("/user/permission",e).then(function(e){r.a.checkResponse(e,t)&&(t.$Notice.success({title:"操作用户权限成功",duration:5}),t.reset(),t.$emit("on-commit"))})},reset:function(){this.userPermission={uid:"",permission:"",type:""}}},watch:{openDialog:function(e){this.opened=e},opened:function(e){this.$emit("finished",e)}},mounted:function(){var e=this;this.$http.get("/user/allPermissions").then(function(t){r.a.checkResponse(t,e)&&(e.permissions=t.data.data)})}}},BeUV:function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"queryContainer"},[n("Form",{ref:"formInline",staticClass:"queryForm",attrs:{model:e.queryParams,inline:""}},[n("FormItem",{attrs:{prop:"uid"}},[n("Input",{attrs:{type:"text",placeholder:"uid"},model:{value:e.queryParams.uid,callback:function(t){e.queryParams.uid=t},expression:"queryParams.uid"}})],1),e._v(" "),n("FormItem",{attrs:{prop:"入驻类型"}},[n("Select",{attrs:{placeholder:"请选择入驻类型"},model:{value:e.queryParams.roleType,callback:function(t){e.queryParams.roleType=t},expression:"queryParams.roleType"}},[n("Option",{attrs:{value:"owner"}},[e._v("卖家")]),e._v(" "),n("Option",{attrs:{value:"assistant"}},[e._v("小二")])],1)],1),e._v(" "),n("FormItem",{attrs:{prop:"测试账号"}},[n("Select",{attrs:{placeholder:"是否包含测试账号"},model:{value:e.queryParams.test,callback:function(t){e.queryParams.test=t},expression:"queryParams.test"}},[n("Option",{attrs:{value:"1"}},[e._v("包含")]),e._v(" "),n("Option",{attrs:{value:"0"}},[e._v("不包含")])],1)],1),e._v(" "),n("FormItem",[n("Button",{attrs:{type:"primary"},on:{click:function(t){e.handleSubmit()}}},[e._v("搜索")])],1)],1),e._v(" "),e.queryResult?n("div",[n("Table",{attrs:{columns:e.resultCol,data:e.queryResult}}),e._v(" "),n("Page",{staticClass:"page",attrs:{"page-size":e.pageSize,"page-size-opts":e.pageSizeOpts,current:e.currentPage,total:e.totalSize,"show-sizer":""},on:{"update:pageSize":function(t){e.pageSize=t},"update:current":function(t){e.currentPage=t},"on-change":e.onPageChange,"on-page-size-change":e.onPageSizeChange}})],1):e._e()],1)},a=[],i={render:r,staticRenderFns:a};t.a=i},CDbl:function(e,t,n){"use strict";function r(e){n("Er01")}var a=n("STK+"),i=n("5bgQ"),s=n("VU/8"),o=r,c=s(a.a,i.a,o,"data-v-d859ca0c",null);t.a=c.exports},Er01:function(e,t){},Gyl8:function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("div",{staticClass:"layout"},[n("Menu",{attrs:{mode:"horizontal",theme:"light","active-name":e.menuActive},on:{"on-select":e.nav}},[n("MenuItem",{attrs:{name:"mgr"}},[n("Icon",{attrs:{type:"android-people"}}),e._v("\n        账户列表\n      ")],1),e._v(" "),n("MenuItem",{attrs:{name:"add"}},[n("Icon",{attrs:{type:"android-person-add"}}),e._v("\n        新增账户\n      ")],1),e._v(" "),n("MenuItem",{attrs:{name:"userPermission"}},[n("Icon",{attrs:{type:"disc"}}),e._v("\n        用户权限\n      ")],1)],1),e._v(" "),n("div",{staticClass:"layout-content"},[n("router-view")],1),e._v(" "),n("div",{staticClass:"layout-copy"},[e._v("\n      非标电商项目组\n    ")])],1)])},a=[],i={render:r,staticRenderFns:a};t.a=i},IJKN:function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("Modal",{attrs:{width:"580"},on:{"on-ok":e.sendData},model:{value:e.opened,callback:function(t){e.opened=t},expression:"opened"}},[n("p",{staticStyle:{color:"#f60","text-align":"center"},slot:"header"},[n("span",[e._v("添加用户权限")])]),e._v(" "),n("Form",{ref:"addUserPermissionForm",staticClass:"addForm",attrs:{model:e.userPermission,"label-width":120}},[n("FormItem",{attrs:{label:"用户列表",prop:"uid"}},[n("Input",{attrs:{type:"textarea",autosize:{minRows:2,maxRows:10},placeholder:"请输入uid, 回车间隔"},model:{value:e.userPermission.uid,callback:function(t){e.userPermission.uid=t},expression:"userPermission.uid"}})],1),e._v(" "),n("FormItem",{attrs:{label:"权限"}},[n("Select",{attrs:{placeholder:"请选择"},model:{value:e.userPermission.permission,callback:function(t){e.userPermission.permission=t},expression:"userPermission.permission"}},e._l(e.permissions,function(t,r){return n("Option",{key:t.id,attrs:{value:t.id}},[e._v("\n          "+e._s(t.name)+"\n        ")])}))],1),e._v(" "),n("FormItem",{attrs:{label:"类型"}},[n("Select",{attrs:{placeholder:"请选择"},model:{value:e.userPermission.type,callback:function(t){e.userPermission.type=t},expression:"userPermission.type"}},[n("Option",{attrs:{value:"0"}},[e._v("追加")]),e._v(" "),n("Option",{attrs:{value:"1"}},[e._v("删除")])],1)],1)],1)],1)},a=[],i={render:r,staticRenderFns:a};t.a=i},Lt2J:function(e,t){},M93x:function(e,t,n){"use strict";function r(e){n("Lt2J")}var a=n("xJD8"),i=n("Gyl8"),s=n("VU/8"),o=r,c=s(a.a,i.a,o,null,null);t.a=c.exports},NG0K:function(e,t,n){"use strict";function r(e){n("shvd")}var a=n("Xwl9"),i=n("+R7H"),s=n("VU/8"),o=r,c=s(a.a,i.a,o,"data-v-91be2b56",null);t.a=c.exports},NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=n("7+uW"),a=n("mtWM"),i=n.n(a),s=n("M93x"),o=n("YaEn"),c=n("BTaQ"),u=n.n(c),l=n("+skl");n.n(l);r.default.use(u.a),r.default.http=r.default.prototype.$http=i.a,r.default.config.productionTip=!1,new r.default({el:"#app",router:o.a,template:"<App/>",components:{App:s.a}})},R8u8:function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[e.data&&e.data.length>0?n("div",{staticClass:"tableContainer"},[n("Table",{attrs:{columns:e.col,data:e.data,loading:e.loading},on:{"on-selection-change":e.onSelectionChange}}),e._v(" "),e.pageable?n("Page",{staticClass:"page",attrs:{"page-size":e.pageSize,"page-size-opts":e.pageSizeOpts,current:e.pageNo,total:e.totalSize,"show-sizer":""},on:{"on-change":e.onPageChange,"on-page-size-change":e.onPageSizeChange}}):e._e()],1):e.showNoData?n("div",[n("p",{staticStyle:{margin:"20px auto","text-align":"center"}},[e._v("当前还没有数据，快去添加吧！")])]):e._e()])},a=[],i={render:r,staticRenderFns:a};t.a=i},"STK+":function(e,t,n){"use strict";t.a={name:"img-updater",model:{prop:"imgList",event:"finished"},props:{imgList:{type:[Array],default:function(){return[]}}},data:function(){return{imgPath:"",visible:!1,currentImgList:this.imgList}},methods:{findFileLocation:function(e,t){for(var n=-1,r=0;r<e.length;r++){var a=e[r];if(t.url===a.url){n=r;break}}return n},handleView:function(e){this.imgPath=e,this.visible=!0},handleRemove:function(e){var t=this.$refs.upload.fileList,n=this.findFileLocation(t,e);-1!==n&&this.$refs.upload.fileList.splice(n,1);var r=this.findFileLocation(this.currentImgList,e);-1!==r&&this.currentImgList.splice(r,1)},handleSuccess:function(e,t){if("finished"!==t.status)return void console.log(t.name+"上传失败,请重新上传");t.name=e.data.name,t.url=e.data.path,this.currentImgList.push(t),this.$emit("finished",this.currentImgList)},handleFormatError:function(e){this.$Notice.warning({title:"文件格式不正确",desc:"文件 "+e.name+" 格式不正确，请上传 jpg 或 png 格式的图片。"})},handleMaxSize:function(e){this.$Notice.warning({title:"超出文件大小限制",desc:"文件 "+e.name+" 太大，不能超过 2M。"})},handleBeforeUpload:function(){var e=this.currentImgList.length<10;return e||this.$Notice.warning({title:"最多只能上传 10 张图片。"}),e},setCurrentImgList:function(e){e!==this.currentImgList&&(this.currentImgList=e)}},watch:{imgList:function(e){this.setCurrentImgList(e)}}}},W7gV:function(e,t,n){"use strict";function r(e){n("eQfC")}var a=n("AVp8"),i=n("IJKN"),s=n("VU/8"),o=r,c=s(a.a,i.a,o,"data-v-e3fa7f92",null);t.a=c.exports},Xwl9:function(e,t,n){"use strict";var r=n("CDbl"),a=n("DlMc"),i=n.n(a);t.a={name:"add-assistant-view",components:{ImgUpdater:r.a},data:function(){return{id:0,userInfo:{uid:"",test:"",name:"",phone:"",category:"",sample:[],bizLicPic:[],sellerType:"",idCard:"",idCardImgs:[],physicalStorePic:[],memberPic:[],taobao:"",weibo:"",wechat:"",artistIdPic:[],techGradCertPic:[],auctionRecordPic:[],titleCertPic:[],sellerId:"",mainCommodity:""},roleType:"",ruleValidate:{uid:[{required:!0,message:"uid不能为空",trigger:"blur"}],roleType:[{required:!0,message:"必须选择用户角色",trigger:"change"}]}}},methods:{extractPureUrl:function(e){if(Array.isArray(e))return e.map(function(e){return e.url})},fillUrl:function(e){if(Array.isArray(e))return e.map(function(e){return{name:i.a.v4(),url:e}})},buildData:function(){return"assistant"===this.roleType?{uid:this.userInfo.uid,sellerId:this.userInfo.sellerId,test:this.userInfo.test}:{uid:this.userInfo.uid,test:this.userInfo.test,name:this.userInfo.name,phone:this.userInfo.phone,category:this.userInfo.category,mainCommodity:this.userInfo.mainCommodity,sample:this.extractPureUrl(this.userInfo.sample),bizLicPic:this.extractPureUrl(this.userInfo.bizLicPic),sellerType:this.userInfo.sellerType,idCard:this.userInfo.idCard,idCardImgs:this.extractPureUrl(this.userInfo.idCardImgs),physicalStorePic:this.extractPureUrl(this.userInfo.physicalStorePic),memberPic:this.extractPureUrl(this.userInfo.memberPic),taobao:this.userInfo.taobao,weibo:this.userInfo.weibo,wechat:this.userInfo.wechat,artistIdPic:this.extractPureUrl(this.userInfo.artistIdPic),techGradCertPic:this.extractPureUrl(this.userInfo.techGradCertPic),auctionRecordPic:this.extractPureUrl(this.userInfo.auctionRecordPic),titleCertPic:this.extractPureUrl(this.userInfo.titleCertPic)}},checkResponse:function(e){var t=this;return console.log(e),200===e.status&&e.data?200===e.data.code||(t.$Message.error({content:"操作失败，原因:"+e.data.msg,duration:5}),!1):(t.$Message.error({content:"操作失败，网络异常",duration:5}),!1)},commitData:function(){var e=this;this.$refs.addForm.validate(function(t){t?e.id&&e.id>0?e.updateData():e.addData():e.$Message.error("表单验证失败!")})},updateData:function(){var e=this,t=this.buildData();e.$http.put("/user/update/"+this.roleType+"/"+this.id,t).then(function(t){e.checkResponse(t)&&e.$Message.success({content:"更新成功",duration:5})})},addData:function(){var e=this,t=this.buildData();e.$http.post("/user/add/"+this.roleType,t).then(function(t){e.checkResponse(t)&&e.$Message.success({content:"添加成功",duration:5})})},loadData:function(e){var t=this,n=this;e&&e>0&&n.$http.get("/user/seller/"+e).then(function(e){if(n.checkResponse(e)){var r=e.data.data;r.sample=t.fillUrl(r.sample),r.bizLicPic=t.fillUrl(r.bizLicPic),r.idCardImgs=t.fillUrl(r.idCardImgs),r.physicalStorePic=t.fillUrl(r.physicalStorePic),r.memberPic=t.fillUrl(r.memberPic),r.artistIdPic=t.fillUrl(r.artistIdPic),r.techGradCertPic=t.fillUrl(r.techGradCertPic),r.auctionRecordPic=t.fillUrl(r.auctionRecordPic),r.titleCertPic=t.fillUrl(r.titleCertPic),t.userInfo=r,t.roleType="owner"}})}},watch:{$route:function(e,t){console.log("router changed"),this.loadData(e.params.uid),this.id=e.params.uid}},beforeRouteEnter:function(e,t,n){n(function(t){t.loadData(e.params.uid),t.id=e.params.uid})}}},YaEn:function(e,t,n){"use strict";var r=n("7+uW"),a=n("/ocq"),i=n("NG0K"),s=n("v1cs"),o=n("kY3Q");r.default.use(a.a),t.a=new a.a({routes:[{path:"/",name:"root",redirect:"/mgr"},{path:"/add",name:"AddAssistantView",component:i.a},{path:"/mgr",name:"AccountView",component:o.a},{path:"/edit/:uid",name:"EditAssistantView",component:i.a},{path:"/userPermission",name:"UserPermissionView",component:s.a}]})},"bn1/":function(e,t,n){"use strict";var r={combinParams:function(e,t,n){var r={};for(var a in e)e.hasOwnProperty(a)&&(r[a]=e[a]);for(var i in t)t.hasOwnProperty(i)&&(r[i]=t[i]);return n&&n.pageNo&&(r.pageNo=n.pageNo),n&&n.pageSize&&(r.pageSize=n.pageSize),n&&n.id&&(r.id=n.id),r},matchUrl:function(e,t){return e.replace(/{([^\s]*?)}/g,function(e){var n=e.substring(1,e.length-1);return t[n]})}};t.a=r},cFDB:function(e,t,n){"use strict";t.a={name:"pageable-table",props:{col:{type:Array,default:function(){return[]}},data:{type:Array,default:function(){return[]}},totalSize:{type:Number,default:0},pageSize:{type:Number,default:50},pageNo:{type:Number,default:1},pageSizeOpts:{type:Array,default:function(){return[20,50,100]}},pageable:{type:Boolean,default:!0},showNoData:{type:Boolean,default:!0},loading:{type:Boolean,default:!1}},methods:{onPageChange:function(e){this.$emit("on-change",e)},onPageSizeChange:function(e){this.$emit("on-page-size-change",e)},onSelectionChange:function(e){this.$emit("on-selection-change",e)}}}},ciBs:function(e,t){},cmCQ:function(e,t,n){"use strict";function r(e){n("omQo")}var a=n("cFDB"),i=n("R8u8"),s=n("VU/8"),o=r,c=s(a.a,i.a,o,"data-v-466805a2",null);t.a=c.exports},eQfC:function(e,t){},"h+cV":function(e,t,n){"use strict";function r(e){n("ciBs")}var a=n("qAfD"),i=n("wrU5"),s=n("VU/8"),o=r,c=s(a.a,i.a,o,"data-v-6e54676a",null);t.a=c.exports},kY3Q:function(e,t,n){"use strict";function r(e){n("yDvM")}var a=n("mEg5"),i=n("BeUV"),s=n("VU/8"),o=r,c=s(a.a,i.a,o,"data-v-4e86a9ef",null);t.a=c.exports},l1i1:function(e,t,n){"use strict";var r={checkResponse:function(e,t){return console.log(e),200===e.status&&e.data?200===e.data.code||(t.$Notice.error({title:"请求失败，原因:"+e.data.msg,duration:5}),!1):(t.$Notice.error({title:"请求失败，网络异常",duration:5}),!1)}};t.a=r},mEg5:function(e,t,n){"use strict";var r=n("mw3O"),a=n.n(r);t.a={name:"account-view",data:function(){var e=this;return{queryParams:{uid:"",roleType:"",test:""},queryResult:"",resultCol:[{title:"uid",key:"uid"},{title:"昵称",key:"nickname"},{title:"真实姓名",key:"realname"},{title:"身份",key:"roleType",render:function(e,t){var n="",r=t.row.roleType;return"owner"===r?n="卖家":"assistant"===r&&(n="小二"),e("div",n)}},{title:"测试账号",key:"test",render:function(e,t){return e("div",t.row.test?"是":"否")}},{title:"操作",key:"operations",render:function(t,n){if("owner"===n.row.roleType)return t("div",[t("Button",{props:{type:"primary",size:"small"},style:{marginRight:"5px"},on:{click:function(){e.$router.push("/edit/"+n.row.uid)}}},"编辑")])}}],pageSize:50,pageSizeOpts:[50,100,200],currentPage:1,totalSize:0,roleMap:{assistant:"小二",owner:"卖家"}}},methods:{checkResponse:function(e){var t=this;return console.log(e),200===e.status&&e.data?200===e.data.code||(t.$Message.error({content:"查询失败，原因:"+e.data.msg,duration:5}),!1):(t.$Message.error({content:"查询失败，网络异常",duration:5}),!1)},handleSubmit:function(){var e=this,t=this,n={uid:t.queryParams.uid,roleType:t.queryParams.roleType,test:t.queryParams.test,pageNo:t.currentPage,pageSize:t.pageSize};t.$http.get("/user/list?"+a.a.stringify(n)).then(function(n){if(t.checkResponse(n)){var r=n.data.data;e.queryResult=r.list,e.totalSize=r.totalCount}})},onPageChange:function(e){this.handleSubmit()},onPageSizeChange:function(e){this.pageSize=e,this.handleSubmit()}},mounted:function(){this.handleSubmit()}}},omQo:function(e,t){},ouxa:function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("common-mgr",{ref:"userPermissionMgr",attrs:{searchUrl:"/user/permissions",deleteUrl:"/user/permission/{id}",filters:e.filters,resultCol:e.resultCol},on:{"on-open-editor":e.onOpenEditor}}),e._v(" "),n("user-permission-edit",{on:{"on-commit":e.refresh},model:{value:e.openEditor,callback:function(t){e.openEditor=t},expression:"openEditor"}})],1)},a=[],i={render:r,staticRenderFns:a};t.a=i},qAfD:function(e,t,n){"use strict";var r=n("mw3O"),a=n.n(r),i=n("bn1/"),s=n("l1i1"),o=n("cmCQ");t.a={name:"common-mgr",components:{PageableTable:o.a},props:{showSearch:{type:Boolean,default:!0},showNew:{type:Boolean,default:!0},params:{type:Object,default:function(){return{}}},searchUrl:String,deleteUrl:String,startUrl:String,stopUrl:String,filters:{type:Array,default:function(){return[{key:"",name:"",type:"",options:{}}]}},resultCol:{type:Array,default:function(){return[]}},btns:{type:Array,default:function(){return[]}}},data:function(){return{result:[],queryParams:{},totalSize:0,selectedRow:-1,pageNo:1,pageSize:50,editMode:!1,loadingData:!1,id:-1,editFields:{},showBatchDelete:!1,selectedRows:[]}},computed:{col:function(){for(var e=[],t=0;t<this.resultCol.length;t++){var n=this.resultCol[t];if(!1!==n.display)if(!n.render&&n.type)switch(n.type){case"date":this.parseDateCell(n),e.push(n);break;case"button":this.parseBtnCell(n),n.invalid||e.push(n);break;case"code":this.parseCodeCell(n),e.push(n);break;case"switch":this.parseSwitchCell(n),e.push(n);break;default:e.push(n)}else e.push(n)}return e}},methods:{parseDateCell:function(e){var t=this;e.render=function(n,r){var a=Number(r.row[e.key]);return isNaN(a)?n("div"):n("div",t.$moment(a).format("YYYY-MM-DD HH:mm:ss"))}},parseBtnCell:function(e){var t=this,n=e.options.data;e.render=function(e,r){var a=[];return n.forEach(function(n){if(!n.condition||"[object Function]"!==Object.prototype.toString.call(n.condition)||n.condition(r)){var i=e("Button",{props:{type:function(){if("stop"!==n.func)return n.type;var e=n.status||1,t=n.rstatus||2;return r.row.status===e?"error":r.row.status===t?"success":void 0}(),size:"small"},style:{marginRight:"5px"},on:{click:function(){if("[object Function]"===Object.prototype.toString.call(n.click))n.click(r.index,r.row);else switch(n.func){case"update":t.openEditor(void 0,r.index);break;case"delete":t.remove(r.index,r.row,n.tip);break;case"stop":var e=n.status||1,a=n.rstatus||2;r.row.status===e?t.stop(r.index,r.row,n.tip):r.row.status===a?t.start(r.index,r.row,n.rtip):t.$Notice.info({title:"暂无此操作"})}}}},function(){if("stop"!==n.func)return n.name;var e=n.status||1,t=n.rstatus||2;return r.row.status===e?n.name:r.row.status===t?n.rname:void 0}());a.push(i)}}),e("div",a)}},parseCodeCell:function(e){var t=e.options.codeTable;e.render=function(n,r){var a=r.row[e.key];if(e.options.color){if(t[a])return n("Tag",{props:{color:e.options.color[a]||"info"},domProps:{innerHTML:t[a]}});var i=e.options.defValue;return i||(i="异常"),n("Tag",i)}if(t[a])return n("div",t[a]);var s=e.options.defValue;return s||(s="异常"),n("div",s)}},parseSwitchCell:function(e){var t=e.key,n=this;e.render=function(r,a){return r("i-switch",{props:{value:e.options.codeTable[a.row[t]]||e.options.defValue||!1,size:"large"},on:{"on-change":function(t){n.$Modal.confirm({title:"确认操作",content:"该操作将会影响线上数据展示，您确认吗？",onOk:function(){n.$http.post(e.options.url,{id:a.row.id,key:e.key,status:t}).then(function(e){if(!s.a.checkResponse(e,n))return void n.search();n.$Notice.success({title:"操作成功",duration:5}),n.search()})},onCancel:function(){n.search()}})}}},[r("span",{slot:"open"},e.options.open),r("span",{slot:"close"},e.options.close)])}},onPageNoChange:function(e){this.pageNo=e,this.search()},onPageSizeChange:function(e){this.pageSize=e,this.search()},onSelectionChange:function(e){console.log(e),e&&e.length>0?this.showBatchDelete=!0:this.showBatchDelete=!1,this.selectedRows=e},openEditor:function(e,t){t||0===t?(this.selectedRow=t,this.id=this.result[this.selectedRow].id,this.$emit("on-open-editor",this.selectedRow,this.result[this.selectedRow])):(this.selectedRow=-1,this.id=-1,this.$emit("on-open-editor",this.selectedRow)),this.editMode=!0},clearAndSearch:function(){this.pageNo=1,this.search()},search:function(){var e=this;if(!this.searchUrl)return void this.$Notice.error({title:"查询失败",desc:"没有获取到搜索URL，请联系开发人员修复。",duration:5});this.loadingData=!0;var t=a.a.stringify(i.a.combinParams(this.params,this.queryParams,this));this.$http.get(this.searchUrl+"?"+t).then(function(t){if(e.loadingData=!1,console.log(t),s.a.checkResponse(t,e)){var n=t.data.data;e.result=n.data,e.totalSize=n.total,e.$emit("on-search",e.result),e.showBatchDelete=!1,e.selectedRows=[]}})},reset:function(){this.queryParams={}},remove:function(e,t,n){var r=this;this.$Modal.confirm({title:n&&n.title?n.title:"确认删除",content:n&&n.content?n.content:"删除数据将无法恢复，您确认删除吗？",onOk:function(){r.doRemove(e,t)}})},doRemove:function(e,t){var n=this,r=this;r.$http.delete(i.a.matchUrl(this.deleteUrl,{id:t.id})).then(function(e){s.a.checkResponse(e,n)&&(r.$Message.success({content:"删除成功",duration:5}),r.search())})},stop:function(e,t,n){var r=this;this.$Modal.confirm({title:n&&n.title?n.title:"确认停用",content:n&&n.content?n.content:"停用后可能会对线上数据产生影响，您确认停用吗？",onOk:function(){r.doStop(e,t)}})},doStop:function(e,t){var n=this,r=this;r.$http.post(i.a.matchUrl(this.stopUrl,{id:t.id})).then(function(e){s.a.checkResponse(e,n)&&(r.$Message.success({content:"停用成功",duration:5}),r.search())})},start:function(e,t,n){var r=this;this.$Modal.confirm({title:n&&n.title?n.title:"确认启用",content:n&&n.content?n.content:"启用后可能会对线上数据产生影响，您确认启用吗？",onOk:function(){r.doStart(e,t)}})},doStart:function(e,t){var n=this,r=this;r.$http.post(i.a.matchUrl(this.startUrl,{id:t.id})).then(function(e){s.a.checkResponse(e,n)&&(r.$Message.success({content:"启用成功",duration:5}),r.search())})},batchDelete:function(){var e=this;if(!this.selectedRows||this.selectedRows.length<=0)return void this.$Notice.warn({title:"没有指定需要删除的数据",duration:5});this.$Modal.confirm({title:"确认删除",content:"数据删除无法恢复，您确认删除吗?",onOk:function(){e.$emit("on-batch-delete",e.selectedRows)}})}},mounted:function(){this.search()},watch:{params:function(){this.reset(),this.search()}}}},shvd:function(e,t){},v1cs:function(e,t,n){"use strict";function r(e){n("1ygp")}var a=n("yfmx"),i=n("ouxa"),s=n("VU/8"),o=r,c=s(a.a,i.a,o,"data-v-75ccc752",null);t.a=c.exports},wrU5:function(e,t,n){"use strict";var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("Form",{ref:"formInline",staticClass:"queryForm",attrs:{model:e.queryParams,inline:""}},[e._l(e.filters,function(t){return n("FormItem",{key:t.key,attrs:{prop:t.name}},["text"===t.type?n("Input",{attrs:{type:"text",placeholder:t.name},model:{value:e.queryParams[t.key],callback:function(n){e.$set(e.queryParams,t.key,n)},expression:"queryParams[filter.key]"}}):"select"===t.type?n("Select",{attrs:{placeholder:t.name},model:{value:e.queryParams[t.key],callback:function(n){e.$set(e.queryParams,t.key,n)},expression:"queryParams[filter.key]"}},e._l(t.options.list,function(t){return n("Option",{key:t.key,attrs:{value:t.key}},[e._v(e._s(t.name))])})):e._e()],1)}),e._v(" "),n("FormItem",[e.showSearch?n("Button",{attrs:{type:"primary",loading:e.loadingData},on:{click:e.clearAndSearch}},[e._v("搜索")]):e._e(),e._v(" "),e.showNew?n("Button",{attrs:{type:"success"},on:{click:e.openEditor}},[e._v("新增")]):e._e(),e._v(" "),e._l(e.btns,function(t){return n("Button",{key:t.name,attrs:{type:t.type},on:{click:t.on}},[e._v(e._s(t.name))])}),e._v(" "),n("transition",{attrs:{name:"fade"}},[e.showBatchDelete?n("Button",{attrs:{type:"error"},on:{click:e.batchDelete}},[e._v("批量删除")]):e._e()],1)],2)],2),e._v(" "),n("pageable-table",{attrs:{loading:e.loadingData,col:e.col,data:e.result,totalSize:e.totalSize},on:{"on-change":e.onPageNoChange,"on-page-size-change":e.onPageSizeChange,"on-selection-change":e.onSelectionChange}})],1)},a=[],i={render:r,staticRenderFns:a};t.a=i},xJD8:function(e,t,n){"use strict";t.a={name:"app",data:function(){return{selectedItem:1}},computed:{menuActive:function(){var e=this.$route.path;return-1!==e.indexOf("mgr")?"mgr":-1!==e.indexOf("add")?"add":"userPermission"}},methods:{nav:function(e){switch(e){case"mgr":this.$router.push("/mgr");break;case"add":this.$router.push("/add");break;case"userPermission":this.$router.push("/userPermission")}}}}},yDvM:function(e,t){},yfmx:function(e,t,n){"use strict";var r=n("l1i1"),a=n("h+cV"),i=n("W7gV");t.a={name:"user-permission-view",components:{CommonMgr:a.a,UserPermissionEdit:i.a},data:function(){return{filters:[{name:"uid",key:"uid",type:"text"}],resultCol:[{title:"uid",key:"uid"},{title:"昵称",key:"nickname"},{title:"权限",key:"permission"},{title:"权限类型",key:"permissionType",type:"code",options:{codeTable:{1:"角色权限",2:"用户权限"}}},{title:"用户权限类型",key:"status",type:"code",options:{codeTable:{0:"追加",1:"屏蔽"},color:{0:"green",1:"red"},defValue:"普通"}},{title:"操作",key:"action",width:200,align:"center",type:"button",options:{data:[{name:"删除",type:"error",func:"delete",condition:function(e){return 1!==e.row.permissionType}}]}}],openEditor:!1}},methods:{onOpenEditor:function(){this.openEditor=!0},refresh:function(){this.$refs.userPermissionMgr.search()},buildData:function(){return this.roleType,{}},commitData:function(){var e=this;this.$refs.addForm.validate(function(t){t?e.id&&e.id>0?e.updateData():e.addData():e.$Message.error("表单验证失败!")})},updateData:function(){var e=this,t=this.buildData();e.$http.put("/user/update/"+this.roleType+"/"+this.id,t).then(function(t){r.a.checkResponse(t)&&e.$Message.success({content:"更新成功",duration:5})})},addData:function(){var e=this,t=this.buildData();e.$http.post("/user/add/"+this.roleType,t).then(function(t){r.a.checkResponse(t)&&e.$Message.success({content:"添加成功",duration:5})})},loadData:function(e){var t=this;e&&e>0&&t.$http.get("/user/seller/"+e).then(function(e){r.a.checkResponse(e)})}},watch:{$route:function(e,t){console.log("router changed"),this.loadData(e.params.uid),this.id=e.params.uid}},beforeRouteEnter:function(e,t,n){n(function(t){t.loadData(e.params.uid),t.id=e.params.uid})}}}},["NHnr"]);
//# sourceMappingURL=app.4a41ee89eb5f7d0d00d2.js.map