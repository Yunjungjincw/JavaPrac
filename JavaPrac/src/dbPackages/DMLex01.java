//package dbPackages;
//
//import java.sql.Statement;
//import java.util.Date;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
////sott.emp에 DML 작업 
//public class DMLex01 {
//	String url = "jdbc:oracle:thin:@localhost:1521/xe";
//	String user = "scott";
//	String password = "tiger";
//	static Connection conn=null;
//	//static Statement stmt = null;
//	static PreparedStatement stmt=null;
//			//생성자
//	public DMLex01() {}  //매개변수 없는 기본 생성자
//	
//			//메서드
//	
//	//1.JDBC Driver 등록   & 2.연결 커넥트  얻기
//	public Connection dbConnection() {
//
//		//1.JDBC Driver등록
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("ClassNotFoundException발생 e="+e);
//			e.printStackTrace();
//		}
//		System.out.println("1.JDBC Driver등록-성공");
//		
//		//2.연결 Connection얻기
//		try {
//			conn=DriverManager.getConnection(url, user, password);
//		} catch (SQLException e) {
//			System.out.println("SQLException발생");
//			e.printStackTrace();
//		}
//		System.out.println("2.Connection얻기-성공");
//		return conn;
//	}
//	
//	public static void main(String[] args) {
//		
//		//객체생성
//		DMLex01 obj = new DMLex01 ();
//		obj.dbConnection();
//		//1.JDBC Driver 등록
////		dbConnection();
//		
//	
//		//3. 객체 준비 . PreparedStatament 4. 쿼리실행
//		System.out.println();
//		System.out.println("---아래는 사원입사---");
//		
//		System.out.println();
//		
//		obj.insertEmp(9875,"왜이래","개잡부",7000,1500);//사원입사
//		System.out.println("---아래는 사원목록 조회---");
//		//사원목록조회
//		//사원정보수정
//		//특정사원조회
//		System.out.println();
//		System.out.println("===아래는 사원삭제===");
//		obj.deleteEmp(9998); //TK
//		//삭제
//		
//		
//	
//		
//		
//		//사원목록조회
//		public void selectEmpList() {
//			System.out.println("selectEmpList");
//			ResultSet rs = null;
//		
//			try {
//				String sql = 
//					"SELECT empno,ename,job,hiredate,sal"+
//					" FROM EMP";
//
//				stmt =conn.prepareStatement(sql);
//				System.out.println("3.PreparedStatement객체 생성");
//				
//				
//				ResultSet rs = stmt.executeQuery();
//				System.out.print("4.쿼리문결과 : ");
//				
//				
//				
//				while(rs.next()) {    
//			
//					int eno = rs.getInt("empno");
//					String eName= rs.getString("ename");
//					String job = rs.getString("job");
//					Date hdate= rs.getDate("hiredate");
//					double salary =rs.getDouble("sal");
//					
//					System.out.printf("%d/%s,%s는\r",eno,eName,job);
//					System.out.print("                  ");
//					
//					System.out.print(salary+"");
//					System.out.print(hdate+"");
//					
//					
//					System.out.println();
//				}
//				if( rs.next() ) {  
//					System.out.println("select결과가 있어요");
//				}else {
//					System.out.println("select결과가 없네요");
//				}
//				
//			} catch (SQLException e1) {
//				System.out.println("executeUpdate()실행관련 에러");
//				e1.printStackTrace();
//			}
//			
//
//			try {
//				if(rs!=null) {	
//					rs.close();
//				}
//				
//				if(stmt!=null) {
//					stmt.close();
//				}
//				
//				if(conn!=null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		//5.자원반납
//		obj.close(stmt);
//		obj.close(conn);
//		
//		//
//		
//	}//main
//	
//	//자원반납
//	//다형성 적용시켜보기
//	//상위클래스명 참조변수 = new 하위클래스명();
//	//인터페이스명 참조변수 = new 구현 클래스명 ();
//	// 메소드 => 오버로딩 => 재정의 (순서 타입 개수를 다르게 할 경우 적용 가능
//	// 리턴 값이 달라도 순서 타입 개수가 같을 경우는 적용 X
//
//	public void close(Connection conn) {
//		System.out.println();
//		try {
//		
//			if(conn!=null)
//				conn.close();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println("5.자원반납완료");
//	}//close()끝
//	public void close(Object stmt) {
//		System.out.println();
//		try {
//			if(stmt!=null) {
//				if(stmt instanceof Statement) {
//					((Statement)stmt).close();
//				}
//				if(stmt instanceof PreparedStatement) {
//					((PreparedStatement)stmt).close();
//				}
//			}
//			if(conn!=null)
//				conn.close();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println("5.자원반납완료");
//	}
//	//입력
//	public void insertEmp(int empNo, String name, String job, int pay, int commition) {
//		System.out.printf("insertEmp()진입 empNo:%d, name:%s, job:%s, pay:%d, commition:%d\r",empNo,name,job,pay,commition);
//				String sql = 
//						"INSERT INTO EMP(empno,ename,job,hiredate,sal,comm)"
//						+" VALUES(?,?,?,SYSDATE,?,?)";
//				
//				try {
//					stmt.setInt(1, empNo);
//					stmt.setString(2, name);
//					stmt.setString(3, job);
//					stmt.setInt(4, pay);
//					stmt.setInt(5, commition);
//
//					int resultCnt = stmt.executeUpdate();
//					System.out.println("쿼리문 실행결과로 받은 record 수="+resultCnt);
//				} catch (SQLException e2) {
//					System.out.println("쿼리 실행 관련 오류"+e2);
//					e2.getStackTrace();
//				}finally {
//					System.out.println("4.쿼리실행 완료");
//				}
//				
//				
//				try {
//					if(stmt!=null) {
//						stmt.close();
//					}
//				}catch (SQLException e) {
//					e.printStackTrace();
//				}
//				System.out.println("5.자원반납완료");
//			}
//		
//	
//	
//	//수정
//	//public  void updateEmp() {}
//
//	//삭제
//	public void deleteEmp(int empNo) {
//		System.out.println("deleteEmp()진입 	empNo="+empNo);
//		
//		String sql ="DELETE FROM EMP"
//				+" where empno=?";
//		try {
//			stmt = conn.prepareStatement(sql);
//			
//		}catch(SQLException e1) {
//			e1.printStackTrace();
//		}finally {
//			System.out.println("3.일단 성공");
//		}
//		
//
//		
//	try {
//			stmt.setInt(1, 9998);
//			
//			
//			int resultCnt = stmt.executeUpdate();
//			System.out.println("쿼리문 실행결과로 받은 record 수="+resultCnt);
//		} catch (SQLException e2) {
//			System.out.println("쿼리 실행 관련 오류"+e2);
//			e2.getStackTrace();
//		}finally {
//			System.out.println("4.쿼리실행 완료");
//		}
//	}
//
//	//사원목록조회
//	//	public static void selectEmpList() {}
//	
//	//특정사원조회
//	//	public static void selectEmp() {}
//
//
//}
