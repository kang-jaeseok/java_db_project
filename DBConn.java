package rent_car_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	// 싱글톤패턴: 인스턴스를 하나만 생성해서 재사용
	private static Connection conn = null;
	// 컨넥션을 리턴하는 메소드
	public static Connection getConn() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String passwd = "hr";
		try {
			// 만약 컨넥션 객체가 널이라면
			if (conn == null || conn.isClosed()) {

				Class.forName("oracle.jdbc.driver.OracleDriver");
				// System.out.println("Loading complete");
				conn = DriverManager.getConnection(url, user, passwd);
				// System.out.println("Connection Success");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver does not exist.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection fail");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 접속 실패 시 종료

		return conn;
	}
	//접속해제 메소드
	public static void dbClose() {
		try {
			if(conn != null && !conn.isClosed()) {
				System.out.println("DB 연결 해제");
				conn.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
