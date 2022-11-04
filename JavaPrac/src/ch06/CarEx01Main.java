package ch06;

//이 클래스는 실행클래스
 
public class CarEx01Main {

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
		System.out.println(myCar);
		System.out.println(myCar.toString());
		
		//Object클래스 (교재 457) / toString(); 는 p464 
		//Object클래스는 최상위클래스로
		//모든 클래스는 Object클래스를 상속받는다.
		
		//Object 클래스의 toString(); 객체의 문자정보를 리턴
		// 객체의 문자 정보란 ? 객체를 문자열로 표현한 값을 말한다.
		// 기본적으로 "패키지명.클래스명@16진수 해시코드" 로 구성된다.
		
		
		
	

	}

}
