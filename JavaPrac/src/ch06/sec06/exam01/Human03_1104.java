package ch06.sec06.exam01;

// 생성자 constructor => 객체(object)를 생성하는데에만 초점을 맞춘 것이다.
// 클래스명 () {}
// 메서드명 [접근제한자] [제한자] 리턴유형 메서드명 (매개변수리스트)

//생성자
//매개변수가 없는 생성자 : 기본생성자(기본 constructor).
//=> 생성자 호출 문법 > 클래스명 (){}
//매개변수가 있는 생성자 : 객체생성시 클래스 필드값을 초기화
//=> 생성자호출 문법> 클래스명 (매개변수리스트) {}
public class Human03_1104 {
	//필드 - 데이터 저장
		//[접근제한자] [제어자] 타입 필드명[=값];
		String name;	//이름	//전역변수
		char sex ;	
		String job ;
		int old ;
		double height;
		String nation;
		String position ;
		String team ;
		//메소드 - 기능
		//[접근제한자][제어자] 리턴유형 메서드명 (매개변수) {}
//			public static void main(String[] args) {} 
		
		//생성자
		Human03_1104(){
			System.out.println("Human03_1104() 호출성공 - 기본생성자");
		}
		
		//객체생성시 외부에서 제공된 값을
		//String n 변수에 저장
		Human03_1104(String name){
			System.out.println("String1 개인생성자 호출 성공/n"+ name);
			
			//매개변수 n에 저장된 값을
			//name 필드에 할당
			this.name = name;
		}
		//외부에서 매개변수가 있는 생성자 호출하면 전달받은 값을
		//매개변수에 저장
		Human03_1104(char sex){
			// 저장된 값을 필드에 설정
			this.sex = sex;
		}
		
		Human03_1104(int old){
			this.old = old;
		}
		
		Human03_1104(double height){
			this.height = height;
		}
		// this 
		Human03_1104(String name, char sex, String job, int old, String nation, String position, double height){
			this.name = name;
			this.sex = sex;
			this.job = job;
			this.old = old;
			this.nation = nation;
			this.position = position;
			this.height = height;
		}
		
		
		

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
