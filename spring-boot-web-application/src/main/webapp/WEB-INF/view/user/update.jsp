<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="user.update.title" /></title>
</head>
<body>
	<form name="user" action="<c:url value='/user/updateUser' />" method="post">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<h1>
			<spring:message code="user.update.title" />
		</h1>
		<c:if test="${not empty error}">
			<h2 style="color: red;">${error}</h2>
		</c:if>
		<c:if test="${not empty exception}">
			<h2 style="color: red;">${exception}</h2>
		</c:if>
		<c:if test="${not empty user}">
			<input type="hidden" name="id" value="${user.id}"/>
			<table border="1" style="padding-top: 10px; width: 400px;">
				<tr>
					<td><spring:message code="user.update.name" /></td>
					<td>
						<input type="text" name="name" value="${user.name}" style="width: 300px;"/>
					</td>
				</tr>
				<tr>
					<td><spring:message code="user.update.username" /></td>
					<td>
						<input type="text" name="username" value="${user.username}" style="width: 300px;"/>
					</td>
				</tr>
		
				<tr>
					<td><spring:message code="user.update.email" /></td>
					<td>
						<input type="text" name="email" value="${user.email}" style="width: 300px;"/>
					</td>
				</tr>
				
				<tr>
					<td><spring:message code="user.update.role" /></td>
					<td>
						 <select name="role" style="width: 300px;">
							<option <c:if test="${user.role eq 'USER'}"> selected="selected" </c:if> value="USER"><spring:message code = "user.update.role.user"/></option>
							<option <c:if test="${user.role eq 'ADMIN'}"> selected="selected" </c:if> value="ADMIN"><spring:message code = "user.update.role.admin"/></option>
						</select>
					</td>
				</tr>
			</table>
			<div style="padding-top: 10px; float: left;"> 
				<input type="submit" value="<spring:message code = "user.update.submit"/>"/>
			</div>
		</c:if>
		<c:if test="${empty user}">
			<h2><spring:message code="user.find.notfound"/></h2>
		</c:if>
	</form>	
</body>
</html>