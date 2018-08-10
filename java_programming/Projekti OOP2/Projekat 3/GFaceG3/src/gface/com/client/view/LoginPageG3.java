package gface.com.client.view;

import gface.com.client.ErrorDlg;
import gface.com.client.GFaceG3;
import gface.com.client.services.UserService;
import gface.com.client.services.UserServiceAsync;
import gface.com.server.entity.UserG3;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class LoginPageG3 extends View {
	private static final UserServiceAsync userService = GWT.create(UserService.class);

	private Button sendButton;
	private Button sendButton_1;
	private Button registerButton;
	private Button registerButton_1;
	private TextBox nameField;
	private PasswordTextBox passwordField;
	private UserG3 loggedUser;
	private AbsolutePanel absolutePanel;
	private AbsolutePanel absolutePanel_1;
	
	
	public LoginPageG3(GFaceG3 gfaceg3){
		super(gfaceg3);
		setSpacing(4);
		setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);
		sendButton = new Button("Login");
		registerButton = new Button("Register");
		
		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		add(absolutePanel_2);
		absolutePanel_2.setHeight("105px");
		absolutePanel_2.setWidth("800px");
		HTML html = new HTML("<h1>Welcome to GFace</h1>");
		absolutePanel_2.add(html, 203, 10);
		html.setSize("338px", "15px");
		
		absolutePanel_1 = new AbsolutePanel();
		add(absolutePanel_1);
		absolutePanel_1.setSize("800px", "301px");
		// We can add style names to widgets
		
		HTML htmlpleaseEnterYour = new HTML("<b>Please enter your name: </b>");
		absolutePanel_1.add(htmlpleaseEnterYour, 10, 10);
		htmlpleaseEnterYour.setSize("162px", "15px");
		nameField = new TextBox();
		absolutePanel_1.add(nameField, 214, 4);
		nameField.setTitle("Enter your username");
		nameField.setSize("163px", "15px");
		HTML newPassword = new HTML("<b>Please enter your password: </b>");
		absolutePanel_1.add(newPassword, 10, 45);
		newPassword.setSize("183px", "15px");
		passwordField = new PasswordTextBox();
		absolutePanel_1.add(passwordField, 214, 39);
		passwordField.setTitle("Enter your username");
		passwordField.setSize("163px", "15px");
		sendButton_1 = new Button("Login", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				tryLogin();
			}
		});
		absolutePanel_1.add(sendButton_1, 214, 92);
		sendButton_1.setSize("169px", "26px");
		HTML html_1 = new HTML("<br/><br/><hr />");
		absolutePanel_1.add(html_1, 10, 144);
		html_1.setSize("781px", "26px");
		
		Label lblNewOnGface = new Label("New on GFace?");
		absolutePanel_1.add(lblNewOnGface, 38, 222);
		lblNewOnGface.setSize("134px", "18px");
		registerButton_1 = new Button("Register", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				System.out.println("Otvorio register");
				GFaceG3 gface = LoginPageG3.this.gfaceg3;
				gface.showView(new RegisterPageG3(gface));
			}
		});
		absolutePanel_1.add(registerButton_1, 214, 214);
		registerButton_1.setSize("169px", "26px");
		
		Image image = new Image("images/gfacelogo.jpg");
		absolutePanel_1.add(image, 493, 10);
		image.setSize("307px", "160px");
		
		absolutePanel = new AbsolutePanel();
		absolutePanel.setWidth("100%");
		add(absolutePanel);
		
		
		registerButton.addStyleName("registerButton");
		sendButton.addStyleName("sendButton");
		
	}

	private void tryLogin() {
		System.out.println(" USAO U LOGOVANJEE!!!");
		userService.login(nameField.getText(), passwordField.getText(), new AsyncCallback<UserG3>() {
			@Override
			public void onFailure(Throwable caught) {
				new ErrorDlg(caught.getMessage());
				System.out.println(" USAO U fail!!!");
				sendButton.setEnabled(true);
			}

			@Override
			public void onSuccess(UserG3 user) {
				System.out.println(" USAO U suc!!!");
				if (user != null) {
					GFaceG3 gface = LoginPageG3.this.gfaceg3;
					gface.showView(new HomePageG3(gface, user));
				} else {
					new ErrorDlg("Pogresno korisnicko ime, ili lozinka.");
				}
			}
		});
	}
	
	

	public UserG3 getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(UserG3 loggedUser) {
		this.loggedUser = loggedUser;
	}
}