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
	}
	
	//update
}
