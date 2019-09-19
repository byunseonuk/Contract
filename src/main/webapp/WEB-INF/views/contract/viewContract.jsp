<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<table>
			<tr>
				<td>사업주</td>
				<td>${contract.employer}</td>
			</tr>
			<tr>
				<td>사업주 주소</td>
				<td>${contract.employer_address}</td>
			</tr>
			<tr>
				<td>사업주 연락처</td>
				<td>${contract.employer_tel}</td>
			</tr>
			<tr>
				<td>근로자</td>
				<td>${contract.employee}</td>
			</tr>
			<tr>
				<td>근로자 주소</td>
				<td>${contract.employee_address}</td>
			</tr>
			<tr>
				<td>근로자 연락처</td>
				<td>${contract.employee_tel}</td>
			</tr>
			<tr>
				<td>근로계약기간</td>
				<td>${contract.start_date} 부터
					<c:if test="${contract.end_date!=null}">
						${contract.end_date} 까지
					</c:if>
				</td>
			</tr>
			<tr>
				<td>근무장소</td>
				<td>${contract.work_place}</td>
			</tr>
			<tr>
				<td>업무내용</td>
				<td>${contract.work_details}</td>
			</tr>
			<tr>
				<td>소정근로시간</td>
				<td>${contract.start_time} 부터 ${contract.end_time} 까지</td>
			</tr>
			<tr>
				<td>휴식시간</td>
				<td>${contract.break_time}</td>
			</tr>
			<tr>
				<td>근무일</td>
				<td>${contract.work_date}</td>
			</tr>
			<tr>
				<td>휴일</td>
				<td>${contract.holiday}</td>
			</tr>
			<tr>
				<td>임금</td>
				<td>${contract.salary}</td>
			</tr>
			<tr>
				<td>상여금</td>
				<td>${contract.bonus}</td>
			</tr>
			<tr>
				<td>기타급여</td>
				<td>${contract.other_benefits}</td>
			</tr>
			<tr>
				<td>임금지급일</td>
				<td>${contract.payment_date}</td>
			</tr>
			<tr>
				<td>임금지급방법</td>
				<td>${contract.payment_method}</td>
			</tr>
			<tr>
				<td>고용보험</td>
				<td>
					<c:if test="${contract.insurance1!=null}">${contract.insurance1},</c:if>
					<c:if test="${contract.insurance2!=null}">${contract.insurance2},</c:if>
					<c:if test="${contract.insurance3!=null}">${contract.insurance3},</c:if>
					<c:if test="${contract.insurance4!=null}">${contract.insurance4}</c:if>
				</td>
			</tr>
			<tr>
				<td>기타 내용</td>
				<td>${contract.other_contents}</td>
			</tr>
		</table>
		<c:if test="${loginInfo.role=='employee' && contract.state=='wait'}">
			<form id="contract" name="contract">
				<input type="hidden" name="_id" value=""/>
				<input type="hidden" name="state" value="accept"/>
				<button type="button" onclick="acceptContract(${contract._id},'accept')">계약 수락</button>
			</form>
		</c:if>
	</div>
	<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		function acceptContract(_id,state){
			$.ajax({
				type:"POST",
				url:"/test/contract/acceptContract",
				data:{
					_id:_id,
					state:state
				},
				error: function(){
					alert("오류가 발생하였습니다. 다시 시도해주세요");
				},
				success: function(result){
					if(result=="success"){
						alert("계약을 수락하였습니다. 사업주가 확인후 완전히 체결됩니다.");
						location.reload();
					} else {
						alert("오류가 발생하였습니다. 다시 시도해주세요");
					}
					
				}
			});
		}
	</script>
</body>
</html>