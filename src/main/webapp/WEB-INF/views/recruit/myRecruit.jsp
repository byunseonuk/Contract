<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>Insert title here</title>
<style>
	.container {
		width:70%;
		margin:auto;
	}
	
	table{
		width:100%;
		border-collapse: collapse;
		text-align: center;
	}
	
	
	th {
		border-bottom: 1px solid;
	}
	
	tr {
		height:70px;
	}
	
	td {
		height:50px;
		border-bottom: 1px solid;
	}
</style>
</head>
<body>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>공고 제목</th>
					<th>등록일</th>
					<th>마감일</th>
					<!-- <th>지원자 수</th> -->
					<th>마감여부</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="recruit" items="${myRecruitList}">
					<tr>
						<td>${recruit.title}</td>
						<td><fmt:formatDate value="${recruit.createdAt}" pattern="yyyy-MM-dd"/></td>
						<td>${recruit.endDate}</td>
						<!-- <td></td> -->
						<%-- <c:choose>
							<c:when test="${recruit.isEnded}"><td>마감됨</td></c:when>
							<c:when test="!${recruit.isEnded}"><td>진행중</td></c:when>
						</c:choose> --%>
						<c:if test="${recruit.isEnded ==true}"><td>마감됨</td></c:if>
						<c:if test="${recruit.isEnded ==false}"><td>진행중</td></c:if>
						<td><button onclick="openDialog(${recruit._id})" data-toggle="modal" data-target=".bs-example-modal-lg">지원자 보기</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="dialog">
		<ul id="list">
		</ul>
	</div>
	<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		function openList(recruit_id){
			var option = 'scrollbars=yes, resizeable=no, width=300, height=400, left=20, right=20';

			window.open('recruit/applicantList?recruit_id='+recruit_id,'',option);
		}
		
		function openDialog(recruit_id){
			$.ajax({
				type:"POST",
				url:"/test/recruit/applicantList",
				//dataType:"json",
				data:{
					recnum:recruit_id
				},
				error: function(){
					alert("오류가 발생하였습니다. 다시 시도해주세요");
				},
				success: function(resultData){
					/* if(result.result=="empty"){
						$("#list").append('<h3>지원자가 없습니다.</h3>');
					}else{
						var data = result.resultData;
						for(var i=0;i<data.length;i++){
							$("#list").append('<li><span>이름 :'+data[i].user_name+'</span>'+
												'<p>소개 : '+data[i].educationState+'</p>'+
												'<div><button type="button" class="btn btn-primary"'+
												'onclick="showResume('+data[i].resume_id+')">이력서보기</button>'+
												'<form method="post" action="contract/contractForm">'+
												'<input type="hidden" name="employee" value="'+data[i].user_id+'"/>'+
												'<input type="hidden" name="employer" value="'+${loginInfo._id}+'"/>'+
												'<input type="hidden" name="apply" value="'+data[i].apply_id+'"/>'+
												'<button type="submit">계약하러가기</button></form></div></li>');
						}
					} */
					let result = resultData.result;
					if(result==="empty"){
						$("#list").append('<h3>지원자가 없습니다.</h3>');
					}else if(result==="success"){
						let data = resultData.data;
						console.log(data);
						for(var i=0;i<data.length;i++){
							$("#list").append('<li><span>이름 :'+data[i].user_name+'</span>'+
												'<p>소개 : '+data[i].educationState+'</p>'+
												'<div><button type="button" class="btn btn-primary"'+
												'onclick="showResume('+data[i].resume_id+')">이력서보기</button>'+
												'<form method="post" action="/test/contract/contractForm">'+
												'<input type="hidden" name="employee" value="'+data[i].user_id+'"/>'+
												'<input type="hidden" name="employer" value="'+${loginInfo._id}+'"/>'+
												'<input type="hidden" name="apply" value="'+data[i].apply_id+'"/>'+
												'<button type="submit">계약하러가기</button></form></div></li>');
						}
					}
					applicantList_dialog.dialog("open");
				}
			});
		}
		
		var applicantList_dialog;
		$(document).ready(function(){
			applicantList_dialog = $("#dialog").dialog({
				autoOpen:false,
				height:400,
				width:350,
				modal: true,
				close:function(event,ui){
					$("#list").empty();
				}
			});
		});
		
		function showResume(resume_id){
			var option = 'scrollbars=yes, resizeable=no, width=800, height=700, left=20, right=20';
			var url = 'http://localhost:8080/test/resume/showResume?resume_id='+resume_id;
			console.log(url);
			window.open(url,'',option);
		}
		
	</script>
</body>
</html>