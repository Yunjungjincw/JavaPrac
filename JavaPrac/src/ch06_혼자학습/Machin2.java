package ch06_혼자학습;

// 이 클래스는 (전기) 기계에 대한 속성, 기능 ~~~
public class Machin2 {
	//field
	//[접근제한자][제한자] 데이터타입 필드명[=초기값];
	private String company;	//제조회사
	private String model;	//모델명
	private String color;	//색상
	private int price;	//가격
	private String nation;	//생산국가
	private String productDate;	//생산일
	
	
	//constructor
	//[접근제한자][제어자]클래스명(매개변수리스트){}
	public Machin2() {
	}
	public Machin2(
			String company,	String model,String color,	int price,	String nation,String productDate) {		
		this.company = company;
		this.model =model;
		this.color =color;
		this.price = price;
		this.nation = nation;
		this.productDate = productDate;
	}
	
	//method
	//[접근제한자][제어자]리턴유형 메서드명(매개변수리스트)
	public void powerOn(){
		System.out.println("powerOn()-전원을 켭니다");
	}
	public String sound() {
		return "따르르르르~~~~";
	}
	public void powerOff(){
		System.out.println("powerOf()- 전원을 끕니다");
	}
	
	
	
	@Override
	public String toString() {
		return "Machin2 [company=" + company + ", model=" + model + ", color=" + color + ", price=" + price
				+ ", nation=" + nation + ", productDate=" + productDate + "]";
	}





//  Phone01 클래스
//이클래스는 Machine01을 상속하는 Phone01클래스입니다.

//public class Phone01 extends Machin2{
//
//	
//	//필드
//	public String telecom;
//	//생성자
//	public Phone01() {
//	}
//	public Phone01(String company, String model, String color, int price, String nation, String productDate, String telecom) {
//		super(company, model,color, price, nation, productDate);
//		this.telecom = telecom;
//	}
//	//메서드
//	
//	@Override
//	public void sound() {
//		System.out.println("Phone 소리가 납니다");
//	}
//	
//	// getter / setter
//	public void makeCall() {
//		System.out.println("전화를 건다");
//	}
//
//	public void receiveCall() {
//		System.out.println("전화를 받는다");
//	}
//	
//	public String getTelecom() {
//		return telecom;
//	}
//
//	public void setTelecom(String telecom) {
//		this.telecom = telecom;
//	}
//	@Override
//	public String toString() {
//		return "Phone01 [telecom=" + telecom + ", company=" + company + ", model=" + model + ", color=" + color
//				+ ", price=" + price + ", nation=" + nation + ", productDate=" + productDate + "]";
//	}
//
//	//소리가 난다.
//	
//	
//	
//	
//}
//
////이클래스는 Phone01을 상속하는 SmartPhone1클래스입니다.
//
//public class SmartPhone1 extends Phone01{
//
//	
//	//필드
//	String os;
//	String mobileOperator;//무선통신사
//	//생성자
//	public SmartPhone1(String company, String model, String color, int price, String nation, String productDate, String telecom, String os) {
//		super(company, model, color, price, nation, productDate, telecom);
//		this.os = os;
//	}
//	//메서드
//	public void getMessage() {
//		System.out.println("문자를 받는다");
//	}
//	
//	public void sendMessage() {
//		System.out.println("문자를 보낸다");
//	}
//	
//		
//	//무선네트워크와 접속(인터넷을 사용한다)
//	void connectNetwork() {
//		System.out.println("무선 네트워크와 접속합니다.");
//		}
//		
//	
//	//카메라기능
//	void camera() {
//		System.out.println("카메라 기능을 사용합니다.");
//		}
//	
//	
//	@Override
//	public void sound() {
//		System.out.println("SmartPhone 소리가 납니다");
//	}
//	@Override
//	public String toString() {
//		return "SmartPhone1 [os=" + os + ", mobileOperator=" + mobileOperator + ", telecom=" + telecom + ", company="
//				+ company + ", model=" + model + ", color=" + color + ", price=" + price + ", nation=" + nation
//				+ ", productDate=" + productDate + "]";
//	}
//	
//	
//	
//	
//
//	
//	
//	//소리가 난다.
//	
//	
//	
//	
//}	
}

