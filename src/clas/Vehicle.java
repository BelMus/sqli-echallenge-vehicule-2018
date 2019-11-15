package clas;

public class Vehicle {

	protected String vehicle;
	protected String fuel;
	protected int doors;
	protected double consume;
	
	public String getVehicle() {
		return this.vehicle;
	}
	public String getFuel() {
		return this.fuel;
	}
	public int getDoors() {
		return this.doors;
	}
	public double getConsume() {
		return this.consume;
	}
	
	public Vehicle(String fuel) {
		switch (fuel) {
		case "Diesel": this.consume = 0.05; break;
		case "Gasoline": this.consume = 0.06; break;
		case "Hybrid": this.consume = 0.03; break;
		}
	}
}
