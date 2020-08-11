package jdbc.step3;
/*
 * 문제점
 * STEP2에서는 디비서버에 대한 정보가 프로그램상에 하드코딩 되어져 있다.
 * 
 * 해결책 
 * 별도의 모듈에 디비서버에 대한 정보를 뽑아내어서 별도로 처리
 * 메타데이터화 시킨다. (가장 세련된 방법이 XML. 최종적으로는 XML로 갈 것)
 * 인터페이스 - Properties 파일 - XML
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import query.PersonSQL;
import config.ServerInfo;

public class DBConnectionTest1 {
	public DBConnectionTest1() throws ClassNotFoundException, SQLException {
		//1. 드라이버 로딩
		Class.forName(ServerInfo.DRIVER_NAME); //Driver FQCN
		System.out.println("Driver Loading....");
		
		//2. 디비연결..getConnection
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("디비연결 성공...");
		
		//3. 쿼리준비... prepareStatement()
		//select.... 모든 레코드를 다 가져온다.
		PreparedStatement st = conn.prepareStatement(PersonSQL.ALL_PERSON);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) { 
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