<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/common.jspf" %>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">班级管理</a></li>
        <li>教室名称</li>
    </ul>
</div>
<form class="form-inline" action="${pageContext.request.contextPath}/classinfo/classroominfo/list.action" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">教室名称：</label>
        <input type="email" class="form-control" id="activename" placeholder="请输入教室名称">
      </div>

    <input type="button"   class="btn btn-danger"     value="查询"/>
    <input type="button"   class="btn btn-success"     value="添加教室"onClick="javascript:window.location='${pageContext.request.contextPath}/view/classinfo/classroominfo/classroominfo_add.jsp'"/>
   
    
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    </table>
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/classinfo/classroominfo/list.action">
    	<display:column property="classroomId" title="编号"></display:column>
    	<display:column property="classroomName" title="教室名称" href="${pageContext.request.contextPath }/classinfo/classroominfo/show.action" paramId="classroomId" paramProperty="classroomId"></display:column>
    	<display:column property="classroomMax" title="容纳人数"></display:column>
    	<display:column property="classroomInfo" title="设备信息"></display:column>
    	<display:column href="${pageContext.request.contextPath }/classinfo/classroominfo/load.action" paramId="classroomId" paramProperty="classroomId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/classinfo/classroominfo/delete.action" paramId="classroomId" paramProperty="classroomId" value="删除" title="删除"></display:column>
    </display:table>	
    
</div>
</form>
</body>
</html>
