package ch06.sec06.exam01;

public class Human01_1104 {
	//필드 - 데이터 저장
		//[접근제한자] [제어자] 타입 필드명[=값];
		String name = "손흥민";
		String sex = "man";
		String job = "soccer player";
		int old = 31;
		double height = 183.9;
		String nation = "Korea";
		String position = "forward";
		String team = "토트넘";
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
