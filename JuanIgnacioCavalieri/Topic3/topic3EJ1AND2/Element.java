package topic3EJ1AND2;

/**
 *Class Element corresponding to the Topic 3 of Java bootcamp
 *It is used to create an Element object that will be used on the service
 *@author Juan Ignacio Cavalieri
 *@version 2016
 */
public class Element {
	
	String name;
	String description;
	
	 /**
     * Constructor of the class
     */
	Element (String name, String description){
		setName (name);
		setDescription (description);
	}

	/**
     * Method to set the  name of the object
     * @param name2 type String. It contains the name of the object
     */
	private void setName(String name2) {
		// TODO Auto-generated method stub
		this.name = name2;
	}
	
	/**
     * Method to set the  description of the object
     * @param description2 type String. It contains the description of the object
     */
	private void setDescription(String description2) {
		// TODO Auto-generated method stub
		this.description = description2;
		
	}
	
	/**
     * Method to get the  name of the object
     */
	public String getName (){
		return this.name;
	}
	
	/**
     * Method to get the  description of the object
     */
	public String getDescription () {
		return this.description;
	}
}
