package common;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class EmailSender {
	
	public void send(String email, String name, HttpServletRequest request) {
		//기본이메일
		//sendSimpleEmail(email, name);
		
		//파일첨부 이메일
		//sendFileEmail(email, name, request);
		
		//html태그 이메일
		sendHtmlEmail(email, name, request);
	}
	
	//html태그 이메일 전송 처리
	public void sendHtmlEmail(String email, String name, HttpServletRequest request) {
		HtmlEmail mail = new HtmlEmail();
		mail.setHostName("smtp.naver.com");
		mail.setDebug(true);
		mail.setCharset("utf-8");
		
		mail.setAuthentication("아이디", "비번"); //로그인할 정보
		mail.setSSLOnConnect(true);
		
		try {
			mail.setFrom("로그인한 이메일@naver.com", "관리자");
			mail.addTo(email, name);
			
			mail.setSubject("가입축하 html형식");
			
			StringBuffer msg = new StringBuffer();
			msg.append("<html>");
			msg.append("<body>");
			msg.append("<h3>HANUL302 가입축하</h3>");
			msg.append("<div>").append(name).append(" 님 회원가입을 축하합니다</div>");
			msg.append("<hr>");
			msg.append("<div><a href='https://www.hrd.go.kr/' target='_blank'>HANUL302 사이트</a></div>");
			msg.append("<img src='https://cdn.pixabay.com/photo/2022/09/07/21/23/ferris-wheel-7439636__340.jpg'>");
			msg.append("</body>");
			msg.append("</html>");
			mail.setHtmlMsg( msg.toString() );
			
			EmailAttachment file = new EmailAttachment();
			file.setPath( request.getServletContext()
					.getRealPath("file/회원가입축하.pdf"));
			mail.attach(file);
			
			mail.send();			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}
	
	//파일첨부 이메일 전송처리
	public void sendFileEmail(String email, String name, HttpServletRequest request) {
		MultiPartEmail mail = new MultiPartEmail();
		//메일서버지정
		mail.setHostName("smtp.naver.com");
		//메일전송과정 확인
		mail.setDebug(true);
		mail.setCharset("utf-8");
		
		//아이디.비번 입력후 로그인버튼 클릭
		mail.setAuthentication("보내는이메일아이디", "아이디에대한비밀번호");
		mail.setSSLOnConnect(true);
		
		try {
			//보내는사람지정
			mail.setFrom("보내는이메일아이디@naver.com", "관리자");
			//받는사람지정
			mail.addTo(email, name);
			
			//제목
			mail.setSubject("가입축하-파일첨부있음");
			
			//내용
			mail.setMsg("회원가입을 축하합니다! 첨부된 파일을 확인하세요");
			
			//파일첨부하기
			EmailAttachment file = new EmailAttachment();
			file.setPath("D:\\aa\\01.변수&연산자 기초 테스트");
			//첨부하기버튼클릭
			mail.attach(file);
			
			file = new EmailAttachment();
			file.setPath( request.getServletContext()
								.getRealPath("file/회원가입축하.pdf")  );
			mail.attach(file);
			
			file = new EmailAttachment();
			file.setURL( new URL("https://imgnews.pstatic.net/image/293/2022/10/04/0000040904_001_20221004121701473.jpg?type=w647") );
			mail.attach(file);
			
			//메일전송하기(보내기) 클릭
			mail.send();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
	//기본 이메일 전송처리
	public void sendSimpleEmail(String email, String name) {
		SimpleEmail mail = new SimpleEmail();
		//이메일서버지정
		mail.setCharset("utf-8");
		mail.setDebug(true);
		mail.setHostName("smtp.naver.com");
		
		//로그인하기 위한 이메일 아이디/비번 지정
		mail.setAuthentication("이메일아이디", "아이디에대한 비밀번호");
		//로그인버튼 클릭하기
		mail.setSSLOnConnect(true);
		
		try {
			//이메일 송신인 지정
			mail.setFrom("보내는 이메일아이디@naver.com", "HANUL302 관리자");
			//이메일 수신인 지정
			mail.addTo(email, name); //여러명에게 이메일 전송시 addTo 메소드로 
			
			//메일 제목
			mail.setSubject("HANUL302 가입축하");
			
			//메일 내용
			mail.setMsg(name + " 님! 회원가입을 축하합니다!");
			
			//메일보내기버튼 클릭
			mail.send();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
