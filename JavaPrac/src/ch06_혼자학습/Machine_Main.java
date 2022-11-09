package ch06_혼자학습;

public class Machine_Main {

	public static void main(String[] args) {
		
		Playstation playstation = new Playstation("video", "playstation", 60);
		//Machine으로부터 상속받은 필드
				System.out.println("종류 : "+ playstation.type);
				System.out.println("이름 : "+ playstation.name);
				System.out.println("가격 : "+ playstation.price);
			

				playstation.turnOn();
				playstation.startGame();
				playstation.stopGame();
				playstation.pauseGame();
				playstation.restartGame();
				playstation.turnOff();
				
				
				
				
	}

}
