package AC_ch15_collection;

import java.util.Arrays;
import java.util.List;

public class ArrayList03 {
	public static void main(String[] args) {
		
		List<String> list1 = Arrays.asList("홍길동","김구라","이순신");
		for(String name: list1) {
			System.out.println(list1);
		}
		List<Integer> list2 = Arrays.asList(1,2,3);
		for(int value: list2) {
			System.out.println(list2);
		}
		
		
	}
}
