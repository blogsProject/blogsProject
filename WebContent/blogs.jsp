<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>blog</title>
<link rel="stylesheet" href="css/zerogrid.css">
<link rel="stylesheet" href="css/style.css">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/menu.css">
<script src="js/jquery1111.min.js" type="text/javascript"></script>
<script src="js/script.js"></script>
<link href="ueditor/themes/default/css/umeditor.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="ueditor/third-party/jquery.min.js"></script>
<script type="text/javascript" src="ueditor/third-party/template.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="ueditor/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="ueditor/umeditor.min.js"></script>
<script type="text/javascript" src="ueditor/lang/zh-cn/zh-cn.js"></script>
<style href="editor/themes/default/css/myeditor.css" type="text/css" rel="stylesheet"></style>
<link href="owl-carousel/owl.carousel.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
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
<script src="js/modernizr-2.6.2.min.js"></script>
<script type="text/javascript">
<c:if test="${empty page}">
location="index.jsp";
</c:if>
</script>
<script type="text/javascript">
function showdiv(targetid,objN){  
      var target=document.getElementById(targetid);
      var clicktext=document.getElementById(objN)
            if (target.style.display=="block"){
                target.style.display="none";
                clicktext.innerText="登录";
            } else {
                target.style.display="block";
                clicktext.innerText='登录';
            } 
}
 
</script>
<style>
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
 　　color:#999;
 　　
}
 　input:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
 　　color:#999;
 　　
}
 　　input::-moz-placeholder { /* Mozilla Firefox 19+ */
 　　color:#999;
 　　
}
 　　input:-ms-input-placeholder { /* Internet Explorer 10+ */
 　　color:#999;
 　　
}
.login {
	z-index: 9999;
}
.blogs{
position:absolute;
	background: #fff;
	height: 100%;
	width: 65%;
	margin-top: 0px;
	margin-left: 300px;
	padding:50px;
	padding-left:90px;
	border: 1px solid #d1d1d1;
	border-radius: 13px;
	text-align: left;
}
.blogs-title{
	text-align: left;
}
.blogs-info{
margin-left:40px;
margin-top:50px;
margin-right:40px;
	word-wrap:break-word;  
    word-break:break-all;  
    overflow: hidden;  
}
.read{
	margin-right: 20px;
}
	</style>
</head>
<body>


<div class="wrap-body">
<div style="position:fixed ;width: 100%" id='cssmenu' class="align-center">
  <ul>
    <li class="active"><a href='index.html'><span>主页</span></a></li>
    <li class=' last'><a href='photo.jsp'><span>相册</span></a></li>
    <li class=' last'><a href='File.jsp'><span>文件柜</span></a></li>
    <li class='last'><a href='Musc.html'><span>音乐</span></a></li>
    <li class='last'><a href='single.jsp'><span>个人资料</span></a></li>
    <li class='last'  style="margin-right: 10px;margin-left: 160px;"><a id="showtext" onClick="showdiv('contentid','showtext')"><span>登录</span></a></li>
    <li class='last' style="margin-right: 50px;"><a id="showtext" onClick="showdiv('contentid2','showtext')"><span>注册</span></a></li>
  </ul>
</div>
<div id="contentid" class="none">
  <form>
    <h4 style="margin-top: 10px;margin-left: 15px">登录</h4>
    <section> <span class="input input--isao">
      <input class="input__field input__field--isao" type="text" id="input-38" />
      <label class="input__label input__label--isao" for="input-38" data-content="用户名"> <span class="input__label-content input__label-content--isao">用户名</span> </label>
      </span> <span class="input input--isao">
      <input class="input__field input__field--isao" type="password" id="input-39" />
      <label class="input__label input__label--isao" for="input-39" data-content="密码"> <span class="input__label-content input__label-content--isao">密码</span> </label>
      </span>
      <input class="bootstrap-frm2" type="submit"value="登录">
    </section>
    
    <!--        <input type="submit" value="登录">-->
    
  </form>
