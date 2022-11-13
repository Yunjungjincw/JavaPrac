package ch06.sec07.exam04;

public class CarExample {

	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println("car1.company: "+car1.company);
		System.out.println();
		
		
		Car car2 = new Car("자가용");
		System.out.println("카2 컴퍼니:"+ car2.company);
		System.out.println("카2모델:"+car2.model);
		System.out.println();
		Car car3 = new Car("자가용","빨강");
		System.out.println("카3 컴퍼니:"+ car3.company);
		System.out.println("카3모델:"+car3.model);
		System.out.println("카3 컬러 :"+car3.color);
		System.out.println();
		Car car4 = new Car("택시","검정", 200);
		System.out.println("카4 컴퍼니:"+ car4.company);
		System.out.println("카4모델:"+car4.model);
		System.out.println("카4 컬러 :"+car3.color);
		System.out.println("카4 맥스스피드 :"+car4.maxSpeed);
		System.out.println();

	}

}
