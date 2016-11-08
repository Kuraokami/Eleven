package com.eleven.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.eleven.general.Config;

public class Conexion {

	private static Connection connection;
	private static String driver = Config.db_driver;
	private static String url = Config.db_url;
	private static String user = Config.db_user;
	private static String password = Config.db_pass;

	private Conexion() {
	}

	public static Connection getConexion() {
		if (connection == null) {

			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}

}
