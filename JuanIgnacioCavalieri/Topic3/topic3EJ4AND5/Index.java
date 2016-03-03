package topic3EJ4AND5;

/**
 *Main Class Index corresponding to the Topic 3 of Java bootcamp
 *It is used to use the service and all the methods
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
public class Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Element element1 = new Element("First element", "This is the first element for a test");
		Element element2 = new Element("Second element", "This is the second element for a test");
		Element element3 = new Element("Third element", "This is the third element for a test");
		
		CRUDService service1 = CRUDServiceFactory.getLocalCRUDService();
		CRUDService service2 = CRUDServiceFactory.getRemoteCRUDService();
		
		service1.connect("localhost", "root", "12345");
		service2.connect("localhost", "root", "12345");
		
		//HEADING
		System.out.println("Exercise number five from Topic 3 of Java-bootcamp ");
		System.out.println("");
		
		//Show the empty list
		System.out.println("TEST: Show the empty list");
		service2.select();
		System.out.println("*********************************************************************");
		System.out.println("");
		
		//Insert an element into the database
		System.out.println("TEST: Insert an element into the database");
		service2.insert(element1);
		service2.select();
		System.out.println("*********************************************************************");
		System.out.println("");
		
		//Insert an element into the database
		System.out.println("TEST: Insert an element into the database");
		service2.update(0, "First element updated", "The first file was updated");
		service2.select();
		System.out.println("*********************************************************************");
		System.out.println("");
		
		//Delete an element from database
		System.out.println("TEST: Delete an element from database");
		service2.delete(0);;
		service2.select();
		System.out.println("*********************************************************************");
		System.out.println("");
	}

}
