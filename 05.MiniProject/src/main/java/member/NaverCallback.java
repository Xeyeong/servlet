package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.Command;
import common.CommonUtil;

public class NaverCallback implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String url = request.getContextPath().isEmpty() ? "/" : request.getContextPath();
		request.setAttribute("url", url);
		String state = request.getParameter("state");
		String code = request.getParameter("code");
		String error = request.getParameter("error");
		
		//상태토큰의 일치여부 확인
		//상태토큰이 일치하지 않거나 콜백에러 발생시는 토큰 발급 불가
		if( ! state.equals(  (String)request.getSession().getAttribute("state")  ) 
					||  error != null ) {
			return;
		}
		
		//접근 토큰 발급 요청 
		//Callback으로 전달받은 'code' 값을 이용하여 '접근토큰발급API'를 호출
		//API 응답으로 접근토큰에 대한 정보를 받을 수 있습니다
		//https://nid.naver.com/oauth2.0/token?grant_type=authorization_code
		//&client_id=jyvqXeaVOVmV
		//&client_secret=527300A0_COq1_XV33cf
		//&code=EIc5bFrl4RibFls1
		//&state=9kgsGTfH4j7IyAkg  
		StringBuffer apiUrl 
		= new StringBuffer("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code");
		apiUrl.append("&client_id=cmg3bBYHwudZL3cfrAWJ");
		apiUrl.append("&client_secret=CL4i_Uy02M");
		apiUrl.append("&code=").append(code);
		apiUrl.append("&state=").append(state);
		
		String data = new CommonUtil().requestAPI(apiUrl);
		JSONObject json = new JSONObject( data );
		String token = json.getString("access_token");
		String type = json.getString("tokey_type");
		// "{ access_token : adfbfa,  tokey_type : adf }"
	}

}










