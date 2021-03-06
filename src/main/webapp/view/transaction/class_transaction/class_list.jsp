<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<li><a href="#">教务管理</a></li>
			<li>班级事务</li>
		</ul>
	</div>
	<script type="text/javascript">
		function query(condition) {
			$("#keyword").attr("name", condition.value);
		}
	</script>
	<!-- 显示错误信息 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 100%;display:${empty allErrors?'none':'block'} ">
			<c:forEach items="${allErrors}" var="error">
			 	${error.defaultMessage }<br />
			</c:forEach>
		</div>
	</div>

	<div class="row alert alert-info" style="margin: 0px; padding: 3px;">
		<form
			action="${pageContext.request.contextPath}/transaction/class_transaction/list.action"
			method="post" class="form-horizontal">
			<div class="col-sm-3" style="margin-left: 200px">
				<select class="form-control  input-sm" onchange="query(this)"
					name="condition">
					<option value="">请选择</option>
					<option value="classroomId">教室编号</option>
					<option value="classroomName">教室名称</option>
				</select>
			</div>
			<div class="col-sm-3">
				<input type="text" id="keyword" class="form-control input-sm" />
			</div>
			<input type="submit" class="btn btn-danger" value="查询" /> <input
				type="button" class="btn btn-success" value="添加"
				onClick="javascript:window.location='${pageContext.request.contextPath}/view/transaction/class_transaction/class_add.jsp'" />
		</form>
	</div>

	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>

			</button>
			<p align="center" style="color: red;">教室信息-${info}</p>
		</div>
	</div>


	<div class="row" style="padding: 15px; padding-top: 0px;" align="right">
		<table class="table  table-condensed table-striped">
		</table>
		<display:table class="table table-condensed table-striped" name="list"
			pagesize="10"
			requestURI="${pageContext.request.contextPath }/transaction/class_transaction/list.action">
			<display:column property="classroomId" title="教室编号"></display:column>
			<display:column property="classroomName" title="教室名称"
				href="${pageContext.request.contextPath }/transaction/class_transaction/show.action"
				paramId="classroomId" paramProperty="classroomId"></display:column>
			<display:column property="classroomMax" title="容纳人数"></display:column>
			<%--     	<display:column property="class_transaction_tile" title="主题"></display:column> --%>

			<display:column property="classroomInfo" title="设备信息"></display:column>
			<display:column property="classroomRemark" title="备注信息"></display:column>
			<display:column property="classroomMark" title="标识"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/transaction/class_transaction/load.action"
				paramId="classroomId" paramProperty="classroomId" value="修改"
				title="修改"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/transaction/class_transaction/delete.action"
				paramId="classroomId" paramProperty="classroomId" value="删除"
				title="删除"></display:column>

		</display:table>


	</div>

</body>
</html>
