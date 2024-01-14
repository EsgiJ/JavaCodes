package oguzhanesgiyusufo_lab3;

public class Treatment {
	private String medication;
	private int restPeriodDays;
	private double surgeryCost;
	
	public Treatment(String medication, int restPeriodDays, double surgeryCost) {
		this.medication = medication;
		this.restPeriodDays = restPeriodDays;
		this.surgeryCost = surgeryCost;
	}

	@Override
	public String toString() {
		return "Treatment [medication=" + medication + ", restPeriodDays=" + restPeriodDays + ", surgeryCost="
				+ surgeryCost + "]";
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public int getRestPeriodDays() {
		return restPeriodDays;
	}


	public double getSurgeryCost() {
		return surgeryCost;
	}

	
}
