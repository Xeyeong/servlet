package com.hanul.test;

import java.util.Scanner;

import com.hanul.test.TestDAO;
import com.hanul.test.TestDTO;

public class TestInput {
	
	//생성자 메소드 구현
	private Scanner scanner;
	public TestInput(Scanner scanner) {
		this.scanner = scanner;
	}
	
	
	
	//회원가입
	public void insertInput() {
		while(true) {
			int num;
			int tel;
			System.out.print("아이디를 입력하세요 : ");
			String id = scanner.nextLine();
			
			TestDAO dao = new TestDAO();
			
			if(dao.checkId(id)) {
				System.out.println("\n이미 사용 중인 아이디입니다");
				System.out.println("다른 아이디를 입력해주세요\n");
				continue;
			}else {
				
				System.out.print("이름을 입력하세요 : ");
				String name = scanner.nextLine();
				
				System.out.print("비밀번호를 입력하세요 : ");
				String pw = scanner.nextLine();

				System.out.print("이메일을 입력하세요 : ");
				String email = scanner.nextLine();
				
				while(true) {
					try {
						System.out.print("전화번호를 입력하세요 : ");
						tel = Integer.parseInt(scanner.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("전화번호를 잘못 입력하셨습니다");
						continue;
					}//try
				}//while
				
				//num 부여
				int i = 0;
				while(true) {
					i++;
					if(dao.checkNum(i)) {
						num = i;
						break;
					}else {
						continue;
					}
				}//while
				
				TestDTO dto = new TestDTO(num, name, id, pw, email, tel);
				int succ = dao.insertMember(dto);	//회원등록
				
				if(succ > 0) {
					System.out.println("회원가입이 성공했습니다");
				}else {
					System.out.println("회원가입이 실패했습니다");
				}//if
				break;
			}//if
		}//while
	}//insertInput()
	
	
	
	
	
	
	//회원정보 수정 서브화면
	public void updateInput(TestDTO dto) {
	   while(true) {
	      try {
	         TestDAO dao = new TestDAO();
	         
	         System.out.print("수정할 회원의 이름을 입력하세요 : ");
	         String name = scanner.nextLine();
	         if(name.trim().equals("")) {   //수정하고자 하는 값을 입력하지 않고 Pass 했을 경우
	            name = dto.getName();      //기본값으로 설정
	         }
	         
	         System.out.print("수정할 회원의 아이디를 입력하세요 : ");
	         String id = scanner.nextLine();
	         if(id.trim().equals("")) {   //수정하고자 하는 값을 입력하지 않고 Pass 했을 경우
	            id = dto.getId();      //기본값으로 설정
	         }
	         
	         System.out.print("수정할 회원의 비밀번호를 입력하세요 : ");
	         String pw = scanner.nextLine();
	         if(pw.trim().equals("")) {
	            pw = dto.getPw();
	         }
	         
	         System.out.print("수정할 회원의 이메일를 입력하세요 : ");
	         String email = scanner.nextLine();
	         if(email.trim().equals("")) {
	            email = dto.getEmail();
	         }
	         
	         int tel;
	         try {
	            System.out.print("수정할 회원의 전화번호를 입력하세요 : ");
	            tel = Integer.parseInt(scanner.nextLine());
	         } catch (Exception e) {
	            tel = dto.getTel();
	         }
	         
	         int num = dto.getNum();
	         
	         dto = new TestDTO(num, name, id, pw, email, tel);
	         int succ = dao.updateMember(dto);
	         if(succ > 0) {
	            System.out.println(name + "회원님의 정보가 수정되었습니다.");
	         }else {
	            System.out.println(name + "회원님의 정보가 수정 실패 되었습니다.");                  
	         }//if         
	         break;
	      } catch (Exception e) {
	         //e.printStackTrace();   //예외메세지를 상세하게 출력 후 종료
	         System.out.println("번호를 잘못 입력하셨습니다.");
	         continue;
	      }//try
	   }//while
	}//updateInput()
	
	



}//class

