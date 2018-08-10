package guiStuff;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import bean.CommentG3Bean;
import bean.CommentG3BeanRemote;
import bean.TweetG3Bean;
import bean.TweetG3BeanRemote;
import bean.UserG3Bean;
import bean.UserG3BeanRemote;
import bean.UserTweetsG3Bean;
import bean.UserTweetsG3BeanRemote;
import entity.CommentG3;
import entity.TweetG3;
import entity.UserG3;
import entity.UserTweetG3;

/**
 * Izgled "Home" stranice Twitter-a.
 * 
 * @author <a href="mailto:lihvarcekmisa@yahoo.com"> Lihvarcek Misa </a>
 *
 */

public class HomePageG3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private static UserG3 loggedUser;
	private JTextField inputTextField;
	/**
	 * @author Nenad Barugdzic
	 */
	private static final Logger logger = Logger.getLogger(HomePageG3.class.getName());
	private static final String SERVER_PROJECT = "TwitterServerProjectG3";
	private static InitialContext ctx;	
	private UserG3BeanRemote userBean;
	private TweetG3BeanRemote tweetBean;
	private UserTweetsG3BeanRemote userTweetBean;
	private ArrayList<TweetG3> userTweets;
	private ArrayList<TweetG3> timelineTweets;
	private JComboBox searchBox;
	private JPanel optionsPanel;
	private String statefulUserName = "ejb:/" + SERVER_PROJECT + "//" + UserG3Bean.class.getSimpleName()
			+ "!" + UserG3BeanRemote.class.getName() + "?stateful";
	private String statefulTweetName = "ejb:/" + SERVER_PROJECT + "//" + TweetG3Bean.class.getSimpleName()
			+ "!" + TweetG3BeanRemote.class.getName() + "?stateful";
	private String statefulUserTweetName = "ejb:/" + SERVER_PROJECT + "//" + UserTweetsG3Bean.class.getSimpleName()
			+ "!" + UserTweetsG3BeanRemote.class.getName() + "?stateful";
	private String statefulCommentName = "ejb:/" + SERVER_PROJECT + "//" + CommentG3Bean.class.getSimpleName()
			+ "!" + CommentG3BeanRemote.class.getName() + "?stateful";
	private CommentG3BeanRemote comBean;
	private JLabel lblTweetsNumber;
	
	private JPanel tweetsInScrollPanel;
	
	private int tweetPanelSize = 1;

	/**
	 * Pokretanje aplikacije.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageG3 frame = new HomePageG3(loggedUser);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
   /**
    * Metod kreira objekat koji predstavlja Tweet.
	* Takav objekat se moze  ubaciti na Timeline.
    * 
    * @param tweetsInScrollPanel - panel na koji postavljamo tweet-ove
    * @param tweetName - jedinstveno ime korisnika na twitter-u
    * @param tweetContent - sadrzaj poruke koju novi Tweet
    * @return
    */
	public JPanel createNewTweetFrame(JPanel tweetsInScrollPanel,final TweetG3 tw){ //fali jos parametar za vreme
		tweetPanelSize++;
		JPanel tweetFramePanel = new JPanel();
		tweetFramePanel.setBackground(SystemColor.inactiveCaption);
		tweetFramePanel.setPreferredSize(new Dimension(400, 100));
		tweetFramePanel.setMinimumSize(new Dimension(400, 100));
		tweetFramePanel.setMaximumSize(new Dimension(400, 100));
		tweetsInScrollPanel.add(tweetFramePanel);
		tweetFramePanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel tweetNamePanel = new JPanel();
		tweetNamePanel.setMaximumSize(new Dimension(400, 20));
		tweetNamePanel.setMinimumSize(new Dimension(400, 20));
		tweetNamePanel.setPreferredSize(new Dimension(400, 20));
		FlowLayout flowLayout_1 = (FlowLayout) tweetNamePanel.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		tweetNamePanel.setBackground(UIManager.getColor("textHighlight"));
		tweetFramePanel.add(tweetNamePanel);
		
		JLabel lblnameofuserwhopostedtweet = new JLabel(tw.getUsers().getTweetname());
		lblnameofuserwhopostedtweet.setMaximumSize(new Dimension(250, 15));
		lblnameofuserwhopostedtweet.setMinimumSize(new Dimension(250, 15));
		lblnameofuserwhopostedtweet.setPreferredSize(new Dimension(250, 15));
		lblnameofuserwhopostedtweet.setHorizontalAlignment(SwingConstants.LEFT);
		tweetNamePanel.add(lblnameofuserwhopostedtweet);
		/**
		 * @author Nenad Barugdzic
		 */
		JLabel lblTimePosted = new JLabel(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(tw.getCreateDate())); //udeni vreme sa Timestamp
		tweetNamePanel.add(lblTimePosted);
		//
		
		JPanel tweetTextPanel = new JPanel();
		tweetTextPanel.setPreferredSize(new Dimension(400, 20));
		tweetTextPanel.setMaximumSize(new Dimension(400, 20));
		tweetTextPanel.setMinimumSize(new Dimension(400, 20));
		tweetTextPanel.setBackground(UIManager.getColor("textHighlight"));
		tweetFramePanel.add(tweetTextPanel);
		tweetTextPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblTweetContent = new JLabel(tw.getTweetText() + "\r\n");
		lblTweetContent.setPreferredSize(new Dimension(390, 30));
		lblTweetContent.setMinimumSize(new Dimension(390, 14));
		lblTweetContent.setMaximumSize(new Dimension(390, 14));
		tweetTextPanel.add(lblTweetContent);
		
		JPanel functionsPanel = new JPanel();
		functionsPanel.setMaximumSize(new Dimension(400, 20));
		functionsPanel.setMinimumSize(new Dimension(400, 20));
		functionsPanel.setPreferredSize(new Dimension(400, 20));
		FlowLayout flowLayout_2 = (FlowLayout) functionsPanel.getLayout();
		flowLayout_2.setVgap(0);
		flowLayout_2.setHgap(7);
		functionsPanel.setBackground(UIManager.getColor("textHighlight"));
		tweetFramePanel.add(functionsPanel);
		
		JButton btnReply = new JButton("");
		btnReply.setMaximumSize(new Dimension(30, 30));
		btnReply.setMinimumSize(new Dimension(30, 30));
		btnReply.setIcon(new ImageIcon(HomePageG3.class.getResource("/guiStuff/icons/reply_icon.png")));
		btnReply.setToolTipText("Reply");
		btnReply.setPreferredSize(new Dimension(30, 30));
		/**
		 * @author Nenad Barugdzic
		 */
		btnReply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CommentG3 com = new CommentG3();
				com.setCommentText("No functionality");
				com.setTweets(tw);
				com.setUsers(getLoggedUser());
				comBean.createComment(com);
				setVisible(false);
				HomePageG3 frame = new HomePageG3(getLoggedUser());
				frame.setLoggedUser(getLoggedUser());
				frame.setVisible(true);
			}
		});
		functionsPanel.add(btnReply);
		/**
		 * @author Nenad Barugdzic
		 */
		JLabel lblNoReplies = new JLabel(String.valueOf(comBean.getAllCommentsForTweetS(tw).size()));
		//
		lblNoReplies.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoReplies.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNoReplies.setMaximumSize(new Dimension(30, 30));
		lblNoReplies.setMinimumSize(new Dimension(30, 30));
		lblNoReplies.setPreferredSize(new Dimension(30, 30));
		functionsPanel.add(lblNoReplies);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(10, 2));
		horizontalStrut_1.setMinimumSize(new Dimension(10, 2));
		horizontalStrut_1.setPreferredSize(new Dimension(10, 2));
		functionsPanel.add(horizontalStrut_1);
		/**
		 * @author Nenad Barugdzic
		 */
		JButton btnRetweet = new JButton(String.valueOf(userTweetBean.getAllRetweetsForTweet(getLoggedUser(), tw).size()));
		//
		btnRetweet.setToolTipText("Retweet");
		btnRetweet.setMaximumSize(new Dimension(30, 30));
		btnRetweet.setMinimumSize(new Dimension(30, 30));
		btnRetweet.setIcon(new ImageIcon(HomePageG3.class.getResource("/guiStuff/icons/retweet_icon.png")));
		btnRetweet.setPreferredSize(new Dimension(30, 30));
		/**
		 * @author Nenad Barugdzic
		 */
		btnRetweet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TweetG3 twit = new TweetG3();
				twit.setUsers(getLoggedUser());
				twit.setTweetText(tw.getTweetText());
				Date date = new Date();
				twit.setCreateDate(new Timestamp(date.getTime()));
				tweetBean.createTweet(twit);
				UserTweetG3 userTweet = new UserTweetG3();
				userTweet.setUsers(getLoggedUser());
				userTweet.setTweets(tw);
				userTweet.setRetweeted(true);
				userTweetBean.retweet(userTweet);
				setVisible(false);
				HomePageG3 frame = new HomePageG3(getLoggedUser());
				frame.setLoggedUser(getLoggedUser());
				frame.setVisible(true);
			}
		});
		functionsPanel.add(btnRetweet);
		JLabel lblNoRetweets = new JLabel(String.valueOf(userTweetBean.getAllRetweetsForTweet(getLoggedUser(), tw).size()));
		//
		
		lblNoRetweets.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNoRetweets.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoRetweets.setMaximumSize(new Dimension(30, 30));
		lblNoRetweets.setMinimumSize(new Dimension(30, 30));
		lblNoRetweets.setPreferredSize(new Dimension(30, 30));
		functionsPanel.add(lblNoRetweets);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setMaximumSize(new Dimension(10, 2));
		horizontalStrut_2.setMinimumSize(new Dimension(10, 2));
		horizontalStrut_2.setPreferredSize(new Dimension(10, 2));
		functionsPanel.add(horizontalStrut_2);
		
		JButton btnFavourite = new JButton("");
		btnFavourite.setToolTipText("Favourite");
		btnFavourite.setMaximumSize(new Dimension(30, 30));
		btnFavourite.setMinimumSize(new Dimension(30, 30));
		btnFavourite.setPreferredSize(new Dimension(30, 30));
		btnFavourite.setIcon(new ImageIcon(HomePageG3.class.getResource("/guiStuff/icons/favourite_icon.png")));
		/**
		 * @author Nenad Barugdzic
		 */
		btnFavourite.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserTweetG3 userTweet = new UserTweetG3();
				userTweet.setUsers(getLoggedUser());
				userTweet.setTweets(tw);
				userTweet.setFavorite(true);
				userTweetBean.favoriteTweet(userTweet);
				setVisible(false);
				HomePageG3 frame = new HomePageG3(getLoggedUser());
				frame.setLoggedUser(getLoggedUser());
				frame.setVisible(true);
			}
		});
		functionsPanel.add(btnFavourite);	
		
		JLabel lblNoFavourites = new JLabel(String.valueOf(userTweetBean.getAllFavoritesForTweet(getLoggedUser(), tw).size()));
		//
		lblNoFavourites.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNoFavourites.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoFavourites.setMaximumSize(new Dimension(30, 30));
		lblNoFavourites.setMinimumSize(new Dimension(30, 30));
		lblNoFavourites.setPreferredSize(new Dimension(30, 30));
		functionsPanel.add(lblNoFavourites);
		
		tweetPanelSize = tweetPanelSize + tweetFramePanel.getHeight();
	    return tweetFramePanel;	
	}

	/**
	 * Kreiranje okvira.
	 */
	public HomePageG3(UserG3 user) {
		
		setMinimumSize(new Dimension(800, 600));
		/**
		 * @author Nenad Barugdzic
		 */
		setLoggedUser(user);

		try {
			ctx= new InitialContext();
			userBean = (UserG3BeanRemote) ctx.lookup(statefulUserName);
			tweetBean = (TweetG3BeanRemote) ctx.lookup(statefulTweetName);
			userTweetBean = (UserTweetsG3BeanRemote) ctx.lookup(statefulUserTweetName);
			comBean = (CommentG3BeanRemote) ctx.lookup(statefulCommentName);
		} catch (NamingException e2) {
			// TODO Auto-generated catch block
			logger.severe("Failed to get UserG3BeanRemote");
			e2.printStackTrace();
		}
		timelineTweets = tweetBean.getTimelineTweets(getLoggedUser());
		ArrayList<UserG3> following = userBean.findFollowing(getLoggedUser());
		ArrayList<UserG3> followers = userBean.findFollowers(getLoggedUser());
		///end nenad
		
		setTitle("Twitter Home");
		//sistemski look & feel
		try{
		   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){
		   e.printStackTrace();	
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomePageG3.class.getResource("/guiStuff/icons/twitter_logo2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//velicina pocetnog prozora
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(200, 25));
		contentPane.setMinimumSize(new Dimension(200, 25));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//osnovni panel
		optionsPanel = new JPanel();
		contentPane.add(optionsPanel, BorderLayout.NORTH);
		
		//postavljamo istu dimenziju za sve dugmice
		Dimension d = new Dimension(100,25);
		optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.X_AXIS));
		
		Component h_strut_1 = Box.createHorizontalStrut(5);
		optionsPanel.add(h_strut_1);
		
		//"Home" dugme
		JButton btnHome = new JButton("Home");
		btnHome.setIconTextGap(10);
		btnHome.setIcon(new ImageIcon(HomePageG3.class.getResource("/guiStuff/icons/twitter_home__icon.png")));
		btnHome.setToolTipText("Home page");
		setButtonSize(btnHome, d);		
		btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				HomePageG3 frame = new HomePageG3(getLoggedUser());
				frame.setLoggedUser(getLoggedUser());
				frame.setVisible(true);
			}
		});
		optionsPanel.add(btnHome);
		
		
		Component h_strut_2 = Box.createHorizontalStrut(5);
		optionsPanel.add(h_strut_2);
		
		//"Profile" dugme
		JButton btnProfile = new JButton("Profile");
		btnProfile.setIconTextGap(10);
		btnProfile.setIcon(new ImageIcon(HomePageG3.class.getResource("/guiStuff/icons/twitter_profile_icon.png")));
		btnProfile.setToolTipText("Profile page");
		btnProfile.setMinimumSize(new Dimension(100, 25));
		btnProfile.setMaximumSize(new Dimension(100, 25));
		btnProfile.setPreferredSize(new Dimension(100, 25));
		setButtonSize(btnProfile, d);
		/**
		 * @author Nenad Barugdzic
		 */
		btnProfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				ProfilePageNewG3 prof = new ProfilePageNewG3(getLoggedUser());
				prof.setLoggedUser(getLoggedUser());
				prof.setVisible(true);
			}
		});
		optionsPanel.add(btnProfile);
		/**
		 * @author Nenad Barugdzic
		 */
		
		
		
		Component h_strut_3 = Box.createHorizontalStrut(15);
		h_strut_3.setMaximumSize(new Dimension(20, 32767));
		h_strut_3.setMinimumSize(new Dimension(20, 0));
		h_strut_3.setPreferredSize(new Dimension(20, 0));
		optionsPanel.add(h_strut_3);
		
		JLabel searchLabel = new JLabel("");
		searchLabel.setSize(new Dimension(25, 25));
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		searchLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		searchLabel.setIconTextGap(0);
		searchLabel.setPreferredSize(new Dimension(25, 25));
		searchLabel.setMinimumSize(new Dimension(25, 25));
		searchLabel.setMaximumSize(new Dimension(25, 25));
		searchLabel.setIcon(new ImageIcon(HomePageG3.class.getResource("/guiStuff/icons/search_icon.png")));
		optionsPanel.add(searchLabel);
		
		Component h_strut_4 = Box.createHorizontalStrut(5);
		optionsPanel.add(h_strut_4);
		txtSearch = new JTextField();
		txtSearch.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtSearch.setBounds(new Rectangle(0, 0, 0, 200));
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearch.setSize(new Dimension(200, 25));
		txtSearch.setMinimumSize(new Dimension(200, 25));
		txtSearch.setMaximumSize(new Dimension(200, 25));
		txtSearch.setText("Search twitter...");
		txtSearch.setPreferredSize(new Dimension(200, 25));
		/**
		 * @author Nenad Barugdzic
		 */
		txtSearch.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				txtSearch.setText("Search twitter...");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtSearch.setText("");
				
			}
		});
		optionsPanel.add(txtSearch);
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<UserG3> searchedUsers = userBean.searchUsersByTweetname(txtSearch.getText()+"%");
				System.out.println(" BROJ koris " + searchedUsers.size() + " text " + txtSearch.getText());
				fillComboBox(searchedUsers);
			}
		});
		//
		Component h_strut_5 = Box.createHorizontalStrut(5);
		optionsPanel.add(h_strut_5);
		
		searchBox = new JComboBox();
		searchBox.addItem("Search tweeters..");
		searchBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		searchBox.setMaximumRowCount(10);
		searchBox.setToolTipText("Search results");
		searchBox.setMinimumSize(new Dimension(100, 25));
		searchBox.setMaximumSize(new Dimension(100, 25));
		searchBox.setPreferredSize(new Dimension(100, 25));
		searchBox.setMaximumRowCount(5);
		optionsPanel.add(searchBox);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setMaximumSize(new Dimension(5, 32767));
		horizontalStrut_3.setMinimumSize(new Dimension(5, 0));
		horizontalStrut_3.setPreferredSize(new Dimension(5, 0));
		optionsPanel.add(horizontalStrut_3);
		
		JButton btnFollow = new JButton("Follow");
		btnFollow.setPreferredSize(new Dimension(100, 25));
		btnFollow.setMinimumSize(new Dimension(100, 25));
		btnFollow.setMaximumSize(new Dimension(100, 25));
		btnFollow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				String tweetname = (String)searchBox.getSelectedItem();
				System.out.println(" tweetname  " + tweetname);
				UserG3 u = userBean.searchUsersByTweetnameFull(tweetname);
				System.out.println("User " + u);
				if (u!=null){
					userBean.followUser(u.getId(),getLoggedUser().getId());
				}
				setVisible(false);
				HomePageG3 frame = new HomePageG3(getLoggedUser());
				frame.setLoggedUser(getLoggedUser());
				frame.setVisible(true);
			}
		});
		optionsPanel.add(btnFollow);
		
		
		Component horizontalGlue = Box.createHorizontalGlue();
		optionsPanel.add(horizontalGlue);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setPreferredSize(new Dimension(2, 0));
		horizontalStrut_4.setMaximumSize(new Dimension(2, 32767));
		horizontalStrut_4.setMinimumSize(new Dimension(2, 0));
		optionsPanel.add(horizontalStrut_4);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setToolTipText("Log out");
		btnLogOut.setIcon(null);
		btnLogOut.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		optionsPanel.add(btnLogOut);
		btnLogOut.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnLogOut.setMinimumSize(new Dimension(100, 25));
		btnLogOut.setMaximumSize(new Dimension(100, 25));
		btnLogOut.setPreferredSize(new Dimension(100, 25));
		/**
		 * @author Nenad Barugdzic
		 */
		btnLogOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					System.out.println("btnExit.actionPerformed, event="+e);
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
		
		Component h_strut_6 = Box.createHorizontalStrut(5);
		optionsPanel.add(h_strut_6);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setContinuousLayout(true);
		splitPane.setResizeWeight(0.3);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(320, 10));
		infoPanel.setMinimumSize(new Dimension(320, 10));
		infoPanel.setMaximumSize(new Dimension(320, 32767));
		splitPane.setLeftComponent(infoPanel);
		infoPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setMinimumSize(new Dimension(350, 22222));
		splitPane_1.setPreferredSize(new Dimension(350, 2222222));
		splitPane_1.setEnabled(false);
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		infoPanel.add(splitPane_1);
		
		JPanel avatarPanel = new JPanel();
		avatarPanel.setMaximumSize(new Dimension(350, 200));
		avatarPanel.setPreferredSize(new Dimension(350, 200));
		avatarPanel.setMinimumSize(new Dimension(350, 200));
		splitPane_1.setLeftComponent(avatarPanel);
		avatarPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel avatarLabel = new JLabel("");
		avatarLabel.setPreferredSize(new Dimension(100, 100));
		avatarLabel.setMaximumSize(new Dimension(100, 100));
		avatarLabel.setMinimumSize(new Dimension(100, 100));
		avatarLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		avatarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		avatarLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		avatarLabel.setIcon(new ImageIcon(HomePageG3.class.getResource("/guiStuff/icons/twitterAvatar.png")));
		avatarPanel.add(avatarLabel);
		
		JLabel lblTweetname = new JLabel(getLoggedUser().getTweetname());
		lblTweetname.setFont(new Font("Tahoma", Font.BOLD, 13));
		avatarPanel.add(lblTweetname, BorderLayout.SOUTH);
		
		
		JPanel userStatsPanel = new JPanel();
		userStatsPanel.setMaximumSize(new Dimension(350, 32767));
		userStatsPanel.setMinimumSize(new Dimension(350, 300));
		userStatsPanel.setPreferredSize(new Dimension(350, 300));
		splitPane_1.setRightComponent(userStatsPanel);
		userStatsPanel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JPanel tweetsBtnPanel = new JPanel();
		tweetsBtnPanel.setPreferredSize(new Dimension(350, 25));
		tweetsBtnPanel.setMaximumSize(new Dimension(350, 25));
		tweetsBtnPanel.setMinimumSize(new Dimension(350, 25));
		userStatsPanel.add(tweetsBtnPanel);
		tweetsBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnTweets = new JButton("TWEETS");
		btnTweets.setToolTipText("Your Tweets");
		btnTweets.setPreferredSize(new Dimension(100, 25));
		tweetsBtnPanel.add(btnTweets);
		
		JButton btnFollowing = new JButton("FOLLOWING");
		btnFollowing.setToolTipText("People you are following");
		btnFollowing.setPreferredSize(new Dimension(100, 25));
		btnFollowing.setMaximumSize(new Dimension(100, 25));
		btnFollowing.setMinimumSize(new Dimension(100, 25));
		tweetsBtnPanel.add(btnFollowing);
		
		JButton btnNewButton = new JButton("FOLLOWERS");
		btnNewButton.setToolTipText("People that follow you");
		btnNewButton.setMaximumSize(new Dimension(100, 25));
		btnNewButton.setMinimumSize(new Dimension(100, 25));
		btnNewButton.setPreferredSize(new Dimension(100, 25));
		tweetsBtnPanel.add(btnNewButton);
		
		JPanel tweetsLblPanel = new JPanel();
		tweetsLblPanel.setMaximumSize(new Dimension(350, 32767));
		tweetsLblPanel.setMinimumSize(new Dimension(350, 10));
		tweetsLblPanel.setPreferredSize(new Dimension(350, 10));
		userStatsPanel.add(tweetsLblPanel);
		
		lblTweetsNumber = new JLabel();
		lblTweetsNumber.setText(String.valueOf(getUserTweets().size()));
		lblTweetsNumber.setMaximumSize(new Dimension(100, 25));
		lblTweetsNumber.setMinimumSize(new Dimension(100, 25));
		lblTweetsNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblTweetsNumber.setPreferredSize(new Dimension(100, 25));
		tweetsLblPanel.add(lblTweetsNumber);
		
		JLabel lblFollowingNumber = new JLabel(String.valueOf(following.size()));
		lblFollowingNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblFollowingNumber.setMaximumSize(new Dimension(100, 25));
		lblFollowingNumber.setMinimumSize(new Dimension(100, 25));
		lblFollowingNumber.setPreferredSize(new Dimension(100, 25));
		tweetsLblPanel.add(lblFollowingNumber);
		
		JLabel lblFollowersNumber = new JLabel(String.valueOf(followers.size()));
		lblFollowersNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblFollowersNumber.setPreferredSize(new Dimension(100, 25));
		lblFollowersNumber.setMinimumSize(new Dimension(100, 25));
		lblFollowersNumber.setMaximumSize(new Dimension(100, 25));
		tweetsLblPanel.add(lblFollowersNumber);
		
		JPanel timelinePanel = new JPanel();
		timelinePanel.setMinimumSize(new Dimension(400, 10));
		timelinePanel.setPreferredSize(new Dimension(400, 10));
		timelinePanel.setMaximumSize(new Dimension(400, 32767));
		splitPane.setRightComponent(timelinePanel);
		timelinePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(UIManager.getColor("Label.background"));
		statusPanel.setPreferredSize(new Dimension(50, 110));
		statusPanel.setMaximumSize(new Dimension(200, 100));
		statusPanel.setMinimumSize(new Dimension(200, 100));
		timelinePanel.add(statusPanel, BorderLayout.NORTH);
		statusPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel userTextFieldPanel = new JPanel();
		userTextFieldPanel.setPreferredSize(new Dimension(440, 110));
		userTextFieldPanel.setMaximumSize(new Dimension(400, 110));
		userTextFieldPanel.setMinimumSize(new Dimension(400, 110));
		userTextFieldPanel.setBackground(UIManager.getColor("Button.shadow"));
		statusPanel.add(userTextFieldPanel);
		userTextFieldPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel inputTextFieldPanel = new JPanel();
		inputTextFieldPanel.setMinimumSize(new Dimension(200, 10));
		inputTextFieldPanel.setPreferredSize(new Dimension(200, 10));
		FlowLayout fl_inputTextFieldPanel = (FlowLayout) inputTextFieldPanel.getLayout();
		fl_inputTextFieldPanel.setVgap(16);
		inputTextFieldPanel.setBackground(UIManager.getColor("Button.shadow"));
		inputTextFieldPanel.setMaximumSize(new Dimension(200, 10));
		userTextFieldPanel.add(inputTextFieldPanel);
		
		inputTextField = new JTextField();
		inputTextField.setText("What's happening?");
		inputTextField.setMaximumSize(new Dimension(200, 30));
		inputTextField.setMinimumSize(new Dimension(200, 30));
		inputTextField.setPreferredSize(new Dimension(400, 30));
		/**
		 * @author Nenad Barugdzic
		 */
		inputTextField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				inputTextField.setText("");
				
			}
		});
		inputTextFieldPanel.add(inputTextField);
		//
		JPanel inputTweetBtnPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) inputTweetBtnPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		inputTweetBtnPanel.setBackground(UIManager.getColor("Button.shadow"));
		userTextFieldPanel.add(inputTweetBtnPanel);
		
		
		JLabel lblNoCharacters = new JLabel("140");
		inputTweetBtnPanel.add(lblNoCharacters);
		
		JButton btnTweet = new JButton("Tweet");
		btnTweet.setToolTipText("Post Tweet");
		btnTweet.setIconTextGap(10);
		btnTweet.setIcon(new ImageIcon(HomePageG3.class.getResource("/guiStuff/icons/twitter_tweet_icon.png")));
		btnTweet.setMaximumSize(new Dimension(100, 25));
		btnTweet.setMinimumSize(new Dimension(100, 25));
		btnTweet.setPreferredSize(new Dimension(120, 25));
		/**
		 * @author Nenad Barugdzic
		 */
		btnTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tweetTxt = inputTextField.getText();
				if (tweetTxt.length()>140){
					tweetTxt = tweetTxt.substring(0, 130) + "...";
				}
				TweetG3 tweet = new TweetG3();
				tweet.setUsers(getLoggedUser());
				Date date = new Date();
				tweet.setCreateDate(new Timestamp(date.getTime()));
				tweet.setTweetText(tweetTxt);
				tweetBean.createTweet(tweet);
				setUserTweets(null);
				inputTextField.setText("What's happening?");
				refreshTweetsInScrollPanel(timelineTweets);
				setVisible(false);
				HomePageG3 frame = new HomePageG3(getLoggedUser());
				frame.setLoggedUser(getLoggedUser());
				frame.setVisible(true);
			}
		});
		inputTweetBtnPanel.add(btnTweet);
		
		
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		inputTweetBtnPanel.add(horizontalStrut);
		
