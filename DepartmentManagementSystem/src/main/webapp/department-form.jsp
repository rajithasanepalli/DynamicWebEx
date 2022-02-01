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
	<c:if test = "${existingDepartment != null}">
		<form action="update" method="post">
	</c:if>
	<c:if test = "${existingDepartment == null}">
		<form action="insert" method="post">
	</c:if>
	<table border="1" cellpadding="5">
		<caption>
			<h2>
				<c:if test = "${existingDepartment!= null}">
					Edit Department
				</c:if>
				<c:if test = "${existingDepartment == null}">
					Add New Department
				</c:if>
			</h2>
		</caption>
		<c:if test = "${existingDepartment!=null}">
			<input type="hidden" name="did" value="<c:out value='${existingDepartment.depId}' />" />
		</c:if>
		<tr>
			<th> Department Name: </th>
			<td><input type="text" name="dname" value="<c:out value='${existingDepartment.depName}' />" /> 
			</td>
		</tr>
		<tr>
			<th> Department Email: </th>
			<td><input type="text" name="demail" value="<c:out value='${existingDepartment.depEmail}' />" /> 
			</td>
		</tr>
		<tr>
			<th> Department MobileNo: </th>
			<td><input type="text" name="dmobno" value="<c:out value='${existingDepartment.depMobileNo}' />" /> 
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