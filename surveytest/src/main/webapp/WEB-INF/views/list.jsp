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
	.surveyRow{
		border: 1px solid black;
		width: 200px;
		height: 200px;
		display: inline-block;
	} 
</style>
</head>
<body>
	<div id="topDiv">
		<h2>설문지</h2>
	</div>
	<div id="allDiv">
		<hr>
		<div id="midDiv" align="center">
			<c:if test="${!empty list }">
				<c:forEach var="s" items="${list }" >
					<div class="surveyRow" onclick="location.href='/survey?sId=${s.sId}'">
						${s.rownum }<br>
						${s.title }
					</div>
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
	</div>
</body>
</html>

