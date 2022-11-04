package ch06.sec06.exam01;

public class Human_Main03_1104 {
	public static void main(String[] args) {
		//클래스타입 참조변수명 = new 클래스명();
		//new human
		Human03_1104 human = new Human03_1104();
		System.out.println("기본 생성자 이용 : object 생성");
		System.out.println("참조변수 "+human);
		System.out.println("참조변수 "+human.toString());

		//참조변수 선언 및 클래스 객체 생성
		
			System.out.println("--------첫 번째 필드값-------");
				String name = human.name;			System.out.println("이름:"+name);
				char sex = human.sex;				System.out.println("성별: "+sex);
				String job = human.job;				System.out.println("직업: "+ job);
				int old = human.old;				System.out.println("나이: "+old);
				String nation = human.nation;		System.out.println("나라: "+ nation);
				String position = human.position;	System.out.println("포지션: "+position);
				double height = human.height;		System.out.println("신장: "+height);
				System.out.println();
				System.out.println();

		//매개변수가 있는 생성자를 이용하여 객체생성
				Human03_1104 human2 = new Human03_1104("손흥민");
				
				System.out.println("--두번째----매개변수가 있는 생성자 : object 생성");
				System.out.println("human2 참조변수 "+human);
				
				name = human2.name;				System.out.println("이름:"+name); //null
				sex = human2.sex;				System.out.println("성별: "+sex); // x
				job = human2.job;				System.out.println("직업: "+ job); //null
				old = human2.old;				System.out.println("나이: "+old); //31
				nation = human2.nation;			System.out.println("나라: "+ nation);//29
				position = human2.position;		System.out.println("포지션: "+position);//null
				height = human2.height;			System.out.println("신장: "+height);//
				System.out.println();
				System.out.println();
				
				
				System.out.println("-3번째--char1 개인생성자이용 객체생성---");
				Human03_1104 human3 = new Human03_1104('ㅈ');
				name = human3.name;System.out.println("이름:"+name); //null
				sex = human3.sex;System.out.println("성별: "+sex); // 남
				job = human3.job;System.out.println("직업: "+ job); //null
				old = human3.old;System.out.println("나이: "+old); //31
				nation = human3.nation;System.out.println("나라: "+ nation);//29
				position = human3.position;System.out.println("포지션: "+position);//null
				height = human3.height;System.out.println("신장: "+height);//
				System.out.println();
				System.out.println();
				
				
				
			System.out.println("---4번째-----모르겠다---------");
			Human03_1104 human4 = new Human03_1104(18);
			name = human4.name;			System.out.println("이름:"+name);
			sex = human4.sex;			System.out.println("성별: "+sex);
			job = human4.job;			System.out.println("직업: "+ job);
			old = human4.old;			System.out.println("나이: "+old);
			nation = human4.nation;		System.out.println("나라: "+ nation);
			position = human4.position;	System.out.println("포지션: "+position);
			height = human4.height;		System.out.println("신장: "+height);//
			System.out.println();
			System.out.println();
				
			Human03_1104 human5 = new Human03_1104("윤정진", '남', "백수", 30, "대한민국", "포워드", 179.8);
			name = human5.name; 		System.out.println("이름:"+name); //null
			sex = human5.sex;   		System.out.println("성별: "+sex); // 남
			job = human5.job;   		System.out.println("직업: "+ job); //null
			old = human5.old;			System.out.println("나이: "+old); //31
			nation = human5.nation; 	System.out.println("나라: "+ nation);//29
			position = human5.position;	System.out.println("포지션: "+position);//null
			height = human5.height;		System.out.println("신장: "+height);//
			System.out.println();
			System.out.println();
	}
	
}
