package how2j.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class TestConnectionPool {
	public static void main(String[] args) {
		ConnectionPool p = new ConnectionPool(3);
		for(int i=0;i<100;i++) {
			new WorkingThread("working thread" + i, p).start();
		}
	}
}

class WorkingThread extends Thread{
	private ConnectionPool pool;

	public WorkingThread(String name,ConnectionPool pool ) {
		super(name);
		this.pool=pool;
	}
	
	public void run() {
		Connection c = pool.getConnection();
		System.out.println(this.getName()+":\t获取了一根连接，并开始工作");
		try (Statement s =c.createStatement();){
			Thread.sleep(1000);
			s.executeQuery("select * from hero");
		} catch (Exception e) {
			// TODO: handle exception
		}
		pool.returnConnection(c);
	}
}
