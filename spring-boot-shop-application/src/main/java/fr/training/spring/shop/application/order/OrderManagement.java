package fr.training.spring.shop.application.order;

import java.util.List;

public interface OrderManagement {

	List<OrderDTO> getOrdersForCustomer(String customerID);

	OrderDTO addOrder(OrderDTO order);

	OrderDTO findOne(String orderID);

}
