/**
 * 
 */
package com.ecommerce.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ecommerce.entities.User;

/**
 * @author shenten
 *
 */
@Stateless
public class UserDAO {

	@PersistenceContext( unitName = "ecommerce_PU" ) // refers to entry in META-INF/persistence.xml
	private EntityManager entityManager;
	
	public void save(User user) throws DAOException {
		try {
			entityManager.persist(user);
		}
		catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
	public void update(User user) throws DAOException {
		try {
			entityManager.merge(user);
		}
		catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
	public void delete(User user) throws DAOException {
		try {
			entityManager.remove(user);
		}
		catch (Exception e) {
			throw new DAOException(e);
		}
	}
 }
