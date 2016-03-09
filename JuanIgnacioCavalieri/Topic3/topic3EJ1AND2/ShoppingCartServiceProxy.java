package topic3EJ1AND2;

/**
 *Class ShoppingCartServiceProxy corresponding to the Topic 3 of Java bootcamp
 *It is used to hide the code and don´t write it any time it is needed
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
public class ShoppingCartServiceProxy implements ShoppingCartService {
	
	ShoppingCartService implementation;
	
	/**
     * Constructor of the class
     */
	protected ShoppingCartServiceProxy (ShoppingCartService imp) {
		this.implementation = imp;
	}
	
	/**
     * Method that insert a new element into the arraylist
     * @param element type Element. It contains the element object
     * @param quantity type integer. It contains the quantity of elements that the client select
     */
	public void insertANewElement (Element element, int quantity){
		implementation.insertANewElement(element, quantity);
	}
	
	/**
     * method to show the arraylist of elements
     */
	public void showList () {
		implementation.showList();
	}
	
	/**
     * Method to be implemented later. It insert a new element into the arraylist
     * @param index type integer. It is used to get the number of element into the arraylist
     */
	public void removeElement (int index){
		implementation.removeElement  (index);
	}
	
	/**
     * Method to remove all elements from arraylist
     */
	public void removeAll () {
		implementation.removeAll();
		
	}


}
