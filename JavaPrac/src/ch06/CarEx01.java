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
	//필드 = 전역 변수
	//[접근제어자] [제어자] 타입 필드명[=초기값];
	
	String[] color   = {"빨강","노랑","파랑","초록","검정","주황"};//색상
	String  productDate    ="20221102";//생산일자
	String  company = "중앙정보";//제조회사
	int 	maxSpeed   =250;//속도
	int     minSpeed   =0;
	int		distance   =0;
	int		sideDistance =0;
	int		speed	=0;
	char 	grade   ='A';//등급
	int 	price   =5000;//가격
//	Tire01 tire = null;
	Tire01[] tires = null;
	//배열로 설정한 이유.
	//자동차의 타이어는 4개, 각 타이어는 독립적이다.
	// 앞왼쪽의 마모율과 뒤오른쪽의 마모율은 다룰 수 있다.
	//String[] tires = {}
	

	
	
	//method -기능
	//[접근제어자] [제어자] 리턴유형 메서드명 (){}
	
	//움직이다
	
	void move() {
		System.out.println("move()호출-움직인다");
	}
	//방향조절
	void stop() {
		System.out.println("stop()호출-멈춘다");
	}
	//왼쪽으로
	void directionLeft () {
		sideDistance += 10;
		System.out.println("directionLeft()호출-왼쪽방향조절");
	}
	//오른쪽으로
	void directionRight () {
		sideDistance -= 10;
		System.out.println("directionRight()호출-오른쪽방향조절");
	}
	//앞으로
	void directionFront () {
		distance += 10;
		System.out.println(distance);
	}
	
	//뒤로
	void directionBack () {
		distance -= 10;
		System.out.println(distance);
	}
	void controlSpeed () {}
	void controlSpeed (int s) {
	
//		System.out.println("controlSpeed()진입");
//		speed++;
//		int s =5;
		speed=speed+s;
		System.out.println("현재 Speed "+speed);
	}
	//속도 증가
	void speedControlUp () {
		if(speed <= maxSpeed) {
			// <= 범위라고 생각하면 됨. a<100 는 a가 100까지 실행. 
			/// a<=100 은 100보다 낮은 전구간과 100이랑 같을때까지 실행됨
			speed+=50;
			System.out.println("speedControlUp: "+speed);	
		} else {
			System.out.println("최고속도에 도달하였습니다.");
		}
	}
	//속도 감소
	void speedControlDown () {
		speed -= 50;
			System.out.println("speedControlDown:"+speed);
		if(speed >= 0) {
			System.out.println("더 이상 속도를 낮출 수 없습니다.");
		}
	}
}
	

