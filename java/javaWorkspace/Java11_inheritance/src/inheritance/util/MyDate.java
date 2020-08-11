package inheritance.util;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	// getDate() function 만들 필요가 없음.
	
	/*
	 * 	메소드 Overriding
	 * step 1. Object의 기능을 그대로 받아서
	 * step 2. 그 기능을 자식 본인에게 맞도록 고쳐 쓴다.
	 */
	@Override // 이거 손대면 안 됨.
	/*public String toString() {
		return super.toString(); 
		// super는 부모를 의미함. 현재 MyDate의 부모는 Object(그 중간에 부모가 없으므로)
		// Object 객체에 있는 toString()을 호출.
	}*/
	public String toString() {
		return year+"-"+month+"-"+day; 
	} // 부모를 상속하되 자식에게 맞게 사용. 년 월 일을 돌려줌.
	
}
