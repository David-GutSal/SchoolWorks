package com.practicaf.model;

import com.practicaf.model.entities.UserLogIn;
import com.practicaf.model.entities.UserSignIn;

public interface IAuthModel {

	UserLogIn byName(String name);

	boolean register(UserSignIn signInUser);

}
