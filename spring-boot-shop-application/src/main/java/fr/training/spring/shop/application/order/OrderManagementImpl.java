package fr.training.spring.shop.application.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.training.spring.shop.application.item.ItemDTO;
import fr.training.spring.shop.domain.customer.CustomerEntity;
import fr.training.spring.shop.domain.item.ItemEntity;
import fr.training.spring.shop.domain.order.OrderEntity;
import fr.training.spring.shop.infrastructure.customer.CustomerRepository;
import fr.training.spring.shop.infrastructure.item.ItemRepository;
import fr.training.spring.shop.infrastructure.order.OrderRepository;

@Service
@Transactional
public class OrderManagementImpl implements OrderManagement {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<OrderDTO> getOrdersForCustomer(String customerID) {
		List<OrderEntity> orderEntity = orderRepository.getOrdersForCustomer(customerID);
		return orderMapper.toDto(orderEntity);
	}

	@Override
	public OrderDTO addOrder(OrderDTO orderDTO) {
		OrderEntity orderEntity = orderMapper.toEntity(orderDTO);
		CustomerEntity customerEntity = customerRepository.findOne(orderDTO.getCustomerID());
		List<ItemEntity> items = itemRepository
				.findAll(orderDTO.getItems().stream().map(ItemDTO::getItemID).collect(Collectors.toList()));
		orderEntity.setCustomer(customerEntity);
		orderEntity.setItems(items);
		orderEntity = orderRepository.save(orderEntity);
		return orderMapper.toDto(orderEntity);
	}

	@Override
	public OrderDTO findOne(String orderID) {
		OrderEntity orderEntity = orderRepository.findOne(orderID);
		return orderMapper.toDto(orderEntity);
	}

}
