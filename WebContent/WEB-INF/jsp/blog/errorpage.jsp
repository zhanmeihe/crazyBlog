<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html> -->

<!--[if IE 6]><html class="ie lt-ie8"><![endif]-->
<!--[if IE 7]><html class="ie lt-ie8"><![endif]-->
<!--[if IE 8]><html class="ie ie8"><![endif]-->
<!--[if IE 9]><html class="ie ie9"><![endif]-->
<!--[if !IE]><!--> <html> <!--<![endif]-->

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta property="wb:webmaster" content="294ec9de89e7fadb" />
     
    <!-- Apple -->
    <meta name="apple-mobile-web-app-title" content="疯狂博客">

    <title>页面不存在 - 疯狂博客</title>

    <style type="text/css" media="all" rel="stylesheet">
      a {
        color: #333333;
        cursor: pointer;
        text-decoration: none;
      }
      a:hover, a:focus {
        color: #2F2F2F;
        text-decoration: none;
      }
      a:focus {
        outline: none;
      }
      .error-page-logo {
        position: absolute;
        left: 40px;
        top: 40px;
        width: 300px;
      }
      .error {
        width: 100%;
        max-width: 1440px;
        margin: 0 auto;
        text-align: center;
      }
      .error-block {
        padding-top: 80px;
        padding-bottom: 20px;
      }
      .main-img {
        width: 220px;
      }
      h3 {
        margin: 40px 0 20px 0;
        font-weight: bold;
      }
      .sub-title {
        margin: 10px 0 30px 0;
        font-size: 14px;
      }
      .sub-title a {
        color: #3194D0;
      }
      .follow {
        padding: 13px 0;
        width: 160px;
        font-size: 15px;
        border-radius: 40px;
        color: #ffffff;
        background-color: #42C02E;
        border-color: #42C02E;
        display: inline-block;
        text-align: center;
        vertical-align: middle;
        touch-action: manipulation;
        cursor: pointer;
        background-image: none;
        border: 1px solid transparent;
        white-space: nowrap;
        user-select: none;
      }
      .follow:hover, .follow:focus {
        color: #ffffff;
        background-color: #28A014;
        border-color: #28A014;
      }
      .error-footer {
        margin-top: 40px;
        border-top: 1px solid #F0F0F0;
      }
      .part {
        float: left;
        width: 33%;
        padding: 30px 0;
      }
      .part:nth-child(2) {
        border-left: 1px solid #F0F0F0;
        border-right: 1px solid #F0F0F0;
      }
      .part:last-child {
        padding: 20px 0;
      }
      .res-warp {
        display: inline-block;
      }
      .res-warp img {
        margin-right: 15px;
        width: 80px;
        height: 80px;
        vertical-align: middle;
      }
      .res-warp .app, .res-warp .weibo {
        width: auto;
        height: 60px;
      }
      .info {
        padding-top: 10px;
        text-align: left;
        vertical-align: middle;
        display: inline-block;
      }
      .info {
        font-size: 14px;
      }
      .info p {
        font-size: 12px;
        color: #9B9B9B;
      }
      @media (max-width: 768px) {
        .error-page-logo, .error-footer {
          display: none;
        }
      }
    </style>

    <link href="<%=request.getContextPath()%>/images/logo.ico"
	rel="shortcut icon" type="image/x-icon">
 
    <!-- Start of 访问统计 -->
      <script>
    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "//hm.baidu.com/hm.js?0c0e9d9b1e7d617b3e6842e85b9fb068";
      var s = document.getElementsByTagName("script")[0];
      s.parentNode.insertBefore(hm, s);
    })();
  </script>

    <!-- End of 访问统计 -->
  </head>
  <body lang="zh-CN" class="reader-black-font">
    <!-- <a href="/">
      <img class="error-page-logo" src="https://cdn2.jianshu.io/assets/web/error_p_logo-4a543c8ed828256afa97a62fbea4c186.png" alt="Error p logo" />
</a>  -->   <div class="error">
      <div class="error-block">
  <!-- <img class="main-img" src="https://cdn2.jianshu.io/assets/web/img_404-80cb554db22104d39ab89692e9ebfdb8.png" alt="Img 404" /> -->
  <h3>您要找的页面不存在</h3>
  <div class="sub-title">可能是因为您的链接地址有误、该文章已经被作者删除或转为私密状态。</div>
  <a class="follow" href="<%=request.getContextPath()%>">返回「疯狂博客」首页</a>
</div>

        <div class="error-footer">
<!--           <div class="part">
            <div class="res-warp"><img class="app" src="https://cdn2.jianshu.io/assets/web/error_p_app-52706219fcf58ae658cd9f68c7610bad.png" alt="Error p app" /></div>
            <div class="info">
              <a href="/apps">免费下载简书手机app ›</a>
              <p>创作你的创作</p>
            </div>
          </div>
          <div class="part">
            <div class="res-warp"><img class="weibo" src="https://cdn2.jianshu.io/assets/web/error_p_weibo-a35a5ab1702131fd77afc11ad608c40b.png" alt="Error p weibo" /></div>
            <div class="info">
              <a href="http://weibo.com/jianshuio">关注简书官方微博 ›</a>
              <p>看看大家的精彩创作</p>
            </div>
          </div>
          <div class="part">
            <div class="res-warp"><img src="https://cdn2.jianshu.io/assets/web/qrcode_wechat-55114be8bccc3bccb1ae76a6d3dd10e9.png" alt="Qrcode wechat" /></div>
            <div class="info">
              关注简书官方微信
              <p>每天为你推送精选文章</p>
            </div>
          </div> -->
        </div>
    </div>
    <script>
  (function(){
      var bp = document.createElement('script');
      var curProtocol = window.location.protocol.split(':')[0];
      if (curProtocol === 'https') {
          bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';
      }
      else {
          bp.src = 'http://push.zhanzhang.baidu.com/push.js';
      }
      var s = document.getElementsByTagName("script")[0];
      s.parentNode.insertBefore(bp, s);
  })();
</script>

  </body>
</html>
