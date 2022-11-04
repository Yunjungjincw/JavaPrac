package ch06.sec06.exam01;

public class Human02_1104 {
	//필드 - 데이터 저장
		//[접근제한자] [제어자] 타입 필드명[=값];
		String name;	//이름	//전역변수
		char sex ;	
		String job ;
		int old ;
		double height ;
		String nation = "Korea";
		String position ;
		String team ;
		//메소드 - 기능
		//[접근제한자][제어자] 리턴유형 메서드명 (매개변수) {}
//			public static void main(String[] args) {} 
		//움직인다
		void move () {
			System.out.println("move()");
		}
		void speak () {
			System.out.println("speak()");

		}
		void eat () {
			System.out.println("eat");

		}
}
