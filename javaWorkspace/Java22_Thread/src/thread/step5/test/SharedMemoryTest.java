package thread.step5.test;
/*
 * Review ::
 * Thread들은 공유자원을 서로 Sharing 한다
 */
class Calculator{
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized void setMemory(int memory) {
		// synchronized 안 붙여주면 User1 클래스에서 100 주입하고 User2 클래스가 50 주입해서 덮어씌우는데
		// synchronized 붙이면 User1이 작업 끝내기 전까지 User2가 값을 덮어씌울 수 없음.
		this.memory = memory;
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"  :  "+this.memory);
	}	
}
class User1 extends Thread{
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		setName("CalculatorUser1");
		this.calculator = calculator;
	}
	public void run(){
		calculator.setMemory(100);		
	}	
}
class User2 extends Thread{
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		setName("CalculatorUser2");
		this.calculator = calculator;
	}
	public void run(){
		calculator.setMemory(50);		
	}	
}
public class SharedMemoryTest {
	public static void main(String[] args) {
		Calculator calculator  = new Calculator();
		
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	}
}











