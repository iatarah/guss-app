package org.ugguss.model;// default package
// Generated Jun 17, 2018 6:55:19 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import javax.persistence.*;

/**
 * TransactionHistory generated by hbm2java
 */
@Entity
@Table(name = "transaction_history", catalog = "guss_db")
public class TransactionHistory implements java.io.Serializable {

	private int id;
	private GussMember gussMember;
	private User user;
	private Date date;
	private Double amount;
	private String description;
	private Date lastUpdated;
	private Date dateCreated;

	public TransactionHistory() {
	}

	public TransactionHistory(int id, GussMember gussMember, User user) {
		this.id = id;
		this.gussMember = gussMember;
		this.user = user;
	}

	public TransactionHistory(int id, GussMember gussMember, User user, Date date, Double amount, String description,
			Date lastUpdated, Date dateCreated) {
		this.id = id;
		this.gussMember = gussMember;
		this.user = user;
		this.date = date;
		this.amount = amount;
		this.description = description;
		this.lastUpdated = lastUpdated;
		this.dateCreated = dateCreated;
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
	@JoinColumn(name = "guss_member_id", nullable = false)
	public GussMember getGussMember() {
		return this.gussMember;
	}

	public void setGussMember(GussMember gussMember) {
		this.gussMember = gussMember;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "approved_by", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "amount", precision = 22, scale = 0)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated", length = 19)
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created", length = 19)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
