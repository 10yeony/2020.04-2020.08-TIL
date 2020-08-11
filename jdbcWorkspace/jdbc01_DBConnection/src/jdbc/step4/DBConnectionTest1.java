package jdbc.step4;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/*
 * 실제값들의 메타데이터
 * 인터페이스 --> properties!!!!
 * 자바 진영에서 굉장히 중요한 기술. properties 파일. 손에서 절대로 놓치지 않는 기술.
 * 
 * properties는 결국 Map의 자식. key-vaule 방식으로 저장. 
 * 보통 값은 object 타입인데 얘는 값이 String. (왜? 메타데이터로 쓰는 것!)
 */

public class DBConnectionTest1 {
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		p.load(new FileInputStream("src/config/db.properties")); 
		// File System은 src부터 시작. 클래스는 src를 먹고 들어감.
		
		String driver = p.getProperty("jdbc.mysql.driver"); // 변수명이랑 맞춤.
		String url = p.getProperty("jdbc.mysql.url");
		String user = p.getProperty("jdbc.mysql.user");
		String pass = p.getProperty("jdbc.mysql.pass");
		
		String insert = p.getProperty("jdbc.sql.insert");
		String delete = p.getProperty("jdbc.sql.delete");
		String update = p.getProperty("jdbc.sql.update");
		String select = p.getProperty("jdbc.sql.select");
		String selectAll = p.getProperty("jdbc.sql.selectAll");
		
		Class.forName(driver);
		System.out.println("1. 드라이버 로딩 성공");
		
		Connection conn = DriverManager.getConnection(url, user, pass);
		System.out.println("2. 디비연결 성공....");
		
		PreparedStatement st = conn.prepareStatement(selectAll);
		System.out.println("3. PreparedStatement 생성...");
		
		System.out.println("4. Query 실행....");
		ResultSet rs = st.executeQuery();
		while(rs.next()) System.out.println(rs.getString("name")+","+rs.getString("address"));
	}
}