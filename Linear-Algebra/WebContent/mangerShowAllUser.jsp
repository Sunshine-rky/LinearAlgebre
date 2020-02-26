<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
			#a{
				height: 100px;
				width: 1000px;
			/* 	border: #000000 1px solid; */
				/* position: absolute; */
				/* border-bottom: #008000 solid 1px; */
			}
			#a #b{
				font-size: 25px;
				margin-left:20px;
				margin-bottom: 10px;
				
			}
			#a #c{
				font-size: 14px;
			}
			#a #c span{
				margin-right: 20px;
			}
			
		</style>
	</head>
	<body>
		<h1><a href="#" style="color: #4CAE4C;text-decoration:none">
		人员管理</a></h1>
		<br />
	  <c:forEach var="afile" items="${user}">
		<div id="a">
			<div id="b">用户名：${afile.u_name}</div>
			<div id="c">
				<span>用户邮箱:${afile.u_email}</span>
				<span>用户密码: ${afile.u_password}</span>
				
				<span>用户注册时间: ${afile.u_registertime}</span>
				<span>用户金币数：${afile.u_money}</span>
				<span style="font-size: 20px;"> <a href="MangerDelectUser?resPath=${afile.u_email}" style="color: #4CAE4C;text-decoration:none">删除</a></span>
			</div>
			
		</div>
		
		
		
		  </c:forEach>
</body>
</html>