package bean;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.ConnexionDB;

public class UserBean implements Serializable{	
	private static final long serialVersionUID = 1L;
	private int id;
	private String role;
	private String login;
	private String password;
	static public boolean test = true;

	public UserBean(String login,String password){
		this.login=login;
		this.password=password;
		Statement stmt;
		try {
			stmt = ConnexionDB.getInstance().conn.createStatement();
			ResultSet res = stmt.executeQuery("select id, role from users where login='"+login+"' and mdp='"+password+"'");
			while (res.next()){
				id=res.getInt(1);
				role= res.getString(2);
				if(role.equals("1"))
					role ="proprietaire";
				if(role.equals("2"))
					role ="secretaire";
				if(role.equals("3"))
					role ="utilisateur";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}
}