//		JPanel tweetsPanel = new JPanel();
//		timelinePanel.add(tweetsPanel, BorderLayout.CENTER);
		
		tweetsInScrollPanel = new JPanel();
		tweetsInScrollPanel.setLayout(new BoxLayout(tweetsInScrollPanel, BoxLayout.Y_AXIS));
//		tweetsInScrollPanel.setMaximumSize(new Dimension(400, 300));
//		tweetsInScrollPanel.setMinimumSize(new Dimension(400, 300));
//		tweetsInScrollPanel.setPreferredSize(new Dimension(400, 300));
//		tweetsPanel.add(tweetsInScrollPanel);
		

		
		//--------End Tweet--------------
		
		JPanel tweetFramePanel = new JPanel();
		tweetFramePanel.setBackground(SystemColor.inactiveCaption);
		tweetFramePanel.setPreferredSize(new Dimension(400, 100));
		tweetFramePanel.setMinimumSize(new Dimension(400, 100));
		tweetFramePanel.setMaximumSize(new Dimension(400, 100));
		tweetsInScrollPanel.add(tweetFramePanel);
		tweetFramePanel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel tweetNamePanel = new JPanel();
		tweetNamePanel.setMaximumSize(new Dimension(400, 20));
		tweetNamePanel.setMinimumSize(new Dimension(400, 20));
		tweetNamePanel.setPreferredSize(new Dimension(400, 20));
		FlowLayout flowLayout_1 = (FlowLayout) tweetNamePanel.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		tweetNamePanel.setBackground(UIManager.getColor("textHighlight"));
		tweetFramePanel.add(tweetNamePanel);
		
