package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.WelcomeDAO;
import vo.WelcomeVo;

public class AdminController implements Controller{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String method = req.getMethod();
		System.out.println(method);
		if(method.equalsIgnoreCase("POST")) {
			String msg= req.getParameter("msg");
			int id = Integer.parseInt(req.getParameter("id"));
			
			WelcomeDAO.dao.add(id, msg);
			
			return "redirect::/admin";
		}
		
		int maxId = WelcomeDAO.dao.getMaxID();
		List<WelcomeVo> list = WelcomeDAO.dao.getList();
		req.setAttribute("maxId", maxId);
		req.setAttribute("list", list);
		
		return "admin";
	}
}
