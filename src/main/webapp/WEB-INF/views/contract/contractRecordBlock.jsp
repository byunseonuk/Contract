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
				<td>고용주</td>
				<td>${contract.employer}</td>
			</tr>
			<tr>
				<td>고용주 주소</td>
				<td>${contract.employer_address}</td>
			</tr>
			<tr>
				<td>고용주 연락처</td>
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
				<td>근로계약기간 주소</td>
				<td>${contract.start_date} 부터
					<c:if test="${contract.end_date!=null}">		
						${contract.end_date} 까지
					</c:if></td>
			</tr>
			<tr>
				<td>근로자 근무장소</td>
				<td>${contract.work_place}</td>
			</tr>
			<tr>
				<td>업무내용</td>
				<td>${contract.work_details}</td>
			</tr>
			<tr>
				<td>근로자 주소</td>
				<td>${contract.employer}</td>
			</tr>
			<tr>
				<td>소정근로시간</td>
				<td>${contract.start_time} 부터 
					
					${contract.end_time} 까지</td>
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
		
		<form id="contract_data">
			<input type="hidden" name="_id" value="${contract._id}" />
			<input type="hidden" name="employer_id" value="${contract.employer_id}" />
			<input type="hidden" name="employee_id" value="${contract.employee_id}" />
			<input type="hidden" name="employer" value="${contract.employer}" />
			<input type="hidden" name="employer_address" value="${contract.employer_address}" />
			<input type="hidden" name="employer_tel" value="${contract.employer_tel}" />
			<input type="hidden" name="employee" value="${contract.employee}" />
			<input type="hidden" name="employee_address" value="${contract.employee_address}" />
			<input type="hidden" name="employee_tel" value="${contract.employee_tel}" />
			<input type="hidden" name="start_date" value="${contract.start_date}" />
			<input type="hidden" name="end_date" value="${contract.end_date}" />
			<input type="hidden" name="work_place" value="${contract.work_place}" />
			<input type="hidden" name="work_details" value="${contract.work_details}" />
			<input type="hidden" name="start_time" value="${contract.start_time}" />
			<input type="hidden" name="end_time" value="${contract.end_time}" />
			<input type="hidden" name="break_time" value="${contract.break_time}" />
			<input type="hidden" name="work_date" value="${contract.work_date}" />
			<input type="hidden" name="holiday" value="${contract.holiday}" />
			<input type="hidden" name="salary" value="${contract.salary}" />
			<input type="hidden" name="bonus" value="${contract.bonus}" />
			<input type="hidden" name="other_benefits" value="${contract.other_benefits}" />
			<input type="hidden" name="payment_date" value="${contract.payment_date}" />
			<input type="hidden" name="payment_method" value="${contract.payment_method}" />
			<input type="hidden" name="insurance1" value="${contract.insurance1}" />
			<input type="hidden" name="insurance2" value="${contract.insurance2}" />
			<input type="hidden" name="insurance3" value="${contract.insurance3}" />
			<input type="hidden" name="insurance4" value="${contract.insurance4}" />
			<input type="hidden" name="other_contents" value="${contract.other_contents}" />
			<input type="hidden" name="state" value="${contract.state}" />
			<input type="hidden" name="recordBlock" value="${contract.recordBlock}" />
			<input type="button" onclick="contractRecordBlock()" value="블록에 저장하기"/>
			<!-- <button onclick="recordBlock()">블록에 저장하기</button> -->
		</form>
	</div>
	
	
	<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		function contractRecordBlock() {
			alert("잠시만 기다려주세요. 5~10초 정도 소요됩니다.");
			
			var contract_data = $('#contract_data').serialize();
			console.log(contract_data);
			
			$.ajax({
				url: 'recordBlock',
				type: 'POST',
				data: contract_data,
				error: function(){
					alert("오류가 발생하였습니다.");
				},
				success: function(result){
					if(result.result==="success"){
						alert("성공");
					}else {
						alert("실패");
					}
						
				}
			
			});
		}
	</script>
</body>
</html>