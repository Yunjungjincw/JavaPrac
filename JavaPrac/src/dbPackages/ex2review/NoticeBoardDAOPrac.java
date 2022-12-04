package dbPackages.ex2review;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeBoardDAOPrac {
	
	//DAO : data access object.
	//dao 란 db 연동하여 db 작업 제공하는 클래스.
	// 이 클래스는 db 연동하여 dml 기능을 제공하는 클래스 
	//(DML :  Data Manipulation Language 데이터 조작어
		//field 
		//contructor
		//method
		//1. 목록 조회
		public void getNoticeList(int inputnbno) {
			System.out.println("getNoticeList() 진입");
			
			PreparedStatement stmt = null;
			Connection conn = null;
			ResultSet rs = null;
			
			//1. 드라이버 등록 = > 2. 커넥션 얻기, 객체준비, 실행 , 반납
			//db연결테스트 
			String sql = "select nbno,title,cre_date,writer"
					+ " from  noticeboard"
					+ " order by nbno desc";
			
			conn = JdbcUtilPrac.getConnection();
			
			//객체준비
			try {
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				
				//여기 아래 있는 것들은 그럼, 필드 선언을 따로 안해주는 이유는
				//이미 데이터베이스 들어있는 컬럼의 값들이기 때문에 그런건가 ?
				while(rs.next()) {
					int nbno = rs.getInt("nbno");
					String title = rs.getString("title");
					Date cre_date = rs.getDate("cre_date");
					String writer = rs.getString("writer");
					
					System.out.printf("%5d\t%s\t%s\t",nbno,title,cre_date);
					System.out.println();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				stmt.executeQuery();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			JdbcUtilPrac.close(rs);
			JdbcUtilPrac.close(stmt);
			JdbcUtilPrac.close(conn);
		}
		
		
		// 2. 상세조회
		public void getNotice(int inputnbno) {
			System.out.println("getNotice()nbno 진입= "+inputnbno);
			PreparedStatement stmt = null;
			Connection conn = null;
			ResultSet rs = null;
			
			// 1. 드라이버 등록 => 2. 커넥션 얻기, 객체 준비, 실행 반납
			// db연결테스트 
			String sql = "select nbno,title,cre_date,writer,rcnt,empno"
					+ " from noticeboard"
					+ " where nbno = ?";
			
			conn = JdbcUtilPrac.getConnection();
			
			//3.객체준비
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1,inputnbno);
				rs = stmt.executeQuery();
				
				while (rs.next()) {
					int nbno = rs.getInt("nbno");
					String title = rs.getString("title");
					Date cre_date = rs.getDate("cre_date");
					String writer = rs.getString("writer");
					
					System.out.printf("%5d\t%s\t%s\t",nbno,title,cre_date);
					System.out.println();
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				stmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
			JdbcUtilPrac.close(rs);
			JdbcUtilPrac.close(stmt);
			JdbcUtilPrac.close(conn);
		}
		
		
		// 등록  -  title , contant writer 
		public void addNotice(String inputtitle, String inputcontant, String inputwriter ) {
			System.out.printf("addNotice() title: %s, contant:%s, writer:%s\r\n",inputtitle,inputcontant,inputwriter);
			PreparedStatement stmt = null;
			Connection conn = null;
			ResultSet rs = null;
			
			//1.드라이버 등록 = > 2.커넥션 얻기 , 객체준비, 실행, 반납
			//db 연결테스트
			
			String sql = "INSERT INTO noticeboard(nbno,title,contant,cre_date,writer,rcnt,empno)"
					+ " VALUES(notice_seq.nextval,?,?,SYSDATE,?,100,7900)";
			
			conn = JdbcUtilPrac.getConnection();
			
			//3. 객체준비
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, inputtitle);
				stmt.setString(2, inputcontant);
				stmt.setString(3, inputwriter);
				
				int rows = stmt.executeUpdate();
				System.out.println("등록완료: "+ rows);
				
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//5.반납
			JdbcUtilPrac.close(rs);
			JdbcUtilPrac.close(stmt);
			JdbcUtilPrac.close(conn);
		}
		
		
		// 수정 title제목, contant writer
		public void updateNotice(int inputnbno, String inputtitle, String inputcontant, String inputwriter) {
			System.out.printf("updateNotice() nbno:%d title:%s, contant:%s, writer:%s\r\n",inputnbno,inputtitle,inputcontant,inputwriter);
			PreparedStatement stmt = null;
			Connection conn = null;
			ResultSet rs = null;
			
			
			// 1. 드라이버 등록 = > 2.커넥션얻기, 객체준비, 실행 반납
			//db연결 테스트
			String sql = "UPDATE noticeboard"
					+ " set title =?,contant=?,writer=?"
					+ " where nbno =?";
			
			conn = JdbcUtilPrac.getConnection();
			
			//3.객체 준비
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, inputtitle);
				stmt.setString(2, inputcontant);
				stmt.setString(3, inputwriter);
				stmt.setInt(4, inputnbno);
				
				int rows = stmt.executeUpdate();
				System.out.println("수정 완료: "+ rows);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//5. 반납
			JdbcUtilPrac.close(rs);
			JdbcUtilPrac.close(stmt);
			JdbcUtilPrac.close(conn);
		}
		
		// 삭제 nbno 는 글번호 설정
		public void delNotice(int inputnbno) {
			System.out.println("delNotice()진입 nbno = "+ inputnbno);
			PreparedStatement stmt = null;
			Connection conn = null;
			ResultSet rs = null;
			
			//1,드라이버등록 = > 2. 커넥션 얻기 객체 준비 실행 반납
			
			String sql = "DELETE FROM noticeboard\r\n"
					+ " where nbno = ?";
			
			conn = JdbcUtilPrac.getConnection();
			
			try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, inputnbno);
			rs = stmt.executeQuery();
			
			int rows = stmt.executeUpdate();
			System.out.println("삭제완료 : "+ rows);

		} catch (SQLException e) {
			e.printStackTrace();
		}
			
			try {
				stmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JdbcUtilPrac.close(rs);
			JdbcUtilPrac.close(stmt);
			JdbcUtilPrac.close(conn);
	}
}
