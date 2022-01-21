<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<jsp:include page="master/header.jsp"/>
	
	<section>
		<div class="container">
			<p class="title">홈쇼핑 회원등록</p>
			<form action="/memberInsert" method="post" name="frm">
				<table width="600px">
					<tr>
						<td>회원번호(자동발생)</td>
						<td><input type="number" value="${maxNo}" name="custno" readonly /></td>
					</tr>
					<tr>
						<td>회원이름</td>
						<td><input type="text" name="custname" id="custname" /></td>
					</tr>
					<tr>
						<td>회원전화</td>
						<td><input type="text" name="phone" id="phone" /></td>
					</tr>
					<tr>
						<td>회원주소</td>
						<td><input type="text" name="address" id="address" /></td>
					</tr>
					<tr>
						<td>가입일자</td>
						<td><input type="date" name="joindate" id="joindate" /></td>
					</tr>
					<tr>
						<td>고객등급(A:VIP, B:일반, C:직원)</td>
						<td>
							<select id="grade" name="grade">
								<option value="A">VIP</option>
								<option value="B">일반</option>
								<option value="C">직원</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>도시코드</td>
						<td><input type="text" name="city" id="city"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit" onclick="return checkForm()">가입하기</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<script>
		function checkForm(){
			//앞뒤 공백 제거
			if(document.frm.custname.value.trim() == ""){
				alert("회원이름을 입력해주세요");
				document.frm.custname.focus();
				return false;
			}
			if(document.frm.phone.value.trim() == ""){
				alert("회원전화를 입력해주세요");
				document.frm.phone.focus();
				return false;
			}
			if(document.frm.address.value.trim() == ""){
				alert("회원주소를 입력해주세요");
				document.frm.address.focus();
				return false;
			}
			if(document.frm.joindate.value.trim() == ""){
				alert("가입일자 입력해주세요");
				document.frm.joindate.focus();
				return false;
			}
			if(document.frm.grade.value.trim() == ""){
				alert("회원등급을 입력해주세요");
				document.frm.grade.focus();
				return false;
			}
			if(document.frm.city.value.trim() == ""){
				alert("도시를 입력해주세요");
				document.frm.city.focus();
				return false;
			}
			if(document.frm.custname.value.trim() == ""){
				alert("회원이름을 입력해주세요");
				document.frm.custname.focus();
				return false;
			}
				
		}
	</script>
	
	<jsp:include page="master/footer.jsp"/>