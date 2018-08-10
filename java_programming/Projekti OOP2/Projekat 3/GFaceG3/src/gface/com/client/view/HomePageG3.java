package gface.com.client.view;

import gface.com.client.ErrorDlg;
import gface.com.client.GFaceG3;
import gface.com.client.services.GroupServiceG3;
import gface.com.client.services.GroupServiceG3Async;
import gface.com.client.services.PostServiceG3;
import gface.com.client.services.PostServiceG3Async;
import gface.com.client.services.UserGroupServiceG3;
import gface.com.client.services.UserGroupServiceG3Async;
import gface.com.client.services.UserService;
import gface.com.client.services.UserServiceAsync;
import gface.com.server.entity.UserG3;

import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class HomePageG3 extends View {
	private static final UserServiceAsync userService = GWT.create(UserService.class);
	private static final GroupServiceG3Async groupService = GWT.create(GroupServiceG3.class);
	private static final UserGroupServiceG3Async userGroupService = GWT.create(UserGroupServiceG3.class);
	private static final PostServiceG3Async postService = GWT.create(PostServiceG3.class);
	private UserG3 loggedUser;
	private TextBox searchUsers;
	
	public HomePageG3(GFaceG3 gfaceg3, UserG3 user) {
		super(gfaceg3);
		setLoggedUser(user);
		AbsolutePanel absolutePanel = new AbsolutePanel();
		absolutePanel.setSize("800px", "81px");
		Button btnLogout = new Button("Logout");
		btnLogout.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				setLoggedUser(null);
				GFaceG3 gfaceg3 = HomePageG3.this.gfaceg3;
				gfaceg3.showView(new LoginPageG3(gfaceg3));
			}
		});
		absolutePanel.add(btnLogout, 740, 10);
		add(absolutePanel);
		
		searchUsers = new TextBox();
		absolutePanel.add(searchUsers, 179, 12);
		searchUsers.setSize("118px", "18px");
		
		Label userName = new Label(getLoggedUser().getName() + " " + getLoggedUser().getSurname());
		absolutePanel.add(userName, 570, 10);
		userName.setSize("148px", "26px");
		HTML html_1 = new HTML("<hr />");
		absolutePanel.add(html_1, 10, 45);
		html_1.setSize("810px", "26px");
		
		Image image = new Image("images/facebookheader.jpg");
		absolutePanel.add(image, 10, 3);
		image.setSize("148px", "36px");
		searchUsers.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			}
		});
		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		add(absolutePanel_1);
		absolutePanel_1.setSize("800px", "498px");
		
		Button btnGroups = new Button("Groups");
		absolutePanel_1.add(btnGroups, 24, 278);
		btnGroups.setSize("174px", "26px");
		HTML html_2 = new HTML("<vr />");
		absolutePanel_1.add(html_2);
		Button btnFriends = new Button("Friends");
		absolutePanel_1.add(btnFriends, 24, 329);
		btnFriends.setSize("174px", "26px");
		
		TextArea postTextArea = new TextArea();
		absolutePanel_1.add(postTextArea, 282, 31);
		postTextArea.setSize("486px", "47px");
		
		AbsolutePanel absolutePanel_2 = new AbsolutePanel();
		absolutePanel_1.add(absolutePanel_2, 282, 146);
		
		Button btnPost = new Button("Post");
		absolutePanel_1.add(btnPost, 678, 97);
		btnPost.setSize("96px", "26px");
		
		Image userImage = new Image("images/nije_fora_samo_biti_na_facebooku.jpg");
		absolutePanel_1.add(userImage, 25, 31);
		userImage.setSize("232px", "214px");
		btnFriends.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			}
		});
		btnGroups.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				GFaceG3 gface = HomePageG3.this.gfaceg3;
				gface.showView(new UserGroupsPageG3(gface, getLoggedUser()));
			}
		});
		add(new HTML("<br/>"));
		
	}

	private void trySearch() {
		System.out.println(" USAO U LOGOVANJEE!!!");
		userService.findUsers(searchUsers.getText(), new AsyncCallback<List<UserG3>>() {
			@Override
			public void onFailure(Throwable caught) {
				new ErrorDlg(caught.getMessage());
				System.out.println(" USAO U fail!!!");
			}

			@Override
			public void onSuccess(List<UserG3> users) {
				System.out.println(" Nasao nesto!!!");
				if (users != null) {

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
