<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<c:if test ="${applyList.size()!=0}">
		<ul>
		<c:forEach var="apply" items="${applyList}">
			<li>
				<span>${apply.recruit_title}</span>
				<span>${apply.company}</span>
				<c:if test="${apply.state==\"wait\"}">
					<span>지원완료(대기중)</span>
				</c:if>
				<c:if test="${apply.state==\"selected\"}">
					<span>합격</span>
					<button type="button" onclick="openContract(${apply.contract_id})">계약서 보기</button>
				</c:if>
				<c:if test="${apply.state==\"completed\"}">
					<span>계약완료</span>
				</c:if>
			</li>
		</c:forEach>
		</ul>
		</c:if>
		<c:if test="${applyList.size()==0}">
			<h2>지원한 회사가 없습니다.</h2>
		</c:if>
	</div>
	<div id="dialog"></div>
	<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		var contract_dialog;
		contract_dialog = $('#dialog').dialog({
			autoOpen:false,
			height:700,
			width:600,
			modal: true,
			close:function(event,ui){
				$("#list").empty();
			}
		});
		function openContract(contract_id){
			var url = 'http://localhost:8080/test/contract/viewContract';
			$('#dialog').load(url,{"contract_id":contract_id});
			contract_dialog.dialog("open");
		}
	</script>
</body>
</html>