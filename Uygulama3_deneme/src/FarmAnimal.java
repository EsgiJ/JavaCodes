import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FarmAnimal {
	private double weight;
	private double maintenanceCost;
	private double valuePerKg;
	
	public FarmAnimal(double weight, double maintenanceCost, double valuePerKg) {
		super();
		this.weight = weight;
		this.maintenanceCost = maintenanceCost;
		this.valuePerKg = valuePerKg;
	}
	
	public double getMaintenanceCost() {
		return maintenanceCost;
	}
	private static ArrayList<FarmAnimal> createRandomFarmAnimals(){
		ArrayList<FarmAnimal> animals = new ArrayList<FarmAnimal>();
		Random random = new Random();
		
		int numberOfAnimals = (int)(Math.random()*10)+1;
		
		for (int i = 0; i < numberOfAnimals; i++) {
			double weight = random.nextDouble()*200 + 1;
			double maintenanceCost = random.nextDouble()*100 + 1;
			double valuePerKg = random.nextDouble()*10 + 1;
			animals.add(new FarmAnimal(weight, maintenanceCost, valuePerKg));
			System.out.println("Total number of Animals: " + numberOfAnimals);
		}
		return animals;
	}
	public List<FarmAnimal> getCreatedAnimals(){
		return createRandomFarmAnimals();
	}
	public double calculateProfit() {
		return (weight * valuePerKg) - (maintenanceCost * valuePerKg);
	}
	public void feed() {
		System.out.println("Feeding farm animal...");
		System.out.println("Animal fed");
	}
}
