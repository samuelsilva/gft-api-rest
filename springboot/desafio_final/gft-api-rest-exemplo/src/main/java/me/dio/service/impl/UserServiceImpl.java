package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.*;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
			throw new IllegalArgumentException("This User ID already exists;");
		}
		// TODO Auto-generated method stub
		return this.userRepository.save(userToCreate);
	}

}
