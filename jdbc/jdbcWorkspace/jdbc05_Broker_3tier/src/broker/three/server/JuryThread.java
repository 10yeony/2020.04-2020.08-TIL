package broker.three.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

import broker.three.exception.DuplicateSSNException;
import broker.three.exception.InvalidTransactionException;
import broker.three.exception.RecordNotFoundException;
import broker.three.shares.Command;
import broker.three.shares.Result;
import broker.three.vo.CustomerRec;

public class JuryThread extends Thread {
	Socket s;
	Database db;
	ObjectInputStream ois; 
	ObjectOutputStream oos;
	Command cmd; //Protocol이 날린 Command 받아야 하니까 일단 선언.
	
	public JuryThread(Socket s, Database db) {
		this.s = s;
		this.db = db;
		try {
			ois = new ObjectInputStream(s.getInputStream()); 
			// Protocol이 날린 Command 받아야 하니까 여기서는 입력부터
			oos = new ObjectOutputStream(s.getOutputStream());
		}catch(Exception e) {
			
		}
		System.out.println("Jury Creating...");
	}
	
	public void run() { // 쓰레드
		System.out.println("run()....들어옴...");
		while(true) {
			try {
				//1. 도시락 받는다.
				cmd = (Command)ois.readObject();
				System.out.println("cmd...Jury readObject()...");
			}catch(Exception e){

			}

			//2. 도시락 깐다... Data Unpack.... getter... 상수값|반찬통|빈통
			int comm = cmd.getCommandValue(); // 10~90까지의 숫자가 튀어나온다.
			String[] args = cmd.getArgs();
			Result r = cmd.getResults();
			switch(comm) {//switch의 변수로는 실수형은 못 온다. 정수만! String은 올 수 있음.
			case Command.BUYSHARES:
				try {
					db.buyShares(args[0], args[1], Integer.parseInt(args[2]));
					r.setStatus(0);
				} catch (Exception e) {
				}
				break;
			case Command.SELLSHARES: 
				try {
					db.sellShares(args[0], args[1], Integer.parseInt(args[2]));
				} catch(RecordNotFoundException e) {
					System.out.println("주식을 팔 고객이 없어요... Jury...");
					r.setStatus(-1);
				}catch(InvalidTransactionException e) {
					System.out.println("팔려는 주식의 수량이 너무 많아요... Jury...");
					r.setStatus(-3);
				}catch(Exception e) {

				}
				r.setStatus(0);
				break;
			case Command.GETALLSTOCK: 
				try {
					r.setStatus(0);
					r.add(db.getAllStocks());
				} catch (SQLException e2) {
				}
				break;
			/*case Command.GETSTOCKPRICE: 

				break;*/
			case Command.GETALLCUSTOMERS:  
				try {
					r.setStatus(0);
					r.add(db.getAllCustomers());
				} catch (SQLException e1) {
				}
				break;
			case Command.GETCUSTOMER: 
				try {
					r.add(db.getCustomer(args[0])); 
					// 빈통 Result에 db.getCustomer에서 리턴받은 객체 추가
					r.setStatus(0); // Result의 상태값 지정
				} catch (SQLException e) {
				}

				break;
			case Command.ADDCUSTOMER: 
				try {
					CustomerRec cr = new CustomerRec(args[0], args[1], args[2]);
					db.addCustomer(cr); // 디비 갔다온다...
					r.setStatus(0);
				}catch(DuplicateSSNException e) {
					r.setStatus(-2);
				}catch(Exception e) {

				}
				break;
			case Command.DELETECUSTOMER: 
				try {
					db.deleteCustomer(args[0]);
					r.setStatus(0);
				}catch(RecordNotFoundException e) {
					r.setStatus(-1);
				}catch(Exception e) {

				}
				break;
			case Command.UPDATECUSTOMER: 
				try {
					CustomerRec cr = new CustomerRec(args[0], args[1], args[2]);
					db.updateCustomer(cr);
					r.setStatus(0);
				}catch(RecordNotFoundException e) {
					r.setStatus(-1);
				}catch(Exception e) {

				}
				break;

			}
			
		
			try {
				oos.writeObject(cmd); // 객체니까 write^Object^
				System.out.println("Jury writeCommand...end...");
			}catch(Exception e) {
				System.out.println("Jury writeCommand...error"+e);
			}
		}
	}
}
