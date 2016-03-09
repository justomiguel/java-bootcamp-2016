package topic3EJ1AND2;

import java.util.ArrayList;
import java.util.List;

import topic2EJ1.File;

/**
 *Class ShoppingCartServiceImp corresponding to the Topic 3 of Java bootcamp
 *It is used to implements the interface ShoppingCartService
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
public class ShoppingCartServiceImp implements ShoppingCartService {
	
	static List<Element> elementList = new ArrayList <Element> ();
	static List<Integer> elementQuantity = new ArrayList <Integer> (3);
	
	/**
     * Constructor of the class
     */
	protected ShoppingCartServiceImp () {}
	
	/**
     * Method that insert a new element into the arraylist
     * @param element type Element. It contains the element object
     * @param quantity type integer. It contains the quantity of elements that the client select
     */
	public void insertANewElement (Element element, int quantity){
		elementList.add(element);
		elementQuantity.add(quantity);
	}
	
	/**
     * method to show the arraylist of elements
     */
	public void showList () {
		System.out.println("Shopping Cart list");
		
		if (elementList.isEmpty()){
			// TODO: handle exception
			System.out.println("The shopping cart is empty");
			
		}else {
			for (int i = 0; i < elementList.size(); i++) {
				System.out.println ((i+1) + ")" + elementList.get(i).getName() + "(" + elementList.get(i).getDescription() + "). Quantity: " + elementQuantity.get(i));
			}
		}
		
	}
	
	/**
     * Method to be implemented later. It insert a new element into the arraylist
     * @param index type integer. It is used to get the number of element into the arraylist
     */
	public void removeElement (int index){
		elementList.remove(index);
		elementQuantity.remove(index);
	}
	
	/**
     * Method to remove all elements from arraylist
     */
	public void removeAll () {
		elementList.clear();
		elementQuantity.clear();		
	}


}
