package ch06.sec07.constructor.copy;



public class PersonExample {

	public static void main(String[] args) {
		Person  p1 = new Person("931028-1231111","윤정진");
		
		System.out.println(p1.nation);
		System.out.println(p1.name);
		System.out.println(p1.ssn);
		
		
//		p1.nation = "usa";
//		p1.ssn = "931028-2222222";
		p1.name = "이름이당";
		
		System.out.println(p1.name);
		 
		 
		 
	}
}
