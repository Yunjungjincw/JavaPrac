package ch06_혼자학습;
//전화기
//String,    String,String,int   ,String, String        , String
//company,model,color,price,nation,productDate ,telecom  
//제조회사,모델명,색상,가격,생산국가,생산일       ,통신사
//넥슨,mns1,red,350000,korea,20120203            ,좋은유선통 
//넥슨,mns2,ivory,120000,china,201212
//
//makeCall() //전화를 건다
//receiveCall()//전화를 받는다
//sound()//소리가 난다
public class Phone01 extends Machin2 {
	//Machin2로부터 상속받은 필드와 메서드가 존재.
	//필드
	private String company;	//제조회사
	private String model;	//모델명
	private String color;	//색상
	private int price;	//가격
	private String nation;	//생산국가
	private String productDate;	//생산일
	private String telecom;
	
	//생성자
	public Phone01() {}
	
	public Phone01(String company,	String model,String color,	int price,	String nation,String productDate, String telecom) 
	{
		this.company = company;
		this.model =model;
		this.color =color;
		this.price = price;
		this.nation = nation;
		this.productDate = productDate;
		this.telecom = telecom;
	}
	
	//메서드
	public void makeCall() {
		System.out.println("전화걸기");
	}
	public void receiveCall() {
		System.out.println("전화받기");
	}
	
	@Override
	public String sound() {
		return "폰 따르르르르~~~~";
	}

	@Override
	public String toString() {
		return "Phone01 [company=" + company + ", model=" + model + ", color=" + color + ", price=" + price
				+ ", nation=" + nation + ", productDate=" + productDate + ", telecom=" + telecom + "]";
	}
	
	
	
}
	//메서드
