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
        <li>跟踪记录</li>
    </ul>
</div>
<form class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">学员姓名：</label>
        <input type="email" class="form-control" id="activename" placeholder="请输入学员姓名">
      </div>
    <div class="form-group">
         <label class="" for="activename">学员意向：</label>
		 <select name="" class="form-control">
         	<option>请选择</option>
            <option>无意向</option>
            <option>意向低</option>
            <option>意向中</option>
			<option>意向高</option>
         </select>	
      </div>
    <input type="button"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="trackrecord_add.jsp">添加纪录</a>
    
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>编号</th>
            <th>主题</th>
            <th>姓名</th>
            <th>内容</th>
            <th>意向状态</th>
            <th>负责人</th>
            <th>联系时间</th>
            <th>下次联系时间</th>
            <th>操作</th>
        </tr>
       	<tr>
        	<td>1001</td>
            <td>了解课程大纲</td>
            <td>张三</td>
            <td>明天过来</td>
            <td>意向强</td>
            <td>李四</td>
            <td>2014-10-10</td>
             <td>2014-10-11</td>
            <th>
            <a href="trackrecord_update.jsp">修改</a> 
            <a href="">删除</a>
            </th>
        </tr>
        <tr>
        	<td>1001</td>
            <td>了解课程大纲</td>
            <td>张三</td>
            <td>明天过来</td>
            <td>意向强</td>
            <td>李四</td>
            <td>2014-10-10</td>
             <td>2014-10-11</td>
            <th>
            <a href="trackrecord_update.jsp">修改</a> 
            <a href="">删除</a>
            </th>
        </tr>
     	                   
    </table>
</div>
</form>
</body>
</html>
