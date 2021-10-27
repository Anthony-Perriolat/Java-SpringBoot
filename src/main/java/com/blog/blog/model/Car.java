package com.blog.blog.model;


public class Car {
	
	private int id;
	private String name;
	private ModelCar model;
	private String brand;
	private Integer color;
	
	
	
	
	public Car(int id, String name, ModelCar model, String brand, Integer color) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.brand = brand;
		this.color = color;
	}
	
	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ModelCar getModel() {
		return model;
	}
	public int getIdModel() {
		return model.getId();
	}
	public void setModel(ModelCar model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	
}
