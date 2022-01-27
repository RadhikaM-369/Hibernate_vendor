package com.xworkrz.vendor.dao;

import java.time.LocalDateTime;

import com.xworkrz.vendor.entity.VendorEntity;
import com.xworkrz.vendor.service.VendorService;
import com.xworkrz.vendor.service.VendorServiceImpl;

public class Tester {

	public static void main(String[] args) {
		
		VendorDao vendordao=new VendorDaoImpl();
		VendorService vendorService= new VendorServiceImpl(vendordao);
		
		VendorEntity vEntityy= new VendorEntity("Latte Love", "lattelovebgm@gmail.com", "cafeLatteLove", "latte1234", "crunch N cafe, near ramdev busstop belgaum-590001", "29AAACS0001Z8", "RadhikaM", LocalDateTime.now());
		
		
		vendorService.validateAndSave(vEntityy);						
	}

}
