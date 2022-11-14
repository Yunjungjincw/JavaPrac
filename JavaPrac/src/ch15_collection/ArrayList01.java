package ch15_collection;


//java.lang 패키지를 제외한 그 외 패키지는 import 해야한다.
//Object 클래스,  wrapper 클래스 ...
import java.util.ArrayList;
import java.util.Date;

/*
 * Collection Framework(컬렉션 프레임워크)
 * -3가지 인터페이스
 * List:   순서o, 중복o 예)대기자 list
 * Set:   순서x, 중복x
 * Map:   Key와 value가 한 pair
 * 		  key는 중복허용x
 * 		  value는 중복허용
 */
public class ArrayList01 {
	public static void main(String[] args) {
//		java.util.ArrayList list =
//				new java.util.ArrayList();
		
		ArrayList list = new ArrayList();
		System.out.println(list);
		System.out.println(list.toString());
		
		
		//리스트안에 저장된 요소 (item)의 개수를 리턴
		//참고> length: 배열(array)에 저장된 요소(item)의 개수를 리턴 
		//size : Returns the number of elements in this list.
		int size = list.size();
		//배열에서의 length는 속성 -----------> size 메소드 
		System.out.println("Array size: "+size); // 0 
		
		//value 추가 
		//List에는 다양한 타입의 value을 추가할 수 있음.
		// 배열> 배열(array)에는 동일한 타입의 value을 추가. ( String, int , double, boolean, date ?, char ...)
		list.add("홍길동");
		list.add(new String("서울시 강남구"));
		list.add("hid");
		list.add(20);
		list.add(179.3);
		list.add('남');
		list.add(true);
		list.add(new Date()); // Date(현재 날짜와 시간 객체 생성) = > java.lang 패키지를 제외한 그 외 패키지는 import 해야한다. 
		int result = list.size();
		System.out.println("Array size: "+result);
		System.out.println(list);
		
		
	}
}
