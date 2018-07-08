package fr.training.spring.shop.application.customer;

public interface CustomerManagement {

	CustomerDTO create(CustomerDTO customer);

	CustomerDTO findOne(String customerID);

}
