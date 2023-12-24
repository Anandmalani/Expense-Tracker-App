package com.example.ExpenseTrackerApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ExpenseTrackerApp.entity.Userr;
import com.example.ExpenseTrackerApp.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class UserService {

    
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
    

//    public Userr findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }

    

//	public List<Userr> getAllUsers() {
//        return userRepository.findAll();
//    }

	public Userr saveUser(Userr user) {
//		return userRepository.save(user);
		 if (userRepository.existsByUsername(user.getUsername())) {
	            return null;
	        }

//	        Userr user = new Customer();
//	        BeanUtils.copyProperties(signupRequest,customer);

	        //Hash the password before saving
	        String hashPassword = passwordEncoder.encode(user.getPassword());
	        user.setPassword(hashPassword);
	        Userr createdCustomer = userRepository.save(user);
	        user.setId(createdCustomer.getId());
	        return user;
		
	}
//	@Transactional
//	public void deleteUser(Integer id) {
//		// TODO Auto-generated method stub
//		userRepository.deleteById(id);
//		
//	}


	public Userr getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElse(null);
//		return null;
	}


	

//	public Userr getUser(Integer id) {
//		// TODO Auto-generated method stub
//		return userRepository.findById(id).get();
//	}
//
//	public Userr updateUser(Userr u1, Integer id) {
//		// TODO Auto-generated method stub
//		u1.setId(id);
//		userRepository.save(u1);
//		
//		return u1;
//	}



	
	

    // Additional methods as needed
}

