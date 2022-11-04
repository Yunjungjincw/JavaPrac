package ch06.sec06.exam01;

// 이 클래스는 실행 클래스 (Human01_1104)
public class Human_Main01_1104 {

	public static void main(String[] args) {
		//
		Human01_1104 son = new Human01_1104();
//		System.out.println(son);	
		
		//참조변수 선언 및 클래스 객체 생성

		String name = son.name;
		System.out.println("이름:"+name);
		String sex = son.sex;
		int old = son.old;
		System.out.println("나이"+old);
		String position = son.position;
		System.out.println("포지션: "+position);
		double height = son.height;
		System.out.println(height);
		
		
		
//		System.out.println("name: "+son.name);
//		System.out.println("sex: "+son.sex);
//		System.out.println("job: "+son.job);
//		System.out.println("old: "+son.old);
//		System.out.println("height: "+son.height);
//		System.out.println("nation: "+son.nation);
		
		//필드값 변경 문법> 참조변수명 +
		//필드값 변경 왜하는거야
		son.height = 184.9;
		System.out.println("변경 후 키:"+son.height);
//		
//		// 메서드 호출
//		//참조변수명.메서드명()
		son.move();
		
	}
}
