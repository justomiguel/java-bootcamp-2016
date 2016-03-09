package topic3EJ1AND2;
import org.junit.Test;

/**
 *Class ShoppingCartServiceTest corresponding to the Topic 3 of Java bootcamp
 *It is used to make a TDD develop
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
public class ShoppingCartServiceTest {
	
	ShoppingCartService service1 = ShoppingCartServiceFactory.getLocalShoppingCartService();
	ShoppingCartService service2 = ShoppingCartServiceFactory.getRemoteShoppingCartService();
	
	
	Element element1 = new Element("First element", "This is the first element for a test");
	Element element2 = new Element("Second element", "This is the second element for a test");
	
	/**
     * Test the insertion of a new element in the arraylist
     */
	@Test
	public void whenANewElementThenInsertIntList (){
		//Local service
		service1.insertANewElement(element1, 2);
		
		//Remote service
		service2.insertANewElement(element2, 3);
	}
	
	/**
     * Test show the eements and the quantyties of the arraylist of shopping cart
     */
	@Test
	public void whenItIsRequiredThenShowList () {
		//Local service
		//service1.showList();
		
		//Remote service
		//service1.showList();
		
	}
	
	/**
     * Test to remove only one element of the arraylist of shopping cart
     */
	@Test
	public void whenRemoveAnElementThenRemoveElementFromList () {
		//Local service
		service1.insertANewElement(element1, 2);
		service1.removeElement(0);
		
		//Remote service
		service2.insertANewElement(element2, 3);
		service2.removeElement(0);
	}
	
	/**
     * Test to remove all elements of the arraylist of shopping cart
     */
	@Test
	public void whenRemoveAllElementsThenRemoveAllElementsfromList () {
		//Local service
		service1.insertANewElement(element1, 2);
		service1.insertANewElement(element2, 3);
		service1.removeAll();
		
		//Remote service
		service2.insertANewElement(element1, 2);
		service2.insertANewElement(element2, 3);
		service2.removeAll();
	}

}
