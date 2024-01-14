import java.util.Random;

public class Seed {
	private double productionAmount;
	private double financialValue;
	private double maintenanceCost;
	
	public Seed(double productionAmount, double financialValue, double maintenanceCost) {
		super();
		this.productionAmount = productionAmount;
		this.financialValue = financialValue;
		this.maintenanceCost = maintenanceCost;
	}

	@Override
	public String toString() {
		return "Seed [productionAmount=" + productionAmount + ", financialValue=" + financialValue
				+ ", maintenanceCost=" + maintenanceCost + "]";
	}

	public double getMaintenanceCost() {
		return maintenanceCost;
	}

	public void setMaintenanceCost(double maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}
	double random = new Random().nextDouble();
	public void harvest() throws UnsuccesfulHarvestException {
		if (random < 0.25) {
			throw new UnsuccesfulHarvestException("Harvest unsuccesful for seed.");
		}
		System.out.println("Harvest succesful for seed");
	}
	public void performHarvest() throws UnsuccesfulHarvestException {
		System.out.println("Harvesting seed...");
		try {
			harvest();
		} catch (UnsuccesfulHarvestException e) {
			System.out.println("Exception" + e.getMessage());
		}
	}
	public double seedProfit() throws UnsuccesfulHarvestException {
		if (random < 0.25) {
			return -maintenanceCost;//Only maintenance cost no profit
		}
		return (productionAmount * financialValue) - maintenanceCost;
	}
}
