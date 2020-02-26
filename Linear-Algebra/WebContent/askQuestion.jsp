<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AskQuestionServlet" method="post">
问题标题<input type="text" name="q_title"/>
<br>
问题内容
<br>
<textarea rows="20" cols="40"  name="q_content"></textarea>

<br>
悬赏<input type="text" name="q_money"/>
<br>
<input type="submit" value="提交"/>
</form>
</body>
</html>