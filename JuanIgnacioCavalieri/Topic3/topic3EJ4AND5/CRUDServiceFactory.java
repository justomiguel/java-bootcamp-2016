package topic3EJ4AND5;

/**
 *Class CRUDServiceFactory corresponding to the Topic 3 of Java bootcamp
 *It is used to show the client the only thing that they have to use of the service
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
public class CRUDServiceFactory {

	/**
     * Constructor of the class
     */
	private CRUDServiceFactory (){}
	
	/**
     * Method that return a new local service
     */
	public static CRUDService getLocalCRUDService () {
		return new CRUDServiceImp();
	}
	
	/**
     * Method that return a new remote service
     */
	public static CRUDService getRemoteCRUDService (){
		return new CRUDServiceProxy (new CRUDServiceCommunicationClient());
	}
}
