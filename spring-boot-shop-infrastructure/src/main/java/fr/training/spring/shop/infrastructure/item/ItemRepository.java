package fr.training.spring.shop.infrastructure.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.training.spring.shop.domain.item.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {

	List<ItemEntity> findByIdIn(List<String> id);

}
