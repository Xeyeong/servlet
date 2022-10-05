package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class MemberLogout implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//세션에 담긴 로그인정보를 삭제
		request.getSession().removeAttribute("loginInfo");
		request.setAttribute("url", 
				request.getContextPath().isEmpty() ? "/" : request.getContextPath() );
		
	}

}
