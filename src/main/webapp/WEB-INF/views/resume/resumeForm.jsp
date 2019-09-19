<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.exam.test.model.AuthInfoVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container {
		width: 800px;
		margin: 0 auto;
	}
	
	.user_info {
	
	}
	
	.user_info .row {
	
	}
	
	.user_info .row .user_info_item {
		font-size: 20px;
	}
	
	.user_info .row .user_info_item label {
	
	}
	
	.career_info {
	
	}
	
	.career_info .career_item_wrap {
		
	}
	
	.career_item, .certificate_item, .language_item {
		padding: 15px;
		border-bottom: 1px solid;
	}
	
	.row {
		
		margin-bottom: 10px;
		font-size: 0;
	}
	
	/* .career_info .career_item_wrap .career_item .row */ 
	.input_val {
		display: inline-block;
    height: 65px;
    position: relative;
    border: 1px solid;
    width: 180px;
	}
	
	/* .career_info .career_item_wrap .career_item .row */
	 .input_val label{
		position: absolute;
    top: 5px;
    left: 5px;
    font-size: 12px;
	}
	
/* 	.career_info .career_item .row .input_val label:focus{
		font-size:5px;
		top:2px;
		left:2px;
	} */
	
	/* .career_info .career_item_wrap .career_item .row  */
	.input_val input {
		font-size: 18px;
    height: 60px;
    padding: 30px 10px 0 10px;
    box-sizing: border-box;
    border: none;
    outline: none;
    width: 100%;
	}
	
	.input_val select {
		height: 60px;
    font-size: 15px;
    padding: 30px 10px 0px 10px;
    box-sizing: border-box;
    border: none;
    outline: none;
    width: 100%;
	}
	
	.certificate_name, .language_kinds, .schoolName {
		width: 337px;
	}
	
	.certificate_publisher, .language_score {
		width: 196px;
	}
/* 	.career_info .career_item .row .input_val input:focus{
		font-size:10px;
		height:40px;
	} */
	
	.row .input_val_long {
    width: 726px;
	}
	
	.add_btn {
		width: 100%;
    background: #49cefa;;
    border: none;
    padding: 0;
    height: 45px;
	}

	.add_btn span {
	
	}
	
	.education_info {
		padding:15px;
	}
	
	.self_info {
		margin-bottom: 60px;
	}
	
	.selfIntroductionArea {
		height: 500px;
    width: 100%;
    font-size: 21px;
	}
	
	.btn_wrap {
		text-align:center;
	}
	
	.btn_wrap button {
		width: 200px;
    height: 60px;
	}
