package banking;
/*
 * ������ �����ϰ��� �ϴ� ���� ������ �����ϰ� �ִ� Ŭ����..
 * Customer + Account ---> Has a Relation (Hasing)
 * 1. �ʵ忡 Account�� ����
 * 2. Account�� ���� ---> ������ / setter�� ����
 */
public class Customer {
	private String name;
	private int ssn; // �ֹι�ȣ(Social Secret Number)

	// �߰�
	private Account account; // Account Ÿ���� account ����

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public String getCustInfo() {
		return name + ", " + ssn;
	}
}
