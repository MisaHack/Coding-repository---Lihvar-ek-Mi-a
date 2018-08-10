package guiStuff;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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


/**
 * 
 * @author Nemanja Dragin
 * Deo GUI-a, samo za Login
 *
 */


/**
 * Rade sve funkcionalnosti koje smo do sad implementirali (logovanje, registracija). Bice malo sredjivanja 
 * izgleda , obrada gresaka i dorada jos nekih sitnica oko tih stranica, ali najbitnije za to, i najveci deo posla radi.
 * Mozete sada krenuti da pravite stranicu za timeline, i metode koje su vezane za nuu, bar najosnovnije. Bilo bi dobro i zavrsiti ceo gui,
 * da znamo koje nam jos metode fale, i da nam ostane vremena da odradimo kako treba sve funkcionalnosti.
 * 
 * P. S. Ne treba za svaku gui stranicu da pravite main metod, potreban je samo na prvoj stranici, ostale se ranuju iz nje (prva je login, iz nje se sve otvara,
 * ni u jednoj drugoj ne treba da ima main metod)
 * @author Nenad
 * Nemanja - Da, main su bili samo da bi se testirao pojedinacno
 * 
 * Resio sam da kada se uloguje ode na twitter timeline
 * 
 * @author Nenad opet su ispravljane funkcionalnosti, primeticete razliku, treba da se 
 * dogovorimo kako ce izgleda lista tweetova korisnika koje pratimo
 *  (ja sam napravio neku pomocnu listu). 
 *  Sada radi kreiranje tweetova i pravilno se loguje i registruje u gui-u i
 *   postoji metoda koja vraca sve tweetove pratilaca korisnika, pa @Nemanja, ti to iskoristi u gui-u u ovu tvoju postojecu funkcionalnost. Bilo bi dobro napraviti taj izgled i 
 *   odraiti gui maksimalno koliko je moguce da bih ja mogao da radim metode koje su potrebne da bi gui funkcio nisao. Pozdrav!
 * 
 * 
 * 
 */
@ApplicationScoped
public class LoginUserFrameG3 extends JFrame {
	
	private static final String SERVER_PROJECT = "TwitterServerProjectG3";
	private static InitialContext ctx;
	private UserG3 loggedUser;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField txtTweetName;
	private JTextField txtPassword;
	private UserG3BeanRemote userRemote;
	private static final Logger logger = Logger.getLogger(TwitterFrameG3.class.getName());

	public LoginUserFrameG3() throws NamingException {
		String statefulName = "ejb:/" + SERVER_PROJECT + "//" + UserG3Bean.class.getSimpleName()
				+ "!" + UserG3BeanRemote.class.getName() + "?stateful";
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomePageG3.class.getResource("/guiStuff/icons/twitter_logo2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		JLabel lblUserPass = new JLabel("Your password : ");
		lblUserPass.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserPass.setBounds(10, 95, 120, 52);
		contentPane.add(lblUserPass);
		
		txtTweetName = new JTextField();
		txtTweetName.setBounds(256, 64, 120, 20);
		contentPane.add(txtTweetName);
		txtTweetName.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setBounds(256, 112, 120, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		ctx= new InitialContext();
		
		// Ovo za userRemote proveriti
		userRemote = (UserG3BeanRemote) ctx.lookup(statefulName);
		userRemote.findAllUsers();
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tweetName = "@" + txtTweetName.getText().trim(); 
				String userPass = txtPassword.getText().trim();
				loggedUser = userRemote.loginUser(tweetName, userPass);
				if (loggedUser !=null) {
					HomePageG3 frame = new HomePageG3(loggedUser);
					frame.openHomePage();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(LoginUserFrameG3.this, "Login failed.");
					logger.severe("Failed login for username : " + userPass + " and password: " + userPass);
				}
			}
		});
		btnLogin.setBounds(70, 146, 274, 42);
		contentPane.add(btnLogin);

		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					RegisterUserFrameG3 frame = new RegisterUserFrameG3();
					frame.openRegistratonPage();
					setVisible(false);
				}catch(Exception ex){
					logger.severe("Failed to open register page");
				}
			}
		});
		
		btnRegister.setBounds(256, 201, 88, 42);
		contentPane.add(btnRegister);

		JLabel lblLoginTwitterScreen = new JLabel("Login to Twitter");
		lblLoginTwitterScreen.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLoginTwitterScreen.setBounds(145, 11, 144, 32);
		contentPane.add(lblLoginTwitterScreen);
		
		JLabel lblYourTwitterName = new JLabel("Your twitter name :");
		lblYourTwitterName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYourTwitterName.setBounds(10, 52, 153, 42);
		contentPane.add(lblYourTwitterName);
		
		JLabel lblYouAreNot = new JLabel("You are not register yet?");
		lblYouAreNot.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYouAreNot.setBounds(70, 214, 174, 16);
		contentPane.add(lblYouAreNot);

}	
		
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{															
					openLoginPage();
				}catch(Exception e){
					logger.severe("Failed to init");
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * @author Nenad Barugdzic
	 */
	public static void openLoginPage(){
		try {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			LoginUserFrameG3 frame = new LoginUserFrameG3();
			frame.setVisible(true);
		} catch (Exception e) {
			logger.severe("Failed to open login page");
		}
	}
}