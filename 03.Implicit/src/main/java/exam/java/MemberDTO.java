package exam.java;

public class MemberDTO {
	private int a, b, c;
	private String d, e;
	

	public MemberDTO(int a) {
		this.a = a;
	}
	public MemberDTO(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public MemberDTO(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public MemberDTO(int a, String d) {
		this.a = a;
		this.d = d;
	}
	public MemberDTO(String d, String e) {
		this.d = d;
		this.e = e;
	}
}//class
