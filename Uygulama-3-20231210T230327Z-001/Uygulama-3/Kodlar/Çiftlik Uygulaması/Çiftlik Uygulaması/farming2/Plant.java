package farming2;

public interface Plant {
    public double seedProfit() throws UnsuccessfulHarvestException;
    public void harvest() throws UnsuccessfulHarvestException;
}