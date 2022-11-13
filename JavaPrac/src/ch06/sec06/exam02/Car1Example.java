package ch06.sec06.exam02;

public class Car1Example {
	public static void main(String[] args) {
		//car 객체
		Car1 mycar = new Car1();
		
		System.out.println(mycar.company);
		System.out.println(mycar.model);
		System.out.println(mycar.color);
		System.out.println(mycar.maxSpeed);
		System.out.println("원래속도"+mycar.speed);
		
		
		
		mycar.speed = 60;
		System.out.println("변경된 솓"+mycar.speed);
	}
}
