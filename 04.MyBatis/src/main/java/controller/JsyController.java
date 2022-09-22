package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;


@WebServlet("*.jsy")
public class JsyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			System.out.println("된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다된다");
			UserDAO dao = new UserDAO();
			dao.getList();
			
			RequestDispatcher rd = req.getRequestDispatcher("user/list.jsp");
			req.setAttribute("list", dao.getList());
			rd.forward(req, res);
			
		}
}
