<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html >
<head>
<meta charset="utf-8">
<title>Blog</title>
<meta name="description" content="Free Responsive Html5 Css3 Templates ">
<meta name="author" content="#">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no"  >
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" >
<meta name="HandheldFriendly" content="true">

<script src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/zerogrid.css">
<link rel="stylesheet" href="css/style.css">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/menu.css">
<script src="js/jquery1111.min.js" type="text/javascript"></script>
<script src="js/script.js"></script>
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
<!-- ----- -->
<script type="text/javascript">
<c:if test="${empty page}">
location="index.jsp";
</c:if>
</script>
<script type="text/javascript">
 var userisexits=false;
 function checkuserexits() {
	$.ajax({
		url:"UserController",
		type:"post",
		data:{
			flag:"checkUsername",
			username:document.getElementById("username").value
		},
		success : function (data) {
		if(data == 3){
			alert("用户名不能为空！");
		}else if(data!=1){
			alert("用户名已存在");
			userisexits=true;
		}
		}
	});
	}
	function test() {
		var password1 = document.getElementById("password1").value;
		var password2 = document.getElementById("password2").value;
		 if(password1==null||password2==null){
			 window.alert("密码不能为空");
			 return false;
		 }else if(password1 != password2) {
			 window.alert("您输入的新密码与确认密码确认不一致");
			signupForm.repassword.focus();
			return false;
		}
		
		return true;
	}

	function checkName() {
		var Uname = document.getElementById("username").value;
		
		if ((Uname).length == 0) {
			alert("请输入用户名");
			Uname.focus();
			return false;
		} else {
			return true;
		}
	}
	function checknetname() {
		var netname = document.getElementById("netname").value;
		
		if ((netname).length == 0) {
			alert("请输入昵称");
			netname.focus();
			return false;
		} else {
			return true;
		}
	}

	
	function submitcheck() {
		if(test()){
			alert("两次输入密码不一致");
		}else if(checkName()){
			alert("用户名不能为空");
		}else if(checknetname()){
			alert("昵称不能为空");
		}else if(userisexits){
			alert("用户名已存在！");
		}else{
			document.regeistform.onsubmit();
		}
	}
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

@media (min-width: 1366px) {
#contentid {
	background: #FFFFFF;
	position: absolute;
	margin-top: 30px;
	margin-left: 900px;
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
	margin-top: 30px;
	margin-left: 900px;
	width: 350px;
	height: 900px;
	max-height: 900px;
	max-width: 350px;
	border: 1px solid #CCC;
	border-radius: 10px;
	z-index: 999;
	padding: 5px;
}
.rizhi{
position:absolute;
		height: 700px;
		width: 690px;	
		max-width:690px;
margin-left:200px;
text-align:left;
		padding-left: 90px;
		padding-top: 30px;
		padding-bottom: 40px;
		border: 1px solid #d1d1d1;
		border-radius: 10px;
		background: #fff;
	}
	.rizhi1{
		margin-top: 20px;
		padding: 20px;
	}
	.news{
	margin-bottom: 20px;
	}
	
	.ph{
	position:absolute;
		height: 600px;
		width: 300px;	
		margin-top:0px;
margin-left:1020px;
text-align:left;
		padding-left: 90px;
		padding-top: 30px;
		padding-bottom: 40px;
		border: 1px solid #d1d1d1;
		border-radius: 10px;
		
	}
		#write{
		margin-top:0px;
		width: 100px;
		height: 70px;
		margin-left: 1020px;
	}
	.page{
position:absolute;
margin:740px 420px;
		width: 200px;
		height: 30px;
		
	}

  }
@media (min-width: 1920px) {
 #contentid {
	background: #FFFFFF;
	position: absolute;
	margin-top: 30px;
	margin-left: 1400px;
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
	margin-top: 30px;
	margin-left: 1400px;
	width: 350px;
	height: 900px;
	max-height: 900px;
	max-width: 350px;
	border: 1px solid #CCC;
	border-radius: 10px;
	z-index: 999;
	padding: 5px;
}
.login {
	z-index: 9999;
}
	.rizhi{
		height: 100%;
		width: 800px;	
margin-left:540px;
text-align:left;
		padding-left: 90px;
		padding-top: 30px;
		padding-bottom: 40px;
		border: 1px solid #d1d1d1;
		border-radius: 10px;
		
	}
	.rizhi1{
		margin-top: 20px;
		padding: 20px;
	}
	.news{
	margin-bottom: 20px;
	}
	
	.ph{
	position:absolute;
		height: 400px;
		width: 300px;	
margin-left:1400px;
text-align:left;
		padding-left: 90px;
		padding-top: 30px;
		padding-bottom: 40px;
		border: 1px solid #d1d1d1;
		border-radius: 10px;
		
	}
	#write{
		width: 100px;
		height: 70px;
		margin-left: 1400px;
	}

  }


  


body {

}
#showtext {
	cursor: hand;
	cursor: pointer;
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

</style>
</head>

<body>
<div class="wrap-body">
<div  id='cssmenu' class="align-center">
  <ul>
    <li class="active"><a href='index.jsp'><span>主页</span></a></li>
    <c:if test="${!empty user }">
    <li class=' last'><a href='photo.jsp'><span>相册</span></a></li>
    <li class=' last'><a href='FilesController?flag=all'><span>文件柜</span></a></li>
    <li class='last'><a href="Musc.html"><span>音乐</span></a></li>
    <li class='last'><a href='single.jsp'><span>个人资料</span></a></li>
    </c:if>
    <c:if test="${empty user }">
    <li class='last'  style="margin-right: 10px;margin-left: 160px;"><a id="showtext" onClick="showdiv('contentid','showtext')"><span>登录</span></a></li>
    <li class='last' style="margin-right: 50px;"><a id="showtext" onClick="showdiv('contentid2','showtext')"><span>注册</span></a></li>
    </c:if>
      <c:if test="${!empty user }">
       <li class='last'  style="margin-right: 10px;margin-left: 160px;"><a id="showusername" ><span>${user.username }</span></a></li>
        <li class='last' style="margin-right: 50px;"><a id="shownetname" ><span>${user.netname }</span></a></li>
      </c:if>
  </ul>
