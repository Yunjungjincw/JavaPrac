package dbPackages.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB 연결을 위한 클래스 .
public class DbConnectionTest {
	public static void main(String[]args) throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		
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
		

		//4.쿼리실행
		
		
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
