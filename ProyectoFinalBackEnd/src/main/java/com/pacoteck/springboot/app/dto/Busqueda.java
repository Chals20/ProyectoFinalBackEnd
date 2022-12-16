package com.pacoteck.springboot.app.dto;

public class Busqueda {

	private int type;
	private String name;
	private int pmin;
	private int pmax;
	private boolean lactosa;
	private boolean glutten;
	private boolean vegan;
	
	public Busqueda() {}
	
	public Busqueda(int type, String name, int pmin, int pmax, boolean lactosa,
			boolean glutten, boolean vegan) {
		this.type = type;
		this.name = name;
		this.pmin = pmin;
		this.pmax = pmax;
		this.lactosa = lactosa;
		this.glutten = glutten;
		this.vegan = vegan;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPmin() {
		return pmin;
	}

	public void setPmin(int pmin) {
		this.pmin = pmin;
	}

	public int getPmax() {
		return pmax;
	}

	public void setPmax(int pmax) {
		this.pmax = pmax;
	}

	public boolean isLactosa() {
		return lactosa;
	}

	public void setLactosa(boolean lactosa) {
		this.lactosa = lactosa;
	}

	public boolean isGlutten() {
		return glutten;
	}

	public void setGlutten(boolean glutten) {
		this.glutten = glutten;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	@Override
	public String toString() {
		return "Busqueda [type=" + type + ", name=" + name + ", pmin=" + pmin + ", pmax=" + pmax + ", lactosa="
				+ lactosa + ", glutten=" + glutten + ", vegan=" + vegan + "]";
	}

	
}
