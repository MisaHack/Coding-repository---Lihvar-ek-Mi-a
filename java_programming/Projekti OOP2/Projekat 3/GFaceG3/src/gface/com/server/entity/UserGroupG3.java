package gface.com.server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({	
	@NamedQuery(name = "UserGroupG3.findFollowing", query = "SELECT ug.following FROM UserGroupG3 ug WHERE ug.belongsToGroup.user = :user")
})
public class UserGroupG3 implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private GroupsG3 belongsToGroup;
	@ManyToMany
	private List<UserG3> following;
	@ManyToMany
	private List<PostG3> posts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public GroupsG3 getBelongsToGroup() {
		return belongsToGroup;
	}
	public void setBelongsToGroup(GroupsG3 belongsToGroup) {
		this.belongsToGroup = belongsToGroup;
	}
	public List<UserG3> getFollowing() {
		return following;
	}
	public void setFollowing(List<UserG3> following) {
		this.following = following;
	}
	public List<PostG3> getPosts() {
		return posts;
	}
	public void setPosts(List<PostG3> posts) {
		this.posts = posts;
	}
	
	
}
