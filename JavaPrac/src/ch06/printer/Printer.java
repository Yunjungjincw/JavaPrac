package ch06.printer;

public class Printer {
	public int println(int num) {
		System.out.println(num);
		return println(num);
	}
	
	public boolean println(boolean bool) {
		System.out.println(bool);
		return println(bool);
	}
	
	public String println(String str) {
		System.out.println(str);
		return println(str);
	}
	
	public double println(double db) {
		System.out.println(db);
		return println(db);
	}

}
