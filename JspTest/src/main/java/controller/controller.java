package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsptest.JspDAO;
import jsptest.JspDTO;

@WebServlet("/emp.te")
public class controller extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("다음 페이지");
		JspDAO dao = new JspDAO();
		//dao.aList();
		List<JspDTO> list = dao.aList() ;
		RequestDispatcher rd = req.getRequestDispatcher("test/JspTest_01.jsp");
		req.setAttribute("list",list);
		rd.forward(req, resp);	
	}
}
