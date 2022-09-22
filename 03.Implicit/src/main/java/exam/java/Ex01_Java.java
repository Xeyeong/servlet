package exam.java;
		//패키지 추가 
		// Ex01_Java 클래스를 추가 후 메소드 구현.
		// 리턴이 없는 타입의 메소드 for_star라는 메소드를 만들고
		// 해당하는 메소드의 기능을 구현한다.
		// 메소드 기능 :
		// for문을 이용하여 다음과같은 출력 결과 만들기
		// ★
		// ★★
		// ★★★
		// ★★★★
		// ★★★★★ 
public class Ex01_Java {
	public void for_star() {
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++ ) {
				System.out.print("★");
			}//for j 
			System.out.println("");
		}//for i
	}//for_star
	public void while_star() {
		int i = 1;
		while(i <= 5) {
			int j = 1;
			while(j <= i) {
				System.out.print("★");
				j++;
			}//while j
			System.out.println("");
			i++;
		}//while i
	}//while_star
}//class




