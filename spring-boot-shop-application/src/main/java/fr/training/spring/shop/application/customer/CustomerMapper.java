package fr.training.spring.shop.application.customer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.training.spring.shop.domain.customer.CustomerEntity;

/**
 * Mapper for the entity CustomeEntity and its DTO CustomeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper {

	@Mapping(target = "id", source = "customerID")
	@Mapping(target = "version", ignore = true)
	CustomerEntity toEntity(CustomerDTO customerDTO);

	@Mapping(target = "customerID", source = "id")
	CustomerDTO toDto(CustomerEntity entity);

}