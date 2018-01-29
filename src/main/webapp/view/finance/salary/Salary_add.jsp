<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加工资单</title>

<%@ include file="/view/public/common.jspf" %>

</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>员工薪水</li>
        <li>添加工资单</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/finance/salary/add.action" class="form-horizontal">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">工资单编号</label>
                <div class="col-sm-9">
                	<input type="text" name="staffSalaryId" readonly="readonly" class="form-control input-sm" placeholder="请输入工资单编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">领取人员编号</label>
                <div class="col-sm-9">
                	<input type="text" name="staffId" class="form-control input-sm" placeholder="请输入领取人员编号"/>
                </div>
            </div>
        </div>

    </div>
    <!-- 开始2 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">发放人员编号</label>
                <div class="col-sm-5">
                	<input type="text" name="staStaffId" class="form-control input-sm" placeholder="请输入发放人员编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">是否已发</label>
                <div class="col-sm-4">
                		<select class="form-control input-sm" name="staffSalaryIsused">
                        	<option>请选择</option>
                            <option value="是">是</option>
                            <option value="否">否</option>
                        </select>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束2 -->
    <!-- 开始3 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">本月薪水</label>
                <div class="col-sm-6">
                	<input type="text" name="staffSalaryTotal" class="form-control input-sm" placeholder="请输入本月薪水"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">实际发放工资</label>
                <div class="col-sm-9">
                <input type="text" name="staffSalaryReal" class="form-control input-sm" placeholder="请输入实际发放工资"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束3 -->
        <!-- 开始4 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">扣除</label>
                <div class="col-sm-9">
                	<input type="text" name="staffSalaryDeduct" class="form-control input-sm" placeholder="请输入扣除工资"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">领取日期</label>
                <div class="col-sm-9">
                <input type="text" name="staffSalaryTime" onclick="WdatePicker()" class="form-control input-sm" readonly="readonly" placeholder="请输入领取日期"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束4 -->
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="remark"></textarea>
                </div>
            </div>
        
        </div>

   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input type="submit" class="btn btn-success" value="保存"/>
            <input type="reset" class="btn  btn-danger" value="取消"/>
        </div>
    </div>
</form>

</body>
</html>