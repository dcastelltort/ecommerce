/**
 * 
 */
package com.ecommerce.forms;

/**
 * @author shenten
 *
 */
public class FormValidationException extends RuntimeException {

	public FormValidationException(String message) {
		super(message);
	}
	
	public FormValidationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public FormValidationException(Throwable cause) {
		super(cause);
	}
}
