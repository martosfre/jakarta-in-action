/**
 * 
 */
package com.matoosfe.security;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;

/**
 * 
 * @author martosfre - Marco A. Toscano Freire 11 oct. 2020 - 00:02:59<br>
 *         <br>
 *         <b>Soporte Matoosfe:</b>mtoscano@matoosfe.com
 */
@CustomFormAuthenticationMechanismDefinition(
		loginToContinue = @LoginToContinue(loginPage = "/login.xhtml",
		useForwardToLogin = false, errorPage = "/login-error.xhtml"))
@FacesConfig
@ApplicationScoped
public class SecurityConfiguration {

}
