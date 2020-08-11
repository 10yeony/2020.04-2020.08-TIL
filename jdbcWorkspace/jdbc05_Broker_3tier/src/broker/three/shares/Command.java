package broker.three.shares;

import java.io.Serializable;
import java.util.ArrayList;

public class Command implements Serializable{//직렬화.
	// int 상수값으로 넣는데 String 상수값으로 해도 상관 없음. 하지만 머신 입장에서는 숫자가 더 명료.
	public static final int BUYSHARES = 10; 
	public static final int SELLSHARES = 20; 
	public static final int GETALLSTOCK = 30; 
	public static final int GETSTOCKPRICE = 40; 
	public static final int GETALLCUSTOMERS = 50; 
	public static final int GETCUSTOMER = 60; 
	public static final int ADDCUSTOMER = 70; 
	public static final int DELETECUSTOMER = 80; 
	public static final int UPDATECUSTOMER = 90;
	// GETPORTFOLIO는 독자적인 것이 아니므로 안 넣음.
	
	private int commandValue;
	private String[] args;
	private Result results; // 갈 때는 빈통, 올 때는 담아서 오는 통.
	
	public Command(int commandValue) {
		super();
		this.commandValue = commandValue;
	}

	public Command(Result results) {
		super();
		this.results = results;
	}

	public int getCommandValue() {
		return commandValue;
	}

	public void setCommandValue(int commandValue) {
		this.commandValue = commandValue;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	public Result getResults() {
		return results;
	}

	public void setResults(Result results) {
		this.results = results;
	}
	
}
