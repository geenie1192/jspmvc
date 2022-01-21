package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션은 자신의 밑에 나오는 메소드, 클래스, 멤버변수를 수사해주는 일
@WebServlet("/abc")
public class MainController extends HttpServlet {
	//doGet은 HttpServlet에 요청이 들어왔을 때 그게 Get요청이면 실해오디는 메서드
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("Hello Get");
//	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("gmh", "Hello gmh");
		
		String path = "/main.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Init");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy");
	}
}

// url 주소 => 자바클래스 1:1 매칭
// /abc =>라고하면 MainController가 실행되도록
//get(검색:요청) post(전송) put(수정) delete(삭제)