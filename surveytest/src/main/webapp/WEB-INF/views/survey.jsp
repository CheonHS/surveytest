<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>설문지</title>
<style>
	input{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<h2>설문지제목</h2>sId = ${s.sId}
	<div id="btn" style="float: right;">
		<a href="/">뒤로가기</a>
	</div>
	<div id="top" align="center">
		<a href="">질문</a>
		<a href="">응답</a>
	</div>
	<hr>
	<div id="title" align="center">
		<input type="text" name="title" id="title">
		<br>
		<input type="text" name="description" id="description">
	</div>
	<div id="questionList" align="center">
		<div class="question">
			<input type="text" name="qValue">
		</div>
	</div>
	<div id="bottom">
		
	</div>
</body>
</html>