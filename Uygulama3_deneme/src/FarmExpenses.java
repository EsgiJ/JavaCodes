import java.util.List;

public class FarmExpenses {
	public static double calculateTotalPlantProfit(List<Seed> plants) {
		double totalPlantProfit = 0;
		for(Seed plant: plants) {
			try {
				totalPlantProfit += plant.seedProfit();
			} catch (UnsuccesfulHarvestException e) {
				System.out.println("Exception" + e.getMessage());
			}
		}
		return totalPlantProfit;
	}
	public static double calculateTotalAnimalProfit(List<FarmAnimal> farmAnimals) {
		double totalAnimalProfit = 0;
		for(FarmAnimal animal: farmAnimals) {
			totalAnimalProfit += animal.calculateProfit();
		}
		return totalAnimalProfit;
	}
	public static double calculateTotalPlantMaintenanceCost(List<Seed> plants) {
		double totalPlantMaintenanceProfit = 0;
		for(Seed plant: plants) {
			totalPlantMaintenanceProfit += plant.getMaintenanceCost();
		}
		return totalPlantMaintenanceProfit;
	}
	public static double calculateTotalAnimalMaintenanceCost(List<FarmAnimal> farmAnimals) {
		double totalPlantMaintenanceProfit = 0;
		for(FarmAnimal animal: farmAnimals) {
			totalPlantMaintenanceProfit += animal.getMaintenanceCost();
		}
		return totalPlantMaintenanceProfit;
	}
	
}
