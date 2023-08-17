package com.sy.restapi.dto;


import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Component
@Data
@Entity

public class Customer {
	@Id
	private int cid;
	private String name;
	private String address;
	private long phno;
	private int pincode;
	private String city;

}
