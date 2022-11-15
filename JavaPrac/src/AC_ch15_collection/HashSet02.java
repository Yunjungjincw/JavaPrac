package AC_ch15_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSet02 {

	public static void main(String[] args) {
		//HashSet 기본생성자를 호출하여
		//인터페이스타입의 set 참조변수에 저장

		Set<String> set= new HashSet<>();
		//제너릭 타입 파라미터
		set.add("hoNg");
		set.add("kIm");
		set.add("뭐할려고");
//		set.add(true); // boolean 타입이잖아
		
		Iterator<String> iterator = set.iterator();
		String e="";
		//안에 있는 요소들 뽑아 쓸때
		while(iterator.hasNext()) {
			e = iterator.next();
			System.out.println("대문자: "+e.toUpperCase());
			System.out.println("소문자: "+e.toLowerCase());
		}
		System.out.println();
		for(String a : set) {
			System.out.println(a);
		}
	}

}
