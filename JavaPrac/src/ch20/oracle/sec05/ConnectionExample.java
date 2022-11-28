package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

	public static void main(String[] args) {
		//Connection conn = null;
		
//		try {
//			//JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			
//			//DB와 연결
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "qwe3776");
//			System.out.println("연결 성공");
//			
//			
//			//DB작업
//			//~~
//			
//			
//			//DB 연결 끊기
//			
//			
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(conn != null) {
//				//null 일 경우 = 
//				// 연결이 안되면 예외 발생 => null 인 상태 유지 => close 할 필요없음.
//				
//			
//			//DB 연결 끊기
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			System.out.println("연결 끊김");
//		}
//	}
		
		
		
		
		// Auto 기능 써서 만든거
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "qwe3776")){
				System.out.println("연결 성공");
			
			
		//DB작업
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			System.out.println("연결 끊김");

		//DB작업
				
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
}
}
