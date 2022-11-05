package ch06.sec11.exam01;

public class KoreaExample {

	public static void main(String[] args) {
		
	//객체 생성 시 주민등록번호화 이름 전달
		Korean k1 = new Korean("123456-1234567", "김자바");
		
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		
		
		//Final 필드는 값을 변경할 수 없음
//		k1.nation = "USA";   
//		k1.ssn = "123-12-1234";
		 
		
		k1.name = "김자바";
	}
}
