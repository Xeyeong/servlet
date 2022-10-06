package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.KakaoCallback;
import member.KakaoLogin;
import member.MemberIDCheck;
import member.MemberJoin;
import member.MemberLogin;
import member.MemberLogout;
import member.NaverLogin;
import member.naverCallback;

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
		}else if(uri.equals("/login.mb")) {
			//로그인화면 요청
			view= "member/login.jsp";
		}else if(uri.equals("/smartLogin.mb")) {
			
			//로그인처리 요청
			//입력한 아이디/비번이 일치하는 회원정보를 DB에서 조회
			//화면연결 없이 return
			new MemberLogin().execute(request, response);
			return;
			
		}else if(uri.equals("/logout.mb")) {
			//로그아웃처리 요청
			new MemberLogout().execute(request, response);
			view = (String)request.getAttribute("url");
			redirect = true;
		}else if( uri.equals("/naverlogin.mb") ) {
			//네이버로그인처리 요청
			new NaverLogin().execute(request, response);
			redirect = true;
			view = (String)request.getAttribute("url");
			
		}else if(uri.equals("/navercallback.mb")) {
			new naverCallback().execute(request, response);
			redirect = true;
			view = (String)request.getAttribute("url");
			
		}else if( uri.equals("/kakaologin.mb")) {
			new KakaoLogin().execute(request, response);
			redirect = true;
			view = (String)request.getAttribute("url");
			
		}else if( uri.equals("/kakaocallback.mb") ) {
			new KakaoCallback().execute(request, response);
			redirect = true;
			view = (String)request.getAttribute("url");
			
		}
		
		
		if( redirect ) 	response.sendRedirect(view);
		else			request.getRequestDispatcher(view).forward(request, response);
		
	}
	//클라이언트ID FUGviTJg_mmDsIrhZU4E
	//클라이언트 시크릿 0fzLe2MxCY
	
//	네이티브 앱 키	f6023b82b9a6ca5dd74fb3ca92fc2c82
//	REST API 키	7c13a83e4cbae4cd9ece01140bed85d2
//	JavaScript 키	2a03c27032611e9e0e161b58b129d2e1
//	Admin 키	05e9487fc2ea674670ecc378ffd2e22d
}
