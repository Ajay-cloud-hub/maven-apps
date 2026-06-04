<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Employee Data</title>
</head>
<body>
	<div align="center">
		<h1 style="color:red;">Search Data</h1>
		<table border="1px">
		<frm:form action="./search" modelAttribute="emp">
				<tr>
					<th>Emp Name: <th>
					<frm:input type="text" path="empname" />
				</tr>
				<tr>
					<th>Job:<th>
					<frm:input type="text" path="job" />
				</tr>
				<tr>
					<th>Salary:<th>
					<frm:input type="text" path="sal" />
				</tr>
				<tr>
					<th>Dept No:<th>
					<frm:input type="text" path="deptno" />
				</tr>
				<tr>
					<th><input type="submit" value="Dynamic Search"></th>
					<td><input type="reset" value="clear"></td> 
				</tr>
		</frm:form>
		</table>
	</div>
	<br>
	<br>
	<hr>
	<br>
	<br>


	<h1 align="center" style="color:red;">Emploee Report</h1>
	<table border="1" align="center" style="background-color: cyan">
		<tr style="background-color: RED">
			<th>Emp_No</th>
			<th>Emp_Name</th>
			<th>Emp_Job</th>
			<th>Emp_sal</th>
			<th>dept_no</th>
			<th>edit op</th>
			<th>delete op</th>

		</tr>
		<c:forEach var="emp" items="${listOfEmployees}">
			<tr>
				<!-- In jsp file variables and methods are allowed  -->
				<td>${emp.empno}</td>
				<td>${emp.empname}</td>
				<td>${emp.getJob()}</td>
				<td>${emp.getSal()}</td>
				<td>${emp.deptno}</td>
				<%-- <td><a href="update?empno=${emp.empno}"><img alt="edit"
						src="images/edit_pic.png" height="30px" width="30px"></a> --%>
				<td><a href="./update?no=${emp.empno}"><img alt="edit"
						src="images/edit_pic.png" height="30px" width="30px"></a>
				<td><a href="delete?empno=${emp.empno}"
					onclick="return Confirm('Are you sure to delete?')"><img
						alt="delete" src="images/delete_pic.png" height="30px"
						width="30px"></a>
			</tr>
		</c:forEach>
	</table>
	<h1 style="text-align: center; color: green;">${returnMsg}</h1>
	<%-- <center> --%>
	<br>
	<br>
	<br>
	<div align="center">
		<a href="./">Home<img alt="home" src="images/home.jpeg"
			height="100px" width="100px"></a>
	</div>
	<br>
	<div align="center">
		<a href="./register">Add Employee<img src="images/add_pic.png"
			height="100px" width="100px"></a>
	</div>
	<%-- </center> --%>
</body>
</html>