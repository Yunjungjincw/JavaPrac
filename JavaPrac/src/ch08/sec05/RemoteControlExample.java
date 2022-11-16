package ch08.sec05;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl rc;
		
		
		rc = new Television();
		rc.turnOn();
		rc.setVolume(10);
		rc.turnOff();
		rc.setMute(true);
		rc.setMute(false);
		
		
		
		rc = new Audio();
		rc.turnOn(); 
		rc.setVolume(5);
		rc.turnOff();
		
		//디폴트 메소드 호출
		rc.setMute(true);
		rc.setMute(false);
		
	
		RemoteControl.changeBattery();

	}

}
