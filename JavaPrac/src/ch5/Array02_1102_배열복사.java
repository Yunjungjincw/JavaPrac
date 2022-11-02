package ch5;

public class Array02_1102_배열복사 {
	
	
	
	/*
	 * 배열복사
	 * -배열은 한 번 생성하면, 크기 변경불가
	 * -더 많은 저장 공간이 필요하다면
	 * 보다 큰 배열을 새로 만들고
	 * 이전 배열로부터 항목 값들을 복사
	 */

	public static void main(String[] args) {
		
		String[] oldStrArr = {"자바", "배열", "복사"}; //원본배열
		String[] newStrArr = new String[7];//새배열
		
		System.out.println("---oldStrArr값출력---");
		for(int i=0; i<oldStrArr.length; i++) {
			System.out.print(oldStrArr[i]+" ");
		}
		System.out.println(); //빈줄
		System.out.println("---newldStrArr값출력---");
		for(int i=0; i<newStrArr.length; i++) {
			System.out.print(newStrArr[i]+" ");
		}
		System.out.println();
		
		//배열복사
		System.out.println("---배열복사 진행---");
//		System.arraycopy(oldStrArr, 0, newStrArr, 5, 2);
		System.arraycopy(oldStrArr, 0, newStrArr,0, oldStrArr.length);
		
		
		//새배열의 값 출력
		System.out.println("---newldStrArr값출력---");
		for(int i=0; i<newStrArr.length; i++) {
			System.out.print(newStrArr[i]+" ");
		}
		
		
	}

}
