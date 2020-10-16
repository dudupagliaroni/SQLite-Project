package view;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;

import com.eduardopagliaroni.database.Person;
import com.eduardopagliaroni.database.PersonDao;

public class Listar extends JPanel {
	public Listar() throws SQLException {
		setLayout(null);
		this.setSize(600,400);
		
		JList list = new JList();
		list.setBounds(100, 30, 400, 250);
		add(list);
		
		PersonDao dao = new PersonDao();
		List<Person> pessoas = new ArrayList<Person>();
		pessoas = dao.getAll();
		
		for (Component i : pessoas) {
			list.add(i);
		}
		
		
		
		
		
	}
}
