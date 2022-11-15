package ch07.sec04.exam2;

public class SupersonicAirplaneExample {
	public static void main(String[]args) {
		SupersonicAirplane sa = new SupersonicAirplane();
		sa.takeOff();
		sa.fly();
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();
		sa.flyMode = SupersonicAirplane.NORMAL;
	// 상속된 클래스를 자식클래스에서 다시 수정 후 사용
		sa.fly();
		sa.land();
	}
}
 