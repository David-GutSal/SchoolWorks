package com.practicaf.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import org.jasypt.util.password.StrongPasswordEncryptor;

import com.practicaf.model.auth.AuthModel;
import com.practicaf.model.auth.IAuthModel;
import com.practicaf.model.dto.UserLogInDto;
import com.practicaf.model.dto.UserSignInDto;

public class AuthController implements IAuthController{
	private StrongPasswordEncryptor passwordEncryptor;
	private IAuthModel authModel;
	
	public AuthController() throws ClassNotFoundException, SQLException, IOException {
		this.authModel = new AuthModel();
		this.passwordEncryptor = new StrongPasswordEncryptor();
	}
	
	public boolean register(UserSignInDto signInUser) {
		String encrypted = this.passwordEncryptor.encryptPassword(signInUser.getPassword());
		String code = UUID.nameUUIDFromBytes(signInUser.getName().getBytes()).toString();
		
		signInUser.setPassword(encrypted);
		signInUser.setUuid(code);
		
		boolean result = this.authModel.register(signInUser);
		
		return result;
	}
	
	public boolean login(UserLogInDto logInUser) {
		
		UserLogInDto userDb = this.authModel.byName(logInUser.getName());
		
		if(userDb == null) {
			return false;
		}
		
		boolean result = this.passwordEncryptor.checkPassword(logInUser.getPassword(), userDb.getPassword());
		
		return result;
	}
}
