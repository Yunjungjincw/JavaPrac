package AC_ch15_collection;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * 컬렉션 프레임워크의 3가지 인터페이스 종류 종류별 특징
 * list 중복  o 순서 o
 * - ArrayList, Vector, LinkedList 
 * ( ArrayList와 차이점, 속도가 더빠르다. 스레드가 동시에 실행될 때 
 * LinkedList는 한개씩만 실행되어 정보를 삭제 수정할 때 안정적임.)
 * set 중복 x 순서 x 
 * HashSet, 
 * map key value로 구성
 */

public class HashSet01 {

	public static void main(String[] args) {
		//HashSet 객체 생성
		//new 클래스명();
//		HashSet set = new HashSet();
		
		Set set = new HashSet<>();	
		
		
		//value추가
		set.add(1);  //다양한 타입을 저장
		set.add("홍길동");
		set.add("이순신");
		set.add(new String("김구라"));
		set.add(new String("이름"));
		set.add(20);
		set.add(179.3);
		set.add('남');
		set.add(true);
		set.add(new Date());
		
		
		//value개수
		System.out.println("set.size()= "+set.size());
		
		
		//value꺼내기
		//while문 활용
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) { //다음요소가 존재한다면, true리턴
			Object obj = iterator.next();
			System.out.println(obj);
		}
		System.out.println("--------------------");
		//삭제
		if(set.remove("홍길동")) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제 X");
		}
		System.out.println("--------------------");
		//확인 : contains(Object): 제시된 요소가 포함되면 true리턴
		if(set.contains("홍길동")) {
			System.out.println("포함 OK");
		} else {
			System.out.println("포함 X");
		}
		// 저장된 모든 객체 : void clear()
		set.clear();
		if(set.isEmpty() == true) {
			System.out.println("컬렉션 비어있음");
		} else {
			System.out.println("비어있지 않음.");
		}
		
		System.out.println("인터페이스의 길이: "+set.size());
		System.out.println("컬렉션이 비어있는지 확인: "+set.isEmpty());
		//확인
		
		
		
	}
	

}
