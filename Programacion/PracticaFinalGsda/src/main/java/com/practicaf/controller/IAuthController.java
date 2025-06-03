package com.practicaf.controller;

import com.practicaf.model.dto.UserLogInDto;
import com.practicaf.model.dto.UserSignInDto;


public interface IAuthController {


	boolean register(UserSignInDto user);

	boolean login(UserLogInDto logInUser);

}
