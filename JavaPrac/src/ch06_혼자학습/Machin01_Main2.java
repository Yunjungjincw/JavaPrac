package ch06_혼자학습;


public class Machin01_Main2 {

	public static void main(String[] args) {
		Machin2 machin02 = new Machin2("회사","모델","색상",90,"나라","11/10");
		
		
		//필드와 메서드 확인
		System.out.println(machin02);
		System.out.println(machin02.toString());
		
		
		
		System.out.println("-----------------아래는 phone01 생성자------------------");
		Phone01 phone01 = new Phone01("넥슨","mns1","red",350000,"korea","20221110","skt");
		System.out.println(phone01.toString());
		System.out.println(phone01);
		
		phone01.powerOn();
		phone01.makeCall();
		System.out.println(phone01.sound());
		phone01.receiveCall();
		phone01.powerOff();
		
		
		System.out.println("-----------------아래는 SmartPhone 생성자------------------");
		SmartPhone smartphone01 = new SmartPhone("애플","아이폰13pro","black",1500000,"us","20221110","자급제","mac");
		System.out.println(smartphone01.toString());
		System.out.println(smartphone01);
		
		
		System.out.println();
		smartphone01.powerOn();
		smartphone01.makeCall();
		
		//왜 안뜨지
		System.out.println("발신 메세지: " + smartphone01.sound());
		//왜 안뜨지
		System.out.println(smartphone01.sendMSG("뭐라는거지"));
		
		smartphone01.receiveMSG("뭐라는거지");
		smartphone01.connectInternet();
		smartphone01.cameraOn();
		smartphone01.powerOff();
		System.out.println();
		System.out.println();
		
		
		System.out.println("============= 기계=new 전화기 ==============");
		Machin2 mc2 = new Phone01();
		mc2.powerOn();
		System.out.println(mc2.sound());
		mc2.powerOff();
		//mc2.makeCall(); => 안됨
		//기계 Machin2 클래스에서 makeCall()은 선언되지 않았는데, 호출하려니 에러발생
		// => makeCall()은 전화가 가진 기능이지
		//기계 Machin2 클래스에서 가진 기능이 아니지 때문이다.
		
		
		
		
		
		
		System.out.println("----------????????????------------------");
		Phone01 mc3 = new SmartPhone();
		mc3.makeCall();
		mc3.receiveCall();
//		mc3.cameraOn;
		
		System.out.println("---------------------------------");
		Machin2 mc4 = new SmartPhone();
//		mc4.makeCall();
		mc4.powerOn();
		mc4.powerOff();
	
	}	
	
 
}
