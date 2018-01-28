<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/common.jspf"%>
</head>

<body>
	<div style="padding: 0px; margin: 0px;">
		<ul class="breadcrumb" style="margin: 0px;">
			<li><a href="#">招生管理</a></li>
			<li>学员池</li>
		</ul>
	</div>
	<form
		action="${pageContext.request.contextPath}/recruitstudent/studentpool/list.action"
		method="post" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">

			<div class="form-group">
				<label class="" for="activename">学员姓名：</label> <input type="email"
					class="form-control" id="activename" placeholder="请输入学员姓名">
			</div>

			<input type="button" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success"
				href="${pageContext.request.contextPath}/recruitstudent/studentpool/loadAdd.action">添加学员</a>
		</div>

		<!-- 提示信息区域 -->
		<div align="center">
			<div class="alert alert-warning"
				style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span>
				</button>
				<p align="center" style="color: red;">学生信息-${info}</p>
			</div>
		</div>

		<div class="row" style="padding: 15px; padding-top: 0px;">
			<display:table class="table  table-condensed table-striped"
				name="list" pagesize="10"
				requestURI="${pageContext.request.contextPath}/recruitstudent/studentpool/list.action">
				<display:column property="studentId" title="学生编号"></display:column>
				<display:column property="staffId" title="负责人编号（姓名）"></display:column>
<%-- 学生池是非正式学员 没有班级	<display:column property="classId" title="班级编号（名字）"></display:column> --%>
				<display:column property="studentName" title="学生姓名"></display:column>
				<display:column property="studentSex" title="性别"></display:column>
				<display:column property="studentAge" title="年龄"></display:column>
				<display:column property="studentTellphone" title="手机号码"></display:column>
				<display:column property="studentEmail" title="邮箱"></display:column>
				<display:column property="studentIdcard" title="身份证号码"></display:column>
				<display:column property="studentAddress" title="地址"></display:column>
				<display:column property="studentBirthday" title="生日" format="{0,date,yyy年MM月dd日}"></display:column>
				<display:column property="studentSchool" title="学校"></display:column>
				<display:column property="studentQq" title="qq"></display:column>
				<display:column property="studentParentsName" title="父母名字"></display:column>
				<display:column property="studentParentsPhone" title="父母手机号码"></display:column>
				<display:column property="studentPro" title="所在省份"></display:column>
				<display:column property="studentProCity" title="所在城市"></display:column>
				<display:column property="studentType" title="类型"></display:column>
				<display:column property="studentIspay" title="是否缴费"></display:column>
				<display:column property="studentState" title="学生意向"></display:column>
				<display:column property="studentMark" title="学生标记"></display:column>
				<display:column property="studentDesc" title="学生描述"></display:column>
				<display:column property="studentNumber" title="学生帐号"></display:column>
				<display:column property="studentPassword" title="学生密码"></display:column>
				<display:column
					href="${pageContext.request.contextPath }/recruitstudent/studentpool/loadUpdate.action"
					paramId="studentId" paramProperty="studentId" value="修改"
					title="修改"></display:column>
				<display:column
					href="${pageContext.request.contextPath }/recruitstudent/studentpool/loadUpdateMark.action"
					paramId="studentId" paramProperty="studentId" value="领取学生"
					title="修改"></display:column>
				<display:column
					href="${pageContext.request.contextPath }/recruitstudent/studentpool/delete.action"
					paramId="studentId" paramProperty="studentId" value="删除"
					title="删除"></display:column>
			</display:table>
		</div>
		</div>
	</form>
</body>
</html>
