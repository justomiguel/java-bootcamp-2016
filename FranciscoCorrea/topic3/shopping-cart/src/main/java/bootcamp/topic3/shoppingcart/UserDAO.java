package bootcamp.topic3.shoppingcart;

public interface UserDAO {
	public boolean insert(User user);
	public boolean delete(User user);
	public boolean update(User user);
	public User find(int id);
}