</div>
<div id="contentid2" class="none">
  <form>
    <h4 style="margin-top: 10px;margin-left: 15px">注册</h4>
    <section> <span class="input input--isao">
      <input class="input__field input__field--isao" type="text" id="input-38" />
      <label class="input__label input__label--isao" for="input-38" data-content="用户名"> <span class="input__label-content input__label-content--isao">用户名</span> </label>
      </span> <span class="input input--isao">
      <input class="input__field input__field--isao" type="password" id="input-39" />
      <label class="input__label input__label--isao" for="input-39" data-content="密码"> <span class="input__label-content input__label-content--isao">密码</span> </label>
      </span> <span class="input input--isao">
      <input class="input__field input__field--isao" type="password" id="input-39" />
      <label class="input__label input__label--isao" for="input-39" data-content="再次输入密码"> <span class="input__label-content input__label-content--isao">再次输入密码</span> </label>
      </span> <span class="input input--isao">
      <input class="input__field input__field--isao" type="text" id="input-39" />
      <label class="input__label input__label--isao" for="input-39" data-content="昵称"> <span class="input__label-content input__label-content--isao">昵称</span> </label>
      </span> <span class="input input--isao">
      <input class="input__field input__field--isao" type="text" id="input-39" />
      <label class="input__label input__label--isao" for="input-39" data-content="真实姓名（可不填）"> <span class="input__label-content input__label-content--isao">真实姓名（可不填）</span> </label>
      </span>
      <section>
        <label>选择你的性别:</label>
        <div class="pretty circle">
          <input type="radio" name="radio1">
          <label><i class="default"></i> 男</label>
        </div>
        <div class="pretty circle">
          <input type="radio" name="radio1">
          <label><i class="default"></i> 女</label>
        </div>
      </section>
      <textarea  class="bootstrap-frm1" placeholder="个人简介（可不填）"></textarea>
      <input class="bootstrap-frm2" type="submit"value="注册">
    </section>
  </form>
</div>

<section id="container">
<div class="wrap-container">
<div id="main-content">
<div class="blogs">
<h2 class="blogs-title">标题</h2>
<hr>
<div class="blogs-info">
<p>ajksfhauksfhuioashfjkoahoiaosdaiosdhklafhuodyhfwehfiahDuifhiaseuidrfgakedfgUIdfioAsdiofhjiasdjifhiohedhfgoushdfgiosdgklhposirodghoidghioszodhgjozshdgojszhdogizhsldgjzosdioghzsjdbgozioshdfozshdfukgzsiedfguksedghfuoGedrfuiGefjhgIDUIfgIUdfgILDGfiuDGfiSDhfgUDsgkzsdgzshdgzdufzskdjlfgbksedhf</p>

</div>
<hr>
<div class="blogs-info">
李安鑫：
<br>
<p>asjklfhasjikfhauisfhuiaosfhjoashdoiuashdojahsfuioashfkljahsiufghoasuofaoisfhoaishfo</p>
<span class="read">时间：2017-01-01</span>
</div>
<hr>
<h3 class="blogs-title">评论</h2>
<form action="TestServlet" method="post">
		<textarea type="text/plain" id="myEditor" name="myEditor"
			style="width: 1000px; height: 240px;">
		</textarea>
		<input  class="bootstrap-frm2" type="submit" value="提交" />
	</form>
	<script type="text/javascript">
		
		var um = UM.getEditor('myEditor');
	</script>
</div>

 
  

<script src="owl-carousel/owl.carousel.js"></script> 
  <script>
		$(document).ready(function() {
		  $("#owl-slide").owlCarousel({
			autoPlay: 3000,
			items : 1,
			itemsDesktop : [1199,1],
			itemsDesktopSmall : [979,1],
			itemsTablet : [768, 1],
			itemsMobile : [479, 1],
			navigation: true,
			navigationText: ['<i class="fa fa-chevron-left fa-5x"></i>', '<i class="fa fa-chevron-right fa-5x"></i>'],
			pagination: false
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

				[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
					
					if( inputEl.value.trim() !== '' ) {
						classie.add( inputEl.parentNode, 'input--filled' );
					}
					
					inputEl.addEventListener( 'focus', onInputFocus );
					inputEl.addEventListener( 'blur', onInputBlur );
				} );

				function onInputFocus( ev ) {
					classie.add( ev.target.parentNode, 'input--filled' );
				}

				function onInputBlur( ev ) {
					if( ev.target.value.trim() === '' ) {
						classie.remove( ev.target.parentNode, 'input--filled' );
					}
				}
			})();
		</script> 


































<script src="js/jquery.min.js"></script> 
<script src="js/jquery.waypoints.min.js"></script> 
<script src="js/jquery.magnific-popup.min.js"></script> 
<script src="js/salvattore.min.js"></script> 
<script src="js/photomain.js"></script>
</html>