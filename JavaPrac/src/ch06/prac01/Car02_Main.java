package ch06.prac01;

public class Car02_Main {
		//field
		//생성자
		//메서드
			static void showField(Car02 car){
		//참조변수를 참조하여 
		//해당 객체의 필드에 접근.출력
		//참조변수명.필드명
			System.out.println("color:"+car.color);
			System.out.println("nation:"+car.nation);
			System.out.println("price:"+car.price);
			System.out.println("isGas:"+car.isGas);
		}
		
		public static void main(String[] args) {
			//참조변수선언 및 객체생성
			Car02 myCar=new Car02();
			//new Car02() 매개변수가 없는 기본생성자를 호출
			System.out.println(myCar);
			System.out.println(myCar.toString());
			
			//참조변수를 참조하여
			//해당 객체의 메서드호출
			//참조변수명.메서드명(매개변수);
			//단, static있는 메서드를 호출시에는 참조변수x
			showField(myCar);
			System.out.println("-----");
			
			//argument가 있는 생성자를 생성자호출 객체생성
			//참조변수선언 및 객체생성
			Car02 myCar2= new Car02("black");		
			//해당 객체의 필드에 접근.출력 //참조변수명.필드명
			showField(myCar2);
			System.out.println("-------");
			
			Car02 myCar5=new Car02("white","한국");
			showField(myCar5);
			System.out.println("-------");
			
			Car02 myCar6=new Car02("white","한국",7000);
			showField(myCar6);
			System.out.println("333 위를 봐-------");
			
			Car02 myCar7=new Car02("white","한국",7000,true);
			showField(myCar7);
			System.out.println("-------");
			
			
			//참조변수선언 및 객체생성-가격제시
			Car02 myCar3= new Car02(9999);		
			showField(myCar3);
			System.out.println("-------");
			
			//참조변수선언 및 객체생성-가스차량여부 제시
			Car02 myCar4= new Car02(true);
			showField(myCar4);
			
		}//main

}
