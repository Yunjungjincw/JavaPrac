package dbPackages.ex5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//DAO:Data Access Object.
//DAO란 DB 연동하여 DB 작업 제공하는 클래스이다.
//이 클래스는 Board관련 DB작업을 제공하는 클래스이다.

//이 클래스에서는 매개변수로 NoticeBoardDTO를 사용+
// 리턴유형을 Notice
					
public class NoticeBoardDAO {
	
	//1-1.목록조회 public 게시글목록 getNoticeList2(){
	//리턴 유형이 NoticeBoardDTO클래스로 구성된 Set
	public Map<Integer,NoticeBoardDTO> getNoticeList2() {
		
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

		
		//db연결테스트
		String sql = "select nbno,title,contant,cre_date,writer,rcnt,empno"
				+ " from  noticeboard"
				+ " order by nbno desc";
		
		conn =JdbcUtil.getConnection(); // 드라이버등록 & 커넥션 얻기
		
		
		//key는 정수, value :NoticeBoardDTO
		Map<Integer,NoticeBoardDTO> map = new HashMap<Integer,NoticeBoardDTO>();
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			System.out.println("try{}안!");
			
			
		while(rs.next() ) {
			//방법1.파라미터가 있는 생성자를 이용하여 객체를 생성하는 경우
			NoticeBoardDTO nbdto = 
					new NoticeBoardDTO(	rs.getInt("nbno"),
										rs.getString("title"), 
										rs.getString("contant"),
										rs.getDate("cre_date"),
										rs.getString("writer"),
										rs.getInt("rcnt"),
										rs.getInt("empno"));

			//공지사항 게시판의 객체를 Map에 추가한다.
			//여기에서는  Map에 넣는 Key를 글번호로 사용하였다.
			//rs.getInt("nbno")는 noticeBoard테이블의 글번호 컬럼의 값 가져오기
			map.put(rs.getInt("nbno"), nbdto);
			}
		} catch (SQLException e) {
			System.out.println("catch{}안~~");
			e.printStackTrace();
		}finally {
			System.out.println("exception 발생 상관없는 finally 블럭");

		//5.반납
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
	}

		return map;
	}
	
	
	//1-1.목록조회 public 게시글목록 getNoticeList(){
	//리턴 유형이 NoticeBoardDTO클래스로 구성된 Set
	public Set<NoticeBoardDTO> getNoticeList() {
		System.out.println("getNoticeList() 진입");
		
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

		
		//db연결테스트
		String sql = "select nbno,title,contant,cre_date,writer,rcnt,empno"
				+ " from  noticeboard"
				+ " order by nbno desc";
		
		conn =JdbcUtil.getConnection(); // 드라이버등록 & 커넥션 얻기
		
		// 리스트선언
		// 인터페이스타입 참조변수명 = new 구현 클래스명();
		Set<NoticeBoardDTO> list = new HashSet();
		// 클래스명 타입 참조변수명 = new 클래스명 ();
		//ArrayList <NoticeBoardDTO> = new ArrayList();


		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			System.out.println("try{}안!");
			//DB 불러오기
			
			//4.실행
			/*
			 * rs.get데이터타입(select순서)
				rs.get데이터타입("컬럼명")
			 */
		while(rs.next() ) {
			int nbno = rs.getInt("nbno");
			String title= rs.getString("title");
			String contant = rs.getString("contant");
			Date cre_date = rs.getDate("cre_date");
			String writer = rs.getString("writer");
			int rcnt = rs.getInt("rcnt");
			int empno = rs.getInt("empno");
			
			
			NoticeBoardDTO nbDdto = new NoticeBoardDTO();
			nbDdto.setNbno(nbno);
			nbDdto.setTitle(title);
			nbDdto.setContant(contant);
			nbDdto.setCre_date(cre_date);
			nbDdto.setWriter(writer);
			nbDdto.setRcnt(rcnt);
			nbDdto.setEmpno(empno);
			
			
			//공지사항 게시판의 객체를 List에 추가한다.
			list.add(nbDdto);
			
			
//			list.add(NoticeBoardDTO객체);
//			System.out.printf("%5d\t%s\t%s\t%s\t%s\t%s\t%s\t",nbno,title,contant,cre_date,writer,rcnt,empno);
//			System.out.println();
		}//while문의 끝
			/*
			 * printf 에서 %t 는 Date 객체
			 * %tY 는 년도 %tm 는 월 %td는 일
			 * %tH 는 시 %tM는 분 %tS는 초
			 */
		} catch (SQLException e) {
			System.out.println("catch{}안~~");
			e.printStackTrace();
		}finally {
			System.out.println("exception 발생 상관없는 finally 블럭");
			//exception이 발생하지 않아도, exception 이 발생하여 catch절에 들어갔어도 
			// finally절에는 반드시 거쳐가야한다
			// 반드시 해야하는 작업이(코드) 있다면,  finally 블럭을 이용한다.
		}
		//5.반납
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		
		
		return list;
	} // getNoticeList()끝
	
	
	//2.상제조회 -1개만 처리하면되는거라 int 처리해주는게 낫다고 함.
