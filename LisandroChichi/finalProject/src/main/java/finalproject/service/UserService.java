package finalproject.service;

import finalproject.entity.User;

public interface UserService {

	public void deleteUserByUsername(String username);

	public User persistUser(User user);

	public void deleteUser(long idUser);

	public User getUserById(long id);

	public User findByUsername(String username);

}