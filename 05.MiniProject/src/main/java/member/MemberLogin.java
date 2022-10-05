package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class MemberLogin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//입력한 아이디/비번인 일치하는 회원정보를 DB에 조회
		//DB연결 -> 아이디/비번인 일치하는 회원정보조회 메소드 호출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDTO dto = new MemberDAO().member_login(id, pw);
		
		//로그인정보를 세션에 담는다
		request.getSession().setAttribute("loginInfo", dto);
		try {
			response.getWriter().print( dto == null ? false : true );
		}catch(Exception e) {}
	}

}
