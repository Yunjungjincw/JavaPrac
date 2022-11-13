package ch06.sec06.exam02;

public class KoreanExample {
	public static void main(String[] args) {
		//Korean 객체 생성
		Korean k1 = new Korean("윤정진", "931028-1231231");
		System.out.println("k1"+k1.nation);
		System.out.println("k1"+k1.name);
		System.out.println(k1.ssn);
		System.out.println("------------------");
		
		
		
		//또 다른 Korean 객체 생성
		Korean k2 = new Korean("김자바", "931232-9191123");
		System.out.println("k2"+k2.nation);
		System.out.println("k2"+k2.name);
		System.out.println("k2"+k2.ssn);
		System.out.println("줄바꿈");
	}
}
