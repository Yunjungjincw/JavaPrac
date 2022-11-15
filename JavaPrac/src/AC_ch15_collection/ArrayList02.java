package AC_ch15_collection;
/*
 * - 인터페이스
 * list 중복 0 순서 0 
 * 구성객체 - Arraylist , Vector, LinkedList (링크로 연결되어있음)
 * set 순서 x 중복 x
 * Hashset
 * 
 * map key value로 구성 , key 값은 중복 x 
 * Hashmap
 */
import java.util.ArrayList;
//컬렉션들은 java.util 패키지 안에 있기 때문에 사용할 때 마다 import 해줘야 함.

public class ArrayList02 {

	public static void main(String[] args) {
		//ArrayList 객체 생성
		//ArrayList 는 List 인터페이스의 구현 클래스 중의하나
		ArrayList<String> list = new ArrayList<>();
		
		
		//value추가 : .add(Object)
		list.add("홍길동");
		list.add("이순신");
		list.add(new String("김구라"));
		list.add(new String("이름"));
		
		// 저장된 value 개수: size();
		System.out.println("list.size(): "+ list.size());
		System.out.println("--------------------");
		
		
		
		//value 꺼내기: Object 리턴하는 get(인덱스)
		Object obj=list.get(0);
		String strObj=(String)obj;//String으로 강제형변환
		int len=strObj.length(); //String으로 변환된 value의 글자길이
		System.out.println(strObj+"의 글자길이: "+len);
		System.out.println(list.get(2)+"-한 줄로 Obj 강제 형변환한 값: "+((String)(list.get(2))).length());
		System.out.println("--------------------");
		
		String strObj2=(String)list.get(1);
		System.out.println(strObj2+"의 글자길이: "+strObj2.length());
		System.out.println();
		
		System.out.println("-----------for문 활용---------");
		for(int i=0; i<list.size(); i++) {
			System.out.println("list 인덱스"+i+"번째 값: "+list.get(i));
		}
		System.out.println("-----------향상된 for문 활용---------");
		for(String i : list) {
			System.out.println(i);
		}
		
		
		System.out.println();
		//value 삭제: remove(인덱스), remove(Object)
		// 객체를 제거할 경우 바로 뒤 인덱스 라인이 삭제된 공백을 채워 넣는 구조를 가지고 있다.
		// 0 1 2 3 => 1 삭제 => 0 null 2 3 이 아니라, 0 1 2 로 수정이 되어 저장된다. 
		list.remove(1);
		// 인덱스가 1인 요소가 삭제가 됨을 의미.
		
		
		System.out.println(list);
		//contains(Object) : 특정요소가 포함되어 있으면 , true리턴
		System.out.println("-------김구라 존재--------");
		if(list.contains("김구라")) {
			System.out.println("김구라는 list에 포함 contains");
			list.remove("김구라");
		} else {
			System.out.println("포함 X");
		}
		System.out.println("--------------------------");
		
		
	
		System.out.println(list);
		for(int i=0; i<list.size(); i++) {
			System.out.println("list 인덱스"+i+"번째 값: "+list.get(i));
		}
		
		//value 확인: 
	}

}
