<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	body{
		background:#f5f6f7;
	}
	
	.container {
		width:60%;
		margin:auto;
	}

	.signup_form_wrap {
		width:450px;
		margin:auto;
	}
	
	.signup_form_wrap .input_wrap{
	
	}
	
	.intput_id_area {
		position:relative;
	}
	
	.signup_form_wrap .input_wrap .input_val {
		font-size:20px;
		width: 100%;
    display: inline-block;
    padding: 10px 14px;
    border: 1px solid;
    background: #fff;
    display:block;
    box-sizing: border-box;
	}
	
	.signup_form_wrap .input_wrap .input_val > input {
		width: 100%;
    height: 40px;
    border: none;
	}
	
	.signup_form_wrap .input_wrap .input_val > select {
		width: 100%;
    height: 42px;
    font-size: 16px;
    border: none;
	}
	
	.signup_form_wrap .input_wrap .input_id {
		width:335px;
	}
	.signup_form_wrap .input_wrap button {
		width: 100px;    
		height: 64px;
		position:absolute;
		top:0;
		right:0;
		background: #5bb3f7;
    border: 0;
    font-size: 18px;
    color: #fff;
    font-weight: 600;
   	cursor: pointer;	
	}
	
	.submit_btn {
		margin-top:30px;
	}
	
	.submit_btn > input {
		height: 64px;
    width: 100%;
    font-size:20px;
    background: #5bb3f7;
    border: 0;
    font-size: 18px;
    color: #fff;
    font-weight: 600;
    cursor: pointer;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="signup_form_wrap">
			<form method="post" id="signupForm">
				<div class="input_wrap">
					<h2>아이디</h2>
					<div class="intput_id_area">
						<span class="input_val input_id">
							<input type="text" name="identifier" id="identifier"/>
						</span>
						<button type="button" id="idCheck">중복확인</button>
					</div>
				</div>
				<div class="input_wrap">
					<h2>비밀번호</h2>
					<span class="input_val">
						<input type="password" name="password"/>
					</span>
				</div>
				<div class="input_wrap">
					<h2>비밀번호 확인</h2>
					<span class="input_val">
						<input type="password" name="passwordCheck"/>
					</span>
				</div>
				<div class="input_wrap">
					<h2>이름</h2>
					<span class="input_val">
						<input type="text" name="name"/>
					</span>
				</div>
				<div class="input_wrap">
					<h2>이메일</h2>
					<span class="input_val">
						<input type="email" name="email"/>
					</span>
				</div>
				<div class="input_wrap">
					<h2>휴대전화</h2>
					<span class="input_val">
						<input type="text" name="phone"/>
					</span>
				</div>
				<div class="input_wrap">
					<h2>개인/기업</h2>
					<div class="input_val">
						<select name="role">
							<option value="none" selected="selected">선택</option>
							<option value="employee">개인</option>
							<option value="employer">기업</option>
						</select>
					</div>
				</div>
				<div class="submit_btn">
					<input type="submit" value="가입하기" id="signupSubmit"/>
				</div>
			</form>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		var idcheck = false;
		
		$('#idCheck').click(function(){
			var userId = $('#identifier').val();
			if(userId.length<1){
				alert("아이디를 입력해주세요.");
			} else{
				$.ajax({
					type:"POST",
					url:"signup/checkID",
					data:{"identifier":userId},
					error: function(){
						alert("다시 시도해주세요");
					},
					success: function(resultData){
						let result = resultData.result;
						if(result==="possible"){
							alert("사용 가능한 아이디 입니다.");
							idcheck = true;
						} else if(result==="impossible"){
							alert("이미 사용중인 아이디입니다. \n 다른 아이디를 사용해주세요");
						}else if(result==="error"){
							alert("오류가 발생하였습니다. \n 다시 시도해주세요 \n 계속해서 문제가 발생하면 고객센트로 문의바랍니다.");
						}
						
					}
				});	
			}
			return false;
		});
		
		 $('#signupSubmit').click(function(){
			var formData = $('#signupForm').serialize();
			$.ajax({
				type:"POST",
				url:"signup",
				data:formData,
				error: function(xhr, staus,error){
					var err = eval("(" + xhr.responseText + ")");
					alert(err.Message);
					alert("다시 시도해주세요");
				},
				success: function(resultData){
					let result = resultData.result;
					if(result==="success"){
						alert("회원가입 되었습니다.");
						location.replace("loginForm");		
					}
				}
			});	
			return false;
		}); 
	</script>
</body>
</html>