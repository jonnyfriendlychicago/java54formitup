package com.jonfriend.java54formitup.models;

public class Item {

	private String name; 
	private double price; 
	
	public Item(String name, double price) {
		this.setName(name); 
//		this.nameSetter(name); 
		this.setPrice(price); 
	}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

//	public String nameGetter() {return name; }
//	public void nameSetter(String name) {this.name = name;}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
//	
//	public double priceGetter() {return price; }
//	public void priceSetter(double price) {this.price = price;}
	
}
