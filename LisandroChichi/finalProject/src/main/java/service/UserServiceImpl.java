package service;

import java.util.List;

import repository.UserRepository;
import entity.User;

public class UserServiceImpl implements UserService{

	UserRepository userDao;
	
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userDao.findAll();
	}




	@Override
	public void addUser(User user) {
		userDao.save(user);
		
	}




	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
		
	}




	@Override
	public User getUserById(long id) {
		return userDao.findOne( (int) id);
	}




	@Override
	public void updateUser(User newUser,long id) {
		User user = userDao.findOne((int) id);
		user.setName(newUser.getName());
		user.setPassword(newUser.getPassword());
		
	}

}
