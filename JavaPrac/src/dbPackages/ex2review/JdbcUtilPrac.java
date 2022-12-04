package dbPackages.ex2review;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtilPrac {

		//field
	static String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
	static String user = "scott";
	static String password = "tirger";
	
	
	//constructor
	//method
	//connection
	
	public static Connection getConnection() {
		Connection conn = null;
		ResultSet rs = null;
		
		//왜 try catch 문을 쓰는거지 ?
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("JDBC 드라이버 등록 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
		// return conn;의 역할은 뭐지 ?
	}
	

	public static void close(ResultSet rs) {
	try {
		if(rs!=null) {rs.close();}
		} catch (SQLException e) {
			e.printStackTrace();
	}
	}
	//자원반납 - Statement 객체 또는 PreparedStatement 객체
	public static void close(Statement stmt) {
		try {
			if(stmt!= null) {stmt.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close (Connection conn) {
		try {
			if(conn!=null) {conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection해제");
	}
}
