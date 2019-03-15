package how2j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc2 {
	public static void main(String[] args) {
		execute("insert into hero values(null,?,?,?)");
		//execute("select * from hero limit ?,? ");
		//execute("select * from hero where name = ?");
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
				"root", "root"); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {
			/*插入数据*/
			ps.setString(1, "提莫");
			ps.setFloat(2, 325.0f);
			ps.setInt(3, 50);
			ps.execute();
			
			/*查询数据*/
			/*ps.setInt(1, 10);
			ps.setInt(2, 5);
			//ps.setString(1, "'盖伦' OR 1=1");//PreparedStatement的优点3-防止SQL注入式攻击
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id =rs.getInt("id");
				String name = rs.getString(2);
				float hp=rs.getFloat("hp");
				int damage =rs.getInt(4);
				System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
			}*/
			/*插入数据后获取插入id*/
			ResultSet rs=ps.getGeneratedKeys();
			int id=-1;
			if(rs.next()) {
				id = rs.getInt(1);
				System.out.println(id);
			}
			for(int i=id-1;i>0;i--) {
				ResultSet rd=ps.executeQuery("select id from Hero where id = " + i);
				if(rd.next()) {
					 System.out.println("id=" + i + " 的数据存在，删除该数据");
					 String deleteSQL = "delete from hero where id = " + i;
					 ps.execute(deleteSQL);
	                 break;
				}
			}
			System.out.println("执行成功");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
