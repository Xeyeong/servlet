package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.java.Ex01_Java;
import exam.java.MemberDTO;
import exam.java.Overloding;
import member.MemberDAO;

// URL로 들어오는 String 문자열을 판별하여 해당하는 서블릿이 실행이됨
// 서블릿 파일 추가 후 반드시 서버는 리스타트 되어야한다.



@WebServlet("/Java01")
public class Ex04_ExamJava extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ex01_Java java = new Ex01_Java();
		java.for_star();
		java.while_star();
		
		Overloding over = new Overloding();
		over.OverLoding1(3.14, 3.14);
		over.OverLoding1(3.14, 2);
		over.OverLoding1(1, 3.14);
		over.OverLoding1(2, 3);
		over.OverLoding1(1, 2, 3);
		
		
	}//get

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ex01_Java java = new Ex01_Java();
		java.for_star();
		java.while_star();

		Overloding over = new Overloding();
		over.OverLoding1(3.14, 3.14);
		over.OverLoding1(3.14, 2);
		over.OverLoding1(1, 3.14);
		over.OverLoding1(2, 3);
		over.OverLoding1(1, 2, 3);
		
		
	}//post

}
