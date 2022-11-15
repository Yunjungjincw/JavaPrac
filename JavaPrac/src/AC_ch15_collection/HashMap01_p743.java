package AC_ch15_collection;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HashMap01_p743 {

	public static void main(String[] args) {
//		Map map = new HashMap();
		//위의 코드는 아래와 동일하다.
		Map<Object,Object> map = new HashMap<>();
		//key,value추가 : put(Object key,Objectvalue)
		
		//아래코드처럼 key와 value타입은 Object타입으로 추가 가능하다.
		//Object타입 key가 들어갈 수 있지만, 편의상 String
		
		//???????????????????
		map.put("key", 1);
		map.put(1, 1);
		map.put(2, 1.5);
		map.put(true, false);
		map.put("문자열", new Date());
		
		
		//Object타입 key가 들어갈 수 있지만, 편의상 String
		Map<String,Integer> map1 = new HashMap<>();
//		map1.put("신구", 80.8);
		//여기에서는 80.8 은 실수타입.
		//즉 실수의 wrapper클래스인 Double 타입으로 값을 추가하겠다고 하였지만,
		//위에서 new HashMpap<String,Integer>(); 하면서
		//값을 Integer. 즉 정수형태의 값만을 저장하겠다고 제한하였기 때문에 X
		map1.put("홍길동", 90);
		map1.put("동장군", 80);
		map1.put("구라", 100);
		map1.put("홍길동", 100);
		
		//만약 key가 동일하다면 마지막 key가 가진 value로 저장된다.
		// 1번째 홍길동 90 이고 두번째 100이니까 홍길동 출력하면 뒤에 100짜리 홍길동이 찍힘.
		System.out.println("홍길동 값 : "+(map1.get("홍길동")));
		
		System.out.println(map1.get("홍길동"));
		
		//key를 이용하여 value를 꺼내기
		//key 를 알면 get(key 명)
		Integer i1 = map1.get("홍길동");
		System.out.println(i1);
		
		
		int i2  = map1.get("구라");
		//Integer타입을 int 타입의 변수에 저장 => unBoxing
		//unBoxing이란 wrapper클래스 타입 -> 기본타입으로 전환
		System.out.println(i2);
		
		
		
		
		// key를 모르면 모든 key를 꺼내기 => while 반복문
		// 꺼낸 key 하나 하나에 대해서 
		// => 각 key에 대한 value를 꺼내기
		

	}

}
