package automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;


//•	        Method addVehicle(Vehicle vehicle) – adds an entity to the collection of Vehicles, if the Capacity allows it.
//•	        Method removeVehicle(String vin) – removes a vehicle by given vin, if such exists, and returns boolean (true if it is removed, otherwise – false)
//•	        Method getCount() – returns the number of vehicles, registered in the RepairShop
//•	        Method getLowestMileage() – returns the Vehicle with the lowest value of Mileage property.
//•	Method report() – returns a string in the following format:
//o	"Vehicles in the preparatory:
//{Vehicle1}
//{Vehicle2}
//(…)"
public class RepairShop {
    private List<Vehicle> vehicles;
    private int capacity;


    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:\n");
        for (Vehicle v :
                vehicles) {
            sb.append(v + "\n");

        }

        return sb.toString();
    }


    public Vehicle getLowestMileage() {
        int lowestMileage = Integer.MAX_VALUE;
        int index = 0;
        for (Vehicle v:
             vehicles) {
            if (v.getMileage() < lowestMileage) {
                lowestMileage = v.getMileage();
                index = vehicles.indexOf(v);
            }
        }

        return vehicles.get(index);
    }


    public int getCount() {
        return vehicles.size();
    }

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public boolean removeVehicle(String vin) {
        for (Vehicle v :
                vehicles) {
            if (vin.equals(v.getVIN())) {
                vehicles.remove(v);
                return true;
            }
        }

        return false;
    }


    public void addVehicle(Vehicle vehicle) {
        if (capacity > vehicles.size()) {
            vehicles.add(vehicle);
        }
    }
}
