package topic2EJ2;

import topic2EJ1.File;
import topic2EJ1.RecentFileList;

public class Index {

	public static void main(String[] args) {
		
		//HEADING
		System.out.println("Exercise number two from Topic 2 of Java-bootcamp ");
		System.out.println("");
		
		//Show the empty list
		System.out.println("TEST: Show the empty list");
		Blog.ShowRecentList();
		System.out.println("*********************************************************************");
		System.out.println("");
				
		//Create the objects to test the program
		Blog firstEntry = new Blog ("First Entry", "Testing with one Entry");
		Blog secondEntry = new Blog ("Second Entry", "Testing with two Entry");
		Blog thirdEntry = new Blog ("Third Entry", "Testing with three Entry");
		Blog fourthEntry = new Blog ("Fourth Entry", "Testing with four Entry");
		Blog fifthEntry = new Blog ("Fifth Entry", "Testing with five Entry");
		
		//Open all files and show the list
		System.out.println("TEST: Create all files and show the list");
		Blog.InsertANewEntry (firstEntry);
		Blog.InsertANewEntry (secondEntry);
		Blog.InsertANewEntry (thirdEntry);
		Blog.InsertANewEntry (fourthEntry);
		Blog.InsertANewEntry (fifthEntry);
		Blog.ShowRecentList();
		System.out.println("*********************************************************************");
		System.out.println("");
		
		//Open again the first file to site it on the top of the list
		System.out.println("TEST: Open again the first entry to site it on the top of the list");
		Blog.OpenEntry (firstEntry);
		Blog.ShowRecentList();
		System.out.println("*********************************************************************");
		System.out.println("");
		
		//Create a sixth file. The second file must dissapear from the list
		System.out.println("TEST: Create a sixth file and open it. The second file must dissapear from the list");
		Blog sixthEntry = new Blog ("Sixth Entry", "Testing with six Entry");
		Blog.InsertANewEntry(sixthEntry);
		Blog.ShowRecentList();
		System.out.println("*********************************************************************");
		System.out.println("");
		
		//Delete The third entry and show the list
		System.out.println("TEST: Delete The third entry and show the list");
		Blog.DeleteAnEntry(thirdEntry);
		Blog.ShowRecentList();
		System.out.println("*********************************************************************");
		System.out.println("");

	}
}
