package ch06.shopService;

public class ShopService {
	// 정적 필드 선언 방식
	private static ShopService singleton = new ShopService();
	
	// 생성자
	private void ShopService() {
		
	}

	// 정적 메소드
	static ShopService getInstance() {
		return singleton;
	}
}
