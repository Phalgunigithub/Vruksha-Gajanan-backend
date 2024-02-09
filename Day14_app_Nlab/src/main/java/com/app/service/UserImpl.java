package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.dto.UserDto;
import com.app.entities.User;

@Service
@Transactional
public class UserImpl implements UserService {
	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private ModelMapper mm;

	@Override
	public UserDto addNewUser(UserDto udto) {
		
			// validate confirm password
			if (udto.getPassword().equals(udto.getConfirmPassword())) {
				User u1 = mm.map(udto, User.class);
				User saveduser = udao.save(u1);
				System.out.println("user entity id " + u1.getId() + " " + saveduser.getId());
				return mm.map(saveduser, UserDto.class);			
			}
			throw new ApiException("Passwords don't match");

		}

	@Override
	public List<UserDto> getAllUsers() {
		return udao.findAll()
				.stream()
				.map((s)->mm.map(s,UserDto.class))
				.collect(Collectors.toList());

	}
	}


