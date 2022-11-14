package ch08;

//p356
//서치기능 선언한 인터페이스다.
//구현 인터페이스 implements 인터페이스명1 .... 인터페이스명 n
public interface Searchable {

	//추상메소드
	//문법> public abstract 리턴 유형 메서드명(매개변수 리스트);
	public abstract void search(String url);
}
