package com.sy.restapi.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sy.restapi.dto.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer>
{

	public Customer findByphno(long phno);
	

}
