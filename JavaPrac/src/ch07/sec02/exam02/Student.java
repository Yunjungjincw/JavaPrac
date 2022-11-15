package ch07.sec02.exam02;

public class Student extends People {
	public int studenNo;
	
	public Student(String name, String ssn, int studentNo) {
		super(name, ssn);
		this.studenNo = studentNo;
	}
}
