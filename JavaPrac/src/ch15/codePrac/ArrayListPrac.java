package ch15.codePrac;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPrac {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		
		
		list.add("java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2,"DB");
		list.add("iBATIS");
		
		int size = list.size();
		System.out.println("총 객체 수: "+ size);
		System.out.println();
		
		String skill = list.get(2);
		System.out.println("2: "+skill);
		System.out.println();
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		for(int i = 0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i+":"+ str);
			
		}
		System.out.println();
		
		list.remove(0);
		list.remove(1);
		list.remove("JDBC");
		
		System.out.println(list);

		
		for(int i =0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i+":"+str);
		}
	}

}
