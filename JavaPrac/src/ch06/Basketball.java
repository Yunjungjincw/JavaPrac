package ch06;

public class Basketball {
	String team = "Golden State Warriors";//소속팀
	String position = "Forward";//포지션
	String skill = "shooting";
	double height = 190;//신장
	int weight = 100;//몸무게
	int number = 8;//등번호
	
	
	
	
	void directionLeft () {
		System.out.println("directionLeft()호출- ← (왼쪽방향조절)");
	}
	void directionRight () {
		System.out.println("directionRight()호출- → (오른쪽방향조절)");
	}
	void directionFront () {
		System.out.println("directionFront()호출- ↑ (앞으로)");
	}
	void directionBack () {
		System.out.println("directionFront()호출- ↓ (뒤로)");
	}
	void directionBackRightDiagonal () {
		System.out.println("directionFront()호출- ↘ (대각선 R 뒤로)");
	}
	void directionBackLeftDiagonal () {
		System.out.println("directionFront()호출- ↙ (대각선 L 뒤로)");
	}
	void directionFrontRightDiagonal () {
		System.out.println("directionFront()호출- ↗ (대각선 R 앞으로)");
	}
	void directionFrontLeftDiagonal () {
		System.out.println("directionFront()호출- ↖ (대각선 L 앞으로)");
	}
	
	void speedControlUp () {
		System.out.println("speedControlUp()호출-속도증가조절");
	}
	void speedControlDown () {
		System.out.println("speedControlDown()호출-속도감소조절");
	}
	void jump () {
		System.out.println("jump()호출-점프");
	}
	
	
	
	
}
