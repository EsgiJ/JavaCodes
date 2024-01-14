package farming2;

import java.util.List;

public class FarmExpenses {

    public static double calculateTotalPlantProfit(List<Seed> plants) {
        double totalPlantProfit = 0;
        for (Plant plant : plants) {
            try {
                totalPlantProfit += plant.seedProfit();
            } catch (UnsuccessfulHarvestException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
        return totalPlantProfit;
    }

    public static double calculateTotalAnimalProfit(List<FarmAnimal> farmAnimals) {
        double totalAnimalProfit = 0;
        for (Animal animal : farmAnimals) {
            totalAnimalProfit += animal.calculateProfit();
        }
        return totalAnimalProfit;
    }

    public static double calculateTotalPlantMaintenanceCost(List<Seed> plants) {
        double totalPlantMaintenanceCost = 0;
        for (Plant plant : plants) {
            totalPlantMaintenanceCost += ((Seed) plant).getMaintenanceCost();
        }
        return totalPlantMaintenanceCost;
    }

    public static double calculateTotalAnimalMaintenanceCost(List<FarmAnimal> farmAnimals) {
        double totalAnimalMaintenanceCost = 0;
        for (Animal animal : farmAnimals) {
            totalAnimalMaintenanceCost += ((FarmAnimal) animal).getMaintenanceCost();
        }
        return totalAnimalMaintenanceCost;
    }
}
