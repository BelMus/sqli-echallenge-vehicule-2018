package clas;

public class Motorcycle extends Vehicle{

	public Motorcycle(String vehicle, String fuel, int doors) {
		super(fuel);
		this.doors = doors;
		this.fuel = fuel;
		this.vehicle = vehicle;
	}
}
