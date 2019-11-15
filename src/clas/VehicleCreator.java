package clas;

public class VehicleCreator {

	public static Vehicle getVehicle(String parameter) {
		Vehicle vehicle = null;
		String[] separateParameter = parameter.split(":");
		switch (separateParameter[0]) {
		case "CAR":
			vehicle = new Car(separateParameter[0], separateParameter[1], Integer.parseInt(separateParameter[2]));
			break;
		case "TRUCK":
			vehicle = new Truck(separateParameter[0], separateParameter[1], Integer.parseInt(separateParameter[2]));
			break;
		case "MOTORCYCLE":
			vehicle = new Motorcycle(separateParameter[0], separateParameter[1], Integer.parseInt(separateParameter[2]));
			break;
		}
		return vehicle;
	}
}
