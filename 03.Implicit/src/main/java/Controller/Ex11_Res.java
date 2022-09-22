package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex11_Res")
public class Ex11_Res extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; utf-8");
//		PrintWriter writer = res.getWriter();
//		writer.println("응답이 되었습니다");
//		writer.println("<script>alert('잘뜨네');</script>");
		//	response는 바로 Servlet이 응답을 처리하는 형태
		//  Requset는 Forward방식을 통해서 페이지에서 응답을 하게끔 미루는 형태
		res.sendRedirect("Ex01_Request/Ex11_Res.jsp");
		
		//요청을 받고나서 페이지를 새로 띄운다 (=!Forward 모든 jsp경로가 노출이됨)
		//Redirect될때는 어떤 데이터를 담아둘수가없음
		//로그인을 하고나서 Model(데이터처리)가 필요없는 경우, 회원가입을 한 경우 등
		// 다음페이지에 데이터가 필요가 없을때, 많이 사용됨
		// Forward 70% ↑ , Redirect 30%
		//Request는 Forward방식을 통해서 페이지에서 응답을 하게끔 미루는 형태
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	}

}



