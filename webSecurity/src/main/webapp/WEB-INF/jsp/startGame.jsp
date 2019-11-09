<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title><s:message code="menu.mainPage" /></title>
</head>
<body>
	<%@include file="/WEB-INF/incl/menu.app"%>

	<form id="startGameForm" action="/startGameForm" method="POST">

	<c:forEach items="${mapOfCharacters}" var="entry">

		<img
			src="<c:url value="/resources/images/gierka.png"></c:url>"
			alt="image" style="width: 100%" />
		<input type="radio" name="character" value="${entry.key}">${entry.key}<br><br>	
		
	</c:forEach>


		<input type="submit" value="Dalej"/>
	</form>
	
</body>
</html>