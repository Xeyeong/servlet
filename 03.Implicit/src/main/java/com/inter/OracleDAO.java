package com.inter;

public class OracleDAO implements DataAccessObject{
	//public int ip = 0;
	public static int ip = 111;
	// 기획자나 설계자가 의도한 메소드 이름, 리턴타입, 파라미터 갯수등을
	// 미리 인터페이스로 만들어놓고나서 여러개발자에게 다시 줌.
	// 기능구현은 인터페이스를 상속받은 클래스에서 한다.
	// 상수 vs 변수
	// double pie = 3.14;  <= 절대로 수정이 불가능하게 만들기
	final static double PIE = 3.14;
	@Override
	public void select() {
		//PIE = 5.14;
		System.out.println(IP + "오라클로 SELECT 쿼리 함");
	}
	
	@Override
	public int insert() {
		System.out.println(IP + "오라클로 INSERT 쿼리 함");
		return 1;
	}

	@Override
	public int update() {
		System.out.println(IP + "오라클로 UPDATE 쿼리 함");
		return 1;
	}

	@Override
	public int delete() {
		System.out.println(IP + "오라클로 DELETE 쿼리 함");
		return 1;
	}
	
	//설계도를 사용하지않고 직접만듬
	//	public void select() {
	//		
	//	}
}
