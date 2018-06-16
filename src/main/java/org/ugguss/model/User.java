package org.ugguss.model;// default package
// Generated Jun 11, 2018 9:52:10 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "guss_db", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements java.io.Serializable {

	private int id;
	private Role role;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	private Date dob;
	private Integer status;
	private Date dateCreated;
	private Date lastUpdated;
	private Set<TransactionHistory> transactionHistories = new HashSet<TransactionHistory>(0);
	private Set<GussMember> gussMembers = new HashSet<GussMember>(0);

	public User() {
	}

	public User(int id, Role role, String email, String password) {
		this.id = id;
		this.role = role;
		this.email = email;
		this.password = password;
	}

	public User(int id, Role role, String email, String password, String firstName, String lastName, String middleName,
			String gender, Date dob, Integer status, Date dateCreated, Date lastUpdated,
			Set<TransactionHistory> transactionHistories, Set<GussMember> gussMembers) {
		this.id = id;
		this.role = role;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.gender = gender;
		this.dob = dob;
		this.status = status;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.transactionHistories = transactionHistories;
		this.gussMembers = gussMembers;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "email", unique = true, nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "middle_name")
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "gender", length = 1)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dob", length = 10)
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created", length = 19)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated", length = 19)
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<TransactionHistory> getTransactionHistories() {
		return this.transactionHistories;
	}

	public void setTransactionHistories(Set<TransactionHistory> transactionHistories) {
		this.transactionHistories = transactionHistories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<GussMember> getGussMembers() {
		return this.gussMembers;
	}

	public void setGussMembers(Set<GussMember> gussMembers) {
		this.gussMembers = gussMembers;
	}

}
