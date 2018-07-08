package fr.training.spring.shop.application.item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.training.spring.shop.domain.item.ItemEntity;
import fr.training.spring.shop.infrastructure.item.ItemRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ItemServiceImplTest {

	@Autowired
	private ItemManagement itemManagement;

	@MockBean
	private ItemRepository itemRepository;

	@Test
	public void testGetAllItems() {
		ItemEntity itemEntity = new ItemEntity("DESC99", 99);
		List<ItemEntity> items = Arrays.asList(itemEntity);
		when(itemRepository.findAll()).thenReturn(items);
		List<ItemDTO> itemsResult = itemManagement.getAllItems();
		assertNotNull(itemsResult);
		assertTrue(itemsResult.size() == 1);
	}

	@Test
	public void testAddItem() {
		ItemEntity itemEntity = new ItemEntity("DESC99", 99);
		when(itemRepository.save(itemEntity)).thenReturn(itemEntity);

		ItemDTO itemDTO = new ItemDTO(itemEntity.getId(), "DESC99", 99);
		ItemDTO itemResultDTO = itemManagement.addItem(itemDTO);
		assertNotNull(itemResultDTO);
		assertEquals("DESC99", itemResultDTO.getDescription());
	}

}
