/**
 * 
 */
package es.challenge.hiberus.Inditex.service;

import static org.junit.Assert.assertNull;

import org.junit.Test;

import es.challenge.inditex.service.ImportCSVDataService;

/**
 * @author lgoicoechea
 *
 */
public class ImportCSVDataServiceTest {

	ImportCSVDataService mockTest = new ImportCSVDataService();

	/**
	 * Test method for {@link es.challenge.hiberus.Inditex.service.ImportCSVDataService#importCSVToObject(java.lang.String, java.lang.String, class, java.util.String[])}.
	 */
	@Test
	public final void testCheckSKUStockProduct() {
		assertNull( mockTest.importCSVToObject("","",Object.class, new String[]{""}));
	}
	

}
