package dbPackages.ex3; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB연결을 위한 클래스이다
public class DBConnectionTest {

	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String user="scott";
		String password="tiger";
		Connection conn=null;
		
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
		
		//4.쿼리실행
		
		//5.자원반납
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("5.자원반납완료");
	}

}




