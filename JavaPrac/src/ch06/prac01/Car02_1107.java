package ch06.prac01;

// 이클래스는 자동차 설계도이다.
// 클래스 멤버
// field: 데이터 저장
// [접근 제한자][제어자] 타입 필드명[=초기값];
// constructor: 오브젝트 생성 method
// method: 기능 동작
//[접근 제한자][제어자] 리턴유형 메서드명(arguments){}
public class Car02_1107 {
	// field : 데이터저장
	//전역변수는 타입에 따라 자동초기화 된다
	String color ;
	String nation ;
	int price ;
	boolean isGas;
	
	
	// constructor : object 생성 method
	Car02_1107(){
		System.out.println("기본생성자");
	}
	Car02_1107(String color){
		//참조변수명.필드명
		this.color = color;
		//this 는 Car2_1107 객체의 참조변수
		//필드명이 매개변수명과 동일하면
		//반드시 this.필드명을 사용
		//필드와 매개변수를 구분하기 위해.
		System.out.println("String 1개인 생성자");
		System.out.println("----------------------------------");
	}

	Car02_1107(int price){
		this.price = price;
		System.out.println("int 1개인 생성자");
		System.out.println("----------------------------------");
	}
	
	
	Car02_1107(boolean isGas){
		this.isGas = isGas;
		System.out.println("boolean 1개인 생성자");
		System.out.println("----------------------------------");
	}
	
	
	//this()
	//색상, 제조국가의 값을 받아서 필드초기화하는 생성자
	
			
			
			
			// 동일 클래스에 있는 또 다른 생성자를 호출
			//한개의 동일 클래스 내에서 생성자는 또 다른 생성자를 호출 할 수 없다.
			//이때는 this()를 사용해야한다
//			this.color = color;
//			this.nation = nation;
		
//		Car02_1107(String color, String nation, int price, boolean isGas){
//			this(color, nation, price, true);
//		}
}

