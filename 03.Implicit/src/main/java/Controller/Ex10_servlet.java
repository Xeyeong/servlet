package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Ex10_servlet")
public class Ex10_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Form태그를 통해서 전송요청이 왔음");
		//Forward( JSP, Controller ) 방식이 아니라면 => Request.getParam => 태그의 name
		// 또는 url ? name=value <= 여기서의 왼쪽항 이름
		System.out.println(request.getParameter("num1"));
		System.out.println(request.getParameter("num2"));
		int sum = Integer.parseInt(request.getParameter("num1")) + Integer.parseInt(request.getParameter("num2"));
		System.out.println("두수의 합 " + sum);
		//페이지 전환 => Forward => RequestDispatcher
		
		/* SCOPE 데이터 범위를 나눠놓은 이유는
		 * 메모리를 효율적으로 사용하기위해서
		 * 현재의 경우는 두수의 합은 Result.jsp에서만 필요함*/
//		HttpSession session = request.getSession();
//		session.setAttribute("sum1", sum);
		RequestDispatcher rd = request.getRequestDispatcher("Ex01_Request/Ex10_ServletResult.jsp");
		request.setAttribute("sum", sum);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
