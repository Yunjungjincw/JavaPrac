package dbPackages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;





//scott.emp에 DML작업
//DML중에서는 시퀀스를 사용한 INSERT연습
public class DbmsPrac {
	//필드
	String url ="jdbc:oracle:thin:@127.0.0.1:1521/xe";
	String user="scott";
	String password="tiger";
	Connection conn=null;
	//Statement  stmt=null;
	PreparedStatement stmt=null;
	
	//생성자 
	public DbmsPrac(){} //기본생성자-매개변수가 없는 생성자
	
	//메서드
	
	//1.JDBC Driver등록 &	2.연결 Connection얻기
	public void dbConnection() {
		//1.JDBC Driver등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException발생 e="+e);
			e.printStackTrace();
		}
		System.out.println("1.JDBC Driver등록-성공");
		
		//2.연결 Connection얻기
		//DriverManager.getConnection(연결DB서버url, 접속user명, 비밀번호)
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("SQLException발생");
			e.printStackTrace();
		}
		System.out.println("2.Connection얻기-성공");
		
	}
	
	
	public static void main(String[] args) {

		
		//객체생성
		DbmsPrac obj=new DbmsPrac();
		
		//1.JDBC Driver등록&	2.연결 Connection얻기
		obj.dbConnection();
		
		//3.객체준비 & 4.쿼리실행
		//사원목록조회->사원입사->사원목록조회->사원삭제->사원목록조회
		
		System.out.println("--아래는 입사전 사원목록조회----------------------");
		obj.selectEmpList();//사원목록조회
		
		System.out.println();//빈줄
//		System.out.println("--아래는 사원입사----");
		obj.insertEmp("이강인","개발",4800,1500);//사원입사
		
		System.out.println();//빈줄
//		System.out.println("--아래는 사원목록조회----------------------");
		obj.selectEmpList();//사원목록조회
		System.out.println("--아래는 사원 정보 변경----------------------");
		obj.updateEmp(9000);
		System.out.println("--아래는 특정사원조회----------------------");
		obj.selectEmp(100);//특정사원조회
		
		System.out.println();//빈줄
//		System.out.println("--아래는 사원삭제----");
		obj.deleteEmp(9012);// 사번이 9012인 사원삭제
		
		System.out.println();//빈줄
//		System.out.println("--아래는 사원목록조회----------------------");		
		obj.selectEmpList();//사원목록조회
		

	}//main
	//수정
	public void updateEmp(int empno) {
		//3.객체준비-Statement객체,PreparedStatement객체
		try {
			String sql = "UPDATE emp " + 
				"SET sal=sal*5 " + 
				"WHERE empno=?";
			stmt = conn.prepareStatement(sql);
			System.out.println("3.PreparedStatement객체 생성");
		
			//4.쿼리실행 set데이터타입(?의순서, 값)
			stmt.setInt(1, empno);
			int resultCnt = stmt.executeUpdate();
			System.out.println("4.쿼리실행결과 리턴받은 row수="+resultCnt);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		//5.자원반납
		try {
			if(stmt!=null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("5.사원수정 자원반납완료");
	}//updateEmp()끝
	//특정사원조회-- 메서드호출시 조회하고자 하는 사원번호를 받아서 매개변수 empno에 저장
		public void selectEmp(int empno) {
				System.out.println("selectEmp()진입 empno="+empno);
				
				ResultSet rs = null;
				//select로 나온 결과값을 나타내주는 거 = 
				String sql = "SELECT e.EMPNO,e.ENAME,e.job,e.sal,nvl(e.comm,1230) as bonus, d.dname "
							+ " FROM   EMP e join dept d on e.deptno=d.deptno"
							+ " where e.empno=?";
				//3.객체준비-PreparedStatement객체
				try {
					stmt =conn.prepareStatement(sql);
					System.out.println("3.PreparedStatement객체 생성");
					
					//4.쿼리실행
							
					stmt.setInt(1,empno); //?설정
					rs = stmt.executeQuery();
					System.out.println("4.쿼리문실행결과 : ");

					if( rs.next() ) { //rs.next()는 다음행(new row)있으면 true리턴
						int eno=rs.getInt("empno");//empno컬럼의 값을 자바에서 int로 처리
						String eName=rs.getString("ename");//job컬럼값 가져오기
						String job=rs.getString("job");//ename컬럼값 가져오기
//						Date hireDate=rs.getDate("hiredate");//hiredate컬럼값 가져오기
//						String strHireDate = rs.getString("hiredate");
						double salary=rs.getDouble("sal");//sal컬럼값 가져오기
						double bonus = rs.getDouble("bonus");//bonus 값 가져오기
						String dname = rs.getString("dname");//dname 값 가져오기
						
						System.out.printf("%10d%10s, %10s는 ", eno, eName, job);
//						System.out.print(hireDate);
//						System.out.print(strHireDate);
						System.out.print(salary);
						System.out.println(bonus);
						System.out.println(dname);
						System.out.println();//줄바꿈
					} else { //조회한 사번의 사원이 존재하지 않을 경우
						System.out.println("조회한 사번("+ empno+")사원이 존재하지 않아요");
					}
					
					
				} catch (SQLException e1) {
					System.out.println("executeUpdate()실행관련 에러");
					e1.printStackTrace();
				}
				
				//5.자원반납
				try {
					if(rs!=null) {	
						rs.close();
					}
					
					if(stmt!=null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("5.selectEmpList-자원반납완료");
		}// selectEmp()끝
	
	//자원반납
	//다형성 적용시켜보기
	//상위클래스명 참조변수=new 하위클래스명();
	//인터페이스명 참조변수=new 구현클래스명();
	//자원해제-Statement,PreparedStatement 
	public void close(Object stmt) {
		try {
			if(stmt!=null) {
				if(stmt  instanceof Statement) {
					((Statement)stmt).close();
				}
				
				if(stmt  instanceof PreparedStatement) {
					((PreparedStatement)stmt).close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("5.자원반납완료");
	}//close()끝
	
	//Connection자원해제
	public void close(Connection conn) {
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("5.자원반납완료");
	}//close()끝
	
	
	//입력
	public void insertEmp(String name,String job,int pay,int commission) {
		System.out.printf("insertEmp()진입 empNo: name:%s, job:%s, pay:%d, 커미션:%d\r",name,job,pay,commission);
		String sql = 
				"INSERT INTO emp(empno,ename,job,hiredate,sal,comm) "+
                "VALUES(EMP_EMPNO_SEQ.NEXTVAL,?,?,SYSDATE,?,?)";

		try {
			stmt =conn.prepareStatement(sql);
	
			stmt.setString(1,name);
			stmt.setString(2,job);
			stmt.setInt(3, pay);
			stmt.setInt(4, commission);
			int resultCnt = stmt.executeUpdate();
			System.out.println("4.쿼리문실행결과로 받은 record수="+resultCnt);
		} catch (SQLException e1) {
			System.out.println("executeUpdate()실행관련 에러");
			e1.printStackTrace();
		}
		
		try {
			if(stmt!=null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("5.insertEmp()의 stmt자원반납");
	}//insertEmp()끝
	
	//수정
	//public void updateEmp(매개변수) {}
	//삭제
	public void deleteEmp(int empno) { 
		System.out.println("deleteEmp()진입 empno="+empno); 
		
		//3.객체준비-PreparedStatement객체
		String sql = 
				"DELETE FROM emp " + 
				"WHERE empno=?";

		try {
			stmt =conn.prepareStatement(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println("3.PreparedStatement객체받기");
		
		//4.쿼리실행
		try {
			stmt.setInt(1,empno);
			int resultCnt = stmt.executeUpdate();
			System.out.println("4.쿼리문실행결과로 받은 record수="+resultCnt);
		} catch (SQLException e1) {
			System.out.println("executeUpdate()실행관련 에러");
			e1.printStackTrace();
		}
		
		//5.자원해제
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("5.deleteEmp()의 stmt자원반납");
	}//deleteEmp()끝
	
	
	
	
	
	
	//사원목록조회
	public void selectEmpList() {
		System.out.println("selectEmpList()진입");
		
		ResultSet rs = null;
		String sql = "SELECT empno,ename,job,hiredate,sal"+
					 " FROM EMP";
		//3.객체준비-PreparedStatement객체
		try {
			stmt =conn.prepareStatement(sql);
			System.out.println("3.PreparedStatement객체 생성");
			
			//4.쿼리실행
			rs = stmt.executeQuery();
			System.out.println("4.쿼리문실행결과 : ");

			while( rs.next() ) { //rs.next()는 다음행(new row)있으면 true리턴
				int eno=rs.getInt("empno");//empno컬럼의 값을 자바에서 int로 처리
				String eName=rs.getString("ename");//job컬럼값 가져오기
				String job=rs.getString("job");//ename컬럼값 가져오기
				Date hireDate=rs.getDate("hiredate");//hiredate컬럼값 가져오기
				String strHireDate = rs.getString("hiredate");
				double salary=rs.getDouble("sal");//sal컬럼값 가져오기
				
				System.out.printf("%10d%10s, %10s는 ", eno, eName, job);
				System.out.print(hireDate);
				System.out.print(strHireDate);
				System.out.print(salary);
				System.out.println();//줄바꿈
			}
			
			
		} catch (SQLException e1) {
			System.out.println("executeUpdate()실행관련 에러");
			e1.printStackTrace();
		}
		
		//5.자원반납
		try {
			if(rs!=null) {	
				rs.close();
			}
			
			if(stmt!=null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("5.selectEmpList-자원반납완료");
	}//selectEmpList()끝
	
	//특정사원조회
	//public void selectEmp(매개변수) {}
	
	
}


