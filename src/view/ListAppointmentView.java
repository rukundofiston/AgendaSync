package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.TableModel;

import util.Calendrier;
import agenda.Agenda;
import bean.*;

public class ListAppointmentView extends javax.swing.JFrame {
	{
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static final long serialVersionUID = 1L;
	private JLabel jLabel1;
	private JButton jButtonQuitter;
	private JButton jButtonSupprimer;
	private JTable jTableRDV;
	private JButton jButtonModifier;
	private JButton jButtonAjouter;
	List<AppointmentBean> appointmentBean = new ArrayList<AppointmentBean>();
	public boolean test = true;
	private JScrollPane jScrollPane1;
	private JSeparator jSeparator1;
	private JButton dateRDV;
	private JButton tous;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ListAppointmentView listApp= new ListAppointmentView(true);				
				listApp.setLocationRelativeTo(null);
				listApp.setVisible(true);				
			}
		});
	}

	public ListAppointmentView(boolean test) {
		super();
		this.test = test;
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(102,153,238));
			this.setTitle("Liste des taches");
			{
				jButtonAjouter = new JButton();
				getContentPane().add(jButtonAjouter);
				jButtonAjouter.setBounds(36, 60, 115, 38);				
				jButtonAjouter.setIcon(new ImageIcon(getClass().getResource("/icon3.png")));
				jButtonAjouter.setText("Ajouter");
				jButtonAjouter.setBackground(Color.white);
				if(test){
					jButtonAjouter.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							AppointmentView inst = new AppointmentView(ListAppointmentView.this);
							ListAppointmentView.this.setVisible(false);
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
				}else{
					jButtonAjouter.setEnabled(false);
				}
			}
			{
				jButtonModifier = new JButton();
				getContentPane().add(jButtonModifier);
				
				jButtonModifier.setBounds(171, 60, 115, 38);
				jButtonModifier.setIcon(new ImageIcon(getClass().getResource("/icon4.png")));
				jButtonModifier.setText("Modifier");
				jButtonModifier.setBackground(Color.white);
				if(test){
					jButtonModifier.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							if(jTableRDV.getSelectedRowCount() > 0){
								AppointmentView inst = new AppointmentView(
										ListAppointmentView.this,
										(Integer) getValueAt(jTableRDV.getSelectedRow(), 0),
										(String)getValueAt(jTableRDV.getSelectedRow(), 1),
										(String)getValueAt(jTableRDV.getSelectedRow(), 2),
										(String)getValueAt(jTableRDV.getSelectedRow(), 3),
										(String)getValueAt(jTableRDV.getSelectedRow(), 4)
										);
								AppointmentView.lblDate.setText((String)getValueAt(jTableRDV.getSelectedRow(), 4));
								ListAppointmentView.this.setVisible(false);
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}else
								JOptionPane.showMessageDialog(null, "selectionner une ligne","error",JOptionPane.ERROR_MESSAGE);
						}
					});
				}else{
					jButtonModifier.setEnabled(false);
				}
			}
			{
				jButtonSupprimer = new JButton();
				getContentPane().add(jButtonSupprimer);
				jButtonSupprimer.setBounds(577, 60, 115, 38);
				jButtonSupprimer.setIcon(new ImageIcon(getClass().getResource("/icon7.png")));
				jButtonSupprimer.setText("Supprimer");
				jButtonSupprimer.setBackground(Color.white);
				if(test){
					jButtonSupprimer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							if(jTableRDV.getSelectedRowCount() > 0){
								String url="rmi://localhost/agenda";


								try {
									@SuppressWarnings("rawtypes")
									Agenda a=(Agenda)Naming.lookup(url);
									a.supprimerRDV((Integer) getValueAt(jTableRDV.getSelectedRow(), 0));
								} catch (RemoteException e) {
									e.printStackTrace();
								} catch (MalformedURLException e) {
									e.printStackTrace();
								} catch (NotBoundException e) {
									e.printStackTrace();
								}
								ListAppointmentView.this.setVisible(false);
								ListAppointmentView inst = new ListAppointmentView(test);
								inst.setLocationRelativeTo(null);
								inst.setVisible(true);
							}else
								JOptionPane.showMessageDialog(null, "selectionner une ligne","error",JOptionPane.ERROR_MESSAGE);
						}
					});
				}else{
					jButtonSupprimer.setEnabled(false);	
				}
			}
			{
				jButtonQuitter = new JButton();
				getContentPane().add(jButtonQuitter);
				jButtonQuitter.setBounds(275, 310, 126, 41);
				jButtonQuitter.setIcon(new ImageIcon(getClass().getResource("/icon5.png")));
				jButtonQuitter.setText("Quitter");
				jButtonQuitter.setBackground(Color.white);
				jButtonQuitter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						LoginView inst = new LoginView();
						ListAppointmentView.this.setVisible(false);
						inst.setVisible(true);
					}
				});
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Menu");
				jLabel1.setBounds(325, 12, 86, 16);
				jLabel1.setFont(new java.awt.Font("Baskerville Old Face",3,26));
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(24, 153, 684, 114);
				{

					this.appointmentBean = new AppointmentBean().getListRDV();
					String [][] tab = new String [this.appointmentBean.size()][4];

					for(int i=0;i<this.appointmentBean.size();i++){
						tab[i][0] = this.appointmentBean.get(i).getDesc();
						tab[i][1] = this.appointmentBean.get(i).getHeuredeb();
						tab[i][2] = this.appointmentBean.get(i).getHeurefin();
						tab[i][3] = this.appointmentBean.get(i).getDate();
					}

					TableModel jTableRDVModel = 
							new javax.swing.table.DefaultTableModel(
									tab,
									new String [] {
											"description"," heure-deb", "heure-fin","Date"
									});
					jTableRDV = new JTable();
					jScrollPane1.setViewportView(jTableRDV);
					jScrollPane1.setBackground(new java.awt.Color(255,162,255));
					jTableRDV.setModel(jTableRDVModel);
					jTableRDV.getTableHeader().setVisible(true);
					jTableRDV.setBounds(24, 153, 684, 114);
					//jTableRDV.setBackground(new java.awt.Color(192,162,255));
				}
			}
			{
				jSeparator1 = new JSeparator();
				getContentPane().add(jSeparator1);
				jSeparator1.setBounds(12, 114, 719, 10);
			}
			{
				dateRDV = new JButton();
				getContentPane().add(dateRDV);
				dateRDV.setText("Choisir date");
				dateRDV.setBackground(Color.white);
				dateRDV.setBounds(306, 60, 115, 38);
				dateRDV.setIcon(new ImageIcon(getClass().getClassLoader().getResource("date.png")));
				dateRDV.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						new Calendrier(ListAppointmentView.this);
					}
				});
			}
			{
				tous = new JButton();
				getContentPane().add(tous);
				tous.setText("Toutes");
				tous.setBackground(Color.white);
				tous.setBounds(441, 60, 115, 38);
				tous.setIcon(new ImageIcon(getClass().getClassLoader().getResource("date.png")));
				tous.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						ListAppointmentView.this.setDate();
					}
				});
			}
			pack();
			this.setSize(759, 400);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}
	public Object getValueAt(int rowIndex, int columnIndex) {

		AppointmentBean r= appointmentBean.get(rowIndex);
		switch(columnIndex){
		case 0:return r.getId();
		case 1:return r.getHeuredeb();
		case 2:return r.getHeurefin();
		case 3:return r.getDesc();
		case 4:return r.getDate();
		default:return null;
		}
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	public void setDate(String date){
		this.appointmentBean = new AppointmentBean().getListRDV();
		String [][] tab = new String [this.appointmentBean.size()][8];

		for(int i=0,j=0;i<this.appointmentBean.size();i++){
			if(date.equals(this.appointmentBean.get(i).getDate())){
				tab[j][0] = this.appointmentBean.get(i).getDesc();
				tab[j][1] = this.appointmentBean.get(i).getHeuredeb();
				tab[j][2] = this.appointmentBean.get(i).getHeurefin();
				tab[j][3] = this.appointmentBean.get(i).getDate();
				j++;
			}
		}
		TableModel jTableRDVModel = 
				new javax.swing.table.DefaultTableModel(
						tab,
						new String [] {
								"description"," heure-deb", "heure-fin","Date"
						});
		jTableRDV.setModel(jTableRDVModel);
		jTableRDV.setBackground(Color.white);
		this.repaint();
	}
	public void setDate(){
		this.appointmentBean = new AppointmentBean().getListRDV();
		String [][] tab = new String [this.appointmentBean.size()][8];

		for(int i=0;i<this.appointmentBean.size();i++){
				tab[i][0] = this.appointmentBean.get(i).getDesc();
				tab[i][1] = this.appointmentBean.get(i).getHeuredeb();
				tab[i][2] = this.appointmentBean.get(i).getHeurefin();
				tab[i][3] = this.appointmentBean.get(i).getDate();
		}
		TableModel jTableRDVModel = 
				new javax.swing.table.DefaultTableModel(
						tab,
						new String [] {
								"description"," heure-deb", "heure-fin","Date"
						});
		jTableRDV.setModel(jTableRDVModel);
		this.repaint();
	}
}