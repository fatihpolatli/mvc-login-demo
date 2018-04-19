package com.mvc.login.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mvc.login.dto.UserDto;
import com.mvc.login.entity.User;
import com.mvc.login.repository.UserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository repository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) 
      throws Exception {
         
        if (emailExist(accountDto.getEmail())) {   
            throw new Exception(
              "There is an account with that email address:  "+ accountDto.getEmail());
        }
        User user = new User();    
        user.setUsername(accountDto.getFirstName());
       // user.setLastName(accountDto.getLastName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        //user.setRoles(Arrays.asList("ROLE_ADMN"));
        return repository.save(user);       
    }

	private boolean emailExist(String email) {
		User user = repository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public User findByUserName(String username) {
		
		return repository.findByUsername(username);
	}
}