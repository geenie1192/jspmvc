<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//Class.forName("com.mysql.jdbc.Driver");
		//String url = "jdbc:mysql://localhost:3306/myDB?useUnicode=true&characterEncoding=utf8";
		Connection conn = DriverManager.getConnection(url, "system", "1234");
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("create table test(id varchar2(5), pwd varchar(5))");
		
		stmt.executeUpdate("insert into test values('aa','11')");
		stmt.executeUpdate("insert into test values('bb','22')");
		stmt.executeUpdate("insert into test values('cd','33')");
		
		stmt.close();
		conn.close();
		
	%>
</body>
</html>