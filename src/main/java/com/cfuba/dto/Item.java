package com.cfuba.dto;

import java.io.Serializable;

public class Item implements Serializable{

	int id;
	String name;
	double mrp;
	String description;
	
	public Item(int id, String name, double mrp, String description) {
		super();
		this.id = id;
		this.name = name;
		this.mrp = mrp;
		this.description = description;
	}
	
	public Item() {
	
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
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", mrp=" + mrp + ", description=" + description + "]";
	}
	
}
