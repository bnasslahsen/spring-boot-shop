package fr.training.spring.shop.application.item;

import java.io.Serializable;

public class ItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String itemID;

	private String description;

	private int price;

	public ItemDTO() {
	}

	public ItemDTO(String itemID, String description, int price) {
		this.itemID = itemID;
		this.description = description;
		this.price = price;
	}

	public ItemDTO(String description, int price) {
		this.description = description;
		this.price = price;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
