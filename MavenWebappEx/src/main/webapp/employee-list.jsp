<%@page import="com.mouritech.employeemanagement.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management System</title>
</head>
<body>
<center>
	<h1>Employee Management System</h1>
	<h2>
		<a href="new">Add New Employee</a> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="list">List of Employees</a> 
	</h2>
</center>
<div align="center">

	<table border="1" cellpadding = "5">
		<caption><h2>List of employees</h2></caption>
		<tr>
			<th>EmployeeId </th>
			<th>EmployeeName </th>
			<th>EmployeeEmail </th>
			<th>EmployeePhoneNo</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="emp" items = "${listEmp}">
		<tr>
			<td><c:out value= "${emp.empId}" /></td>
			<td><c:out value= "${emp.empName}" /></td>
			<td><c:out value= "${emp.empEmail}" /> </td>
			<td><c:out value= "${emp.empMobileNo}" /></td>
			<td>
				<a href="edit?id=<c:out value= "${emp.empId}" />">Edit Employee</a> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="delete?id=<c:out value= "${emp.empId}" />">Delete Employee</a> 
			</td>
		</tr>
		</c:forEach>
	</table>
		
</div>
</body>
</html>