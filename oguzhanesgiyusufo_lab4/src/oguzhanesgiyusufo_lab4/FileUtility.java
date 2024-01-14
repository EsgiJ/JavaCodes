package oguzhanesgiyusufo_lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileUtility {
	public static List<Staff> readStaffFromFile(String string) {
		try {
		      File myObj = new File(string);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] sData = data.split(",");
		        System.out.println(sData[0]);
		        String name = sData[0];
		        double x = Double.parseDouble(sData[1]);
		        System.out.println(x); // 45.0
		        if (sData[0].equals("Academic")) {
		        	int y = Integer.parseInt(sData[2]);
					@SuppressWarnings("unused")
					AcademicStaff academicStaff = new AcademicStaff(name, x, y);
				}
		        if (sData[0].equals("Staff")){
					@SuppressWarnings("unused")
					Staff staff = new Staff(name, x);
				}
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return Staff;
	}

	public static void writeStaffToFile(List<Staff> staffList, String string) {
		
		try {
			FileWriter myWriter = new FileWriter("updated_staff.txt");
			for (Iterator<Staff> iterator = staffList.iterator(); iterator.hasNext();) {
				Staff staff = (Staff) iterator.next();
				myWriter.write(staff.getName()+",");
				myWriter.write((double) staff.getSalary()+",");
				if (staff instanceof AcademicStaff) {
					AcademicStaff academicStaff = (AcademicStaff)staff;
					myWriter.write((int)academicStaff.getNumberOfCourses());
				}
			    myWriter.close();
			    System.out.println("Successfully wrote to the file.");
			}
	    } catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}
}
