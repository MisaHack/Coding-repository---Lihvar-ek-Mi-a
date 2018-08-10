package gface.com.server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({	
	@NamedQuery(name = "UserG3.login", query = "SELECT u FROM UserG3 u WHERE u.username = :username AND u.password = :password"),
	@NamedQuery(name = "UserG3.findUser", query = "SELECT u FROM UserG3 u WHERE u.username = :user OR u.name = :user OR u.surname = :user")
})
public class UserG3 implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String dateOfBirth;
	
	@OneToMany(mappedBy="user")
	private List<GroupsG3> userGroups;
	
	@ManyToMany
	private List<UserGroupG3> followers;
	
	@OneToMany(mappedBy = "createdBy")
	private List<PostG3> posts;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public List<GroupsG3> getUserGroups() {
		return userGroups;
	}
	public void setUserGroups(List<GroupsG3> userGroups) {
		this.userGroups = userGroups;
	}
	public List<PostG3> getPosts() {
		return posts;
	}
	public void setPosts(List<PostG3> posts) {
		this.posts = posts;
	}
	public List<UserGroupG3> getFollowers() {
		return followers;
	}
	public void setFollowers(List<UserGroupG3> followers) {
		this.followers = followers;
	}
	
}
