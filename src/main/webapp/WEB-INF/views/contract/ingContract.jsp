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
	<table>
		<tr>
			<th>사업주<th>
			<th>근로자<th>
			<th>업무내용<th>
			<th>상태<th>
		</tr>
		<c:forEach var="ingcontract" items="${ingcontractList}">
		<tr>
			<td>${ingcontract.employer}</td>
			<td>${ingcontract.employee}</td>
			<td>${ingcontract.work_details}</td>
			<c:if test="${ingcontract.state=='wait'}">
				<td>수락 대기중</td>
			</c:if>
			<c:if test="${ingcontract.state=='accept' && loginInfo.role=='employee'}">
				<td>수락완료(확인 대기중)</td>
			</c:if>
			<c:if test="${ingcontract.state=='accept' && loginInfo.role=='employer'}">
				<td>수락완료</td>
				<td>
					<form method="post" action="contractRecordBlock">
						<input type="hidden" name="_id" value="${ingcontract._id}"/>
						<button type="submit">계약서 등록하기</button>
					</form>
				</td>
			</c:if>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>