package how2j.socket;

public class DictionaryDAO {
	
	public DictionaryDAO () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
}
