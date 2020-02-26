<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		#a div{
			margin-bottom: 75px;
	
		}
			
		#a div span{
		font-size: 20px;
		color: #008000;
		}
	</style>
</head>
<body>

	<body>
			<h1 style="color: #008000;">个人资料 </h1>
			<br>
			 
		<div id="a">
			<div><span>昵称:  ${fileList.u_name}</span></div>
			<div><span>ID: ${fileList.u_email}</span></div>
			<div><span>注册时间:  ${fileList.u_registertime}</span></div>
			<div><span>金币数:  ${fileList.u_money}</span></div>
			</div>
	</body>
</html>