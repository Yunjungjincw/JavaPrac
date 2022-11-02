package ch5;

public class ArrayPrac_p162_1101 {

	public static void main(String[] args) {
		/*[0]
		 *[1]
		 *[2]출력
		for(int i=0;i<3;i++) {
			//System.out.println("i가["+i+"]일때");
			//0 1 2 3 4출력 
			for(int j=0;j<5;j++) {
				System.out.print("["+i+"]["+j+"],");
			}
			System.out.println();//줄바꿔
		}
		*/
		
		int[][] scores=
			{
			 //[0][0],[0][1],[0][2],[0][3],[0][4]
			  {100   ,95    ,94    ,93    ,91    }, //학생1의 5과목 점수
			  
			 //[1][0],[1][1],[1][2],[1][3],[1][4] 
			  {80    ,81    ,82    ,93    ,84    }, //학생2의 5과목 점수
					    
			 //[2][0],[2][1],[2][2],[2][3],[2][4]	    
			  {70    ,71    ,72    ,73    ,74   }  //학생3
			}; 
		for(int i=0;i<3;i++) {
			//System.out.println("i가["+i+"]일때");
			//0 1 2 3 4출력 
			for(int j=0;j<5;j++) {
				System.out.print(scores[i][j]+",");
			}
			System.out.println();//줄바꿔
		}
/*		
		
		int[][] scores={
			    {100,95,94,93,91}, //학생1의 5과목 점수
			    {80 ,81,82,93,84}, //학생2의 5과목 점수
			    {70 ,71,72,73,74}  //학생3
			   };
		
		
		//int[] stu1 = {100,95,94,93,91}; //학생1의 5과목 점수
		//int[] stu2 = {80,81,82,93,84}; //학생2의 5과목 점수
		//int[] stu3 = {70,71,72,73,74}; //학생3의 5과목 점수
		
		
		
		System.out.println();//빈줄
		System.out.println("====");
		//5과목의 점수를 저장하는 배열을 생성, 출력
		int[] stu1 = {100,95,94,93,91}; //학생1의 5과목 점수
		for(int i=0;i<stu1.length ;i++) {//stu1.length=5
			System.out.print(stu1[i]+" ");
		}
		
*/		

	}

}
