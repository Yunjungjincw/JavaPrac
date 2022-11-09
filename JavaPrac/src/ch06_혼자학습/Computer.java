package ch06_혼자학습;

public class Computer {
	//배열타입으로 선언
	int sum1(int[] values) {
		int sum = 0;
		for(int i = 0; i<values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
	
	// 배열을 생성하지 않고 , 리스트만 넘겨주는 방법
	int sum2(int ... values) {
		int sum = 0;
		for(int i =0; i<values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
}
