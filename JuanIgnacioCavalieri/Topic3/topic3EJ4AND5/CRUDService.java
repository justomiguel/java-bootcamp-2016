package topic3EJ4AND5;

/**
 *Class CRUDService corresponding to the Topic 3 of Java bootcamp
 *It is used to set an interface for the service
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
public interface CRUDService {
	
	/**
     * Abstract method to insert values in database
     */
	public void connect(String URL, String User, String Pass);

	/**
     * Abstract method to insert values in database
     */
	public void insert (Element newElement);
	
	/**
     * Abstract method to update values in database
     */
	public void update (int index, String name, String description);
	
	/**
     * Abstract method to delete values in database
     */
	public void delete (int index);
	
	/**
     * Abstract method to select all values in database
     */
	public void select ();
}
