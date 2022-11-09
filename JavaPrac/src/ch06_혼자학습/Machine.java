package ch06_혼자학습;
	
public class Machine {
	//필드
	String type;//게임기 종류
	String name;// 이름
	int price;// 가격
	
	
	
	//생성자
	
	//메소드
		void turnOn() {
			System.out.println("전원 On");
		}
		void turnOff() {
			System.out.println("전원을 Off");
		}
	}




//하위 클래스
class Playstation extends Machine{

	//필드
	

	
	//생성자
	Playstation(String type, String name, int price){
		this.type = type;//부모 클래스로부터 상속받은 필드.
		this.name = name;
		this.price = price;
	}
		
		
		
	//메소드
		@Override
		void turnOn() {
			super.turnOn();
		}
		@Override
		void turnOff() {
			super.turnOff();
		}
		void startGame() {
			System.out.println("게임을 실행합니다.");
		}
		void stopGame() {
			System.out.println("게임을 종료합니다.");
		}
		void pauseGame() {
			System.out.println("게임을 잠시 멈춤합니다.");
		}
		void restartGame() {
			System.out.println("게임을 다시 진행합니다.");
		}
}