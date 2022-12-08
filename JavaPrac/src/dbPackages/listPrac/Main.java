package dbPackages.listPrac;

import java.util.List;
import java.util.Scanner;

//메인클래스
//web에서는 불필요한 부분

public class Main {

	public static void main(String[] args) {
		NoticeBoardDAO ntBoardDAO = new NoticeBoardDAO(); //DAO객체생성
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println();//빈줄
			System.out.println();//빈줄
			System.out.println("--1.목록조회   2.상세조회   3.등록   4.수정   5.삭제   6.종료");
			System.out.print("원하는 메뉴번호를 입력하세요:");
			int num=sc.nextInt();//Scans the next token of the input as an int.
			
			if(num==1) { //1.목록조회
				List<NoticeBoardDTO> ntDTOList=ntBoardDAO.getNoticeList();
				System.out.println("ntDTOList="+ntDTOList.toString());
				
				System.out.println("총 게시글수:"+ntDTOList.size());
				
				for(int i=0;i<ntDTOList.size() ;i++) {
					System.out.println( ntDTOList.get(i) );
				}
				
				
			}else if(num==2) {//2.상세조회
				System.out.print("조회할 글번호:");
				int nbno=sc.nextInt();//user로 부터 글번호 입력받아 nbno에 저장
				
				//NoticeBoardDTO 객체를 생성하려면 생성자가 있어야 됨
				ntBoardDAO.getNotice(new NoticeBoardDTO(nbno));
				
				
				//콘솔에 리턴받은 NoticeBoardDTO객체내용을 출력
//				System.out.println("리턴받은 NoticeBoardDTO="+resultNTDTO);//주소
//				
//				//SELECT nbno,title,contant,cre_date,writer,rcnt,empno 
//				System.out.println("--아래는 특정글번호의 상세내용이 컬럼별 한줄로 출력");
//				System.out.println("nbno컬럼값:"+resultNTDTO.getNbno());
//				System.out.println("title컬럼값:"+resultNTDTO.getTitle());
//				System.out.println("contant컬럼값:"+resultNTDTO.getContant());
//				System.out.println("cre_date컬럼값:"+resultNTDTO.getCre_date());
//				System.out.println("writer컬럼값:"+resultNTDTO.getWriter());
//				System.out.println("rcnt컬럼값:"+resultNTDTO.getRcnt());
//				System.out.println("empno컬럼값:"+resultNTDTO.getEmpno());
//				System.out.println("------------까지");
				
				
			}else if(num==3) {//3.등록
				System.out.println("등록정보를 입력하세요");
				System.out.print("제목:");
				String title=sc.next();
				System.out.print("내용:");
				String contant=sc.next();
				System.out.print("작성자:");
				String writer=sc.next();
				
				//NoticeBoardDTO타입의 객체를 생성해서 제시하자
				NoticeBoardDTO nbDTOobj=new NoticeBoardDTO();
				//user로 부터 입력받은 제목,내용,작성자를
				//NoticeBoardDTO의 setter를 호출하여 설정한 후 
				nbDTOobj.setTitle(title);
				//nbDTOobj 참조변수를 이용 근데 nbDTOobj 참조변수는 생성자를 통해서 만들어졌음. 
				//setter의 기능이 정확이 뭔데 
				// => 
				nbDTOobj.setContant(contant);
				nbDTOobj.setWriter(writer);
				//ntBoardDAO.addNotice()를 호출하면서 넘기자
				boolean insertResult=ntBoardDAO.addNotice(nbDTOobj);
				
			}else if(num==4) {//4.수정
				System.out.println("수정정보를 입력하세요");
				System.out.print("수정할 글번호:");
				int nbno=sc.nextInt();
				System.out.print("제목:");
				String title=sc.next();
				System.out.print("내용:");
				String contant=sc.next();
				System.out.print("작성자:");
				String writer=sc.next();
				//boolean r=ntBoardDAO.updateNotice(nbno,title,contant,writer);
				
				//외부에서   클래스명 참조변수=new 클래스명();
				NoticeBoardDTO nbDTOobj=new NoticeBoardDTO();
				//필드값을 설정해서 ntBoardDAO의   updateNotice()호출시 넘긴다
				nbDTOobj.setNbno(nbno);
				nbDTOobj.setTitle(title);
				nbDTOobj.setContant(contant);
				nbDTOobj.setWriter(writer);
				
				
				boolean r=ntBoardDAO.updateNotice(nbDTOobj);
				//업데이트성공하면 true리턴, 업데이트실패하면 false리턴
				System.out.println("updateNotice()실행결과="+r);
				
			}else if(num==5) {//5.삭제
				System.out.print("삭제할 글번호:");
				int nbno=sc.nextInt();//user로 부터 글번호 입력받아 nbno에 저장
				int resultRowCnt=ntBoardDAO.delNotice(nbno);
				System.out.println("resultRowCnt="+resultRowCnt);
				
			}else if(num==6) {//6.종료
				break; //반복문종료
			}else {
				System.out.println("기타-잘못된 번호");
			}
			
		}//while
		System.out.println("종료합니다...");
		
	}

}



