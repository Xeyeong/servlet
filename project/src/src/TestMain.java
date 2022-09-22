import java.util.Scanner;

import com.hanul.test.TestDAO;
import com.hanul.test.TestDTO;
import com.hanul.test.TestInput;

public class TestMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TestInput ti = new TestInput(scanner);
		TestMain main = new TestMain();
		TestDAO dao = new TestDAO();
		
		while(true) {
			main.display();
			System.out.print("메뉴를 입력하세요 : ");
			String menu = scanner.nextLine();
			System.out.println();
			
			//로그인
			if(menu.equalsIgnoreCase("L")){
				System.out.print("아이디를 입력해주세요 : ");
				String id = scanner.nextLine();
				System.out.print("비밀번호를 입력해주세요 : ");
				String pw = scanner.nextLine();
				TestDTO dto = dao.checkLogin(id, pw);
				
				
				
				while(true) {
					main.display2();
					System.out.print("버튼을 입력하세요 : ");
				    String subMenu = scanner.nextLine();
					
					if(subMenu.equalsIgnoreCase("U")) {
				    	 ti.updateInput(dto);
				     }else if(subMenu.equalsIgnoreCase("D")) {
				    	 
				     }else if(subMenu.equalsIgnoreCase("N")) {
				    	 
				     }else if(subMenu.equalsIgnoreCase("B")) {
				    	 
				     }else {
				    	 System.out.println("잘못 입력하셨습니다");
				    	 continue;
				     }//if
				}
				
				
				
				
			//회원가입	
			}else if(menu.equalsIgnoreCase("I")) {
				ti.insertInput();
				
			//종료
			}else if(menu.equalsIgnoreCase("E")) {
				System.out.println("정말 종료하시겠습니까? Y/N");
				String exit = scanner.nextLine();
				if(exit.equalsIgnoreCase("y")) {
					System.out.println("프로그램을 종료합니다");
					System.exit(0);
					break;
				}else if(exit.equalsIgnoreCase("n")) {
					continue;
				}else {
					System.out.println("잘못 입력하셨습니다");
				}//if
			}else {
				System.out.println("잘못 입력하셨습니다");
			}//if
		}//while
		scanner.close();
	}//main

	private void display() {
		System.out.println("==================");
		System.out.println("로그인 :	L");
		System.out.println("회원가입 :	I");
		System.out.println("종료 :		E");
		System.out.println("==================");
	}//display()
	
	
	
	
	public void display2() {
		 
		 System.out.println();
		 System.out.println("========================");
		 System.out.println("1.회원정보수정 : U");
	     System.out.println("2.회원 탈퇴 : D");
	     System.out.println("3.공지사항 보기 : N");
	     System.out.println("4.뒤로가기 : B");
	     System.out.println("========================");
		}//loginSubMain
}//class
