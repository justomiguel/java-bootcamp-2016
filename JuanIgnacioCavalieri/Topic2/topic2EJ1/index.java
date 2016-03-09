package topic2EJ1;

public class index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//HEADING
		System.out.println("Exercise number one from Topic 2 of Java-bootcamp ");
		System.out.println("NOTE: just to show the functionality of the programm, the limit of recent list is five ");
		System.out.println("");
		
		
		//Show the empty list
		System.out.println("TEST: Show the empty list");
		RecentFileList.ShowList();
		System.out.println("*********************************************************************");
		System.out.println("");
		
		//Create the objects to test the program
		File firstFile = new File ("First File", "Testing with one file");
		File secondFile = new File ("Second File", "Testing with two files");
		File thirdFile = new File ("Third File", "Testing with three files");
		File fourthFile = new File ("Fourth File", "Testing with four files");
		File fifthFile = new File ("Fifth File", "Testing with five files");

		//Open all files and show the list
		System.out.println("TEST: Open all files and show the list");
		File.OpenFile (firstFile);
		File.OpenFile (secondFile);
		File.OpenFile (thirdFile);
		File.OpenFile (fourthFile);
		File.OpenFile (fifthFile);
		RecentFileList.ShowList();
		System.out.println("*********************************************************************");
		System.out.println("");
		
		//Open again the first file to site it on the top of the list
		System.out.println("TEST: Open again the first file to site it on the top of the list");
		File.OpenFile (firstFile);
		RecentFileList.ShowList();
		System.out.println("*********************************************************************");
		System.out.println("");
		
		//Create a sixth file and open it. The second file must dissapear from the list
		System.out.println("TEST: Create a sixth file and open it. The second file must dissapear from the list");
		File sixthFile = new File ("Sixth File", "Testing with six files");
		File.OpenFile (sixthFile);
		RecentFileList.ShowList();
		System.out.println("*********************************************************************");
		System.out.println("");
	}

}
