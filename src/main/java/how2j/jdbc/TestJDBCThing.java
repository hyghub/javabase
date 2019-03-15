package how2j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestJDBCThing {
	 public static void main(String[] args) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	 
	        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/moon?characterEncoding=UTF-8&autoReconnect=true&useSSL=false&serverTimezone=GMT%2B8","root", "root");
	            Statement sqe = c.createStatement();Statement sde = c.createStatement();) {
	  
	            //没有事务的前提下
	            //假设业务操作时，加血，减血各做一次
	            //结束后，英雄的血量不变
	            c.setAutoCommit(false);  
	            //加血的SQL
	            Scanner sc = new Scanner(System.in);
	            ResultSet rs = sqe.executeQuery("select id from hero t where t.id limit 0,10");
	            while(rs.next()) {
	            	int id = rs.getInt(1);
	            	System.out.println("试图删除id="+id+"的数据");
	            	sde.execute("delete p from hero p where p.id ="+id);
	            }
	            while(true){
	            	System.out.println("是否要删除数据(Y/N)");
	            	String str =sc.next();
	            	if("Y".equals(str)) {
	            		c.commit();
	                    System.out.println("提交删除");
	                    break;
	            	}else if("N".equals(str)){
	            		 System.out.println("放弃删除");
	                     break;
	            	}
	            }  
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	  
	    }
}
