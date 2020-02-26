<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="uploadServlet" method="post"enctype="multipart/form-data">
选择文件<input type="file" name="file">
<br>
设置金币<input type="text" name="m_money" >
<br>
<input type="submit" value="提交">

</form>

</body>
</html>