<%@page import="vo.MemberMoneyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp" />

<section>
	<div class="container">
		<p class="title"> 회원 매출 조회 </p>
	</div>
	
<%
	List<MemberMoneyVO> list = (List<MemberMoneyVO>)request.getAttribute("list");
%>
	<table>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>고객등급</td>
			<td>매출</td>
		</tr>
		<%
			for(MemberMoneyVO vo : list){
		%>
			<tr>
				<td><%= vo.getCustno() %></td>
				<td><%= vo.getCustname() %></td>
				<td><%= vo.getGrade() %></td>
				<td><%= vo.getPrice() %></td>
			</tr>
		<%		
			}
		%>
	</table>
</section>