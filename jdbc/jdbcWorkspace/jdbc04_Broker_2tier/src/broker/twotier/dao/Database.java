package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class Database implements DatabaseTemplate{
	public Database(String serverIP) throws ClassNotFoundException{
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩 성공...");
	}
	//공통적인 로직...
	@Override
	public Connection getConnect() throws SQLException {
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
	public boolean isExist(String ssn, Connection conn) throws SQLException{
		// 리턴타입을 int로 해도 되지만
		// 조금 더 코드를 줄일 수 있는 방법은 리턴타입을 boolean으로 하는 것.
		// 프로그램에서 존재 유무를 확인할 수도 있지만 db에서도 존재 유무를 확인할 수 있음.
		String sql = "SELECT ssn FROM customer WHERE ssn = ?";	
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, ssn);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	@Override
	public boolean isExistStock(String symbol, Connection conn) throws SQLException{
		String sql = "SELECT symbol FROM stock WHERE symbol = ?";	
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, symbol);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	@Override
	public int numOfStock(String ssn, String symbol, Connection conn) throws SQLException{
		String sql = "SELECT quantity FROM shares WHERE ssn =? AND symbol = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, ssn);
		ps.setString(2, symbol);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getInt(1); // 컬럼명 안 적어도 됨. 어차피 1 row 1 column이라서 스칼라 값
		}
		return -1;
	}
	
	
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		// 가독성을 위해 예외는 잡지 않고 주로 던지고 메인에서 처리함
		// 예외는 던지니까 catch 안 쓰고 
		// 예외 발생 여부와 무관하게 어떻게든 자원 종료시키기 위해 try ~ finally 씀.
		
		try {
			// 연결만 시켜놓고 쿼리문 나오기 전에
			// 존재 유무를 확인해야 한다. 네가 추가하려는 게 이미 테이블에 있는지 없는지...
			// Customer 클래스의 getCustomer() 메소드 써도 되긴 하지만 ssn만 있는지 없는지 확인하면 됨 
			// 더 세련된 코드를 짜려면 위에 따로 공통적인 로직으로 뽑는 게 좋음.
			
			conn = getConnect();
			if(!isExist(cust.getSsn(), conn)) {//ssn이 없는 것
				String query = "INSERT INTO customer(ssn, cust_name, address) VALUES(?, ?, ?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());

				System.out.println(ps.executeUpdate()+" 명 INSERT OK.... addCustomer()...");
			}else { // ssn이 있는 것...
				throw new DuplicateSSNException(cust.getName()+" 님은 이미 회원이십니다...");
			}
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(isExist(ssn, conn)) {
				String query = "DELETE FROM customer WHERE ssn = ?";
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);
				ps.executeUpdate();
				System.out.println("회원탈퇴가 완료되었습니다.");
			}else {
				throw new RecordNotFoundException("존재하지 않는 회원입니다.");
			}
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "UPDATE customer SET cust_name=?, address=? WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, cust.getName());
			ps.setString(2, cust.getAddress());
			ps.setString(3, cust.getSsn());
			int row = ps.executeUpdate();
			
			if(row==1) System.out.println(cust.getName()+" 님의 정보가 수정되었습니다.");
			else throw new RecordNotFoundException("존재하지 않는 회원입니다.");
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	// Customer에게 Vector라는 필드를 뽑아낼 수 있느냐(안 뽑아내면 쿼리문이 지저분해짐)
	// getPortfolio를 비즈니스 로직으로 정의할 수 있느냐
	public Vector<SharesRec> getPortfolio(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<SharesRec> vec = new Vector<>();
		try {
			conn = getConnect();
			String query = "SELECT * FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			while(rs.next()) {
				vec.add(new SharesRec(ssn, rs.getString("symbol"), rs.getInt("quantity")));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vec;
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerRec cr = null;
		try {
			conn = getConnect();
			String query = "SELECT * FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString("cust_name")+"님의 정보를 가져옵니다.");
				cr = new CustomerRec(
									ssn, 
									rs.getString("cust_name"), 
									rs.getString("address"));
			}//if
			cr.setPortfolio(getPortfolio(ssn));
		}finally {
			closeAll(rs, ps, conn);
		}
		return cr;
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<CustomerRec> crList = new ArrayList<>();
		conn = getConnect();
		String query = "SELECT * FROM customer";
		ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			crList.add(new CustomerRec(
					rs.getString("ssn"), 
					rs.getString("cust_name"), 
					rs.getString("address"), 
					getPortfolio(rs.getString("ssn"))));
		}
		closeAll(rs, ps, conn);
		return crList;
	}

	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<StockRec> stList = new ArrayList<>();
		conn = getConnect();
		String query = "SELECT * FROM stock";
		ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			stList.add(new StockRec(rs.getString("symbol"), 
					rs.getFloat("price")));
		}
		closeAll(rs, ps, conn);
		return stList;
	}
	/*
	 누가 어떤 주식을 몇 개 살 것인가...
	 지금 주식이 몇 개 있는가를 먼저 알아봐야 한다... 이미 가지고 있냐/없냐에 해당되는 쿼리문이 된다... 0/N
	 50개 있는데 100개 사려고 함 -- UPDATE
	 0개 있는데 100개 사려고 함 -- INSERT
	 */
	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(isExist(ssn, conn)) {//등록된 회원일 때
				if(isExistStock(symbol, conn)) {//주식시장에 상장된 주식일 때
					int curSt = numOfStock(ssn, symbol, conn);
					if(curSt>=0) {//보유한 주식이거나 모두 팔아서 0이 된 주식일 경우
						String query = "UPDATE shares SET quantity=? WHERE ssn = ? AND symbol = ?";
						ps = conn.prepareStatement(query);
						ps.setInt(1, numOfStock(ssn, symbol, conn)+quantity);
						ps.setString(2, ssn);
						ps.setString(3, symbol);
						ps.executeUpdate();
						System.out.println(symbol+" "+quantity+"주를 매수하였습니다.");
						System.out.println("현재 "+symbol+" "+(curSt+quantity)+"주를 보유 중입니다.");
					}else {//보유한 주식이 아닐 때
						String query = "INSERT INTO shares(ssn, symbol, quantity) VALUES(?, ?, ?)";
						ps = conn.prepareStatement(query);
						ps.setString(1, ssn);
						ps.setString(2, symbol);
						ps.setInt(3, quantity);
						ps.executeUpdate();
						System.out.println(symbol+" "+quantity+"주를 매수하였습니다.");
						System.out.println("현재 "+symbol+" "+quantity+"주를 보유 중입니다.");
					}
				}else {//주식시장에 상장되지 않은 주식일 때
					throw new RecordNotFoundException("존재하지 않는 주식입니다.");
				}
			}else {//등록되지 않은 회원일 때
				throw new RecordNotFoundException("존재하지 않는 회원입니다.");
			}
		}finally {
			closeAll(ps, conn);
		}
	}
