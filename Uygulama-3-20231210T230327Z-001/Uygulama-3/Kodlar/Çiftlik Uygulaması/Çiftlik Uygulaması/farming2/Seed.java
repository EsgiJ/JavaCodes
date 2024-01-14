package farming2;

import java.util.Random;

public class Seed implements Plant {
    private double productionAmount;
    private double financialValue;
    private double maintenanceCost;

    public Seed(double productionAmount, double financialValue, double maintenanceCost) {
        this.productionAmount = productionAmount;
        this.financialValue = financialValue;
        this.maintenanceCost = maintenanceCost;
    }
    double random = new Random().nextDouble();//nextDouble metodu parametre almaz ve 0 ile 1 arasında (1 hariç) rastgele bir ondalık sayı üretir.
    @Override
    public double seedProfit() throws UnsuccessfulHarvestException {

        if (random < 0.25) {

            return -maintenanceCost; // Only maintenance cost, no profit
        }

        return (productionAmount * financialValue) - maintenanceCost;
    }


    @Override
    public void harvest() throws UnsuccessfulHarvestException {
        if (random < 0.25) {
            throw new UnsuccessfulHarvestException("Harvest unsuccessful for seed");
        }
        System.out.println("Harvest successful for seed");
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    @Override
    public String toString() {
        return "Seed [productionAmount=" + productionAmount + ", financialValue=" + financialValue +
                ", maintenanceCost=" + maintenanceCost + "]";
    }
  /*Arkadaşlar dersteki örnekte unsuccesful mesajının çıkmamasının nedeni burada yer alan
  kısmın eklenmemesinden kaynaklıydı. Orada Exception'da catch'in içi boş bırakılmış ancak bize istenilen mesajı döndürmesi için 
   bu şekilde gerçekleştirmemiz gerekli. Hatalı kodu da karşılaştırmalı olarak anlayabilmeniz için aşağıya ekliyorum..*/
    public void performHarvest() {
        System.out.println("Harvesting seed...");
        try {
            harvest();
        } catch (UnsuccessfulHarvestException e) {
            System.out.println("Exception: " + e.getMessage()); 
        }
 /*	public void performHarvest() {
		System.out.println("Harvesting seed...");
		try {
			harvest();
		} catch (UnsuccesfulHarvestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();                   Problemin temel kaynağı buradaydı..
		}*/

    }
}