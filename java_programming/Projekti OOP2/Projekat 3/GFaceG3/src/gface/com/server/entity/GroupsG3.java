package gface.com.server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({	
	@NamedQuery(name = "GroupsG3.usersGroups", query = "SELECT g FROM GroupsG3 g WHERE g.user = :user"),
	@NamedQuery(name = "GroupsG3.findGroupByNameAndUser", query = "SELECT g FROM GroupsG3 g WHERE g.user = :user AND g.groupName = :groupname")
})
public class GroupsG3 implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String groupName;
	@ManyToOne
	private UserG3 user;
	@OneToMany(mappedBy = "belongsToGroup")
	private List<UserGroupG3> ownedUsers;
	@ManyToMany
	private List<PostG3> posts;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public UserG3 getUser() {
		return user;
	}
	public void setUser(UserG3 user) {
		this.user = user;
	}
	public List<UserGroupG3> getOwnedUsers() {
		return ownedUsers;
	}
	public void setOwnedUsers(List<UserGroupG3> ownedUsers) {
		this.ownedUsers = ownedUsers;
	}
	public List<PostG3> getPosts() {
		return posts;
	}
	public void setPosts(List<PostG3> posts) {
		this.posts = posts;
	}
	
}
