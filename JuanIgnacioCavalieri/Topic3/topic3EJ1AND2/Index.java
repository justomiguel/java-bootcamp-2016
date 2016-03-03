package topic3EJ1AND2;

/**
 *Main Class Index corresponding to the Topic 3 of Java bootcamp
 *It is used to use the service and all the methods
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
public class Index {

	public static void main(String[] args) {
		
		Element element1 = new Element("First element", "This is the first element for a test");
		Element element2 = new Element("Second element", "This is the second element for a test");
		Element element3 = new Element("Third element", "This is the third element for a test");
		
		ShoppingCartService service1 = ShoppingCartServiceFactory.getLocalShoppingCartService();
		ShoppingCartService service2 = ShoppingCartServiceFactory.getRemoteShoppingCartService();
		
		//HEADING
		System.out.println("Exercise number two from Topic 3 of Java-bootcamp ");
		System.out.println("");
		
		//Show the empty list
		System.out.println("TEST: Show the empty list");
		service2.showList();
		System.out.println("*********************************************************************");
		System.out.println("");

		//Add an element whit the local service
		System.out.println("TEST: Add an element whit the local service");
		service1.insertANewElement(element1, 2);
		service1.showList();
		System.out.println("*********************************************************************");
		System.out.println("");
		
		//Add thow elements whit the remote service
		System.out.println("TEST: Add thow elements whit the remote service");
		service2.insertANewElement(element2, 3);
		service2.insertANewElement(element3, 1);
		service2.showList();
		System.out.println("*********************************************************************");
		System.out.println("");
		
		//Remove the first elemen from the list using remote service
		System.out.println("TEST: Remove the first element from the list using remote service");
		service2.removeElement(0);
		service2.showList();
		System.out.println("*********************************************************************");
		System.out.println("");
		
		//Remove all elements from the list using remote service
		System.out.println("TEST: Remove all elements from the list using remote service");
		service2.removeAll();
		service2.showList();
		System.out.println("*********************************************************************");
		System.out.println("");
	}

}
