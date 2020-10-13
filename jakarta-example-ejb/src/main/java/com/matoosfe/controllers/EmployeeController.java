package com.matoosfe.controllers;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.matoosfe.entities.Audit;
import com.matoosfe.entities.Employee;

/**
 * 
 * Controller to manages the employee operations
 * 
 * @author martosfre - Marco A. Toscano Freire<br>
 *         12 oct. 2020 - 10:35:07<br>
 *         <br>
 *         <b>Soporte Matoosfe:</b>mtoscano@matoosfe.com
 */
@Stateless
public class EmployeeController {

	@PersistenceContext(unitName = "jakartaee8-PU", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Inject
	private Event<Audit> auditEvent;

	/**
	 * Method to add an employee
	 * 
	 * @param employee
	 * @return
	 */
	public String add(Employee employee) {
		em.persist(employee);
		auditEvent.fire(new Audit("martosfre", new Date()));
		System.out.println("Employee registered successful:" + new Date());
		return "Employee registered successful";
	}

	/**
	 * Method to find all employees
	 * 
	 * @return
	 */
	public List<Employee> findEmployees() {
		TypedQuery<Employee> qEmp = em.createQuery("Select emp from Employee emp", Employee.class);
		return qEmp.getResultList();
	}

	/**
	 * Method to show how to throw an event based on Audit object using CDI Event
	 * Notification
	 * 
	 * @param audit
	 */
	public void saveAudit(@Observes(during = TransactionPhase.AFTER_SUCCESS) Audit audit) {
		System.out.println("Save audit:" + audit.getUsername() + " - " + audit.getDateCreated());
	}

}
