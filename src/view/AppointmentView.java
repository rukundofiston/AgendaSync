package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import util.Calendrier;
import agenda.Agenda;
import bean.UserBean;

public class AppointmentView extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel heure;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JScrollPane jScrollPane1;
	private JPanel jPanel2;
	private JPanel jPanel1;
	public static JLabel lblDate;
	private JButton btnDate;
	private JButton jButtonModifier;
	private JButton jButtonValider;
	private JTextArea jTextDescription;
	private JComboBox fin;
	private JComboBox Debut;
	static public String date;
	public JFrame frame;
	int id = 0;
	String Fin = "";
	String debut = "";
	String description="";
	public boolean etat = true;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AppointmentView appointment = new AppointmentView();
				appointment.setLocationRelativeTo(null);
				appointment.setVisible(true);
			}
		});
	}

	public AppointmentView(JFrame f) {
		super();
		this.frame = f;
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date = sdf.format(d);
		initGUI();
	}

	public AppointmentView(JFrame f,int id , String debut,String fin, String description, String date) {

		super();
		etat=false;

		this.id=id;
		this.debut=debut;
		this.Fin=fin;
		this.description=description;
		AppointmentView.date=date;
		this.frame = f;
		initGUI();
	}

	public AppointmentView() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(102,153,238));
			this.setTitle("Rendez-Vous");
			{
				heure = new JLabel();
				getContentPane().add(heure);
				heure.setText("Rendez Vous");
				heure.setBounds(176, 12, 140, 16);
				heure.setFont(new java.awt.Font("Comic Sans MS",3,14));
			}
			{
				jPanel2 = new JPanel();
				GroupLayout jPanel2Layout = new GroupLayout((JComponent)jPanel2);
				jPanel2.setLayout(jPanel2Layout);
				getContentPane().add(jPanel2);
				jPanel2.setBounds(40, 68, 160, 90);
				jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Heure:", TitledBorder.LEADING, TitledBorder.TOP, new java.awt.Font("Tahoma",1,11)));
				jPanel2.setBackground(new java.awt.Color(102,153,238));
				{
					jLabel3 = new JLabel();
					jLabel3.setText("Fin      :");
					jLabel3.setBounds(45, 152, 38, 16);
				}
				{
					jLabel2 = new JLabel();
					jLabel2.setText("Debut :");
					jLabel2.setBounds(45, 102, 38, 16);
				}
				{
					ComboBoxModel DebutModel = 
							new DefaultComboBoxModel(
									new String[] { });
					Debut = new JComboBox();
					Debut.setModel(DebutModel);
					Debut.setBounds(118, 99, 97, 23);
					Debut.addItem("8h");
					Debut.addItem("9h");
					Debut.addItem("10h");
					Debut.addItem("11h");
					Debut.addItem("12h");
					Debut.addItem("14h");
					Debut.addItem("15h");
					Debut.addItem("16h");
					Debut.addItem("17h");
					Debut.addItem("18h");
					if(!this.debut.equals("")){
						Debut.setSelectedItem(debut);
					}
					Debut.setBackground(Color.white);
				}
				{
					ComboBoxModel finModel = 
							new DefaultComboBoxModel(
									new String[] { });
					fin = new JComboBox();
					fin.setModel(finModel);
					fin.setBounds(118, 149, 97, 23);
					fin.addItem("9h");
					fin.addItem("10h");
					fin.addItem("11h");
					fin.addItem("12h");
					fin.addItem("15h");
					fin.addItem("16h");
					fin.addItem("17h");
					fin.addItem("18h");
					if(!this.Fin.equals("")){
						fin.setSelectedItem(Fin);
					}
					fin.setBackground(Color.white);
				}
				jPanel2Layout.setHorizontalGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel2Layout.createParallelGroup()
					    .addComponent(jLabel3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					    .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(jPanel2Layout.createParallelGroup()
					    .addComponent(Debut, GroupLayout.Alignment.LEADING, 0, 56, Short.MAX_VALUE)
					    .addComponent(fin, GroupLayout.Alignment.LEADING, 0, 56, Short.MAX_VALUE))
					.addContainerGap());
				jPanel2Layout.setVerticalGroup(jPanel2Layout.createSequentialGroup()
					.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(Debut, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(jLabel2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(fin, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(jLabel3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)));
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Description  :");
				jLabel4.setBounds(36, 196, 97, 16);
			}
			{
				jButtonValider = new JButton();
				getContentPane().add(jButtonValider);
				jButtonValider.setText("Valider");
				jButtonValider.setBackground(Color.white);
				jButtonValider.setIcon(new ImageIcon(getClass().getResource("/icon9.png")));
				jButtonValider.setBounds(52, 314, 104, 32);
				jButtonValider.addActionListener(new ActionListener() {
					@SuppressWarnings("rawtypes")
					public void actionPerformed(ActionEvent evt) {
						String url="rmi://localhost/agenda";
						try {
							Agenda a=(Agenda)Naming.lookup(url);
							if(etat){
								a.ajouterRDV(Debut.getSelectedItem().toString(), fin.getSelectedItem().toString(), date, jTextDescription.getText());
							}else{
								a.modifierRDV(id,Debut.getSelectedItem().toString(), fin.getSelectedItem().toString(), date, jTextDescription.getText().toString());
								etat=false;
							}
						} catch (RemoteException e) {
							e.printStackTrace();
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (NotBoundException e) {
							e.printStackTrace();
						}
						AppointmentView.this.setVisible(false);
						ListAppointmentView inst = new ListAppointmentView(UserBean.test);
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}
				});
			}
			{
				jButtonModifier = new JButton();
				getContentPane().add(jButtonModifier);
				jButtonModifier.setText("Annuler");
				jButtonModifier.setBackground(Color.white);
				jButtonModifier.setIcon(new ImageIcon(getClass().getResource("/icon10.png")));
				jButtonModifier.setBounds(342, 313, 105, 33);
				jButtonModifier.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						AppointmentView.this.setVisible(false);
						ListAppointmentView inst = new ListAppointmentView(UserBean.test);
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}
				});
			}
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1);
				jPanel1.setBounds(310, 68, 160, 90);
				jPanel1.setBackground(new java.awt.Color(102,153,238));
				jPanel1.setBorder(BorderFactory.createTitledBorder("Date:"));
				{
					btnDate = new JButton();
					btnDate.setText("Changer la date");
					btnDate.setBackground(Color.white);
					btnDate.setBounds(311, 144, 97, 23);
					btnDate.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							@SuppressWarnings("unused")
							Calendrier date = new Calendrier();
						}
					});
				}
				{
					lblDate = new JLabel();
					lblDate.setBounds(76, 144, 176, 23);
					lblDate.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
					lblDate.setLocale(new java.util.Locale("fr", "CA"));
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					lblDate.setText(sdf.format(new Date()));
				}
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(btnDate, GroupLayout.Alignment.LEADING, 0, 128, Short.MAX_VALUE)
					    .addComponent(lblDate, GroupLayout.Alignment.LEADING, 0, 128, Short.MAX_VALUE))
					.addContainerGap());
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addComponent(btnDate, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE));
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(145, 196, 294, 91);
				{
					jTextDescription = new JTextArea();
					jScrollPane1.setViewportView(jTextDescription);
					jTextDescription.setBounds(145, 196, 294, 91);
					jTextDescription.setText(description);
					
				}
			}
			pack();
			setSize(500, 400);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}


}