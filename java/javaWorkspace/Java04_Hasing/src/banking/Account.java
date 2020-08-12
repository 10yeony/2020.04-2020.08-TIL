package banking;
/*
 * ������ ������ �����ϴ� Ŭ����
 */
public class Account {
	private double balance;
	// balance Ŭ���ϰ� ������ ���콺 - source - generate Constructor using field���� 
	// �Ʒ� ������ �ڵ����� ���� �� ����
	public Account(double balance) {
		this.balance = balance;
	} 
	
	public void setBalance(double balance) {
		this.balance = balance;
	}


	public double getBalance() {
		return balance;
	}

	public void deposit(double amt) {
		balance += amt; // (balance = balance + amt;) // amount
	}
	
	public void withdraw(double amt) {
		balance -= amt;
	}
	
}