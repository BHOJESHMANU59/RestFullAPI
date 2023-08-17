package com.sy.restapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sy.restapi.dto.Customer;
import com.sy.restapi.exception.CustomerNotFoundException;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository customerRepository;
	
	//SimpleJPARepository object -->CRUD operation methods implementation
	
	public Customer insertCustomer(Customer customer)
	{
		Customer cust=customerRepository.save(customer);
		
		return cust;
	}

	public List<Customer> fetchAllCustomers() 
	{
		List<Customer> findAllCust =customerRepository.findAll();
		if(findAllCust!=null)
		{
			return findAllCust;
		}
		throw new CustomerNotFoundException("Customer Details Not found");
	}

	public Optional<Customer> findbyId(int cid)
	{
		Optional<Customer> findById = customerRepository.findById(cid);
		if(findById.isPresent())
		{
			return findById;
		}
		throw new CustomerNotFoundException("Customer Not Found ");
		
		
	}

	public Customer findByPhno(long phno)
	{
		Customer findbyPhno=customerRepository.findByphno(phno);
		if(findbyPhno!=null)
		{
			return findbyPhno;
		}
		throw new CustomerNotFoundException("Customer Not Found ");
	}

	

	public Customer update(Customer cust)
	{
		Optional<Customer> findById = customerRepository.findById(cust.getCid());
		if(findById.isPresent())
		{
			return customerRepository.save(cust);
		}
		throw new CustomerNotFoundException("Customer Not Found ");
	}

	public Customer updatephno(int cid, long phno) 
	{
		Optional<Customer> findById = customerRepository.findById(cid);
		if(findById.isPresent())
		{
			findById.get().setPhno(phno);
			return customerRepository.save(findById.get());
		}
		throw new CustomerNotFoundException("Customer Not Found ");
	}

	public Customer delete(int cid) 
	{
		Optional<Customer> findById = customerRepository.findById(cid);
		if(findById.isPresent())
		{
			customerRepository.deleteById(cid);
			return findById.get(); 
		}
		throw new CustomerNotFoundException("Customer Not Found ");
	}

	
}
