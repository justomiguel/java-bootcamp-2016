package topic2EJ1;

import org.junit.Test;

public class FileTest {

	File Test1 = new File ("Test1", "Testing the creation of a first file");
	File Test2 = new File ("Test2","Testing the creation of a second file");
	File Test3 = new File ("Test3","Testing the creation of a third file");
	
	@Test
	public void WhenANewFileThenVerifyParameters (){
		
		String name = Test1.getName();
		String description = Test1.getDescription();
		
		if (name.equals(null)){
			Error EmptyName = new Error ("The name is empty");
			throw EmptyName;
		}else if (description.equals(null)){
			Error EmptyDescription = new Error ("The description is empty");
			throw EmptyDescription;
		}
	}
	
}
