package ch5;

import java.util.Random;

public class ArrayQuiz_1101 {

	public static void main(String[] args) {
		//Math.random(): 0.0이상 1.0미만의 난수구하기
		
		
			System.out.println(Math.random());
		
		System.out.println("------------------------------------");
		
		
		//start 이상~(start+n)범위에 속하는 정수 얻기 (p536) => 이게 무슨소리지
		int randomValue;
		randomValue = (int)(Math.random()*100);
		System.out.println(randomValue);
		System.out.println("------------------------------------");
		//(int)(Math.random()*n)+start
		
		
		
		// 1~100 사이의 1개의 난수구하기
		int max = 100;
		int min = 1;
		int random = (int)((Math.random()*(max - min))+min);
		System.out.println(random);
		System.out.println("------------------------------------");
		
		
		
		// 1~100사이의 5개의 난수 구하기
		Random random2 = new Random();
		for(int i=1; i<=5; i++) {
			System.out.println( random2.nextInt(100) + 1 );  
		}
		System.out.println("------------------------------------");
		
		// 1~100 사이에서 숫자를 구할 수 있는 반복문
		for(int i=0; i<=100; i++) {
			System.out.println(i);
		}
		System.out.println("------------------------------------");
		
		
		// 1~100 사이에서 5개의 숫자를 고르는 범위설정
		Random random3 = new Random();
		for(int i=1; i<=5; i++) {
			System.out.println( random3.nextInt(100) + 1 );  
		}
		System.out.println("------------------------------------");
		//정수 5개를 저장하기위한 배열생성 및 출력
		// 1~100 사이의 5개의 난수를 배열에 저장하여 출력
		
		
		
		int[] Arr1 = new int[5];
		Random random9 = new Random();
		for(int i=0; i<5; i++) {
			Arr1[i] = random9.nextInt(100)+1;
			System.out.println(i + "번째" + Arr1[i]);
		}
		System.out.println(Arr1.getClass().getName());
		
		
		
		

	}

}
