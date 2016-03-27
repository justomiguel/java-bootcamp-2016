package bootcamp.finalproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.finalproject.entities.User;
import bootcamp.finalproject.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(long userId) {
		userRepository.delete(userId);
	}

	@Override
	public User findById(long userId) {
		return userRepository.findOne(userId);
	}

	@Override
	public User findByNickName(String nickName) {
		return userRepository.findByNickName(nickName);
	}

}
