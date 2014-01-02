/**
 * 
 */
package com.ecommerce.entitiestest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ecommerce.entities.User;

/**
 * @author shenten
 *
 */
public class UserTest {

	private User user;
	
	@Before
	public void setUp() {
		user = new User();
	}

	/**
	 * Test method for {@link com.ecommerce.entities.User#getName()}.
	 */
	@Test
	public void testGetName() {
		user.setName("Will I AM");
		assertEquals("Will I AM", user.getName());
	}

	/**
	 * Test method for {@link com.ecommerce.entities.User#getPassword()}.
	 */
	@Test
	public void testGetPassword() {
		user.setPassword("dumbpassword");
		assertEquals("dumbpassword", user.getPassword());
	}

	/**
	 * Test method for {@link com.ecommerce.entities.User#getEmail()}.
	 */
	@Test
	public void testGetEmail() {
		user.setEmail("arf@net.fr");
		assertEquals("arf@net.fr", user.getEmail());
	}

}
