package how2j.jdbc;

public class Item {
	public int id;
	public String name;
	public int price;
	
	public Item() {
		super();
	}
	
	public Item(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "item [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
