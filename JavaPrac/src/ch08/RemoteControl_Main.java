package ch08;


//p359
//이 클래스는 RemoteControl 기능을 사용하는 실행클래스이다.
public class RemoteControl_Main {

	public static void main(String[] args) {
		//참조변수선언 및 객체생성

		//		RemoteControl rc = new RemoteControl();
		
		//인터페이스는 생성자가 없으므로 객체를 생성할 수 없다.
		//Cannot instantiate the type RemoteControl
//		=> 따라서  구현클래스의 객체를 생성하고
//		생성된 구현클래스의 객체를 통하여
//		필드와 메서드를 사용
//		이때 인터페이스의 필드는 static final필드로서 상수이다.
//		static 키워드로 인해 인터페이스명.상수명예 접근가능
				
			System.out.println(RemoteControl.MAX_VOLUME);
		
			//구현클래스의 객체를 생성
			//여기에서는 Television, Audio클래스
			Television objTV = new Television();
			objTV.turnOn();
			objTV.setVolume(-10);
			objTV.turnOff();
			
			System.out.println("--------------------");
			
			
			//Audio 작동 
			Audio objAudio = new Audio();
			objAudio.turnOn();
			objAudio.setVolume(-10);
			objAudio.turnOff();
			System.out.println("--------------");

			//다형성 적용시켜보기
			//상위클래스명 참조변수=new 하위클래스명();
			//인터페이스명 참조변수=new 구현클래스명();
			
			
			
			RemoteControl rc = new Television();
			rc.turnOn();
			rc.setVolume(-10);
			rc.turnOff();
			System.out.println("---------------");
			
			
			//다형성 적용시켜보기
			RemoteControl rc1 =objTV;
			rc1.turnOn();
			rc1.setVolume(-10);
			rc1.turnOff();
			System.out.println("-------------------");
			
			RemoteControl rc2 =new Audio();
			rc2.turnOn();
			rc2.setVolume(-10);
			rc2.turnOff();
			System.out.println("-------------------");
			
			RemoteControl rc3=objAudio;//기존 객체이용
			rc3.turnOn();
			rc3.setVolume(-10);
			rc3.turnOff();
			System.out.println("--------");
			
			
			
			SmartTelevision st = new SmartTelevision();
			st.turnOn();//RemoteControl인터페이스의 추상메서드 재정의한것 호출
			st.setVolume(-10);//RemoteControl인터페이스의 추상메서드 재정의한것 호출
			st.search("네이번"); //Searchable인터페이스의 추상메서드 재정의한것 호출
			st.turnOff();//RemoteControl인터페이스의 추상메서드 재정의한것 호출
			
			
;	
	}
}
