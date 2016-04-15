package agenda;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface  Agenda<T> extends Remote {

	public T getObject() throws RemoteException;
	public T connect(String login, String pass) throws RemoteException;
	public void supprimerRDV(int id) throws RemoteException;
	public  void ajouterRDV(String debut,String fin,String date,String descr) throws RemoteException;
	public void modifierRDV(int id ,String debut,String fin,String date,String descr) throws RemoteException;
}
