package ch06.prac01;


// 이 클래스는 Car_p223 클래스의 실행클래스이다.
public class Car_p223_1107_Main {
		//필드
		//생성자
		//메서드
	public static void main(String[] args) {
		//Car+223 클래스 객체 생성
		Car_p223_1107 myCar =new Car_p223_1107();

		
		//자동가스충전위해 필드로 직접 접근 불가
//		myCar.gas=10;
		//* private 접근제한자는 외부에서 접근 불가
		//
		//The field Car_p223_1107.gas is not visible

		
		//가스충전위해 gas갑 설정하기() 기능 이용
		myCar.setGas(10);
		
		//가스 잔량 체크
		 boolean gasState = myCar.isLeftGas();
		 System.out.println("gasState: "+gasState);
		 
		 if(gasState) { //gas 없다면 //조건만족시 실행코드
			 System.out.println("가스 상태: 있음");
			 myCar.run();
				return; 
			} else {
				 System.out.println("가스 상태: 없음");
				return;
				
			}
		 //주행하기 => 참조변수명.run()
	}
}
