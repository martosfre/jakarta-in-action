package com.matoosfe.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.matoosfe.controllers.EmployeeController;
import com.matoosfe.entities.Employee;

/**
 * Class that represents the Employee Web Service
 * 
 * @author martosfre - Marco A. Toscano Freire<br>
 *         12 oct. 2020 - 10:45:33<br>
 *         <br>
 *         <b>Soporte Matoosfe:</b>mtoscano@matoosfe.com
 */
@Path("employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeService {

	@Inject
	private EmployeeController employeeController;

	/**
	 * Method to save an employee
	 * 
	 * @param employee
	 * @return
	 */
	@PUT
	public Response saveEmployee(Employee employee) {
		return Response.ok(employeeController.add(employee)).build();
	}

	/**
	 * Method to find all employees
	 * 
	 * @return
	 */
	@GET
	public Response findEmployees() {
		return Response.ok(employeeController.findEmployees()).build();
	}

}
