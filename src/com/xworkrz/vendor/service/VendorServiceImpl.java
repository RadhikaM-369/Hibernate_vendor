package com.xworkrz.vendor.service;

import javax.persistence.PersistenceException;

import com.xworkrz.vendor.dao.VendorDao;
import com.xworkrz.vendor.entity.VendorEntity;

public class VendorServiceImpl implements VendorService {
	private VendorDao dao;

	public VendorServiceImpl(VendorDao vendorDao) {
		this.dao = vendorDao;
	}

	@Override
	public boolean validateAndSave(VendorEntity vendorEntity) {
		boolean valid = false;
		try {
			if (vendorEntity.getName() == null || vendorEntity.getName().isEmpty() == true
					|| vendorEntity.getName().length() < 5 || vendorEntity.getName().length() > 30) {
				valid = false;
				System.out.println("Invalid name");
				return false;
			} else {
				valid = true;
				System.out.println("Valid Name");
			}
			if (vendorEntity.getEmail() == null || vendorEntity.getEmail().isEmpty() == true
					|| (!(vendorEntity.getEmail().contains("@") || vendorEntity.getEmail().endsWith(".com")
							|| vendorEntity.getEmail().endsWith(".in") || vendorEntity.getEmail().endsWith(".org")))) {
				valid = false;
				System.out.println("Invalid email Id");
				return false;
			} else {
				valid = true;
				System.out.println("Valid email Id");
			}
			if (vendorEntity.getLoginName() == null || vendorEntity.getLoginName().isEmpty() == true
					|| vendorEntity.getLoginName().length() < 8 && vendorEntity.getLoginName().length() > 20) {
				valid = false;
				System.out.println("Invalid Login name");
				return false;
			} else {
				valid = true;
				System.out.println("Valid loginName");
			}
			if (vendorEntity.getPassword().length() < 8 || vendorEntity.getPassword().length() > 16
					|| vendorEntity.getPassword() == null || vendorEntity.getPassword().isEmpty()) {
				valid = false;
				System.out.println("invalid password");
				return false;
			} else {
				valid = true;
				System.out.println("Valid Password");
			}
			if (vendorEntity.getAddress() == null || vendorEntity.getAddress().isBlank() == true
					|| vendorEntity.getAddress().length() < 30 || vendorEntity.getAddress().length() > 100) {
				valid = false;
				System.out.println("Invalid Address");
				return false;
			} else {
				valid = true;
				System.out.println("valid Address");
			}
			if (!(vendorEntity.getGstNo().length() == 13) || vendorEntity.getGstNo() == null
					|| vendorEntity.getGstNo().isEmpty() == true) {
				valid = false;
				System.out.println("Invalid GST No.");
				return false;
			} else {
				valid = true;
				System.out.println("Valid GST No.");
			}
			if (vendorEntity.getCreatedBy().length() < 5 || vendorEntity.getCreatedBy().length() > 30
					|| vendorEntity.getCreatedBy() == null || vendorEntity.getCreatedBy().isEmpty() == true) {
				valid = false;
				System.out.println("Invalid created by");
				return false;
			} else {
				valid = true;
				System.out.println("Valid created by");
			}
			if (vendorEntity.getCreatedAt() == null) {
				valid = false;
				System.out.println("Invalid createdAt");
				return false;
			} else {
				valid = true;
				System.out.println("valid created At");
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Inside validateAndSave method");
		}
		if (valid) {
			dao.save(vendorEntity);
		}
		return false;
	}

	@Override
	public boolean validateAndLogin(String loginName, String password) {
		boolean valid = false;
		try {
			if (loginName.isEmpty() == true || loginName == null || loginName.length() < 8

					|| loginName.length() > 16 && password.isEmpty() == true || password == null
					|| password.length() < 8 || password.length() > 16) {
				valid = false;
				System.out.println("Invalid login name and password");
				return false;
			} else {
				valid = true;
				System.out.println("valid loginname and password");
				valid = dao.findLogin(loginName, password);
			}
			return valid;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Inside validate and login method");
		}
		return valid;
	}

	@Override
	public void validateAndChangePassword(String email, String password) {
		boolean valid = false;
		try{
			if (email == null || email.isEmpty() == true || (!((email.contains("@")
				|| (email.endsWith(".com") || email.endsWith(".org") || email.endsWith(".in")))))) {
			valid = false;
			System.out.println("Invalid email");
			if (password == null || password.isEmpty() == true || password.length() < 8 || password.length() > 16) {
				valid = false;
				System.out.println("Invalid password" + valid);
			}
		} else {
			valid = true;
			System.out.println("Valid emailId & password");
			boolean emaiL = dao.findByEmail(email);
			if (emaiL) {
				System.out.println("Email is matching with entity");
				dao.updatePasswordbyEmail(email, password);
			} else {
				emaiL = false;
				System.out.println("Email not matching");
			}
		}
	}catch(PersistenceException e) {
		e.printStackTrace();
	}finally {
		System.out.println("Inside validateAndChangePassword method");
	}
	}

}
