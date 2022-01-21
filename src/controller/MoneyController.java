package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import vo.MemberMoneyVO;

public class MoneyController implements Controller{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MemberMoneyVO> list = MemberDAO.dao.getMemberMoneyList();
		req.setAttribute("list", list);
		return "moneyList";
	}
}
