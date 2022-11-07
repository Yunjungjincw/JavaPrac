package ch06.prac01;

public class Member_Main {
	
	//non-static 메서드 => 참조 변수명, 메서드명()
	void test() {}
}

	
	static void showMembers(Member numb) {
	System.out.println(numb.nation);
	System.out.println(numb.name);
	System.out.println(numb.id);
	System.out.println(numb.password);
	System.out.println(numb.age);
	
	public static void main(String[] args) {
		Member member = new Member();

		System.out.println(member.name);
		System.out.println(member.id);
		System.out.println(member.password);
		System.out.println(member.age);
		
		

		
		
		System.out.println(Member.nation);
		
		
		
		
		showMembers(member);
		System.out.println("--------------------------");
		
		Member member2 = new Member("","윤정진","qwe3776","1234",30);
		showMembers(member2);
		System.out.println("---------------------------");
		
		Member member3 = new Member("","손흥민","sid","s123",31);
		showMembers(member3);
		System.out.println("---------------------------");
		
		Member member4 = new Member("","이순신","lid","i123",35);
		showMembers(member4);
		System.out.println("---------------------------");
		
		Member member5 = new Member("","홍길동","hid","h123",20);
		showMembers(member5);
		System.out.println("---------------------------");
	}

}
