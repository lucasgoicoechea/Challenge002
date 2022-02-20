package es.challenge.inditex.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

import es.challenge.inditex.domain.Product;
import es.challenge.inditex.domain.Size;
import es.challenge.inditex.domain.Stock;

/**
 * @author lgoicoechea
 * 
 */
public class ListSKUStockService {

	ImportCSVDataService importCSVDataService = new ImportCSVDataService();

	public List<Product> importCSVToShowFrontProducts() {
		String pathFilesFolder = getPathFilesFolderCSV();
		List<Product> products = new ArrayList<>();
		try {
			products = importCSVDataService.importCSVToObject(pathFilesFolder, "products.csv", Product.class,
					new String[] { "id", "sequence" });
			List<Stock> stocks = importCSVDataService.importCSVToObject(pathFilesFolder, "stocks.csv", Stock.class,
					new String[] { "sizeId", "quantity" });
			List<Size> sizes = importCSVDataService.importCSVToObject(pathFilesFolder, "sizes.csv", Size.class,
					new String[] { "id", "productId", "backSoon", "special" });
			products = this.updateStockForFrontCommerce(products, sizes, stocks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	private List<Product> updateStockForFrontCommerce(List<Product> products, List<Size> sizes, List<Stock> stocks) {
		// iterate products to map
		Map<Integer, Product> productMap = products.stream().collect(Collectors.toMap(Product::getId, Function.identity()));

		// iterate sizes to map
		Product tmpProd;
		Map<Integer, Size> sizeMap = new HashMap<>();
		for (Size p : sizes) {
			sizeMap.put(p.getId(), p);
			tmpProd = productMap.get(p.getProductId());
			// is special size? SET
			tmpProd.setHasSpecialSize(tmpProd.isHasSpecialSize() || p.isSpecial());
			// is backsoon size? SET
			tmpProd.setHasBacksoonSize(tmpProd.isHasBacksoonSize() || p.isBackSoon());
		}

		// iterate stocks for update
		Size tmpSize = null;
		for (Stock stock : stocks) {
			// set size
			tmpSize = sizeMap.get(stock.getSizeId());
			tmpProd = productMap.get(tmpSize.getProductId());
			if (tmpSize.isSpecial())
				tmpProd.setQuantitySpecialStock(stock.getQuantity());
			else
				tmpProd.setQuantityCommonOrBacksoonStock(
						tmpProd.getQuantityCommonOrBacksoonStock() + stock.getQuantity());
		}
		return (List<Product>) productMap.values();
	}

	private String getPathFilesFolderCSV() throws NullPointerException {
		String pathFileFolder = "";
		Properties prop = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		try  {
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			// get the property value and print it out
			pathFileFolder = prop.getProperty("folder_files_csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pathFileFolder;
	}

	public List<Product> filterProductForShowFront(List<Product> products) {
		List<Product> filterProducts = new ArrayList<>();
		for (Product product : products) {
			if ((product.isHasBacksoonSize() || product.getQuantityCommonOrBacksoonStock() > 0)
					&& (product.isHasSpecialSize() && product.getQuantitySpecialStock() > 0))
				filterProducts.add(product);
		}
		return filterProducts;
	}

}
