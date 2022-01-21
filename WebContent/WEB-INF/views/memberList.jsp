<%@page import="vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>
	<section>
		<div class="container">
			<p class = "title">회원목록 조회</p>
			<%
				List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
			%>
			<table>
				<tr>
					<td>회원번호</td>
					<td>회원성명</td>
					<td>회원전화</td>
					<td>회원주소</td>
					<td>가입일자</td>
					<td>고객등급</td>
					<td>거주지역</td>
				</tr>
			<%
				for(MemberVO member : list){
					
			%>
				<tr>
					<td>
						<a href="/member/update?custno=<%= member.getCustno() %>">
							<%= member.getCustno() %>
						</a>
					</td>
					<td><%= member.getCustname() %></td>
					<td><%= member.getPhone() %></td>
					<td><%= member.getAddress() %></td>
					<td><%= member.getJoindate() %></td>
					<td><%= member.getGrade() %></td>
					<td><%= member.getCity() %></td>
				</tr>
			<%
				}
			%>
			</table>
		</div>
	</section>
<jsp:include page="master/footer.jsp" />