<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>

<div class="wrap">
        <div class="container">
            <h1>Welcome</h1>
            <form action="LoginServlet" method="post">
                <input type="text" placeholder="用户名" name="u_name"/>
                 <input type="text" placeholder="邮箱" name="u_email"/>
                <input type="password" placeholder="密码" name="u_password"/>
                
                <input type="submit" value="登录"/>
            </form>
        </div>
        <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</body>
</html>

