package gface.com.client.view;

import gface.com.client.GFaceG3;
import gface.com.client.services.GroupServiceG3;
import gface.com.client.services.GroupServiceG3Async;
import gface.com.client.services.UserGroupServiceG3;
import gface.com.client.services.UserGroupServiceG3Async;
import gface.com.client.services.UserService;
import gface.com.client.services.UserServiceAsync;
import gface.com.server.entity.UserG3;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;

public class SerchedUsersSinglePageG3 extends View {
	private static final UserServiceAsync userService = GWT
			.create(UserService.class);
	private static final GroupServiceG3Async groupService = GWT
			.create(GroupServiceG3.class);
	private static final UserGroupServiceG3Async userGroupService = GWT
			.create(UserGroupServiceG3.class);
	private UserG3 loggedUser;
	private Button addToFriends;

	public SerchedUsersSinglePageG3(GFaceG3 gfaceg3, UserG3 user) {
		super(gfaceg3);
		setSpacing(4);
		setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		add(absolutePanel);
		absolutePanel.setSize("440px", "164px");
		VerticalPanel vp = new VerticalPanel();
		absolutePanel.add(vp, 10, 10);
		vp.setSize("422px", "47px");
		vp.setSpacing(8);
		vp.setVerticalAlignment(VerticalPanel.ALIGN_TOP);
		vp.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		
				addToFriends = new Button("Add to friends", new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						System.out.println("Otvorio register");
						GFaceG3 gface = SerchedUsersSinglePageG3.this.gfaceg3;
						gface.showView(new HomePageG3(gface,loggedUser));
					}
				});
				absolutePanel.add(addToFriends, 339, 78);
				HTML html_1 = new HTML("<hr />");
				absolutePanel.add(html_1, 0, 128);
				html_1.setSize("432px", "14px");

		// opis i cena (h3 je Heading 3, <br /> je novi red)
		add(new HTML("<h3>" + user.getName() + " " + user.getSurname() + "</h3><br /><b><i>" + user.getUsername() + "</i><b/>"));
	}

}
