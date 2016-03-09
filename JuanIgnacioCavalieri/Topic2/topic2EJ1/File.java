package topic2EJ1;

public class File {

	private String name;
	private String description;
	

	//Constructor of File object
	public File(String name, String description) {
		this.setName(name);
		this.setDescription (description);
	
	}
	
	public void setName (String name){
		this.name = name;
	}
	
	public void setDescription (String description){
		this.description = description;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	//Whena newfile is open, then it is added to the recent file list
	public static void OpenFile(File openedFile) {
		// TODO Auto-generated method stub
		RecentFileList.newFileIntoArray (openedFile);
		
	}

}
