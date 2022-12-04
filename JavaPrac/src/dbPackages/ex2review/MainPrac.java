package dbPackages.ex2review;

import java.util.Scanner;

//메인 클래스
// web 에서는 불필요한 부분

public class MainPrac {

	public static void main(String[] args) {
		NoticeBoardDAOPrac ntBoardDAOPrac = new NoticeBoardDAOPrac(); //객체 생성
			Scanner sc = new Scanner(System.in);

			
			while(true) {
				System.out.println();
				System.out.println();
				System.out.println("1.목록조회 2. 상세조회 3.등록 4.수정 5.삭제 6.종료-");
				System.out.println("원하는 메뉴번호를 입력하세요:");
				int num = sc.nextInt();
				
				if(num==1) { //  데이터 베이스 전체목록조회
					ntBoardDAOPrac.getNoticeList(num);
				}else if (num==2) { // 데이터 베이스 번호로 상세목록 조회
					System.out.println("조회할 글번호 : ");
					int nbno = sc.nextInt();
					ntBoardDAOPrac.getNotice(nbno);
				} else if(num==3) {
					System.out.println("등록 정보를 입력하세요.");
					System.out.println("제목: ");
					String title = sc.next();
					System.out.println("내용: ");
					String contant = sc.next();
					System.out.println("작성자: ");
					String writer = sc.next();
					ntBoardDAOPrac.addNotice(title, contant, writer);
				} else if (num==4) { //수정
					System.out.println("수정 정보를 입력하세요");
					System.out.println("수정할 글번호 :");
					int nbno = sc.nextInt();
					System.out.println("제목:");
					String title = sc.next();
					System.out.println("내용: ");
					String contant = sc.next();
					System.out.println("작성자: ");
					String writer = sc.next();
					ntBoardDAOPrac.updateNotice(nbno, title, contant, writer);
				} else if (num==5) { //삭제
					System.out.println("삭제할 글번호 : ");
					int nbno = sc.nextInt();
					ntBoardDAOPrac.delNotice(nbno);
				} else if (num==6) {
					break;
				} else {
					System.out.println("기타. 잘못된 번호");
				}
			}
			System.out.println("종료");
	}

}
