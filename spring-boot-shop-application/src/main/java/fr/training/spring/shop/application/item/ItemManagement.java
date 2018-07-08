package fr.training.spring.shop.application.item;

import java.util.List;

public interface ItemManagement {

	List<ItemDTO> getAllItems();

	ItemDTO addItem(ItemDTO itemDTO);

}
