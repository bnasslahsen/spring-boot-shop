package fr.training.spring.shop.infrastructure.item;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.training.spring.shop.domain.item.ItemEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ItemRepositoryImplTest {

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void testGetAllItems() {
		List<ItemEntity> itemEntities = itemRepository.findAll();
		assertNotNull(itemEntities);
		assertTrue(itemEntities.size() == 5);
	}

	@Test
	public void testAddItem() {
		ItemEntity itemEntity = new ItemEntity("DESC99", 99);
		itemRepository.save(itemEntity);
		assertNotNull(itemEntity.getId());
	}

	@Test
	public void testGetAllItemsWithList() {
		List<String> items = Arrays.asList("1", "2", "3");
		List<ItemEntity> itemEntities = itemRepository.findByIdIn(items);
		assertNotNull(itemEntities);
		assertTrue(itemEntities.size() == 3);
	}

}
