package dbPackages.ex3; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

//scott.emp테이블에 전체 사원목록 조회 작업을 위한 클래스이다
//PreparedStatement객체를 이용한 select문 실행 
public class SelectEx02 {

	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String user="scott";
		String password="tiger";
		Connection conn=null;
		//Statement  stmt=null;
		PreparedStatement stmt=null;
		ResultSet rs = null; //select쿼리문의 실행결과집합을 저장하기위한 변수선언 및 초기화
		
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
		try {
			String sql = 
				"SELECT empno,ename,job,hiredate,sal"+
				" FROM EMP";

			stmt =conn.prepareStatement(sql);
			System.out.println("3.PreparedStatement객체 생성");
			
			//4.쿼리실행
			//query문에 ;미포함, 작은따옴표,공백,괄호 등등 주의=> 실행가능한 쿼리문!			
			//executeUpdate() 메소드를 호출하면 
			//주어진 SQL문(insert,update,delete)이 실행. 실행된 레코드수가 리턴된다
			//executeQuery(select문) : select쿼리문실행. 실행결과를 ResultSet리턴

			//int resultCnt = stmt.executeUpdate(sql);
			
			//PreparedStatement객체를 
			//실행하기전에(executeUpdate() 혹은 executeQuery() )
			//?개수만큼 set설정해야한다
			//set데이터타입(?순서,값)
			//stmt.setInt(1, 7934); //여기에서는 ?없으므로 삭제해야하는 코드
			//위의 코드를 놔두면 java.sql.SQLException: 부적합한 열 인덱스  
			
			//executeUpdate(): insert,update,delete실행
			//executeQuery() : select실행
			rs = stmt.executeQuery();
			System.out.println("4.쿼리문실행결과 : ");
			/*if( rs.next() ) { //rs.next()는 다음행(new row)있으면 true리턴
			 * System.out.println("select결과가 있어요"); }else {
			 * System.out.println("select결과가 없네요"); }
			 */
			while( rs.next() ) { //rs.next()는 다음행(new row)있으면 true리턴
				//rs.get데이터타입(select컬럼순서) 첫번째컬럼은 1, 두번째컬럼은 2..
				//rs.getI데이터타입("컬럼명 또는 컬럼별칭")
				//int eno=rs.getInt(1); //여기에서는 첫번째컬럼이 empno가 된다
				int eno=rs.getInt("empno");//empno컬럼의 값을 자바에서 int로 처리
				String eName=rs.getString("ename");//job컬럼값 가져오기
				String job=rs.getString("job");//ename컬럼값 가져오기
				Date hireDate=rs.getDate("hiredate");//hiredate컬럼값 가져오기
				String strHireDate = rs.getString("hiredate");
				double salary=rs.getDouble("sal");//sal컬럼값 가져오기
				
				//%d : 숫자
				//%s : 문자열
				//  \r\n : 줄바꿈
				System.out.printf("%10d%10s, %10s는 ", eno, eName, job);
				//System.out.print(eno+"/");
				//System.out.print(eName+", ");
				//System.out.print(job+" ");
								
				System.out.print(hireDate);
				System.out.print(strHireDate);
				System.out.print(salary);
				System.out.println();//줄바꿈
			}
			
			
		} catch (SQLException e1) {
			System.out.println("executeUpdate()실행관련 에러");
			e1.printStackTrace();
		}
		
		//5.자원반납
		try {
			if(rs!=null) {	
				rs.close();
			}
			
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




