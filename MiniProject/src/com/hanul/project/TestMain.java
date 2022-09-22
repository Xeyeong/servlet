package com.hanul.project;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		TestMain main = new TestMain();
		TestInput input = new TestInput();
			
		while(true) {
			main.display();
			System.out.print("메뉴를 입력하세요 : ");
			String menu = scanner.nextLine();
			System.out.println();
			
			if(menu.equalsIgnoreCase("L")) {
				//로그인 서브화면 화면
				System.out.println("1.회원정보수정 : U");
				System.out.println("2.회원 탈퇴 : D");
				System.out.println("3.공지사항 보기 : N");
				System.out.println("4.뒤로가기 : B");
				String login = scanner.nextLine();
				
				if(login.equalsIgnoreCase("U")) {
					System.out.println("회원정보를 수정합니다.");
					System.exit(0); //프로그램을 종료하고 메모리에서 관련 프로세스를 제거
					break;
				}else if(login.equalsIgnoreCase("D")) {
					System.out.println("회원 탈퇴를 진행합니다.");
					continue;
				}else if(login.equalsIgnoreCase("N")){
					System.out.println("공지사항입니다.");
					continue;
				}else if(login.equals("B")){
					System.out.println("처음으로 돌아갑니다.");
				}
			//	input.insertInput();
				
			}else if(menu.equalsIgnoreCase("D")) {
				//회원정보 삭제하는 서브화면 호출
				
				input.deleteInput();
			}else if(menu.equalsIgnoreCase("U")) {
				//회원정보 수정하는 서브화면 호출
				
				input.updateInput();
			
			}else if(menu.equalsIgnoreCase("A")) {
				//회원 주소를 검색하는 서브화면 호출
			
			}else if(menu.equalsIgnoreCase("E")) {
				//프로그램 종료하는 코드 구현
				System.out.print("정말 종료 하시겠습니까?(Y/N) : ");
				String exit = scanner.nextLine();
				if(exit.equalsIgnoreCase("y")) {
					System.out.println("회원관리 프로그램을 종료합니다.");
					System.exit(0); //프로그램을 종료하고 메모리에서 관련 프로세스를 제거
					break;
				}else if(exit.equalsIgnoreCase("n")) {
					System.out.println("회원관리 프로그램을 계속 진행합니다.");
					continue;
				}else {
					System.out.println("잘못 입력하셨습니다");
					continue;
				}
			}
		}//while
	}//main
	
	public void display() {
		System.out.println();
		System.out.println("=====메인프로그램=====");
		System.out.println("1. 로그인 : L");
		System.out.println("2. 회원가입 : J");
		System.out.println("3. 종료 : E");
		System.out.println("==================");
	}//display
}//class







