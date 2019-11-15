package clas;

public class Car extends Vehicle{

	public Car(String vehicle, String fuel, int doors) {
		super(fuel);
		this.doors = doors;
		this.fuel = fuel;
		this.vehicle = vehicle;
	}
}
