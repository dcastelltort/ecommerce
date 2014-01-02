/**
 * 
 */
package com.ecommerce.constraintstest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ecommerce.constraints.FieldConstraints;
import com.ecommerce.constraints.FieldConstraintsException;

/**
 * @author shenten
 *
 */
public class FieldConstraintsTest {

	private FieldConstraints c;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() {
		c = new FieldConstraints();
	}
	
	/**
	 * Test method for {@link com.ecommerce.constraints.FieldConstraints#validateEmailField(java.lang.String)}.
	 * @throws FieldConstraintsException 
	 */
	@Test
	public void testValidateEmailField() throws FieldConstraintsException {
		
		exception.expect(FieldConstraintsException.class);
		c.validateEmailField("");
		
		exception.expect(FieldConstraintsException.class);
		c.validateEmailField("name.net.fr");
		
		exception.expect(FieldConstraintsException.class);
		c.validateEmailField("name.net.fr");
		
		exception.expect(FieldConstraintsException.class);
		c.validateEmailField("namenetfr");
		
		c.validateEmailField("someone@net.fr"); //should pass
		
	}

	/**
	 * Test method for {@link com.ecommerce.constraints.FieldConstraints#validatePasswordField(java.lang.String, java.lang.String)}.
	 * @throws FieldConstraintsException 
	 */
	@Test
	public void testValidatePasswordField() throws FieldConstraintsException {
		
		exception.expect(FieldConstraintsException.class);
		c.validatePasswordField("mypass", "Mypass");
		
		exception.expect(FieldConstraintsException.class);
		c.validatePasswordField("1", "1");
		
		c.validatePasswordField("mypass", "mypass");
	}

	/**
	 * Test method for {@link com.ecommerce.constraints.FieldConstraints#validateNameField(java.lang.String)}.
	 * @throws FieldConstraintsException 
	 */
	@Test
	public void testValidateNameField() throws FieldConstraintsException {
		
		exception.expect(FieldConstraintsException.class);
		c.validateNameField("123");
		
		exception.expect(FieldConstraintsException.class);
		c.validateNameField("");
	
		c.validateNameField("Will I AM"); //should pass
	}

}
