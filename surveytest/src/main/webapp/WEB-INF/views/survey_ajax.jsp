<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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