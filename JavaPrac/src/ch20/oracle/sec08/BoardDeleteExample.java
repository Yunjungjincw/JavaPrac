package ch20.oracle.sec08;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDeleteExample {

	public static void main(String[] args) { 
		Connection conn = null;
		
		try {
			//JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//DB와 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "qwe3776");
			System.out.println("연결 성공");
			
			
			//DB작업 매개변수화 된  insert 문
			String sql = "delete from boards "
					+ " where bwriter=?";
					// toString이 문자열을 리턴해주니까 String sql에 넣을 수 있음.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "fall");
			//filenot exception 때문에 exception 만 잡아줌
		
			//반영된 행의 수를 리턴한다.
			int rows = pstmt.executeUpdate();
			System.out.println("삭제된 행 수: "+rows);
			// executeUpdate() => 실행하는 코드
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				//null 일 경우 = 
				// 연결이 안되면 예외 발생 => null 인 상태 유지 => close 할 필요없음.
				
			
			//DB 연결 끊기
			try {
				conn.close();
			} catch (SQLException e) {
			}
			System.out.println("연결 끊김");
		}
	}

	}

}
