package topic3EJ4AND5;

import java.util.ArrayList;
import java.util.List;

public class MockDatabase {
	
	static List<Element> elementDatabase = new ArrayList <Element> ();

	public static boolean connect(String URL, String User, String Pass) {
		// TODO Auto-generated method stub
		
		if (URL.equals("localhost")){
			if (User.equals("root")){
				if (Pass.equals("12345")){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}

	public static void insert(Element newElement) {
		// TODO Auto-generated method stub
		elementDatabase.add(newElement);
	}

	public static void update(int index, String name, String description) {
		// TODO Auto-generated method stub
		elementDatabase.get(index).name = name;
		elementDatabase.get(index).description = description;
	}

	public static void delete(int index) {
		// TODO Auto-generated method stub
		elementDatabase.remove(index);
	}

	public static void select() {
		// TODO Auto-generated method stub
		System.out.println("Database list");
		
		if (elementDatabase.isEmpty()){
			// TODO: handle exception
			System.out.println("The list is empty");
			
		}else {
			for (int i = 0; i < elementDatabase.size(); i++) {
				System.out.println ((i+1) + ")" + elementDatabase.get(i).getName() + "(" + elementDatabase.get(i).getDescription() + ")");
			}
		}
		
	}

}
