package guiStuff;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import bean.UserG3Bean;
import bean.UserG3BeanRemote;
import entity.UserG3;

public class UpdateProfileFrameG3 extends JFrame {

	/**
	 * @author Nemanja Dragin
	 * GUI za update profile
	 */
	private static final String SERVER_PROJECT = "TwitterServerProjectG3";
	private static InitialContext ctx;
	
	private static final long serialVersionUID = 1L;
	private JButton btnRegister;
	private JButton btnExit;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtEmail;
	private JTextField txtAbout;
	private JTextField txtPassword;
	private JTextField txtBirthDate;
	private JTextField txtTweetName;
	private UserG3BeanRemote userRemote;
	//private JTextField txtAvatar;
	
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws NamingException 
	 */
	public UpdateProfileFrameG3() throws NamingException {
		String statefulName = "ejb:/" + SERVER_PROJECT + "//" + UserG3Bean.class.getSimpleName()
				+ "!" + UserG3BeanRemote.class.getName() + "?stateful";
		ctx= new InitialContext();
		userRemote = (UserG3BeanRemote) ctx.lookup(statefulName);
		setMinimumSize(new Dimension(700, 200));
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomePageG3.class.getResource("/guiStuff/icons/twitter_logo2.png")));
		setSize(new Dimension(787, 315));
		setPreferredSize(new Dimension(700, 300));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setTitle("Twitter registration screen");
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panName = new JPanel();
		getContentPane().add(panName);
		panName.setLayout(new BoxLayout(panName, BoxLayout.X_AXIS));
		
		JPanel panSurname = new JPanel();
		getContentPane().add(panSurname);
		setVisible(true);
		panSurname.setLayout(new BoxLayout(panSurname, BoxLayout.X_AXIS));
		
		JPanel panEmail = new JPanel();
		getContentPane().add(panEmail);
		setVisible(true);
		panEmail.setLayout(new BoxLayout(panEmail, BoxLayout.X_AXIS));
		
		JPanel panPass = new JPanel();
		getContentPane().add(panPass);
		setVisible(true);
		panPass.setLayout(new BoxLayout(panPass, BoxLayout.X_AXIS));
		
		JPanel panAbout = new JPanel();
		getContentPane().add(panAbout);
		setVisible(true);
		panAbout.setLayout(new BoxLayout(panAbout, BoxLayout.X_AXIS));
		
		JPanel panBirthDate = new JPanel();
		getContentPane().add(panBirthDate);
		setVisible(true);
		panBirthDate.setLayout(new BoxLayout(panBirthDate, BoxLayout.X_AXIS));
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panName.add(horizontalStrut_8);
		panName.add(new JLabel("Name : "));
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panSurname.add(horizontalStrut_9);
		panSurname.add(new JLabel("Surname : "));
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		panEmail.add(horizontalStrut_10);
		panEmail.add(new JLabel("Email : "));
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		panPass.add(horizontalStrut_11);
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		panAbout.add(horizontalStrut_14);
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(20);
		panBirthDate.add(horizontalStrut_15);
		JLabel label_3 = new JLabel("Birthday : ");
		panBirthDate.add(label_3);
		
		Component horizontalGlue_7 = Box.createHorizontalGlue();
		panName.add(horizontalGlue_7);
		
		txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(250, 20));
		txtName.setMinimumSize(new Dimension(250, 20));
		txtName.setMaximumSize(new Dimension(250, 20));
		panName.add(txtName);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panName.add(horizontalStrut_7);
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		panSurname.add(horizontalGlue_6);
	
		txtSurname = new JTextField();
		txtSurname.setPreferredSize(new Dimension(250, 20));
		txtSurname.setMinimumSize(new Dimension(250, 20));
		txtSurname.setMaximumSize(new Dimension(250, 20));
		panSurname.add(txtSurname);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panSurname.add(horizontalStrut_6);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		panEmail.add(horizontalGlue_5);
		
		txtEmail = new JTextField();
		txtEmail.setPreferredSize(new Dimension(250, 20));
		txtEmail.setMinimumSize(new Dimension(250, 20));
		txtEmail.setMaximumSize(new Dimension(250, 20));
		panEmail.add(txtEmail);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panEmail.add(horizontalStrut_5);
		
		JLabel label_1 = new JLabel("Pass : ");
		panPass.add(label_1);
		//
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		panPass.add(horizontalGlue_4);
		
		txtPassword = new JTextField();
		txtPassword.setPreferredSize(new Dimension(250, 20));
		txtPassword.setMinimumSize(new Dimension(250, 20));
		txtPassword.setMaximumSize(new Dimension(250, 20));
		panPass.add(txtPassword);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panPass.add(horizontalStrut_4);
		JLabel label_2 = new JLabel("About : ");
		panAbout.add(label_2);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		panAbout.add(horizontalGlue_2);
		
		txtAbout = new JTextField();
		txtAbout.setPreferredSize(new Dimension(250, 20));
		txtAbout.setMinimumSize(new Dimension(250, 20));
		txtAbout.setMaximumSize(new Dimension(250, 20));
		panAbout.add(txtAbout);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panAbout.add(horizontalStrut_2);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		panBirthDate.add(horizontalGlue_3);
		
		txtBirthDate = new JTextField();
		txtBirthDate.setPreferredSize(new Dimension(250, 20));
		txtBirthDate.setMinimumSize(new Dimension(250, 20));
		txtBirthDate.setMaximumSize(new Dimension(250, 20));
		panBirthDate.add(txtBirthDate);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panBirthDate.add(horizontalStrut_3);
		
		JPanel panButtons = new JPanel();
		getContentPane().add(panButtons);
		setVisible(true);
		panButtons.setLayout(new BoxLayout(panButtons, BoxLayout.X_AXIS));
		panButtons.setSize(200, 50);
		btnRegister = new JButton("Register");
		panButtons.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.out.println("btnUnesi.actionPerformed, event="+evt);
				
				String nameUser;
				if((nameUser = txtName.getText()).length() < 1){
					JOptionPane.showMessageDialog(UpdateProfileFrameG3.this, "You must insert your name", "Error!", JOptionPane.ERROR_MESSAGE);
					txtName.requestFocus();
					return;
				}
				nameUser = txtName.getText().trim();

				String surnameUser;
				if((surnameUser = txtSurname.getText()).length() < 1){
					JOptionPane.showMessageDialog(UpdateProfileFrameG3.this, "You must insert your surname", "Error!", JOptionPane.ERROR_MESSAGE);
					txtSurname.requestFocus();
					return;
				}
				surnameUser = txtName.getText().trim();						
				
				String emailUser = txtEmail.getText().trim();	
				
				String passUser;
				if((passUser = txtPassword.getText()).length() < 1){
					JOptionPane.showMessageDialog(UpdateProfileFrameG3.this, "You must insert your password", "Error!", JOptionPane.ERROR_MESSAGE);
					txtPassword.requestFocus();
					return;
				}
				passUser = txtPassword.getText().trim();	

		
				String aboutUser = txtAbout.getText().trim();		
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
				try {
					Date date = sdf.parse(txtBirthDate.getText());
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(UpdateProfileFrameG3.this, "Wrong date format! Date format must be in 'dd.MM.yyyy' format.", "Error!", JOptionPane.ERROR_MESSAGE);
					txtBirthDate.requestFocus();
					return;
				}
				String birthUser = txtBirthDate.getText().trim();				
				
				
				boolean insert = userRemote.updateUser(emailUser, nameUser, surnameUser, passUser, null, aboutUser);
				if (insert) {
					
					JOptionPane.showMessageDialog(UpdateProfileFrameG3.this, "Registration succsessful.");					
					ProfilePageG3 frame = new ProfilePageG3();
					frame.openProfilePage();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(UpdateProfileFrameG3.this, "Registration failed.");
				}
			}
		});
		
		Component horizontalStrut_161 = Box.createHorizontalStrut(20);
		panButtons.add(horizontalStrut_161);
		
		btnExit = new JButton();
		panButtons.add(btnExit);
		btnExit.setText("Exit");
		btnExit.setBounds(205, 155, 112, 23);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					System.out.println("btnExit.actionPerformed, event="+e);
				setVisible(false);
				ProfilePageG3 frame = new ProfilePageG3();
				frame.openProfilePage();
			}
			
		});
		
	}

	public void openUpdatePage(){
		try {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
