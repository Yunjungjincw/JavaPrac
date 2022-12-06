package dbPackages.ex4prac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

//DAO data Access object
//DAO 란 DB 연동하여 DB 작업 제공하는 클래스
//이 클래스는 Board 관련 db 작업을 제공하는 클래스

// 이 클래스에서는 매개변수로 NoticeBoardDTO를 사용

public class NoticeBoardDAO{
	
	// 1. 목록조회
	public void getNoticeList(int inputnbno) {
		System.out.println("getNoticeList() 진입");
		
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		//db 연결 테스트
		String sql = "select nbno,title,contant,cre_date,writer,rcnt,empno"
				+ " from  noticeboard"
				+ " order by nbno desc";
		
		conn = JdbcUtil.getConnection();
		
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				int nbno = rs.getInt("nbno");
				String title = rs.getString("title");
				String contant = rs.getString("contant");
				Date cre_date = rs.getDate("cre_date");
				String writer = rs.getString("writer");
				int rcnt = rs.getInt("rcnt");
				int empno = rs.getInt("empno");
				
				System.out.printf("%5d\t%s\t%s\t%s\t%s\t%s\t%s\t%s",nbno,title,contant,cre_date,writer,rcnt,empno);
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
	}
	//2.상세조회 - 1개만 처리하면 되는거라 int 처리해주는게 낫다고 함.
	public NoticeBoardDTO getNotice(NoticeBoardDTO nbDTO) {
		System.out.println("getNotice() nbno 진입="+nbDTO);
		System.out.println("getNotice() nbno 진입="+nbDTO.getNbno());
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		NoticeBoardDTO ntDTOobj = null;
		
		conn = JdbcUtil.getConnection();
		String sql = "select nbno,title,contant,cre_date,writer,rcnt,empno"
				+ " from noticeboard"
				+ " where nbno = ?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, nbDTO.getNbno());
			rs = stmt.executeQuery();
		
		
		if(rs.next()) {
			int nbno = rs.getInt("nbno");
			String title = rs.getString("title");
			String contant = rs.getString("contant");
			Date cre_date = rs.getDate("cre_date");
			String writer = rs.getString("writer");
			int rcnt = rs.getInt("rcnt");
			int empno = rs.getInt("empno");
			
			ntDTOobj = new NoticeBoardDTO(nbno,title,contant,cre_date,writer,rcnt,empno);
			
			
			System.out.printf("%5d\t%s\t%s\t%s\t%s\t%s\t%s\t",nbno,title,contant,cre_date,writer,rcnt,empno);
			System.out.println();
		}else {
			System.out.println("조회한 글번호("+nbDTO.getNbno()+")에 해당하는 글이 존재하지 않아요.");
		}
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		
		return ntDTOobj;
	};
	
	// 등록
	public boolean addNotice(NoticeBoardDTO ntDTO) {
		System.out.printf("addNotice() ntDTO="+ntDTO);
		System.out.printf("addNotice() title:%s, contant:%s, writer:%s\r\n",ntDTO.getTitle(),ntDTO.getContant(), ntDTO.getWriter());
		
		PreparedStatement stmt =null;
		Connection conn = null;
		boolean result = false;
		
		String sql = "INSERT INTO noticeboard(nbno,title,contant,cre_date,writer,rcnt,empno)"
				+ " VALUES(notice_seq.nextval,?,?,SYSDATE,?,,7900)";
		
		conn = JdbcUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ntDTO.getTitle());
			stmt.setString(2, ntDTO.getContant());
			stmt.setString(3, ntDTO.getWriter());
			
			int cnt = stmt.executeUpdate();
			System.out.println("등록완료"+cnt);
			
			if(cnt==1) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력 실패");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		
		
		
		return result;
	}
	
	
	
//4. update
	public boolean updateNotice(NoticeBoardDTO ntDTO) {
		System.out.printf("updateNotice() ntDTO="+ntDTO);
		System.out.printf("updateNotice() nbno:%d, title:%s, contant:%s, writer:%s\r\n",ntDTO.getNbno(),ntDTO.getTitle(),ntDTO.getContant(),ntDTO.getWriter());
		
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		boolean result =false;
		
		String sql = "UPDATE noticeboard"
				+ " set title =?,contant=?,writer=?"
				+ " where nbno =?";
		
		
		try {
			stmt = conn.prepareStatement(sql);
			//prepareStatement 를 쓰는 이유는 위에서  ? 형태로 있는 곳에서 값을 받기 위해서
			stmt.setString(1, ntDTO.getTitle());
			stmt.setString(2, ntDTO.getContant());
			stmt.setString(3, ntDTO.getWriter());
			stmt.setInt(4, ntDTO.getNbno());
			
			
			int cnt = stmt.executeUpdate();
			System.out.println("등록 완료: "+cnt);
			
			if(cnt==1) {
				System.out.println("수정 성공");
				result = true;
			} else {
				System.out.println("수정 실패");
				result = false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		
		
		
		return result;
	}
	// 삭제
	public int delNotice(NoticeBoardDTO nbDTO) {
		System.out.println("getNotice()nbno 진입="+nbDTO);
		System.out.println("getNotice()nbno 진입="+nbDTO.getNbno());
		PreparedStatement stmt = null;
		Connection conn = null;
		int resultCnt =0;
		
		String sql = "DELETE FROM noticeboard"
				+ " where nbno = ?";
		
		conn = JdbcUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, nbDTO.getNbno());
			
			resultCnt = stmt.executeUpdate();
			System.out.println("resultCnt개수 = "+resultCnt);
			
			if(resultCnt>=1) {
				System.out.println("삭제완료");
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
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		return resultCnt;
	}
}
