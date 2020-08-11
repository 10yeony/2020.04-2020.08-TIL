package jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

public class TXCommitTest1 {
	//TX = Transaction
	public static void main(String[] args) throws Exception {
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("Driver Loading...");
		
		Connection conn = 
				DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DBServer Connection...");
		
		String query1 = "INSERT INTO encore (name) VALUES(?)";
		String query2 = "SELECT no, name FROM encore WHERE no=?";
		
		//트랜잭션 시작...
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement(query1);
		ps.setString(1, "전지현");
		ps.executeUpdate();
		
		//no 7에 해당하는 레코드가 존재하지 않는다.... 실패... rollback
		//no 7에 해당하는 레코드가 존재하면.... 성공... commit 
		PreparedStatement ps2 = conn.prepareStatement(query2);
		ps2.setInt(1, 4); 
		// 테이블에 레코드가 3개 있고 위에서 추가한 레코드가 4번째라면
		// 레코드가 존재하지 않는 게 되어서 롤백됨.
		// 왜냐하면 트랜잭션 처리해서 한 묶음이 되었고 커밋이 안 되었기에 아직 전지현이 추가 안 됨
		ResultSet rs = ps2.executeQuery();
		
		if(!rs.next()) {//레코드가 존재하지 않는다면...
			conn.rollback();
			System.out.println("찾는 번호에 해당하는 회원이 없어서 rollback!!! ");
		}else {//레코드가 존재한다면...
			conn.commit();
			System.out.println("번호에 해당하는 회원 발견 commit!!!");
		}
		
		// 트랜잭션 처리를 다시 원래대로 돌려놓음
		conn.setAutoCommit(true);
	}

}
