package dbPackages.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




//DB연결을 위한 클래스이다
//JDBC Driver등록,Connection제공,자원반납 기능 제공
public class JdbcUtil {
	
	//field
	static String url ="jdbc:oracle:thin:@127.0.0.1:1521/xe";
	static String user="scott";
	static String password="tiger";
	
	
	//constructor
	
	//method
	//1.JDBC Driver등록 & 2.연결 Connection얻기
	//Connection제공
	public static Connection getConnection() {
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("1.JDBC Driver등록-성공");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException발생 e="+e);
			e.printStackTrace();
		}
		
		//2.연결 Connection얻기
		//DriverManager.getConnection(연결DB서버url, 접속user명, 비밀번호)
		try {
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("2.Connection얻기-성공");
		} catch (SQLException e) {
			System.out.println("SQLException발생");
			e.printStackTrace();
		}
		return conn;
	}
	

	//DriverManager.getConnection(연결DB서버url, 접속user명, 비밀번호)


	/*
	 * //5.자원반납 try { if(conn!=null) { conn.close(); } } catch (SQLException e) {
	 * e.printStackTrace(); } System.out.println("5.자원반납완료");
	 * 
	 */
}






