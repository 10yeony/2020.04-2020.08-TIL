package pizza.child;

import pizza.parent.Pizza;

// �ڽ� Ŭ����...
public class PotatoPizza extends Pizza {
	
	public PotatoPizza(int price, String storeName) {
		// �θ��� �ʵ尡 protected�� �����Ǿ super �� ����ص� �ȴ�.
		this.price = price;
		this.storeName = storeName;
	}
	
	@Override
	public void topping() {
		System.out.println("Potato Toping Pizza...");
	}

}
