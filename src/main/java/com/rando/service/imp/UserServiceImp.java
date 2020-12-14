package com.rando.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rando.dao.UserRepository;
import com.rando.modele.User;
import com.rando.service.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository userRepository;
	
	//check si un user existe
	@Override
	public boolean checkUser(User inputUser) {
		User userToCheck = userRepository.checkUserExist(inputUser.getNomUser());
		
		if(userToCheck != null && userToCheck.getPassUser().equals(inputUser.getPassUser())) {
			return true;
		}else {
			return false;
		}
	}
	
}
