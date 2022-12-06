package dbPackages.ex2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

//DAO:Data Access Object.
//DAO란 DB 연동하여 DB 작업 제공하는 클래스이다.
//이 클래스는 DB연동하여 DML 기능을 제공하는 클래스이다.
public class NoticeBoardDAO {
	//field
	//contructor
	//method
	//1.목록조회
	public void getNoticeList(int inputnbno) {
		System.out.println("getNoticeList() 진입");
		
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		//1. 드라이버등록 => 2. 커넥션얻기, 객체준비, 실행, 반납
		//db연결테스트
		String sql = "select nbno,title,cre_date,writer,rcnt,empno"
				+ " from  noticeboard"
				+ " order by nbno desc";
		
		conn =JdbcUtil.getConnection();

		//3. 객체준비
		// 
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			//4.실행
			/*
			 * rs.get데이터타입(select순서)
				rs.get데이터타입("컬럼명")
			 */
		while(rs.next() ) {
			int nbno = rs.getInt("nbno");
			String title= rs.getString("title");
			Date cre_date = rs.getDate("cre_date");
			String writer = rs.getString("writer");
			int rcnt = rs.getInt("rcnt");
			int empno = rs.getInt("empno");
			
			
			System.out.printf("%5d\t%s\t%s\t%s\t%s",nbno,title,cre_date,rcnt,empno);
			System.out.println();
		}
			/*
			 * printf 에서 %t 는 Date 객체
			 * %tY 는 년도 %tm 는 월 %td는 일
			 * %tH 는 시 %tM는 분 %tS는 초
			 */
		} catch (SQLException e) {
			e.printStackTrace();
	}
		
		try {
			stmt.executeQuery();
			//이미 쿼리를 보냈기 때문에
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//5.반납
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
	} // getNoticeList()끝
	
	
	//2.상제조회
	public void getNotice(int inputnbno) {
		System.out.println("getNotice()nbno 진입="+inputnbno);
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		//1. 드라이버등록 => 2. 커넥션얻기, 객체준비, 실행, 반납
		//db연결테스트
		String sql = "select nbno,title,cre_date,writer,rcnt,empno"
				+ " from noticeboard"
				+ " where nbno = ?";
		
		conn =JdbcUtil.getConnection();
		
		//3. 객체준비
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, inputnbno);
			rs = stmt.executeQuery();
			//4.실행
			/*
			 * rs.get데이터타입(select순서)
//				rs.get데이터타입("컬럼명")
//			 */
		while(rs.next() ) {
			int nbno = rs.getInt("nbno");
			String title= rs.getString("title");
			Date cre_date = rs.getDate("cre_date");
			String writer = rs.getString("writer");
			
			
			System.out.printf("%5d\t%s\t%s\t%s\t",nbno,title,cre_date,writer);
			System.out.println();
			
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt.executeQuery();
			//이미 쿼리를 보냈기 때문에
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
		//5.반납
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
	};//getNotice 끝
	
	
	//3.등록 - title메목, contant내용, 작성자명writer
	public boolean addNotice(String inputtitle, String inputcontant, String inputwriter) {
		System.out.printf("addNotice() title:%s, contant:%s, writer:%s\r\n",inputtitle,inputcontant,inputwriter );
		PreparedStatement stmt = null;
		Connection conn = null;
		boolean result = false;
//		ResultSet rs = null;  = select 할 때만 넣어주는 것.
		
		//1. 드라이버등록 => 2. 커넥션얻기, 객체준비, 실행, 반납
		//db연결테스트
		String sql = "INSERT INTO noticeboard(nbno,title,contant,cre_date,writer,rcnt,empno)"
				+ " VALUES(notice_seq.nextval,?,?,SYSDATE,?,100,7900)";
		
		conn =JdbcUtil.getConnection();
		//3. 객체준비
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, inputtitle);
			stmt.setString(2, inputcontant);
			stmt.setString(3, inputwriter);
//			rs = stmt.executeQuery();
			
		// 실행 
			//insert 에 성공하면 리턴되는 행수는 1
			// insert에 실패시에는 리턴되는 행수는 0
			
			
			int cnt = stmt.executeUpdate();
			System.out.println("등록 완료 : "+cnt);
			
			if(cnt==1) {
				System.out.println("입력 성공");
				result = true;
			}else {
				System.out.println("입력실패");
				result=false;
			}
			
			
			
//			stmt.close();
			//4.실행
			/*
			 * rs.get데이터타입(select순서)
				rs.get데이터타입("컬럼명")
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//5.반납
//		JdbcUtil.close(rs); => select 할 때만 넣어주는 것.
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		
		return result;
	} // addNotice 끝
	
	
	//4.수정 -title제목, contant내용, 작성자명writer
	public boolean updateNotice( int inputnbno, String inputtitle, String inputcontant, String inputwriter) {
		System.out.printf("updateNotice() nbno:%d title:%s, contant:%s, writer:%s\r\n",inputnbno,inputtitle,inputcontant,inputwriter);
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		boolean result = false;
		
		//1. 드라이버등록 => 2. 커넥션얻기, 객체준비, 실행, 반납
		//db연결테스트
		String sql = "UPDATE noticeboard"
				+ " set title =?,contant=?,writer=?"
				+ " where nbno =?";
		
		conn =JdbcUtil.getConnection();
		
		//3. 객체준비
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, inputtitle);
			stmt.setString(2, inputcontant);
			stmt.setString(3, inputwriter);
			stmt.setInt(4, inputnbno);
	
			int resultUp = stmt.executeUpdate();
			System.out.println("리턴되는 행수"+resultUp);
			if(resultUp==1) {
				System.out.println("수정 완료");
				result = true;
			} else {
				System.out.println("수정 실패");
				result = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//5.반납
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		return result;
		
	}; //updateNotice 끝
	
	
	//5.삭제
	// 매개변수 - inputnbno는 글번호
	// 리턴유형 int delete 실행시 리턴되는 행수
	public int delNotice(int inputnbno) {
		System.out.println("delNotice()진입 nbno="+inputnbno);
		PreparedStatement stmt = null;
		Connection conn = null;
		int resultCnt = 0; //delete 실행시 리턴되는 행수를 저장하기위한 변수선언 및 초기화
		//1. 드라이버등록 => 2. 커넥션얻기, 객체준비, 실행, 반납
		//db연결테스트
		String sql = "DELETE FROM noticeboard"
				+ " where nbno = ?";
		
		conn =JdbcUtil.getConnection();
		//3. 객체준비
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, inputnbno);
			
			resultCnt = stmt.executeUpdate();  // 타입이 붙으면 선언해주는건
			if(resultCnt==1) {
				System.out.println("삭제 완료");
			}else {
				System.out.println("삭제 실패");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//5.반납
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		
		return resultCnt;
	}
}
