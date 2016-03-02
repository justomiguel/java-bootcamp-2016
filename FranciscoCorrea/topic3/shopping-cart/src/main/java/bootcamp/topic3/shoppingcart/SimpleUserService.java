package bootcamp.topic3.shoppingcart;

import java.util.List;

public class SimpleUserService implements UserService {

	private UserService implementation;
	
	protected SimpleUserService() {
		super();
		implementation = new UserServiceImpl();
	}
	
	@Override
	public boolean insert(User user) {
		return implementation.insert(user);
	}

	@Override
	public boolean update(User updated) {
		return implementation.update(updated);
	}

	@Override
	public boolean delete(User user) {
		return implementation.delete(user);
	}

	@Override
	public List<User> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		return implementation.findById(id);
	}
	

}
