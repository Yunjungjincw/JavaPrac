package ch07.sec08.exam01;

public abstract class Animal {
	public String kind;
	
	public void breath() {
		System.out.println("숨을 쉽니다");
	}
	
	
	public abstract void sound();
	// 추상 메소드 선언입니다!
}
