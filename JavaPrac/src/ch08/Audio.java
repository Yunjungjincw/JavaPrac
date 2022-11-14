package ch08;


//p351
// 이클래스는 구현클래스이다.
//구현 클래스명 implements 인터페이스명    => 구현 클래스
public class Audio implements RemoteControl {
//구현클래스에서는 반드시 인터페이스에서 상속받은 추상클래스를 반드시 구현해야한다.
	//= > 추상 클래스를 반드시 오버라이딩 해야한다는 의미   => 메서드 재정의
//The type Television must implement 
//the inherited abstract method 
//RemoteControl.setVolume(int)
	
	//필드
	private int volume;
	

	//전원켜기 메서드 재정의
	public void turnOn() {
		System.out.println("Audio 전원on()");
	}
	//전원끄기 메서드 재정의 
	public void turnOff() {
		System.out.println("Audio 전원off()");
	}
	//볼륨조절하는  메서드 재정의
	//MAX_VOLUME과 MIN_VOLUME은 static 이므로 
	//클래스명 .필드명으로 접근
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {//제시된 volume 이 최대볼륨보다 크면 // 최대 볼륨으로 현재 volume으로 설정
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME){//제시된 볼륨이 최저볼륨보다 작다면
			//최저 볼륨으로 현재 volume으로 설정
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			//제시된 볼륨이 최저볼륨과 최대볼륨사이라면
			//제시된 볼륨으로 현재 volume으로 설정
			this.volume = volume;
		}
		System.out.println("현재 Audio 볼륨 : "+this.volume);
			
		}
		
}

