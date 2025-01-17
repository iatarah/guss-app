package org.ugguss.model;// default package
// Generated Jun 17, 2018 6:55:19 PM by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "guss_db", uniqueConstraints = @UniqueConstraint(columnNames = "role_name"))
public class Role implements java.io.Serializable {

	private int id;
	private String roleName;
	private String description;
	private Set<User> users = new HashSet<User>(0);

	public Role() {
	}

	public Role(int id) {
		this.id = id;
	}

	public Role(int id, String roleName, String description, Set<User> users) {
		this.id = id;
		this.roleName = roleName;
		this.description = description;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "role_name", unique = true, length = 100)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
