<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	.container {
		position:relative;
		top:250px;
	}
	
	.head {
		text-align:center;
	}

	.login_form_wrap {
		width:450px;
		margin:auto;
	}
	
	.login_form_wrap .input_wrap .input_val {
		font-size:20px;
		width: 100%;
    display: inline-block;
    padding: 10px 14px;
    border: 1px solid;
    background: #fff;
    display:block;
    box-sizing: border-box;
	}
	
	.login_form_wrap .input_wrap .input_val > input {
		width: 100%;
    height: 40px;
    border: none;
	}

	.login_form_wrap .login_btn {
		margin-top:30px;
	}

	.login_form_wrap .login_btn > input{
		width: 100%;
    height: 40px;
    border: none;
    font-weight:600;
	}
	
</style>
</head>
<body>
	<div class="container">
		<div class="login_wrap">
			<div class="head">
				<h2>로그인을 해주세요.</h2>
			</div>
			<div class="login_form_wrap">
				<form method="post" action="login">
					<div class="input_wrap">
						<span class="input_val">
							<input type="text" name="identifier" placeholder="아이디"/>
						</span>
					</div>
					<div class="input_wrap">
						<span class="input_val">
							<input type="password" name="password" placeholder="비밀번호"/>
						</span>
					</div>
					<div class="login_btn">
						<input type="submit" value="로그인"/>
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>