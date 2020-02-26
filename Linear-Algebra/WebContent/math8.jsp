<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
function displayResult(){
	var textareaContents = $('#textareaContents').val();
	$.ajax({
		//发送请求的地址
		url:"Math8Servlet",
		//请求方式，默认为get
		type:"post",
		//预期服务器返回的数据类型。如果不指定自动根据MIME类型返回信息
		//dataType:"text",
		//发送到服务器的数据
		/*data:{
			sno:$("#sno").val(),
			sname:$("#sname").val(),
			sage:$("#sage").val(),
			sdept:$("#sdept").val()
		},*/
		//还可以提交整个form表单，注意表单参数的id和name相同
		data:{a:textareaContents},//第一个textareaContents值文本框的Id，用jquery方式的AJAX提交，这个Id必须要
		//请求成功后回调函数，参数为服务器返回的数据
		success:function(data){
			
			var result= eval("("+ data + ")");	
			$("#myInput").html("计算结果"+result);
		},
		//请求失败时调用的函数
		error:function(){
			alert("处理异常");
		}
	});
}
</script>
</head>
<body>
    <img src="img/2.png" width="600px";height="600px"/>
		<br />
	<textarea rows="20" cols="40" id="textareaContents" name="a">
	
	</textarea>
	<button type="button" onclick="displayResult()">求特征值</button>
	<p><span id="myInput"></span></p>
</body>
</html>