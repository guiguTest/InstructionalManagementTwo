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
        <li>缴费单详情</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/finance/tuition/add.action" class="form-horizontal">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">缴费单编号</label>
                <div class="col-sm-9">
                	<input type="text" name="paymentId" readonly="readonly" class="form-control input-sm" placeholder="请输入缴费单编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">学员编号</label>
                <div class="col-sm-5">
                	<input type="text" name="studentId" class="form-control input-sm" placeholder="请输入学员编号"/>
                </div>
            </div>
        </div>

    </div>
    <!-- 开始2 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">员工编号</label>
                <div class="col-sm-5">
                	<input type="text" name="staffId" class="form-control input-sm" placeholder="请输入员工编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">缴费方式</label>
                <div class="col-sm-9">
                	<select class="form-control input-sm" name="paymentMenthod" >
                        	<option value="-1">请选择缴费方式</option>
                        	<option value="0">支付婊</option>
                        	<option value="1">微信支付</option>
                        	<option value="2">网银</option>
                        	<option value="3">现金</option>
                        	<option value="4">归谷网络支付平台</option>
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
            	<label class="col-sm-3 control-label">应缴金额</label>
                <div class="col-sm-6">
                	<input type="text" name="paymentShouldAmount" class="form-control input-sm" placeholder="请输入应缴金额"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">实缴金额</label>
                <div class="col-sm-6">
                <input type="text" name="paymentRealAmount" class="form-control input-sm" placeholder="请输入实缴金额"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束3 -->
        <!-- 开始4 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">优惠金额</label>
                <div class="col-sm-6">
                	<input type="text" name="paymentDiscountAmount" class="form-control input-sm" placeholder="请输入优惠金额"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">欠款</label>
                <div class="col-sm-6">
                <input type="text" name="paymentDebtAmount" class="form-control input-sm" placeholder="请输入欠款"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束4 -->
    <!-- 开始4 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">缴费时间</label>
                <div class="col-sm-9">
                	<input type="text" name="paymentTime" onclick="WdatePicker()" readonly="readonly"  class="form-control input-sm" placeholder="请输入缴费时间"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">缴费情况</label>
                <div class="col-sm-9">
            	   	<textarea class="form-control" name="paymentSitutation"></textarea>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 结束6 -->   
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="paymentRemark"></textarea>
                </div>
            </div>
        
        </div>

   
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <input  type="reset" class="btn  btn-danger" value="取消"/>
        </div>
    </div>
</form>

</body>
</html>
