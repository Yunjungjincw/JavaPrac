package ch07.sec03.exam02;

public class SmartPhoneExample {

	public static void main(String[] args) {
		SmartPhone myPhone = new SmartPhone("갤럭시","은색");
		//부모 생성자 실행되고, 자식 클래스에 있는 생성자 실행되었음.
		
		System.out.println(myPhone.model);
		System.out.println(myPhone.color);
	}

}
