package dbPackages.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//scott의 emp 테이블에 데이터 입력 작업을 위한 클래스
// PreparedStatement 객체를 이용한 insert문 실행
public class Delete {
	public static void main(String[]args) throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement pstmt =null;
		// 참조변수로 사용하기 위해 = null 
		
		//1.JDBC Driver 등록하기
		 try {
			//try catch문 설정함
			Class.forName("oracle.jdbc.OracleDriver");
		 }catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundception발생"+e);
		}finally {
			System.out.println("1.JDBC 드라이버 성공 성공");
		}
		
		//2.연결 Connection 얻기
		try {
		 conn = DriverManager.getConnection(url, user, password);
		}catch (SQLException e){
			System.out.println("SQLException 에러발생");
			e.printStackTrace();
		}finally {
			System.out.println("2.connection 성공");
		}
		//3.객체준비-Statement객체,PreparedStatement 객체
		//QUERY문에 ; 미포함 , 작은따옴표, 공백, 괄호 등등 주의 => 실행가능한 쿼리문!(문법적으로 완벽해야 함.)
		String sql ="DELETE FROM EMPwhere empno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			//An object that represents a precompiled SQL statement. 
		}catch(SQLException e1) {
			e1.printStackTrace();
		}finally {
			System.out.println("3.일단 성공");
		}
		

		//4.쿼리실행
		//executeUpdate() 메소드를 호출하면
		// 주어진 SQL문 (insert , update, delete)이 실행 , 실행된 레코드수가 리턴
		//executeQuery(select문) : select쿼리문 실행. 실행 결과를 ResultSet
		try {
			//   PreparedStatement 객체를 실행하기전에 
			//   executeUpdate() 혹은 executeQuery를 
			//   ? 개수만큼 set 설정해야한다.
			pstmt.setInt(1, 9999);
			
			
			int resultCnt = pstmt.executeUpdate();
			System.out.println("쿼리문 실행결과로 받은 record 수="+resultCnt);
		} catch (SQLException e2) {
			System.out.println("쿼리 실행 관련 오류"+e2);
			e2.getStackTrace();
		}finally {
			System.out.println("4.쿼리실행 완료");
		}
		
		
		//5.자원반납
		//주소지가 있을 경우에만 close 해라.
		try {
			if(conn!=null)
				conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("5.자원반납완료");
	}
}
