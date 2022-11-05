package ch06.sec14;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setSpeed(-50);
		System.out.println(myCar.getSpeed());
		
		myCar.setSpeed(60);
		System.out.println(myCar.getSpeed());

		if(myCar.isStop()) {
			myCar.setStop(true);
			//자동차가 움직이고 있다면, 멈추게 하겠다.
		}
		System.out.println(myCar.getSpeed());
	}

}
