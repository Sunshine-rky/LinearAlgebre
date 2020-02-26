<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
		#a div{
			margin-bottom: 20px;
			height: 35px;
		}
			
		h2 	span{
			margin: 25px;
		}
		#a div span{
			margin-left: 75px;
		font-size: 18px;
		color: #008000;
		}
	</style>
	<body>
		
			<h2 style="color: #008000;"><span>编辑</span> <span><a href="upsuccess.jsp" style="color: #008000; text-decoration: none;">上传</a></span></h2>
		 <c:forEach var="afile" items="${fileList}">
		<div id="a">
			<div><span><a href="MangerAlterFileServlet?resPath=${afile.name}" style="color: #008000; text-decoration: none;">${afile.name}</a></span>  <span><a href="MangerDeleteServlet?resPath=${afile.name}" style="color: #008000; text-decoration: none;">删除</a></span></div>
			
			</div>
			  </c:forEach>
	</body>
</html>