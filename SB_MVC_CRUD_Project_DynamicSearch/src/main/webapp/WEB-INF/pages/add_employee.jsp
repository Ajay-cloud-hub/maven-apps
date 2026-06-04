<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>
	<frm:form action="./register" method="POST" modelAttribute="emp">
		<table border="1" align="center">
			<%-- <tr>
				<th>Emp_No</th>
				<td><frm:input type="text" path="empno"  /></td>
			</tr> --%>
			<tr>
				<th>Emp_Name</th>
				<td><frm:input type="text" path="empname" /></td>
			</tr>
			<tr>
				<th>Emp_Job</th>
				<td><frm:input type="text" path="job" /></td>
			</tr>
			<tr>
				<th>Emp_Sal</th>
				<td><frm:input type="text" path="sal" /></td>
			</tr>
			<tr>
				<th>Emp_Dept_no</th>
				<td><frm:input type="text" path="deptno" /></td>
			</tr>
			<tr>
				<th><input type="submit" value="send" /></th>
				<th><input type="reset" value="clear"></th>
			</tr>
		</table>
	</frm:form>
	<center>
		<a href="./report">Show Report<img alt="Report"
			src="images/report_pic.jpeg" width="100px" height="100px"></a>
	</center>
</body>
</html>