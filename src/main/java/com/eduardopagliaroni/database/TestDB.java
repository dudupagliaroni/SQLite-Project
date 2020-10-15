package com.eduardopagliaroni.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestDB {

	static Connection con = null;

	public static void main(String[] args) throws SQLException {

		Person p3 = new Person();
		p3.setId(1);
		p3.setName("Eduardo");
//
//		Person p2 = new Person();
//		p2.setId(2);
//		p2.setName("Lila");

		PersonDao dao = new PersonDao();
		dao.update(p3, 2);


		List<Person> pessoas = dao.getAll();

		for (Person p1 : pessoas) {
			System.out.println(p1);
		}

	}

}
