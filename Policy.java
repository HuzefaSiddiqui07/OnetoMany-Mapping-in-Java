package com.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "policy")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "policyId")
	private String policyId;
	
	@Column(name = "policyType")
	private String policyType;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	// Create Parameterized Constructor 
	// (id) is not write in Parameterized Constructor  because (id) is Auto Incremental

	public Policy(String policyId, String policyType, String status, User user) {
		super();
		this.policyId = policyId;
		this.policyType = policyType;
		this.status = status;
		this.user = user;
	}
	
	
}
