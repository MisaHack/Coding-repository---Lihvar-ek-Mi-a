package gface.com.server.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({	
	@NamedQuery(name = "PostG3.findPostsCreatedByUser", query = "SELECT p FROM PostG3 p WHERE p.createdBy = :user"),
	@NamedQuery(name = "PostG3.findPostsCreatedForUser", query = "SELECT p FROM PostG3 p WHERE p.userGroups.following = :user OR p.groups.ownedUsers := user")
})
public class PostG3 implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String namePost;
	private byte[] multimedia;
	private Timestamp createTime;
	@ManyToOne
	private UserG3 createdBy;
	@ManyToMany
	private List<GroupsG3> groups;
	@ManyToMany
	private List<UserGroupG3> userGroups;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNamePost() {
		return namePost;
	}
	public void setNamePost(String namePost) {
		this.namePost = namePost;
	}
	public byte[] getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(byte[] multimedia) {
		this.multimedia = multimedia;
	}
	public List<GroupsG3> getGroups() {
		return groups;
	}
	public void setGroups(List<GroupsG3> groups) {
		this.groups = groups;
	}
	public List<UserGroupG3> getUserGroups() {
		return userGroups;
	}
	public void setUserGroups(List<UserGroupG3> userGroups) {
		this.userGroups = userGroups;
	}
	public UserG3 getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(UserG3 createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
}
