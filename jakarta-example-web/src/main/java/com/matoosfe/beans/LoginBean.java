/**
 * 
 */
package com.matoosfe.beans;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 
 * ManagedBean to manage the authentication
 * @author martosfre - Marco A. Toscano Freire<br>
 *         12 oct. 2020 - 21:36:30<br>
 *         <br>
 *         <b>Soporte Matoosfe:</b>mtoscano@matoosfe.com
 */
@Named
@RequestScoped
public class LoginBean {

	@NotBlank
	@Size(max = 10, message = "Username must be 10 characters")
	private String userName;
	@NotBlank
	@Size(max = 10, message = "Password must be 10 characters")
	private String password;

	@Inject
	private SecurityContext securityContext;

	@Inject
	private FacesContext facesContext;

	@Inject
	private ExternalContext externalContext;

	public LoginBean() {
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Method to validate the user.
	 */
	public void validateUser() {
		try {
			AuthenticationStatus status = securityContext.authenticate(
					(HttpServletRequest) externalContext.getRequest(),
					(HttpServletResponse) externalContext.getResponse(), AuthenticationParameters.withParams()
							.credential(new UsernamePasswordCredential(userName, password)));

			switch (status) {
			case SEND_CONTINUE:
				facesContext.responseComplete();
				break;
			case SEND_FAILURE:
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed", null));
				break;
			case SUCCESS:
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login Succeed", null));
				facesContext.getExternalContext()
						.redirect(facesContext.getExternalContext().getRequestContextPath() + "/pages/employee.xhtml");
				break;
			default:
				break;
			}
		} catch (IOException e) {
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Failed", null));
		}
	}

}
