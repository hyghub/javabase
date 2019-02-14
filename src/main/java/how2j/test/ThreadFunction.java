package how2j.test;

public class ThreadFunction {
	public static void main(String[] args) {
/*	sleep	当前线程暂停*/		
		/*Thread t1 = new Thread() {
			public void run() {
				int sec = 0;
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.printf("已经玩了%d秒%n",sec++);
				}
			}
		};
		t1.start();*/
		
		/*join	加入到当前线程中*/
		Hero hero  = new Hero("盖伦", new Double(100), 1);
		Hero hero1 = new Hero("提姆", new Double(100), 1);
		Hero hero2 = new Hero("赏金", new Double(100), 1);
		Hero hero3 = new Hero("猴子", new Double(100), 1);
		
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
		//设置优先级
		//thread1.setPriority(Thread.MIN_PRIORITY);
		//thread1.setDaemon(true);守护线程的概念是： 当一个进程里，所有的线程都是守护线程的时候，结束当前进程。
		thread1.start();
		/*try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Thread thread2 = new Thread() {
			public void run() {
				while(!hero2.isDead()) {
					//Thread.yield();//线程临时暂停
					hero3.attack(hero2);
				}
			}
		};
		//thread2.setPriority(Thread.MAX_PRIORITY);
		thread2.setDaemon(true);
		thread2.start();	
		
	}

}