//		JLabel lblnameofuserwhopostedtweet = new JLabel("@NameOfUserWhoPostedTweet");
//		lblnameofuserwhopostedtweet.setMaximumSize(new Dimension(250, 15));
//		lblnameofuserwhopostedtweet.setMinimumSize(new Dimension(250, 15));
//		lblnameofuserwhopostedtweet.setPreferredSize(new Dimension(250, 15));
//		lblnameofuserwhopostedtweet.setHorizontalAlignment(SwingConstants.LEFT);
//		tweetNamePanel.add(lblnameofuserwhopostedtweet);
//		
//		JLabel lblTimePosted = new JLabel("Time Tweet posted");
//		tweetNamePanel.add(lblTimePosted);
//		
//		JPanel tweetTextPanel = new JPanel();
//		tweetTextPanel.setPreferredSize(new Dimension(400, 20));
//		tweetTextPanel.setMaximumSize(new Dimension(400, 20));
//		tweetTextPanel.setMinimumSize(new Dimension(400, 20));
//		tweetTextPanel.setBackground(UIManager.getColor("textHighlight"));
//		tweetFramePanel.add(tweetTextPanel);
//		tweetTextPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
//		
//		JLabel lblTweetContent = new JLabel("Tweet content\r\n");
//		lblTweetContent.setPreferredSize(new Dimension(390, 30));
//		lblTweetContent.setMinimumSize(new Dimension(390, 14));
//		lblTweetContent.setMaximumSize(new Dimension(390, 14));
//		tweetTextPanel.add(lblTweetContent);
//		
//		JPanel functionsPanel = new JPanel();
//		functionsPanel.setMaximumSize(new Dimension(400, 20));
//		functionsPanel.setMinimumSize(new Dimension(400, 20));
//		functionsPanel.setPreferredSize(new Dimension(400, 20));
//		FlowLayout flowLayout_2 = (FlowLayout) functionsPanel.getLayout();
//		flowLayout_2.setVgap(0);
//		flowLayout_2.setHgap(7);
//		functionsPanel.setBackground(UIManager.getColor("textHighlight"));
//		tweetFramePanel.add(functionsPanel);
//		
//		JButton btnReply = new JButton("");
//		btnReply.setMaximumSize(new Dimension(30, 30));
//		btnReply.setMinimumSize(new Dimension(30, 30));
//		btnReply.setIcon(new ImageIcon(HomePageG3.class.getResource("/guiStuff/icons/reply_icon.png")));
//		btnReply.setToolTipText("Reply");
//		btnReply.setPreferredSize(new Dimension(30, 30));
//		functionsPanel.add(btnReply);
//		
//		JLabel lblNoReplies = new JLabel("123");
//		lblNoReplies.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNoReplies.setHorizontalTextPosition(SwingConstants.CENTER);
//		lblNoReplies.setMaximumSize(new Dimension(30, 30));
//		lblNoReplies.setMinimumSize(new Dimension(30, 30));
//		lblNoReplies.setPreferredSize(new Dimension(30, 30));
//		functionsPanel.add(lblNoReplies);
//		
//		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
//		horizontalStrut_1.setMaximumSize(new Dimension(10, 2));
//		horizontalStrut_1.setMinimumSize(new Dimension(10, 2));
//		horizontalStrut_1.setPreferredSize(new Dimension(10, 2));
//		functionsPanel.add(horizontalStrut_1);
//		
//		JButton btnRetweet = new JButton("");
//		btnRetweet.setToolTipText("Retweet");
//		btnRetweet.setMaximumSize(new Dimension(30, 30));
//		btnRetweet.setMinimumSize(new Dimension(30, 30));
//		btnRetweet.setIcon(new ImageIcon(HomePageG3.class.getResource("/guiStuff/icons/retweet_icon.png")));
//		btnRetweet.setPreferredSize(new Dimension(30, 30));
//		functionsPanel.add(btnRetweet);
//		
//		JLabel lblNoRetweets = new JLabel("3");
//		lblNoRetweets.setHorizontalTextPosition(SwingConstants.CENTER);
//		lblNoRetweets.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNoRetweets.setMaximumSize(new Dimension(30, 30));
//		lblNoRetweets.setMinimumSize(new Dimension(30, 30));
//		lblNoRetweets.setPreferredSize(new Dimension(30, 30));
//		functionsPanel.add(lblNoRetweets);
//		
//		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
//		horizontalStrut_2.setMaximumSize(new Dimension(10, 2));
//		horizontalStrut_2.setMinimumSize(new Dimension(10, 2));
//		horizontalStrut_2.setPreferredSize(new Dimension(10, 2));
//		functionsPanel.add(horizontalStrut_2);
//		
//		JButton btnFavourite = new JButton("");
//		btnFavourite.setToolTipText("Favourite");
//		btnFavourite.setMaximumSize(new Dimension(30, 30));
//		btnFavourite.setMinimumSize(new Dimension(30, 30));
//		btnFavourite.setPreferredSize(new Dimension(30, 30));
//		btnFavourite.setIcon(new ImageIcon(HomePageG3.class.getResource("/guiStuff/icons/favourite_icon.png")));
//		functionsPanel.add(btnFavourite);
		
