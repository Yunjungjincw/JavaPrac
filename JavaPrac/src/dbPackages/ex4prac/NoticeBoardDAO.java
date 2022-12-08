package dbPackages.ex4prac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import dbPackages.ex4.JdbcUtil;


//DAO data Access object
//DAO 란 DB 연동하여 DB 작업 제공하는 클래스
//이 클래스는 Board 관련 db 작업을 제공하는 클래스
// 이 클래스에서는 매개변수로 NoticeBoardDTO를 사용

// DAO 클래스 
// int 타입의 매개값을 받는 메소드를 생성하고, 그 타입은 NoticeBoardDAO 으로 만든다. =>
// 
public class NoticeBoardDAO{
	
	public NoticeBoardDAO getNoticeList(int inputnbno) {
	System.out.println("getNotice() 접근");
	NoticeBoardDAO nbno1 = new NoticeBoardDAO();
	PreparedStatement stmt = null; 
	// 초기값 null로 초기화
	Connection conn = null;
	ResultSet rs = null;
	
	// 형태는 String 타입 sql 에 쿼리문을 저장하는건데,
	String sql = "select nbno,title,contant,cre_date,writer,rcnt,empno"
				+ " from  noticeboard"
				+ " order by nbno desc";
	conn = JdbcUtil.getConnection();
			try {
				stmt = conn.prepareStatement(sql);
				// string 타입의 쿼리문 저장된 sql을 
				rs = stmt.executeQuery();
				//************* rs 에는 PreparedStatement stmt를 이용해서 쿼리문을 실행하여 rs에 담아준다.
				// 그럼 rs에서 쿼리문 실행한 결과값을 받을 수 있겠네 ?
				// 근데 따로 어떤 데이터가 들어가 있는지 모르니까 내가 원하는 결과를 출겨하기 위해서는?
				// 따로 다른걸 설정해줘야함.
				
				//그럼 for문이나 while문을 돌려줘야하는데  안에 들어있는 데이터 
				// for문 => i<9 이런식으로 조건이 정확할 경우 사용
				// while = - 조건식이 false가 될때 까지 무한 실행
//					true 라면 계속 실행하고 false 가 되면 즉시 while 문 종료
				while(rs.next()) {
		//*************while문을 놀려서 rs 안에 있는 값들을 찾기 위해 사용되는 건가 ?
					// while문은 더 이상 찾을게 없으면 false 값을 나타내고 false 값이 나오면 멈추게됨 무한루프도니까
					int nbno = rs.getInt("nbno");
					String title = rs.getString("title");
					String contant = rs.getString("contant");
					Date cre_date = rs.getDate("cre_date");
					String writer = rs.getString("writer");
					int rcnt = rs.getInt("rcnt");
					int empno = rs.getInt("empno");
					
					System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t%s\t",nbno,title,contant,cre_date,writer,rcnt,empno);
					//**********여기서 숫자 7의 의미와 t는 뭐지 s는 문자열인건 알겠는데;
					System.out.println();
				}
				stmt.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		JdbcUtil.close(rs);
		JdbcUtil.close(conn);
		JdbcUtil.close(stmt);
//		Statement를 닫지 않을 경우, 생성된 Statement의 개수가 증가하여 더 이상 Statement를 생성할 수 없게 된다.
//		close() 하지 않으므로 불필요한 자원(네트워크 및 메모리)을 낭비하게 된다.
//		커넥션 풀을 사용하지 않는 상황에서 Connection을 닫지 않으면 결국엔 DBMS에 연결된 새로운 Connection을 생성할 수 없게 된다.
		return nbno1;
	} // getNoticeList()끝
	
}	
