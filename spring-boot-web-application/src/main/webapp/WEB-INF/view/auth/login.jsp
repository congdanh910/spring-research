<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<style type="text/css">
.login { 
	height:100px;
	width:170px;
	margin:auto;
	border:1px #CCC solid;
	padding:10px;
	background-color:#E9E9E9 
}

input { 
	background: #E1FFE1;
	border:1px #CCC solid;
	padding:5px;
 }

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="login.title" /></title>
</head>
<body>
	<h1>
		<spring:message code="login.title" />
	</h1>
	<form action="<c:url value='/auth/login'/>" method="post">
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<div class="login">
			<spring:message code="login.form.username" /> : <input type="text" name="username" id="username"> 
			<spring:message code="login.form.password" /> : <input type="password" name="password" id="password">
			<spring:message code="login.form.remember" /> : <input type="checkbox" name="remember-me" id="password">
			<button type="submit"><spring:message code="login.form.submit" /></button>			
		</div>
		<c:if test="${error}">
			<div style="color: red;">
				<p>
					<spring:message code="login.error.message"/>
				</p>
			</div>
		</c:if>
	</form>
</body>
</html>