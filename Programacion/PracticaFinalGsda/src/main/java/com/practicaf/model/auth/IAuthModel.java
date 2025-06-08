package com.practicaf.model.auth;

import com.practicaf.model.dto.UserLogInDto;
import com.practicaf.model.dto.UserSignInDto;

public interface IAuthModel {

	UserLogInDto byName(String name);

	boolean register(UserSignInDto signInUser);

}
