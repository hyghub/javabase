package how2j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	List<Connection> cs = new ArrayList<Connection>();
	int size;
	public ConnectionPool(int size) {
		this.size=size;
		init();
	}
	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for(int i=0;i<size;i++) {
				 Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/moon?characterEncoding=UTF-8&autoReconnect=true&useSSL=false&serverTimezone=GMT%2B8","root", "root");
				 cs.add(c);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public synchronized Connection getConnection() {
		while(cs.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Connection c = cs.remove(0);
		return c;
	}
	public synchronized void returnConnection(Connection c) {
        cs.add(c);
        this.notifyAll();
    }
}
