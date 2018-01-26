<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>编号</th>
            <th>活动名称</th>
            <th>负责人</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>活动状态</th>
            <th>操作</th>
        </tr>
       	<tr>
        	<td>1001</td>
            <td>软件大赛</td>
            <td>张三</td>
            <td>2014-12-12 12:12:12</td>
            <td>2014-12-22 12:12:12</td>
            <td>准备中</td>
            <th><a href="marketactive_update.html">修改</a> <a href="">删除</a></th>
        </tr>
        	<tr>
        	<td>1001</td>
            <td>软件大赛</td>
            <td>张三</td>
            <td>2014-12-12 12:12:12</td>
            <td>2014-12-22 12:12:12</td>
            <td>准备中</td>
            <th><a href="marketactive_update.html">修改</a> <a href="">删除</a></th>
        </tr>
               	<tr>
        	<td>1001</td>
            <td>软件大赛</td>
            <td>张三</td>
            <td>2014-12-12 12:12:12</td>
            <td>2014-12-22 12:12:12</td>
            <td>准备中</td>
            <th><a href="marketactive_update.html">修改</a> <a href="">删除</a></th>
        </tr>                    
    </table>
</div>

</body>
</html>
