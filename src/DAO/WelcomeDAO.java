package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBUtil;
import vo.WelcomeVo;

public class WelcomeDAO {
	public static WelcomeDAO dao = new WelcomeDAO();
	
	private WelcomeDAO() {}
	
	public int getMaxID() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = "SELECT MAX(id) +1 maxId FROM wlecome_tbl";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("maxId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return 0;
	}
	
	public List<WelcomeVo> getList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = "SELECT * FROM wlecome_tbl ORDER BY id DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<WelcomeVo> list = new ArrayList<WelcomeVo>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String msg = rs.getString("msg");
				WelcomeVo vo = new WelcomeVo(id, msg);
				list.add(vo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return null;
	}
	public int add(int id, String msg) {
		Connection con =null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = "INSERT INTO welcome_tbl(id, msg) VALUES(?,?)";
			pstmt = con.prepareStatement(sql);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
		return 0;
	}
	public int delete(int id) {
		return 0;
	}
}
