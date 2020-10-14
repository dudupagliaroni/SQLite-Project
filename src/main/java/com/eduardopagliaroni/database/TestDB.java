package com.eduardopagliaroni.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDB {
	
	static Connection con = null;

	public static void main(String[] args) throws IOException {

		try {
			
			con = Database.getInstance().getConnection();

			java.sql.Statement statement = con.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			
//			String sql = FileUtils.loadTextFile("/res/descricao.sql");
//			
//			statement.executeUpdate(sql)("");
//			
//			System.out.println(sql);
			
			
			Person p = new Person();
			p.setId(3);
			p.setName("Leonardo");
			
			PersonDao dao = new PersonDao();
			dao.insert(p);
			
			ResultSet rs = statement.executeQuery("select * from person");
			while (rs.next()) {
				// read the result set
				System.out.println("name = " + rs.getString("name"));
				System.out.println("id = " + rs.getInt("id"));
			}
		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e.getMessage());
			}
		}
	}

}
