package ch5;

public class Array01_1102_이차배열연습 {

	public static void main(String[] args) {
		//동물 - 말,염소,돌고래, 제비, 딱다구리, 까지, 뱀,도마뱀,이구아나
				//포유류
				String[][] animal =	{
									{"캥거루","코알라","곰","사람","돌고래","침팬치"},
									{"제비","딱다구리","까치","독수리"},
									{"뱀","도마뱀","이구아나","사마귀","무당벌레"}
									};
				
				//for문 활용 animal의 값 출력
				for(int i=0; i<animal.length; i++) {
					for(int j=0; j<animal[i].length; j++)
					System.out.print(animal[i][j]+" ");
				}
				System.out.println();
				
				// animals[0]
				System.out.println("animal[0]의 길이: "+animal[0].length);
				System.out.println("animal[1]의 길이: "+animal[1].length);
				System.out.println("animal[2]의 길이: "+animal[2].length);
				System.out.println();

				
				//animal[0] ~animal[2] 주소출력
				System.out.println("animal주소확인: "+animal[0]);
				System.out.println("animal주소확인: "+animal[1]);
				System.out.println("animal주소확인: "+animal[2]);
				
				//길이출력
				//줄=행 에 대한 값이 출력됨 (3줄이니까 3(\)
				System.out.println("animal길이: "+ animal.length);
				System.out.println();
				
				//주소출력
				System.out.println("animal="+animal);
				System.out.println("--------------------------------");
				System.out.println();
				
				//for문 활용 animal1의 값 출력
				for(int i=0; i<animal.length; i++) {
					for(int j=0; j<3; j++)
					System.out.println("for문 활용: "+animal[i][j]);
				}
				
				//향상된 for문 활용 animal2의 값 출력
				//향상된 for 문은 처음부터 끝까지 다뽑을 때
//				for(String bird : animal2) {
//					System.out.println("향상된 for문: "+bird);
//				}
//				
				
				//배열길이
//				System.out.println("animal1길이: "+animal1.length);
//				System.out.println("animal2길이: "+animal2.length);
//				System.out.println("animal3길이: "+animal3.length);
//				
				
				
				//주소확인
				System.out.println("animal"+animal);
//				System.out.println("animal2참조변수"+animal2);
//				System.out.println("animal3참조변수"+animal3);



				

	}

}
