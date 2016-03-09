package topic3EJ1AND2;

/**
 *Class ShoppingCartService corresponding to the Topic 3 of Java bootcamp
 *It is used to set the interface of the service
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */

public interface ShoppingCartService {
	
	/**
     * Abstract method to be implemented later. It insert a new element into the arraylist
     * @param element type Element. It contains the element object
     * @param quantity type integer. It contains the quantity of elements that the client select
     */
	public void insertANewElement (Element element, int quantity);
	
	/**
     * Abstract method to show the arraylist of elements
     */
	public void showList ();
	
	/**
     * Abstract method to be implemented later. It insert a new element into the arraylist
     * @param index type integer. It is used to get the number of element into the arraylist
     */
	public void removeElement (int index);
	
	/**
     * Abstract method to remove all elements from arraylist
     */
	public void removeAll () ;
	

}
