package gface.com.client.view;

import java.util.List;

import gface.com.client.ErrorDlg;
import gface.com.client.GFaceG3;
import gface.com.client.services.GroupServiceG3;
import gface.com.client.services.GroupServiceG3Async;
import gface.com.client.services.UserGroupServiceG3;
import gface.com.client.services.UserGroupServiceG3Async;
import gface.com.client.services.UserService;
import gface.com.client.services.UserServiceAsync;
import gface.com.server.entity.GroupsG3;
import gface.com.server.entity.UserG3;
import gface.com.server.entity.UserGroupG3;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.text.client.IntegerRenderer;

public class UserGroupsPageG3 extends View {
	private static final UserServiceAsync userService = GWT.create(UserService.class);
	private static final GroupServiceG3Async groupService = GWT.create(GroupServiceG3.class);
	private static final UserGroupServiceG3Async userGroupService = GWT.create(UserGroupServiceG3.class);
	
	private UserG3 loggedUser;
	private TextBox textGroupName;
	private Button btnCreateGroup ;
	private Button btnFindUserGroups; 
	private HTML htmlNewHtml;
	private UserGroupG3 ug;

	public UserGroupsPageG3(GFaceG3 gfaceg3, UserG3 user) {
		super(gfaceg3);
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		add(absolutePanel);
		absolutePanel.setHeight("595px");
		
		/*
		 * Metod za kreiranje grupa, PROVERITI
		 */
		btnCreateGroup = new Button("New button");
		btnCreateGroup.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				System.out.println(" Kreiranje grupe ");
				GroupsG3 group = new GroupsG3();
				group.setGroupName(textGroupName.getText());
				groupService.createGroup(group, new AsyncCallback<GroupsG3>() {
					@Override
					public void onFailure(Throwable caught) {
						new ErrorDlg(caught.getMessage());
						System.out.println(" Neuspesno ");
						btnCreateGroup.setEnabled(true);
					}
					@Override
					public void onSuccess(GroupsG3 group) {
						btnCreateGroup.setEnabled(false);
						System.out.println(" Uspesno ");
						if (group != null) {
							GFaceG3 gface = UserGroupsPageG3.this.gfaceg3;
							gface.showView(new UserGroupsPageG3(gface, getLoggedUser()));
						} else {
							new ErrorDlg("Pogresno uneti podaci, unesite ponovo");
						}
					}

				});
				
			}
		});
		btnCreateGroup.setText("Create a group");
		absolutePanel.add(btnCreateGroup, 10, 135);
		
		Button btnLogout = new Button("Logout");
		btnLogout.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			}
		});
		absolutePanel.add(btnLogout, 610, 10);
		
		Button btnHomePage = new Button("Home page");
		btnHomePage.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				GFaceG3 gface = UserGroupsPageG3.this.gfaceg3;
				gface.showView(new HomePageG3(gface, getLoggedUser()));
			}
		});
		absolutePanel.add(btnHomePage, 508, 10);
		
		Button btnCancel = new Button("Cancel");
		btnCancel.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				GFaceG3 gface = UserGroupsPageG3.this.gfaceg3;
				gface.showView(new UserPageG3(gface, getLoggedUser()));
			}
		});
		absolutePanel.add(btnCancel, 609, 540);
		
		
		/*
		 * Trazi i postavlja u text box ime grupa od korisnika. PROVERITI
		 */
		btnFindUserGroups = new Button("Find followers");
		btnFindUserGroups.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				userGroupService.findFollowing(getLoggedUser(), new AsyncCallback<List<UserGroupG3>>()  {

					@Override
					public void onFailure(Throwable caught) {
						new ErrorDlg(caught.getMessage());
						System.out.println(" Neuspesno ");
						btnCreateGroup.setEnabled(true);
					}

					@Override
					public void onSuccess(List<UserGroupG3> result) {
						btnFindUserGroups.setEnabled(false);
						System.out.println(" Uspesno ");
						if (result != null) {
							showFollowers(result); 
						} else {
							new ErrorDlg("Pogresno uneti podaci, unesite ponovo");
						}
					}

					private void showFollowers(List<UserGroupG3> result) {
						for (int i = 0; i < result.size(); i++) {
							result.get(i);
							//add(new HTML("<h3>" + + "</h3><br /><i>" +  + "</i>"));
						}
						
					}
					
				});
			}
		});
		
		absolutePanel.add(btnFindUserGroups, 10, 180);
		
		Label lblGroupName = new Label("Group name  :");
		absolutePanel.add(lblGroupName, 10, 88);
		lblGroupName.setSize("97px", "28px");
		
		textGroupName = new TextBox();
		absolutePanel.add(textGroupName, 121, 88);
		
		Label lblNewLabel = new Label("Groups");
		lblNewLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblNewLabel.setStyleName("h1");
		absolutePanel.add(lblNewLabel, 10, 10);
		lblNewLabel.setSize("249px", "44px");
		
		
		absolutePanel.add(htmlNewHtml, 23, 242);
		
		HTML htmlNewHtml_1 = new HTML("New HTML", true);
		absolutePanel.add(htmlNewHtml_1, 10, 237);
		htmlNewHtml_1.setSize("278px", "299px");
		htmlNewHtml.setSize("269px", "249px");
		
		setLoggedUser(user);
	}
	

	public UserG3 getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(UserG3 loggedUser) {
		this.loggedUser = loggedUser;
	}
}
