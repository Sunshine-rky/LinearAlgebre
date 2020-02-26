<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="SendEmailServlet" method="post">
邮箱号<input type="text" name="email" >
<br>
<input type="submit" value="发送验证码">
</form>
<form action="RegisterServlet" method="post">
请填入接受到的验证码<input type="text" name="code">
<br>
姓名<input type="text" name="name">
<br>
密码<input type="password" name="password">
<br>
<input type="submit" value="注册"> 

</form>
</body>
</html>