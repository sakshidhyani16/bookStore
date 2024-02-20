package com.backend.bookStore.authentication;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.bookStore.exception.ResourceNotFoundException;
import com.backend.bookStore.model.Admin;
import com.backend.bookStore.model.User;
import com.backend.bookStore.repository.AdminRepository;
import com.backend.bookStore.repository.UserRepository;



@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
		Admin getAdmin =adminRepository.findByEmail(username);
		User getUser = userRepository.findByMobileNumber(username);
		
		
		Admin admin = null;
		User user = null ;
		
		if(getAdmin!=null) {  // admin will signin via email
			admin = this.adminRepository.findByEmailAndActive(username, (byte) 1)
					.orElseThrow(() -> new ResourceNotFoundException("user", "email", "username"));
			
			return admin;

		}

		else if(getUser!=null)  //user will signin via mobile number
			user = this.userRepository.findByMobileNumberAndActive(username, (byte) 1)
			.orElseThrow(() -> new ResourceNotFoundException("user", "phoneNumber", "username"));

		return user;

	}

	
	
}
