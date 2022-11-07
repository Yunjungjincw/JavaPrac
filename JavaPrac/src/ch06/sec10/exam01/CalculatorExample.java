package ch06.sec10.exam01;

public class CalculatorExample {

	public static void main(String[] args) {
//		Calculator myCalcu = new Calculator();
//		double result1 = 10*10*myCalcu.pi;
//		int result2 = myCalcu.plus(10, 5);
//		int result3 = myCalcu.minus(10,5);
		//The static method plus(int, int) from the type Calculator should be accessed in a static way
		//Calculator 유형의 정적 메서드 plus(int, int)는 정적 방식으로 액세스해야 합니다.
 		
		
		
		
		
		double result1 = 10 * 10 * Calculator.pi;
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10,  5);
//		
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : "+ result2);

	} 

}
