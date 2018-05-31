package org.ugguss.model;// default package
// Generated May 30, 2018 7:20:56 PM by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "guss_db", uniqueConstraints = { @UniqueConstraint(columnNames = "role_id"),
		@UniqueConstraint(columnNames = "role_name") })
public class Role implements java.io.Serializable {

	private int id;
	private String roleId;
	private String roleName;
	private String description;

	public Role() {
	}

	public Role(int id, String roleId) {
		this.id = id;
		this.roleId = roleId;
	}

	public Role(int id, String roleId, String roleName, String description) {
		this.id = id;
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "role_id", unique = true, nullable = false, length = 45)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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


}
