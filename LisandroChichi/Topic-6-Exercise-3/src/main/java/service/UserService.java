package service;

import java.util.List;

import entity.User;

public interface UserService {

    User findByNickName(String nickName);
    
    List<User> findByName(String name);
     
    void add(User user);
 
    void update(User user);
 
    void delete(String nickName);

	boolean isUserExist(User user);
}
