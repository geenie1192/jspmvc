<%@page import="vo.WelcomeVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 페이지입니다.</h1>
	<form method="post" action="/admin">
		<input type="number" name="id" value="${maxId}" readonly /><br>
		<input type="text" name="msg" placeholder="명언을 입력하세요." /><br>
		<button type="submit">등록</button>
	</form>
	<h4>등록된 리스트 </h4>
	<ul>
	<%
		List<WelcomeVo> list = (List<WelcomeVo>)request.getAttribute("list");
		if(list != null){
			for(WelcomeVo vo : list){
				out.write("<li>" + vo.msg + "<a class='btn' href='/admin/delete?id=" + vo.id + "'>삭제</a></li>");
			}
		}
		
	%>
	</ul>
</body>
</html>