package ch5;

public class Array_solution_Real {

	public static void main(String[] args) {
		//Math.random(): 0.0이상 1.0미만의 난수구하기
		System.out.println(Math.random());
		System.out.println("-------------------------------");
				//start이상~(start+n)범위에 속하는 정수얻기(p536)
				//(int)(Math.random()*n)+start
				//예문> 1~6  주사위   (int)(Math.random()*6)+1
				//예문> 1~45로또번호 (int)(Math.random()*45)+1
				//1~100사이의 1개의 난수구하기
				int n0=(int)(Math.random()*100)+1;
				System.out.println("1개의 난수: "+ n0);
				System.out.println("-------------------------------");
				
				//1~100사이의 5개의 난수구하기
				int n1=(int)(Math.random()*100)+1;
				int n2=(int)(Math.random()*100)+1;
				int n3=(int)(Math.random()*100)+1;
				int n4=(int)(Math.random()*100)+1;
				int n5=(int)(Math.random()*100)+1;
				
				for(int i=0;i<5;i++) {//5번반복
					System.out.println("5개의 난수구하기 : "+(int)(Math.random()*100)+1);			
				}
				System.out.println("-------------------------------");
				
				//정수5개를 저장하기위한 배열생성 및 출력
				int[] nums0=new int[5]; //0으로 자동초기화
				for(int i=0;i<nums0.length;i++) {//5번반복
					System.out.println("배열 생성: "+nums0[i]);			
				}
				
				//-------------------------------------------
				//1~100사이의 5개의 난수를 배열에 저장하여 출력하세요
				//향상된 for문이용하여 배열안의 값을 출력
				//배열이나 컬렉션에 value가 존재하는 동안만 반복실행
				/*실행순서
				 * 1. 배열명 또는 컬렉션명
				 * 2. 데이터타입 변수명
				 *    배열(또는 컬렉션)에서 value를 하나씩 꺼내어
				 *    변수에 저장한다
				 * 3. for{}블럭안의 코드를 반복실행   

				for(데이터타입 변수명 : 배열명 또는 컬렉션명) {
					//반복실행코드
				}
				*/
				System.out.println();//빈줄
				System.out.println("--아래 향상된for이용--");
				int[] nArr=new int[5];// 0 0 0 0 0
				for(int temp : nArr) {
					temp = (int)(Math.random()*100)+1;
					System.out.println(temp);
				}
				System.out.println("------아래는 for문이용-------");
				
				int[] n=new int[5];
				for(int i=0;i<n.length;i++) {//5번반복
					n[i] = (int)(Math.random()*100)+1;
					System.out.println(n[i]);			
				}
				
				System.out.println("--------");
				//코드구현1>
				int[] nums=new int[5];
				for(int i=0;i<nums.length;i++) {//5번반복
					nums[i] = (int)(Math.random()*100)+1;
					System.out.println(nums[i]);			
				}
				System.out.println("---------");
				
				//1~100사이의 5개의 난수를 배열에 저장하여 출력하세요
				//코드구현2> 절차를 나누어서 진행하는 형태=> 향후 메서드로 변경할 수 있다
				//입력->작업->출력 순으로 프로세스가 진행
				//선언
				int[] nums1=new int[5];
				
				//입력 & 작업
				for(int i=0;i<nums1.length;i++) {
					nums1[i] = (int)(Math.random()*100)+1;
				}
					
				//출력
				for(int i=0;i<nums1.length;i++) {
					System.out.println(nums1[i]);
				}
				System.out.println("-----------향상된 for문 연습----------");
				
				int[] s = new int[] {100,90,85,90,100};
				for(int data : s) {
					data = (int)(Math.random()*100)+1;
				System.out.println(data);
				}
			}
	}
