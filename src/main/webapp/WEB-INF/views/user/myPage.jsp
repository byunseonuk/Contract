<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
</head>
<body>
	<div>
		<div>
			<ul>
				<li><a href="./myPage">내 정보 보기</a></li>
				<li><a href="./changeMyInfo">내 정보 변경</a></li>
				<li><a href="./">비밀번호 변경</a></li>
				<c:if test="${loginInfo.role=='employee'}">
				<li><a href="resume/resumeForm">이력서 작성</a></li>
				<li><a href="resume/myResume">이력서 보기</a></li>
				<li>
					<form method="post" name="myApply" action="apply/myApply">
					</form>
					<a href="#" onclick="javascript:document.myApply.submit();">지원목록</a>
				</li>
				</c:if>
				<c:if test="${loginInfo.role=='employer'}">
				<li><a href="recruit/myRecruit">등록한 공고 보기</a></li>
				<li><a href="recruit/recruitForm">채용공고 작성</a></li>
				</c:if>
				<li>
					<form method="get" name="myContract" action="contract/myContract">
					</form>
					<a href="#" onclick="javascript:document.myContract.submit();">내 계약서 확인</a>
				</li>
				<li><a href="contract/ingContract">진행중인 계약보기</a></li>
			</ul>
		</div>
		<div>
			<h2>내 정보</h2>
			<ul>
				<li>${myInfo.name}</li>
				<li>${myInfo.phone}</li>
				<li>${myInfo.email}</li>
			</ul>
		</div>
	</div>
</body>
</html>