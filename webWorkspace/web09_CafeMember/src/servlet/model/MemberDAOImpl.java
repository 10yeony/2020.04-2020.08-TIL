package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class MemberDAOImpl implements MemberDAO{
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패...."); 
		}
	}
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("Database Connection......");
		return conn;
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
	public void registerMember(MemberVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO member(id,password,name,address) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());
			ps.executeUpdate();
			System.out.println(vo.getName()+"님이 정상적으로 회원 등록되었습니다.");
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<MemberVO> temp = new ArrayList<>();
		
		try {
			conn = getConnection();
			String sql = "SELECT id, password, name, address FROM member";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				temp.add(new MemberVO(rs.getString("id"),rs.getString("password"),rs.getString("name"),rs.getString("address")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return temp;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		MemberVO temp = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT password, name, address FROM member WHERE id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				temp = new MemberVO(id, rs.getString("password"), rs.getString("name"), rs.getString("address"));
			}
			
		}finally {
			closeAll(rs, ps, conn);
		}
		return temp;
	}
	
	public static void main(String[] args) throws SQLException {
		//실행으로 돌려봄.
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		//dao.registerMember(new MemberVO("abc", "123", "Lala", "Seoul"));
		//dao.registerMember(new MemberVO("def", "456", "TT", "NY"));
		//dao.registerMember(new MemberVO("ghi", "789", "DD", "Taipei"));
		for(MemberVO m : dao.showAllMember()) {
			System.out.println(m.toString());
		}
		System.out.println(dao.findByIdMember("ghi").toString());
	}
}
