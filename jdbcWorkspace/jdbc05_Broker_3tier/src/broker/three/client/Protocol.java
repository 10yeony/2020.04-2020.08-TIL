package broker.three.client;
/*
 * Protocol + Jury
 * 서버 ---- ProtocolHandler 돌리고
 * 클라이언트 ---- Broker 돌림
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import broker.three.exception.DuplicateSSNException;
import broker.three.exception.InvalidTransactionException;
import broker.three.exception.RecordNotFoundException;
import broker.three.shares.Command;
import broker.three.vo.CustomerRec;
import broker.three.vo.StockRec;

//Database의 동명이인
//클라이언트 사이드의 통신의 대표주자...Socket...스트림
public class Protocol {
	private Socket s;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Command cmd; // 스트림을 통해서 왔다갔다 하는 Command
	static final int MIDDLE_PORT = 60000;
	
	public Protocol(String serverIp) throws Exception {
		s = new Socket(serverIp, MIDDLE_PORT);
		oos = new ObjectOutputStream(s.getOutputStream()); // 날릴 거니까 출력이 먼저
		ois = new ObjectInputStream(s.getInputStream());
	}
	
	public void close() { // 소켓 닫아줌. 호출해서 쓸 때 finally에서 닫을 것.
		try {
			s.close();
		}catch(Exception e) {
			System.out.println("Protocol.close()...."+e);
		}
	}
	
	// 공통적인 로직 작성...
	public void writeCommand(Command cmd) {
		try {
			oos.writeObject(cmd); // 객체니까 write^Object^
			System.out.println("Client writeCommand...end...");
		}catch(IOException e) {
			System.out.println("Client Protocol writeCommand...error"+e);
		}
	}
	public int getResponse() {
		//응답결과인 걸 고려하면 Method Identifier는 readCommand보다 getReponse()가 더 적절 
		//readObject() + getResults().getStatus() --> status code
		try {
			cmd = (Command)ois.readObject(); //다시 통으로 받음.
			System.out.println("client readObject()... end...");
		}catch(Exception e) {
			System.out.println("client getResponse()....error"+e);
		}
		// 0, DuplicateSSNException(-2), RecordNE(-1), InvalidTE(-3)
		int status = cmd.getResults().getStatus(); //상태값을 받음.
		
		return status;
	}
	
	// 비즈니스 로직 작성... Database 메소드와 같아야 함!(getPortfolio는 독자적인 것이므로 뺐다.)
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		/*
		 * 1. 도시락 싼다.
		 * 2. 던진다... Jury가 받는다
		 * -----------------------------
		 * 3. Jury가 던진 도시락 다시 받는다
		 * 4. status가 0이면 정상, 음수면 펑(예외는 Broker로 전달)
		 */
		//도시락 싼다
		cmd = new Command(Command.ADDCUSTOMER); // 70이라고 써도 되지만 좀 더 직관적인 코드.
		String[] str = {cust.getSsn(), cust.getName(), cust.getAddress()}; // 반찬만 만든 것.
		cmd.setArgs(str); // 도시락 통에 넣는다
		
		//도시락 날린다
		writeCommand(cmd); 
		
		//Jury가 보낸 데이터(Jury가 db 가서 처리한 결과값) 받는다... 응답결과
		//중요! 응답 결과는 크게 두 가지 -- 1)상태값(성공/실패)  2)리턴값 
		int status = getResponse(); 
		if(status==-2) throw new DuplicateSSNException("그런 회원 이미 있어요...");
		
	}
	public void deleteCustomer(String ssn) throws SQLException,RecordNotFoundException {
		cmd = new Command(Command.DELETECUSTOMER);
		String[] str = {ssn};
		cmd.setArgs(str);
		
		writeCommand(cmd);
		
		int status = getResponse();
		if(status==-1) throw new RecordNotFoundException("삭제할 회원이 없습니다");
	}
	public void updateCustomer(CustomerRec cust) throws SQLException,RecordNotFoundException  {
		cmd = new Command(Command.UPDATECUSTOMER);
		String[] str = {cust.getSsn(), cust.getName(), cust.getAddress()};
		cmd.setArgs(str);
		
		writeCommand(cmd);
		
		// 1)상태값(성공/실패)  2)리턴값 
		
		int status = getResponse();
		if(status==-1) throw new RecordNotFoundException("수정할 회원이 없습니다");
	}
	public CustomerRec getCustomer(String ssn) throws SQLException {
		CustomerRec cr = null; // 메소드에 리턴 타입 있으면 선언하고 들어갈 것.
		
		//1. 도시락 싼다.
		cmd = new Command(Command.GETCUSTOMER); // 도시락 통
		String[] str = {ssn}; // 반찬 만들고
		cmd.setArgs(str); // 반찬을 도시락 통에 넣음.
		
		//2. 도시락 던진다... Jury쪽으로
		writeCommand(cmd); // 이 때 cmd는 내가 던진 도시락.
		
		//////////////////////////////////
		
		//3. Jury가 다시 던진 도시락 받는다.
		getResponse(); //상태값, 결과값  |  //이 때 cmd는 Jury가 던진 도시락 
		CustomerRec cust = (CustomerRec)cmd.getResults().get(0);
		// cmd.getResults() ==> Result (ArrayList 상속.)
		// .get(0) ==> 첫번째 인덱스 가져옴.(ArrayList의 메소드)
		// cmd.getResults().get(0), 이 객체를 CustomerRec으로 캐스팅.
		return cust;
	}
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		ArrayList<CustomerRec> cList = null;
		
		//1. 도시락 싼다
		cmd = new Command(Command.GETALLCUSTOMERS);
		
		//2, 도시락 던진다
		writeCommand(cmd);
		
		//3. Jury가 다시 던진 도시락 받는다.
		getResponse(); // cmd... Jury가 던진 cmd...
		cList = (ArrayList<CustomerRec>)cmd.getResults().get(0);
		return cList;
	}
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		ArrayList<StockRec> sList = null;
		cmd = new Command(Command.GETALLSTOCK);
		
		writeCommand(cmd);
		
		getResponse();
		sList = (ArrayList<StockRec>) cmd.getResults().get(0);
		return sList;
	}
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
		cmd = new Command(Command.BUYSHARES);
		String[] str = {ssn, symbol, String.valueOf(quantity)}; //int를 String으로 바꿈
		cmd.setArgs(str);
		
		writeCommand(cmd);
		
		getResponse(); //data Unpacking... getter
	}
	public void sellShares(String ssn, String symbol, int quantity) throws SQLException,InvalidTransactionException,RecordNotFoundException {
		cmd = new Command(Command.SELLSHARES);
		String[] str = {ssn, symbol, String.valueOf(quantity)};
		cmd.setArgs(str);
		
		writeCommand(cmd);
		
		int status = getResponse();
		if(status==-1) throw new RecordNotFoundException("주식을 팔 사람이 없어요!!");
		if(status==-3) throw new InvalidTransactionException("팔려는 주식의 양이 넘 많아요");
	}
}
