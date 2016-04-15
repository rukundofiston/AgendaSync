package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionDB {
	static ConnexionDB c;
	public Connection conn = null;
	
	
	private ConnexionDB() {
		super();
	}
	
	
	public static ConnexionDB getInstance(){
		if(c == null){
			c = new ConnexionDB();
		}
		c.connect();
		return c;
	}
	
	public void connect()
	{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/agendasync","root","");
			System.out.println("connection etablie ^_^");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		this.conn = conn;
	}
}
