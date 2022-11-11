package ch06_혼자학습;

public class Animal01 {
	String type;
	String weight;
	
	Animal01(){
	}
	public Animal01(String type, String weight) {
		this.type = type;
		this.weight = weight;
	}
	
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public void eat() {
		System.out.println("먹는다");
	}
	public void sleep() {
		System.out.println("잔다");
	}
	public String sound() {
		return "소리소리소리~~~";
	}

}


 class Dog01 extends Animal01{
	 
	 
	 public Dog01 (String type, String weight) {
		 	this.type = type;
			this.weight = weight;
	 }
	 
	 
	 
	 @Override
	public String sound() {
		return "Dog01 [sound()=" + sound() + "]";
	}



	public void protect() {
		 System.out.println("보호한다");
	 }
	 
 }
 
 
 class Bird extends Dog01{
	 
	 
	 
	 public Bird(String type, String weight) {
		super(type, weight);
	}

	@Override
	public String sound() {
		return "Bird [sound()=" + sound() + "]";
	}

	public void fly() {
		 System.out.println("난다");
	 }
 }
