package com.ecommerce.utilitiestest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ecommerce.utilities.FieldEncryptor;

public class FieldEncryptorTest {

	@Test
	public void testFieldEncryptor() {
		FieldEncryptor fe = new FieldEncryptor("testpassword");
		
		assertTrue(fe.getEncryptedField() != null);
		assertTrue(fe.IsEqual("testpassword"));
		
	}
}
