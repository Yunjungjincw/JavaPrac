package ch07.sec06.package1;

//패키지가 같기 때문에 protected는 사용가능하다.

public class B {
	public void method() {
		A a = new A();
		a.field = "value";
		a.method();
	}
}
