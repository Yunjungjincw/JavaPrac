package ch5;

public class ArrayPrac_1101_02 {

	public static void main(String[] args) {
	
		int sum = 0;
		
		int[] numb = {100,100,100,100,100};
		for(int i =0; i<numb.length; i++) {
			sum += numb[i];
			System.out.println(sum);
		}
		System.out.println("-------------------------------------------");
		System.out.println("평균값 :" + sum/numb.length);

	}

}
