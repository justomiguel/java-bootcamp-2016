package topic3EJ4AND5;

/**
 *Class CRUDServiceCommunication corresponding to the Topic 3 of Java bootcamp
 *It is used to get a communication mechanism between the client and the service
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
public class CRUDServiceCommunication implements CRUDService{

	CRUDService imp = new CRUDServiceImp ();

	/**
     * Method to connect database
     * @param URL Type String. It is used to set the URL of the connection to the database
     * @param User type String. It is used to set the User of the connection to the database
     * @param Pass type String. It is used to set the Password of the connection to the database
     */
	@Override
	public void connect(String URL, String User, String Pass) {
		// TODO Auto-generated method stub
		imp.connect(URL, User, Pass);;
	}

	/**
     * Method to insert values in database
     * @param newElement type Element. It is used to insert into the list
     */
	@Override
	public void insert(Element newElement) {
		// TODO Auto-generated method stub
		imp.insert(newElement);
	}

	/**
     * Method to update values in database
     * @param index type integer. It is used to get the specyfic element into the array
     * @param name type String. It is used to update the name attribute of the element
     * @param description type String. It is used to update the description attribute of the element
     */
	@Override
	public void update(int index, String name, String description) {
		// TODO Auto-generated method stub
		imp.update(index, name, description);
	}

	/**
     * Method to delete values in database
     * @param index Type integer. It is used to get an specyfic element into the array
     */
	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		imp.delete(index);
	}

	/**
     * Method to select values in database
     */
	@Override
	public void select() {
		// TODO Auto-generated method stub
		imp.select();
	}
	
	
}