</style>
</head>
<body>
	<div class="container">
		<div>
			<form id="resumeData">
				<div class="user_info">
					<div class="row">
						<div class="user_info_item">
							<label>이름</label>
							<span>${loginInfo.name}</span>
						</div>
						<div class="user_info_item">
							<label>생년월일</label>
							<span></span>
						</div>
						<div class="user_info_item">
							<label>성별</label>
							<span></span>
						</div>
					</div>
					
					<div class="row">
						<div class="user_info_item">
							<label>휴대전화</label>
							<span>${loginInfo.phone}</span>
						</div>
						<div class="user_info_item">
							<label>이메일</label>
							<span>${loginInfo.email}</span>
						</div>
						<div class="user_info_item"> 
							<label>주소</label>
							<span></span>
						</div>
					</div>
					<input type="hidden" name="user_id" value="${loginInfo._id}"/>
					<c:if test="${resume!=null}">
						<input type="hidden" name="_id" value="${resume._id}"/>
					</c:if>
				</div>
				<div>
					<input type="text" name="title" />
				</div>
				<div class="career_info">
					<h2>경력사항</h2>
					<div id="career" class="career_item_wrap"></div>
					<button type="button" onclick="addCareer()" class="add_btn"><span>+ 추가</span></button>
				</div>
				
				<div class="certificate_info">
					<h2>자격증</h2>
					<div id="certificate" class="certificate_item_wrap"></div>
					<button type="button" onclick="addCertificate()" class="add_btn"><span>+ 추가</span></button>
				</div>
				
				<div class="language_info">
					<h2>외국어</h2>
					<div id="language" class="language_item_wrap"></div>
					<button type="button" onclick="addLanguage()" class="add_btn"><span>+ 추가</span></button>
				</div>

				<div class="education_info">
					<h2>학력</h2>
					<div class="">
						<div class="row">
							<div class="input_val">
								<label for="">학력구분</label>
								<select class="" id="">
									<option value="고등학교">고등학교</option>
									<option value="대학교(2,3년)">대학교(2,3년)</option>
									<option value="대학교(4년)">대학교(4년)</option>
									<option value="대학원">대학원</option>
								</select>
							</div>
	
							<div class="input_val schoolName">
								<label>학교명</label>
								<input type="text" name="schoolName"/>
							</div>
							
							<div class="input_val">
								<label>전공</label>
								<input type="text" name="major" class=""/>
							</div>
						</div>
						<div class="row">
							<div class="input_val">
								<label>입학일</label>
								<input type="text" name="admissionDate" class=""/>
							</div>
							
							<div class="input_val">
								<label>졸업일</label>
								<input type="text" name="graduationDate" class=""/>
							</div>
							<div class="input_val">
								<label>졸업일</label>
								<select name="educationState">
									<option value="졸업">졸업</option>
									<option value="재학중">재학중</option>
									<option value="중퇴">중퇴</option>
								</select>
							</div>
						</div>
					</div>
				</div>

				<div class="self_info">
					<h2>자기소개서</h2>
					<textarea rows="20" cols="40" name="selfIntroduction" class="selfIntroductionArea"></textarea>
				</div>
				<div class="btn_wrap">
					<button type="button" id="submitbtn" onclick="submitResume('new')">저장하기</button>
					<button type="button" onclick="location.href='myResumeList'">취소</button>
				</div>
			</form>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<script type="career-template" id="careerTemplate">
		<div class="career_item" id="career{index}">
			<div class="row">
				<div class="input_val">
					<label for="startDate">시작년월</label>
					<input type="text" id="startDate" name="careerList[{index}].startDate" value="${career.startDate}"/>
				</div>
				<div class="input_val">
					<label for="endDate">종료년월</label>
					<input type="text" id="endDate" name="careerList[{index}].endDate" value="${career.startDate}"/>
				</div>
				<div class="input_val">
					<label for="companyName">회사명</label>
					<input type="text" id="companyName" name="careerList[{index}].companyName" value="${career.companyName}"/>
				</div>
				<div class="input_val">
					<label for="position">직위</label>
					<input type="text" id="position" name="careerList[{index}].position" value="${career.position}"/>
				</div>
			</div>
			<div class="row">
				<div class="input_val input_val_long">
					<label for="work">활동내용</label>
					<input type="text" id="work" name="careerList[${status.index}].work" value="${career.work}"/>
				</div>
			</div>
			<input type="hidden" name="careerList[{index}]._id" value="${career._id}">
			<button type="button" onclick="deleteCareer({index})">삭제</button>
		</div>
	</script>
	
	<script type="certificate-template" id="certificateTemplate">
		<div class="career_item" id="certificate{index}">
			<div class="row">
				<div class="input_val">
					<label for="date">취득일</label>
					<input type="text" id="date" name="certificateList[{index}].date" value="${certificate.date}"/>
				</div>
				<div class="input_val certificate_name">
					<label for="certificate_name">자격증명</label>
					<input type="text" id="certificate_name" name="certificateList[{index}].name" value="${certificate.name}"/>
				</div>
				<div class="input_val certificate_publisher">
					<label for="publisher">발행처</label>
					<input type="text" id="publisher" name="certificateList[{index}].publisher" value="${certificate.publisher}"/>
				</div>
			</div>
			<input type="hidden" name="certificateList[{index}]._id" value="${certificate._id}">
			<button type="button" onclick="deleteCertificate({index})">삭제</button>
		</div>
	</script>
	
	<script type="language-template" id="languageTemplate">
		<div class="language_item" id="language{index}">
			<div class="row">
				<div class="input_val">
					<label for="date">취득일</label>
					<input type="text" id="date" name="languageList[{index}].date" value="${language.startDate}"/>
				</div>
				<div class="input_val language_kinds">
					<label for="kinds">종류</label>
					<input type="text" id="kinds" name="languageList[{index}].kinds" value="${language.startDate}"/>
				</div>
				<div class="input_val language_score">
					<label for="score">점수</label>
					<input type="text" id="score" name="languageList[{index}].score" value="${language.companyName}"/>
				</div>
			</div>
			<input type="hidden" name="languageList[{index}]._id" value="${language._id}">
			<button type="button" onclick="deleteLanguage({index})">삭제</button>
		</div>
	</script>
	
	<script>
		var careerIndex=0;
		var certificateIndex=0;
		var languageIndex=0;
		
		$(document).ready(function(){
			console.log($('#careerTemplate').text());
			/* console.log(${careerList==null});
			console.log(${careerList});
			if(${method=='modify'}){
				if(${careerList!=null})
					careerIndex=${careerList.size()};
				if(${certificateList!=null})
					certificateIndex=${certificateList.size()};
				if(${languageList!=null})
					languageIndex=${languageList.size()};
				$("textarea[name='selfIntroduction']").val("${resume.selfIntroduction}");
				$("input[name='admissionDate']").val("${resume.admissionDate}");
				$("input[name='graduationDate']").val("${resume.graduationDate}");
				$("input[name='schoolName']").val("${resume.schoolName}");
				$("input[name='major']").val("${resume.major}");
				$("select[name='educationState']").val("${resume.educationState}");
			} */
		});
		
		function submitResume(method){
			var url;
			if(method=='new'){
				url = 'insertResume';
			}else if(method=='modify'){
				url = 'modifyResume';
			}
			var resumeData = $('#resumeData').serialize();
			$.ajax({
				type:'post',
				url:url,
				data:resumeData,
				error:function(){
					alert("오류가 발생하였습니다. 다시 시도해주세요");
				},
				success:function(result){
					alert("이력서 저장 성공");
					location.href='myResume';
				}
			})
		}
		
		function addCareer(){
			/* $("#career").append('<tr id="career'+careerIndex+'"><td><input type="text" name="careerList['+careerIndex+'].term"/></td>'+
						'<td><input type="text" name="careerList['+careerIndex+'].companyName"></td>'+
						'<td><input type="text" name="careerList['+careerIndex+'].position"/></td>'+
						'<td><input type="text" name="careerList['+careerIndex+'].work"/></td>'+
						'<td><button type="button" onclick="deleteCareer('+careerIndex+')">삭제</button></td></tr>');
 */
			let html = $('#careerTemplate').text();
			let resultHtml = html.replace(/{index}/gi,careerIndex);
			
			$("#career").append(resultHtml);
			careerIndex++;
		}
		
		function addCertificate(){
			/* $("#certificate").append('<tr id="certificate'+certificateIndex+'"><td><input type="text" name="certificateList['+certificateIndex+'].name"/></td>'+
					'<td><input type="text" name="certificateList['+certificateIndex+'].publisher"></td>'+
					'<td><input type="text" name="certificateList['+certificateIndex+'].date"/></td>'+
					'<td><button type="button" onclick="deleteCertificate('+certificateIndex+')">삭제</button></td></tr>'); */
			let html = $('#certificateTemplate').text();
			let resultHtml = html.replace(/{index}/gi,certificateIndex);
			
			$("#certificate").append(resultHtml);
			certificateIndex++;
		}
		
		function addLanguage(){
/* 			$("#language").append('<tr id="language'+languageIndex+'"><td><input type="text" name="languageList['+languageIndex+'].kinds"></td>'+
					'<td><input type="text" name="languageList['+languageIndex+'].score"></td>'+
					'<td><input type="text" name="languageList['+languageIndex+'].date"/></td>'+
					'<td><button type="button" onclick="deleteLanguage('+languageIndex+')">삭제</button></td></tr>'); */
			let html = $('#languageTemplate').text();
			let resultHtml = html.replace(/{index}/gi,languageIndex);
			
			$("#language").append(resultHtml);
			languageIndex++;
		}
		
		function deleteCareer(index){
			$("#career").find('#career'+index).remove();
			
		}
		function deleteCertificate(index){
			$("#certificate").find('#certificate'+index).remove();
			
		}
		function deleteLanguage(index){
			$("#language").find('#language'+index).remove();
			
		}

	</script>
</body>
</html>
<!--                                  resume_id
	이름, 연락처, 주소, 나이, 생년월일,          user_id
	경력사항(기간, 회사명, 직위, 업무내용)        career_id, 이력서번호
	자격증(자격증명, 취득일, 발행처)             certificate_id, 이력서번호
	외국어(종류, 점수, 취득일)									foreign_language_id ,이력서번호
	최종학력(입학일, 졸업일, 재학여부, 학교명)			resume_id
	자기소개()															resume_id
	
	이력서번호, 유저번호, 최종학력 입학일, 졸업일, 재학여부, 학교명, 분야, 자기소개
 -->