package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberIDCheck;
import member.MemberJoin;

@WebServlet("*.mb")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		uri = uri.substring( context.length() );
		
		boolean redirect = false;
		String view = "";
		if( uri.equals("/ajax.mb") ) {
			
			view = "ajax/index.html";
			
		}else if( uri.equals("/data.mb") ) {
			view = "ajax/data.json";
			
		}else if( uri.equals("/member.mb") ) {
			//회원가입화면 요청
			
			//응답화면연결
			view = "member/join.jsp";
			
		}else if( uri.equals("/id_check.mb") ) {
			//아이디 중복확인처리 요청
			new MemberIDCheck().execute(request, response);
			return;
			
		}else if( uri.equals("/join.mb") ) {
			//회원가입처리 요청
			//화면에서 입력한 정보를 DB에 신규저장처리한 후
			new MemberJoin().execute(request, response);
			//응답화면 연결
			return;
		}
		
		
		if( redirect ) 	response.sendRedirect(view);
		else			request.getRequestDispatcher(view).forward(request, response);
		
	}

}
