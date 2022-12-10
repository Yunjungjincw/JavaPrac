package ch06.sec07.memberService.copy;

public class MemberServiceExample {

	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
	
		if(result) {
//				result가 트루라는 것을 확인하는 코드를 작성하고, 
//				확인되면 로그인 되었습니다 출력,
			System.out.println("로그인 되었습니다");
			memberService.logout("hong");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}

	}

}
