package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.eduardopagliaroni.database.Person;
import com.eduardopagliaroni.database.PersonDao;

public class Create extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtId;
	private JTextField txtNome;
	private DefaultTableModel modelo = new DefaultTableModel();

	public Create() {

		this.setLayout(null);
		this.setSize(400,250);
		this.setVisible(true);

		JLabel lbl_ld = new JLabel("Id");
		lbl_ld.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_ld.setBounds(66, 40, 28, 26);
		this.add(lbl_ld);

		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setBounds(147, 40, 45, 26);
		this.add(txtId);
		txtId.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(66, 106, 45, 26);
		this.add(lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setBounds(147, 106, 212, 26);
		this.add(txtNome);
		txtNome.setColumns(10);

		JButton btnAdd = new JButton("Adicionar");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = Integer.parseInt(txtId.getText());
				String nome = txtNome.getText();
				Person p = new Person(id, nome);
				PersonDao pDao = new PersonDao();
				try {
					pDao.insert(p);
					txtId.setText("");
					txtNome.setText("");
					Read.pesquisar(modelo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 

			}
		});

		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(66, 172, 113, 36);
		this.add(btnAdd);

	}
}
