<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="user.create.title" /></title>
</head>
<body>
	<form name="user" action="<c:url value='/user/createUser' />" method="post">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<h1>
			<spring:message code="user.create.title" />
		</h1>
		<c:if test="${not empty error}">
			<h2 style="color: red;">${error}</h2>
		</c:if>
		<c:if test="${not empty exception}">
			<h2 style="color: red;">${exception}</h2>
		</c:if>
		<table border="1" style="padding-top: 10px; width: 400px;">
			<tr>
				<td><spring:message code="user.create.name" /></td>
				<td>
					<input type="text" name="name" value="" style="width: 300px;"/>
				</td>
			</tr>
			<tr>
				<td><spring:message code="user.create.username" /></td>
				<td>
					<input type="text" name="username" value="" style="width: 300px;"/>
				</td>
			</tr>
	
			<tr>
				<td><spring:message code="user.create.password" /></td>
				<td>
					<input type="password" name="password" value="" style="width: 300px;"/>
				</td>
			</tr>
			<tr>
				<td><spring:message code="user.create.email" /></td>
				<td>
					<input type="text" name="email" value="" style="width: 300px;"/>
				</td>
			</tr>
			<tr>
				<td><spring:message code="user.create.role" /></td>
				<td>
					 <select name="role" style="width: 300px;">
						<option value="USER"><spring:message code = "user.create.role.user"/></option>
						<option value="ADMIN"><spring:message code = "user.create.role.admin"/></option>
					</select>
				</td>
			</tr>
		</table>
		<div style="padding-top: 10px; float: left;"> 
			<input type="submit" value="<spring:message code = "user.create.submit"/>"/>
		</div>
	</form>	
</body>
</html>