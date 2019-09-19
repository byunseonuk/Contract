<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채용공고</title>
</head>
<body>
	<h4 id="area"></h4>
	<div>
		<ul>
			<li>
				<p><a href="http://localhost:8080/test/public/recruitArea?aCod=0">지역별</a></p>
				<p>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=0">서울</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=1">경기</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=2">인천</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=3">부산</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=4">대구</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=5">강원</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=6">충북</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=7">충남</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=8">전북</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=9">전남</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=10">경북</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=11">경남</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=12">대전</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=13">제주</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=14">울산</a>
					<a href="http://localhost:8080/test/public/recruitArea?aCod=15">광주</a>
				</p>
			</li>
		</ul>
	</div>
	<div>
		<ul>
		<c:forEach var="recruit" items="${recruitList}">
			<li>
				<a href="detailView?rcodnum=${recruit._id}">
					<span>${recruit.company}</span>
					<span>${recruit.title}</span>
					<span>${recruit.workTime}</span>
					<span>${recruit.workType}</span>
					<span>마감일 ${recruit.endDate}</span>
				</a>
			</li>
		</c:forEach>
		</ul>
	</div>
	<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		var area = ['서울','경기','인천','부산','대구','강원','충북','충남','전북',
			'전남','경북','경남','대전','제주','울산','광주'];
		$(document).ready(function(){
			$('#area').text(area[${area}]);
		});
	</script>
</body>
</html>