package ch07.sec04.exam1;

public class ComputerExample {

	public static void main(String[] args) {
		int r = 10;
		
		Calculator calculator = new Calculator();
		System.out.println("원면적: "+ calculator.areaCircle(r));
		System.out.println();
		
		
		
		Computer computer = new Computer();
		System.out.println("원면적: "+ computer.areaCircle(r));
		// 자식 클래스인 computer 에서는 수학함수를 써서 더 정확한 계산을 얻을 수 있었음.
	}

}
