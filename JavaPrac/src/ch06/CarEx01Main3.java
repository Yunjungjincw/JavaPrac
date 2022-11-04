package ch06;

// 이 클래스는 CarEx01 을 실행하기위한 클래스이다.
// 
public class CarEx01Main3 {

	public static void main(String[] args) {
		// 참조 변수 선언 문법
		CarEx01 myCar;
		myCar = new CarEx01();
		System.out.println(myCar);
		
		
//		System.out.println("무슨색이야"+myCar.color[0]);
		
		//필드값을 가져와 출력
		//필드값 get하기: 참조변수,필드명
		//필드값 set하기: 참조변수, 필드명 = 값;
		System.out.println(myCar.maxSpeed); //250
		System.out.println(myCar.speed); //0
		
		//메서드 (기능)를 호출해서 기능을 작동
		myCar.directionFront();
		myCar.directionFront();
		myCar.directionFront();
		myCar.directionFront();
		myCar.directionFront();
		myCar.directionFront();
		myCar.directionFront();
		myCar.directionBack();
		myCar.controlSpeed();
		myCar.controlSpeed();
		myCar.controlSpeed();
		myCar.controlSpeed();


		
//		myCar.move();{
//		for(int i=1; i<=100; i++) {
//			myCar.controlSpeed(10);
//		}
//		}
	}

}
