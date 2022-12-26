<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>설문지</title>
<style>
	.qDiv{
		width: 500px;
		height: 200px;
		border: 1px solid black;
	}
</style>
<script src="//code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div id="topDiv">
		<h2>설문지</h2>
		<button id="responseBtn">응답</button>
	</div>
	<hr>
	<div id="midDiv" align="center">
		<div id="sDiv">
			${s.sId } / ${s.title } / ${s.sDesc }<br>
			<input type="hidden" id="sId" value="${s.sId }">
			<input type="text" id="title" value="${s.title }"><br>
			<input type="text" id="sDesc" value="${s.sDesc }"><br>
		</div>
		<button id="qAdd">질문 추가</button>
		<c:if test="${!empty q }">
			<c:forEach var="qq" items="${q }" >
				<div class="qDiv">
					qId = ${qq.qId } / qType = ${qq.type } / qValue = ${qq.qValue }
					<input type="hidden" name="qId" class="qId" value="">
					<br>
					<button class="qDel" qId="${qq.qId }">질문 삭제</button>
				</div>
			</c:forEach>
		</c:if>
		<div class="iDiv">
			<c:if test="${!empty i }">
				<c:forEach var="ii" items="${i }" >
					iId = ${ii.iId } / iValue = ${ii.iValue }
				</c:forEach>
			</c:if>
		</div>
	</div><!-- midDiv -->
	<hr>
	<div id="botDiv" align="center">
	</div>
</body>
<script>
	let sId = $('#sId').val();
	let title = $('#title').val();
	let sDesc = $('#sDesc').val();

	let s = {
		sId : sId,
		title : title,
		sDesc : sDesc		
	};
	let survey = JSON.stringify(s);
	console.log(survey);

	$(document).on('click', '#responseBtn', function(){
		$.ajax({
			method: "POST",
			url: "/survey/response",
			data: survey
		})
		.done(function( msg ) {
		    $('#midDiv').html(msg);
		});
	});

	//	질문 추가
	$(document).on('click', '#qAdd', function(){
		let sId = $('#sId').val();
		
		$.ajax({
			method: "POST",
			url: "/survey/qAdd",
			data: { sId: sId }
		})
		.done(function( msg ) {
		    $('#midDiv').html(msg);
		});
	});

	//	질문 삭제
	$(document).on('click', '.qDel', function(){
		let sId = $('#sId').val();
		let qId = $(this).attr('qId');
		
		$.ajax({
			method: "POST",
			url: "/survey/qDel",
			data: { sId: sId, qId: qId }
		})
		.done(function( msg ) {
		    $('#midDiv').html(msg);
		});
	});
</script>
</html>