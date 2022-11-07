package ch06.prac01;


//이 클래스는 자동차관련 클래스
public class Car_p223_1107 {
	//필드
	//[접근제한자][제한자] 타입 필드명[=초기값];
	
	int gas; // 0으로 자동 초기화
	// private 같은 클래스 안에서만 사용 가능
	
	
	//constructor:object 생성자 주로 필드값을 초기화함
	//[접근제한자][제어자] 클래스명(매개변수리스트){}
	
	//method :기능, 동작
	// [접근제한자][제어자] 리턴유형 메서드명(매개변수리스트){}
	
	//gas값 설정하기
	void setGas (int gas) {
		this.gas = gas;
	}
	//가스 잔량 확인
	boolean isLeftGas() {
		if(gas  <= 0 ) { //gas 없다면 //조건만족시 실행코드
			System.out.println("가스 남아있지 않아요");
			return false; 
		}  
		System.out.println("GAS 남아 있어요.");
		return true;
	}
	//움직이기
	void run() {
		while(true) {
			if(gas > 0) { //조건을 만족 실행했을 떄 코드
				System.out.println("주행중. 현재 gas :"+gas);//움직이기
				//gas = gas -1; 		//field gas 의  값이 -1씩 감소
				gas -= 1;
			}else { 	//가스가 있지 않다면, 조건만족 x 실행코드
				System.out.println("주행 X");
				return; //break 말고 return 사용
			}
		}//while
	}//run
	
	
	
//	void run() {
//		if(gas > 0) { //조건을 만족 실행했을 떄 코드
//			System.out.println("주행중.");//움직이기
//		}else { 	//가스가 있지 않다면, 조건만족 x 실행코드
//			System.out.println("주행 X");
//		}
//		return;
		//return; //메서드 종료
		//return 값 ; 원칙이다.
//	}

}//class
