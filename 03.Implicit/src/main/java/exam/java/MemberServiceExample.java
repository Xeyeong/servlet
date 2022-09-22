package exam.java;

import java.util.Scanner;

public class MemberServiceExample extends MemberService{
	public static void main(String[] args) {						 //결과 (hong ,12345입력)           결과(1.2 입력)
		
		Scanner scan = new Scanner(System.in);                       //로그인 되었습니다.               id 또는 password가 올바르지 않습니다.
		MemberService memberService = new MemberService();           //로그아웃 되었습니다. 
		System.out.print("아이디를 입력하세요 : ");
		String userId = scan.nextLine();                              
		System.out.print("비밀번호를 입력하세요 : ");
		String userPw = scan.nextLine();                            
		
		if( memberService.login(userId, userPw)) {
			System.out.println("로그인 되었습니다.");
			
		} else {	
			memberService.login(userId, userPw);
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}//if
		scan.close();
	}//main
}//class





