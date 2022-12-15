<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>설문지</title>
<style>
	#allDiv{
		width: 600px;
		margin-left: auto;
		margin-right: auto; 
	}
	#title, #description{
		width: 400px;
	}
	.qValue{
		width: 250px;
	}
	.questionDiv{
		width: 400px;
		border: 1px solid black;
	}
	.question{
		margin-bottom: 10px;
	}
	.item{
		margin-top: 10px;
		margin-left: 30px;
		margin-bottom: 10px;
	}
	.iValue{
		width: 300px;
	}
</style>
<script src="//code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>
	<div id="topDiv">
		<h2>설문지제목</h2>sId = ${s.sId }
		<div id="btnDiv" style="float: right;">
			<a href="/">뒤로가기</a>
			<a href="/survey/delete?sId=${s.sId}">삭제하기</a>
		</div>
	</div>			
	<div id="allDiv">
		<div align="center">
			<a href="">질문</a>
			<a href="">응답</a>
		</div>	
		<hr>
		<div id="midDiv" align="center">
			<div id="surveyDiv" align="center">
				<input type="hidden" name="sId" id="sId" value="${s.sId }">
				<input type="text" name="title" id="title" placeholder="설문지 제목" value="${s.title }">
				<br>
				<input type="text" name="description" id="description" placeholder="설문지 설명" value="${s.description }">
			</div>
			<hr>
			<button class="qAddBtn">질문 추가</button><br>
			<c:if test="${not empty q}">
				<c:forEach items="${q }" var="list">
					<c:choose>
						<c:when test="${list.type == 1 }">
							<input type="hidden" name="qId" value="${list.qId }">
							<div class="questionDiv" align="center">
								<input type="hidden" name="qId" value="${list.qId }">
								<div class="question">
									<input type="text" name="qValue" class="qValue" placeholder="질문">
									<select name="qType">
										<option value="1" selected>객관식 질문</option>
										<option value="2">체크 박스</option>
										<option value="3">드롭 다운</option>
									</select>
									<div class="item" align="left">
										<input type="text" name="iValue" class="iValue">
										<button>X</button>
									</div>
									<button>옵션 추가</button> 또는 <button>'기타' 추가</button>
								</div>
							<button class="qDelBtn">질문 삭제</button>
							</div><!-- questionDiv -->
						</c:when>
						<c:when test="${list.type == 2 }">
							<input type="hidden" name="qId" value="${list.qId }">
							<div class="questionDiv" align="center">
								<input type="hidden" name="qId" value="${list.qId }">
								<div class="question">
									<input type="text" name="qValue" class="qValue" placeholder="질문">
									<select name="qType">
										<option value="1">객관식 질문</option>
										<option value="2" selected>체크 박스</option>
										<option value="3">드롭 다운</option>
									</select>
									<div class="item" align="left">
										<input type="text" name="iValue" class="iValue">
										<button>X</button>
									</div>
									<button>옵션 추가</button> 또는 <button>'기타' 추가</button>
								</div>
							<button class="qDelBtn">질문 삭제</button>
							</div><!-- questionDiv -->
						</c:when>
					</c:choose>
				</c:forEach>
			</c:if>	
		</div>
		<hr>
		<div id="botDiv" align="center">
		</div>
	</div><!-- allDiv -->
</body>
<script>
	//	ajax 수정	
	$("input").change(function (){

		let sId = $('#sId').val();
		let title = $('#title').val();
		let description = $('#description').val();
		
		$.ajax({
			method: "POST",
			url: "/survey/edit",
			data: { sId: sId, title: title, description: description }
		})
		
		.done(function( msg ) {
		    $('#allDiv').html(msg);
		});
		
		location.reload();
		
	});

	//	질문 추가
	$(document).on('click', '.qAddBtn', function(){

		let sId = $('#sId').val();
		
		$.ajax({
			method: "POST",
			url: "/survey/addQuestion",
			data: { sId: sId }
		})
		
		.done(function( msg ) {
		    $('#allDiv').html(msg); 
		});
		
		location.reload();
	});

	//	질문 삭제
	$(document).on('click', '.qDelBtn', function(){
		$(this).parent().remove();
	});
</script>
</html>