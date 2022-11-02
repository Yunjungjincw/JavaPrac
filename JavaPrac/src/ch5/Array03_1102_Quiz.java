package ch5;

import java.util.Arrays;
import java.util.Collections;

public class Array03_1102_Quiz {

	public static void main(String[] args) {
		//10,999, 300인 3개의 정수값이 저장된 배열을 생성
		//배열안의 순서를 크기 순서대로 나열 되도록 하시오.
		
		
		
		int[] arr3 = {10, 999, 300}; 
		 Integer[] num = Arrays.stream(arr3).boxed().toArray(Integer[] :: new);
		
		 Arrays.sort(num, Collections.reverseOrder());
		 System.out.println(Arrays.toString(num));
		
		 int[] desc = Arrays.stream(num).mapToInt(i -> i).toArray();
	      System.out.println("내림차순"+Arrays.toString(desc));
		
	       
	      
	      System.out.println("--------------------------");
	      //------------------------
		//10, 999인 2개의 정수값이 저장된 배열을 생성
		//새배열에 옮겨서 저장 후 출력
		int[] arr = {10,999};
		int[] arr2 = new int[2];
		
		//원래 배열
		for(int i=0; i<arr.length; i++) {
			System.out.print("원래 배열: "+arr[i]);
		}
		System.out.println();
		
		//새배열 생성
		for(int i=0; i<arr2.length; i++) {
			System.out.print("새배열:"+arr2[i]+" ");
		}
		System.out.println();
		
		//배열 복사
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		
		System.out.println();
		
		//복사한 새배열 출력
		for(int i=0; i<arr2.length; i++) {
			System.out.print("배열 복사"+ arr2[i]+" ");
		}
		
		
		//10, 999 2개의 정수값이 저장된 배열을 생성
		//int[] arr = {10,999};
//		int[] arr = {10,999};
//		int temp1;
		
//		for(int i=0; i<arr.length; i++) {
//			System.out.println(arr[i]+" ");
//		}
//		System.out.println();
//		
//		System.out.println("--변경작업 진행 --");
//			temp1 =arr[1];
//			arr[1]=arr[0];
//			arr[0]=temp1;
//						
//
//		
//		
//		
//		int a =10;
//		int b=999;
//		System.out.println("a="+a);	//10
//		System.out.println("b="+b); //999
//
//		System.out.println("---변경작업 진행---");
//		
//		int temp;
//		temp = b;
//		b = a;
//		a = temp;
//		
//
//		System.out.println("a="+a);	// 
//		System.out.println("b="+b);	//
	}

}
