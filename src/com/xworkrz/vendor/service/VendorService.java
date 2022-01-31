package com.xworkrz.vendor.service;

import com.xworkrz.vendor.entity.VendorEntity;

public interface VendorService {
	public boolean validateAndSave(VendorEntity vendorEntity);
	boolean validateAndLogin(String loginName, String password);
	void validateAndChangePassword(String email,String newpassword);
	
}
