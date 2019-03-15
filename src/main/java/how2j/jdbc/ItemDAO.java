package how2j.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
	public ItemDAO() {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	 
	    public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/moon?characterEncoding=UTF-8&autoReconnect=true&useSSL=false&serverTimezone=GMT%2B8","root", "root");
	    }
	 
	    public int getTotal() {
	        int total = 0;
	        try (Connection c = getConnection(); Statement s = c.createStatement();) {
	 
	            String sql = "select count(*) from item";
	 
	            ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	                total = rs.getInt(1);
	            }
	 
	            System.out.println("total:" + total);
	 
	        } catch (SQLException e) {
	 
	            e.printStackTrace();
	        }
	        return total;
	    }
	 
	    public void add(Item item) {
	 
	        String sql = "insert into item values(null,?,?)";
	        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	 
	            ps.setString(1, item.name);
	            ps.setInt(2, item.price);
	 
	            ps.execute();
	 
	            ResultSet rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                int id = rs.getInt(1);
	                item.id = id;
	            }
	        } catch (SQLException e) {
	 
	            e.printStackTrace();
	        }
	    }
	 
	    public void update(Item item) {
	 
	        String sql = "update item set name= ?, price = ?  where id = ?";
	        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	 
	            ps.setString(1, item.name);
	            ps.setInt(2, item.price);
	            ps.setInt(3, item.id);
	 
	            ps.execute();
	 
	        } catch (SQLException e) {
	 
	            e.printStackTrace();
	        }
	 
	    }
	 
	    public void delete(int id) {
	 
	        try (Connection c = getConnection(); Statement s = c.createStatement();) {
	 
	            String sql = "delete from item where id = " + id;
	 
	            s.execute(sql);
	 
	        } catch (SQLException e) {
	 
	            e.printStackTrace();
	        }
	    }
	 
	    public Item get(int id) {
	        Item item = null;
	 
	        try (Connection c = getConnection(); Statement s = c.createStatement();) {
	 
	            String sql = "select * from item where id = " + id;
	 
	            ResultSet rs = s.executeQuery(sql);
	 
	            if (rs.next()) {
	                item = new Item();
	                String name = rs.getString(2);
	                int price = rs.getInt(3);
	                item.name = name;
	                item.price = price;
	                item.id = id;
	            }
	 
	        } catch (SQLException e) {
	 
	            e.printStackTrace();
	        }
	        return item;
	    }
	 
	    public List<Item> list() {
	        return list(0, Short.MAX_VALUE);
	    }
	 
	    public List<Item> list(int start, int count) {
	        List<Item> items = new ArrayList<Item>();
	 
	        String sql = "select * from item order by id desc limit ?,? ";
	 
	        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	 
	            ps.setInt(1, start);
	            ps.setInt(2, count);
	 
	            ResultSet rs = ps.executeQuery();
	 
	            while (rs.next()) {
	                Item item = new Item();
	                int id = rs.getInt(1);
	                String name = rs.getString(2);
	                int price = rs.getInt(3);
	                item.name = name;
	                item.price = price;
	                item.id = id;
	                 
	                items.add(item);
	            }
	        } catch (SQLException e) {
	 
	            e.printStackTrace();
	        }
	        return items;
	    }
	 
}
