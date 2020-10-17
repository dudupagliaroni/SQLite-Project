package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.eduardopagliaroni.database.Person;
import com.eduardopagliaroni.database.PersonDao;
import java.awt.Font;

public class Read extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();

	public Read() throws SQLException {
		setLayout(null);
		this.setSize(600,400);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(100, 30, 400, 250);
		add(scrollPane);
		
		table = new JTable(modelo);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		modelo.addColumn("Id");
		modelo.addColumn("Name");
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(360);
		
		pesquisar(modelo);
		


		
//		PersonDao dao = new PersonDao();
//		List<Person> pessoas = new ArrayList<Person>();
//		pessoas = dao.getAll();
		

		
		
		
		
		
	}
	
	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		PersonDao dao = new PersonDao();

		try {
			for (Person p : dao.getAll()) {
				modelo.addRow(new Object[]{p.getId(), p.getName()});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
