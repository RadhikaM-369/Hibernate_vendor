package com.xworkrz.vendor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkrz.vendor.entity.VendorEntity;
import com.xworkrz.vendor.util.EMFUtil;

public class VendorDaoImpl implements VendorDao {

	@Override
	public void save(VendorEntity vEntity) {
		EntityManagerFactory entityManagerFactory = EMFUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction trans = entityManager.getTransaction();
		trans.begin();
		try {
			entityManager.persist(vEntity);
			trans.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	@Override
	public boolean findLogin(String loginName, String password) {
		EntityManager manager = EMFUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query query = manager.createNamedQuery("findLogin");
			query.setParameter("ln", loginName);
			query.setParameter("ps", password);
			VendorEntity vend = (VendorEntity) query.getSingleResult();
			if (vend != null) {
				System.out.println("Login Name : " + loginName);
				System.out.println("Password : " + password);
				return true;
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return false;
	}

	@Override
	public boolean findByEmail(String email) {
		EntityManager manager = EMFUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByEmail");
			query.setParameter("em", email);

			VendorEntity vend = (VendorEntity) query.getSingleResult();
			if (vend != null) {
				System.out.println("email : " + email);
				return true;
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return false;
	}

	@Override
	public void updatePasswordbyEmail(String email, String pwd) {
		EntityManager entityManager = EMFUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			Query query = entityManager.createNamedQuery("updatePasswordbyEmail");
			query.setParameter("em", email);
			query.setParameter("pswdd", pwd);
			int vend = query.executeUpdate();
			System.out.println("execute update status: " + vend);
			System.out.println("new password is : " + pwd);
			transaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

}
