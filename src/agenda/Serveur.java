package agenda;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class Serveur {

	public static void main(String [] args)
	{
		try {
			AgendaImpl ag=new AgendaImpl();
			Naming.rebind("agenda", ag);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}