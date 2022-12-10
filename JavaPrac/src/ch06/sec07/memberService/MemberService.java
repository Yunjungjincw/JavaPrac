package ch06.sec07.memberService;

public class MemberService {
	
	boolean login(String id, String password) {
		// equals  함수는 
		//Compares this string to the specified object. 
		//The result is true if and only if the argument is not null and is a String object that represents the same sequence of characters as thisobject. 
		
		//&& and 좌항과 우황이 모두 참 일 때만 전체가 참이 됩니다.
	if(id.equals("hong") && password.equals("12345")) {
		return true;
	} else {
		return false;
	}
}
	
	void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
	
	
	
	
	
	
	
	
	
	
//	public void logout(String id) {
//	}
//	
//	
//	public boolean login (String id, String password) {
//		return login(id, password);
//	}
//	
	
}
