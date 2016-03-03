package exercise1;

import java.util.ArrayList;


import java.util.Scanner;


//EXTRA
//EXTRA
//EXTRA
public class Main {

	
	// Little Application
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListOfFiles lof = new ListOfFiles();

		ArrayList<String> actualList = new ArrayList<String>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("desea agregar un archivo 1-'s' 2-'n' \n");
		int res = sc.nextInt();
		int var = 0;
		
		
		while (res != 1) {
			System.out.println("digite el nombre \n");
			String element = sc.next();

			lof.addNoDumplicates(actualList, element);

			if (actualList.size() > 15) {
				lof.OutOfRange(actualList, var);
				var++;
			}
			if (var == actualList.size()) {
				var = 0;
			}
			lof.Show(actualList);
			System.out.println("desea agregar otro archivo 1-'s' 2-'n' \n");
			res = sc.nextInt();
		}
		;
	}

}
