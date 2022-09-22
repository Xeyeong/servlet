package exam.java;

import java.util.Random;
import java.util.Scanner;

public class RandomGame {
	public static void main(String[] args) {
		
		int iv = 0;		
		Scanner scanner = new Scanner(System.in);
		System.out.print("난이도를 입력하세요 : ");
		iv = Integer.parseInt(scanner.nextLine());
		if(iv > 0) {
			System.out.println("입력완료");
		}
		System.out.println("입력하신 난이도는 "+ iv +" 입니다.");
		System.out.println("게임을 시작합니다.");
		int[] arr = {iv};
		Random random = new Random();
		
		while(true) {
			for(int i = 0; i < iv; i++ ) {
				
			}
			break;
		}//while
	}//main
}//class




