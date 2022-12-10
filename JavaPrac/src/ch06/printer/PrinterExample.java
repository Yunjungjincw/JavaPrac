package ch06.printer;

public class PrinterExample {

	public static void main(String[] args) {
		Printer printer = new Printer();
	
		printer.println(10);
		printer.println(5.7);
		printer.println("홍길동");
		printer.println(false);
	}

}
