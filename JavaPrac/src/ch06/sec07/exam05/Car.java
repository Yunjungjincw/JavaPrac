package ch06.sec07.exam05;

public class Car {
	String company = "철원자동차";
	String model;
	String color;
	int maxSpeed;
	
	
	//생성자
	Car(){
	}
	
	Car(String model){
		this(model, "은색",250);
		System.out.println("1");
		//생성자의 첫줄에 적어야한다. 아니면 오류가 뜬다.
	}
	Car(String model, String color){
		this(model, color, 250);
	}
	Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
