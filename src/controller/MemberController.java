package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import vo.MemberVO;

public class MemberController implements Controller{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<MemberVO> list = MemberDAO.dao.getMemberList();
		req.setAttribute("list", list);
		return "memberList";
	}
}
