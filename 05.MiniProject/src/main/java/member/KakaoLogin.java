package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;

public class KakaoLogin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//url
		request.setAttribute("url", request.getContextPath().isEmpty() ? "/" : request.getContextPath());
		//https://kauth.kakao.com/oauth/authorize?response_type=code
		//&client_id=${REST_API_KEY}
		//&redirect_uri=${REDIRECT_URI}
		StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/authorize?response_type=code");
		url.append("&client_id=").append("7c13a83e4cbae4cd9ece01140bed85d2");
		url.append("&redirect_uri=").append("http://localhost/kakaocallback.mb");
		
		request.setAttribute("url", url.toString());

	}

}
