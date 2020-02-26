<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <link href="css/qa4.css" media="screen" rel="stylesheet" />
    <link href="css/qa5.css" media="screen" rel="stylesheet" />
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
          <a class="bds_more" href="javascript:;" style="height:30px;line-height:30px; padding-left:0;margin:0px;background:none" data-cmd="more">分享</a>
       
        </div>


        <span class="interval">|</span>
          <a class="collection question_comment" id='collection_1055092' href="javascript:;">评论0</a>

        <span class="interval">|</span>
         
			<a class="collection" data-bind-collection="true" rel="nofollow" title="收藏" style="cursor: pointer;">
				收藏
			</a>
<!--
-->

        <span class="interval">|</span>
        <a class="collection" href="javascript:;">浏览21</a>

          <span class="interval interval_no">|</span>
          
        <a class="browse report" data-method="post" data-remote="true" href="/questions/1055092/report" rel="nofollow" title="举报">举报</a>



        <span class="interval">|</span>
        <div class="thumb-box">
          <span class="thumb-up" data-item-id="1055092" data-like-type="question" data-do-type="up"></span>
          <em>0</em>
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
  <p>${fileList.a_number}</p>
  <div class="sort_style operate_style">
    <div class="sort_label">
          未排序
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
        <a href="/questions/1055092?sort=votes_count">按赞数排序</a>
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

        <a class="collection" href="AcceptQuestionServlet?resPath=${afile.u_email}&resPath1=${afile.q_title}" id='collection_1252204'>
          采纳
        </a>


        <span class="interval interval_no">|</span>
        
        <a class="browse report" data-method="post" data-remote="true" href="/answers/1252204/report" rel="nofollow" title="举报">举报</a>



      <span class="interval">|</span>
      <div class="thumb-box">
        <span class="thumb-up" data-item-id="1252204" data-like-type="answer" data-do-type="up"></span>
        <em>0</em>
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




       

<dl class="answer_form_con">
  <form accept-charset="UTF-8" action="AnswerQuestionServlet" class="new_answer" id="answer_form" method="post"><div style="display:none"><input name="utf8" type="hidden" value="&#x2713;" /><input name="authenticity_token" type="hidden" value="YyWhN3W6NZtDHo8voNEC4cEPBlqJwDJF5UDvD5V9o5Y=" /></div>
    <input id="answer_question_id" name="answer[question_id]" type="hidden" value="1055092" />
    <input id="answer_from_type" name="answer[from_type]" type="hidden" value="ask_channels" />
    <dt style="padding-top:20px;">
      <img alt="3 weixin 44003176" src="//profile.csdnimg.cn/6/5/6/3_weixin_44003176" style="width:30px; height:30px;" />
    </dt>
    <dd class="form_textarea" style="position:relative;">
      <div class="cm_box">
        <div class='cm_dialog'></div>
        <div class="pop_cm cm_add_link" style="z-index: 10001;">
          <input type="text" placeholder="链接内容" id="af_cm_link_txt">
          <input type="text" placeholder="链接地址" id="af_cm_link_url">
          <input type="text" placeholder="链接提示" id="af_cm_link_tit">
          <div class="text-right">
            <span class="btn btn-default btn-sm" id="add_link_btn">插入链接</span>
          </div>
        </div>
        <div class='pop_cm cm_add_img' style="z-index: 10001;">
          <div class='nav-tabs'>
            <a class='img_tab active' href='#answer_tab_upload'>本地上传</a>
            <a class='img_tab' href='#answer_tab_weburl'>网络图片</a>
          </div>
          <div class='tab_panel active' id='answer_tab_upload'>
            <div class='up_img_loading'>上传中...</div>
            <div class='set_img'>
              <div class='markdown_file_name'></div>
              <label for='markdown_file'>浏览</label></div>
            <div class='markdown_file_msg'></div>
            <div class='text-right'><span class='btn btn-default btn-sm' onclick='ajaxFileUploadToQiniu("editor_question");'>上传图片</span> </div>
          </div>
          <div class='tab_panel' id='answer_tab_weburl'>
            <input type='text' placeholder='图片地址' id='af_cm_img_url'>
            <input type='text' placeholder='图片说明' id='af_cm_img_alt'>
            <div class='text-right'><span class='btn btn-default btn-sm' id='add_img_btn'>插入图片</span> </div>
          </div>
        </div>
      </div>
      <textarea id="editor_question" name="answer[body]" rows="4">
</textarea>
    </dd>
    <dd class="form_submit">
      <input type="hidden" value="${fileList.q_title}" name="q_title" />
      <input type="submit" value="我要回答" class="form_submit_btn" id="form_submit_btn">
    </dd>
    <dd class="point_arrow"></dd>
</form>  <div style="color: red;margin-top: 12px;">
    抄袭、复制答案，以达到赚金币分或其他目的的行为，在问答是严格禁止的,一经发现立刻封号。是时候展现真正的技术了！
  </div>
</dl>




    
  </body>




</html>