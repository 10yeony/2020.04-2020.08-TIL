package spring.service.greet;

public class Greet{
	
	///Field
	private String message;
	
	///Constructor Method
	public Greet() {
		System.out.println(getClass().getName()+" Instance Create.....");
	}
	public Greet(String message) {
		this.message = message;
	}

	///Method
	//==> getter / setter Method definition
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//==> message 를 출력하는 Method  
	public void printMessage() {
		System.out.println("\n"+getClass().getName()+"=>"+message);
	}
	
}//end of class