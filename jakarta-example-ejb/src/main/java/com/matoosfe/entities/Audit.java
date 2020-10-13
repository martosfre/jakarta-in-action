/**
 * 
 */
package com.matoosfe.entities;

import java.util.Date;

/**
 * 
 * Class to manage the Audit throught CDI Event Notification
 * 
 * @author martosfre - Marco A. Toscano Freire<br>
 *         12 oct. 2020 - 10:40:26<br>
 *         <br>
 *         <b>Soporte Matoosfe:</b>mtoscano@matoosfe.com
 */
public class Audit {

	private String username;
	private Date dateCreated;

	/**
	 * @param username
	 * @param dateCreated
	 */
	public Audit(String username, Date dateCreated) {
		this.username = username;
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
