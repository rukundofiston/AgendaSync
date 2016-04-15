package agenda;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.sql.Statement;

import bean.UserBean;

import dao.ConnexionDB;



public class AgendaImpl extends UnicastRemoteObject implements Agenda<UserBean> {

	private static final long serialVersionUID = 1L;
	static Statement stmt;

	protected AgendaImpl()throws RemoteException {
		super();
	}
	public UserBean getObject() throws RemoteException {
		UserBean p=null;
		p=new UserBean("Moi","RukundoFiston");
		return p;

	}

	public UserBean connect(String login, String pass) throws RemoteException{
		UserBean user=null;
		user=new UserBean(login,pass);
		return user;
	}
	@Override
	public void supprimerRDV(int id) throws RemoteException {
		try {
			String QUERY= "DELETE FROM appointment WHERE id='"+id+"'";
			stmt = ConnexionDB.getInstance().conn.createStatement();
			stmt.executeUpdate(QUERY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void ajouterRDV(String debut, String fin, String date,
			String descr) throws RemoteException {
		try {
			String QUERY= "Insert into appointment(debut,fin,date,description) values('"+debut+"','"+fin+"','"+date+"','"+descr+"')";
			stmt = ConnexionDB.getInstance().conn.createStatement();
			stmt.executeUpdate(QUERY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void modifierRDV(int id, String debut, String fin, String date,
			String descr) throws RemoteException {
		try {
			String QUERY= "update appointment set debut = '"+debut+"', fin ='"+fin+"' ,date='"+date+"', description ='"+descr+"' WHERE id='"+id+"'";
			stmt = ConnexionDB.getInstance().conn.createStatement();
			stmt.executeUpdate(QUERY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}