//	public void getNotice(NoticeBoardDTO nbDTO) {
	
	
	// 매개변수 int nbno : 글번호
		public NoticeBoardDTO getNotice(int inputnbno) { // 로 코드작성
//		public NoticeBoardDTO getNotice(NoticeBoardDTO nbDTO) {
//		System.out.println("getNotice()nbno 진입="+nbDTO);
//		System.out.println("getNotice()nbno 진입=+nbDTO"+nbDTO.getNbno());
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		NoticeBoardDTO ntDTOobj = null;
		// select 결과로 받은 컬럼의 값들을 NoticeBoardDTO()객체로 만들기위해 선언한 변수 및 초기화ㄴ
		
		//db연결테스트
		conn =JdbcUtil.getConnection();
		String sql = "select nbno,title,contant,cre_date,writer,rcnt,empno"
				+ " from noticeboard"
				+ " where nbno = ?";
		
		//3. 객체준비
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, inputnbno);
			rs = stmt.executeQuery();

		if(rs.next() ) {		//while -> if select의 record가 존재한다.
			//select 컬럼의 값들을 불러옴.
			int nbno = rs.getInt("nbno");
			String title= rs.getString("title");
			String contant = rs.getString("contant");
			Date cre_date = rs.getDate("cre_date");
			String writer = rs.getString("writer");
			int rcnt = rs.getInt("rcnt");
			int empno = rs.getInt("empno");
			
			ntDTOobj = new NoticeBoardDTO(nbno,title,contant,cre_date,writer,rcnt,empno );
			
			//\t는 공백임   %s 내
//			System.out.printf("%5d\t%s\t%s\t%s\t%s\t%s\t%s\t",nbno,title,contant,cre_date,writer,rcnt,empno);
//			System.out.println();
		
		}else { //select의 결과로 record가 존재x
			System.out.println("조회한 글번호("+inputnbno+")에 해당하는 글이 존재하지 않아요.");
		}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//5.반납
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		
		
		return ntDTOobj;
	};
	
	
	//3.등록 - title메목, contant내용, 작성자명writer
	public boolean addNotice(NoticeBoardDTO ntDTO) {
		System.out.printf("addNotice() ntDTO="+ntDTO);
		System.out.printf("addNotice() title:%s, contant:%s, writer:%s\r\n",ntDTO.getTitle(),ntDTO.getContant(),ntDTO.getWriter()); // 주소 출력
		
		PreparedStatement stmt = null;
		Connection conn = null;
		boolean result = false;

		String sql = "INSERT INTO noticeboard(nbno,title,contant,cre_date,writer,rcnt,empno)"
				+ " VALUES(notice_seq.nextval,?,?,SYSDATE,?,,7900)";
		
		conn =JdbcUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ntDTO.getTitle());
			stmt.setString(2, ntDTO.getContant());
			stmt.setString(3, ntDTO.getWriter());
			
		
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
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		
		return result;
	} // addNotice 끝
	
	
	//4.수정 -title제목, contant내용, 작성자명writer
	public boolean updateNotice(NoticeBoardDTO ntDTO) {
		System.out.println("updateNotice() ntDTO="+ntDTO);
		System.out.printf("updateNotice() nbno:%d title:%s, contant:%s, writer:%s\r\n",ntDTO.getNbno(),ntDTO.getTitle(),ntDTO.getContant(),ntDTO.getWriter());
		
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		boolean result = false;
		
		//db연결테스트
		String sql = "UPDATE noticeboard"
				+ " set title =?,contant=?,writer=?"
				+ " where nbno =?";
		
		conn =JdbcUtil.getConnection();
		
		//3. 객체준비
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ntDTO.getTitle());
			stmt.setString(2, ntDTO.getContant());
			stmt.setString(3, ntDTO.getWriter());
			stmt.setInt(4, ntDTO.getNbno());
	
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
	public int delNotice(int nbno) {
		//참조변수 ntDTO에는 주소가 저장되었다.
		System.out.println("getNotice()nbno 진입="+nbno);
//		System.out.println("getNotice()nbno 진입=+nbDTO"+nbDTO.getNbno());
		PreparedStatement stmt = null;
		Connection conn = null;
		int resultCnt = 0;
		//db연결테스트
		String sql = "DELETE FROM noticeboard"
				+ " where nbno = ?";
		
		conn =JdbcUtil.getConnection();
		//3. 객체준비
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, nbno);
			
			resultCnt = stmt.executeUpdate();  // 타입이 붙으면 선언해주는건
			System.out.println("resultCnt개수 = " + resultCnt);
			if(resultCnt>=1) {
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
