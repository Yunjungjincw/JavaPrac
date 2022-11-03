package ch06;

//이 클래스는 CarEx01 클래스의 2번째 실행클래스이다.
public class CarEx01Main2 {

	public static void main(String[] args) {
		//CarEx01 클래스의 객체를 저장하기 위한 변수 선언
		//참조변수 선언 문법 > 타입 변수명 [=초기값];
		CarEx01 myCar;
		
		// CarEx01 클래스의 객체 생성하여
		//참조변수에 객체저장 => 객체의 주소지를 저장
		//객체생성 문법 > new 클래스명 ();
//		myCar = new CarEx01();
//		CarEx01 myCar = new CarEx01();
//		CarEx01 myCar = null;
//		System.out.println("null 나오나 ?: "+myCar);
		
		myCar = new CarEx01();
		 System.out.println("주소지: "+myCar);
//		for(int i=0; i<3; i++) {
//			myCar = new CarEx01();
//			System.out.println("for문 출력: "+myCar);
//			System.out.println("for문 출력: "+myCar.color);
//		}
		
		//CarEx01 클래스의 데이터출력 -> 필드
		 // 참조변수명.필드명 : 필드의 값을 가져오기 => get
		 // 참조변수명.필드명 : 필드의 값을 설정하기 => set

		System.out.println("myCar.colo: "+myCar.color);//색상
		System.out.println("myCar.productDate: "+myCar.productDate);//제조사
		System.out.println("myCar.company: "+myCar.company);//가격
		

		
		System.out.println("myCar.grade: "+myCar.grade); //등급
		System.out.println("myCar.price: "+myCar.price);//가격
		myCar.price = 4000; // 참조변수명.필드명=값;
		System.out.println("변경 후 myCar.price: "+myCar.price);//가격
		
		
		
		//CarEx01클래스의 기능수행 => 메서드 호출
		myCar.move();
		myCar.stop();
		myCar.move();
		myCar.directionFront();
		myCar.directionRight();
		myCar.speedControlUp();
		myCar.speedControlUp();
		myCar.speedControlDown();
		myCar.speedControlDown();
		myCar.speedControlUp();
		myCar.speedControlDown();
		myCar.speedControlDown();
		myCar.speedControlUp();
		myCar.speedControlUp();
		myCar.speedControlDown();
		myCar.speedControlUp();
		myCar.speedControlUp();
		myCar.speedControlUp();
		myCar.speedControlUp();
		myCar.speedControlDown();
		myCar.speedControlDown();
		myCar.speedControlDown();
		myCar.speedControlDown();
		myCar.speedControlDown();
		myCar.speedControlDown();
		myCar.speedControlUp();
		myCar.speedControlUp();
		myCar.speedControlUp();
		myCar.speedControlDown();
		
		
	}

}
