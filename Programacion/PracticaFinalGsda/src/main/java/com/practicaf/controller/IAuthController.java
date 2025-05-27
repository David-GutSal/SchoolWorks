package com.practicaf.controller;

import com.practicaf.model.entities.UserLogIn;
import com.practicaf.model.entities.UserSignIn;


public interface IAuthController {


	boolean register(UserSignIn user);

	boolean login(UserLogIn logInUser);

}
