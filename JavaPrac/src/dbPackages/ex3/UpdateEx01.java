package dbPackages.ex3; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//scott.emp에 update를 실행하는 클래스이다
public class UpdateEx01 {

	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String user="scott";
		String password="tiger";
		Connection conn=null;
		PreparedStatement stmt = null;
		
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
		
		//3.객체준비-Statement객체,PreparedStatement객체
		try {
			String sql = "UPDATE emp " + 
				"SET job=?,sal=?,deptno=? " + 
				"WHERE empno=?";
			stmt = conn.prepareStatement(sql);
			System.out.println("3.PreparedStatement객체 생성");
		
			//4.쿼리실행 set데이터타입(?의순서, 값)
			stmt.setString(1, "개발");
			stmt.setInt(2, 5000);
			stmt.setInt(3, 97);
			stmt.setInt(4, 9003);
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
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("5.자원반납완료");
	}

}




