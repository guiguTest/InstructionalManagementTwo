<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

<%@ include file="/view/public/common.jspf" %>

</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>角色管理</li>
        <li>角色变更</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/system/roleinfo/changerole.action" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="hidden" name="staffId" value="${staffInfo.staffId }">
                	<p class="form-control-static">${staffInfo.staffId }</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">姓名</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${staffInfo.staffName }</p>
                </div>
            </div>
        </div>

    </div>
    <!-- 开始2 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">年龄</label>
                <div class="col-sm-5">
                	<p class="form-control-static">${staffInfo.staffAge }</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">性别</label>
                <div class="col-sm-4">
                	<p class="form-control-static">${staffInfo.staffSex }</p>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束2 -->
    <!-- 开始3 -->
	<div class="row">
 
        <div class="col-sm-5">
            <div class="form-group">
            		<label class="col-sm-3 control-label">角色</label>
                <div class="col-sm-6">
                		<select class="form-control input-sm" name="roleId" >
                        	<option>请选择</option>
                        	<c:forEach items="${rolelist }" var="role">
                            	<option value="${role.roleId}"  ${role.roleId==staffInfo.roleId?'selected':'' }>${role.roleName }</option>
                            </c:forEach>
                        </select>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束3 -->
   	<div class="row">
    	<div class="col-sm-5 col-sm-offset-4">
          	<input type="submit" class="btn btn-success" value="角色变更"/>
            <a class="btn btn-warning" href="${pageContext.request.contextPath }/system/roleinfo/staffinforolelist.action">返回上一级</a>
          
        </div>
    </div>
</form>

</body>
</html>