</div>
<div id="contentid" class="none">
  <form action="UserController" method="post">
    <h4 style="margin-top: 10px;margin-left: 15px">登录</h4>
    <section> <span class="input input--isao">
      <input name="username"  class="input__field input__field--isao" type="text" id="input-38" />
      <label class="input__label input__label--isao" for="input-38" data-content="用户名"> <span class="input__label-content input__label-content--isao">用户名</span> </label>
      </span> <span class="input input--isao">
      <input name="password"  class="input__field input__field--isao" type="password" id="input-39" />
      <label class="input__label input__label--isao" for="input-39" data-content="密码"> <span class="input__label-content input__label-content--isao">密码</span> </label>
      </span>
      <input type="hidden" name="flag" value="login"/> 
      <input class="bootstrap-frm2" type="submit"value="登录">
    </section>
  </form>
</div>

<div id="contentid2" class="none">
  <form name="regeistform" action="UserController"  method="post">
  <input type="hidden" name="flag" value="regeist" >
    <h4 style="margin-top: 10px;margin-left: 15px">注册</h4>
    <section> <span class="input input--isao">
      <input name="username" id="username"  onblur="checkuserexits()" class="input__field input__field--isao" type="text" id="input-38" />
      <label class="input__label input__label--isao" for="input-38" data-content="用户名"> <span class="input__label-content input__label-content--isao">用户名</span> </label>
      </span> <span class="input input--isao">
      <input name="password" id="password1"  class="input__field input__field--isao" type="password" id="input-39" />
      <label class="input__label input__label--isao" for="input-39" data-content="密码"> <span class="input__label-content input__label-content--isao">密码</span> </label>
      </span> <span class="input input--isao">
      <input  id="password2" class="input__field input__field--isao" type="password" id="input-39" />
      <label class="input__label input__label--isao" for="input-39" data-content="再次输入密码"> <span class="input__label-content input__label-content--isao">再次输入密码</span> </label>
      </span> <span class="input input--isao">
      <input name="netname" id="netname" class="input__field input__field--isao" type="text" id="input-39" />
      <label class="input__label input__label--isao" for="input-39" data-content="昵称"> <span class="input__label-content input__label-content--isao">昵称</span> </label>
      </span> <span class="input input--isao">
      <input name="relname" id="relname" class="input__field input__field--isao" type="text" id="input-39" />
      <label class="input__label input__label--isao" for="input-39" data-content="真实姓名（可不填）"> <span class="input__label-content input__label-content--isao">真实姓名（可不填）</span></label>
      </span>
      <section>
        <label>选择你的性别:</label>
        <div class="pretty circle">
          <input  type="radio" name="gender" checked="checked">
          <label><i class="default"></i>男</label>
        </div>
        <div class="pretty circle">
          <input type="radio" name="gender">
          <label><i class="default"></i>女</label>
        </div>
      </section>
      <textarea  class="bootstrap-frm1" placeholder="个人简介（可不填）"></textarea>
      <input name="about" class="bootstrap-frm2" type="button"   onclick="submitcheck()"  value="注册">
    </section>
  </form>
</div>



<header class="">
  <div class="logo">
    <hr class="line-1">
    <a >Blogs</a> <span>Write your life！</span>
    <hr class="line-1">
  </div>

<!--  
  <div id="owl-slide" class="owl-carousel">
    <div class="item"> <img src="images/1.jpg" /> </div>
    <div class="item"> <img src="images/2.jpg" /> </div>
    <div class="item"> <img src="images/3.jpg" /> </div>
  </div>
-->
</header>
<section id="container">
<div class="wrap-container">
<div id="main-content">
<!-- 日志 -->
<div class="rizhi">
<c:forEach items="${AlllogList}" var="log">
<div class="rizhi1">
<a href="#"><h3 class="news" >${log.ltitle }</h3></a>
作者:${log.uname }  阅读数:${log.readnum }  发表时间:${log.ltime }
</div>
</c:forEach>
</div>

</div>

<!-- 分页 -->
<div  class="page">
<c:choose>
<c:when test="${page.curpage-1 <= 0 }"> 
 上一页
</c:when>
<c:otherwise>
<a href="LogController?flag=home&curpage=${page.curpage-1 }">上一页</a>
</c:otherwise>
  </c:choose> |
  <c:choose>
   <c:when test="${page.curpage+1 >= page.allPage }"> 
 下一页
</c:when>
<c:otherwise>
<a href="LogController?flag=home&curpage=${page.curpage+1 }">下一页</a>
</c:otherwise>
  </c:choose>
  </div>
  <div id="write">
  <a href="write.jsp"><button style="margin: 0 80px;" class="bootstrap-frm2" >发表日志</button></a>
  </div>
  <div class="ph">
    <h3>排行</h3>
<c:forEach items="${AlllogList}" var="log">
<div class="rizhi1">
<a href="#"><h2 class="news" >${log.ltitle }</h2></a>
</div>
</c:forEach>
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
</body>
</html>