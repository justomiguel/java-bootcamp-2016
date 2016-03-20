package service;

import java.util.List;

import entity.User;

public interface UserService {
	public void addUser(User user);
	public void deleteUser(User user);
	public List<User> getAllUsers();
	public User getUserById(long id);
	public void updateUser(User newUser,long id);
}