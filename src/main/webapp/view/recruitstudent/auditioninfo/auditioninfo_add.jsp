<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
    	<li><a href="#">招生管理</a></li>
         <li>试听记录</li>
        <li>添加记录</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/recruitstudent/auditionInfo/add.action" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="auditionId" readonly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">试听课程</label>
                <div class="col-sm-9">
                	<input type="text" name="auditionCourse" class="form-control input-sm" placeholder="请输入试听课程"/>
                </div>
            </div>
        </div>

    </div>
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">试听学员</label>
                <div class="col-sm-9">
                	<select name="studentId" class="form-control input-sm">
                    	<option value="1">张三</option>
                   	    <option value="2">李四</option>
                    </select>
                </div>
            </div>
        </div>
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">试听时间</label>
                <div class="col-sm-9">
               		 <input type="text" name="auditionTime" onclick="WdatePicker()" readonly="readonly" class="form-control input-sm" placeholder="请输入试听日期"/>
                </div>
            </div>
        
        </div>

    </div>
       	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">试听地点</label>
                <div class="col-sm-9">
               		 <input type="text" name="auditionAddr" class="form-control input-sm" placeholder="请输入试听地点"/>
                </div>
            </div>
        
        </div>

    </div>
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">描述</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="auditionDesc"></textarea>
                </div>
            </div>
        </div>
    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <a class="btn btn-warning" href="${pageContext.request.contextPath }/recruitstudent/auditionInfo/list.action">返回上一级</a>
        </div>
    </div>
    
</form>

</body>
</html>
