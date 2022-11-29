package ch20.oracle.sec06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SequencePrac {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			//JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//DB와 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "scott", "tiger");
			System.out.println("연결 성공");
			
			
			//DB작업 매개변수화 된  insert 문
			String sql = 
					" insert into emp(empno, ename, job, hiredate, sal, comm)"
					+ " values (emp_empno_seq.nextval,?,?, sysdate, ?,?);";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"empno"});
			
			pstmt.setString(1, "손흥민");
			pstmt.setString(2, "개발");
			pstmt.setInt(3, 5000);
			pstmt.setInt(4, 3000);
		
		
			
			//반영된 행의 수를 리턴한다.
			int rows = pstmt.executeUpdate();
			if(rows ==1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				
				if(rs.next()) {
					int empno = rs.getInt(1);
					System.out.println("저장된 bno :"+ empno);
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
