package nyp1;

import java.util.Scanner;

public class SportClub_edu {

	public static void main(String[] args) {
		Sports sp1 = new Sports();
		sp1.setName("tennis");
		System.out.println(sp1.getName());
		
		Scanner input = new Scanner(System.in);
		System.out.println("enter sport name:");
		String sp_name = input.nextLine();
		
		Sports sp2 = new Sports();
		sp2.setName(sp_name);
		System.out.println(sp2.getName());
		
		Sports sp3 = new Sports("basketball", 10, 25.90);
		
	}

}
