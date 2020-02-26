<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <body id='questions-index'>
   <!-- <script src="//csdnimg.cn/release/ask/assets/common_body-45edd7971b65ad2667d43c09fa0f50b1.js"></script> -->
       <link href="css/qa1.css" media="screen" rel="stylesheet" />
<div class="news-nav">
  <div class="container clearfix">
    <div class="nav-bar">
   
      <a class="" href="#">问答主页</a>
		   
  
      <a href="askQuestion.jsp" class="ask_tips_box" target="_blank" onclick="return check_user_status()">我要提问</a>
		<a class="" href="FindMyAllQuestionServlet">我的问答</a>
		   </div>
  
  </div>
</div>


       <div class="main clearfix">
          <div style="margin-bottom: 10px;">
            <!-- 页顶广告 -->
            
          </div>

          

         
          <link href="css/qa2.css" media="screen" rel="stylesheet" />
<link href="css/qa3.css" media="screen" rel="stylesheet" />



  <c:forEach var="afile" items="${fileList}">

        <div class="questions_detail_con">
  <div class="q_time">
    <span>${afile.q_time}</span>
    <a class="user_name" href="https://my.csdn.net/DJCBPL" target="_blank">${afile.u_name}</a>
  <b>悬赏
        <a href="javascript:;" title="个人悬赏">
         ${afile.q_money}
        </a>
      </b>

  </div>
  <dl>
    <h1>
      <a href="ShowQuestionDetail?resPath=${afile.q_title}" target="_blank">${afile.q_title}</a>
    </h1>
    <dd>
     ${afile.q_content}
    </dd>
  </dl>
  <div class="tags">
<a href="/questions/tags/search?id=scss" target="_blank">${afile.q_state}</a>
</div>
  <a class="answer_num "
     title="暂无满意答案"
     target="_blank" href="/questions/1055185#answer_form">
    <span>${afile.a_number}</span>
    <p>回答</p>
  </a>

</div>
  </c:forEach>

</body>
</html>