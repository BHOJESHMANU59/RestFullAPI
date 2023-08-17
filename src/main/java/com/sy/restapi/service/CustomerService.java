package com.sy.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sy.restapi.dto.Customer;
import com.sy.restapi.repository.CustomerDao;
import com.sy.restapi.response.ResponseStructure;
@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public ResponseStructure<?> insertCustomer(Customer customer) {
		Customer cust=customerDao.insertCustomer(customer);
		ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
		responseStructure.setData(cust);
		responseStructure.setHttpStatus(HttpStatus.CREATED);// 201
		return responseStructure;
	}

	public ResponseStructure<?> getCustomers() {
		
		List<Customer> custlist=customerDao.fetchAllCustomers();
		ResponseStructure<List<Customer>> responseStructure=new ResponseStructure<>();
		responseStructure.setData(custlist);
		responseStructure.setHttpStatus(HttpStatus.OK);
		
		
		return responseStructure;
	}

	public ResponseStructure<?> getById(int cid)
	{
		Optional<Customer> findbyId = customerDao.findbyId(cid);
		ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
		Customer cust=findbyId.get();
		responseStructure.setData(cust);
		responseStructure.setHttpStatus(HttpStatus.FOUND);
		return responseStructure;
	}

	public ResponseStructure<?> findbyphno(long phno) 
	{
	    Customer findbyPhno=customerDao.findByPhno(phno);
		ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
		responseStructure.setData(findbyPhno);
		responseStructure.setHttpStatus(HttpStatus.FOUND);
		return responseStructure;
	}

	public ResponseStructure<?> update(Customer cust) 
	{
		Customer update = customerDao.update(cust);
		ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
		responseStructure.setData(update);
		responseStructure.setHttpStatus(HttpStatus.OK);
		return responseStructure;
		
	}

	public ResponseStructure<?> updatePhno(int cid, long phno)
	{
		Customer updatePhno=customerDao.updatephno(cid,phno);
		ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
		responseStructure.setData(updatePhno);
		responseStructure.setHttpStatus(HttpStatus.OK);
		return responseStructure;
		
	}

	public ResponseStructure<?> delete(int cid) {
		Customer delete = customerDao.delete(cid);
		ResponseStructure<Customer> responseStructure=new ResponseStructure<>();
		responseStructure.setData(delete);
		responseStructure.setHttpStatus(HttpStatus.OK);
		return responseStructure;
		
		
	}

}
