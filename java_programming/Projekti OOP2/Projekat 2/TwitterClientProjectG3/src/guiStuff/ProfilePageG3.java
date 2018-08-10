package guiStuff;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Toolkit;

import javax.swing.JTextField;

import bean.UserG3Bean;
import bean.UserG3BeanRemote;
import entity.UserG3;

/**
 * 
 * @author Nemanja Dragin - stranica sa informacijama korisnika
 * Imam problem, ne mogu da ucitam podatke, kada napravim jTextField ili jLabel 
 * JLabel lblName = new JLabel("");
		lblName.setBounds(164, 76, 101, 14);
		contentPane.add(lblName);
		//String userName = loggedUser.getName();
		//lblName.setText(userName);
	izbacuje gresku null pointer exception
 */

public class ProfilePageG3 extends JFrame {

	private JPanel contentPane;
	private static final Logger logger = Logger.getLogger(UpdateProfileFrameG3.class.getName());
	private UserG3 loggedUser;
	private static final String SERVER_PROJECT = "TwitterServerProjectG3";
	private static InitialContext ctx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilePageG3 frame = new ProfilePageG3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProfilePageG3() {
		String statefulName = "ejb:/" + SERVER_PROJECT + "//" + UserG3Bean.class.getSimpleName()
				+ "!" + UserG3BeanRemote.class.getName() + "?stateful";
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProfilePageG3.class.getResource("/guiStuff/icons/twitter_profile_icon.png")));
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomePageG3.class.getResource("/guiStuff/icons/twitter_logo2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUserName.setBounds(23, 70, 112, 26);
		contentPane.add(lblUserName);
		
		JLabel lblUserSurname = new JLabel("Surname");
		lblUserSurname.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUserSurname.setBounds(23, 107, 83, 34);
		contentPane.add(lblUserSurname);
		
		JLabel lblUserEmail = new JLabel("Email");
		lblUserEmail.setBounds(23, 152, 59, 27);
		contentPane.add(lblUserEmail);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setBounds(23, 203, 46, 14);
		contentPane.add(lblAbout);
		
		JButton btnUpdateProfile = new JButton("Update profile");
		btnUpdateProfile.setBounds(23, 13, 138, 24);
		contentPane.add(btnUpdateProfile);
		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					UpdateProfileFrameG3 frame = new UpdateProfileFrameG3();
					frame.openUpdatePage();
					setVisible(false);
				}catch(Exception ex){
					logger.severe("Failed to open register page");
				}
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(402, 324, 101, 26);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					System.out.println("btnLogout.actionPerformed, event="+e);
				setVisible(false);
				try {
					setLoggedUser(null);
					LoginUserFrameG3 frame = new LoginUserFrameG3();
					frame.openLoginPage();
					setVisible(false);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		JButton btnHomePage = new JButton("Home page");
		btnHomePage.setBounds(197, 13, 122, 24);
		contentPane.add(btnHomePage);
		
		JLabel lblName = new JLabel("");
		lblName.setBounds(164, 76, 101, 14);
		contentPane.add(lblName);
		//String userName = loggedUser.getName();
		//lblName.setText(userName);
		
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					HomePageG3 frame = new HomePageG3(loggedUser);
					frame.openHomePage();
					setVisible(false);
				}catch(Exception ex){
					logger.severe("Failed to open home page");
				}
			}
		});

	}
	
	public void openProfilePage(){
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
	
	public void setLoggedUser(UserG3 loggedUser){
		this.loggedUser = loggedUser;
	}

	public UserG3 getLoggedUser(){
		return loggedUser;
	}
	
	
}
