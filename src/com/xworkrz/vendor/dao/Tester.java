package com.xworkrz.vendor.dao;

import com.xworkrz.vendor.service.VendorService;
import com.xworkrz.vendor.service.VendorServiceImpl;

public class Tester {

	public static void main(String[] args) {

		VendorDao vendordao = new VendorDaoImpl();
		VendorService vendorService = new VendorServiceImpl(vendordao);

		/*
		 * VendorEntity vEntityy= new
		 * VendorEntity("Costa Coffee","costaCoffee@rediffmail.com", "coffeeCosta",
		 * "costa1234", "The CostaCoffee,near MGRoad Mysuru-570008", "29AAACW0021Z8",
		 * "RadhikaM", LocalDateTime.now());
		 * 
		 * VendorEntity vEntityy1= new
		 * VendorEntity("Starbucks","thestarbucks@gmail.com", "starbucksCoffee",
		 * "starbucks@66", "The STARBUCKSCoffee, 804Avenue,Jaynagar,Bengaluru",
		 * "29AAACS0001Z8", "RadhikaM", LocalDateTime.now());
		 * 
		 * VendorEntity vEntityy2= new VendorEntity("Mc Café","mcCafe.cafe@gmail.com",
		 * "FunMC.Cafe", "mcCafe12345",
		 * "CrunchNCafe, near RamdevBusstop belgaum-590001", "29AAACS0001Z8",
		 * "RadhikaM", LocalDateTime.now());
		 * 
		 * VendorEntity vEntityy3= new
		 * VendorEntity("FolgersCoffeeBeans","folgersCoffeeBeans@gmail.com",
		 * "folgersCoffee", "folgersCafe",
		 * "The Folgers CoffeeBeans, Meera Road Pune,Maharashtra", "30AXXCS0401W7",
		 * "RadhikaM", LocalDateTime.now());
		 * 
		 * VendorEntity vEntityy4= new
		 * VendorEntity("Dunkin Donuts","dunkinDonuts@yahoo.com", "donutsDunkin",
		 * "DunkinsDelights", "The Dunkin Donuts Delights, Kolhapur, Maharashtra",
		 * "30AXXCS0401Z5", "RadhikaM", LocalDateTime.now());
		 * 
		 * vendorService.validateAndSave(vEntityy);
		 * vendorService.validateAndSave(vEntityy1);
		 * vendorService.validateAndSave(vEntityy2);
		 * vendorService.validateAndSave(vEntityy3);
		 * vendorService.validateAndSave(vEntityy4);
		 */

		// boolean vendor=vendorService.validateAndLogin("starbucksCoffee",
		// "starbucks@66");
		// System.out.println(vendor);

		vendorService.validateAndChangePassword("thestarbucks@gmail.com", "starbucks@67");

	}

}
