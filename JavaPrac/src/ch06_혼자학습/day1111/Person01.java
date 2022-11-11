package ch06_혼자학습.day1111;

/*
 * 
 */

public abstract class Person01 {
	//The abstract method study in type 
	//Person01 can only be defined by an abstract class
	//필드
	//생성자 -> 생략하면 기본생성자 Person01(){}
	Person01(){
		System.out.println("기본생성자 Person01()호출");
	}
	//메서드
	//[접근제어자][제어자]리턴유형 메서드명(매개변수리스트){}
	void eat(){ 
		System.out.println("Person01-eat()");
	}
	abstract void study();
	//This method requires a body instead of a semicolon
	// => The abstract method study in type Person01 can only be defined by an abstract class
}
