package ch13.sec02.exam02;

public class HomeAgency implements Rentable<Home>{
	// rentable<Home>으로 사용할 수 있는 homeAgency 라는 클래스를 하나 선언 하겠다.
	
	@Override
	public Home rent() {
		return new Home();
	}
	
}
