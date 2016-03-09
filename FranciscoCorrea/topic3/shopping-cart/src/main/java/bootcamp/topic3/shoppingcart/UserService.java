package bootcamp.topic3.shoppingcart;

import java.util.List;

/**
 * Service for CRUD operations of a User
 * @author cactus
 * @version 0.1
 *
 */
public interface UserService {
	
	/**
	 * Insert an user in the database
	 * @param user
	 * @return boolean
	 */
	public boolean insert(User user);
	
	/**
	 * Update an existing user in the database
	 * @param updated 
	 * @return
	 */
	public boolean update(User updated);
	
	/**
	 * Delete a user in the database
	 * @param user (User Class)
	 * @return boolean
	 */
	public boolean delete(User user);
	
	/**
	 * Find all the users on the database
	 * @return List<User>
	 */
	public List<User> select();
	
	/**
	 * Find an user filtering by ID
	 * @param id
	 * @return User
	 */
	public User findById(int id);
}
