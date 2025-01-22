package com.hcl.entity;

public class Vehicle {
	
	private String regNumber;
	private String model;
	private int wheeler;
	private String vehiclePic;
	private int pricePerKm;
	public Vehicle() {
		
	}
	public Vehicle(String regNumber, String model, int wheeler, String vehiclePic, int pricePerKm) {
		super();
		this.regNumber = regNumber;
		this.model = model;
		this.wheeler = wheeler;
		this.vehiclePic = vehiclePic;
		this.pricePerKm = pricePerKm;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getWheeler() {
		return wheeler;
	}
	public void setWheeler(int wheeler) {
		this.wheeler = wheeler;
	}
	public String getVehiclePic() {
		return vehiclePic;
	}
	public void setVehiclePic(String vehiclePic) {
		this.vehiclePic = vehiclePic;
	}
	public int getPricePerKm() {
		return pricePerKm;
	}
	public void setPricePerKm(int pricePerKm) {
		this.pricePerKm = pricePerKm;
	}
	

}
