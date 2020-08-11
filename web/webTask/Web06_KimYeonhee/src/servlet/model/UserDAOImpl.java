package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import config.ServerInfo;

public class UserDAOImpl implements UserDAO {
		
		/*//단위 테스트용 DriverManager 코드
		private static UserDAOImpl dao = new UserDAOImpl();
		private UserDAOImpl() {
			try {
				Class.forName(ServerInfo.DRIVER_NAME);
				System.out.println("드라이버 로딩 성공...");
				
			}catch(ClassNotFoundException e) {
				System.out.println("드라이버 로딩 실패...");
			}
		}
		
		public static UserDAOImpl getInstance() {
			return dao;
		}
		@Override
		public Connection getConnection() throws SQLException {		
			System.out.println("디비연결 성공....");
			return DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER, ServerInfo.PASS);
		}*/
	
	private DataSource ds;
	private static UserDAOImpl dao = new UserDAOImpl();
	private UserDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource lookup 성공...");
		} catch (NamingException e) {
			System.out.println("DataSource lookup 실패...");
		}
	}
	public static UserDAOImpl getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("DB 연결 성공....");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void registerUser(UserVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn =  getConnection();
			String query = "INSERT INTO userinfo(userId, password, name, email) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성...registerMember");
			
			ps.setString(1, vo.getUserId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getEmail());
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		}finally{
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<UserVO> showAllUser() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT * FROM userinfo";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new UserVO(rs.getString("userId"), 
									rs.getString("password"), 
									rs.getString("name"), 
									rs.getString("email")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public UserVO findByIdUser(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM userinfo WHERE userId=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new UserVO(userId,
								rs.getString("password"),
								rs.getString("name"),
								rs.getString("email"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	
	public UserVO login(String userId, String password) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM userinfo WHERE userid=? AND password=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new UserVO(userId, password, rs.getString("name"), rs.getString("email"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	
	/*//단위 테스트는 DriverManager 방식이다. DataSource는 안 됨.
	//하지만 나중에 스프링, 프레임워크까지 가면 DataSource도 단위 테스트가 다 된다.
	public static void main(String[] args) throws SQLException {
		UserDAOImpl dao = UserDAOImpl.getInstance();
		dao.registerUser(new UserVO("user1","1234","회원1","user1@encore.com"));
		dao.registerUser(new UserVO("user2","1234","회원2","user2@encore.com"));
		dao.registerUser(new UserVO("user3","1234","회원3","user3@encore.com"));
		for(UserVO u : dao.showAllUser()) {
			System.out.println("아이디 : "+u.getUserId());
			System.out.println("비밀번호 : "+u.getPassword());
			System.out.println("이름 : "+u.getName());
			System.out.println("이메일 : "+u.getEmail());
		}
		dao.findByIdUser("user1").getName();
		dao.login("user1", "1234").getEmail();
	}*/

}
