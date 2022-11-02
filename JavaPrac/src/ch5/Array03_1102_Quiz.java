package ch5;

public class Array03_1102_Quiz {

	public static void main(String[] args) {
		int a =10;
		int b=999;
		System.out.println("a="+a);	//10
		System.out.println("b="+b); //999

		System.out.println("---변경작업 진행---");
		
		int temp;
		temp = b;
		b = a;
		a = temp;
		

		System.out.println("a="+a);	// 
		System.out.println("b="+b);	//
	}

}
