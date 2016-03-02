package bootcamp.topic3.shoppingcart;

public class FakeUserDAO {

	public FakeUserDAO() {
	}

	public boolean insert(User user) {
		System.out.println("User inserted");
		return true;
	}

	public boolean delete(User user) {
		System.out.println("User deleted");
		return true;
	}

	public boolean update(User user) {
		System.out.println("User updated");
		return true;
	}
	
	public User find(int id) {
		return (new User("pepe", "pepe123"));
	}
}

