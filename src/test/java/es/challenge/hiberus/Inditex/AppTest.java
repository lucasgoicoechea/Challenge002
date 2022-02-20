package es.challenge.hiberus.Inditex;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.challenge.inditex.domain.Product;
import es.challenge.inditex.service.ListSKUStockService;

/**
 * Unit test for simple App.
 */
class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	ListSKUStockService testService = null;

	@BeforeEach
	void initialize() {
		ListSKUStockService testService = new ListSKUStockService();
		assertNotNull(testService);
	}

	@Test
	void testImportCSVToProducts() {
		List<Product> producs = testService.importCSVToShowFrontProducts();
		assertNotNull(producs);
	}

	@Test
	void testFilterProducts() {
		Product mock1 = new Product(1, 1);
		mock1.setHasSpecialSize(true);
		mock1.setQuantityCommonOrBacksoonStock(1);
		mock1.setQuantitySpecialStock(1);
		Product mock2 = new Product(2, 2);
		mock2.setHasBacksoonSize(true);
		mock2.setQuantityCommonOrBacksoonStock(1);
		List<Product> listMockTest = new ArrayList<Product>();
		listMockTest.add(mock2);
		listMockTest.add(mock1);
		List<Product> listMockCopyTest = new ArrayList<Product>(listMockTest);
		testService.filterProductForShowFront(listMockTest);
		assertArrayEquals(listMockCopyTest.toArray(), listMockTest.toArray());
	}

}
