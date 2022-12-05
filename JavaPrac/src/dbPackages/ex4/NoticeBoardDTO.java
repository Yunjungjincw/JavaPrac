package dbPackages.ex4;

import java.util.Date;

/*
 * DTO data transfer object
 * --순수하게 데이터를 담아 계층 간으로 전달하는 객체
 * 로직을 갖고 있지 않은  순수한 데이터 객체이며 메서드로는 getter setter만을 갖는다
 * 여기서 getter / setter 이외에 다른 로직이 필요없는 이유를 좀 더 자세히 살펴보자면, 
 * 만약 DTO 가 데이터 전달만을 위한 객체라고 한다면
 * 완전히 데이터 전달 용도로만 사용하기 때문에 
 * getter / setter 로직만이 필요하지 다른 로직이 필요하지 않은 것.
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
}

