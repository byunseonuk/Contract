<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container {
		min-width:1300px;
	}
	
	.sideNav {
		float: left;
    width: 220px;
	}
	
	.resume_wrap {
		float: right;
    width: 1000px;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="resume_wrap">
			<c:forEach var="resume" items="${resumeList}">
			<div>
				<div>
					<h3><a href="showResume?resume_id=${resume._id}" target="blank" >${resume.title}</a></h3>
				</div>
				<div>
					<button type="button">수정</button>
				</div>
			</div>
			</c:forEach>
		</div>
		
		<div class="sideNav">
			<ul>
				<li><a href="./myPage">내 정보 보기</a></li>
				<li><a href="./changeMyInfo">내 정보 변경</a></li>
				<li><a href="./">비밀번호 변경</a></li>
				
				<c:if test="${loginInfo.role=='employee'}">
				<li><a href="resume/resumeForm">이력서 작성</a></li>
				<li><a href="resume/myResumeList">이력서 보기</a></li>
				<li>
					<form method="post" name="myApplyList" action="apply/myApplyList">
					</form>
					<a href="#" onclick="javascript:document.myApplyList.submit();">지원목록</a>
				</li>
				</c:if>
				
				<c:if test="${loginInfo.role=='employer'}">
				<li><a href="recruit/myRecruit">등록한 공고 보기</a></li>
				<li><a href="recruit/recruitForm">채용공고 작성</a></li>
				</c:if>
				<li>
					<form method="get" name="myContractList" action="contract/myContractList">
					</form>
					<a href="#" onclick="javascript:document.myContractList.submit();">내 계약서 확인</a>
				</li>
				<li><a href="contract/ingContract">진행중인 계약보기</a></li>
			</ul>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		function showResume(resume_id){
			location.href="showResume?resume_id="+resume_id;
		}
	</script>
</body>
</html>