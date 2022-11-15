package ch07.sec08.exam01;

public class Dog extends Animal {
	// 오버라이딩하지 않을 경우 에러가 뜬다.
	//The type Dog must implement the inherited abstract method Animal.sound()
	public Dog() {
		this.kind = "포유류";
	}

	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
