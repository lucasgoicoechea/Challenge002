package es.challenge.inditex.domain;

import com.opencsv.bean.CsvBindByName;

public class Stock {

	@CsvBindByName(column = "sizeId")
	private int sizeId;

	@CsvBindByName(column = "quantity")
	private int quantity;

	public Stock() {
	}

	public Stock(int id, int quantity) {
		this.sizeId = id;
		this.quantity = quantity;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public int getSizeId() {
		return sizeId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

}
