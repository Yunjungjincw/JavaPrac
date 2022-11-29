package ch20.oracle.sec06;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardWithFileInsertExample {

	public static void main(String[] args) { 
		Connection conn = null;
		
		try {
			//JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//DB와 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "qwe3776");
			System.out.println("연결 성공");
			
			
			//DB작업 매개변수화 된  insert 문
			String sql = 
					"insert into boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata) "
					+ " values (seq_bno.nextval, ?, ?, ?, sysdate, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno","btitle"});
			
			pstmt.setString(1, "눈 오는 날8");
			pstmt.setString(2, "함박눈이 내려요.");
			pstmt.setString(3, "winter");
			pstmt.setString(4, null);
			pstmt.setBlob(5, new FileInputStream("src/ch20/oracle/sec05/1.png"));
			//filenot exception 때문에 exception 만 잡아줌
		
			
			//반영된 행의 수를 리턴한다.
			int rows = pstmt.executeUpdate();
			if(rows ==1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				
				if(rs.next()) {
					int bno = rs.getInt(1);
					System.out.println("저장된 bno :"+ bno);
					
					String btitle = rs.getString(2);
					System.out.println("저장된 btitle: "+btitle);
				}
				rs.close();
			}
			System.out.println("저장된 행수 : "+rows);
			
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
				e.printStackTrace();
			}
			System.out.println("연결 끊김");
		}
	}

	}

}
