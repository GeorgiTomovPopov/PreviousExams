package vendingSystem;

import java.util.ArrayList;
import java.util.List;

//•	        getCount() - int - returns the number of drinks, available in the Vending machine.
//•	        Method addDrink(Drink drink) – adds an entity to the collection of Drinks, if the Capacity allows it.
//•	        Method removeDrink(String name) – removes a drink by given name, if such exists, and returns boolean (true if it is removed, otherwise – false)
//•	        Method getLongest() – returns the Drink with the biggest value of volume property.
//•	        Method getCheapest() – returns the Drink with the lowest value of price property.
//•	        Method buyDrink(String name) - returns a string in the format of the overridden toString() method.
//•	Method report() – returns a string in the following format:
//o	"Drinks available:
//{Drink1}
//{Drink2}
//(…)"
public class VendingMachine {

    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }


    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Drinks available:");

        for (Drink drink :
                drinks) {
            sb.append("\n");
            sb.append(drink);
        }

        return sb.toString();
    }

    public String buyDrink(String name) {
        int index = 0;
        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).getName().equals(name)) {
                index = i;
            }
        }

        return drinks.get(index).toString();
    }

    public Drink getCheapest() {
        double cheapest = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).getPrice().doubleValue() < cheapest) {
                cheapest = drinks.get(i).getPrice().doubleValue();
                index = i;
            }
        }

        return drinks.get(index);
    }

    public Drink getLongest() {
        int longest = 0;
        int index = 0;
        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).getVolume() > longest) {
                longest = drinks.get(i).getVolume();
                index = i;
            }
        }

        return drinks.get(index);
    }


    public boolean removeDrink(String name) {
        for (Drink drink :
                drinks) {
            if (drink.getName().equals(name)) {
                drinks.remove(drink);
                return true;
            } else return false;
        }

        return false;
    }

    public void addDrink(Drink drink) {
        if (buttonCapacity > drinks.size()) {
            drinks.add(drink);
        }
    }

    public int getCount() {
        return drinks.size();
    }
}
