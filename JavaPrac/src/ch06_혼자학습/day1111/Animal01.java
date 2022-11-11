package ch06_혼자학습.day1111;


/*매개변수의 다형성 (p.321~323) 
-매개변수가 클래스 타입일 경우
-해당 클래스의 객체 대입이 원칙이나 자식 객체 대입하는 것도 허용
 -자동 타입 변환
 -매개변수의 다형성*/

//이 클래스는 동물클래스이다
public class Animal01 {	
	//필드
	private String type;	//타입-예) 개, 꾀꼬리
	private double weight;	//무게-예) 5, 0.8 
	
	//생성자
	public Animal01() {}
	public Animal01(String type,double weight) {
		this.type=type;
		this.weight=weight;
	}
	
	//메서드
	//먹는다
	public void eat() {}
	//잔다
	public void sleep() {}
	//소리낸다(클래스타입 매개변수명)
	public void sound(Object o) {
		System.out.println(o);
	}
}







