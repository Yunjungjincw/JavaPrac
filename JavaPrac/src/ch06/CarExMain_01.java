package ch06;

//이 클래스는 실행클래스
 
public class CarExMain_01 {

	public static void main(String[] args) {
		// Class (클래스)를 이용하여 object(객체)를 생성한다.
		//객체 생성 문법 > new 클래스명();
		//참조변수선언 문법> 타입 변수명[=초기값];
		
		//참조변수선언 및 객체 생성
		
		//참조변수선언 및 CarEx01 클래스의 객체를 생성
		CarEx01 myCar = new CarEx01();
		System.out.println(myCar);
		
		//메서드호출 : 참조변수명.메서드명()
		myCar.move();

	}

}
