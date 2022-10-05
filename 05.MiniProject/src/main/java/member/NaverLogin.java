package member;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class NaverLogin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//네이버 로그인 연동 URL 생성하기
		//https://nid.naver.com/oauth2.0/authorize
		//?response_type=code
		//&client_id=CLIENT_ID
		//&state=STATE_STRING
		//&redirect_uri=CALLBACK_URL
		
		//id: cmg3bBYHwudZL3cfrAWJ
		//secret: CL4i_Uy02M
		
		//세션상태 토큰으로 사용할 문자열 생성
		String state = UUID.randomUUID().toString(); //af234afrqaf234f
		request.getSession().setAttribute("state", state);
		
		StringBuffer url 
		= new StringBuffer("https://nid.naver.com/oauth2.0/authorize?response_type=code");
		url.append("&client_id=").append("cmg3bBYHwudZL3cfrAWJ");
		url.append("&state=").append(state);
		url.append("&redirect_uri=").append("http://localhost/navercallback.mb");
		
		request.setAttribute("url", url.toString());
		
	}

}
