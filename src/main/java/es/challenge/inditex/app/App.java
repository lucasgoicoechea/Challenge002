package es.challenge.inditex.app;

import java.util.logging.Level;
import java.util.logging.Logger;

import es.challenge.inditex.domain.Product;
import es.challenge.inditex.service.ListSKUStockService;

/**
 * @author lgoicoechea
 *
 */
public class App {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(App.class.getName());
		logger.info("Starting run SKu-stock-Size");
		ListSKUStockService testService = new ListSKUStockService();
		for (Product prod : testService.filterProductForShowFront(testService.importCSVToShowFrontProducts())) {
			String message = prod.toString();
			logger.log(Level.INFO, "Producto: {0}", message);
		}
	}
}
