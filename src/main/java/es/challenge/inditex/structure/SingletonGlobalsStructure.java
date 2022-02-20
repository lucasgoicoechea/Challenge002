package es.challenge.inditex.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.challenge.inditex.domain.Product;
import es.challenge.inditex.domain.Stock;

public class SingletonGlobalsStructure {

	private Map<Integer, Product> sizes = new HashMap<>();
	private List<Stock> stock = new ArrayList<>();
	private static SingletonGlobalsStructure singletonGlobalsStructure = null;

	public static SingletonGlobalsStructure getSingletonGlobalsStructure(Map<Integer, Product> sizes,
			List<Stock> stock) {

		if (singletonGlobalsStructure == null) {
			singletonGlobalsStructure = new SingletonGlobalsStructure(sizes, stock);
		}
		return singletonGlobalsStructure;
	}

	public static SingletonGlobalsStructure getSingletonGlobalsStructure() {
		if (singletonGlobalsStructure == null) {
			singletonGlobalsStructure = new SingletonGlobalsStructure(null, null);
		}
		return singletonGlobalsStructure;
	}

	private SingletonGlobalsStructure(Map<Integer, Product> sizes, List<Stock> stockt) {
		this.sizes = sizes;
		this.stock = stockt;
	}

	public void setSizes(Map<Integer, Product> sizes) {
		this.sizes = sizes;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}

	public Map<Integer, Product> getSizes() {
		return sizes;
	}

	public List<Stock> getStock() {
		return stock;
	}

	public static SingletonGlobalsStructure instance() {
		return SingletonGlobalsStructure.getSingletonGlobalsStructure();
	}

}
