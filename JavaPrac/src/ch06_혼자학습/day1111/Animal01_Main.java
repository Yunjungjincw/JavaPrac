package ch06_혼자학습.day1111;

/*매개변수의 다형성 (p.321~323) 
-매개변수가 클래스 타입일 경우
-해당 클래스의 객체 대입이 원칙이나 자식 객체 대입하는 것도 허용
 -자동 타입 변환
 -매개변수의 다형성*/

/*이 클래스는 
	Animail01-Dog01
	Animail01-Bird01 들과의 실행클래스이다 */
public class Animal01_Main {

	public static void main(String[] args) {
		//클래스 참조변수=new 클래스명();
		Animal01 animal=new Animal01();
		animal.eat();
		animal.sound("동물소리");
		System.out.println();//빈줄
		
		Dog01 dog=new Dog01();
		dog.guard();
		dog.sound("강아지소리");
		System.out.println();//빈줄
		
		Bird01 bird=new Bird01();
		bird.fly();
		bird.sound("새소리");
		System.out.println();//빈줄
		System.out.println("--------------");
		System.out.println();//빈줄		
		
		//부모클래스 참조변수=null;
		Animal01 ani=null;
		//참조변수=new 자식클래스명();
		ani=new Dog01();
		ani.sound("왕왕");//Dog01의 메서드가 호출       =>Dog01의 sound():왕왕
		ani.sound(new Dog01());//Dog01의 메서드가 호출 =>Dog01의 sound():ch07.Dog01@762efe5d
		ani.sound(dog);        //Dog01의 메서드가 호출 =>Dog01의 sound():ch07.Dog01@5d22bbb7 
		
		ani=new Bird01();
		ani.sound("참새");//Bird01의 메서드가 호출	      =>Bird01의 sound():참새
		ani.sound(new Bird01());//Bird01의 메서드가 호출 =>Bird01의 sound():ch07.Bird01@5d22bbb7
		ani.sound(bird);		//Bird01의 메서드가 호출 =>Bird01의 sound():
		
		
		//부모클래스 참조변수 = new 자식 클래스명();
		Animal01 animals = new Dog01();
		System.out.println("animals=new Dog01()면:"+animals);
		if(animals instanceof Dog01) {
			System.out.println("animals 참조변수에는 Dog01클래스의 객체주소가 들어있다.");
			((Dog01)animals).guard();// 강제클래스형볁환(down casting): 상위클래스 -> 하위클래스 변환
			//다운캐스팅을 한 후 -> 여기에서는 Bird01 클래스로 변환 후 ->  Dog01 클래스.guard()호출
		}else if(animal instanceof Bird01){
			System.out.println("animals 참조변수에는 Bird01 클래스의 객체주소가 저장");
			((Bird01)animals).fly();;
		}
	}

}









