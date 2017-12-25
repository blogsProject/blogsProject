package com.lzlz.blog.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private Properties pro = new Properties();
	{
		try {
			pro.load(this.getClass().getResourceAsStream("/config.properties"));
			Class.forName(pro.getProperty("DRIVER"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(pro.getProperty("URL"), pro.getProperty("USERNAME"),
					pro.getProperty("PASSWORD"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
