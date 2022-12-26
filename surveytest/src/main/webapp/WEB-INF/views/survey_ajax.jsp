<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sDiv">
	${s.sId } / ${s.title } / ${s.sDesc }
	<input type="hidden" id="sId" value="${s.sId }">
</div>
<button id="qAdd">질문 추가</button>
<c:if test="${!empty q }">
	<c:forEach var="qq" items="${q }" >
		<div class="qDiv">
			qId = ${qq.qId } / qType = ${qq.type } / qValue = ${qq.qValue }
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