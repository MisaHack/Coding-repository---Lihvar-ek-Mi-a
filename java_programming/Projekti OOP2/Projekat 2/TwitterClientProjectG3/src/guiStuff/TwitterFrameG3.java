package guiStuff;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import bean.TweetG3Bean;
import bean.TweetG3BeanRemote;
import entity.TweetG3;
import entity.UserG3;
import entity.UserTweetG3;

/**
 * 
 * @author Nemanja Dragin
 * 
 */

@SessionScoped
public class TwitterFrameG3 extends JFrame {
	
	private static final String SERVER_PROJECT = "TwitterServerProjectG3";
	private static InitialContext ctx;
	
	private JPanel contentPane;
	private JTextField txtUserStatus;
	private JTextField txtFollowers;
	private UserTweetG3 userTweets;
	private TweetG3 tweet;
	private JTextField txtUserTweet;
	private TweetG3BeanRemote tweetBean;
	private UserG3 loggedUser;
	private static final Logger logger = Logger.getLogger(TwitterFrameG3.class.getName());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TwitterFrameG3 frame = new TwitterFrameG3();
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
	public TwitterFrameG3() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		txtUserStatus = new JTextField();
		txtUserStatus.setColumns(10);
		
		
		JLabel lblFollowers = new JLabel("Followers tweets :");
		lblFollowers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtFollowers = new JTextField();
		txtFollowers.setColumns(10);
		
		
		JButton btnUpdateStatus = new JButton("Update");
		btnUpdateStatus.setVerticalAlignment(SwingConstants.TOP);
		btnUpdateStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		btnUpdateStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdateStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userStatus = txtUserStatus.getText().toString();
				try {
					ctx= new InitialContext();
				// Ovo za userRemote proveriti
					String statefulName = "ejb:/" + SERVER_PROJECT + "//" + TweetG3Bean.class.getSimpleName()
						+ "!" + TweetG3BeanRemote.class.getName() + "?stateful";
					tweetBean = (TweetG3BeanRemote) ctx.lookup(statefulName);
					
					TweetG3 tweet = new TweetG3();
					tweet.setTweetText(userStatus);
					tweet.setUsers(getLoggedUser());
					Date date = new Date();
					tweet.setCreateDate(new Timestamp(date.getTime()));
					tweetBean.createTweet(tweet);
				} catch(Exception ex){
					logger.severe("Failed create tweet for text: " + userStatus + " , user tweetname: " + getLoggedUser().getTweetname());
					ex.printStackTrace();
				}
				txtUserTweet.setText(userStatus);
				txtUserTweet.setEditable(false);
				
				
				

	/*			List<UserTweetG3> tweets = new ArrayList<>();
				userTweets.setTweets((TweetG3) tweets);
				tweets.add(userTweets);
				*/
			}
		});
		
		txtUserTweet = new JTextField();
		txtUserTweet.setColumns(10);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtUserTweet, 615, 615, 615)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblFollowers, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtFollowers, 615, 615, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addGap(14)
								.addComponent(txtUserStatus, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
								.addGap(41)
								.addComponent(btnUpdateStatus))))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtUserStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnUpdateStatus))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(txtUserTweet, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(78)
					.addComponent(lblFollowers, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtFollowers, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		
		JLabel lblNewLabel = new JLabel("Status :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
		
		TimelineModelG3 model = new TimelineModelG3();
		JTable table = new JTable(model);
		// bez ove naredbe, tabela zauzima minimalan potreban prostor
		table.setFillsViewportHeight(true);
		// GUI komponente u Swing-u nemaju scroll bar
		getContentPane().add(new JScrollPane(table));
	}
	
	/**
	 * @author Nemanja Dragin
	 * Isto kao i Nenadovo, samo je TwitterFrameG3 razlika
	 */
	
	public void openTwitterPage(){
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


