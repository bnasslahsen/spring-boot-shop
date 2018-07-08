package fr.training.spring.shop.presentation.customer.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.training.spring.shop.application.customer.CustomerDTO;
import fr.training.spring.shop.application.customer.CustomerManagement;

@RestController
@RequestMapping("/api")
public class CustomerResource {

	@Autowired
	private CustomerManagement customerManagement;

	@PostMapping("/customers")
	public void addOrder(@Valid @RequestBody CustomerDTO customerDTO) {
		customerManagement.create(customerDTO);
	}

	@GetMapping("/customers/{customerID}")
	public CustomerDTO getCustomer(@PathVariable String customerID) {
		return customerManagement.findOne(customerID);
	}
}
