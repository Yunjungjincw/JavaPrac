package ch06.sec10.exam02;

public class TelevisionExample {

	public static void main(String[] args) {
//		Television tv = new Television();
		System.out.println(Television.info);
		// 정적 필드와 정적 메소드는 클래스에 고정된 멤버이므로 
		//클래스 로더가 클래스(바이트코드)를 로딩해서 메소드 메모리 영역에 적재할 때 클래스별로 관리된다. 
		//따라서 클래스의 로딩이 끝나면 바로 사용할 수 있다.

	}

}
