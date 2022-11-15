package ch07.sec05.exam01;

public class SportsCar extends Car{
	@Override
	//speedUp은 final을 쓰지 않았고
	public void speedUp() {speed += 10;}
	
	//오버라이딩 안됨
//	@Override
//	//stop 메소드는 final 사용 => 오버라이딩 못함.
//	public void stop() {
//		System.out.println("스포츠카를 멈춤");
//		speed = 0;
//	}
}
