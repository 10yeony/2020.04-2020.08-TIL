package broker.three.shares;

import java.util.ArrayList;
/*
 * Result는 한칸짜리 ArrayList
 * 성공/실패 여부를 확인할 수 있는 status 값을 가지고 있다.
 */
public class Result extends ArrayList {//Command 직렬화 했으므로 Result는 Serialization할 필요 없음.
	private int status = -1; // 프로그램에서 음수는 fail을 의미. 정상은 0.
	
	public Result() {
		super(1); // ArrayList 1칸으로 만듦.
		// ArrayList 지정 안해주면 디폴트로 10칸 만들어짐.
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
