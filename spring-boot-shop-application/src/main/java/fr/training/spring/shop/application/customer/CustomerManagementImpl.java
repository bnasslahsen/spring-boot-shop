package fr.training.spring.shop.application.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.training.spring.shop.domain.customer.CustomerEntity;
import fr.training.spring.shop.infrastructure.customer.CustomerRepository;

@Service
@Transactional
public class CustomerManagementImpl implements CustomerManagement {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerMapper customeEntityMapper;

	@Override
	public CustomerDTO create(CustomerDTO customeDTO) {
		CustomerEntity customerEntity = customeEntityMapper.toEntity(customeDTO);
		customerEntity = customerRepository.save(customerEntity);
		return customeEntityMapper.toDto(customerEntity);
	}

	@Override
	public CustomerDTO findOne(String customerID) {
		CustomerEntity customerEntity = customerRepository.findOne(customerID);
		return customeEntityMapper.toDto(customerEntity);
	}

}
