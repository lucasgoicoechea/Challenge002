package es.challenge.inditex.domain;

import com.opencsv.bean.CsvBindByName;

public class Product {

	@CsvBindByName(column = "id")
	private int id;

	@CsvBindByName(column = "sequence")
	private int sequence;

	// transient
	private int quantityCommonOrBacksoonStock = 0;

	// transient
	private int quantitySpecialStock = 0;

	// transient
	private boolean hasSpecialSize = false;

	// transient
	private boolean hasBacksoonSize = false;

	public Product() {
	}

	public Product(int id, int sequence) {
		this.id = id;
		this.sequence = sequence;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public boolean isHasSpecialSize() {
		return hasSpecialSize;
	}

	public void setHasSpecialSize(boolean hasSpecialSize) {
		this.hasSpecialSize = hasSpecialSize;
	}

	public int getQuantityCommonOrBacksoonStock() {
		return quantityCommonOrBacksoonStock;
	}

	public void setQuantityCommonOrBacksoonStock(int quantityCommonOrBacksoonStock) {
		this.quantityCommonOrBacksoonStock = quantityCommonOrBacksoonStock;
	}

	public int getQuantitySpecialStock() {
		return quantitySpecialStock;
	}

	public void setQuantitySpecialStock(int quantitySpecialStock) {
		this.quantitySpecialStock = quantitySpecialStock;
	}

	public boolean isHasBacksoonSize() {
		return hasBacksoonSize;
	}

	public void setHasBacksoonSize(boolean hasBacksoonSize) {
		this.hasBacksoonSize = hasBacksoonSize;
	}

}
