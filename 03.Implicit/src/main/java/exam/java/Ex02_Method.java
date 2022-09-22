package exam.java;

import java.lang.reflect.Method;
import java.security.PublicKey;

public class Ex02_Method extends Ex01_Method{
	public static void main(String[] args) {
		
		
	//상속 : 자식 => 부모를 선택해서 기능을 상속 받는것
		
	// extends     : 상속 ( 클래스 ) : 다중상속 X
	// implements  : 상속 ( 인터페이스 ) : 다중상속 O 

	//Ex03_Method 라는 클래스에서
	//Ex01_Method + Ex02_Method
	//안에있는 모든 기능을 사용하려면
	//어떻게 해야할까?
	
	//Ex01_Method라는 클래스에서 이미 구현되어있는 기능을 사용하고싶은 경우
	// 1. 다시 메소드를 만든다.
	Ex01_Method method = new Ex01_Method();
		method.name1();
		method.name7();
	}
	
	public int name8() {
		return 20;
	}
	
}