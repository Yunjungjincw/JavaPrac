package ch5;

import javax.sql.rowset.serial.SQLOutputImpl;

public class ArrayQuiz_solution {

	public static void main(String[] args) {
		//정수 5개를 저장하기위한 배열생성 및 출력
		// 1~100 사이의 5개의 난수를 배열에 저장하여 출력
		
		//입력 => 작업 => 출력 순으로 프로세스가 진행
		int[] nums= new int[5];
		for(int i=0; i<nums.length; i++) {
			nums[i] = (int)(Math.random()*100)+1;
			// 입력
			System.out.println(nums[i]);
			//출력
		}
	}

}
