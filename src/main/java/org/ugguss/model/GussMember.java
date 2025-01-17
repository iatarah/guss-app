package org.ugguss.model;// default package
// Generated Jun 17, 2018 6:55:19 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * GussMember generated by hbm2java
 */
@Entity
@Table(name = "guss_member", catalog = "guss_db", uniqueConstraints = @UniqueConstraint(columnNames = "member_ssn"))
public class GussMember implements java.io.Serializable {

	private int id;
	private MembershipCategory membershipCategory;
	private User user;
	private String memberSsn;
	private Date policyStartDate;
	private Date maturityDate;
	private String membershipStatus;
	private Long currentSalary;
	private String address;
	private Date dateCreated;
	private Date lastUpdated;
	private Set<TransactionHistory> transactionHistories = new HashSet<TransactionHistory>(0);
	private Set<GussMemberContribution> gussMemberContributions = new HashSet<GussMemberContribution>(0);

	public GussMember() {
	}

	public GussMember(int id, MembershipCategory membershipCategory, User user, String memberSsn) {
		this.id = id;
		this.membershipCategory = membershipCategory;
		this.user = user;
		this.memberSsn = memberSsn;
	}

	public GussMember(int id, MembershipCategory membershipCategory, User user, String memberSsn, Date policyStartDate,
			Date maturityDate, String membershipStatus, Long currentSalary, String address, Date dateCreated,
			Date lastUpdated, Set<TransactionHistory> transactionHistories,
			Set<GussMemberContribution> gussMemberContributions) {
		this.id = id;
		this.membershipCategory = membershipCategory;
		this.user = user;
		this.memberSsn = memberSsn;
		this.policyStartDate = policyStartDate;
		this.maturityDate = maturityDate;
		this.membershipStatus = membershipStatus;
		this.currentSalary = currentSalary;
		this.address = address;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.transactionHistories = transactionHistories;
		this.gussMemberContributions = gussMemberContributions;
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
	@JoinColumn(name = "membership_category_id", nullable = false)
	public MembershipCategory getMembershipCategory() {
		return this.membershipCategory;
	}

	public void setMembershipCategory(MembershipCategory membershipCategory) {
		this.membershipCategory = membershipCategory;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "member_ssn", unique = true, nullable = false, length = 25)
	public String getMemberSsn() {
		return this.memberSsn;
	}

	public void setMemberSsn(String memberSsn) {
		this.memberSsn = memberSsn;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "policy_start_date", length = 10)
	public Date getPolicyStartDate() {
		return this.policyStartDate;
	}

	public void setPolicyStartDate(Date policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "maturity_date", length = 10)
	public Date getMaturityDate() {
		return this.maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	@Column(name = "membership_status", length = 10)
	public String getMembershipStatus() {
		return this.membershipStatus;
	}

	public void setMembershipStatus(String membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	@Column(name = "current_salary", precision = 10, scale = 0)
	public Long getCurrentSalary() {
		return this.currentSalary;
	}

	public void setCurrentSalary(Long currentSalary) {
		this.currentSalary = currentSalary;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gussMember")
	public Set<TransactionHistory> getTransactionHistories() {
		return this.transactionHistories;
	}

	public void setTransactionHistories(Set<TransactionHistory> transactionHistories) {
		this.transactionHistories = transactionHistories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gussMember")
	public Set<GussMemberContribution> getGussMemberContributions() {
		return this.gussMemberContributions;
	}

	public void setGussMemberContributions(Set<GussMemberContribution> gussMemberContributions) {
		this.gussMemberContributions = gussMemberContributions;
	}

}
