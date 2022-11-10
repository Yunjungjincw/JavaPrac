package ch06_혼자학습;

// 이 클래스는 (전기) 기계에 대한 속성, 기능 ~~~
public class Machin01 {
	//field
	//[접근제한자][제한자] 데이터타입 필드명[=초기값];
	String company;	//제조회사
	String model;	//모델명
	String color;	//색상
	int price;	//가격
	String nation;	//생산국가
	String productDate;	//생산일
	
	
	//constructor
	//[접근제한자][제어자]클래스명(매개변수리스트){}
	public Machin01() {
	}
	public Machin01(
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
	public String sound(){
		return "따르릉~~~";
	}
	public void powerOff(){
		System.out.println("powerOf()- 전원을 끕니다");
	}
	
	

//  Phone01 클래스
class Phone01 extends Machin01 {
	
		//필드
		public String telecom;
		
		
		Phone01(){
		}
		
		Phone01(String company,	String model,String color,	int price,	String nation,String productDate ){
			this.company = company;
			this.model = model;
			this.color = color;
			this.price = price;
			this.nation = nation;
			this.productDate = productDate;
			this.telecom = telecom;
		}
		
		
		public void makeCall() {
			System.out.println("makeCall-전화를 건다");
		}
		public void receiveCall() {
			System.out.println("receiveCall-전화를 받는다.");
		}
		
		@Override
		public String toString() {
			return "Phone01 [sound()=" + sound() + "]";
		}




// SmartPhone01 클랫
class SmartPhone01 extends Phone01 {
			
			
		public String os;
			
			
		SmartPhone01(){
			}
		SmartPhone01(String company,	String model,String color,	int price,	String nation,String productDate ){
				this.company = company;
				this.model = model;
				this.color = color;
				this.price = price;
				this.nation = nation;
				this.productDate = productDate;
				this.telecom = telecom;
				this.os = os;
			}

			public void internet() {
				System.out.println("internet - 무선네트워크와 접속(인터넷을 사용한다)");
			}
			@Override
			public String toString() {
				return "SmartPhone01 [sound()=" + sound() + "]";
			}
	
		}
	}
	
	

	
	
	//Object의 toString()을 오버라이딩
	//Object의 toString(): 객체으 정보를 해시코드문자열형으로 제공
	//이 클레스의 toString(): 객체의 필드의 값을 문자열형으로 제공
	
	


}


