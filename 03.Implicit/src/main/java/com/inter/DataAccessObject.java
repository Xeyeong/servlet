package com.inter;

// class, interface 어떻게 구분할까
// 옵저버패턴 ( 미리 메소드나 여러가지를 구현해놓고 나중에 보고를 받는 형태 )
// 클래스의 설계도 개념으로 사용 ( 전자정부에서 많이씀 Spring )
public interface DataAccessObject {
	//먼저 메소드를 정의만 한다(==선언)
	public String IP = "121.147.215.32";
	public void select(); //DB에서 어떤 정보를 조회해온다.
	// JDBC : INSERT , UPDATE , DELETE
	// 성공했는지 실패했는지 어떻게 판단?
	// update, delete, insert 메소드를 만들고
	//	성공 , 실패를 판단할수있는 리턴타입으로 만들기. 
	// 인터페이스 수정 후에 OracleDAO 오류 발생 시 어떻게 할까?
	
	// CRUD ( 조회 , 추가 , 수정 , 삭제 ) ==> 
	public int delete();
	public int update();
	public int insert();
	
	
	
}//DataAccessObject
