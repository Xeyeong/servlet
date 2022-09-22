package exam.java;

// Ex01_Method + Ex02_Method 두개의 기능을 합친
// Ex03을 만들고 싶다 ==>
// 다중상속 x ==> 상속을 여러번에 거쳐서 만들기

// 1세대폰 ( 전원 켜기, 전화걸기, 전화끊기, 전원끄기)
// 상속
// 2세대폰 ( + 기능 DMB 기능 넣기 )
// 상속
// 3세대폰 ( + 기능 인터넷 )
// 상속
// 4세대폰 ( + LTE, 5G로 인터넷 ... 추가기능 )

// Ex04_Method라는 클래스 <= 필요한 기능
// 자식객체가 필요한 기능을 가지고있는 부모 객체를
// 선택해서 부모객체의 기능을 받아 오는것( 상속 )
public class Ex03_Method extends Ex02_Method{
	// 재정의
	// 오버로딩(메소드) vs 오버라이드(메소드)(오버라이딩)
	// 							재정의
	// 재정의 : 부모클래스에서 상속받은 메소드를
	// 그대로 사용하지않고 변경해서 사용함(정의를 다시함)
	// rtnInt1 ..2 ...3 <= 각 10, 20 , 30을 리턴 ==> +10
	
			  //어노테이션(annotation : 기계가 해석하는 주석)
	@Override // 인터페이스 상속을 받고 나중에 상속을 지움. => 추후
	public int name1() {
			
		return super.name1() + 10;
		//return name1()+ 10 = return 20;
	}
	
}




