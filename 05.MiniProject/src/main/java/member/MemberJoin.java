package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import common.EmailSender;

public class MemberJoin implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 입력한 정보를 DB에 신규저장처리한 후
		//화면에서 입력한 정보수집
		MemberDTO dto = new MemberDTO();
		dto.setName( request.getParameter("name") );
		dto.setId( request.getParameter("id") );
		dto.setPw( request.getParameter("pw") );
		dto.setEmail( request.getParameter("email") );
		dto.setGender( request.getParameter("gender") );
		dto.setBirth( request.getParameter("birth") );
		dto.setPhone( request.getParameter("phone") );
		dto.setPost( request.getParameter("post") );
		String address[] = request.getParameterValues("address");
		dto.setAddress( String.join("<br>", address) );
		
		//DB연결 -> 신규저장처리 메소드 호출
		int join = new MemberDAO().member_join(dto);
		
		response.setContentType("text/html; charset=utf-8");
		String content = "<script>";
		if( join==1 ) {
			//회원가입이 완료되면 이메일 보내기
			new EmailSender().send( dto.getEmail(), dto.getName(), request );
			content += "alert('회원가입 축하^^'); location='"
			+ (request.getContextPath().isEmpty() ? "/" : request.getContextPath()) +"'; "
					;
			
		}else {
			content += "alert('회원가입 실패ㅠㅠ'); history.go(-1); "
					;
		}
		content += "</script>";
		try {
			response.getWriter().print( content );
		}catch(Exception e) {}
	}

}
