package ch06.account;

public class Account {
	//필드에 상수를 설정한다. 필드는 데이터 그러니까 가져다 쓸 수 있음.
	// 배운건데 왜 활용이 안될까...하..
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000;
	//이제 상수 말고. 기본 필드를 설정하는데 다른곳에서 가져다 쓸 수 없도록 private 를 설정한다.
	private int balance;
	
	
	// getter  -> 실행 클래스에서 값을 가져다 쓸 수 있도록.
	public int getBalance() {
		return balance;
	}
	
	// setter 는 이제 값을 필드값에 저장을 할 수 있도록 설정하는 것.
	// 범위는 || 을 써서 또는 
	public void setBalance(int balance) {
		//|| 는 둘중에 하나라도 그값이 true 라면 아래 return 을 반환하는 것임, 그 반대인 && 는 둘다 해당되었을 때 true를 반환함.
		if(balance<Account.MIN_BALANCE || balance>Account.MAX_BALANCE) {
		return;
	}
	this.balance = balance;
	// 둘다 이제 해당이 안된다면 setter 로  받은 값을 이제 필드에 저장해주는 것이고,
 }
}
	
	
//	//필드는 setter 와 getter 를 생성하여 불러야하니까 Balance로 저정하자 
//	private int balance ;
//	
//	
//	
//	public Account() {
//	}
//
//
//
//	public int getBalance() {
//		return balance;
//	}
//
//
//
//	public void setBalance(int balance) {
//		if(balance <= 1000000) {
//			this.balance = balance;
//		} else if(balance >= 0) {
//			this.balance = balance;
//		} else {
//			System.out.println("시발!");
//		}
//		
//	}
	