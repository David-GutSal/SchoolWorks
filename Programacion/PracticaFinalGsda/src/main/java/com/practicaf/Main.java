package com.practicaf;

import java.io.IOException;

import java.sql.SQLException;

import com.practicaf.view.Login;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Login login = new Login();
		login.run();
	}
}
