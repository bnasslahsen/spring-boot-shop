package fr.training.spring.shop.application.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.training.spring.shop.domain.customer.CustomerEntity;
import fr.training.spring.shop.infrastructure.customer.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerManagementImplTest {

	@Autowired
	private CustomerManagement customerManagement;

	@MockBean
	private CustomerRepository customerRepository;

	@Test
	public void testCreate() {
		CustomerEntity customerEntity = new CustomerEntity("NAME1", "PASS1");
		when(customerRepository.save(customerEntity)).thenReturn(customerEntity);
		CustomerDTO customerDTO = new CustomerDTO(customerEntity.getId(), "NAME1", "PASS1");
		CustomerDTO customerResultDTO = customerManagement.create(customerDTO);
		assertNotNull(customerDTO);
		assertEquals("NAME1", customerResultDTO.getName());
	}

	@Test
	public void testFindOne() {
		CustomerEntity customerEntity = new CustomerEntity("NAME1", "PASS1");
		customerEntity.setId("123e4567-e89b-42d3-a456-556642440000");
		when(customerRepository.findOne("123e4567-e89b-42d3-a456-556642440000")).thenReturn(customerEntity);
		CustomerDTO customerResultDTO = customerManagement.findOne("123e4567-e89b-42d3-a456-556642440000");
		assertEquals("NAME1", customerResultDTO.getName());
	}

}
