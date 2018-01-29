<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<li>招生线索</li>
		</ul>
	</div>
	<form class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 3px;">

			<div class="form-group">
				<label class="" for="activename">学员姓名：</label> <input type="email"
					class="form-control" id="activename" placeholder="请输入学员姓名">
			</div>
			<div class="form-group">
				<label class="" for="activename">学员意向：</label> <select
					name="studentState" class="form-control input-sm">
					<option>无意向</option>
					<option>意向低</option>
					<option>意向中</option>
					<option>意向高</option>
				</select>
			</div>
			<input type="button" class="btn btn-danger" value="查询" /> <a
				class="btn btn-success" href="recruitstudent_add.jsp">添加学员</a>

		</div>
		<div class="row" style="padding: 15px; padding-top: 0px;">
			<table class="table  table-condensed table-striped">
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>手机号码</th>
					<th>电子邮件</th>
					<th>所在院校</th>
					<th>操作</th>
				</tr>
				<tr>
					<td>1001</td>
					<td>猪八戒</td>
					<td>男</td>
					<td>18</td>
					<td>152xxxxxxxx</td>
					<td>xxxx@qq.com</td>
					<td>社会大学</td>
					<th><a href="recruitstudent_update.jsp">修改</a> <a href="">删除</a>

					</th>
				</tr>
				<tr>
					<td>1001</td>
					<td>猪八戒</td>
					<td>男</td>
					<td>18</td>
					<td>152xxxxxxxx</td>
					<td>xxxx@qq.com</td>
					<td>社会大学</td>
					<th><a href="recruitstudent_update.jsp">修改</a> <a href="">删除</a>

					</th>
				</tr>
				<tr>
					<td>1001</td>
					<td>猪八戒</td>
					<td>男</td>
					<td>18</td>
					<td>152xxxxxxxx</td>
					<td>xxxx@qq.com</td>
					<td>社会大学</td>
					<th><a href="recruitstudent_update.jsp">修改</a> <a href="">删除</a>

					</th>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
