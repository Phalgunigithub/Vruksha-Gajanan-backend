package com.app.service;

import java.util.List;
import com.app.dto.UserDto;

public interface UserService {
	
	//create
	UserDto addNewUser(UserDto udto);

	//getall
	List<UserDto> getAllUsers();


}
