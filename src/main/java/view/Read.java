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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		scrollPane.setBounds(100, 30, 400, 220);
		add(scrollPane);
		
		table = new JTable(modelo);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar(modelo);
			}
		});
		
		btnAtualizar.setBounds(238, 260, 123, 29);
		add(btnAtualizar);
		
		modelo.addColumn("Id");
		modelo.addColumn("Name");
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(360);
		
		pesquisar(modelo);
		


		

		

		
		
		
		
		
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
