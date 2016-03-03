package topic3EJ1AND2;

/**
 *Class ShoppingCartServiceFactory corresponding to the Topic 3 of Java bootcamp
 *It is used to show the client the only thing that they have to use of the service
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */

public class ShoppingCartServiceFactory {
	
	/**
     * Constructor of the class
     */
	private ShoppingCartServiceFactory (){}
	
	/**
     * Method that return a new local service
     */
	public static ShoppingCartService getLocalShoppingCartService () {
		return new ShoppingCartServiceImp();
	}
	
	/**
     * Method that return a new remote service
     */
	public static ShoppingCartService getRemoteShoppingCartService (){
		return new ShoppingCartServiceProxy (new ShoppingCartServiceCommunicationClient());
	}

}
