package dbPackages.ex5;

import java.util.Date;

/*
 * DTO data transfer object
 * --순수하게 데이터를 담아 계층 간으로 전달하는 객체
 * 로직을 갖고 있지 않은  순수한 데이터 객체이며 메서드로는 getter setter만을 갖는다
 * 여기서 getter / setter 이외에 다른 로직이 필요없는 이유를 좀 더 자세히 살펴보자면, 
 * DTO는 데이터 전달만을 위한 객체라고 한다
 * 완전히 데이터 전달 용도로만 사용하기 때문에 
 * 
 * 
 * ***********************************************
 * getter / setter 로직만이 필요하지 다른 로직이 필요하지 않은 것.
 * ***********************************************
 * 
// * # VO클래스

- DAO 클래스를 구현하면 데이터베이스에 연결할 때, 
데이터베이스 안에 있는 테이블의 속성을 가져오거나 , 
넣어주게 됨(select = executeQuery  //////   insert, update ,delete  =  executeUpdate)
- 그래서 항상 데이터 베이스 안에 있는 테이블의 컬럼과 같은 값을 갖는 자바빈 클래스를 만드는데, 
이게바로 VO 클래스
- VO 클래스 (Value Object) / DTO 클래스 (Data Transfer Object)라고 부름
- DAO 클래스를 이용하여 데이터베이스에서 데이터를 관리할 때 데이터를 일반적인 변수에 할당하여 작업할수도 있지만, 
별도의 VO 클래스를 작성하여 데이터베이스와 관련된 변수들의 모음 역할을 함.
- VO 클래스의 변수들은 외부에서 쉽게 접근할 수 없도록 은닉(private)처리 함
 */


// 이 클래스는 DB의 noticeBoard 테이블의 데이터를 저장, 
// 제공하는 역할을 하는 DTO
public class NoticeBoardDTO {
	//field
	//[접근제한자][제어자] 데이터타입 필드명[=초기값];
	// 초기값을  생략하면 데이터타입별로 자동초기화된다.
	// (정수 0 , 실수 0.0, boolean:false char:공백  배열,class null
	
	private int nbno;	//글번호
	private String title;	//제목
	private String contant;	//내용
	private Date cre_date;	//작성일
	private String writer;	//작성자
	private int rcnt;	//조회수
	private int empno;	//사원번호(여기에서는 공지사항 게시판을 관리하는 사원번호
	
	
	//constructor
	//기본생성자
	//외부에서 클래스명 참조변수 = new 클래스명(int 글번호);
	//NoticeBoardDTO 참조변수 = new NoticeBoardDTO();
	public NoticeBoardDTO(){
	}
	//외부에서 클래스명 참조변수 = new 클래스명(int 글번호);
	//외부에서 NoticeBoardDTO수 = new NoticeBoardDTO(int 글번호);
	public NoticeBoardDTO(int nbno){
		this.nbno = nbno;
	}//기본생성자

	//파라미터 7개 생성자
	//외부에서 클래스명 참조변수  =new NoticeBoardDTO(글번호,~,~,~,~,~,사번){}
	public NoticeBoardDTO(int nbno, String title, String contant, Date cre_date,String writer, int rcnt, int empno) {
		super();
		this.nbno = nbno;
		this.title = title;
		this.contant = contant;
		this.cre_date = cre_date;
		this.writer = writer;
		this.rcnt = rcnt;
		this.empno = empno;
		
		
	}


	
	//method
//	[접근제한자][제어자] 리턴유형 메서드명{매개변수) {}
	
	
	//object 로 부터 상속받은 toString()은
	//객체의 정보를 sTring 형태로 제공하는 메소드였다
//	하지만 이 클래스에서는 
	//setter
	public void setNbno(int nbno) {
		this.nbno=nbno;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContant(String contant) {
		this.contant = contant;
	}
	public void setCre_date(Date cre_date) {
		this.cre_date = cre_date;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}

	
	
	
	//getter
	
	public int getNbno() {
		return nbno;
	}
	public String getTitle() {
		return title;
	}
	public String getContant() {
		return contant;
	}

	public Date getCre_date() {
		return cre_date;
	}


	public String getWriter() {
		return writer;
	}



	public int getRcnt() {
		return rcnt;
	}



	public int getEmpno() {
		return empno;
	}

	
	// 오버라이드
	// Object로 부터 상속받은 toString()은
	//	객체의 정보를 String 형태로 제공하는 메소드
	//	하지만 이 클래에에서는 
	//	필드의 값을 String 형태로 제공하는 메소드로 재정의
	
	@Override
	public String toString() {
		return "NoticeBoardDTO 유저번호: " + nbno + ", 제목: " + title + ", 내용: " + contant + ", 작성날짜: " + cre_date
				+ ", 작성자: " + writer + ", rcnt: " + rcnt + ", empno: " + empno + "]";
	}
	
	
	
	
}

