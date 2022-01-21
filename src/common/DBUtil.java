package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String connStr = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(
					connStr, "system", "1234");
		}catch(Exception e) {
			System.out.println("드라이버 로등 중 오류 발생");
		}
		return con;
	}
	public static void close(Connection res) {
		if(res != null) try {res.close();} catch(Exception e) {}
	}
	public static void close(PreparedStatement res) {
		if(res != null) try {res.close();} catch(Exception e) {}
	}
	public static void close(ResultSet res) {
		if(res != null) try {res.close();} catch(Exception e) {}
	}
}
