package farming2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FarmTest{

    public static void main(String[] args) throws UnsuccessfulHarvestException {

    	double main_profit;
        double totalPlantProfit = 0;        // Calculating total profit for plants
        double totalAnimalProfit = 0;         // Calculating total profit for animals
        double totalPlantMaintenanceCost = 0;
        double totalAnimalMaintenanceCost = 0;
        
    	Farmer f1 = new Farmer(234, "Ellie Brown");
    	Farmer f2 = new Farmer(345, "Mike Garret");
    	Farmer f6 = new Farmer(123, "Alex Copper");
    	ArrayList<Farmer> per_list = new ArrayList<>();
		per_list.add(f1);
		per_list.add(f2);
        per_list.remove(f6);

		
        System.out.println("********* info *********");
        InfoClass.getListInfo(per_list);
        
        System.out.println("\n ********* Case *********");
        Seed cornSeed = new Seed(100, 2.5, 40);
        Seed wheatSeed = new Seed(80, 3, 30);
        Seed tomatoSeed = new Seed(120, 1.5, 50);
		
        InfoClass.getObjectInfo(cornSeed);
        InfoClass.getObjectInfo(wheatSeed);
        InfoClass.getObjectInfo(tomatoSeed);
        

        List<Seed> plants = new ArrayList<>();
        plants.add(cornSeed);
        plants.add(wheatSeed);
        plants.add(tomatoSeed);

        for (Seed plant : plants) {

            plant.performHarvest(); 
        }
        		
        List<FarmAnimal> farmAnimals = FarmAnimal.getCreatedAnimals();
        
        for (FarmAnimal animal : farmAnimals) {
            animal.feed();
        }

        totalPlantProfit = FarmExpenses.calculateTotalPlantProfit(plants);
        totalAnimalProfit = FarmExpenses.calculateTotalAnimalProfit(farmAnimals);
        totalPlantMaintenanceCost = FarmExpenses.calculateTotalPlantMaintenanceCost(plants);
        totalAnimalMaintenanceCost = FarmExpenses.calculateTotalAnimalMaintenanceCost(farmAnimals);

        main_profit = (totalPlantProfit + totalAnimalProfit) -
                      (totalPlantMaintenanceCost + totalAnimalMaintenanceCost);

        System.out.println("\n******* calculating profit *********");
        System.out.println("Total Plant Profit: $" + totalPlantProfit);
        System.out.println("Total Animal Profit: $" + totalAnimalProfit);
        System.out.println("Total Plant Maintenance Cost: $" + totalPlantMaintenanceCost);
        System.out.println("Total Animal Maintenance Cost: $" + totalAnimalMaintenanceCost);
        System.out.println("Total Farm Profit: " + main_profit);
        
        Farmer f3 = new Farmer(111, "Caleb Harris");
        Farmer f4 = new Farmer(222, "Christy Clark");

        Map<Integer, Farmer> farmerMap = new HashMap<>();
        
        farmerMap.put(f3.getId(), f3);
        farmerMap.put(f4.getId(), f4);
        farmerMap.put(f1.getId(), f1);
        
        System.out.println("\n********* Farmer HashMap Example *********");
        int farmerIdToLookup = 234;
        //int farmerIdToLookup = 333;
        Farmer farmerToLookup = farmerMap.get(farmerIdToLookup);

        if (farmerToLookup != null) {
            System.out.println("Farmer found in HashMap: " + farmerToLookup);
        } else {
            System.out.println("Farmer with ID " + farmerIdToLookup + " not found.");
        }
    
    }

}
