package jdbc.step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest1 {
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	public static final String USER = "root";
	public static final String PASS = "1234";
	public DBConnectionTest1() throws ClassNotFoundException, SQLException {
		//1. 드라이버 로딩
		Class.forName("com.mysql.cj.jdbc.Driver"); //Driver FQCN
		System.out.println("Driver Loading....");
		
		//2. 디비연결..getConnection
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		System.out.println("디비연결 성공...");
		
		//3. 쿼리준비... prepareStatement()
		/*String query = "INSERT INTO person(ssn, name, address) VALUES(?,?,?)";
		PreparedStatement st = conn.prepareStatement(query);
		System.out.println("PreparedStatement 생성 성공...");
		
		//4. ?에 값을 바인딩하고 | 쿼리문 실행
		st.setInt(1, 333);
		st.setString(2, "정우성");
		st.setString(3, "혜화동");
		// 같은 내용으로 콘솔 실행 또 하면 에러남. 이미 추가됐기 때문.
		
		System.out.println(st.executeUpdate()+"명 추가됨");*/
		
		// delete... 333번을 삭제
		/*String query = "DELETE FROM person WHERE ssn=?"; // 값은 주는 게 아니라 나중에 때려넣는 것.
		PreparedStatement st = conn.prepareStatement(query);
		System.out.println("PreparedStatement 생성....");
		
		st.setInt(1, 333);
		System.out.println(st.executeUpdate()+"명 삭제!!!");*/ // 삭제 에러남 다시 확인하기
		
		//update... 111번에 대한 정보를 수정
		/*String query = "UPDATE person SET name=?, address=? WHERE ssn=?";
		PreparedStatement st = conn.prepareStatement(query);
		System.out.println("PreparedStatement 생성....");
		
		st.setString(1, "박나리");
		st.setString(2, "서초동");
		st.setInt(3, 111); // 물음표 순서에 따라
		System.out.println(st.executeUpdate()+"명 수정!!!");*/
		
		//select.... 모든 레코드를 다 가져온다.
		String query = "SELECT ssn, name, address FROM person"; 
		PreparedStatement st = conn.prepareStatement(query);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) { // 한번씩 내려옴...
			int ssn = rs.getInt("ssn"); //컬럼명을 직접 써줌. 정확도가 조금 더 높음.
			// int ssn = rs.getInt(1); 이렇게 써줘도 되긴 함. 1번째 컬럼.
			String name = rs.getString("name");
			String addr = rs.getString("address");
			System.out.println(ssn+","+name+","+ addr);
		}
		
		//5. 자원 반납.... 자원을 열어서 사용한 순서 반대로 닫는다...
		st.close();
		conn.close();
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		new DBConnectionTest1();
	}

}
/*
 * ::: 이 프로그램의 문제점 :::
 * 비즈니스 로직. DB 집적거리는 로직. 
 * 이런 로직에 실제 값이 하드코딩 되어지는 건 현업에 없음. 
 * DB 주소 뻔히 나옴. ip주소 하드코딩 되어지는 일 없음. root, 1234 이렇게 직접 때려넣는 경우 없음. 
 * 
 * 프로그램에는 변수가 들어가는 것. 
 * 직접적인 값을 넣는 게 아니라 분리시켜야 함.
 * 외부 자원으로 모듈화 시켜야 함.
 * MetaData화 시켜야 함.
 * MetaData는 특정한 정보. 이런 메타데이터는 주로 엑셀로 만듦.
 */