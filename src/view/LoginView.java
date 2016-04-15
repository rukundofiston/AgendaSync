package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import agenda.Agenda;
import bean.UserBean;

public class LoginView extends JFrame {

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
	private JLabel jLabel1;
	private JTextField jTextLogin;
	private JLabel jLabel2;
	private JPanel jPanel1;
	private JButton jButtonValider;
	private JLabel Authentification;
	private JPasswordField jPassword;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginView login= new LoginView();
				login.setLocationRelativeTo(null);
				login.setVisible(true);				
			}
		});
	}

	public LoginView() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(102,153,238));
			this.setTitle("Authentification");
			{
				jPanel1 = new JPanel();
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPanel1);
				jPanel1.setLayout(jPanel1Layout);
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 137, 208, 130);
				jPanel1.setBackground(new java.awt.Color(102,153,238));
				jPanel1.setBorder(BorderFactory.createTitledBorder("Authentification:"));
				{
					jLabel1 = new JLabel();
					jLabel1.setText("Username: ");
					jLabel1.setBounds(18, 116, 74, 16);
					jLabel1.setBackground(Color.white);
				}
				{
					jLabel2 = new JLabel();
					jLabel2.setText("Password : ");
					jLabel2.setBounds(12, 144, 61, 16);
					jLabel2.setBackground(Color.white);
				}
				{
					jTextLogin = new JTextField();
					jTextLogin.setBounds(134, 141, 135, 23);
				}
				{
					jPassword = new JPasswordField();
					jPassword.setBounds(120, 179, 135, 23);
				}
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(jTextLogin, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					    .addComponent(jLabel1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(jPanel1Layout.createSequentialGroup()
					        .addGap(0, 0, Short.MAX_VALUE)
					        .addComponent(jPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addGap(0, 7, Short.MAX_VALUE)
					        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap());
				jPanel1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jLabel1, jLabel2});
				jPanel1Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jTextLogin, jPassword});
				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					        .addGap(12))
					    .addComponent(jLabel2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addComponent(jTextLogin, GroupLayout.Alignment.LEADING, 0, 94, Short.MAX_VALUE)
					    .addGroup(jPanel1Layout.createSequentialGroup()
					        .addComponent(jPassword, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					        .addGap(0, 0, Short.MAX_VALUE)))
					.addContainerGap(90, 90));
				jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jLabel1, jLabel2});
				jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jTextLogin, jPassword});
			}
			{
				Authentification = new JLabel();
				getContentPane().add(Authentification);
				Authentification.setBounds(54, 8, 134, 123);
				Authentification.setFont(new java.awt.Font("Comic Sans MS",1,22));
				Authentification.setIcon(new ImageIcon(getClass().getClassLoader().getResource("login.png")));
			}
			{
				jButtonValider = new JButton();
				getContentPane().add(jButtonValider);
				jButtonValider.setText("Valider");
				jButtonValider.setBackground(Color.white);
				jButtonValider.setBounds(72, 273, 95, 23);
				jButtonValider.addActionListener(new ActionListener() {
					@SuppressWarnings({ "unchecked", "deprecation" })
					public void actionPerformed(ActionEvent evt) {
						String url="rmi://localhost/agenda";
						try {
							Agenda<UserBean> a=(Agenda<UserBean>)Naming.lookup(url);
							UserBean user=a.connect(jTextLogin.getText(),jPassword.getText());

							if(user.getLogin().equals(" ") || user.getPassword().equals("")){ 
								JOptionPane.showMessageDialog(null, "Champs mot de passe et login vides","Erreur",JOptionPane.ERROR_MESSAGE);
							}
							else{
								if(user.getRole().equals("secretaire")|| user.getRole().equals("proprietaire")){
									LoginView.this.setVisible(false);
									UserBean.test = true;
									new ListAppointmentView(true).show();
								}
								else{
									LoginView.this.setVisible(false);
									UserBean.test = false;
									new ListAppointmentView(false).show();
								}
							}
							System.out.println("Bienvenue");
						} 
						catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NotBoundException e1) {

							e1.printStackTrace();
						}
					}
				});
			}
			pack();
			this.setSize(248, 340);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

}
