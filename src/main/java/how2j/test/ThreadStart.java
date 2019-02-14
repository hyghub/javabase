package how2j.test;

public class ThreadStart {
	public static void main(String[] args) {
		Hero hero  = new Hero("盖伦", new Double(100), 20);
		Hero hero1 = new Hero("提姆", new Double(100), 20);
		Hero hero2 = new Hero("赏金", new Double(100), 20);
		Hero hero3 = new Hero("猴子", new Double(100), 20);
		
		/*while(!hero1.isDead()) {
			hero.attack(hero1);
		}
		while(!hero3.isDead()) {
			hero2.attack(hero3);
		}*/
		
		/*KillThread kill1 = new KillThread(hero, hero1);
		kill1.start();
		KillThread kill2 = new KillThread(hero2, hero3);
		kill2.start();*/
		
		/*Battle kill1 = new Battle(hero, hero1);
		new Thread(kill1).start();
		Battle kill2 = new Battle(hero2, hero3);
		new Thread(kill2).start();*/
		
		/**
		 * 匿名类
		 */
		Thread thread1 = new Thread() {
			public void run() {
				while(!hero1.isDead()) {
					hero.attack(hero1);
				}
			}
		};
		thread1.start();
		
		Thread thread2 = new Thread() {
			public void run() {
				while(!hero2.isDead()) {
					hero3.attack(hero2);
				}
			}
		};
		thread2.start();
	}
	
}















