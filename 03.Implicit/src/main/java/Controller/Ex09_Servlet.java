package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex09_Servlet")
public class Ex09_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청이 옴");
		//Controller는 DB접속해서 어떤 정보를 얻어오거나하는 처리(비지니스 로직)
		RequestDispatcher rd = request.getRequestDispatcher("Ex01_Request/Ex09_jsp.jsp");
		request.setAttribute("data1", "JSY_SERVLET_DATA");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
