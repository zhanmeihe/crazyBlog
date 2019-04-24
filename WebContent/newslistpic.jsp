<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="gb2312">
<title>个人博客之――江南墨卷</title>
<meta name="keywords" content="个人博客之――江南墨卷" />
<meta name="description" content="个人博客之――江南墨卷" />
<link href="css/base.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<div id="wrapper">
<header>
  <div class="headtop"></div>
  <div class="contenttop">
    <div class="logo f_l">个人博客之――江南墨卷</div>
    <div class="search f_r">
      <form action="/e/search/index.php" method="post" name="searchform" id="searchform">
        <input name="keyboard" id="keyboard" class="input_text" value="请输入关键字" style="color: rgb(153, 153, 153);" onfocus="if(value=='请输入关键字'){this.style.color='#000';value=''}" onblur="if(value==''){this.style.color='#999';value='请输入关键字'}" type="text">
        <input name="show" value="title" type="hidden">
        <input name="tempid" value="1" type="hidden">
        <input name="tbname" value="news" type="hidden">
        <input name="Submit" class="input_submit" value="搜索" type="submit">
      </form>
    </div>
    <div class="blank"></div>
    <nav>
      <div  class="navigation">
        <ul class="menu">
          <li><a href="index.jsp">网站首页</a></li>
          <li><a href="#">关于我</a>
            <ul>
              <li><a href="about.jsp">个人简介</a></li>
              <li><a href="listpic.jsp">个人相册</a></li>
            </ul>
          </li>
          <li><a href="#">我的日记</a>
            <ul>
              <li><a href="newslistpic.jsp">个人日记</a></li>
              <li><a href="newslistpic.jsp">学习笔记</a></li>
            </ul>
          </li>
          <li><a href="newslistpic.jsp">技术文章</a> </li>
          <li><a href="#">给我留言</a> </li>
        </ul>
      </div>
    </nav>
    <SCRIPT type=text/javascript>
	// Navigation Menu
	$(function() {
		$(".menu ul").css({display: "none"}); // Opera Fix
		$(".menu li").hover(function(){
			$(this).find('ul:first').css({visibility: "visible",display: "none"}).slideDown("normal");
		},function(){
			$(this).find('ul:first').css({visibility: "hidden"});
		});
	});
</SCRIPT> 
  </div>
</header>
<div class="container">
  <div class="con_content">
    <div class="about_box">
      <h2 class="nh1"><span>您现在的位置是：<a href="/" target="_blank">网站首页</a>>><a href="#" target="_blank">个人日记</a></span><b>个人日记</b></h2>
      <div class="dtxw box">
        <li>
          <div class="dttext f_l">
            <ul>
              <h2><a href="/">个人博客之――江南墨卷</a></h2>
              <p>个人博客之――江南墨卷个人博客之――江南墨卷个人博客之――江南墨卷原汁原味重现经典....</p>
              <span>2017-3-10</span>
            </ul>
          </div>
          <div class="xwpic f_r"><a href="/"><img src="images/02.jpg"></a></div>
        </li>
        <li>
          <div class="dttext f_l">
            <ul>
              <h2><a href="/">个人博客之――江南墨卷</a></h2>
              <p>个人博客之――江南墨卷个人博客之――江南墨卷广安领先....</p>
              <span>2017-3-10</span>
            </ul>
          </div>
          <div class="xwpic f_r"><a href="/"><img src="images/01.jpg"></a></div>
        </li>
        <li>
          <div class="dttext f_l">
            <ul>
              <h2><a href="/">个人博客之――江南墨卷</a></h2>
              <p>个人博客之――江南墨卷个人博客之――江南墨卷个人博客之――江南墨卷原汁原味重现经典....</p>
              <span>2017-3-10</span>
            </ul>
          </div>
          <div class="xwpic f_r"><a href="/"><img src="images/03.jpg"></a></div>
        </li>
        <li>
          <div class="dttext f_l">
            <ul>
              <h2><a href="/">个人博客之――江南墨卷</a></h2>
              <p>个人博客之――江南墨卷个人博客之――江南墨卷个人博客之――江南墨卷原汁原味重现经典</p>
              <span>2017-3-10</span>
            </ul>
          </div>
          <div class="xwpic f_r"><a href="/"><img src="images/04.jpg"></a></div>
        </li>
        <li>
          <div class="dttext f_l">
            <ul>
              <h2><a href="/">个人博客之――江南墨卷</a></h2>
              <p>个人博客之――江南墨卷个人博客之――江南墨卷个人博客之――江南墨卷原汁原味重现经典</p>
              <span>2017-3-10</span>
            </ul>
          </div>
          <div class="xwpic f_r"><a href="/"><img src="images/02.jpg"></a></div>
        </li>
        <li>
          <div class="dttext f_l">
            <ul>
              <h2><a href="/">个人博客之――江南墨卷</a></h2>
              <p>个人博客之――江南墨卷个人博客之――江南墨卷个人博客之――江南墨卷原汁原味重现经典</p>
              <span>2017-3-10</span>
            </ul>
          </div>
          <div class="xwpic f_r"><a href="/"><img src="images/06.jpg"></a></div>
        </li>
      </div>
      <div class="pagelist">页次：1/1 每页25 总数10<a href="/">首页</a><a href="/">上一页</a><a href="/">下一页</a><a href="/">尾页</a></div>
    </div>
  </div>
  <div class="blank"></div>
  <!-- container代码 结束 -->
  
  <footer>
    <div class="footer">
      <div class="f_l">
        <p>All Rights Reserved 版权所有：<a href="http://www.focode.cn">占美和个人博客</a> 备案号：蜀ICP备00000000号</p>
      </div>
      <div class="f_r textr">
        <p>Design by DanceSmile</p>
      </div>
    </div>
  </footer>
</div>
</body>
</html>