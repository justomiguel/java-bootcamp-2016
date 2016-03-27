package bootcamp.finalproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import bootcamp.finalproject.entities.User;
import bootcamp.finalproject.repositories.UserRepository;

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

	    @Override
	    public UserDetails loadUserByUsername(String nickName) throws UsernameNotFoundException {
	    	User user = userRepository.findByNickName(nickName);
	        if(user != null) {
	        	return new org.springframework.security.core.userdetails.User(user.getNickName(), user.getPassword(), 
	        			true, true, true, true,
	        			AuthorityUtils.createAuthorityList("USER"));
	        } else {
	        	throw new UsernameNotFoundException("Could not find the user '" + nickName + "'");
	        }
	    }
	      
	    };
	}

}

