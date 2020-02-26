<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
				
			span{
				font-size: 20px;
				margin-left: 15px;
				
				}
					
				span a{
					color: #4CAE4C;
					text-decoration:none;
				}
				
				#upp{
					height: 40px;
					width: 1000px;
					}
					#upp #up span{
						font-size: 16px;
						margin-left: 40px;
						color: #4CAE4C;
					}
			#a{
				height: 40px;
				width: 1000px;
			/* 	border: #000000 1px solid; */
				/* position: absolute; */
				/* border-bottom: #008000 solid 1px; */
			}
			
			
			#a #c span{
				margin-right: 40px;
				font-size: 13px;
			}
			
		</style>
	</head>
	<body>
		<span><a href="1.html" style="color: #4CAE4C;text-decoration:none">
		登录注册
		</a><span>
		<span><a href="MangerLog3" style="color: #4CAE4C;text-decoration:none">
		在线运算
		</a><span>
		<span><a href="MangerLog2" style="color: #4CAE4C;text-decoration:none">
		上传下载
		</a><span>
		<span><a href="MangerLog4" style="color: #4CAE4C;text-decoration:none">
		用户问答
		</a><span>
		<br />
		<br />
		<div id="upp">
	<div id="up">
		
		<span>用户名</span>
		<span>用户邮箱</span>
		<span>用户行为</span>
		<span>操作时间</span>
		<span>所属模块</span>
	</div>
	</div>
	<c:forEach var="afile" items="${fileList}">
		<div id="a">
			<div id="c">
				<span>${afile.u_name}</span>
				
				<span>${afile.u_email}</span>
				<span>${afile.l_behavior}</span>
			     <span>${afile.l_time}</span>
			     <span>${afile.l_modular}</span>
			</div>
			
		</div>
  </c:forEach>
</body>
</html>