/**
 * 
 */
package es.challenge.hiberus.Inditex.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import es.challenge.inditex.domain.Product;
import es.challenge.inditex.service.ListSKUStockService;

/**
 * @author lgoicoechea
 *
 */
public class ListSKUStockServiceTest {

	ListSKUStockService mockTest = new ListSKUStockService();

	/**
	 * Test method for {@link es.challenge.hiberus.Inditex.service.ListSKUStockService#importCSVToShowFrontProducts()}.
	 */
	@Test
	public final void testImportCSVToShowFrontProducts() {
		assertNotNull( mockTest.importCSVToShowFrontProducts() );
	}
	
	/**
	 * Test method for {@link es.challenge.hiberus.Inditex.service.ListSKUStockService#filterProductForShowFront(List<Product> products)}.
	 */
	@Test
	public final void testFilterProductForShowFront() {
		assertNotNull( mockTest.filterProductForShowFront(new ArrayList<Product>()));
	}

}
