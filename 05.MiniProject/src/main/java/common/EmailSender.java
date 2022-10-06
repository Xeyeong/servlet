package common;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class EmailSender {
	public void send(String email, String name, HttpServletRequest req) {
		//기본이메일
		//sendSimpleEmail(email, name);
		
		//파일첨부 이메일
		//sendFileEmail(email, name, req);
		
		//html태그 이메일
		sendFileEmail(email, name, req);
		
	}
	
	//html태그 이메일 전송 처리
	public void sendHtmlEmail(String email, String name, HttpServletRequest req) {
		HtmlEmail mail = new HtmlEmail();
		mail.setHostName("smtp.naver.com");
		mail.setDebug(true);
		mail.setCharset("utf-8");
		
		mail.setAuthentication("아이디", "비밀번호"); //로그인 할 정보
		mail.setSSLOnConnect(true);
		
		try {
			mail.setFrom("darkdino1@naver.com", "관리자");
			mail.addTo(email, name);
			
			mail.setSubject("가입축하 html형식");
			
			StringBuffer msg = new StringBuffer();
			
			msg.append("<html>");
			msg.append("<body>");
			msg.append("<h3>HANUL302 가입축하</h3>");
			msg.append("<div>").append(name).append("님 회원가입을 축하합니다</div>");
			msg.append("<hr>");
			msg.append("<a href='https://www.naver.com/' target='_blank'>hanul302 사이트</a>");
			msg.append("<img src=''>");
			msg.append("</body>");			
			msg.append("</html>");
			
			mail.setHtmlMsg(msg.toString());
			
			EmailAttachment file = new EmailAttachment();
			file.setPath(req.getServletContext().getContext("file/축하.pdf"));
			
			
		} catch (Exception e) {
		}
		
	}
	//파일첨부 이메일 전송처리
	public void sendFileEmail(String email, String name, HttpServletRequest req) {
		MultiPartEmail mail = new MultiPartEmail();
		//메일서버지정
		mail.setHostName("smtp.kakao.com");
		//메일전송과정 확인
		mail.setDebug(true);
		mail.setCharset("utf-8");
		
		//아이디.비번 입력후 로그인버튼 클릭
		mail.setAuthentication("sy_0420e@kakao.com", "as245168");
		mail.setSSLOnConnect(true);
		
		try {
			//보내는사람지정
			mail.setFrom("sy_0420e@kakao.com", "관리자");
			//받는사람지정
			mail.addTo(email, name);
			
			//제목
			mail.setSubject("가입축하-파일첨부있음");
			
			//내용
			mail.setMsg("회원가입을 축하합니다! 첨부된 파일을 확인하세요");
			
			//파일첨부하기
			EmailAttachment file = new EmailAttachment();
			file.setPath("D:\\Oracle DB.png");
			//첨부하기버튼 클릭
			mail.attach(file);
			
			file = new EmailAttachment();
			file.setPath(req.getServletContext().getRealPath("file/축하.pdf"));
			
			mail.attach(file);
			
			file = new EmailAttachment();
			file.setURL(new URL("https://media.naver.com/press/422/live"));
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
		mail.setHostName("smtp.kakao.com");
		
		//로그인하기 위한 이메일 아이디/비번 지정
		mail.setAuthentication("이메일아이디", "아이디에대한 비밀번호");
		//로그인버튼 클릭하기
		mail.setSSLOnConnect(true);
		
		try {
			//이메일 송신인 지정
			mail.setFrom("sy_0420e@kakao.com", "HANUL302 관리자");
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
