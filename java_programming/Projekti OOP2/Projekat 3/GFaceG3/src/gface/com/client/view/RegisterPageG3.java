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
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

/**
 * 
 * @author Nemanja Dragin
 *GUI za registraciju
 */

public class RegisterPageG3 extends View {
	private static final UserServiceAsync userService = GWT.create(UserService.class);
	private Button btnRegister;
	private TextBox textName;
	private TextBox textSurname ;
	private TextBox textUsername ;
	private TextBox textEmail ;
	private TextBox textBirth;
	private PasswordTextBox textPass;
	
	public RegisterPageG3(GFaceG3 gfaceg3) {
		super(gfaceg3);
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setVisible(true);
		
		HTML html = new HTML("<h1>Create account</h1>");
		add(html);
		absolutePanel.setStyleName("Register");
		add(absolutePanel);
		absolutePanel.setSize("800px", "565px");
		
		Label lblYourName = new Label("Your name: ");
		absolutePanel.add(lblYourName, 10, 45);
		
		textName = new TextBox();
		absolutePanel.add(textName, 146, 45);
		textName.setSize("273px", "18px");
		
		Label lblSurname = new Label("Your surname: ");
		absolutePanel.add(lblSurname, 10, 114);
		
		textSurname = new TextBox();
		absolutePanel.add(textSurname, 146, 108);
		textSurname.setSize("273px", "18px");
		
		Label lblUsername = new Label("Your username: ");
		absolutePanel.add(lblUsername, 10, 195);
		
		textUsername = new TextBox();
		absolutePanel.add(textUsername, 146, 189);
		textUsername.setSize("273px", "18px");
		
		Label lblYourEmail = new Label("Your email: ");
		absolutePanel.add(lblYourEmail, 10, 355);
		
		textEmail = new TextBox();
		absolutePanel.add(textEmail, 146, 349);
		textEmail.setSize("273px", "18px");
		
		textBirth = new TextBox();
		absolutePanel.add(textBirth, 146, 409);
		textBirth.setSize("273px", "18px");
		
		Label lblDateOfBirth = new Label("Date of birth: ");
		absolutePanel.add(lblDateOfBirth, 10, 415);
		
		textPass = new PasswordTextBox();
		absolutePanel.add(textPass, 146, 272);
		textPass.setSize("273px", "18px");
		
		Label lblYourPassword = new Label("Your password: ");
		absolutePanel.add(lblYourPassword, 12, 278);
		// TODO Auto-generated constructor stub
		
		// OVO SE MORA PROVERITI
		btnRegister = new Button("Register");
		
		btnRegister.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				System.out.println(" Registracija ");
				UserG3 user = new UserG3();
				user.setName(textName.getText());
				user.setSurname(textSurname.getText());
				user.setUsername(textUsername.getText());
				user.setPassword(textPass.getText());
				user.setDateOfBirth(textBirth.getText());
				user.setEmail(textEmail.getText());
				
				userService.register(user, new AsyncCallback<UserG3>() {
					@Override
					public void onFailure(Throwable caught) {
						new ErrorDlg(caught.getMessage());
						System.out.println(" Neuspesno ");
						btnRegister.setEnabled(true);
					}

					@Override
					public void onSuccess(UserG3 user) {
						btnRegister.setEnabled(false);
						System.out.println(" Uspesno ");
						if (user != null) {
							GFaceG3 gface = RegisterPageG3.this.gfaceg3;
							gface.showView(new LoginPageG3(gface));
						} else {
							new ErrorDlg("Pogresno uneti podaci, unesite ponovo");
						}
					}
				});
			}
		});

		absolutePanel.add(btnRegister, 146, 481);
		btnRegister.setSize("135px", "26px");
		
		Button btnCancel = new Button("Cancel");
		absolutePanel.add(btnCancel, 299, 481);
		btnCancel.setSize("126px", "26px");
		btnCancel.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				GFaceG3 gfaceg3 = RegisterPageG3.this.gfaceg3;
				gfaceg3.showView(new LoginPageG3(gfaceg3));
			}
		});
	}
	}
		

