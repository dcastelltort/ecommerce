/**
 * 
 */
package com.ecommerce.utilities;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

/**
 * @author shenten
 *
 */
public class FieldEncryptor {

	private static final String PASSWD_ALGO = "SHA-256";
	
	private String encryptedField;
	
	public FieldEncryptor(String plainField) {
		encryptField(plainField);
	}
	
	public void encryptField(String plainField) {
		
		ConfigurablePasswordEncryptor encryptor = new ConfigurablePasswordEncryptor();
    	encryptor.setAlgorithm( PASSWD_ALGO );
    	encryptor.setPlainDigest( false );
    	this.encryptedField = encryptor.encryptPassword(plainField);
	}

	/**
	 * test if a plain field match the encrypted one
	 * @return true if matching
	 */
	public boolean IsEqual(String plainField) {
		
		ConfigurablePasswordEncryptor encryptor = new ConfigurablePasswordEncryptor();
    	encryptor.setAlgorithm( PASSWD_ALGO );
    	return (encryptor.checkPassword(plainField, getEncryptedField()));
	}
	
	/**
	 * @return the encryptedField
	 */
	public String getEncryptedField() {
		return encryptedField;
	}
}
