package dbPackages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//scott.emp 에 update를 실행하는 클래스
public class DbConnectionTest2 {
	public static void main(String[]args) throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement stmt = null;
		//1.JDBC Driver 등록하기 / 로딩
		 try {
			//try catch문 설정함
			Class.forName("oracle.jdbc.OracleDriver"); // 드라이버 찾아라.
		 }catch (ClassNotFoundException e) {		// 못찾으면 콘솔에 출력해줘
			System.out.println("ClassNotFoundception발생"+e);
		}finally {
			System.out.println("1.JDBC 드라이버 성공 성공"); // 잘찾았구나
		}
		
		 
		
		//2.연결 Connection 얻기
		try {
		 conn = DriverManager.getConnection(url, user, password);	// 위 정보를 바탕으로
		}catch (SQLException e){		//문제있니?
			System.out.println("SQLException 에러발생");
			e.printStackTrace();
		}finally {
			System.out.println("2.connection 성공");	//문제없어
		}
		//3.객체준비-Statement객체,PreparedStatement 객체
	try {
		String sql = "UPDATE emp"
				+" SET job=?,sal=?,deptno=?"
				+" WHERE empno=?"; 
			stmt = conn.prepareStatement(sql);
			System.out.println("3.prepareStatement 객체 생성");
	
	
			String sql1 = "UPDATE emp"
					+" SET job=?,sal=?,deptno=?"
					+" WHERE empno=?"; 
		
		
		//4.쿼리실행 set 데이터타입(?의 순서, 값)

			stmt = conn.prepareStatement(sql1);
			stmt.setString(1, "개잡부");
			stmt.setInt(2, 7000);
			stmt.setInt(3, 93);
			stmt.setInt(4, 9998);
			stmt.executeUpdate();
			int resultCnt = stmt.executeUpdate();
			System.out.println("row 수: "+resultCnt);
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		//5.자원반납
		//주소지가 있을 경우에만 close 해라.
		try {	//자원반납이 뭐지
			if(stmt !=null) {
				stmt.close();
			}
			
			if(conn!=null)
				conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("5.자원반납완료");
	}
}


