package oguzhanesgiyusufo_lab4;

public class AcademicStaff extends Staff{
	private int numberOfCourses;

	public AcademicStaff(String name, double salary, int numberOfCourses) {
		super(name, salary);
		this.numberOfCourses = numberOfCourses;
	}

	@Override
	public void IncreaseSalary(double percentage) {
		super.IncreaseSalary(percentage);
		setSalary(getSalary()+ numberOfCourses*1000);
	}

	public int getNumberOfCourses() {
		return numberOfCourses;
	}

	public void setNumberOfCourses(int numberOfCourses) {
		this.numberOfCourses = numberOfCourses;
	}
	
}
