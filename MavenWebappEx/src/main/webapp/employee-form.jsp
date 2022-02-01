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
	<c:if test = "${existingEmployee != null}">
		<form action="update" method="post">
	</c:if>
	<c:if test = "${existingEmployee == null}">
		<form action="insert" method="post">
	</c:if>
	<table border="1" cellpadding="5">
		<caption>
			<h2>
				<c:if test = "${existingEmployee!= null}">
					Edit Employee
				</c:if>
				<c:if test = "${existingEmployee == null}">
					Add New Employee
				</c:if>
			</h2>
		</caption>
		<c:if test = "${existingEmployee!=null}">
			<input type="hidden" name="eid" value="<c:out value='${existingEmployee.empId}' />" />
		</c:if>
		<tr>
			<th> Employee Name: </th>
			<td><input type="text" name="ename" value="<c:out value='${existingEmployee.empName}' />" /> 
			</td>
		</tr>
		<tr>
			<th> Employee Email: </th>
			<td><input type="text" name="eemail" value="<c:out value='${existingEmployee.empEmail}' />" /> 
			</td>
		</tr>
		<tr>
			<th> Employee MobileNo: </th>
			<td><input type="text" name="emobno" value="<c:out value='${existingEmployee.empMobileNo}' />" /> 
			</td>
		</tr>
		<tr>
		
			<td colspan="2" align="center">
			<input type="submit" value="save" /> 
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>