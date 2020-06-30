package io.spandiar.reactive.rxjava.model;

public class StockSymbol {
	
	private String symbol;
	private float price;
	
	public StockSymbol() {
		
	}
	
	public StockSymbol(String symbol, float price) {
		super();
		this.symbol = symbol;
		this.price = price;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StockSymbol: " + symbol + ", price=" + price;
	}

}

