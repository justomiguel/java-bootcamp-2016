package exercise1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FileList {

	ListOfFiles lof = new ListOfFiles();
	ArrayList<String> actualList = new ArrayList<String>();
	

	@Before
	public void SetUp() {
		int var=0;
		lof.addNoDumplicates(actualList, "Red.java");
		lof.addNoDumplicates(actualList, "Blue.java");
		lof.addNoDumplicates(actualList, "Blue.java");// I can try to add a similar File but don't work
		lof.addNoDumplicates(actualList, "Green.java");//max 3 elements, after that it's removed the older file
		lof.addNoDumplicates(actualList, "Orange.java");//replace the first element
		
		lof.ReplaceOlderFile(actualList, lof, var);
		var++;
		lof.addNoDumplicates(actualList, "Yellow.java");//replace the second element
		lof.ReplaceOlderFile(actualList, lof, var);
		
		lof.Show(actualList); // show the actual elements in the Array
	}
	
	@Test
	public void compareFilesAfteReplaceOldersFiles(){
		assertEquals(actualList.get(0), "Orange.java");
		assertEquals(actualList.get(1), "Yellow.java");
	}
}
