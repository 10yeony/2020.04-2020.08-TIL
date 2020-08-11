package fly.child;

import fly.Flyer;

public class SuperMan implements Flyer {
	@Override
	public void fly() {
		System.out.println("½´ÆÛ¸Ç ³­´Ù...");
		System.out.println("½Ã¼Ó : "+SIZE+"km...");
	}

	@Override
	public void land() {
		System.out.println("½´ÆÛ¸Ç land...");	
	}

	@Override
	public void take_off() {
		System.out.println("½´ÆÛ¸Ç take_off...");
	}
	
	public String StopBullet() {
		return "ÃÑÀ» ÇÇÇÑ´Ù";
	}
}
