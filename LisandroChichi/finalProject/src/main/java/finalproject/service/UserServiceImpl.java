package finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import finalproject.entity.User;
import finalproject.repository.UserRepository;

@Component 
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public User persistUser(User user) {
		return userRepository.save(user);
		
	}




	@Override
	public void deleteUser(long idUser) {
		userRepository.delete(idUser);
		
	}




	@Override
	public User getUserById(long id) {
		return userRepository.findOne( id);
	}
	
	@Override
	public User findByUsername(String username) {
		
		
		return userRepository.getUserByUsername(username);
	}




	@Override
	public void deleteUserByUsername(String username) {
		userRepository.delete(findByUsername(username));
		
	}



}
