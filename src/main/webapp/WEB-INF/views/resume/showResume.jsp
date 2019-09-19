<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	body {
		background: #edeef0;
	}
	
	.container {
		width:800px;
		margin:auto;
	}
	
	.item {
		color: #9E9E9E;
    width: 105px;
    display: inline-block;
	}
	
	table {
		 text-align:center;
	}
	
	h2, h3 {
		border-bottom: 1px solid;
		padding:15px 0;
	}
	h2, h3, h4, p {
		margin: 0;
	}
	.wrap {
		padding: 20px;
		background: #fff;
	}
	
	.career_wrap, .certificate_wrap, .language_wrap {
		background: #fff;
	}
	
	.career_wrap .career_item, .certificate_wrap .certificate_item, .language_wrap .language_item {
		padding: 20px 20px 20px 250px;
    position: relative;
    border-bottom: 1px solid #8080802b;
	}
	
	.career_wrap .career_item .date, .certificate_wrap .certificate_item .date, .language_wrap .language_item .date {
		position: absolute;
    left: 35px;
    top: 26px;
	}
	
	.career_wrap .career_item .content {
		width: 100%;
	}
	
	.career_wrap .career_item .content .position {
		color: #9E9E9E;
    width: 60px;
    display: inline-block;
	}
	
	.certificate_item .content .name, .language_item .content .name {
		padding-right: 50px;
    font-weight: bold;
    font-size: 19px;
	}
	
	.certificate_item .content .agency {
	
	}
</style>
</head>
<body>
   <div class="container">
   	<h2>이력서</h2>
   	<div class="wrap">
   		<div class="photo"></div>
   		<div>
	   		<p><span class="item">이름</span>${user.name}</p>
	   		<p><span class="item">휴대전화</span>${user.phone}</p>
	   		<p><span class="item">이메일</span>${user.email}</p>
   			<p><span class="item">주소</span></p>
			</div>
		</div>
		
   	<h3>최종학력</h3>
   	<div class="wrap">
   		<p><span class="item">학교명</span></p>
   		<p><span class="item">입학일</span>${resume.graduationDate}</p>
   		<p><span class="item">졸업일</span>${resume.admissionDate}</p>
   		<p><span class="item">상태</span>${resume.educationState}</p>
   		<p><span class="item">전공</span>${resume.major}</p>
   	</div>
   	
   	<h3>경력</h3>
   	<div class="career_wrap">
   		<c:forEach var="career" items="${careerList}">
   		<div class="career_item">
   			<div class="date">
   				<p>${career.startDate} ~ ${career.endDate}</p>
	   		</div>
	   		<div class="content">
	   			<h4>${career.companyName}</h4>
	   			<span class="position">직위</span>${career.position}
	   			<p>${career.work}</p>
	   		</div>
   		</div>
  		</c:forEach>
   	</div>
 		
 		<h3>자격증</h3>
 		<div class="certificate_wrap">
 			<c:forEach var="certificate" items="${certificateList}">
 			<div class="certificate_item">
 				<div class="date">
   				<p>${certificate.date}</p>
	   		</div>
	   		<div class="content">
	   			<span class="name">${certificate.name}</span>
	   			<span class="agency">${certificate.publisher}</span>
	   		</div>
 			</div>
 			</c:forEach>
 		</div>
 		
 		
 		<h3>외국어</h3>
 		<div class="language_wrap">
 			<c:forEach var="language" items="${languageList}">
 			<div class="language_item">
 				<div class="date">
   				<p>${language.date}</p>
	   		</div>
	   		<div class="content">
	   			<span class="name">${language.kinds}</span>
	   			<span class="score">${language.score}</span>
	   		</div>
 			</div>
 			</c:forEach>
 		</div>
	</div>
	<c:if test="${loginInfo.role=='employee' && loginInfo._id == resume.user_id}">
	<form method="post" action="modifyResumeForm">
		<input type="hidden" name="resume_id" value="${resume._id}">
		<button type="submit">이력서 수정</button>
	</form>
	<button type="button" onclick="location.href='myResumeList'">목록으로</button>
	</c:if>
	<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
</body>
</html>