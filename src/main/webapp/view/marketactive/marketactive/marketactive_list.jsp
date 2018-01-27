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
    	<li><a href="#">营销管理</a></li>
        <li>营销活动</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-inline">
     <div class="form-group">
         <label class="" for="activename">活动名称：</label>
        <input type="email" class="form-control" id="activename" placeholder="请输入活动名称">
      </div>
      <div class="form-group">
         <label class="" for="activstate">活动状态：</label>
		 <select  class="form-control" id="activstate">
            <option>活动状态</option>
         </select>	
      </div>
    <input type="button"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="marketactive_add.html">添加活动</a>
    </form>
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">员工信息-${info}</p>
	</div>	
</div>


<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<table class="table  table-condensed table-striped">
    </table>
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/system/staffinfo/list.action">
    	<display:column property="activeId" title="编号"></display:column>
    	<display:column property="activeName" title="活动名称" href="${pageContext.request.contextPath }/system/staffinfo/show.action" paramId="staffId" paramProperty="staffId"></display:column>
    	<display:column property="activeState" title="活动状态"></display:column>
    	<display:column property="staffId" title="负责人"></display:column>
    	<display:column property="activeType" title="活动类型"></display:column>
    	<display:column href="${pageContext.request.contextPath }/system//load.action" paramId="staffId" paramProperty="staffId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/system//delete.action" paramId="staffId" paramProperty="staffId" value="删除" title="删除"></display:column>
    	
    </display:table>
    
</div>

</body>
</html>
