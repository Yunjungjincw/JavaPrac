package dbPackages.listPrac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//DAO:Data Access Object. 
//DAO란 DB연동하여 DB작업 제공하는 클래스이다
//이 클래스는 Board관련 DB작업 제공하는 클래스

//이 클래스에서는 매개변수로 NoticeBoardDTO를 사용+
//         리턴유형을  NoticeBoardDTO로 지정
public class NoticeBoardDAO {
	
	
	//1.목록조회 public 게시글목록 getNoticeList() {
	//리턴유형이  NoticeBoardDTO클래스
	public List<NoticeBoardDTO> getNoticeList() {
		System.out.println("getNoticeList()진입");

		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		String sql = "select nbno,title,contant,cre_date,writer,rcnt,empno " + 
					 "from noticeboard " + 
					 "order by nbno desc";
		
		conn = JdbcUtil.getConnection();//1.드라이버등록&2.커넥션얻기
		
		//인터페이스타입 참조변수명=new 구현클래스명();
		List<NoticeBoardDTO> list=new ArrayList();
		//클래스명타입    참조변수명=new 클래스명();
		//ArrayList<NoticeBoardDTO> list=new ArrayList();
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			System.out.println("try{}안!");
			//4.실행  
			/*rs.get데이타입(select순서)
			  rs.get데이타입("컬럼명")*/
			while( rs.next() ) {
				int nbno = rs.getInt("nbno");
				String title  = rs.getString("title");
				String contant=rs.getString("contant");
				Date cre_date = rs.getDate("cre_date");
				String writer = rs.getString("writer");
				int rcnt=rs.getInt("rcnt");//조회수
				int empno=rs.getInt("empno");//사원번호
				
				//방법1.기본생성자를 이용하여 객체를 생성하는 경우
				NoticeBoardDTO nbdto=new NoticeBoardDTO();
				nbdto.setNbno(nbno);
				nbdto.setTitle(title);
				nbdto.setContant(contant);
				nbdto.setCre_date(cre_date);
				nbdto.setWriter(writer);
				nbdto.setRcnt(rcnt);
				nbdto.setEmpno(empno);
				
				//공지사항게시판의 객체를 list에 추가한다
				list.add(nbdto);
				
				//System.out.printf("%5d\t%s\t%s\t%s",nbno,title,cre_date,writer);
				//System.out.println();//줄바꿈
				
			}//while
		} catch (SQLException e) {
			System.out.println("catch{}안~~");
			e.printStackTrace();
		}finally {
			System.out.println("exception발생상관없이 finally블럭입니다~~~~");
			//exception발생하지않아도, 
			//exception이 발생하여 catch절에 들어갔어도
			//finally블럭은 반드시 거쳐가야 한다
			//=>반드시 해야하는 작업(코드가)이 있다면 finally블럭을 이용한다
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
		return list;
	}//getNoticeList()끝
	
