<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<h1>Hi, ${name}</h1>
		<h2>Weather</h2>
		<ul>
		    <c:forEach items="${allItems}" var="item">
		        <li>${item}</li>
		    </c:forEach>
		</ul>
	</body>
</html>
