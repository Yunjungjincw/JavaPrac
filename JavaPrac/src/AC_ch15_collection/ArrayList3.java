package AC_ch15_collection;

/*
 * 제네릭
 * 제네릭 타입
 * 타입을 파라미터로 가지는 클래스와 인터페이스
 * 선언 시 클래스 또는 인터페이스 이름 뒤에 "<>"부호 붙임
 * "<>" 사이에는 타입 파라미터 위치
 * 
 * 타입 파라미터
 * 일반적으로 대문자 알파벳 한 문자로 표현
 * 개발코드에서는 타입파라미터 자리에 구체적인 타입을 지정해야줘야 함
 */

import java.util.ArrayList;
import java.util.List;


public class ArrayList3 {

	public static void main(String[] args) {
		//클래스타입 참조변수=new ArrayList();
		//부모클래스타입 참조변수 = new 자식 클래스명();
		// 인터페이스명 참조변수 = new 구현 클래스명();
		//ArrayList는 List 인터페이스의 구현 클래스
//		List list = new ArrayList();
		
		//컬렉션에는 다양한 타입을 저장할 수 잇지만
		//여기에서는 String만 저장하는 것으로 제한하겠다.
		
		ArrayList<String> list = new ArrayList<>();
		list.add("김길동");
		list.add("장길동");
		list.add("오래오래오");
		
		System.out.println("-------for문 이용--------");
		String str="";
		for(int i=0; i<list.size(); i++) {
			str=(String)list.get(i);
			System.out.println(str);
		}
		System.out.println();
		System.out.println("-------향상된 for문 이용-------");
		for(String a : list) {
			System.out.println("이름: "+a+"------글자의 길이: "+a.length());
		}

	}
}
