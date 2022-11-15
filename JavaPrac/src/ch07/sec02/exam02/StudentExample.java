package ch07.sec02.exam02;

public class StudentExample {

	public static void main(String[] args) {
		//객체 생성했음. 매개변수로 name , ssn, No받음.
		//똑같이 여기서도 자식클래스를 객체로 생성함. => 자동으로 부모 객체 생성되었고, 
		Student student = new Student("홍길동", "123456-1234567", 1);
		
		//아래 super를 사용해서 부모클래스로 기본생성자를 만들어줬기 때문에, 
		// 아래와 같이 호출하는게 가능함. 생성안해주면 오류뜸.
		System.out.println("이름:  "+student.name);
		System.out.println("주민번호: "+student.ssn);
		System.out.println("학생번호: "+student.studenNo);
	}

}
