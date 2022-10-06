package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import common.Command;
import common.CommonUtil;

public class KakaoCallback implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("url", 
		request.getContextPath().isEmpty() ? "/" : request.getContextPath());
		String code = request.getParameter("code");
		String error = request.getParameter("error");
		
		if(error != null) {
			return;
		}
		
		//인가 코드로 토큰 발급을 요청
	      //curl -v -X POST "https://kauth.kakao.com/oauth/token" \
	      // -H "Content-Type: application/x-www-form-urlencoded" \
	      // -d "grant_type=authorization_code" \
	      // -d "client_id=${REST_API_KEY}" \
	      // --data-urlencode "redirect_uri=${REDIRECT_URI}" \
	      // -d "code=${AUTHORIZE_CODE}"
		StringBuffer url = new StringBuffer("https://kauth.kakao.com/oauth/token?grant_type=authorization_code");
		url.append("&client_id=").append("7c13a83e4cbae4cd9ece01140bed85d2");
		url.append("&code=").append(code);
		
		CommonUtil util = new CommonUtil();
		JSONObject json = new JSONObject( util.requestAPI(url) );
		String type = json.getString("token_type");
		String token = json.getString("access_token");
//		{
		//		curl -v -X GET "https://kapi.kakao.com/v2/user/me" \
//			  -H "Authorization: Bearer ${ACCESS_TOKEN}"
//		
		
			url = new StringBuffer("https://kapi.kakao.com/v2/user/me");
			json = new JSONObject( util.requestAPI(url, type + " " + token) );
			if( ! json.isEmpty() ) {
				MemberDTO dto = new MemberDTO();
				dto.setSocial("K");
				dto.setId(json.get("id").toString() );
				json = json.getJSONObject("kakao_account");
				dto.setName( json.has("name") ? json.getString("name") : "");
				dto.setEmail( json.has("email") ? json.getString("email") : "");
				dto.setGender( json.has("gender") ?
						(json.getString("gender").equals("female") ? "여" : "남" ) : "남"); //female/male -> 여/남
				dto.setPhone( json.has("phone_number") ? json.getString("phone_number") : "");
				
				json = json.getJSONObject("profile");
				dto.setProfile( json.has("profile_image_url") 
								? json.getString("profile_image_url") : "");
				if( dto.getName().isEmpty() ) {
					dto.setName( json.has("nickname") ? json.getString("nickname") : "무명씨");
				}
			
				MemberDAO dao = new MemberDAO();
				if( dao.member_id_check(dto.getId())==0 ) {
					//카카오로그인 처음인 경우
					dao.member_join(dto);
					
				}else {
					//카카오로그인 처음아닌 경우
					dao.member_update(dto);
				}
			
			//로그인정보를 세션에 담는다
			request.getSession().setAttribute("loginInfo", dto);
		}
			{
//			    "id":123456789,
//			    "kakao_account": { 
//			        "profile": {
//			            // 프로필 또는 닉네임 동의 항목 필요
//			            "nickname": "홍길동",
//			            // 프로필 또는 프로필 사진 동의 항목 필요
//			            "profile_image_url": "http://yyy.kakao.com/dn/.../img_640x640.jpg",
//			        },
//			        "name":"홍길동",
//			        // 카카오계정(이메일) 동의 항목 필요
//			        "email": "sample@sample.com",
//			        "gender":"female",
//			        "phone_number": "+82 010-1234-5678",   
//			    },
//			    "properties":{
//			        "${CUSTOM_PROPERTY_KEY}": "${CUSTOM_PROPERTY_VALUE}",
//			        ...
//			    }
//			}
//			 "token_type":"bearer",
//		 	 "access_token":"${ACCESS_TOKEN}",
//		     "expires_in":43199,
//		     "refresh_token":"${REFRESH_TOKEN}",
//		     "refresh_token_expires_in":25184000,
//			 "scope":"account_email profile"
			
//			curl -v -X GET "https://kapi.kakao.com/v2/user/me" \
//			  -H "Authorization: Bearer ${ACCESS_TOKEN}"
		}
	}
}
