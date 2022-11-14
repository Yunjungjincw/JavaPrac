package ch08;

public interface RemoteControl {
	// 필드 -> 오직 [public] static final 상수필드 (constant field)가 존재
	//	private int a = 10;
	//	only public, statitc & final are [ermitted]
	// static 필드는 모든 객체에서 공동(공유)으로 사용되는 
	
	//객체를 생성하지 않고 => 객체의 참조주소를 이용하지않고
	// => 클래스명을 통해서 접근한다.
	// => 클래스명.필드명
	
	// static 필드 =  클래스필드 = 정적 필드
	int MAX_VOLUME = 100;
	//public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
			
	
	//생성자 -> 인터페이스에서는 생성자 존재 X
	//Remotecontrol(){}
	//Interfaces cannot have constructors
	
	//메서드
	// 리턴유형 메서드 (매개변수리스트);   {}----> 없음   	//추상메서드
	//default 리턴유형 메서드 (매개변수리스트);     	 	//default 메서드
	//static 리턴유형 메서드 (매개변수리스트);    		//static 메서드
	
	
	//전원켜기
	public void turnOn();
	// public void turnOn();   //{}----> 없음   	//추상메서드
	
	//전원끄기
	public void turnOff();
	
	//볼륨조절하기
	public void setVolume(int volume);


}
