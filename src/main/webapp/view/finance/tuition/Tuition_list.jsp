<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学员缴费</title>

<%@ include file="/view/public/common.jspf" %>

</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">财务管理</a></li>
        <li>学员缴费</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal">
	<div class="col-sm-1" >条件:</div>
    <div class="col-sm-3">
    	<select class="form-control  input-sm">
        	<option>学员姓名</option>
            <option>缴费单编号</option>
            <option>学员班级</option>
            <option>缴费时间</option>
        </select>
    </div>
    <div class="col-sm-3">
    	<input type="text"  class="form-control input-sm"/>
    </div>
    <input type="button"   class="btn btn-danger"   value="查询"/>
    <input type="button"   class="btn btn-success"   value="添加" onClick="javascript:window.location='staffinfo_add.html'"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	
     <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath}/finance/tuition/Tuition_list.action">
    	<display:column property="staffId" title="缴费单编号"></display:column>
    	<display:column property="staffName" title="学员姓名" href="${pageContext.request.contextPath }/system/staffinfo/show.action" paramId="staffId" paramProperty="staffId"></display:column>
    	<display:column property="staffAge" title="所在班级"></display:column>
    	<display:column property="staffAge" title="应缴金额"></display:column>
    	<display:column property="staffId" title="实缴金额"></display:column>
    	<display:column property="staffMobilePhone" title="欠款"></display:column>
    	<display:column property="staffEmail" title="负责人员"></display:column>
    	<display:column property="staffEntryTime" title="缴费时间" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column href="${pageContext.request.contextPath}/finance/tuition/Tuition_list.action" paramId="staffId" paramProperty="staffId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath}/finance/tuition/Tuition_list.action" paramId="staffId" paramProperty="staffId" value="删除" title="删除"></display:column>
    	
    </display:table>
          
    
</div>

</body>
</html>
