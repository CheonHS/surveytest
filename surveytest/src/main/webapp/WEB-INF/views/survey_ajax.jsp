<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sDiv">
	<input type="hidden" id="sId" value="${s.sId }">
	title : <input type="text" id="title" value="${s.title }"><br>
	sDesc : <input type="text" id="sDesc" value="${s.sDesc }"><br>
</div>

<button id="qAdd">질문 추가</button>

<c:if test="${!empty s.questions }">
	<c:forEach var="qq" items="${s.questions }" >
		<div class="qDiv">
			<input type="text" class="qValue" value="${qq.qValue }">
			<select class="qType">
				<option value="1">객관식 질문</option>
				<option value="2">주관식 질문</option>
			</select> 		
			<c:forEach var="i" items="${qq.items }" >
				<c:if test="${!empty i }">
					<div class="iDiv" align="left">
						${i.rownum } / ${i.iValue } <button class="iDel">옵션 삭제</button>
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