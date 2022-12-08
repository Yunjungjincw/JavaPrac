package ArrayPrac;

public class BasickPrac {

	public static void main(String[] args) {
//		String[] names = null;
////		names[0] ="윤정진";
//		
//		names = new String[] {"윤정진","김동호","홍길동"};
//		System.out.println(names[0]);
//		System.out.println(names[1]);
//		System.out.println(names[2]);
//
//		
//		String[] pork = new String[5];
//		pork[0] = "소고기";
//		pork[1] = "닭";
//		pork[2] = "돼지";
//		pork[3] = "오소리";
//		pork[4] = "사슴";
//		
//		
//		System.out.println(pork.length);
//		System.out.println(pork[0]);
//		System.out.println(pork[1]);
//		System.out.println(pork[2]);
//		System.out.println(pork[3]);
//		System.out.println(pork[4]);
//		
//		
		int[] nub = new int[30];
		//index 30이면 0~29까지 
		// length 쓰면 30까지 
		
		System.out.println(nub[0]);
		System.out.println(nub[1]);
		System.out.println(nub[2]);
		System.out.println(nub[3]);
		System.out.println("------------------");
		
		for(int i=0; i<nub.length; i++) {
			// 여기서 i에 1을 넣어서 실행하게 되면, index [1] 자리에 값이 들어가는 것이기 때문에 ,
 		  nub[i] += i; 
			//nub[i] += i; 
		}
		
		System.out.println(nub[0]);
		System.out.println(nub[1]);
		System.out.println(nub[2]);
		System.out.println(nub[3]);
		System.out.println(nub[4]);
		//그럼 30은 안찍히겟지
//		System.out.println(nub[30]);
		//Index 30 out of bounds for length 30
		//길이 30에 대해 범위를 벗어난 인덱스 30
		
		
		boolean[] type = new boolean[5];
		System.out.println(type[0]);
		System.out.println(type[1]);
		System.out.println(type[2]);
		System.out.println(type[3]);
		System.out.println(type[4]);
		
	}

}
