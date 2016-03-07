package bootcamp.topic3.shoppingcart;

public class FakeUserDAO implements UserDAO{

	public FakeUserDAO() {
	}

	@Override
	public boolean insert(User user) {
		System.out.println("User inserted");
		return true;
	}

	@Override
	public boolean delete(User user) {
		System.out.println("User deleted");
		return true;
	}

	@Override
	public boolean update(User user) {
		System.out.println("User updated");
		return true;
	}
	
	@Override
	public User find(int id) {
		return (new User("pepe", "pepe123"));
	}
}

