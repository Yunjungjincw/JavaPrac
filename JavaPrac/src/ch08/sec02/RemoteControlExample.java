package ch08.sec02;

public class RemoteControlExample {
	public static void main(String[]args) {
		//선언과 동시에 초기화
//		RemoteControl rc =  null;
		RemoteControl rc = new Television();
		//rc 를 가지고 Television 객체를 사용할 수 있다.
		rc.turnOn();
		
		rc = new Audio();
		rc.turnOn();
	}
}
