package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam.java.Ex01_Method;
import exam.java.Ex02_Method;
import exam.java.Ex03_Method;
import exam.java.MemberDTO;
import member.MemberDAO;


@WebServlet("/Java02")
public class Java02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 내가 알고있는 모든것들은 메소드의 리턴타입이 될수있다.
		//2. 리턴타입이 주어진 메소드는 해당하는 타입의 변수라고 생각해도 무방하다.
		
		//메소드 호출
		// static, static x
		
		// 메소드 + 메소드가 가능할까? : 가능
		// 가능하다면 왜 될까? : 리턴받는타입이 같아서 int + int, int + double
		// String + int = 문자로 인식
		
		
		Ex01_Method java01 = new Ex01_Method();
		System.out.println(java01.name1()+java01.name7());
		System.out.println(java01.name3()+java01.name1());
		System.out.println(java01.name2()+java01.name3());

		
		
		
		Ex03_Method java03 = new Ex03_Method();
		System.out.println(java03.name1()+java03.name7()+java03.name8());
		// ↑ 해당하는 코드는 수정 x
				//50이라는 값이 아니라 70이라는 값이 
				//나오게하려면 어떻게해야할까? 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
