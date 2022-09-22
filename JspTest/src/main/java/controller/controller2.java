package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsptest.CustomerDAO;


@WebServlet("/cus.te")
public class controller2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CustomerDAO dao = new CustomerDAO();
		dao.aList();
		
		RequestDispatcher rd = req.getRequestDispatcher("test/JspTest_02.jsp");
		req.setAttribute("list", dao.aList());
		rd.forward(req, resp);
	}
	
}
