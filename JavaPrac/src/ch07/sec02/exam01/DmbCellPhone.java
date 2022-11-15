package ch07.sec02.exam01;

public class DmbCellPhone extends CellPhone {
	
	//필드
	// 새로운 int 타입 필드 선언 
	int channel;
	
	//생성자 
	// 자식 생성자에서는 부모 클래스에있는 필드와 자식 클래스에 있는 필드를 한번에 생성자로 만들어줌.
	DmbCellPhone (String model, String color, int channel) {
		this.model = model;
		this.color = color;
		this.channel = channel;
		//여기서 this는 자식클래스 안에 있는,  나 자신을 가르킴.
	}
	
	
	//메소드
	// 자식클래스에서의 메서드.
	// DMB 에 맞는 메소드들을 설정해줌.
	void turnOnDmb() {
		// void 들을 해줫으니까 return 값은 없다.
		System.out.println("채널 "+channel + "번 DMB 방송 수신을 시작합니다.");
	}
	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널"+ channel + "번으로 바꿉니다");
	}
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다");
	}
}
