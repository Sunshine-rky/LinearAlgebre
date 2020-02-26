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
				width: 1200px;
			/* 	border: #000000 1px solid; */
				
				/* border-bottom: #008000 solid 1px; */
			}
			#a #b{
				font-size: 25px;
				margin-left:50px;
				margin-bottom: 10px;
				
			}
			#a #c{
				font-size: 14px;
			}
			#a #c span{
				margin-right: 150px;
			}
			
		</style>
	</head>
	<body>
		<h1><a href="upsuccess.jsp" style="color: #4CAE4C;text-decoration:none">
		我要上传</a></h1>
		<br />
	<c:forEach var="afile" items="${fileList}">
		<div id="a">
			<div id="b">${afile.m_name}</div>
			<div id="c">
				<span>上传时间:  ${afile.m_time}</span>
				
				<span>上传者:  ${afile.u_name}</span>
				<span>所需金币： ${afile.m_money}</span>
				<span style="font-size: 20px;"> <a href="downloadServlet?resPath=${afile.m_name}&resPath1=${afile.m_money}" style="color: #4CAE4C;text-decoration:none">下载</a></span>
			</div>
			
		</div>
		  </c:forEach>
	</body>
</html>