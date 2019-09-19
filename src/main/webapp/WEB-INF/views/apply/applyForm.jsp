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
	<form id="applyForm" method="post">
	<c:forEach var="resume" items="${resumeList}">
		<div>
			<input type="radio" name="resume_id" value="${resume._id}"/>
			<input type="hidden" name="recruit_id" value="${recruit_id}"/>
			<label>이력서 번호(이력서 title? )</label>
			<span>${resume._id}</span>
		</div>
	</c:forEach>
	<a href="/test/resume/resumeForm" target="_blank">새 이력서 작성</a>
	<button type="button" onclick="submitApply()">제출</button>
	</form>
	<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		function submitApply(){
			var applyForm = $('#applyForm').serialize();
			$.ajax({
				url:'apply',
				type:'POST',
				data:applyForm,
				error: function(){
					alert("오류가 발생하였습니다. 다시 시도해주세요");
				},
				success: function(result){
					if(result=="true"){
						alert("정상적으로 지원되었습니다.");
						window.close();
					} else {
						alert("오류가 발생하였습니다. 다시 시도해주세요");
					}
					
				}
			});
		}
		
		
	</script>
</body>
</html>