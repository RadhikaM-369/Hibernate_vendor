package com.xworkrz.vendor.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vendor_info")
public class VendorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int vId;
	@Column(name = "vName")
	private String name;
	@Column(name = "emailId")
	private String email;
	@Column(name = "loginname")
	private String loginName;
	@Column(name = "psw")
	private String password;
	@Column(name = "addres")
	private String address;
	@Column(name = "gst_no")
	private String gstNo;
	@Column(name = "createdby")
	private String createdBy;
	@Column(name = "createdAT")
	private LocalDateTime createdAt;
	@Column(name = "updatedBy")
	private String updatedby;
	@Column(name = "updatedAT")
	private LocalDateTime updatedAt;
	
	public VendorEntity(String name, String email, String loginName, String password, String address, String gstNo,
			String createdBy, LocalDateTime createdAt) {
		super();
		this.name = name;
		this.email = email;
		this.loginName = loginName;
		this.password = password;
		this.address = address;
		this.gstNo = gstNo;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
	}

}
