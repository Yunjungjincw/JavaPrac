package ch07.sec03.exam01;

public class SmartPhone extends Phone{
	//자식 생성자 선언
	public SmartPhone(String model, String color) {
		super(); 	// 부모 생성자 호출하는 코드를 입력하지 않더라도 컴파일시 자동으로 생성된다.
					// => 명시적으로 넣어도된다. => 필요하면 항상 첫줄에 입력해야 한다.
		this.model = model;
		this.color = color;
		 System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
	}
}
