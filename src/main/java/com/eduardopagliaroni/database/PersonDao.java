package com.eduardopagliaroni.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public void delete(int id) throws SQLException {
		Statement stat = con.createStatement();
		stat.executeUpdate("delete from person where person.id = " + id);
		stat.close();

	}
	
	public void update(Person p, int id) throws SQLException {
		Statement stat = con.createStatement();
		stat.executeUpdate("update person set name = '" + p.getName() + "', id = " + p.getId() + " where person.id = " + id);
		stat.close();
	}

	public List<Person> getAll() throws SQLException {
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select * from person");

		List<Person> pessoas = new ArrayList<Person>();

		while (rs.next()) {
			Person p = new Person();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			pessoas.add(p);
		}

		return pessoas;
	}

	public Person getById(int id) throws SQLException {
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery("select * from person where person.id = " + id);

		if (rs.next()) {
			Person p = new Person();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			return p;
		} else {
			return null;
		}

	}

}
