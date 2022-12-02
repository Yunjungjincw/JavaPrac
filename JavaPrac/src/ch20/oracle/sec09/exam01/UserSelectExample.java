package ch20.oracle.sec09.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSelectExample {

	public static void main(String[] args) {
	Connection conn = null;
			try {
				//JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
				Class.forName("oracle.jdbc.OracleDriver");
				
				//DB와 연결
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "qwe3776");
				System.out.println("연결 성공");
				
				
				//DB작업 매개변수화 된  insert 문
				String sql = "select userId, userName, userPassword,userAge, userEmail from users where userid=?";
						// toString이 문자열을 리턴해주니까 String sql에 넣을 수 있음.
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, "fall");
				//filenot exception 때문에 exception 만 잡아줌
			
				//반영된 행의 수를 리턴한다. 
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
//					String userId = rs.getString("userid");
//					String userName = rs.getString("userName");
//					String userPassword = rs.getString("userpassword");
//					int userAge = rs.getInt("userage");
//					String userEmail = rs.getString("useremail");
//					
//				
//					printUser(userId, userName, userPassword, userAge, userEmail);
				User user = new User();
				user.setUserId(rs.getString("userId"));
				user.setUserId(rs.getString("userName"));
				user.setUserId(rs.getString("userPassword"));
				user.setUserAge(rs.getInt("userAge"));
				user.setUserId(rs.getString("userEmail"));
				printUser(user);
				}else {
					System.out.println("사용자 아이디가 존재하지 않음");
				}
				rs.close();
				// executeUpdate() => 실행하는 코드
				
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(conn != null) {
					//null 일 경우 = 
					// 연결이 안되면 예외 발생 => null 인 상태 유지 => close 할 필요없음.
					
				
				//DB 연결 끊기
				try {
					conn.close();
				} catch (SQLException e) {
				}
				System.out.println("연결 끊김");
			}
		}
	}
	public static void printUser(String userId, String userName, String userPassword, int userAge, String userEmail) {
		System.out.println("userId : "+userId);
		System.out.println("userName : "+userName);
		System.out.println("userpassword : "+userPassword);
		System.out.println("userage : "+userAge);
		System.out.println("useremail : "+userEmail);
	}
	public static void printUser(User user) {
		System.out.println("userId : "+user.getUserId());
		System.out.println("userName : "+user.getUserName());
		System.out.println("userpassword : "+user.getUserPassword());
		System.out.println("userage : "+user.getUserAge());
		System.out.println("useremail : "+user.getUserEmail());
		System.out.println(user);
	}
	
}

