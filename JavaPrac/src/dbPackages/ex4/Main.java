package dbPackages.ex4;

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
				int nbno =sc.nextInt();
				
				// "nbDTO" 매개변수 주소를 넘기기 위한 것.
				NoticeBoardDTO nbDTO = new NoticeBoardDTO(nbno); // 클래스타입으로 변경
				//리턴유형이 NoticeBoardDTO클래스인 getNotice()호출
				NoticeBoardDTO resultNTDTO = ntBoardDAO.getNotice(nbDTO);
					
				// 콘솔에 리턴받은 NoticeBoardDTO 객체내용을 출력
				System.out.println("리턴받은 NoticeBoardDTO="+resultNTDTO);
				System.out.println("--아래는 특정글번호의 상세내용이 컬럼별 한줄로 출력");
				
				//
				System.out.println("nbno컬럼값:"+resultNTDTO.getNbno());
				System.out.println("title컬럼값:"+resultNTDTO.getTitle());
				System.out.println("contant컬럼값:"+ resultNTDTO.getContant());
				System.out.println("cre_date컬럼값:"+resultNTDTO.getCre_date());
				System.out.println("writer컬럼값:"+resultNTDTO.getWriter());
				System.out.println("rcnt컬럼값:"+resultNTDTO.getRcnt());
				System.out.println("empno컬럼값:"+resultNTDTO.getEmpno());
				System.out.println("----까지----");
				
			}else if(num==3) {	//3.등록
				System.out.println("등록 정보를 입력하세요.");
				System.out.print("제목: ");
				String title= sc.next();
				System.out.print("내용: ");
				String contant= sc.next();
				System.out.print("작성자: ");
				String writer= sc.next();
				NoticeBoardDTO nbDTOobj = new NoticeBoardDTO();
			
				nbDTOobj.setTitle(title);		//
				nbDTOobj.setContant(contant);	//
				nbDTOobj.setWriter(writer);		//
				//ntBoardDAO
				boolean insertResult = ntBoardDAO.addNotice(nbDTOobj);
				

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
				
				NoticeBoardDTO nbDTOobj = new NoticeBoardDTO();
				nbDTOobj.setTitle(title);
				nbDTOobj.setContant(contant);
				nbDTOobj.setWriter(writer);
				nbDTOobj.setNbno(nbno);
				boolean r = ntBoardDAO.updateNotice(nbDTOobj);
				System.out.println("updateNotice ()실행결과"+r);
			}else if(num==5) {	//5.삭제
				System.out.printf("삭제할 글번호: ");
				int nbno = sc.nextInt();
				
				NoticeBoardDTO nbDTO = new NoticeBoardDTO(nbno);
				int resultRowCnt = ntBoardDAO.delNotice(nbDTO);
				System.out.println("resultCnt = "+resultRowCnt);
			}else if(num==6) {	//6.종료 -> 반복문 종료
				break;
			}else {
				System.out.println("기타. 잘못된 번호");
			}
		} // while 끝
		System.out.println("종료");
	}

}

