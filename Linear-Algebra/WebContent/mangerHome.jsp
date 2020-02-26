<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>线性代数网站</title>
<link rel="stylesheet" href="css/userHome.css" type="text/css">
</head>
<body>
<nav class="navbar fixed-top navbar-toggleable-md navbar-light sb-navbar">
<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarExample" aria-controls="navbarExample" aria-expanded="false" aria-label="Toggle navigation">
<i class="fa fa-bars"></i>
</button>
<div class="container">

<div class="collapse navbar-collapse" id="navbarExample">
<ul class="navbar-nav mr-auto">
<li class="nav-item">
<a class="nav-link" href="ShowAllQuestion" title="问答功能"><i class="icon-home"></i> 欢迎您</a>
</li>
<li class="nav-item">
<a class="nav-link" href="ShowDownServlet" title="上传下载"><i class="icon-graduation"></i>我的管理员 </a>
</li>
</ul>
<ul class="navbar-nav">
<li class="nav-item">
<a class="nav-link" href="ShowMy" data-toggle="modal" data-target="#searchModal"><i class="icon-magnifier"></i></a>
</li>
</ul>
</div>
</div>
</nav>

<header>
<section>
<div class="container">
<div class="row">
<div class="col-lg-12">
<ol class="breadcrumb">

<li class="breadcrumb-item active"><h1 class="toolname">线性代数网站后台</h1></li>
</ol>
</div>
</div>
</div>
</section>
</header>
<section class="new">
<div class="container">

<div class="row" id="toollist">

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">审核问答</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math8.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a></p>
</div>
<div class="card-footer">
<a href="ShowAllCheckQuestionServlet" class="btn btn-secondary">开始工作</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">检查问答</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math2.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a></p>
</div>
<div class="card-footer">
<a href="ShowAllQuestionMangerServlet" class="btn btn-secondary">开始工作</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">人员管理</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math3.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a></p>
</div>
<div class="card-footer">
<a href="ManagerShowAllUser" class="btn btn-secondary">开始工作</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">算法管理</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math1.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a></p>
</div>
<div class="card-footer">
<a href="MangerShowAllFile" class="btn btn-secondary">开始工作</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">查看日志</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math6.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a></p>
</div>
<div class="card-footer">
<a href="MangerLog1" class="btn btn-secondary">开始工作</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">清空日志</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math5.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a></p>
</div>
<div class="card-footer">
<a href="MangerLogClean" class="btn btn-secondary">一键清除</a>
</div>
</div>
</div>


</section>

</body>
</html>