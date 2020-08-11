package broker.twotier.vo;
/**
 * 
 * @author yeony
 *
 * 누가
 * 어떤 주식을
 * 얼마만큼 보유하고 있는지의 정보를 담고 있는 클래스... Shares 테이블의 정보
 * 
 */
public class SharesRec {
	private String ssn;
	private String symbol;
	//
	private int quantity;
	public SharesRec() { // 생성자 오버로딩 안 해준 것. 해줘도 됨.
		super();
	}
	public SharesRec(String ssn, String symbol, int quantity) {
		super();
		this.ssn = ssn;
		this.symbol = symbol;
		this.quantity = quantity;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "SharesRec [ssn=" + ssn + ", symbol=" + symbol + ", quantity=" + quantity + "]";
	}
	
}
