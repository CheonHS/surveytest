<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>설문지</title>
<style>
	div{
		margin-top: 5px;
		margin-bottom: 5px;
	}
	.qDiv{
		width: 500px;
		border: 1px solid black;
	}
	.iDiv{
		width: 400px;
		border: 1px solid black;
	}
	.iDel, .qDel{
		float: right;
	}
</style>
<script src="//code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>
	<h2>설문지</h2>
	<div id="topDiv" align="center">
		<button id="surveyBtn">질문</button>
		<button id="responseBtn">응답</button>
	</div>
	<hr>
	<div id="midDiv" align="center">
		<div id="sDiv">
			<input type="hidden" id="sId" value="${s.sId }">
			title : <input type="text" id="title" value="${s.title }"><br>
			sDesc : <input type="text" id="sDesc" value="${s.sDesc }"><br>
		</div>
		
		<button id="qAdd">질문 추가</button>
		
		<c:if test="${!empty s.questions }">
			<c:forEach var="qq" items="${s.questions }" >
				<div class="qDiv">
					<input type="hidden" class="qId" value="${qq.qId }">
					<input type="text" class="qValue" value="${qq.qValue }">
					<c:choose>
						<c:when test="${qq.type eq 1 }">
							<select class="qType">
								<option value="1" selected>객관식 질문</option>
								<option value="2">주관식 질문</option>
							</select>
						</c:when>
						<c:when test="${qq.type eq 2 }">
							<select class="qType">
								<option value="1">객관식 질문</option>
								<option value="2" selected>주관식 질문</option>
							</select>
						</c:when>
					</c:choose>
					<c:forEach var="i" items="${qq.items }" >
						<c:if test="${!empty i }">
							<div class="iDiv" align="left">
								${i.rownum } <input type="text" class="iValue" value="${i.iValue }">
								<button class="iDel">옵션 삭제</button>
								<input type="hidden" class="iId" value="${i.iId }">	
							</div>
						</c:if>
					</c:forEach>
					<button class="iAdd">옵션 추가</button>
					<input type="hidden" class="qId" value="${qq.qId }">
					<button class="qDel">질문 삭제</button>
				</div><br>			
			</c:forEach>
		</c:if>
		<button id="updateBtn">작성 완료</button>
	</div><!-- midDiv -->
	<hr>
	<div id="botDiv" align="center">
		
	</div>
</body>
<script>
	$(document).on('click', '#updateBtn', function () {
		let questions = [];
		$('.qDiv').each( function() {
			let q_id = $(this).find('.qId').val();
			let q_value = $(this).find('.qValue').val();
			let q_type = $(this).find('.qType option:selected').val();
			let items = [];

			let i_div = $(this).find('.iDiv').get(); 
			$(i_div).each(function () {
				let i_id = $(this).find('.iId').val();
				let i_value = $(this).find('.iValue').val();
				let item = {
					iId: i_id,
					iValue: i_value
				};
				items.push(item);
			});
				
			let question = {
				qId: q_id,
				qValue: q_value,
				type: q_type,
				items: items
			};
			questions.push(question);
		});

		let s_id = $('#sId').val();
		let s_title = $('#title').val();
		let s_desc = $('#sDesc').val();

		let survey = {
			sId: s_id,
			title: s_title,
			sDesc: s_desc,
			questions: questions
		};

		console.log(survey);

		$.ajax({
			type : "POST", 
			url : "/survey/jsonUpdate",  
			dataType : 'json',      
			contentType : 'application/json',            
			data : JSON.stringify(survey),                   
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
		let qId = $(this).prev().val();
		
		
		$.ajax({
			method: "POST",
			url: "/survey/qDel",
			data: { sId: sId, qId: qId }
		})
		.done(function( msg ) {
		    $('#midDiv').html(msg);
		});
	});
	
	//	옵션 추가
	$(document).on('click', '.iAdd', function(){
		let sId = $('#sId').val();
		let qId = $(this).next().val();

		$.ajax({
			method: "POST",
			url: "/survey/iAdd",
			data: { sId: sId, qId: qId }
		})
		.done(function( msg ) {
		    $('#midDiv').html(msg);
		});
	});

	//	옵션 삭제
	$(document).on('click', '.iDel', function(){
		let sId = $('#sId').val();
		let iId = $(this).next().val();

		console.log(iId);
		
		$.ajax({
			method: "POST",
			url: "/survey/iDel",
			data: { sId: sId, iId: iId }
		})
		.done(function( msg ) {
		    $('#midDiv').html(msg);
		});
	});
	
</script>
</html>