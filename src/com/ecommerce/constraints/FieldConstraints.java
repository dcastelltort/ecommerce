/**
 * 
 */
package com.ecommerce.constraints;

import java.util.HashMap;
import java.util.Map;


/**
 * @author shenten
 *
 */
public class FieldConstraints {

	public void validateEmailField( String email ) throws FieldConstraintsException {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new FieldConstraintsException( "Invalid email address entered." );
            }
        } else {
            throw new FieldConstraintsException( "no email address given." );
        }
    }

    public void validatePasswordField( String password, String confirmationPassword ) throws FieldConstraintsException {
        if ( password != null && confirmationPassword != null ) {
            if ( !password.equals( confirmationPassword ) ) {
                throw new FieldConstraintsException( "Mismatched password, please try again." );
            } else if ( password.length() < 3 ) {
                throw new FieldConstraintsException( "Password should be at least 3 characters long." );
            }
        } else {
            throw new FieldConstraintsException( "Please enter your password and confirmation." );
        }
    }

    public void validateNameField( String name ) throws FieldConstraintsException {
        if ( name != null && name.length() < 3 ) {
            throw new FieldConstraintsException( "User name must be at least 3 characters." );
        }
    }
}
