package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import entity.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	private static List<User> listUsers;
	
	public User findByNickName(String nickName) {
		for (User user: listUsers){
			if (user.getNickName()==nickName){
				return user;
			}
		}
		return null;
		
	}

	public List<User> findByName(String name) {
		List<User> listByName = new ArrayList<User>();
		for(User user : listUsers){
            if(user.getName().equalsIgnoreCase(name)){
            	listByName.add(user);
            }
    		return listByName;
        }
        return null;
	}

	public void add(User user) {
		listUsers.add(user);
	}

	public void update(User user) {
		int index = listUsers.indexOf(user);
        listUsers.set(index, user);
	}

	public void delete(String nickName) {
		 for (Iterator<User> iterator = listUsers.iterator(); iterator.hasNext(); ) {
	            User user = iterator.next();
	            if (user.getNickName() == nickName) {
	                iterator.remove();
	            }
	        }
		
	}

	@Override
	public boolean isUserExist(User user) {
		return findByNickName(user.getNickName())!=null;
	}

}
