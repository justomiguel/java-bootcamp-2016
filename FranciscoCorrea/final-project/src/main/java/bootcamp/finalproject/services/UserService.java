package bootcamp.finalproject.services;

import bootcamp.finalproject.entities.User;

public interface UserService {
	
	boolean isValid(User user);
	User saveUser(User user);
	void updateUser(User user);
	void deleteUser(long userId);
	User findById(long userId);
	User findByNickName(String nickName);
}