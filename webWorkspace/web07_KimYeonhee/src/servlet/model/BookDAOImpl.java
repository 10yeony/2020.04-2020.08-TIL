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

public class BookDAOImpl implements BookDAO {
	
	/*//단위 테스트용 DriverManager 코드
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패...");
		}
	}
	
	public static BookDAOImpl getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {		
		System.out.println("디비연결 성공....");
		return DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER, ServerInfo.PASS);
	}*/
	
	private DataSource ds;
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource lookup 성공...");
		} catch (NamingException e) {
			System.out.println("DataSource lookup 실패...");
		}
	}
	public static BookDAOImpl getInstance() {
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
	public void registerBook(BookVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn =  getConnection();
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO book(isbn, title, catalogue, nation,");
			query.append("publish_date, publisher, author, price, currency, description)");
			query.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps = conn.prepareStatement(query.toString());
			System.out.println("PreparedStatement 생성...registerMember");
			
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getCatalogue());
			ps.setString(4, vo.getNation());
			ps.setString(5, vo.getPublishDate());
			ps.setString(6, vo.getPublisher());
			ps.setString(7, vo.getAuthor());
			ps.setString(8, vo.getPrice());
			ps.setString(9, vo.getCurrency());
			ps.setString(10, vo.getDescription());
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		}finally{
			closeAll(ps, conn);
		}
		
	}

	@Override
	public ArrayList<BookVO> showAllBook() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT * FROM book";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new BookVO(rs.getString("isbn"), 
									rs.getString("title"), 
									rs.getString("catalogue"), 
									rs.getString("nation"), 
									rs.getString("publish_date"), 
									rs.getString("publisher"), 
									rs.getString("author"), 
									rs.getString("price"), 
									rs.getString("currency"), 
									rs.getString("description")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public BookVO findByIsbnBook(String isbn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BookVO vo = null;
		try {
			conn = getConnection();
			String query = "SELECT * FROM book WHERE isbn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, isbn);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new BookVO(isbn,
								rs.getString("title"),
								rs.getString("catalogue"),
								rs.getString("nation"),
								rs.getString("publish_date"),
								rs.getString("publisher"),
								rs.getString("author"),
								rs.getString("price"),
								rs.getString("currency"),
								rs.getString("description"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	
	public ArrayList<BookVO> findByTitleBook(String title) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookVO> list = new ArrayList<>();
		title = "%" + title + "%";
		try {
			conn = getConnection();
			String query = "SELECT * FROM book WHERE title LIKE ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new BookVO(rs.getString("isbn"),
									rs.getString("title"),
									rs.getString("catalogue"),
									rs.getString("nation"),
									rs.getString("publish_date"),
									rs.getString("publisher"),
									rs.getString("author"),
									rs.getString("price"),
									rs.getString("currency"),
									rs.getString("description")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<BookVO> findByPublisherBook(String publisher) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT * FROM book WHERE publisher=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, publisher);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new BookVO(rs.getString("isbn"),
									rs.getString("title"),
									rs.getString("catalogue"),
									rs.getString("nation"),
									rs.getString("publish_date"),
									publisher,
									rs.getString("author"),
									rs.getString("price"),
									rs.getString("currency"),
									rs.getString("description")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<BookVO> findByPriceBook(String price) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookVO> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT * FROM book WHERE price=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, price);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new BookVO(rs.getString("isbn"),
									rs.getString("title"),
									rs.getString("catalogue"),
									rs.getString("nation"),
									rs.getString("publish_date"),
									rs.getString("publisher"),
									rs.getString("author"),
									price,
									rs.getString("currency"),
									rs.getString("description")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	/*public static void main(String[] args) throws SQLException {
		BookDAOImpl dao = BookDAOImpl.getInstance();
		dao.registerBook(new BookVO("111-111-111","재미있는 책1","운영체제","국내도서","2019-08-18","엔코아","김00",20000,"원","재미있음~~~"));
		dao.registerBook(new BookVO("222-222-222","재미있는 책3","데이터베이스","외국도서","2020-06-08","이지스퍼블리싱","이00",30,"달러","비싸지만 재미있음~~~"));
		for(BookVO s : dao.showAllBook()) {
			System.out.println("isbn : "+s.getIsbn());
			System.out.println("제목 : "+s.getTitle());
			System.out.println("국가 : "+s.getNation());
			System.out.println("가격 : "+s.getPrice());
		}
		System.out.println("작가 : "+dao.findByIsbnBook("111-111-111").getAuthor());
	}*/
	
}
