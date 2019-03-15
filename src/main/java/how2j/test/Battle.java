package how2j.test;

public class Battle implements Runnable {
	
	private Hero hero1;
	private Hero hero2;
	public Battle(Hero hero1,Hero hero2) {
		this.hero1=hero1;
		this.hero2=hero2;
	}
	public void run() {
		while(!hero2.isDead()) {
			hero1.attack(hero2);
		}
	}

}
