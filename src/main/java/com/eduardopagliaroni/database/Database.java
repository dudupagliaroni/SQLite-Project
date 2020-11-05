package com.eduardopagliaroni.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private Connection connection = null;

	private static Database INSTANCE = null;

	private Database() {

		try {
			connection = DriverManager
					.getConnection("jdbc:sqlite:src/main/java/res/sample.db");
			java.sql.Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			String sql = FileUtils.loadTextFile("src/main/java/res/descricao.sql");

			statement.executeUpdate(sql);

		} catch (Exception e) {
			System.err.println("Houve um problema ao criar o DB");
			e.printStackTrace();
		}

	}

	public static Database getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Database();
		}
		return INSTANCE;
	}

	public Connection getConnection() {
		return this.connection;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Houve um erro ao fechar a conexão");
			e.printStackTrace();
		}
	}
}
