package com.xworkrz.vendor.dao;

import com.xworkrz.vendor.entity.VendorEntity;

public interface VendorDao {
public void save(VendorEntity vEntity);
boolean findLogin(String loginName,String password);
boolean findByEmail(String email);
void updatePasswordbyEmail(String email,String pwd);

}
