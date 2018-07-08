package fr.training.spring.shop.presentation.order.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.training.spring.shop.application.order.OrderDTO;
import fr.training.spring.shop.application.order.OrderManagement;

@RestController
@RequestMapping("/api")
public class OrderResource {

	@Autowired
	private OrderManagement orderManagement;

	@PostMapping("/orders")
	public void addOrder(@Valid @RequestBody OrderDTO orderDTO) {
		orderManagement.addOrder(orderDTO);
	}

	@GetMapping("/orders/{customerID}")
	public List<OrderDTO> getOrders(@PathVariable String customerID) {
		return orderManagement.getOrdersForCustomer(customerID);
	}

}
