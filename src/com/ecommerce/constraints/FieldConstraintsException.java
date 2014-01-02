/**
 * 
 */
package com.ecommerce.constraints;

/**
 * @author shenten
 *
 */
public class FieldConstraintsException extends RuntimeException {

	public FieldConstraintsException(String message) {
		super(message);
	}
	
	public FieldConstraintsException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public FieldConstraintsException(Throwable cause) {
		super(cause);
	}
}
