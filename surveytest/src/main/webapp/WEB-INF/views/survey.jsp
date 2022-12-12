<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>설문지</title>
<style>

</style>
</head>
<body>
	<div id="allDiv">
		<div id="topDiv">
			<h2>설문지제목</h2>sId = ${s.sId }
			<div id="btnDiv" style="float: right;">
				<a href="/">뒤로가기</a>
				<a href="/survey/delete?sId=${s.sId}">삭제하기</a>
			</div>
			<br>
			<div align="center">
				<a href="">질문</a>
				<a href="">응답</a>
			</div>
		</div>
		<hr>
		<div id="midDiv" align="center">
			<div id="titleDiv" align="center">
				<input type="text" name="title" id="title" placeholder="설문지 제목">
				<br>
				<input type="text" name="description" id="description" placeholder="설문지 설명">
			</div>
			<div id="questionList" align="center">
				<div class="question">
					<input type="text" name="qValue" class="qValue" placeholder="질문">
					<select name="type">
						<option value="1">객관식 질문</option>
						<option value="2">체크 박스</option>
						<option value="3">드롭 다운</option>
					</select>
				</div>
				<div class="item">
					<input type="text" name="iValue" class="iValue">
					<button>Img</button> <button>삭제</button>
					<br>
					<button>옵션 추가</button> 또는 <button>'기타' 추가</button>
				</div>
			</div>
		</div>
		<hr>
		<div id="botDiv" align="center">
		</div>
	</div>
</body>
</html>