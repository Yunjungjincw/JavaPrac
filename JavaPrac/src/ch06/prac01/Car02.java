package ch06.prac01;
//이 클래스는 자동차설계도이다
/*클래스멤버
-field:데이터저장
[접근제한자] [제어자] 타입 필드명[=초기값];
-constructor:object생성method
[접근제한자] [제어자] 생성자명(arguments){}
-method:기능.동작
[접근제한자] [제어자] 리턴유형 메서드명(arguments){}

*/

/*다른 생성자 호출( this() ) - 교재p212
-생성자 오버로딩되면 생성자 간의 중복된 코드 발생
-초기화 내용이 비슷한 생성자들에서 이러한 현상을 많이 볼 수 있음
-초기화 내용을 한 생성자에 몰아 작성
-다른 생성자는 초기화 내용을 작성한 생성자를 this(…)로 호출
*/
public class Car02 {
	//field:데이터저장
		//전역변수는 타입에 따라 자동초기화가 된다
		String color; //색상
		String nation;//제조국가
		int price;	  //가격
		boolean isGas;//가스차량 false
		
		//constructor:object생성method
		//[접근제한자] [제어자] 생성자명(arguments){}
		Car02(){
			System.out.println("기본생성자호출");
		}
		
		//색상의 값을 받아서 필드초기화하는 생성자
		Car02(String color){ 
			this.color = color;
			//this는  이 클래스 객체의 참조변수
			//필드명이 매개변수명과 동일하면
			//반드시  this.필드명 사용
			//필드와 매개변수를 구분하기위해.
			System.out.println("String 1개인 생성자호출");
		}
		
		//this()
		//색상,제조국가의 값을 받아서 필드초기화하는 생성자
	//new Car02("white","한국")
		Car02(String color, String nation){
			
		 //Car02("red","대한민국",100);
	     //The method Car02(String, String, int) 
		 //is undefined for the type Car02
			this(color,nation,100);
			//Constructor call must be 
			//the first statement in a constructor
			//this()는 반드시 생성자내
			//반드시 첫 줄에 작성해야한다.
			
			//동일클래스내에서  생성자는 또 다른 생성자를 호출할수x
			//이 때는 this()를 사용해야 한다.
			//this.color=color;
			//this.nation=nation;
			System.out.println("c="+color);
			System.out.println("n="+nation);
		}
		
		//색상,제조국가,가격의 값을 받아서 필드초기화하는 생성자
		Car02(String color, String nation,int price){
			this(color, nation,price,true);
//			this.color=color;
//			this.nation=nation;
//			this.price=price;
		}
		
		//색상,제조국가,가격,가스차량의 값을 받아서 필드초기화하는 생성자
		Car02(String color, String nation,int price,boolean isGas){
			this.color=color;
			this.nation=nation;
			this.price=price;
			this.isGas=isGas;
		}
		
		
		
		
		
		
		//가격의 값을 받아서 필드초기화하는 생성자
		Car02(int price){
			this.price=price;
			System.out.println("int 1개인 생성자호출");
		}
		
		//가스차량 값을 받아서 필드초기화하는 생성자
		Car02(boolean isGas){
			this.isGas=isGas;
			System.out.println("boolean 1개인 생성자");
		}
		
		//method:기능.동작
		//[접근제한자] [제어자] 리턴유형 메서드명(arguments){}

}
