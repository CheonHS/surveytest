<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 목록</title>
<style>
	#midDiv{
		height: 300px;
		overflow-x: auto;
		white-space: nowrap;
		padding-left: 50px;
		padding-right: 50px;
	} 
</style>
<script src="//code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>
	<h2>설문지</h2>
	<div id="topDiv" align="center">	
	</div>
	<hr>
	<div id="midDiv" align="center">
		<c:if test="${!empty list }">
			<c:forEach var="s" items="${list }" >
				<a href="/survey?sId=${s.sId }">${s.rownum } / ${s.title }</a>
			</c:forEach>
		</c:if>
		<c:if test="${empty list }">
			설문지가 없습니다.
		</c:if>
	</div>
	<hr>
	<div id="botDiv" align="center">
		<a href="/survey/write">설문지작성</a>
	</div>
</body>
<script>
</script>
</html>

