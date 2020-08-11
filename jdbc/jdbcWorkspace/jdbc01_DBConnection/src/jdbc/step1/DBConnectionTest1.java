package jdbc.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * JDBC 작업 4단계
 * 
 * 1. 드라이버를 로딩...(클라이언트 메모리단에 올려놔야 붙음)
 * 
 * 2. DB서버와 연결... 
 *    jdbc:mysql: // 앞에는 jdbc 프로토콜 이름. 뒤에는 ip 어드레스
 *    ip:3306 // 가상의 포트를 쓰면 안 됨. 제공되는 포트가 있음. mySQL은 3306이고 오라클은 1521
 *    /scott 우리가 작업한 스키마. 스키마까지 연결.
 *    conn 반환
 *    
 * 3. query를 준비시킴...
 * 	  PreparedStatement st = conn.prepareStatement("sql query");
 * 
 * 4. 값이 바인딩 + 쿼리문이 실행 -- 실제로 DB서버에 값이 추가/삭제/수정/가지고옴
 *    1) 쿼리문 실행하기 전에 ?에 해당하는 값을 먼저 바인딩
 *    2) 쿼리문 실행
 *    st.executeUpdate() : int 타입 리턴 --- insert/delete/update
 *    st.executeQuery() : ResultSet 타입 리턴 --- select
 */
public class DBConnectionTest1 {// 얘가 클라이언트 사이드.
	
	public DBConnectionTest1() {
		// Class.forName("Driver");
		// 이러면 못 찾음. 현재 위치 jdbc.step1 폴더 안에서 찾음. 
		// 패키지명을 포함한 전체 이름인 FQCN(Full Qualified Class Name)으로 지정해야 함.
		try {
			//1.
			Class.forName("com.mysql.cj.jdbc.Driver"); //FQCN
			System.out.println("Driver Loading Sucess!!...");
			
			//2.
			String url = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
			Connection conn = DriverManager.getConnection(url, "root", "1234");
			// 보통 conn으로 쓰는 게 convention(관례)
			System.out.println("DB Connction...");
			
			//3.
			String query = "INSERT INTO person(ssn, name, address) VALUES(?,?,?)"; // 값은 실행할 때 넣을 것
			PreparedStatement st = conn.prepareStatement(query);
			System.out.println("Creating PreparedStatement.....");
			// 값이 들어간 건 아니고 값을 받을 쿼리문만 준비한 것.
			
			//4.
			st.setInt(1, 111); // 1은 첫번째 물음표에 해당
			st.setString(2, "박나래"); // 1은 첫번째 물음표에 해당
			st.setString(3, "여의도"); // 1은 첫번째 물음표에 해당
			
			int row = st.executeUpdate();
			System.out.println(row+"명 추가됨!!")
			;
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Fail....");
		} catch (SQLException e) {
			System.out.println("DBConnection Fail....");
		}
	}
	
	public static void main(String[] args) {
		new DBConnectionTest1();
	}

}
