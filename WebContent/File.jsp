<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>file</title>
<link rel="stylesheet" href="css/zerogrid.css">
<link rel="stylesheet" href="css/style.css">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="css/menu.css">
<script src="js/jquery1111.min.js" type="text/javascript"></script>
<script src="js/script.js"></script>
<link href="owl-carousel/owl.carousel.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" />
<link rel="stylesheet" type="text/css" href="css/normalize1.css" />
<link rel="stylesheet" type="text/css" href="css/demo1.css" />
<link rel="stylesheet" type="text/css" href="css/cs-select.css" />
<link rel="stylesheet" type="text/css" href="css/cs-skin-rotate.css" />
<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
<link rel="stylesheet" type="text/css" href="css/pretty.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/salvattore.css">
<link rel="stylesheet" href="css/photostyle.css">
<link rel="stylesheet" type="text/css" href="./css/uploadify.css">
<script src="./js/jquery.uploadify.min.js" type="text/javascript"></script>
<script src="./js/modernizr-2.6.2.min.js"></script>

<c:if test="${empty user}">
	<script type="text/javascript">
		alert("请先登录");
		location = "index.jsp";
	</script>
</c:if>
<script type="text/javascript">
	function showdiv(targetid, objN) {
		var target = document.getElementById(targetid);
		var clicktext = document.getElementById(objN)
		if (target.style.display == "block") {
			target.style.display = "none";
			clicktext.innerText = "登录";
		} else {
			target.style.display = "block";
			clicktext.innerText = '登录';
		}
	}
</script>

<style>
@media ( min-width :1366px) {
	.photo {
		position: absolute;
		width: 300px;
		height: 600px;
		margin-left: 80px;
		margin-right: 700px;
		border: 1px solid #d1d1d1;
		border-radius: 13px;
		overflow: auto;
	}
	.music {
		float: left;
		width: 300px;
		height: 600px;
		margin-left: 700px;
		margin-right: 60px;
		border: 1px solid #d1d1d1;
		border-radius: 13px;
		overflow: auto;
	}
	.fridend1 {
		margin-top: 20px;
		padding: 20px;
	}
	.div-file {
		position: relative;
		height: 850px;
		width: 80%;
		margin: 0 auto;
		background: #fff;
		padding-top: 50px;
		border: 1px solid #d1d1d1;
		border-radius: 13px;
	}
	.fileup {
		width: 200px;
		margin: 0 auto;
	}
}

@media ( min-width :1920px) {
	.div-file {
		position: relative;
		height: 850px;
		width: 70%;
		margin: 0 auto;
		background: #fff;
		padding-top: 50px;
		border: 1px solid #d1d1d1;
		border-radius: 13px;
	}
	.fileup {
		width: 200px;
		margin: 0 auto;
	}
	.photo {
		position: absolute;
		width: 500px;
		height: 600px;
		margin-left: 80px;
		margin-right: 700px;
		border: 1px solid #d1d1d1;
		border-radius: 13px;
		overflow: auto;
	}
	.music {
		float: left;
		width: 500px;
		height: 600px;
		margin-left: 700px;
		margin-right: 60px;
		border: 1px solid #d1d1d1;
		border-radius: 13px;
		overflow: auto;
	}
	.fridend1 {
		margin-top: 20px;
		padding: 20px;
	}
}

body {
	
}

#showtext {
	cursor: hand;
	cursor: pointer;
}

#contentid {
	background: #FFFFFF;
	position: absolute;
	margin-top: 60px;
	margin-left: 1500px;
	width: 350px;
	height: 400px;
	max-height: 400px;
	max-width: 350px;
	border: 1px solid #CCC;
	border-radius: 10px;
	z-index: 999;
	padding: 5px;
}

#contentid2 {
	background: #FFFFFF;
	position: absolute;
	margin-top: 60px;
	margin-left: 1500px;
	width: 350px;
	height: 900px;
	border: 1px solid #CCC;
	border-radius: 10px;
	z-index: 999;
	padding: 5px;
}

.none {
	display: none;
	　background: #FFFFFF;
}

.bootstrap-frm1 {
	margin-left: auto;
	margin-right: auto;
	height: 100%;
	width: 100%;
	background: #FFF;
	padding: 20px 30px 20px 30px;
	font: 12px "Helvetica Neue", Helvetica, Arial, sans-serif;
	color: #888;
	text-shadow: 1px 1px 1px #FFF;
	border: 1px solid #DDD;
	border-radius: 10px;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
}

