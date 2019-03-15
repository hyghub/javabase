package how2j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {
	public static void main(String[] args) {
		execute("select * from hero limit 10,5 ");
	}
	
	public static void execute(String sql) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (Connection c = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/moon?characterEncoding=UTF-8&autoReconnect=true&useSSL=false&serverTimezone=GMT%2B8",
				"root", "root"); Statement s = c.createStatement();) {
			/*插入数据*/
			/*for(int i=0;i<100;i++) {
				String sql = "insert into hero values(null," + "'英雄"+i+"'" + "," + 30.0f + "," + 50 + ")";
				s.execute(sql);
			}*/
			/*删除数据*/
			/*String sql="delete t from hero t where t.id =3 ";
			s.execute(sql);*/
			/*更新数据*/
			/*String sql="update  hero t set t.name='name5' where t.id =5 ";
			s.execute(sql);*/
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()){
				int id =rs.getInt("id");
				String name = rs.getString(2);
				float hp=rs.getFloat("hp");
				int damage =rs.getInt(4);
				System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
			}
			System.out.println("执行成功");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
