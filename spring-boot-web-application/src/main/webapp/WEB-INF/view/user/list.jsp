<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title><spring:message code="user.list.title" /></title>
</head>
<body>
	<h1>
		<spring:message code="user.list.title" />
	</h1>
	<table border="1" style="width: 100%;">
		<tr>
			<th><spring:message code="user.list.table.name" /></th>
			<th><spring:message code="user.list.table.username" /></th>
			<th><spring:message code="user.list.table.email" /></th>
			<th><spring:message code="user.list.table.role" /></th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.name}</td>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td>${user.role}</td>
			</tr>
		</c:forEach>
	</table>
	<div style="float: left; padding-top: 10px;">
		<a href="<c:url value="/user/create" />">Create</a>
	</div>
</body>
</html>