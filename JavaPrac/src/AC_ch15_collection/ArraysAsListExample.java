package AC_ch15_collection;

import java.util.Arrays;
import java.util.List;


//p729참고
/*
 * 참고 =- Arrays클래스(교재 p519)
 * - 배열 조작 기능을 가지고 있는 클래스 - 배열 복사, 항목 정렬, 항목 검색
 * - 제공하는 정적 메소드
 */
public class ArraysAsListExample {

	public static void main(String[] args) {
		//클래스명.메서드명()
//		Arrays.asList(a) : 고정된 객체들로 구성된 List 생성
		//아래는 고정된 String 객체를 요소로 갖는 ArrayList 객체 생성
		List<String> list = Arrays.asList("중앙", "정보", "학원");
		System.out.println("-------------for문 사용-------------");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-------------향상된 for문 사용-------------");
		for(String a : list) {
			System.out.println(a);
		}
		System.out.println("---------------------------------");
		
		//정수로 고정Integer된 객체를 요소로 갖는 ArrayList 객체생성
//		Arrays.asList(10,20,30,40,50,60);
		List<Integer> list1 = Arrays.asList(10,20,30,40,50,60);
		for(int a : list1) {
			//변수 v의 타입은 기본타입인 int에 저장되면서
			//자동형변환되었다 => 클래스 => 기본타입으로 언박싱(unBoxing)
			System.out.println(a);
		}
	}
}
