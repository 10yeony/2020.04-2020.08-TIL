package banking;
/*
 * 통장을 개설하고자 하는 고객의 정보를 저장하고 있는 클래스..
 * Customer + Account ---> Has a Relation (Hasing)
 * 1. 필드에 Account를 선언
 * 2. Account를 주입 ---> 생성자 / setter로 주입
 */
public class Customer {
	private String name;
	private int ssn; // 주민번호(Social Secret Number)

	// 추가
	private Account account; // Account 타입의 account 선언

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
