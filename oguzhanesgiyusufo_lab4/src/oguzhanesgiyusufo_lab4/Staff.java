package oguzhanesgiyusufo_lab4;

public class Staff {
	private String name;
	private double salary;
	
	public Staff(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public void IncreaseSalary(double percentage) {
		salary += salary*percentage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
