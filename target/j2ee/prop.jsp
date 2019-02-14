<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<!--  attr操作的是页面的标签<select name="city" aaa="111">-->
	<!--  prop操作标签对应的DOM对象    document.getElementById("xx").bbb= yy-->
	
	<!-- 
			哪些属性可以使用attr？
			哪些属性可以使用prop？查询DHTML文档，获取可以操作的属性，推荐是prop操作属性而不是attr
	 -->
	城市：
	<select name="city" aaa="111">
		<option value="北京">北京</option>
		<option value="上海">上海</option>
		<option value="广州">广州</option>
	</select>
	
	<br><br>
	分别使用attr和prop设置select标签的一个不存在的属性，要求设置的属性名相同，但值不同，
	然后分别使用attr和prop获取设置的值，例如：用attr设置abc=123，用prop设置abc=456<br/><br/>
	分别使用attr和prop设置下拉框的value和selectedIndex
	
</body>
</html>