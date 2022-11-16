package ch08.sec02;

public class Television implements RemoteControl {
							//인터페이스가 가진 추상메소드를 반드시 구현해야 함.
							// 그래야 인터페이스 변수에 대입을 할 수 있음.
	// Television 객체는 RemoteControl 를 interface로 사용할 수 있다.
	
	@Override
	public void turnOn() {
		System.out.println("tv를 켭니다");
	}
}
