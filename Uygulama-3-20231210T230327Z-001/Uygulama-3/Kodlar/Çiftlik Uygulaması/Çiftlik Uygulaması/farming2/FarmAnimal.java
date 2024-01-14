package farming2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FarmAnimal implements Animal {
	
    private double weight;
    private double maintenanceCost;
    private double valuePerKg;

    
    public FarmAnimal(double weight, double maintenanceCost, double valuePerKg) {
        this.weight = weight;
        this.maintenanceCost = maintenanceCost;
        this.valuePerKg = valuePerKg;
    }

    @Override
    public double calculateProfit() {
        return (weight * valuePerKg) - (maintenanceCost * valuePerKg) ;
    }
    

    @Override
    public void feed() {
        System.out.println("Feeding farm animal...");
        // logic for feeding the animal
        System.out.println("Animal fed");

    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }
    private static ArrayList<FarmAnimal> createRandomFarmAnimals() {
        ArrayList<FarmAnimal> animals = new ArrayList<>();
        
        Random random = new Random();
        
        int numberOfAnimals = (int) (Math.random() * 10) + 1; // Random number between 1 and 10

        for (int i = 0; i < numberOfAnimals; i++) {
            double weight = random.nextDouble() * 200 + 1; 
            double maintenanceCost = random.nextDouble() * 100 + 1; 
            double valuePerKg = random.nextDouble() * 10 + 1; 
            animals.add(new FarmAnimal(weight, maintenanceCost, valuePerKg));
        }
        System.out.println("Total Number of Animals: " + numberOfAnimals);
        return animals;
    }

    public static List<FarmAnimal> getCreatedAnimals() {
        return createRandomFarmAnimals();
    }
   
}