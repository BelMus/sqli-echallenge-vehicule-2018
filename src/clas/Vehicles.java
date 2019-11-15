package clas;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

public class Vehicles {
	List<Vehicle> road = new LinkedList<Vehicle>();

	public Vehicles(String roadS) {
		String[] seperatedVehicules = roadS.split(", ");
		for (String parameter : seperatedVehicules) {
			road.add(VehicleCreator.getVehicle(parameter));
		}
	}

	public static void main(String[] args) {
		Vehicles vehicles = new Vehicles("CAR:Hybrid:4, TRUCK:Diesel:2, MOTORCYCLE:Gasoline:0");
		String report = vehicles.move("CAR", "1 2 4", "200 KM");
		System.out.println("DOORS KO, BLOCKED \n" + "  _\n" + " | |\n" + " /_|");
		System.out.println(report);

	}

	public String move(String vehicle, String doors, String vitesse) {
		StringBuilder sb = new StringBuilder();
		Vehicle ve = findVehicle(vehicle);
		if (ve != null) {
			if (checkDoors(doors, ve.getDoors())) {
				sb.append("DOORS OK, MOVING. The ").append(ve.getVehicle()).append(" will consume ")
						.append(calculerConsumation(ve.consume, vitesse)).append(" L");
			} else {
				// ----------
				System.out.println(ve.getDoors());
				sb.append(getErrorDoor(doors, ve.getDoors()));
			}

		}
		return sb.toString();
	}

	public boolean checkDoors(String doors, int numberDoors) {
		String[] doorsArray = doors.split(" ");
		for (int i = 1; i <= numberDoors; i++) {
			if (i != Integer.parseInt(doorsArray[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public Vehicle findVehicle(String vehicle) {
		Vehicle v = road.stream().map(c -> c).filter(c -> c.getVehicle().equals(vehicle)).findFirst().orElse(null);

		return v;
	}

	public double getNumber(String vitesse) {
		double res = Double.parseDouble(vitesse.substring(0, vitesse.length() - 2));
		return res;
	}

	public String calculerConsumation(double consume, String vitesse) {
		System.out.println(consume * getNumber(vitesse));
		return String.format("%.02f", consume * getNumber(vitesse));
	}

	public String getErrorDoor(String doors, int numberDoors) {
		String sb = "DOORS KO, BLOCKED \n  _\n";
		String[] doorsArray = doors.split(" ");
		int cpt = 0;
		for (int i = 1; i <= numberDoors; i++) {
			if (i != Integer.parseInt(doorsArray[cpt])) {
				if (i % 2 == 1) {
					sb += " /";
					// sb +="a";
				} else {
					// sb +="b";
					if (cpt == numberDoors - 1) {
						//sb += "_";
						sb += "_\\";
					} else {
						sb += " \\\n";
					}
				}

			} else {
				cpt++;
				if (i % 2 == 1) {
					// sb += "c";
					sb += " |";
				} else {
					if (cpt == numberDoors - 1) {
						//sb += "_";
						sb += "_|";
					} else {
						sb += " |\n";
					}
				}
			}

		}
		return sb;
	}
}
