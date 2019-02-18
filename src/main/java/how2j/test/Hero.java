package how2j.test;

public class Hero {
	private String name;
	private Double hq;
	private int damage;
	
	public Hero() {};
	public Hero(String name, Double hq, int damage) {
		super();
		this.name = name;
		this.hq = hq;
		this.damage = damage;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getHq() {
		return hq;
	}
	public void setHq(Double hq) {
		this.hq = hq;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void attack(Hero hero) {
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		hero.hq=hero.hq-damage;
		System.out.println(name+"攻击"+hero.name+","+hero.name+"的血量还有"+hero.hq);
		if(hero.isDead()) {
			System.out.println(hero.name+"已死");
		}
	}
	public boolean isDead() {
		return 0>=hq?true:false;
	}
	
}
