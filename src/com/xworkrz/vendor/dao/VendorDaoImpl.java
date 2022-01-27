package com.xworkrz.vendor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.xworkrz.vendor.entity.VendorEntity;
import com.xworkrz.vendor.util.EMFUtil;


public class VendorDaoImpl implements VendorDao{

	@Override
	public void save(VendorEntity vEntity) {
		EntityManagerFactory entityManagerFactory = EMFUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction trans = entityManager.getTransaction();
		trans.begin();
		try{
			entityManager.persist(vEntity);
			trans.commit();
		}
		catch (PersistenceException e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			if (entityManager != null) {
				entityManager.close();
			}
	}
	
		
	}

}
