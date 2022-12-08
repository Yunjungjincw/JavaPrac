package dbPackages.listPrac;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//DB연결을 위한 클래스이다
//JDBC Driver등록,Connection제공,자원반납 기능 제공
public class JdbcUtil {
	
	//field
	static String url ="jdbc:oracle:thin:@127.0.0.1:1521/xe";
	static String user="scott";
	static String password="tiger";
	
	
	//constructor
	
	//method
	//Connection제공
	public static Connection getConnection() {
		Connection conn=null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("1.JDBC Driver등록-성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//DriverManager.getConnection(연결DB서버url, 접속user명, 비밀번호)
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("2.Connection얻기-성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	
	public static void close(ResultSet rs) {
		try { 
			 if(rs!=null) {rs.close();} 
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	}
	
	
	//자원반납-Statement객체 또는 PreparedStatement객체
	public static void close(Statement stmt) {
		 try { 
			 if(stmt!=null) {stmt.close();} 
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	}
	
	//접속종료
	public static void close(Connection conn) {
		 try {
			 if(conn!=null) {conn.close();}
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 System.out.println("Connection해제");
	}

}