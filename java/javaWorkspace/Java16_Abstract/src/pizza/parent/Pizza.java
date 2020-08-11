package pizza.parent;
/*
 * 추상 클래스의 용도
 * ::
 * 1. 여러 종류의 피자들을 만들 때, 
 *    피자로서의 공통적인 부분(필드, 메소드)은 부모가 가진 성질을 자식에게 그대로 물려주고 
 * 2. 반면에 서로 다른 피자가 만들어지는 결정적인 부분은 추상 메소드로 자식에게 물려주어서
 *    자식이 본인에 맞도록 직접 구현하도록 한다.
 * -> 공통적인 부분은 그대로 물려주고 서로 다른 부분은 추상으로 물려준다.
 */
public abstract class Pizza {
	protected int price;
	protected String storeName;
	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}
	
	public Pizza() {}
	
	public void makePizza() {
		dough();
		topping(); // 추상 메소드
		bake();
		cut();
		box();
	}
	
	public void dough() {
		System.out.println("피자 반죽과 함께 도우를 빚다");
	}
	public void box() {
		System.out.println("피자 boxing...");
	}
	public void bake() {
		System.out.println("피자를 180도에서 10분간 구워냅니다...");
	}
	public void cut() {
		System.out.println("피자를 8등분으로 자릅니다...");
	}
	public abstract void topping(); 
	// 결정적으로 토핑에 따라 피자가 달라짐. 그래서 이 부분을 추상으로 함.
	// 근데 이 메소드만 abstract로 해주면 에러 남.
	// abstract만 하나라도 있으면 추상 클래스가 되므로 클래스에도 abstract를 붙여준다.

	@Override
	public String toString() {
		return storeName+" "+price+"원";
	}
	
	
}
