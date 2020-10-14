package com.eduardopagliaroni.database;

import java.sql.Connection;
import java.sql.SQLException;

public class PersonDao {
	private Connection con;
	public PersonDao() {
		con = Database.getInstance().getConnection();
	}
		
	public void insert(Person person) throws SQLException {
		java.sql.Statement statement = con.createStatement();
		
		statement.executeUpdate("insert into person values(" + person.getId() + ", '" + person.getName() + "')");
		
		statement.close();

		
	}

}
