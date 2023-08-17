package com.sy.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.sy.restapi.dto.Customer;
import com.sy.restapi.response.ResponseStructure;
import com.sy.restapi.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping(path = "/persist")
	public ResponseEntity<?> insertCustomer(@RequestBody Customer cust)
	{
		ResponseStructure<?> responseStructure=customerService.insertCustomer(cust);
		
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
		
	}
	@GetMapping(path="/FetchAll")
	public ResponseEntity<?> getCustomers()
	{
		ResponseStructure<?> responseStructure=customerService.getCustomers();
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@GetMapping(path="fetch/{cid}")
	public ResponseEntity<?> getbyId(@PathVariable int cid)
	{
		ResponseStructure<?> responseStructure=customerService.getById(cid);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@GetMapping(path="fetch")
	public ResponseEntity<?> getById(@RequestParam int cid)
	{
		ResponseStructure<?> responseStructure=customerService.getById(cid);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	@GetMapping(path="findbyphno/{phno}")
	public ResponseEntity<?> getByphno(@PathVariable long phno)
	{
		ResponseStructure<?> responseStructure=customerService.findbyphno(phno);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@PutMapping(path="update")
	public ResponseEntity<?> update(@RequestBody Customer cust)
	{
		ResponseStructure<?> responseStructure=customerService.update(cust);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	@PatchMapping(path="updatphno")
	public ResponseEntity<?> updatePhno(@RequestParam int cid,@RequestParam long phno)
	{
		ResponseStructure<?> responseStructure = customerService.updatePhno(cid,phno);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@DeleteMapping(path="deleteById/{cid}")
	public ResponseEntity<?> delete(@PathVariable int cid)
	{
		ResponseStructure<?> responseStructure = customerService.delete(cid);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}

}
