<%@page import="com.mouritech.departmentmanagement.entity.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Management System</title>
</head>
<body>
<center>
	<h1>Department Management System</h1>
	<h2>
		<a href="new">Add New Department</a> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="list">List of Departments</a> 
	</h2>
</center>
<div align="center">

	<table border="1" cellpadding = "5">
		<caption><h2>List of Departments</h2></caption>
		<tr>
			<th>DepartmentId </th>
			<th>DepartmentName </th>
			<th>DepartmentEmail </th>
			<th>DepartmentPhoneNo</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="dep" items ="${listDep}">
		<tr>
			<td><c:out value= "${dep.depId}" /></td>
			<td><c:out value= "${dep.depName}" /></td>
			<td><c:out value= "${dep.depEmail}" /> </td>
			<td><c:out value= "${dep.depMobileNo}" /></td>
			<td>
				<a href="edit?id=<c:out value= "${dep.depId}" />">Edit Department</a> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="delete?id=<c:out value= "${dep.depId}" />">Delete Department</a> 
			</td>
		</tr>
		</c:forEach>
	</table>
		
</div>
</body>
</html>