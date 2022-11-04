package ch06.sec06.exam01;

import ch06.Tire01;

public class CarEx01_수업자료 {
	//field-데이터 
		//필드=전역변수
		//[접근제어자] [제어자] 타입 필드명[=초기값];
		String 	color ="red"; //색상  
		int 	price =5000; //가격 
		String 	company="현대"; //제조회사
		int 	maxSpeed=250; //최고속도
		int		speed=0;     //현재속도-상태
		char	grade='A'; //등급
		String 	productDate="2022.11.02"; //생산일  "2022-11-02" Date클래스
		//Tire01 tire=null; //타이어
		//초기값을 null인 이유는?
		//클래스,배열타입의 자동초기값은 null때문
		//(heap영역의 주소가 아직 담기기전이라는 뜻)
		Tire01[] tires=  null;//타이어배열
		//Tire01타입을 배열로 선언한 이유는?
		//자동차의 타이어는 4개, 
		//각 타이어는 독립적이기 때문. 
		//예)앞왼쪽의 마모율과  뒤오른쪽의 마모율은 다를 수 있다
		
		
		//method-기능
		//[접근제어자] [제어자] 리턴유형 메서드명(){}
		//움직이다
		void move(){
			System.out.println("move()호출-움직이다");
		} 
		
		//멈춘다
		void stop(){
			System.out.println("stop()호출-멈춘다");
		}
		
	  	//왼쪽이동하다
		void turnLeft() { 
			System.out.println("turnLeft()호출-왼쪽으로 이동했어요");
		}
		//오른쪽이동이다
		void turnRight() { 
			System.out.println("turnRight()호출-오른쪽으로 이동");
		}
		//전진하다
		void turnFront() { 
			System.out.println("turnFront()호출-직진");
		}
		//후진하다
		void turnBack() { 
			System.out.println("turnBack()호출-띠리리라랄 후진");
		}
		//방향조절하다
		//void turn() { } 
		
		//가속하다
		void speedUp() {  
		  //현재속도가  최고속도이내라면 증가
		  //if(현재속도 < 최고속도) {
		    if(speed < maxSpeed) {	
				speed+=50;//speed=speed+50;
			}
		    if(speed==maxSpeed){ 
			 System.out.println("현재 이미 최고속도입니다");
			}
		    
			System.out.println("speedUp()-현재속도:"+speed);
		}
		//감속하다
		void speedDown() {
			speed-=50;  //speed=speed-50;
			if(maxSpeed<speed) {
	            System.out.println("speedDown()/ 경고! 현재속력: "
			    +(speed-(speed-maxSpeed))
			    +"km 빨리 속도를 줄이십시오. /");
	        }else if(speed<0){
	            System.out.println("더 이상 속도를 줄일 수 없습니다 ");
	        }else {
	            System.out.println("speedDown() / 현재속력: "
	            +speed+"km 제한 속도 규격에 맞습니다.");
	        }
		}

		//속도조절하다
		//매개변수가 있는 메서드(p216~)
		//메서드명(매개변수)
		//메서드명()괄호안에 들어가는 변수를 매개변수,argument,parameter라고 부른다
		//controlSpeed(int s)는  
		//외부에서  메서드를 호출할 때
		//int타입의 값 1개를 받아서
		//(메서드내부에서) 사용하겠다라는 뜻
		void controlSpeed(int s) {
			//만약  외부에서  controlSpeed(10)호출하면
			//정수 10은 int타입의 변수s에 저장된다
			
			//System.out.println("controlSpeed()진입");
			//speed+=1; //speed=speed+1;  //speed++;//호출될때마다 현재스피드가 1씩증가
			
			//argument  s에 저장된  값을 아래코드에서 사용
			//만약 5값이 들어오면 speed=speed+5;가 되어진다
			speed=speed+s; //호출될때마다 현재스피드가 5증가
			System.out.println("현재speed:"+speed);

		}
	}//class





	/*
	[접근제어자] [제어자] class 클래스명{

	  //field-데이터저장	
	  //[접근제어자] [제어자] 타입 변수명[=초기값];

	  //method-동작.기능
	  //[접근제어자] [제어자] 리턴유형 메서드명(){}
	}
	 */
