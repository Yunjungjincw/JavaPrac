package ch15.sec04.exam03;

import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
	public static void main(String[]args) throws IOException {
		Properties properties = new Properties();
	
	properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));
	// load => database.properties에서 Properties 로 저장을 해주는 역할
	
	String driver = properties.getProperty("driver");
	String url = properties.getProperty("url");
	String username = properties.getProperty("username");
	String password = properties.getProperty("password");
	String admin = properties.getProperty("admin");
	
	System.out.println("driver: "+ driver);
	System.out.println("url: "+ url);
	System.out.println("username: "+ username);
	System.out.println("password : "+ password);
	System.out.println("admin : "+ admin);
	
	}
}
	
