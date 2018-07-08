package fr.training.spring.shop.application.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.training.spring.shop.application.item.ItemDTO;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String orderID;

	private String customerID;

	private List<ItemDTO> items;

	public OrderDTO() {
	}

	public OrderDTO(String orderID, String customerID) {
		this.orderID = orderID;
		this.customerID = customerID;
		items = new ArrayList<>();
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDTO [orderID=");
		builder.append(orderID);
		builder.append(", customerID=");
		builder.append(customerID);
		builder.append(", items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}

	public void addItem(ItemDTO itemDTO) {
		items.add(itemDTO);
	}

}
