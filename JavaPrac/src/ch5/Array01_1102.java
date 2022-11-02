package ch5;

public class Array01_1102 {

	public static void main(String[] args) {
		//동물 - 말,염소,돌고래, 제비, 딱다구리, 까지, 뱀,도마뱀,이구아나
				//포유류
				String[] animal1 = {"캥거루","코알라","곰"};
				String[] animal2 = {"제비","딱다구리","까치"};
				String[] animal3 = {"뱀","도마뱀","이구아나"};
				
				
				//for문 활용 animal1의 값 출력
				for(int i=0; i<animal1.length; i++) {
					System.out.println("for문 활용: "+animal1[i]);
				}
				
				//향상된 for문 활용 animal2의 값 출력
				//향상된 for 문은 처음부터 끝까지 다뽑을 때
				for(String a : animal2) {
					System.out.println("향상된 for문: "+a);
				}
				
				
				
				//배열길이
				System.out.println("animal1길이: "+animal1.length);
				System.out.println("animal2길이: "+animal2.length);
				System.out.println("animal3길이: "+animal3.length);
				
				
				
				//주소확인
				System.out.println("animal1참조변수"+animal1);
				System.out.println("animal2참조변수"+animal2);
				System.out.println("animal3참조변수"+animal3);



				

	}

}
