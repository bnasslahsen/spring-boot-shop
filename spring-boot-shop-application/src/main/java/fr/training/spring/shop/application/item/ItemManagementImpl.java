package fr.training.spring.shop.application.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.training.spring.shop.domain.item.ItemEntity;
import fr.training.spring.shop.infrastructure.item.ItemRepository;

@Service
@Transactional
public class ItemManagementImpl implements ItemManagement {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemMapper itemMapper;

	@Override
	@Cacheable("itemCache")
	public List<ItemDTO> getAllItems() {
		List<ItemEntity> itemEntities = itemRepository.findAll();
		return itemMapper.toDto(itemEntities);
	}

	@Override
	@CacheEvict(value = "itemCache", allEntries = true)
	public ItemDTO addItem(ItemDTO itemDTO) {
		ItemEntity itemEntity = itemMapper.toEntity(itemDTO);
		itemEntity = itemRepository.save(itemEntity);
		return itemMapper.toDto(itemEntity);
	}

}