//		JLabel lblNoFavourites = new JLabel("78");
//		lblNoFavourites.setHorizontalTextPosition(SwingConstants.CENTER);
//		lblNoFavourites.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNoFavourites.setMaximumSize(new Dimension(30, 30));
//		lblNoFavourites.setMinimumSize(new Dimension(30, 30));
//		lblNoFavourites.setPreferredSize(new Dimension(30, 30));
//		functionsPanel.add(lblNoFavourites);

		//------------------------------------------------------------------------		
		
//		tweetsPanel.add(scrollPane);
		
	
		refreshTweetsInScrollPanel(timelineTweets);
		tweetsInScrollPanel.setPreferredSize(new Dimension(400, tweetPanelSize));
		JScrollPane scrollPane = new JScrollPane(tweetsInScrollPanel);
		scrollPane.setSize(400, tweetPanelSize);
		scrollPane.createVerticalScrollBar();
		tweetsInScrollPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		scrollPane.setViewportView(tweetsInScrollPanel);
		timelinePanel.add(new JScrollPane(tweetsInScrollPanel));
//		JPanel tweetFramePanel2 = new JPanel();
//		tweetFramePanel2.setBackground(SystemColor.activeCaption);
//		tweetFramePanel2.setPreferredSize(new Dimension(400, 100));
//		tweetFramePanel2.setMinimumSize(new Dimension(400, 100));
//		tweetFramePanel2.setMaximumSize(new Dimension(400, 100));
//		tweetsInScrollPanel.add(tweetFramePanel2);
//		
//		JPanel tweetFramePanel3 = new JPanel();
//		tweetFramePanel3.setBackground(SystemColor.activeCaption);
//		tweetFramePanel3.setPreferredSize(new Dimension(400, 100));
//		tweetFramePanel3.setMinimumSize(new Dimension(400, 100));
//		tweetFramePanel3.setMaximumSize(new Dimension(400, 100));
//		tweetsInScrollPanel.add(tweetFramePanel3);
//		
//		JPanel tweetFramePanel4 = new JPanel();
//		tweetFramePanel4.setBackground(SystemColor.activeCaption);
//		tweetFramePanel4.setPreferredSize(new Dimension(400, 100));
//		tweetFramePanel4.setMinimumSize(new Dimension(400, 100));
//		tweetFramePanel4.setMaximumSize(new Dimension(400, 100));
//		tweetsInScrollPanel.add(tweetFramePanel4);
//		
//		JPanel tweetFramePanel5 = new JPanel();
//		tweetFramePanel5.setBackground(SystemColor.activeCaption);
//		tweetFramePanel5.setPreferredSize(new Dimension(400, 100));
//		tweetFramePanel5.setMinimumSize(new Dimension(400, 100));
//		tweetFramePanel5.setMaximumSize(new Dimension(400, 100));
//		tweetsInScrollPanel.add(tweetFramePanel5);
		
		
			
}
	
	public void setButtonSize(JButton btn,Dimension d){
		btn.setPreferredSize(d);
		btn.setMinimumSize(d);
		btn.setMaximumSize(d);
	}
	/**
	 * @author Nenad Barugdzic
	 */
	public void setLoggedUser(UserG3 loggedUser){
		this.loggedUser = loggedUser;
	}
	/**
	 * @author Nenad Barugdzic
	 */
	public UserG3 getLoggedUser(){
		return loggedUser;
	}
	/**
	 * @author Nenad Barugdzic
	 */
	public void openHomePage(){
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
	/**
	 * @author Nenad Barugdzic
	 */
	public void setUserTweets(ArrayList<TweetG3> userTweets) {
		this.userTweets = userTweets;
	}
	/**
	 * @author Nenad Barugdzic
	 */
	public ArrayList<TweetG3> getUserTweets(){
		if (userTweets==null){
			try {
				ctx= new InitialContext();
				tweetBean = (TweetG3BeanRemote) ctx.lookup(statefulTweetName);
				userTweets = tweetBean.getTweetsForUser(getLoggedUser());
				lblTweetsNumber.validate();
				lblTweetsNumber.repaint();
			} catch (NamingException e2) {
				// TODO Auto-generated catch block
				
				logger.severe("Failed to get UserG3BeanRemote");
				e2.printStackTrace();
				return null;
			}
		}
		return userTweets;
	}
	/**
	 * @author Nenad Barugdzic
	 */
	public void setTimelineTweets(ArrayList<TweetG3> timelineTweets) {
		this.timelineTweets = timelineTweets;
	}
	/**
	 * @author Nenad Barugdzic
	 */
	public ArrayList<TweetG3> getTimelineTweets(){
		if (timelineTweets==null){
			try {
				ctx= new InitialContext();
				tweetBean = (TweetG3BeanRemote) ctx.lookup(statefulTweetName);
				timelineTweets = tweetBean.getTimelineTweets(getLoggedUser());
			} catch (NamingException e2) {
				// TODO Auto-generated catch block
				
				logger.severe("Failed to get TweetG3BeanRemote");
				e2.printStackTrace();
				return null;
			}
		}
		return timelineTweets;
	}
	
	/**
	 * @author Nenad Barugdzic
	 */
	public void fillComboBox(ArrayList<UserG3> searchedUser){
		System.out.println(" Broj takvih korisnika " + searchedUser.size());
		searchBox.removeAllItems();
		searchBox.updateUI();
		searchBox.validate();
		for (UserG3 user : searchedUser){
			searchBox.addItem(user.getTweetname());
		}
		searchBox.updateUI();
		searchBox.validate();
	}
	
	/**
	 * @author Nenad Barugdzic
	 */
	public void refreshTweetsInScrollPanel(ArrayList<TweetG3> tweets){
		tweetsInScrollPanel.removeAll();
		tweetsInScrollPanel.updateUI();
		tweetsInScrollPanel.validate();
		for (TweetG3 tweet : tweets){
			createNewTweetFrame(tweetsInScrollPanel, tweet);
		}
		tweetsInScrollPanel.updateUI();
		tweetsInScrollPanel.validate();
	}
}
