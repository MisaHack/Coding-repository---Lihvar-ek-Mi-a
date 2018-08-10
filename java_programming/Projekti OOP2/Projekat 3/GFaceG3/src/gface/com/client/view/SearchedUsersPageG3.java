package gface.com.client.view;

import gface.com.client.GFaceG3;
import gface.com.client.services.GroupServiceG3;
import gface.com.client.services.GroupServiceG3Async;
import gface.com.client.services.UserGroupServiceG3;
import gface.com.client.services.UserGroupServiceG3Async;
import gface.com.client.services.UserService;
import gface.com.client.services.UserServiceAsync;
import gface.com.server.entity.UserG3;

import java.util.List;

import com.google.gwt.core.shared.GWT;

public class SearchedUsersPageG3 extends View {
	private static final UserServiceAsync userService = GWT.create(UserService.class);
	private static final GroupServiceG3Async groupService = GWT.create(GroupServiceG3.class);
	private static final UserGroupServiceG3Async userGroupService = GWT.create(UserGroupServiceG3.class);
	private UserG3 loggedUser;

	public SearchedUsersPageG3(GFaceG3 gfaceg3, UserG3 user, List<UserG3> users) {
		super(gfaceg3);
	}

}
