package dbPackages.ex2review;

import java.sql.Connection;
import java.sql.ResultSet;

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
	
}
