package dbPackages.ex3; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//scott의 emp테이블에 데이터삭제 작업을 위한 클래스이다
//PreparedStatement객체를 이용한 delete문 실행 
public class DeleteEx {

	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String user="scott";
		String password="tiger";
		Connection conn=null;
		//Statement  stmt=null;
		PreparedStatement stmt=null;
		
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
		
		//3.객체준비-PreparedStatement객체
		//An object that represents a precompiled SQL statement. 
		String sql = 
				"DELETE FROM emp " + 
				"WHERE empno=?";

		try {
			//stmt = conn.createStatement();
			stmt =conn.prepareStatement(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		//4.쿼리실행
		//query문에 ;미포함, 작은따옴표,공백,괄호 등등 주의=> 실행가능한 쿼리문!			
		//executeUpdate() 메소드를 호출하면 
		//주어진 SQL문(insert,update,delete)이 실행. 실행된 레코드수가 리턴된다
		//executeQuery(select문) : select쿼리문실행. 실행결과를 ResultSet리턴
		try {
			//int resultCnt = stmt.executeUpdate(sql);
			
			//PreparedStatement객체를 
			//실행하기전에(executeUpdate() 혹은 executeQuery() )
			//?개수만큼 set설정해야한다
			//set데이터타입(?순서,값)
			stmt.setInt(1, 9004);
			int resultCnt = stmt.executeUpdate();
			System.out.println("쿼리문실행결과로 받은 record수="+resultCnt);
		} catch (SQLException e1) {
			System.out.println("executeUpdate()실행관련 에러");
			e1.printStackTrace();
		}
		
		
		
		//5.자원반납
		try {
			if(stmt!=null) {
				stmt.close();
			}
			
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("5.자원반납완료");
	}

}




