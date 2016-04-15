package bean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.ConnexionDB;


public class AppointmentBean {
	private int id;
	private String date;
	private String heuredeb;
	private String heurefin;
	private String desc;
	static Statement stmt;


	public AppointmentBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppointmentBean(String d,String deb,String fin){
		date=d;
		heuredeb=deb;
		heurefin=fin;

		try {
			stmt = ConnexionDB.getInstance().conn.createStatement();
			ResultSet res = stmt.executeQuery("select id,description from appointment where date='"+d+"' and debut='"+deb+"' and fin='"+fin+"'");

			while (res.next()){
				id = res.getInt(1);
				desc = res.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<AppointmentBean> getListRDV(){
		List<AppointmentBean> appointmentBean=new ArrayList<AppointmentBean>();
		try {
			stmt = ConnexionDB.getInstance().conn.createStatement();
			ResultSet res = stmt.executeQuery("select id, description, debut, fin, date from appointment");
			AppointmentBean r;
			while(res.next()){
				r = new AppointmentBean();
				r.setDate(res.getString(5));
				r.setHeuredeb(res.getString(3));
				r.setHeurefin(res.getString(4));
				r.setDesc(res.getString(2));
				r.setId(res.getInt(1));
				appointmentBean.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Iterator<AppointmentBean> i = appointmentBean.iterator(); i.hasNext();) {
			AppointmentBean rdv2 = (AppointmentBean) i.next();
			System.out.println(rdv2);
		}
		return appointmentBean;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", heuredeb=" + heuredeb
				+ ", heurefin=" + heurefin + ", desc=" + desc + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeuredeb() {
		return heuredeb;
	}

	public void setHeuredeb(String heuredeb) {
		this.heuredeb = heuredeb;
	}

	public String getHeurefin() {
		return heurefin;
	}

	public void setHeurefin(String heurefin) {
		this.heurefin = heurefin;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
}
