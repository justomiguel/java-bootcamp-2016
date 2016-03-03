package topic2EJ1;
import java.util.*;

public class File {

	private String name;
	private String description;
	

	//Constructor of File object
	public File(String name, String description) {
		this.SetName(name);
		this.SetDescription (description);
	
	}
	
	public void SetName (String name){
		this.name = name;
	}
	
	public void SetDescription (String description){
		this.description = description;
	}
	
	public String GetName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public String GetDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	//Whena newfile is open, then it is added to the recent file list
	public static void OpenFile(File openedFile) {
		// TODO Auto-generated method stub
		RecentFileList.newFileIntoArray (openedFile);
		
	}

}
