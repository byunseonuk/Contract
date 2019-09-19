<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<c:if test="${contractList.size()==0}">
			<h2>계약서가 없습니다.</h2>
		</c:if>
		<c:if test="${contractList.size()!=0}">
			<table>
				<tr>
					<th>사업주</th>
					<th>사업주 연락처</th>
					<th>업무내용</th>
					<th>임금</th>
					<th>블록저장상태</th>
					<th></th>
				</tr>
				<c:forEach var="contract" items="${contractList}">
				<tr>
					<td>${contract.employer}</td>
					<td>${contract.employer_tel}</td>
					<td>${contract.work_details}</td>
					<td>${contract.salary}</td>
					<c:if test="${contract.recordBlock}">
						<td>기록됨</td>
					</c:if>
					<c:if test="${!contract.recordBlock}">
						<td>기록안됨</td>
					</c:if>
					<td><a href="viewContract?contract_id=${contract._id}">계약서보기</a></td>
				</tr>
				</c:forEach>
			</table>
			<input type="hidden" name="id" value="${loginInfo._id}"/>
			<input type="hidden" name="role" value="${loginInfo.role}"/>
		</c:if>
	</div>
	<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	<%-- <script src="<c:url value="/resources/js/checkRecordContract.js"/>" charset="utf-8"></script> --%>
	<%-- <script src="<c:url value="/resources/js/checkSocket.js"/>"/></script> --%>
</body>
</html>