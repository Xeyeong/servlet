package controller;

import java.util.ArrayList;
import java.util.Scanner;

public class memberInput {
	public void getAllListMember() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("전체회원 목록을 검색하시겠습니까?(Y/N) : ");
			String menu = scanner.nextLine();
			if(menu.equalsIgnoreCase("Y")) {
				//회원목록 검색 메소드 호출
				System.out.println("회원목록 검색");
				MemberDAO dao = new MemberDAO();
				ArrayList<MemberDTO> list = dao.searchAllMember();
				dao.display(list);
				
				break;
			}else if(menu.equalsIgnoreCase("N")) {
				System.out.println("회원목록 검색을 취소하셨습니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}//if
		}//while	
	}
}
