package topic2EJ2;

import org.junit.Test;
import java.util.*;

public class BlogTest {
	Blog FirstEntry = new Blog ("Title for first entry test", "Testing blog with one entry test");
	Blog SecondEntry = new Blog ("Title for second entry test", "Testing blog with two entry test");
	
	
	@Test
	//Test the consistence of a new blog entry
	public void WhenANewEntryThenControlParameters (){
	
		if (FirstEntry.getTitle().equals(null)){
			Error EmptyTitle = new Error ("The title is empty");
			throw EmptyTitle;
		}
		
		if (FirstEntry.getDescription().equals(null)){
			Error EmptyDescription = new Error ("The description is empty");
			throw EmptyDescription;
		}
	}
	
	@Test
	//Test the insertion of a new entry
	public void WhenANewEntryThenInsertIntoBlogDatabase () {
		MockDatabase.Insert (FirstEntry);
	}
	
	@Test
	//Test the delete of an entry
	public void WhenDeleteANewEntryThenDeleteEntry () {
		MockDatabase.Insert (SecondEntry);
		MockDatabase.Delete (SecondEntry);
	}
	
	@Test
	//Test the show list method
	public void WhenAListIsRequiredThenShowBlogList () {
		if (MockDatabase.filesBlog.isEmpty()){
			// TODO: handle exception
			//Show "The list is empty";
			
		}else {
			//Show "The list is not empty";
		}
	}
	

}
