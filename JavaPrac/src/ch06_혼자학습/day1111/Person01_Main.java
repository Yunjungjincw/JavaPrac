package ch06_혼자학습.day1111;

//이 클래스는 추상클래스에 관한 실습용 클래스이다.
//추상클래스-Person01
public class Person01_Main {

	public static void main(String[] args) {
		Person01 p = new Person01();
		//Cannot instantiate the type Person01
		//Person01 클래스의 객체를 생성하지 못한다.
		// 왜냐하면 new 연산자로 객체 생성하지 못하고 상속 통해 자식 클래스만 생성 가능
		System.out.println(p);
		
		//Person01을 상속받는 Student01 객체생성
		Student01 s = new Student01();
		//상위클래스가 있는 자식 자식클래스의 생성자를 호출하면
//		내부적으로 상위클래스의 기본생성자가 
//		자동으로 호출된다.
//		부모생성자호출 ->
		s.play();
		s.study();
		s.eat(); 
	
	}

}
