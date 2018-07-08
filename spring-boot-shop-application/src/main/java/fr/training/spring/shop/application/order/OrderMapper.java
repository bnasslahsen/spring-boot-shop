package fr.training.spring.shop.application.order;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.training.spring.shop.application.item.ItemDTO;
import fr.training.spring.shop.domain.item.ItemEntity;
import fr.training.spring.shop.domain.order.OrderEntity;

/**
 * Mapper for the entity CustomeEntity and its DTO CustomeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface OrderMapper {

	@Mapping(target = "customer.id", source = "customerID")
	@Mapping(target = "id", source = "orderID")
	@Mapping(target = "version", ignore = true)
	OrderEntity toEntity(OrderDTO orderDTO);

	@Mapping(target = "id", source = "itemID")
	@Mapping(target = "orders", ignore = true)
	@Mapping(target = "version", ignore = true)
	ItemEntity toEntity(ItemDTO itemDTO);

	@Mapping(target = "customerID", source = "customer.id")
	@Mapping(target = "orderID", source = "id")
	OrderDTO toDto(OrderEntity orderEntity);

	@Mapping(target = "itemID", source = "id")
	ItemDTO toDto(ItemEntity itemEntity);

	List<OrderEntity> toEntity(List<OrderDTO> dtoList);

	List<OrderDTO> toDto(List<OrderEntity> entityList);

}