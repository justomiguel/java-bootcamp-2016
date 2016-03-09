package topic3EJ1AND2;

/**
 *Class ShoppingCartServiceCommunicationClient corresponding to the Topic 3 of Java bootcamp
 *It is used to get a communication mechanism between the client and the service
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
public class ShoppingCartServiceCommunicationClient implements ShoppingCartService {

	ShoppingCartService communication;
	
	 /**
     * Constructor of the class
     */
	public ShoppingCartServiceCommunicationClient (){
		communication = new ShoppingCartServiceImp ();
	}
	
	/**
     * Method that insert a new element into the arraylist
     * @param element type Element. It contains the element object
     * @param quantity type integer. It contains the quantity of elements that the client select
     */
	@Override
	public void insertANewElement(Element element, int quantity) {
		// TODO Auto-generated method stub
		communication.insertANewElement(element, quantity);
	}

	/**
     * method to show the arraylist of elements
     */
	@Override
	public void showList() {
		// TODO Auto-generated method stub
		communication.showList();
	}

	/**
     * Method to be implemented later. It insert a new element into the arraylist
     * @param index type integer. It is used to get the number of element into the arraylist
     */
	@Override
	public void removeElement(int index) {
		// TODO Auto-generated method stub
		communication.removeElement(index);
	}

	/**
     * Method to remove all elements from arraylist
     */
	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		communication.removeAll();
	}

}