	//2.상세조회
	//리턴유형이  NoticeBoardDTO클래스
	public void getNotice(NoticeBoardDTO inputNbno) {
//	public NoticeBoardDTO getNotice(int nbno) {
		System.out.println("getNotice()진입 nbDTO="+inputNbno);//주소
//		System.out.println("getNotice()진입 nbDTO.getNbno()="+nbno);
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
//		NoticeBoardDTO ntDTOobj = null;
		//select결과로 받은 컬럼의 값들을 NoticeBoardDTO()객체로 만들기위해 선언한 변수 및 초기화
		
		conn = JdbcUtil.getConnection();//1.드라이버등록&2.커넥션얻기
		String sql ="SELECT nbno,title,contant,cre_date,writer,rcnt,empno "+
					"FROM noticeboard "+
					"WHERE nbno = ?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, inputNbno.getNbno());
			rs = stmt.executeQuery();
			
			while ( rs.next() ) { //select결과로 record가 존재
				int nbno3 = rs.getInt("nbno");  
				String title = rs.getString("title");  
				String contant = rs.getString("contant");  
				Date cre_date = rs.getDate("cre_date");
				String writer = rs.getString("writer");  
				int rcnt = rs.getInt("rcnt");
				int empno = rs.getInt("empno");
				
				//NoticeBoardDTO 참조변수=new NoticeBoardDTO(글번호,~,~,~,~,~,사번);
				//SELECT nbno,title,contant,cre_date,writer,rcnt,empno 
//				ntDTOobj = new NoticeBoardDTO(nbno2,title,content,
//												creDate,writer,rcnt,empno);
				
				
				System.out.printf("%5d\t%s\t%s\t%s\t%s\t%d\t%s",nbno3,title,contant,cre_date,writer,rcnt,empno);
//			}else { //select결과로 record가 존재x
//				System.out.println("조회한 글번호("+nbno+")에 해당하는 글이 존재하지 않아요");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		JdbcUtil.close(rs);
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		
//		return ntDTOobj;
	}
	
	//3.등록   
	public boolean addNotice(NoticeBoardDTO ntDTO) {
		System.out.println("addNotice() ntDTO="+ntDTO);
		System.out.printf("addNotice() title:%s, contant:%s, writer:%s\r\n",
							   ntDTO.getTitle(),ntDTO.getContant(),ntDTO.getWriter());
		
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean result = false; //입력성공실패여부를 저장하기 위한 변수 선언 및 초기화
		
		conn = JdbcUtil.getConnection();//1.드라이버등록&2.커넥션얻기
		String sql = "INSERT INTO noticeboard(nbno,title,contant,cre_date,writer,rcnt,empno) "+ 
				 "VALUES(notice_seq.nextval,?,?,SYSDATE,?,0,7900)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, ntDTO.getTitle());
			stmt.setString(2, ntDTO.getContant());
			stmt.setString(3, ntDTO.getWriter());
			
			int cnt=stmt.executeUpdate();
			System.out.println("리턴되는 행수="+cnt);
			if(cnt==1) {
				System.out.println("입력성공");
				result=true;
			}else {
				System.out.println("입력실패");
				result=false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);//5.반납
		
		return result;
	}
	
	//4.수정   
	public boolean updateNotice(NoticeBoardDTO ntDTO) {
		System.out.println("updateNotice() ntDTO="+ntDTO);
		System.out.printf("updateNotice() nbno:%d, title:%s, contant:%s, writer:%s\r\n"
				,ntDTO.getNbno(),ntDTO.getTitle(),ntDTO.getContant(),ntDTO.getWriter());
		Connection conn = null;
		PreparedStatement stmt = null;
		 boolean result = false;
		String sql = "update noticeboard "+
					 "set title = ?, contant= ?,writer = ? "+
					 "where nbno = ?";
		
		conn = JdbcUtil.getConnection();//1.드라이버등록&2.커넥션얻기

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,ntDTO.getTitle());
			stmt.setString(2,ntDTO.getContant());
			stmt.setString(3,ntDTO.getWriter());
			stmt.setInt(4,ntDTO.getNbno());
			
			int cnt=stmt.executeUpdate();
         System.out.println("리턴되는 행수="+cnt);
          if(cnt==1) {
             System.out.println("수정성공");
             result=true;
          }else {
             System.out.println("수정실패");
             result=false;
          }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		return result;
	}	
	
	//5.삭제 
	public int delNotice(int nbno) {
		System.out.println("delNotice()진입 참조변수ntDTO="+nbno);//주소출력
//		System.out.println("delNotice()진입 참조변수ntDTO="+ntDTO.getNbno());//글번호출력
		Connection conn = null;
		PreparedStatement stmt = null;
		int resultCnt = 0;//delete실행시 리턴되는 행수를 저장하기위한 변수선언 및 초기화
		String sql = "delete from noticeboard " + 
					 "where nbno = ?"; 
		
		conn = JdbcUtil.getConnection();//1.드라이버등록&2.커넥션얻기
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, nbno); //1번째 ?에 글번호
			resultCnt = stmt.executeUpdate();
			System.out.println("resultCnt개수 = " + resultCnt);
			if(resultCnt>=1) {
				System.out.println("삭제success");
			}else {
				System.out.println("삭제fail");
			}
							
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		JdbcUtil.close(stmt);
		JdbcUtil.close(conn);
		
		return resultCnt;
	}	
}






