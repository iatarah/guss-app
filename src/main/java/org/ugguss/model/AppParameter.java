package org.ugguss.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the app_parameters database table.
 * 
 */
@Entity
@Table(name = "app_parameters")
@NamedQuery(name = "AppParameter.findAll", query = "SELECT a FROM AppParameter a")
public class AppParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "param_name")
	private String paramName;

	@Column(name = "param_value")
	private String paramValue;

	public AppParameter() {
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

}