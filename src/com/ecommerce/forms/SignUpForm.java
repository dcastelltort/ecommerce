/**
 * 
 */
package com.ecommerce.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.ecommerce.constraints.FieldConstraints;
import com.ecommerce.constraints.FieldConstraintsException;
import com.ecommerce.dao.UserDAO;
import com.ecommerce.entities.User;
import com.ecommerce.utilities.FieldEncryptor;


/**
 * @author shenten
 *
 */
public final class SignUpForm {
	
	    private static final String EMAIL_FIELD  		= "email";
	    private static final String PASSWD_FIELD   		= "passwd";
	    private static final String PASSWD_CONF_FIELD   = "passwd_confirm";
	    private static final String NAME_FIELD    		= "name";
	    
	    private String              result;
	    private Map<String, String> errors      = new HashMap<String, String>();    

	    private UserDAO userDAO;
	    
	    public SignUpForm(UserDAO userDAO) {
			this.userDAO = userDAO;
		}

		public String getResultat() {
	        return result;
	    }

	    public Map<String, String> getErrors() {
	        return errors;
	    }

	    public User signUpUser( HttpServletRequest request ) {
	        
	    	String email = getParameterValueFromRequest( request, EMAIL_FIELD );
	        String password = getParameterValueFromRequest( request, PASSWD_FIELD );
	        String confirmationPassword = getParameterValueFromRequest( request, PASSWD_CONF_FIELD );
	        String name = getParameterValueFromRequest( request, NAME_FIELD );

	        User newUser = new User();
	        
	        processName(name, newUser);
	        processEmail(email, newUser);
	        processPassword(password, confirmationPassword, newUser);
	        
	        if ( getErrors().isEmpty() ) {
	            result = "Signup succeed";
	        } else {
	            result = "Signup failed";
	        }

	        return newUser;
	    }

	    

	    /*
	     * Process name validation
	     */
	    private void processName( String name, User newUser) throws FieldConstraintsException {
	    	try {
	    		FieldConstraints constraints = new FieldConstraints();
	    		constraints.validateNameField(name);
	    	}
	    	catch (FieldConstraintsException e) {
	    		addError(NAME_FIELD, e.getMessage());
	    	}
	    	newUser.setName(name);
	    }
	    
	    /*
	     * Process email validation
	     */
	    private void processEmail( String email, User newUser) throws FieldConstraintsException {
	    	try {
	    		FieldConstraints constraints = new FieldConstraints();
	    		constraints.validateEmailField(email);
	    	}
	    	catch (FieldConstraintsException e) {
	    		addError(EMAIL_FIELD, e.getMessage());
	    	}
	    	newUser.setEmail(email);
	    }
	    
	    /*
	     * Process email validation
	     */
	    private void processPassword( String password, String confirmationPassword, User newUser) throws FieldConstraintsException {
	    	try {
	    		FieldConstraints constraints = new FieldConstraints();
	    		constraints.validatePasswordField(password, confirmationPassword);
	    	}
	    	catch (FieldConstraintsException e) {
	    		addError(PASSWD_FIELD, e.getMessage());
	    	}
	    	
	    	// store encrypted password
	    	FieldEncryptor fe = new FieldEncryptor(password);	    	
	    	String encryptedPassword = fe.getEncryptedField();
	    	
	    	newUser.setPassword(encryptedPassword);
	    }
	    
	    
	    /*
	     * add a message to errors list.
	     */
	    private void addError( String fieldName, String message ) {
	        errors.put( fieldName, message );
	    }

	    /*
	     * Utility method to extract value from a given parameter from the request
	     * 
	     */
	    private static String getParameterValueFromRequest( HttpServletRequest request, String parameterName ) {
	        String value = request.getParameter( parameterName );
	        if ( value == null || value.trim().length() == 0 ) {
	            return null;
	        } else {
	            return value.trim();
	        }
	    }
	    
}