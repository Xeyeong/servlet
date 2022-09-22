package exam.java;

public class Overloding {
	
	//메소드 오버로딩
	// ==Java 클래스를 하나 만들고 그안에 같은 이름의 메소드
	//getSum 메소드를 5개 만들어보기 (==이름이 중복이 됨)
	//접근제한자 + 리턴타입 + 메소드이름 + ()소괄호 + 중괄호
	//접근제한자 생략하면 default ( 같은 패키지 내부에서만 접근이 가능함 )

	//메소드의 이름이 중복되면 어떤 메소드가 호출되어야 하는지 컴퓨터는 판단 할수가 없다.
	//따라서 파라메터의 갯수나 타입을 달리해서 각각의 메소드가 어떤식으로 호출되어야하는지
	//정의법을 바꿔서 이름을 중복시켜 사용가능하게 하는것.
	
	//메소드 이름이 같지만 매개변수 타입이 다름
	public void OverLoding1(int a, int b) {
		
	}//
	public void OverLoding1(int a, int b, int c) {
		
	}//
	public void OverLoding1(int a, double b) {
		
	}//
	public void OverLoding1(double a, int b) {
		
	}//
	public void OverLoding1(double a, double b) {
		
	}//
	public void OverLoding1(String a, int b) {
		
	}//
}//class

