package com.mouritech.departmentmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "department_table2")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "departmentid")
	private int depId;

	@Column(name = "departmentname")
	@Size(min = 3)
	private String depName;

	@Column(name = "departmentemail")
	@Email
	private String depEmail;

	@Column(name = "departmentmobno")
	@Pattern(regexp = "[0-9]", message = "mobile number contains only digits")
	private String depMobileNo;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String depName, String depEmail, String depMobileNo) {
		super();
		this.depName = depName;
		this.depEmail = depEmail;
		this.depMobileNo = depMobileNo;
	}

	public Department(int depId, String depName, String depEmail, String depMobileNo) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.depEmail = depEmail;
		this.depMobileNo = depMobileNo;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepEmail() {
		return depEmail;
	}

	public void setDepEmail(String depEmail) {
		this.depEmail = depEmail;
	}

	public String getDepMobileNo() {
		return depMobileNo;
	}

	public void setDepMobileNo(String depMobileNo) {
		this.depMobileNo = depMobileNo;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + ", depEmail=" + depEmail + ", depMobileNo="
				+ depMobileNo + "]";
	}

}
