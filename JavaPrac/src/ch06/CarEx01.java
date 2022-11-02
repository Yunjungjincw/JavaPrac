package ch06;

/*
 * class 클래스명 {
 * field 데이터 타입 변수-데이터
 * method(){} -기능,동작
 * }
 */

// 이클래스는 자동차클래스

public class CarEx01 {
	
	//field -데이터
	//[접근제어자] [제어자] 타입 필드명[=초기값];
	
	String  color   = "빨강";//색상
	String  productDate    ="20221102";//생산일자
	String  company = "중앙정보";//제조회사
	int 	maxSpeed   =100;//속도
	char 	grade   ='A';//등급
	int 	price   =5000;//가격
	

	
	
	//method -기능
	//[접근제어자] [제어자] 리턴유형 메서드명 (){}
	
	//움직이다
	void move() {
		System.out.println("move()호출-움직이다");
	}
	//방향조절
	void stop() {
		System.out.println("stop()호출-멈춘다");
	}
	void direction () {
		System.out.println("direction()호출-방향조절");
	}
	void directionLeft () {
		System.out.println("directionLeft()호출-왼쪽방향조절");
	}
	void directionRight () {
		System.out.println("directionRight()호출-오른쪽방향조절");
	}
	void directionFront () {
		System.out.println("directionFront()호출-앞으로방향조절");
	}
	void directionBack () {
		System.out.println("directionFront()호출-뒤로방향조절");
	}
	void speedControlUp () {
		System.out.println("speedControlUp()호출-속도증가조절");
	}
	void speedControlDown () {
		System.out.println("speedControlDown()호출-속도감소조절");
	}
	
	void speedControl () {
		System.out.println("speedControl()호출-속도조절");
	}
}
