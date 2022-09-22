package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ScopeServlet")
public class Ex08_Scope extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JSP페이지(View) 요청할때 보내준 데이터를 Servlet(Controller)에서 사용하는 방법
		//Scope <=
		// PageContext <= 페이지 내에서만 사용이 가능한 내장 객체(JSP의 범위를 벗어나면 사용 x)
		System.out.println("Request에 있는 Attribute : " + request.getAttribute("req"));
		HttpSession session = request.getSession(); //세션의 초기화식(new x)
		System.out.println("Session에 있는 Attribute : " + session.getAttribute("session"));
		
		System.out.println("AppicationContext에 있는 Attribute : " + getServletContext().getAttribute("app"));
		
		//Controller에서 페이지를 전환하는 방식(Forward)
		//요청 자원을 넘기는 방식 ( Forward, redirect)
		//Request(요청) 객체가 바로 처리하는게 아니라 다음페이지에서 요청을 처리할수있게
		//페이지의 현재 경로와 Request객체를 이용하여 어떤값을 넘김.
		RequestDispatcher rd = request.getRequestDispatcher("Ex01_Request/Ex04_ScopeResult.jsp");
		request.setAttribute("req", "Servlet_Data");  //DataBase에 접근해서 데이터를 조회해옴(Model)
		// MVC ( Model(데이터를 담는객체, DAO), View(JSP), Controller(Servlet))
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}




