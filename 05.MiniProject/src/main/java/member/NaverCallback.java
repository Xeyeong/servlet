package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.Command;
import common.CommonUtil;

public class naverCallback implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String url = request.getContextPath().isEmpty() ? "/" : request.getContextPath();
		request.setAttribute("url", url);
		String state = request.getParameter("state");
		String code = request.getParameter("code");
		String error = request.getParameter("error");
		
		
		//상태토큰의 일치여부 확인
		//상태토큰이 일치하지 않거나 콜백에러 발생시는 토큰 발급 불가
		if(!state.equals((String)request.getSession().getAttribute("state")) 
					|| error != null) {
			
			return;
		}
		
		//접근 토큰 발급 요청
		//Callback으로 전달받은 'code' 값을 이용하여 '접근토큰발급API'를 호출하게 되면
		// API 응답으로 접근토큰에 대한 정보를 받을 수 있습니다.
		//https://nid.naver.com/oauth2.0/token?grant_type=authorization_code
		//&client_id=jyvqXeaVOVmV
		//&client_secret=527300A0_COq1_XV33cf
		//&code=EIc5bFrl4RibFls1
		//&state=9kgsGTfH4j7IyAkg  

		StringBuffer apiUrl = new StringBuffer("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code");
		apiUrl.append("&client_id=FUGviTJg_mmDsIrhZU4E");
		apiUrl.append("&client_secret=0fzLe2MxCY");
		apiUrl.append("&code=").append(code);
		apiUrl.append("&state=").append(state);
		
		CommonUtil util = new CommonUtil();
		String data = util.requestAPI(apiUrl);
		JSONObject json = new JSONObject( data );
		String token = json.getString("access_token");
		String type = json.getString("token_type");
		// "{access_token : adfbfa, tokey_type : adf}"
		
		//접근 토큰을 이용하여 프로필 API 호출하기
				//curl  -XGET "https://openapi.naver.com/v1/nid/me" \
			    //  -H "Authorization: Bearer AAAAPIuf07mQShtfK4pchdk/rc="
			
		apiUrl = new StringBuffer("Https://openapi.naver.com/v1/nid/me");
		data = util.requestAPI(apiUrl, type + " " + token);
		json = new JSONObject( data );
		
		if( json.getString("resultcode").equals("00")) {
			json = json.getJSONObject("response");
			MemberDTO dto = new MemberDTO();
			dto.setEmail( json.has("email") ? json.getString("email") : "");
			dto.setName( json.has("name") 
							? json.getString("name") : json.getString("nickname"));
			dto.setGender( json.has("gender") ?
					(json.getString("gender").equals("F") ? "여" : "남") : "남"); //F/M(여/남)
			dto.setId( json.getString("id") );
			dto.setPhone( json.has("mobile") ? json.getString("mobile") : "");
			dto.setProfile( json.has("profile_image") 
								? json.getString("profile_image") : "");	
			dto.setSocial("N");
			
			
			//네이버로그인이 처음인 경우 신규삽입저장
			//				 처음이 아닌경우 변경저장
			
			//DB에 네이버아이디가 회원으로 저장되어 있는지 확인
			MemberDAO dao = new MemberDAO();
			if(dao.member_id_check(dto.getId())== 0){
				//네이버 로그인이 처음인 경우 신규삽입저장
				dao.member_join(dto);
				
			}else {
				//처음이 아닌경우 변경저장
				dao.member_update(dto);
			}
			// 소셜 로그인이 정상 처리되면 세션에 로그인정보를 담는다.
			request.getSession().setAttribute("loginInfo", dto);
		}
//			{
//				  "resultcode": "00",
//				  "message": "success",
//				  "response": {
//				    "email": "openapi@naver.com",
//				    "nickname": "OpenAPI",
//				    "profile_image": "https://ssl.pstatic.net/static/pwe/address/nodata_33x33.gif",
//				    "age": "40-49",
//				    "gender": "F",
//				    "id": "32742776",
//				    "name": "오픈 API",
//				    "birthday": "10-01"
//				  }
	}
}



