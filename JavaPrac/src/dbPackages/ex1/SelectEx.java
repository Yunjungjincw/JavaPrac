package dbPackages.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

//scott.emp 에 update를 실행하는 클래스
public class SelectEx {
	public static void main(String[]args) throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;	//select 쿼리문의 실행결과집합을 저장하기위한 변수선언 및 초기화
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
		String sql = 
				"select empno,ename, job,hiredate,sal "
				+ " from emp "
				+ " where empno = ?"; 
			stmt = conn.prepareStatement(sql);
			System.out.println("3.prepareStatement 객체 생성");
	
	

		
		
		//4.쿼리실행 set 데이터타입(?의 순서, 값)
			// executeUpdate
			// executeQuery
			
			stmt.setInt(1, 9998);
			
			
			rs = stmt.executeQuery();
			System.out.println("4.쿼리문실행결과 : ");

			while(rs.next()) {    //rs.next()는 다음행 (new row)있으면 true리턴
				//rs.get데이터타입(select컬럼순서) 첫번째 컬럼은 1, 두번째컬럼은 2
				//rs.getI 데이터타입 ("컬럼명 또는 컬럼별칭")
				int eno = rs.getInt("empno");
				String eName= rs.getString("ename");
				String job = rs.getString("job");
				Date hdate= rs.getDate("hiredate");
				String strHireDate = rs.getString("hiredate");
				double salary =rs.getDouble("sal");
				
				System.out.println(eno);
				System.out.println(eName);
				System.out.println(job);
				System.out.println(salary);
				System.out.println(hdate);
				System.out.println(strHireDate);
			}
			
			
//			
			if(rs.next()) {		//rs.next()는 다음행 (new row)있으면 true리턴
				System.out.println("select 결과가 있어요 ");
			} else {
				System.out.println("select 결과가 없네요 ");
			}
			
			
		}catch(SQLException e1) {
			System.out.println("executeUpdate()실행관련 에러");
			e1.printStackTrace();
		}
		//5.자원반납
		//주소지가 있을 경우에만 close 해라.
		try {	//자원반납이 뭐지
			if(rs!=null) {
				rs.close();
			}
			
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
