package pattern.action;
/*
 * Framework 기술
 * 
 * Struts1 ---> Struts2 --->SpringFramework
 * 
 */
public interface Action {
	void execute(); //인터페이스에 이렇게 적어놓으면 public abstract 자동으로 붙음. 추상 메소드.
}
