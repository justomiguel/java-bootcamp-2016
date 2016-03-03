package topic2EJ2;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import topic2EJ1.File;

public class MockDatabase {
	
	static List<Blog> filesBlog = new ArrayList <Blog> ();
	static List<Blog> filesBlogAux = new ArrayList <Blog> ();

	public static String ConectToDatabase (String URL, String User, String Pass){
		String msj;
		
		if (URL.equals("localhost")){
			
			if (User.equals("root")){
				
				if (Pass.equals("12345")){
					msj = "Conection succesfully";
				}else{
					msj = "Error: check for password";
				}
				
			}else{
				msj = ("Error: check for User");
			}
			
		}else{
			msj = ("Error: check for URL");
		}
		
		return msj;
	}
	
	public static void Insert (Blog newEntry){
		filesBlog.add(newEntry);
	}

	public static void Delete(Blog entry) {
		// TODO Auto-generated method stub
		String nameEntry = entry.getTitle();
		int index = 0;
		
		for (int i = 0; i < filesBlog.size(); i++) {
			if (nameEntry.equals(filesBlog.get(i).getTitle()) ){
				index = i;
			}
		}
		filesBlog.remove(index);
		
	}

	public static void showList() {
		// TODO Auto-generated method stub
		
		if (filesBlog.isEmpty()){
			// TODO: handle exception
			System.out.println("The recent file list is empty");
			
		}else {
			if (filesBlog.size() > 10){
				for (int i = 0; i < 11; i++) {
					System.out.println ((i+1) + ")" + filesBlog.get(i).getTitle() + "-" + filesBlog.get(i).getDescription());
				}
			}else{
				for (int i = 0; i < filesBlog.size(); i++) {
					System.out.println ((i+1) + ")" + filesBlog.get(i).getTitle() + "-" + filesBlog.get(i).getDescription());
				}
			}
			
		}
		
	}

	public static void OrderList(Blog entry) {
		// TODO Auto-generated method stub
		String nameEntry = entry.getTitle();
		int index = 0;
		
		for (int i = 0; i < filesBlog.size(); i++) {
			if (nameEntry.equals(filesBlog.get(i).getTitle()) ){
				index = i;
			}
		}
		filesBlogAux = filesBlog;		
		filesBlog.add(0, filesBlogAux.get(index));
		filesBlog.remove(index+1);
		
	}
}
