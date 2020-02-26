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
<a class="nav-link" href="ShowAllQuestion" title="问答功能"><i class="icon-home"></i> 问答功能</a>
</li>
<li class="nav-item">
<a class="nav-link" href="ShowDownServlet" title="上传下载"><i class="icon-graduation"></i>上传下载 </a>
</li>
</ul>
<ul class="navbar-nav">
<li class="nav-item">
<a class="nav-link" href="ShowMy" data-toggle="modal" data-target="#searchModal"><i class="icon-magnifier"></i> 我</a>
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

<li class="breadcrumb-item active"><h1 class="toolname">线性代数</h1></li>
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
<h4 class="card-title">特征值计算</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math8.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a>本工具可以快速特在线计算特征值</p>
</div>
<div class="card-footer">
<a href="math8.jsp" class="btn btn-secondary">开始使用</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">解线性方程组</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math2.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a>可解出N阶方程组，用高斯消元法</p>
</div>
<div class="card-footer">
<a href="math2.jsp" class="btn btn-secondary">开始使用</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">矩阵加法和乘法</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math3.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a>矩阵加法和乘法运算</p>
</div>
<div class="card-footer">
<a href="math3.jsp" class="btn btn-secondary">开始使用</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">行列式求值</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math1.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a>这里用了深度搜索的算法实现</p>
</div>
<div class="card-footer">
<a href="math1.jsp" class="btn btn-secondary">开始使用</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">求矩阵的秩</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math6.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a>照初等行变换原则把原来的矩阵变换为阶梯型矩阵，总行数减去全部为零的行数即非零的行数就是矩阵的秩了。</p>
</div>
<div class="card-footer">
<a href="math6.jsp" class="btn btn-secondary">开始使用</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">实现逆矩阵</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math5.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a>逆矩阵一定是方阵</p>
</div>
<div class="card-footer">
<a href="math5.jsp" class="btn btn-secondary">开始使用</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">线性相关的判断</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math7.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a>根据方程组的个数与秩个数进行判断</p>
</div>
<div class="card-footer">
<a href="math7.jsp" class="btn btn-secondary">开始使用</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">矩阵的转置</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="math4.jsp">
<img class="card-img-top img-fluid" src="img/6.png">
</a>实现矩阵的转置</p>
</div>
<div class="card-footer">
<a href="math4.jsp" class="btn btn-secondary">开始使用</a>
</div>
</div>
</div>

<div class="col-lg-4 col-md-6 sb-preview text-center">
<div class="card h-100">
<div class="card-block">
<h4 class="card-title">判断两个矩阵是否相似</h4>
<p class="card-text"><a style="float:left;" class="sb-preview-img" href="#">
<img class="card-img-top img-fluid" src="img/6.png">
</a>没实现判断两个矩阵是否相似</p>
</div>
<div class="card-footer">
<a href="#" class="btn btn-secondary">开始使用</a>
</div>
</div>
</div>





</div>




</div>
</section>

</body>
</html>