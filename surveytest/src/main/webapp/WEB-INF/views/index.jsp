<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 리스트</title>
</head>
<body>
	<h2>설문지</h2>
	
	<div id="surveyList" align="center">
		<c:if test="${!empty list }">
			<c:forEach var="s" items="${list }" >
				<a href="/survey?sId=${s.sId }">${s.rownum } / ${s.title }</a><br>
			</c:forEach>
		</c:if>
	</div>
	<hr>
	<div id="surveyBtn" align="center">
		<a href="/survey/New">설문지작성</a>
	</div>
</body>
</html>