/*
 누가 어떤 주식을 몇 개 팔 것인가... 현재 몇 개를 가지고 있는가....q
  1) 100개를 현재 가지고 있다 --- 50 --- UPDATE
  2) 100개를 현재 가지고 있다 --- 100 --- DELETE
  3) 100개를 현재 가지고 있다 --- 200 --- 펑
  4) 팔려는 사람이 없을 때 / 주식이 없을 때 --- 펑
 */
	@Override
	public void sellShares(String ssn, String symbol, int quantity) throws SQLException, RecordNotFoundException, InvalidTransactionException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(isExist(ssn, conn)) {//등록된 회원일 때
				int curSt = numOfStock(ssn, symbol, conn);
				if(curSt>0) {//보유하고 있는 주식일 때
					if(quantity<=0 || curSt < quantity) {//매도량을 0 또는 음수로 입력했을 때 / 보유한 주식 수보다 매도량이 더 클 때
						throw new InvalidTransactionException("매도량을 잘못 입력하였습니다.");
					}
					else if(curSt >= quantity) {//보유한 주식 수가 매도량보다 크거나 같을 때
						String query = "UPDATE shares SET quantity=? WHERE ssn=? AND symbol=?";
						ps = conn.prepareStatement(query);
						ps.setInt(1, curSt-quantity);
						ps.setString(2, ssn);
						ps.setString(3, symbol);
						ps.executeUpdate();
						System.out.println(symbol+" "+quantity+"주를 매도하였습니다.");
						System.out.println("현재 "+symbol+" "+(curSt-quantity)+"주를 보유 중입니다.");
					}
				}else {//보유하지 않는 주식일 때
					throw new RecordNotFoundException("보유하고 있지 않은 주식입니다.");
				}
			}else {//등록되지 않은 회원일 때
				throw new RecordNotFoundException("존재하지 않는 회원입니다.");
			}
		}finally {
			closeAll(ps, conn);
		}
	}

}
