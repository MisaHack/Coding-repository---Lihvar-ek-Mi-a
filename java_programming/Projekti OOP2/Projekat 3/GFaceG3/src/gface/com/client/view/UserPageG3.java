package gface.com.client.view;

import java.util.List;

import gface.com.client.ErrorDlg;
import gface.com.client.GFaceG3;
import gface.com.client.services.PostServiceG3;
import gface.com.client.services.PostServiceG3Async;
import gface.com.client.services.UserService;
import gface.com.client.services.UserServiceAsync;
import gface.com.server.entity.PostG3;
import gface.com.server.entity.UserG3;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;

public class UserPageG3 extends View {
	private static final UserServiceAsync userService = GWT.create(UserService.class);
	private static final PostServiceG3Async postService = GWT.create(PostServiceG3.class);
	
	private UserG3 loggedUser;
	private TextBox textUpdateBox;
	private TextBox textUpdateSee;
	private Button btnPostAnUpdate;
	private Button btnSeeUpdates;

	public UserPageG3(GFaceG3 gfaceg3, UserG3 user) {
		super(gfaceg3);
		setLoggedUser(user);
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		add(absolutePanel);
		absolutePanel.setVisible(true);
		absolutePanel.setHeight("435px");
		
		
		Button btnGroups = new Button("Groups");
		btnGroups.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				GFaceG3 gface = UserPageG3.this.gfaceg3;
				gface.showView(new UserGroupsPageG3(gface, getLoggedUser()));
			}
		});
		absolutePanel.add(btnGroups, 20, 10);
		
		Button btnLogout = new Button("Logout");
		btnLogout.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			}
		});
		absolutePanel.add(btnLogout, 582, 10);
		
		Button btnHomePage = new Button("Home Page");
		btnHomePage.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				GFaceG3 gfaceg3 = UserPageG3.this.gfaceg3;
				gfaceg3.showView(new HomePageG3(gfaceg3, getLoggedUser()));
			}
		});
		absolutePanel.add(btnHomePage, 477, 10);
		
		// Treba pomoc
		btnPostAnUpdate = new Button("Post");
		btnPostAnUpdate.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				System.out.println(" Postovanje ");
				PostG3 post = new PostG3();
				//post.setMultimedia(textUpdateBox.getText());
				
				postService.createPost(post, new AsyncCallback<PostG3>() {
					@Override
					public void onFailure(Throwable caught) {
						new ErrorDlg(caught.getMessage());
						System.out.println(" Neuspesno ");
						btnPostAnUpdate.setEnabled(true);
					}
					
					@Override
					public void onSuccess(PostG3 post) {
						btnPostAnUpdate.setEnabled(false);
						System.out.println(" Uspesno ");
						if (post != null) {
							GFaceG3 gface = UserPageG3.this.gfaceg3;
							gface.showView(new UserPageG3(gface, getLoggedUser()));
						} else {
							new ErrorDlg(" Neuspesno");
						}
					}
				
				});
			}
		});
		absolutePanel.add(btnPostAnUpdate, 20, 82);
		
		textUpdateBox = new TextBox();
		absolutePanel.add(textUpdateBox, 20, 127);
		textUpdateBox.setSize("603px", "54px");
		
		
		
		//PROVERITI DA LI RADI 
		
		btnSeeUpdates = new Button("See updates");
		btnSeeUpdates.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				System.out.println(" Vidi update ");
				postService.findPostsCreatedByUser(getLoggedUser(), new AsyncCallback<List<PostG3>>() {

					@Override
					public void onFailure(Throwable caught) {
						new ErrorDlg(caught.getMessage());
						System.out.println(" Neuspesno ");
						btnSeeUpdates.setEnabled(true);
					}

					@Override
					public void onSuccess(List<PostG3> post) {
						btnSeeUpdates.setEnabled(false);
						System.out.println(" Uspesno ");
						if (post != null) {
							do {
								String str = post.toString();
								textUpdateSee.setText(str);
							} while (post.size() > 0);
							//GFaceG3 gface = UserPageG3.this.gfaceg3;
							//gface.showView(new UserPageG3(gface, user));
						} else {
							new ErrorDlg(" Neuspesno");
						}
						
					}
					
				});
			}
		});
		absolutePanel.add(btnSeeUpdates, 20, 221);
		
		textUpdateSee = new TextBox();
		absolutePanel.add(textUpdateSee, 20, 268);
		textUpdateSee.setSize("603px", "107px");
		
		
		
	}
	
	public UserG3 getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(UserG3 loggedUser) {
		this.loggedUser = loggedUser;
	}
}
