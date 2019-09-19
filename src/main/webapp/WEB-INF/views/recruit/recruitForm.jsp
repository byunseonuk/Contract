<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style>
	.container {
		width:50%;
	}
	
	h2 , h3{
		border-bottom: 1px solid;
		padding-bottom: 10px;
	}

	.form_group_wrap {
		padding: 15px 0;
	}
	
	.recruit_btn_wrap {
		text-align: center;
    padding: 20px;
	}
	
	.recruit_btn_wrap .recruit_btn {
		width: 230px;
    height: 60px;
	}
</style>
</head>
<body>
	<div class="container">
		<h2>채용공고 등록</h2>
		<form class="form-horizontal" method="post" id="recruitForm">
			<div class="form_group_wrap">
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">공고제목</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="title" id="title" placeholder="공고제목">
					</div>
				</div>
				
			  <div class="form-group">
			    <label for="company" class="col-sm-2 control-label">회사명</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="company" id="company" placeholder="회사명">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="managerName" class="col-sm-2 control-label">등록자</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="managerName" id="managerName" placeholder="등록자">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="managerTel" class="col-sm-2 control-label">전화번호</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="managerTel" id="managerTel" placeholder="전화번호">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="managerEmail" class="col-sm-2 control-label">이메일</label>
			    <div class="col-sm-10">
			      <input type="email" class="form-control" name="managerEmail" id="managerEmail" placeholder="이메일">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="companyTel" class="col-sm-2 control-label">회사전화</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="companyTel" id="companyTel" placeholder="회사전화">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="address" class="col-sm-2 control-label">근무지주소</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="address" id="address" placeholder="근무지주소">
			    </div>
			  </div>
		  </div>
		  <h3>모집조건</h3>
	  	<div class="form_group_wrap">
			  <div class="form-group">
			    <label for="endDate" class="col-sm-2 control-label">모집마감일</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="endDate" id="endDate" placeholder="모집마감일">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="preferential" class="col-sm-2 control-label">우대사항</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="preferential" id="preferential" placeholder="우대사항">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="personnel" class="col-sm-2 control-label">모집인원</label>
			    <div class="col-sm-10">
			      <input type="number" class="form-control" name="personnel" id="personnel" placeholder="모집인원">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="age" class="col-sm-2 control-label">나이</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="age" id="age" placeholder="나이">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="gender" class="col-sm-2 control-label">성별</label>
			    <div class="col-sm-10">
			      <select class="form-control" name="gender" id="gender">
						  <option value="default">선택</option>
						  <option value="male">남자</option>
						  <option value="female">여자</option>
						  <option value="irrelevant">무관</option>
						</select>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="education" class="col-sm-2 control-label">학력</label>
			    <div class="col-sm-10">
			      <select class="form-control" name="education" id="education">
						  <option value="default">선택</option>
						  <option value="university">대졸이상</option>
						  <option value="college">초대졸이상</option>
						  <option value="high">고졸이상</option>
						  <option value="middle">중졸이상</option>
						  <option value="irrelevant">무관</option>
						</select>
			    </div>
			  </div>
		  </div>
		  <h3>근무조건</h3>
		  <div class="form_group_wrap">
			  <div class="form-group">
			    <label for="salary" class="col-sm-2 control-label">급여</label>
			    <div class="col-sm-10">
			      <input type="number" class="form-control" name="salary" id="salary" placeholder="급여">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="salaryType" class="col-sm-2 control-label">급여형태</label>
			    <div class="col-sm-10">
			      <select class="form-control" name="salaryType" id="salaryType">
						  <option value="default">선택</option>
						  <option value="time">시급</option>
						  <option value="day">하루일당</option>
						  <option value="week">주급</option>
						  <option value="month">월급</option>
						  <option value="year">연봉</option>
						</select>
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="workPeriod" class="col-sm-2 control-label">근무기간</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="workPeriod" id="workPeriod" placeholder="근무기간">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="workDay" class="col-sm-2 control-label">근무일</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="workDay" id="workDay" placeholder="근무일">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="workTime" class="col-sm-2 control-label">근무시간</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="workTime" id="workTime" placeholder="근무시간">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="workType" class="col-sm-2 control-label">근무형태</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="workType" id="workType" placeholder="근무형태">
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10" id="test">
			      <button type="submit" class="btn btn-default" id="submitbtn">공고 등록</button>
			    </div>
			  </div>
			</div>
			<div class="recruit_btn_wrap">
		  	<button onclick="test()" class="recruit_btn">클릭</button>
			</div>
		</form>
	</div>
	<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		function test(){
			$('#test').append('<h2>TEST</h2>');
		}
		
		$('#submitbtn').click(function(){
			var formData = $('#recruitForm').serialize();
			$.ajax({
				type:"POST",
				url:"insertRecruit",
				data:formData,
				error: function(){
					alert("오류가 발생하였습니다. 다시 시도해주세요");
				},
				success: function(resultData){
					let result = resultData.result;
					if(result==="success"){
						alert("채용공고가 정상적으로 등록되었습니다.");
						location.href="recruit/myRecruit";
					} else {
						alert("오류가 발생하였습니다. 다시 시도해주세요 \n계속해서 오류발생시 고객센터로 문의바랍니다.");
					}
					
				}
			})
		});
	</script>
</body>
</html>