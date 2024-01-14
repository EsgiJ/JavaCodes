package oguzhanesgiyusufo_lab4;

import java.util.Iterator;
import java.util.List;

public class SalaryIncreaseThread extends Thread{
	private List<Staff>staffList;
	private double IncreasePercentage;
	public SalaryIncreaseThread(List<Staff> staffList, double increasePercentage) {
		super();
		this.staffList = staffList;
		IncreasePercentage = increasePercentage;
	}
	
	public void run() {
		for (Iterator<Staff> iterator = staffList.iterator(); iterator.hasNext();) {
			Staff staff = (Staff) iterator.next();
			staff.IncreaseSalary(IncreasePercentage);
		}
	}

}
