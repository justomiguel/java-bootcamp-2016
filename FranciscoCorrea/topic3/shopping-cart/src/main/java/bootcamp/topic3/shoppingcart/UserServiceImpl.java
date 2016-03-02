package bootcamp.topic3.shoppingcart;

import java.util.List;

public class UserServiceImpl implements UserService{

	private FakeUserDAO dao;
	
	protected UserServiceImpl() {
		this.dao = new FakeUserDAO();
	}
	
	@Override
	public boolean insert(User user) {
		return dao.insert(user);
	}

	@Override
	public boolean update(User updatedUser) {
		return dao.update(updatedUser);
	}

	@Override
	public boolean delete(User user) {
		return dao.delete(user);
	}

	@Override
	public List<User> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		return dao.find(id);
	}
	

}
