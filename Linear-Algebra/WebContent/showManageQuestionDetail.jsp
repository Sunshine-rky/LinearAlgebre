<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body id='questions-show'>
   
       



        <div class="main clearfix">
          <div style="margin-bottom: 10px;">
            <!-- 页顶广告 -->
            
          </div>

          

          
        
<link href="css/qa6.css" media="screen" rel="stylesheet" />






<div class="persion_section">
  <div class="common_con clearfix">
    <div class="questions_detail_con">
      <dl>
        <dt>
         ${fileList.q_title}
            <b>
              <a title="个人悬赏" href="javascript:;">${fileList.q_money}</a>
            </b>
        </dt>
        <dd>
          <p>${fileList.q_content}</p>
        </dd>

        <!-- liwz modified at 20181009 start -->
        <dd class="ask_date">
          <label class="ask_edit_wrap">

               
              <span class="ask_edit">编辑于：${fileList.q_time}</span>
           
          </label>
        </dd>
        <div class="tags">
          
<a href="/questions/tags/search?id=r%E8%AF%AD%E8%A8%80" target="_blank">${fileList.q_state}</a>


        </div>
      </dl>


      <div class="share_bar_con share_bar_con_01" id="question_1055092">
        <div class="share bdsharebuttonbox bdshare-button-style0-16" data-bd-bind="1432880054358">
          <a class="DelectQuestionAndItsAnswerServlet?resPath=${fileList.q_title}" href="javascript:;" style="height:30px;line-height:30px; padding-left:0;margin:0px;background:none" data-cmd="more">删除</a>
       
        </div>


        <span class="interval"></span>
          <a class="collection question_comment" id='collection_1055092' href="javascript:;"></a>

        <span class="interval"></span>
         
			<a class="collection" data-bind-collection="true" rel="nofollow" title="收藏" style="cursor: pointer;">
				
			</a>
<!--
-->

        <span class="interval"></span>
        <a class="collection" href="javascript:;"></a>

          <span class="interval interval_no"></span>
          
        <a class="browse report" data-method="post" data-remote="true" href="/questions/1055092/report" rel="nofollow" title="举报"></a>



        <span class="interval"></span>
        <div class="thumb-box">
          <span class="thumb-up" data-item-id="1055092" data-like-type="question" data-do-type="up"></span>
          <em></em>
        </div>
       

        <dl class="ask_head">
          <dt>
            <a href="https://my.csdn.net/weixin_43698411" target="_blank"><img alt="2 weixin 43698411" class="csdn-avatar50" src="//profile.csdnimg.cn/5/F/B/2_weixin_43698411" style="width:35px; height:35px;" title="weixin_43698411" username="weixin_43698411" /></a>
          </dt>
          <dd>
            <h5 style="margin-bottom: 5px;">
              <a class="user_name" href="https://my.csdn.net/weixin_43698411" target="_blank">${fileList.u_name}</a>
            </h5>
            <p>
              <span>声望：</span>
              <em>2</em>
            </p>
          </dd>
        </dl>

      </div>

     


    </div>

    
  </div>

  <div class="common_con clearfix">
      <!-- 查看全部功能因百度SEO 暂时去掉 -->
          <div class="answer_sort_con  q_operate">
  <p>${fileList.a_number}个回答</p>
  <div class="sort_style operate_style">
    <div class="sort_label">
      
      <i class="icon-caret-down"></i>
    </div>
    <ul>
      <li>
        <a href="/questions/1055092?sort=id">时间排序</a>

      </li>
      <li>
        <a href="/questions/1055092?sort=comments_count">评论数排序</a>

      </li>
      <li>
        <a href="/questions/1055092?sort=votes_count">未排序</a>
      </li>
      <li class="arrow"></li>
    </ul>
  </div>
</div>



  
<c:forEach var="afile" items="${list}">

<div class="answer_list">
    <div class="answer_detail_con" id='answer_1252204'>
    <div style="margin: 0 20px 10px;font-size: 14px;color: #666;line-height: 24px;word-break: break-all;word-wrap: break-word;">
      <p>
      ${afile.a_content}
      </p>
    </div>

    <div class="ask_date">
      <label class="ask_edit_wrap">
          <span class="ask_ask">发布于：${afile.a_time}</span>
      </label>
    </div>

    <div class="share_bar_con share_bar_con_01 clearfix">

        <a class="collection" href="DelectAnswerServlet?resPath=${afile.a_content}" id='collection_1252204'>
      	   删除
        </a>


        <span class="interval interval_no"></span>
        
        <a class="browse report" data-method="post" data-remote="true" href="/answers/1252204/report" rel="nofollow" title="举报"></a>



      <span class="interval"></span>
      <div class="thumb-box">
        <span class="thumb-up" data-item-id="1252204" data-like-type="answer" data-do-type="up"></span>
        <em></em>
      </div>



      <dl class="ask_head">
        <dt>
          <a href="https://my.csdn.net/caozhy" target="_blank"><img alt="caozhy" src="//profile.csdnimg.cn/D/C/C/3_caozhy" style="width:35px; height:35px;" username="caozhy" /></a>
        </dt>
        <dd>
          <h5>
            <a class="user_name" href="https://my.csdn.net/caozhy" target="_blank">${afile.u_name}</a>&nbsp;&nbsp;
          </h5>
          <p>
            <span>声望：</span>
            <em>342710</em>
          </p>
        </dd>
      </dl>
    </div>
  </div>

   </c:forEach>




       


</body>
</html>