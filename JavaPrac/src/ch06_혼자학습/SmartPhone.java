package ch06_혼자학습;

public class SmartPhone extends Phone01{
	//필드
	private String company;	//제조회사
	private String model;	//모델명
	private String color;	//색상
	private int price;	//가격
	private String nation;	//생산국가
	private String productDate;	//생산일
	private String telecom;
	private String os;
	
	
	public SmartPhone() {}
	public SmartPhone(
			String company,	String model,String color,	int price,	String nation,String productDate, String telecom, String os
					) {
		this.company = company;
		this.model =model;
		this.color =color;
		this.price = price;
		this.nation = nation;
		this.productDate = productDate;
		this.telecom = telecom;
		this.os = os;
	
	}
	
	@Override
	public String sound() {
		return "스마트스마트~~~~~~~";
	}
	
	public String sendMSG(String message) {
		return message;
	}
	public void receiveMSG(String message) {
		System.out.println("수신 내용:"+message);
	}
	
	
	//무선네트워크와 접속(인터넷을 사용한다)
	public void connectInternet() {
		System.out.println("인터넷 연결");
	}
	
	//카메라 기능
	public void cameraOn() {
		System.out.println("카메라 On");
	}
	@Override
	public String toString() {
		return "SmartPhone [company=" + company + ", model=" + model + ", color=" + color + ", price=" + price
				+ ", nation=" + nation + ", productDate=" + productDate + ", telecom=" + telecom + ", os=" + os + "]";
	}
	
	
	
	
	
	
	
	
	
}
