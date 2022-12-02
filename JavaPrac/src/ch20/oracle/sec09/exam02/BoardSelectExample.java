package ch20.oracle.sec09.exam02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch20.oracle.sec09.exam02.Board;

public class BoardSelectExample {

	public static void main(String[] args) {
	Connection conn = null;
			try {
				//JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
				Class.forName("oracle.jdbc.OracleDriver");
				
				//DB와 연결
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "qwe3776");
				System.out.println("연결 성공");
				
				
				//DB작업 매개변수화 된  insert 문
				String sql = "select bno, btitle, bcontent,bwriter,bdate,bfilename, bfiledata from boards where bwriter=?";
						// toString이 문자열을 리턴해주니까 String sql에 넣을 수 있음.
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, "winter");
				ResultSet rs = pstmt.executeQuery();
				List<Board> boards = new ArrayList<>();
				while(rs.next()) {
					//한행씩 한행씩 보드 개체에 담아보자
					Board board = new Board();
					board.setBno(rs.getInt("bno"));
					board.setBtitle(rs.getString("btitle"));
					board.setBcontent(rs.getString("bcontent"));
					board.setBwriter(rs.getString("bwriter"));
					board.setBdate(rs.getDate("bdate"));
					board.setBfileName(rs.getString("bfileName"));
					board.setBfileData(rs.getBlob("bfileData"));
					System.out.println(board);
					
				}
				rs.close();
				//반영된 행의 수를 리턴한다. 
				printBoards(boards);
				
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
				}
				System.out.println("연결 끊김");
			}
		}
	}
	public static void printBoards(List<Board> boards) {
//		for(Board board : boards) {
//			System.out.println(board);
//		}
		boards.stream().forEach(b -> System.out.println(b));
	}
}

