package ch07.sec06.package2;

//D는 부모클래스로 A를 상속 받음.
// 객체를 생성하지 않고 메소드를 바로 호출 가능함.
import ch07.sec06.package1.A;

public class D extends A{
	//생성자 선언
	public D () {
		//A() 생성자 호출
		super();
	}
	
	//메소드 선언
	public void method1() {
		// A 필드갑 변경
		this.field = "value";
		// A 메소드 호출
		this.method();
	}
	
	//메소드 선언
	//직접 객체 생성해서 사용하는 것은 안됨.
//	public void method2() {
//		A a = new A();
//		a.field = "value";
//		a.method():
//	}
}
