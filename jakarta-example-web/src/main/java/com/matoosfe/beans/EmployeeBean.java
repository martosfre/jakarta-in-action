/**
 * 
 */
package com.matoosfe.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.matoosfe.controllers.EmployeeController;
import com.matoosfe.entities.Employee;

/**
 * 
 * ManagedBean to controls the operation on the Employee Form
 * 
 * @author martosfre - Marco A. Toscano Freire<br>
 *         12 oct. 2020 - 10:37:00<br>
 *         <br>
 *         <b>Soporte Matoosfe:</b>mtoscano@matoosfe.com
 */
@Named
@ViewScoped
@FacesConfig
public class EmployeeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private EmployeeController employeeController;

	private Employee employee;
	private List<Employee> employees;

	public EmployeeBean() {
		this.employee = new Employee();
		this.employees = new ArrayList<>();
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * Method to save an employee
	 */
	public void saveEmployee() {
		String message = employeeController.add(employee);
		FacesMessage messageJSF = new FacesMessage(message);
		messageJSF.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, messageJSF);
		resetForm();
	}

	/**
	 * Method to get all employees
	 */
	public void findEmployees() {
		this.employees = employeeController.findEmployees();
	}

	/**
	 * Method to reset the form
	 */
	private void resetForm() {
		this.employee = new Employee();
	}

}
