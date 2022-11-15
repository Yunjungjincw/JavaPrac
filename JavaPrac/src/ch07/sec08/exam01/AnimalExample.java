package ch07.sec08.exam01;

public class AnimalExample {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		cat.sound();
		System.out.println("---------");

		
		
		
		//변수의 자동 타입변환
		Animal animal = null;
		animal = new Dog();
		animal.sound();
		animal = new Cat();
		animal.sound();
		System.out.println("---------");
		
		
		
		//메소드의 다형성//
		animalSound(new Dog());
		animalSound(new Cat());
	}
	//자동 타입 변환을 하고 실행 클래스에서 메소드를 만들어서 매개변수로 넣어줌
	public static void animalSound(Animal animal) {
		animal.sound();
	}

}
