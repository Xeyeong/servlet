package exam.java;

public class JSY_PrinterExample{
	public static void main(String[] args) {
		
		Printer.println(10);                          
		Printer.println(true);	                      		
		Printer.println(5.7);                         
		Printer.println("홍길동");       
		
	}//main
}//class

class Printer {
	public static void println(int a) {
		System.out.println(a);
	}//println
	
	public static void println(boolean b) {
		System.out.println(b);
	}//println
	
	public static void println(double c) {
		System.out.println(c);
	}//println
	
	public static void println(String d) {
		System.out.println(d);
	}//println
	
}//class





