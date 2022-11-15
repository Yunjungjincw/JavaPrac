package ch07.sec02.exam01;

//실행 클래스이다. 
// public 으로 처음ㅇ ㅔ 설정하고 만듬.
public class DmbCellPhoneExample {

	public static void main(String[] args) {
		//DmbCellPhone 객체 생성
		// 참조변수를 써서 새로운 객체를 생성해준다. 매개변수에도 값을 바로 넣어줌. 3개.
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		
		//CellPhone으로부터 상속받은 필드
		//매개변수에 들어온 값을 바로 읽어봄.
		
		System.out.println("모델: "+ dmbCellPhone.model);
		System.out.println("색상: "+ dmbCellPhone.color);
		
		
		//DmbCellPhone의 필드
		System.out.println("채널: "+ dmbCellPhone.channel);
		
		//CellPhone으로부터 상속받은 메소드 호출
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receiveVoice("안녕하세요 ! 저는 홍길동인데요.");
		dmbCellPhone.sendVoice("아 예 반갑습니다.");
		dmbCellPhone.hangUp();
		
		
		
		//DmbCellPhone의 메소드 호출
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();
		
		
		//dmbCellPhone은 자식 클래스이지만, 부모 클래스로부터 상속을 받았기 때문에, 
		// 부모클래스 메소드들을 사용할 수 있음.
		//또한 필드도 바로바로 호출해서 사용 가능.

	}

}
