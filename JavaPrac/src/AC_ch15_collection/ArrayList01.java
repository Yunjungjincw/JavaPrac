package AC_ch15_collection;


//java.lang 패키지를 제외한 그 외 패키지는 import 해야한다.
//Object 클래스,  wrapper 클래스 ...
import java.util.ArrayList;
import java.util.Date;

/*
 * Collection Framework(컬렉션 프레임워크)
 * -3가지 인터페이스
 * List:   순서o, 중복o 예)대기자 list
 * Set:   순서x, 중복x
 * Map:   Key와 value가 한 pair
 * 		  key는 중복허용x
 * 		  value는 중복허용
 */
public class ArrayList01 {
	public static void main(String[] args) {
//		java.util.ArrayList list =
//				new java.util.ArrayList();
		
		ArrayList list = new ArrayList();
		System.out.println(list);
		System.out.println(list.toString());
		
		
		//리스트안에 저장된 요소 (item)의 개수를 리턴
		//참고> length: 배열(array)에 저장된 요소(item)의 개수를 리턴 
		//size : Returns the number of elements in this list.
		int size = list.size();
		//배열에서의 length는 속성 -----------> size 메소드 
		System.out.println("Array size: "+size); // 0 
		
		//value 추가 
		//List에는 다양한 타입의 value을 추가할 수 있음.
		// 배열> 배열(array)에는 동일한 타입의 value을 추가. ( String, int , double, boolean, date ?, char ...)
		list.add("이렇게긴 이름을 봤나.");
		list.add(new String("서울시 강남구"));
		list.add("hid");
		list.add(20);
		list.add(179.3);
		list.add('남');
		list.add(true);
		list.add(new Date()); // Date(현재 날짜와 시간 객체 생성) = > java.lang 패키지를 제외한 그 외 패키지는 import 해야한다. 
		int result = list.size();
		System.out.println("Array size: "+result);
		System.out.println(list);
		
		// 특정위치에 있는 요소 (item, element)를 가져오기
		//get(인덱스)
		Object obj = list.get(0);
		System.out.println("이름: "+obj);
		System.out.println(obj);
		
		// String으로 내려가는 다운캐스팅을 해줘야, obj의 index를 뽑을 수 있음.
		//(강제 형변환) 변수
		//여기에서는 String으로 강제 형변환하여
		//String 클래스의 length()메서드를 호출하였다.
		//Object에는 length()메서드가 없기 때문.
		System.out.println("---------");
		String strObj = (String)obj;
		System.out.println(strObj.length()); //글자길이
		
		
	
		System.out.println("---------");
		Object obj2 = list.get(1);
		System.out.println("주소 길이: "+((String)obj2).length());
		
		String strObj2 = (String)obj2;
		System.out.println(strObj2.length());
		System.out.println();
//		String strObj2 = (String)obj;
//		System.out.println(strObj2.length());
		System.out.println("---------");
		
		
		//인덱스 4,5,6,7 에 담긴 value는 
		//Object타입의 변수date4에 저장 후 출력
		//instanceof 클래스명 : 특정 클래스의 객체이면 true리턴
		
		
		Object obj4 = null;
		String type = "";
		for(int i =3; i<7; i++) {
			obj4=list.get(i);
			if(obj4 instanceof Integer) {
			type="정수:";
		} else if (obj4 instanceof Double){
			type="실수 :";
		} else if (obj4 instanceof Character) {
			type="Character: ";
		} else if (obj4 instanceof Boolean) {
			type="Boolean: ";
		}
			System.out.println(obj4);
	}
		
		
		
		
		
		
		
		
		
		
		
	}
}
