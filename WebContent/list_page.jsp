<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>

<script type="text/javascript">

	function doDelete(id){
		
		var flag = confirm("是否确定删除?");
		if(flag){
			window.location.href="DelStudentServlet?id="+ id;
		}
	}
</script>
</head>
<body>
	<table border="1" width="700">
		<tr>
			<td colspan="8">
				<form action="SearchStudentServlet" method="post">
					按名称查询<input type="text" name="sname">
					按性别查询
					<select  name="sgender">
						<option value="">-请选择-</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
					
					<input type="submit" value="查询">
				</form>
				<a href="add.jsp">添加</a>
			</td>
		</tr>
		
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pageBean.list }" var="stu">
			<tr>
				<td>${stu.id }</td>
				<td>${stu.sname }</td>
				<td>${stu.gender }</td>
				<td>${stu.phone }</td>
				<td>${stu.birthday }</td>
				<td>${stu.hobby }</td>
				<td>${stu.info }</td>
				<td>
					<a href="EditServlet?id=${stu.id}">更新 </a>
					<a href="javascript:void(0)" onclick="doDelete(${stu.id})">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
				第&nbsp;${paeBean.currentPage }/${paeBean.totalSize }&nbsp;&nbsp;
				每页显示&nbsp;${pageBean.pageSize }条&nbsp;&nbsp;
				总记录数&nbsp;${pageBean.totalSize }&nbsp;&nbsp;
				<c:if test="${pageBean.currentPage !=1 }">
					<a href="StudentListPageServlet?currentPage=1">首页</a> | 
					<a href="StudentListPageServlet?currentPage=${pageBean.currentPage-1 }">上一页</a>
				</c:if>
				<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
					<c:if test="${pageBaean.currentPage==i }">
						${i }
					</c:if>
					<c:if test="${pageBaean.currentPage!=i }">
						<a href="StudentListPageServlet?currentPage=${i }">${i }</a>
					</c:if>
				</c:forEach>
				
				<c:if test="${pageBean.currentPage !=totalPage }">
					<a href="StudentListPageServlet?currentPage=${pageBean.currentPage+1 }">下一页</a>|
					<a href="StudentListPageServlet?currentPage=${pageBean.totalPage }">首页</a> 
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>