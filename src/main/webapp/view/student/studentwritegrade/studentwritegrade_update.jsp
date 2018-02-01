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
    	<li><a href="#">学员管理</a></li>
        <li>修改学生成绩</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/student/studentwritegrade/update.action" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="writeGradeId" value="${studentWriteGrade.writeGradeId}" readonly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">学员</label>
                <div class="col-sm-9">
                	<input type="text" name="studentId" value="${studentWriteGrade.studentId}" class="form-control input-sm" placeholder="请输入学员"/>
                </div>
            </div>
        </div>

     </div>
    	<div class="row">
    	 <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">监考人和阅卷人</label>
                <div class="col-sm-9">
                	<input type="text" name="staffId" value="${studentWriteGrade.staffId}" class="form-control input-sm" placeholder="请输入监考人和阅卷人"/>
                </div>
            </div>
        </div>
        
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">科目</label>
                <div class="col-sm-9">
                	<input type="text" name="writeGradeSubject" value="${studentWriteGrade.writeGradeSubject}" class="form-control input-sm" placeholder="请输入科目"/>
                </div>
            </div>
        
        </div>
        

    </div>
    <div class="row">
    
    <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">成绩</label>
                <div class="col-sm-9">
                	<input type="text" name="writeGrade" value="${studentWriteGrade.writeGrade}" class="form-control input-sm" placeholder="请输入成绩"/>
                </div>
            </div>
        </div>
        
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">考试时间</label>
                <div class="col-sm-9">
               			<input type="text" name="writeGradeTime" value="${studentWriteGrade.writeGradeTime}" readonly="readonly" onclick="WdatePicker()" class="form-control input-sm" placeholder="请输入考试时间"/>
                </div>
            </div>
        </div>


    </div>


 
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">沟通内容</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">沟通内容</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="writeGradeNote" value="${studentWriteGrade.writeGradeNote}">${studentWriteGrade.writeGradeNote}</textarea>
                </div>
            </div>
        
        </div>

    </div>
    
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="${pageContext.request.contextPath}/student/studentwritegrade/list.action">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
