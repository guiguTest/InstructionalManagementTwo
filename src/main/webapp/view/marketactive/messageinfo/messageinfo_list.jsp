<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<%@ include file="/view/public/common.jspf" %>
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">营销管理</a></li>
        <li>短信管理</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal" action="${pageContext.request.contextPath }/marketactive/messageinfo/list.action" >
	<div class="col-sm-2">电话号码:</div>
    <div class="col-sm-3">
    	<input type="text"  name="messagePhone" class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath }/marketactive/messageinfo/send.action">发送短信</a>
    </form>
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">短信-${info}</p>
	</div>	
</div>

<div class="row" style="padding:15px; padding-top:0px; ">
  <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/marketactve/messageinfo/list.action">
    	<display:column property="messagePhone" title="电话号码"  href="${pageContext.request.contextPath }/marketactive/messageinfo/load.action" paramId="messageId1" paramProperty="messageId1"></display:column>
    	<display:column property="messageTime" title="发送日期"  format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column property="messageState" title="发送状态"></display:column>
    	<display:column property="messageMan" title="接收人"> </display:column>
    	<display:column href="${pageContext.request.contextPath }/marketactive/messageinfo/delete.action" paramId="messageId1" paramProperty="messageId1" value="删除" title="删除"></display:column>
    </display:table>
</div>

</body>
</html>
