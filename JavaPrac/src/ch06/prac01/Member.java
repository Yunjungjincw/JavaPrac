package ch06.prac01;

public class Member {
	static String nation = "Korea~";
	
	
	String name;
	String id;
	String password;
	int age;
	
	
	Member(){
		System.out.println("기본생성자");
	}
	Member(String nation, String name, String id, String password, int age){
		this.nation = "Korea~";
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
		//받아주는 생성자가 없으면 원래 저장되어 있는 필드 초기값으로 출력됨.
	}
	
	
	
	
	
	//method
	// [접제][제어자] 리턴유형 메서드명(매개변수) 
}
