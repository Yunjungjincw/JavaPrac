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

public class NoticeBoardDAO{
	
	public void getNoticeList(int inputnbno) {
	
	PreparedStatement stmt = null;
	// stmt를 null로 만들어주고 , 
	Connection conn = null;
	ResultSet rs = null;
	
	
	String sql = "select nbno,title,contant,cre_date,writer,rcnt,empno"
				+ " from  noticeboard"
				+ " order by nbno desc";

	
	conn = JdbcUtil.getConnection();


			try {
				stmt = conn.prepareStatement(sql);
		//PreparedStatement 인터페이스는 sql문의 결과값을 받아올 용도이다. 
				rs = stmt.executeQuery();
				// rs 에는 PreparedStatement stmt를 이용해서 쿼리문을 실행하여 rs에 담아준다.
				// 그럼 rs에서 쿼리문 실행한 결과값을 받을 수 있겠네 ?
				// 근데 따로 어떤 데이터가 들어가 있는지 모르니까 내가 원하는 결과를 출겨하기 위해서는?
				// 따로 다른걸 설정해줘야함.
				
				//그럼 for문이나 while문을 돌려줘야하는데  안에 들어있는 데이터 
				// for문 => i<9 이런식으로 조건이 정확할 경우 사용
				// while = - 조건식이 false가 될때 까지 무한 실행
//					true 라면 계속 실행하고 false 가 되면 즉시 while 문 종료
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	
	
	

} // getNoticeList()끝
	
	}	
