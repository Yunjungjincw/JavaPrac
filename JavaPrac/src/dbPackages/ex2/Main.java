package dbPackages.ex2;

import java.sql.Connection;
import java.util.Scanner;

//메인클래스
//web에서는 불필요한 부분
public class Main {

	public static void main(String[] args) {
		NoticeBoardDAO ntBoardDAO = new NoticeBoardDAO();//DAO 객체 생성
		 Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println();
			System.out.println();
			System.out.println("-1.목록조회 2.상세조회 3.등록 4.수정 5.삭제 6.종료-");
			System.out.printf("원하는 메뉴번호를 입력하세요:");
			int num = sc.nextInt();	//Scans the next token of the input as an int. 
		
			if(num==1) {	//1.목록조회
				ntBoardDAO.getNoticeList(num);
			}else if(num==2) {	//2.상세조회
				System.out.print("조회할 글번호: ");
				int nbno =sc.nextInt();//user로부터 글번호 입력받아 nbno에 저장
				//nbno 변수명 상관X
				ntBoardDAO.getNotice(nbno);
			}else if(num==3) {	//3.등록
				System.out.println("등록 정보를 입력하세요.");
				System.out.print("제목: ");
				String title= sc.next();
				System.out.print("내용: ");
				String contant= sc.next();
				System.out.print("작성자: ");
				String writer= sc.next();
				ntBoardDAO.addNotice(title, contant, writer);
			}else if(num==4) {	//4.수정
				System.out.println("수정 정보를 입력하세요.");
				System.out.print("수정할 글번호 :");
				int nbno = sc.nextInt();
				System.out.print("제목: ");
				String title= sc.next();
				System.out.print("내용: ");
				String contant= sc.next();
				System.out.print("작성자: ");
				String writer= sc.next();
				ntBoardDAO.updateNotice(nbno,title, contant, writer);
			}else if(num==5) {	//5.삭제
				System.out.printf("삭제할 글번호: ");
				int nbno = sc.nextInt();
				ntBoardDAO.delNotice(nbno);
			}else if(num==6) {	//6.종료 -> 반복문 종료
				break;
			}else {
				System.out.println("기타. 잘못된 번호");
			}
		} // while 끝
		System.out.println("종료");
		
		
		
		//db연결테스트
//		Connection conn =JdbcUtil.getConnection();
//		
		//전체목록조회
		//JdbcUtil.close(conn);
	}

}

