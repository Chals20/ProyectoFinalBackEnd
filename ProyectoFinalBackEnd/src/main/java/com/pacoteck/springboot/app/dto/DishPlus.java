package com.pacoteck.springboot.app.dto;

import javax.persistence.Entity;

public class DishPlus {

	private Long id;
	
	private String name;
	
	private String img;
	
	private Double price;
	
	private  int amount;

	public DishPlus() {}
	
	public DishPlus(Long id, String name, String img, Double price, int amount) {
		this.id = id;
		this.name = name;
		this.img = img;
		this.price = price;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DishPlus [id=" + id + ", name=" + name + ", img=" + img + ", price=" + price + ", amount=" + amount
				+ "]";
	}
	
	
	
}
