/**
 * 
 */
package com.matoosfe.security;

import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

/**
 * 
 * @author martosfre - Marco A. Toscano Freire
 * 11 oct. 2020 - 00:38:07<br><br>
 * <b>Soporte Matoosfe:</b>mtoscano@matoosfe.com
 */

@ApplicationScoped
public class MemoryIdentityStore  implements IdentityStore{

	@Override
	public CredentialValidationResult validate(Credential credential) {
		UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
		
		if(usernamePasswordCredential.getCaller().equals("mtoscano") 
				&& usernamePasswordCredential.getPasswordAsString().equals("1234")) {
			return new CredentialValidationResult("mtoscano", new HashSet<>(Arrays.asList("ADMIN")));
		}else if(usernamePasswordCredential.getCaller().equals("pmacheno") 
				&& usernamePasswordCredential.getPasswordAsString().equals("4567")) {
			return new CredentialValidationResult("pmancheno", new HashSet<>(Arrays.asList("USER")));
		}else {
			return CredentialValidationResult.NOT_VALIDATED_RESULT;
		}
	}

}
