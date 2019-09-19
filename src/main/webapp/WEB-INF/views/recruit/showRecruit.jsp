<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${recruit.title}</title>
<style>
	.container {
		width:60%;
		margin:auto;
	}
	
	ul {
		list-style:none;
	}
	
	.recruit_wrap {
	
	}
	
	.recruit_wrap .recruit_head {
	
	}
	
	.recruit_wrap .recruit_head .recruit_title {
		border-top: 2px solid black;
		border-bottom: 1px solid gray;
		height: 80px;
    text-align: center;
    line-height: 77px;
	}
	
	.recruit_wrap .recruit_head .recruit_company_info {
		padding-bottom: 10px;
    border-bottom: 1px solid;
	}
	
	.recruit_company_info ul li {
		margin-bottom: 10px;
	}
	
	.item {
		color: #9E9E9E;
    width: 105px;
    display: inline-block;
	}
	
	.recruit_body{
		padding-bottom: 10px;
    border-bottom: 1px solid;
	}
	
	.recruit_body .recruit_info_wrap {
	
	}
	
	.recruit_body .recruit_info_wrap .recruit_info {
	
	}
	
	.recruit_body .work_info {
	
	}
	
	.apply_btn_wrap {
    text-align: center;
    padding: 20px;
	}
	
	.apply_btn_wrap .apply_btn {
		width: 230px;
    height: 60px;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="recruit_wrap">
			<h4>채용정보 상세보기</h4>
			<div class="recruit_head">
				<h2 class="recruit_title">${recruit.title}</h2>
				<div class="recruit_company_info">
					<ul>
						<li><span class="item">회사명</span>${recruit.company}</li>
						<li><p><strong>${recruit.company} 채용 담당자</strong></p></li>
						<li><span class="item">이름</span>${recruit.managerName}</li>
						<li><span class="item">전화번호</span>${recruit.managerTel}</li>
						<li><span class="item">이메일</span>${recruit.managerEmail}</li>
					</ul>
				</div>
			</div>
			<div class="recruit_body">
				<div class="recruit_info_wrap">
					<div class="recruit_info">
						<h3>지원자격</h3>
						<ul>
							<li><span class="item">경력</span></li>
							<li><span class="item">성별</span>${recruit.gender}</li>
							<li><span class="item">연령</span>${recruit.age}</li>
							<li><span class="item">학력</span>${recruit.education}</li>
						</ul>
					</div>
					<div class="recruit_info">
						<h3>모집내용</h3>
						<ul>
							<li><span class="item">모집직종</span>${recruit.workType}</li>
							<li><span class="item">고용형태</span></li>
							<li><span class="item">모집인원</span>${recruit.personnel}</li>
						</ul>
					</div>
				</div>
				<div class="work_info">
					<h3>근무조건</h3>
					<ul>
						<li><span class="item">근무기간</span>${recruit.workPeriod}</li>
						<li><span class="item">근무요일</span>${recruit.workDay}</li>
						<li><span class="item">근무시간</span>${recruit.workTime}</li>
						<li><span class="item">우대사항</span>${recruit.preferential}</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="apply_btn_wrap">
			<button onclick="applyForm()" class="apply_btn">지원하기</button>
		</div>
	</div>
	
	<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		function applyForm(){
			var option = 'scrollbars=yes, resizeable=no, width=500, height=400, left=20, right=20';
			var url = 'http://localhost:8080/test/apply/applyForm?recnum='+${recruit._id};
			console.log(url);
			window.open(url,'',option);
		}
	</script>
</body>
</html>