.bootstrap-frm2 {
	margin-left: 110px;
	margin-top: 20px;
	height: 50px;
	width: 120px;
	background: #FFF;
	text-align: center;
	font: 18px "Helvetica Neue", Helvetica, Arial, sans-serif;
	color: #888;
	text-shadow: 1px 1px 1px #FFF;
	border: 1px solid #DDD;
	border-radius: 10px;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
}

input {
	width: 200px;
	height: 30px;
	padding: 5px;
	font-size: 15px;
}

input>submit {
	height: 40px;
}

input::-webkit-input-placeholder { /* WebKit browsers */
	　　color: #999;
	　　
}

　input:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
	　　color: #999;
	　　
}

　　input::-moz-placeholder { /* Mozilla Firefox 19+ */
	　　color: #999;
	　　
}

　　input:-ms-input-placeholder { /* Internet Explorer 10+ */
	　　color: #999;
	　　
}

.login {
	z-index: 9999;
}

.news {
	margin: 20px;
}
</style>
</head>
<body>


	<div class="wrap-body">
		<div style="position: fixed; width: 100%" id='cssmenu'
			class="align-center">
			<ul>
				<li class="active"><a href='index.jsp'><span>主页</span></a></li>
				<li class=' last'><a href='photo.jsp'><span>相册</span></a></li>
				<li class=' last'><a href='File.jsp'><span>文件柜</span></a></li>
				<li class='last'><a href='Musc.html'><span>音乐</span></a></li>
				<li class='last'><a href='single.jsp'><span>个人资料</span></a></li>
			</ul>
		</div>
		<section id="container">
			<div class="wrap-container">
				<div id="main-content">
					<div class="div-file">
						<div class="music">
							<h2>音乐</h2>
							<c:if test="${empty musiclist }">
							<h2>还没有上传音乐，请上传</h2>
							</c:if>
							<c:forEach items="${musiclist }" var="music">
							<div class="friend1">
								<a href="FilesController?flag=download&type=flase&fid=${music.fid }"><h4 class="news">${music.fname }</h4></a>
							</div>
							</c:forEach>
							
						</div>


						<div class="photo">
							<h2>照片</h2>
							<c:if test="${empty imglist }">
							<h2>还没有上传图片，请上传</h2>
							</c:if>
							<c:forEach items="${imglist }" var="img">
							<div class="friend1">
								<a href="FilesController?flag=download&type=flase&fid=${img.fid }"><h4 class="news">${img.fname }</h4></a>
							</div>
							</c:forEach>
							
						</div>
						<div style="margin: 0 auto" class="fileup">
							<form action="" method="get" enctype="multipart/form-data">

								<input type="file" name="file"> <input
									class="bootstrap-frm2" type="submit" value="上传">

							</form>
						</div>
					</div>




					<script src="owl-carousel/owl.carousel.js"></script>
					<script>
						$(document)
								.ready(
										function() {
											$("#owl-slide")
													.owlCarousel(
															{
																autoPlay : 3000,
																items : 1,
																itemsDesktop : [
																		1199, 1 ],
																itemsDesktopSmall : [
																		979, 1 ],
																itemsTablet : [
																		768, 1 ],
																itemsMobile : [
																		479, 1 ],
																navigation : true,
																navigationText : [
																		'<i class="fa fa-chevron-left fa-5x"></i>',
																		'<i class="fa fa-chevron-right fa-5x"></i>' ],
																pagination : false
															});
										});
					</script>
					<script src="js/classie.js"></script>
					<script>
						(function() {

							if (!String.prototype.trim) {
								(function() {

									var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
									String.prototype.trim = function() {
										return this.replace(rtrim, '');
									};
								})();
							}

							[].slice
									.call(
											document
													.querySelectorAll('input.input__field'))
									.forEach(
											function(inputEl) {

												if (inputEl.value.trim() !== '') {
													classie.add(
															inputEl.parentNode,
															'input--filled');
												}

												inputEl.addEventListener(
														'focus', onInputFocus);
												inputEl.addEventListener(
														'blur', onInputBlur);
											});

							function onInputFocus(ev) {
								classie.add(ev.target.parentNode,
										'input--filled');
							}

							function onInputBlur(ev) {
								if (ev.target.value.trim() === '') {
									classie.remove(ev.target.parentNode,
											'input--filled');
								}
							}
						})();
					</script>
					<script src="js/jquery.min.js"></script>
					<script src="js/jquery.waypoints.min.js"></script>
					<script src="js/jquery.magnific-popup.min.js"></script>
					<script src="js/salvattore.min.js"></script>
					<script src="js/photomain.js"></script>
					<script type="text/javascript">
						function set() {
							$(".uploadify")
									.each(
											function(i) {
												var index = $(this).attr("id");
												$(this).uploadify({
																	debug : false,
																	swf : 'js/uploadify.swf', //swf文件路径
																	method : 'post', // 提交方式
																	uploader : 'ProcessUpload', // 服务器端处理该上传请求的程序(servlet, struts2-Action)
																	preventCaching : true, // 加随机数到URL后,防止缓存
																	buttonCursor : 'hand', // 上传按钮Hover时的鼠标形状
																	//	buttonImage		: 'img/.....png',	// 按钮的背景图片,会覆盖文字
																	buttonText : '请选择图片', //按钮上显示的文字，默认”SELECTFILES”
																	height : 30, // 30 px
																	width : 120, // 120 px
																	fileObjName : 'filedata', //文件对象名称, 即属性名
																	fileSizeLimit : 10000, // 文件大小限制, 100 KB
																	fileTypeDesc : 'any', //文件类型说明 any(*.*)
																	fileTypeExts : '*.jpg;*.png;*.mp3;*.ogg', // 允许的文件类型,分号分隔
																	formData : {
																		'id' : '1',
																		'name' : 'myFile'
																	}, //指定上传文件附带的其他数据。也动态设置。可通过getParameter()获取
																	multi : true, // 多文件上传
																	progressData : 'speed', // 进度显示, speed-上传速度,percentage-百分比	
																	queueID : 'fileQueue',//上传队列的DOM元素的ID号
																	queueSizeLimit : 99, // 队列长度
																	removeCompleted : false, // 上传完成后是否删除队列中的对应元素
																	removeTimeout : 10, //上传完成后多少秒后删除队列中的进度条, 
																	requeueErrors : true, // 上传失败后重新加入队列
																	uploadLimit : 20, // 最多上传文件数量
																	successTimeout : 30,//表示文件上传完成后等待服务器响应的时间。超过该时间，那么将认为上传成功。
																	// 在文件被移除出队列时触发	
																	//onCancel : function(file) { alert( 'The file ' + file.name + ' was cancelled!' ); },
																	// 在调用cancel方法且传入参数’*’时触发
																	//onClearQueue : function (queueItemCount) { alert( queueItemCount + ' files were removed from the queue!' ); },
																	// 打开文件对话框 关闭时触发
																	onDialogClose : function(
																			queueData) {
																		/*	alert(
																				"文件对话窗口中选了几个文件:" + queueData.filesSelected + "---" +
																				"队列中加了几个文件:" + queueData.filesQueued + "---" +
																				"队列中被替换掉的文件数:" + queueData.filesReplaced + "---" +
																				"取消掉的文件数:" + queueData.filesCancelled + "---" + 
																				"上传出错的文件数:" + queueData.filesErrored
																			); */
																	},

																	// 选择文件对话框打开时触发
																	onDialogOpen : function() { /*alert( 'please select files' ) */
																	},
																	// 没有兼容的FLASH时触发
																	onFallback : function() {
																		alert('Flash was not detected!')
																	},
																	// 每次初始化一个队列时触发, 即浏览文件后, 加入一个队列
																	//onInit : function (instance) { alert( 'The queue ID is ' + instance.settings.queueID ) },
																	// 上传文件处理完成后触发（每一个文件都触发一次）, 无论成功失败
																	//onUploadComplete : function(file){ alert( 'The file ' + file.name + ' uploaded finished!' ) },
																	// 上传文件失败触发
																	onUploadError : function(
																			file,
																			errorCode,
																			errorMsg,
																			errorString) {
																		/*
																		alert(
																		    file.name + ' upload failed! ' + 
																		    'errorCode: ' + errorCode +
																		    'errorMsg:' + errorMsg +
																		    'errorString:' + errorString
																		);*/
																	},

																	// 在每一个文件上传成功后触发
																	onUploadSuccess : function(file,data,response) {
																		alert(/*file.name + ' is uploaded succeed!  ' +
																		'  server-side returned data:' + data +
																		'  response: ' + response*/'文件上传成功');
																					}

																});
											});
						}
						$(function() {
							set();
						});
					</script>
</html>