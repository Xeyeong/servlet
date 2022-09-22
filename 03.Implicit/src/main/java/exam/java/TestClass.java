package exam.java;

public class TestClass {
	public TestClass(A a, B b) {
		
	}

	public static void main(String[] args) {
		TestClass tClass = new TestClass(new A("필드"), new B(1,2));
		
	}
	
}

class A {
	public A(String string) {
		System.out.println(string);
	}
}

class B {
	
	public B(int a, int b) {
		System.out.println(a);
		System.out.println(b);
	}
	
}
