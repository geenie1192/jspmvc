package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import vo.MemberVO;

public class RegisterController implements Controller{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//회원가입 창을 보여주는게 Get 거기다 뭔가 입력하여 전송하면 POST
		
		String method= req.getMethod();
		if(method.equalsIgnoreCase("POST")) {
			int custno = Integer.parseInt(req.getParameter("custno"));
			String custname = req.getParameter("custname");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			Date joindate = Date.valueOf(req.getParameter("joindate"));
			String grade = req.getParameter("grade");
			String city = req.getParameter("city");
			
			MemberVO vo= new MemberVO();
			vo.setCustno(custno);
			vo.setCustname(custname);
			vo.setPhone(phone);
			vo.setAddress(address);
			vo.setJoindate(joindate);
			vo.setGrade(grade);
			vo.setCity(city);
			
			int n=MemberDAO.dao.memberRegister(vo);
			return "redirect::/member";
		}else if(method.equalsIgnoreCase("GET")) {
			int no = MemberDAO.dao.getMaxCustNo();
			req.setAttribute("maxNo", no);
			return "register";
		}
		return "redirect::/";
	}
}
