package fr.training.spring.shop.infrastructure.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.training.spring.shop.domain.customer.CustomerEntity;
import fr.training.spring.shop.domain.item.ItemEntity;
import fr.training.spring.shop.domain.order.OrderEntity;
import fr.training.spring.shop.infrastructure.customer.CustomerRepository;
import fr.training.spring.shop.infrastructure.item.ItemRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class OrderRepositoryImplTest {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testGetOrdersForCustomer() {
		List<OrderEntity> orders = orderRepository.getOrdersForCustomer("123e4567-e89b-42d3-a456-556642440000");
		assertNotNull(orders);
		assertEquals(2, orders.size());
	}

	@Test
	public void testAddOrder() {
		OrderEntity orderEntity = this.createOrder("123e4567-e89b-42d3-a456-556642440000", "1", 99);
		orderRepository.save(orderEntity);
		assertNotNull(orderEntity.getId());
	}

	@Test
	public void testAddOrders() {
		OrderEntity orderEntity1 = this.createOrder("123e4567-e89b-42d3-a456-556642440000", "1", 99);
		OrderEntity orderEntity2 = this.createOrder("123e4567-e89b-42d3-a456-556642440000", "2", 99);
		List<OrderEntity> orders = Stream.of(orderEntity1, orderEntity2).collect(Collectors.toList());
		orderRepository.save(orders);
		assertNotNull(orderEntity1.getId());
		assertNotNull(orderEntity2.getId());
	}

	private OrderEntity createOrder(String customerId, String itemId, int price) {
		CustomerEntity customer = customerRepository.findOne(customerId);
		ItemEntity itemEntity = itemRepository.findOne(itemId);
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomer(customer);
		orderEntity.setItems(Arrays.asList(itemEntity));
		return orderEntity;
	}

}
