<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/common.jspf"%>
</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">招生管理</a></li>
			<li>试听记录</li>
		</ul>
	</div>

	<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
		<form class="form-inline" action="${pageContext.request.contextPath}/recruitstudent/auditionInfo/list.action">
			<div class="form-group">
				<label class="" for="activename">学员姓名：</label> 
				<input type="email" class="form-control" id="activename" placeholder="请输入学员姓名">
			</div>
			<div class="form-group">
				<label class="auditionCourse" for="activename">试听课程：</label> 
				<input type="email" class="form-control" id="activename" placeholder="请输入试听课程">
			</div>
			<input type="button" class="btn btn-danger" value="查询" /> 
			<input type="button" class="btn btn-success" value="添加纪录" 
			onclick="javascript:window.location='${pageContext.request.contextPath }/view/recruitstudent/auditionInfo/auditioninfo_add.jsp'">
		</form>
	</div>
	
	<!-- 提示信息区域 -->
	<div align="center">
		<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>
			</button>
			<p align="center" style="color: red;">试听记录信息-${info}</p>
		</div>	
	</div>
	
	<div class="row" style="padding: 15px; padding-top: 0px;">
		<display:table class="table  table-condensed table-striped"
			name="list" pagesize="10"
			requestURI="${pageContext.request.contextPath}/recruitstudent/auditionInfo/list.action">
			<display:column property="" title="试听记录编号"></display:column>
			<display:column property="" title="学生编号（姓名）"></display:column>
			<display:column property="" title="试听课程"></display:column>
			<display:column property="" title="试听日期"></display:column>
			<display:column property="" title="试听地点"></display:column>
			<display:column property="" title="试听描述"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/recruitstudent/auditionInfo/load.action"
				paramId="auditionId" paramProperty="auditionId" value="修改"
				title="修改"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/recruitstudent/auditionInfo//delete.action"
				paramId="auditionId" paramProperty="auditionId" value="删除"
				title="删除"></display:column>
		</display:table>
	</div>
</body>
</html>
