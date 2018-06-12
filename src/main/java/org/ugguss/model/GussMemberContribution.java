package org.ugguss.model;// default package
// Generated Jun 11, 2018 9:52:10 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * GussMemberContribution generated by hbm2java
 */
@Entity
@Table(name = "guss_member_contribution", catalog = "guss_db", uniqueConstraints = @UniqueConstraint(columnNames = "doc_id"))
public class GussMemberContribution implements java.io.Serializable {

	private int id;
	private GussMember gussMember;
	private String docId;
	private Date paymentDate;
	private String fiscalMonth;
	private String fiscalYear;
	private String comments;
	private String contributionCategory;

	public GussMemberContribution() {
	}

	public GussMemberContribution(int id, GussMember gussMember, String docId, String contributionCategory) {
		this.id = id;
		this.gussMember = gussMember;
		this.docId = docId;
		this.contributionCategory = contributionCategory;
	}

	public GussMemberContribution(int id, GussMember gussMember, String docId, Date paymentDate, String fiscalMonth,
			String fiscalYear, String comments, String contributionCategory) {
		this.id = id;
		this.gussMember = gussMember;
		this.docId = docId;
		this.paymentDate = paymentDate;
		this.fiscalMonth = fiscalMonth;
		this.fiscalYear = fiscalYear;
		this.comments = comments;
		this.contributionCategory = contributionCategory;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guss_member_ssn", nullable = false)
	public GussMember getGussMember() {
		return this.gussMember;
	}

	public void setGussMember(GussMember gussMember) {
		this.gussMember = gussMember;
	}

	@Column(name = "doc_id", unique = true, nullable = false, length = 45)
	public String getDocId() {
		return this.docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "payment_date", length = 10)
	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Column(name = "fiscal_month", length = 25)
	public String getFiscalMonth() {
		return this.fiscalMonth;
	}

	public void setFiscalMonth(String fiscalMonth) {
		this.fiscalMonth = fiscalMonth;
	}

	@Column(name = "fiscal_year", length = 45)
	public String getFiscalYear() {
		return this.fiscalYear;
	}

	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	@Column(name = "comments")
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "contribution_category", nullable = false, length = 45)
	public String getContributionCategory() {
		return this.contributionCategory;
	}

	public void setContributionCategory(String contributionCategory) {
		this.contributionCategory = contributionCategory;
	}

}
