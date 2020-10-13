/**
 * 
 */
package com.matoosfe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Class that represent the employee table
 * 
 * @author martosfre - Marco A. Toscano Freire<br>
 *         12 oct. 2020 - 10:35:08<br>
 *         <br>
 *         <b>Soporte Matoosfe:</b>mtoscano@matoosfe.com
 */
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	@NotBlank
	@Column(name = "emp_name")
	private String empName;
	@NotBlank
	@Size(min = 10, max = 13, message = "Identification must be 10 to 13 characters")
	@Column(name = "emp_identification")
	private String empIdentification;

	public Employee() {

	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empIdentification
	 */
	public String getEmpIdentification() {
		return empIdentification;
	}

	/**
	 * @param empIdentification the empIdentification to set
	 */
	public void setEmpIdentification(String empIdentification) {
		this.empIdentification = empIdentification;
	}

}
