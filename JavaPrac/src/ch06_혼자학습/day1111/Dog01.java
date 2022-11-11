package ch06_혼자학습.day1111;

/*매개변수의 다형성 (p.321~323) 
-매개변수가 클래스 타입일 경우
-해당 클래스의 객체 대입이 원칙이나 자식 객체 대입하는 것도 허용
 -자동 타입 변환
 -매개변수의 다형성*/


//이 클래스는 동물Animal01클래스를 상속받는 클래스이다
public class Dog01 extends Animal01 {
	//보이지않지만 부모클래스의 필드와 메서드 존재
	//단, private필드와 private메서드 제외
	
	//필드
	private String type;	//타입-예) 개, 꾀꼬리
	private double weight;	//무게-예) 5, 0.8 
	
	//생성자
	public Dog01() {}
	public Dog01(String type,double weight) {
		this.type=type;
		this.weight=weight;		
	}
	
	//메서드
	//지킨다(보호한다는 의미)
	public void guard() {
		System.out.println("Dog01-guard()호출");
	}
	
	//소리낸다(클래스타입 매개변수명)
	//Animal클래스의 메서드를 재정의
	@Override
	public void sound(Object o){
		System.out.println("Dog01의 sound():"+o);
	}
	
	
	
	
	
}









