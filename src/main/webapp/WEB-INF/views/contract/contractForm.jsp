<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form method="post" action="sendContract">
			사업주<input type="text" name="employer" required/><br>
			사업주 주소<input type="text" name="employer_address" required/><br>
			사업주 연락처<input type="text" name="employer_tel" required/><br>
			<input type="hidden" name="employer_id" value="${employer}"/>
			근로자<input type="text" name="employee" required/><br>
			근로자 주소<input type="text" name="employee_address" required/><br>
			근로자 연락처<input type="text" name="employee_tel" required/><br>
			<input type="hidden" name="employee_id" value="${employee}"/>
			<input type="hidden" name="apply_id" value="${apply}"/>
			근로계약기간(정하지 않았을 경우 시작일만 작성)<br>
			<input type="text" name="start_date" required/>~
			<input type="text" name="end_date" /><br>
			근무장소<input type="text" name="work_place" required/><br>
			업무내용<input type="text" name="work_details" required/><br>
			소정근로시간<br>
			<input type="text" name="start_time" required/>~
			<input type="text" name="end_time" required/><br>
			휴식시간<input type="text" name="break_time" required/><br>
			근무일<input type="text" name="work_date" required/><br>
			휴일<input type="text" name="holiday" required/><br>
			임금<input type="text" name="salary" required/><br>
			상여금<input type="text" name="bonus" required/><br>
			기타급여<input type="text" name="other_benefits" required/><br>
			임금지급일<input type="text" name="payment_date" required/><br>
			지급방법<input type="text" name="payment_method" required/><br>
			고용보험
			<input type="checkbox" name="insurance1" value="고용보험"/>고용보험
			<input type="checkbox" name="insurance2" value="산재보험"/>산재보험
			<input type="checkbox" name="insurance3" value="국민연금"/>국민연금
			<input type="checkbox" name="insurance4" value="건강보험"/>건강보험<br>
			<textarea name="other_contents" rows="20" cols="50"></textarea>
			<input type="submit" value="계약서 전송"/>
		</form>
	</div>
	<script>
		var msg = ${msg};
		if(msg=="fail")
			alert('다시 시도해주세요')
	</script>
</body>
</html>