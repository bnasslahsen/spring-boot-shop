package fr.training.spring.shop.application.item;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.training.spring.shop.domain.item.ItemEntity;

/**
 * Mapper for the entity CustomeEntity and its DTO CustomeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ItemMapper {

	@Mapping(target = "id", source = "itemID")
	@Mapping(target = "orders", ignore = true)
	@Mapping(target = "version", ignore = true)
	ItemEntity toEntity(ItemDTO itemDTO);

	@Mapping(target = "itemID", source = "id")
	ItemDTO toDto(ItemEntity itemEntity);

	List<ItemEntity> toEntity(List<ItemDTO> dtoList);

	List<ItemDTO> toDto(List<ItemEntity> entityList);

}