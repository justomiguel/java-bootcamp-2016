package topic2EJ2;

public class Blog {

	private String Title;
	private String description;

	//constructor for Blog class
	public Blog(String title, String description) {
		// TODO Auto-generated constructor stub
		this.Title = title;
		this.description = description;
	}
	
	//method to conect to blog database
	private static String ConectToDatabase() {
		// TODO Auto-generated method stub
		String conection = MockDatabase.ConectToDatabase("localhost","root","12345");
		return conection;
	}
	
	//method to insert a new entry into the blog database
	public static String InsertANewEntry (Blog newEntry){
		
		String msjReturn;
		
		if (newEntry.getTitle().equals(null)){
			Error EmptyTitle = new Error ("The title is empty");
			throw EmptyTitle;
		}else if (newEntry.getDescription().equals(null)){
			Error EmptyDescription = new Error ("The description is empty");
			throw EmptyDescription;
		}else{
			String conection = ConectToDatabase ();
			
			if (conection.equals("Conection succesfully")){
				MockDatabase.Insert(newEntry);
				MockDatabase.OrderList(newEntry);
				msjReturn = "Entry succesfully added";
			}else{
				msjReturn = "ERROR: check for conection parameters";
			}
		}
		
		return msjReturn;
	}
	
	//method to remove an entry from the blog database
	public static void DeleteAnEntry (Blog index){
		MockDatabase.Delete(index);
	}
	
	//method to show the recent blog list
	public static  void ShowRecentList () {
		MockDatabase.showList();
	}
	
	public static void OpenEntry (Blog Entry){
		MockDatabase.OrderList (Entry);
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return this.Title;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

}
