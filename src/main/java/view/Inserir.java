package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.eduardopagliaroni.database.Person;
import com.eduardopagliaroni.database.PersonDao;

public class Inserir extends JPanel {

	private JTextField txtId;
	private JTextField txtNome;

	public Inserir() {

		this.setLayout(null);
		this.setSize(400,250);
		this.setVisible(true);

		JLabel lbl_ld = new JLabel("Id");
		lbl_ld.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_ld.setBounds(66, 56, 28, 20);
		this.add(lbl_ld);

		txtId = new JTextField();
		txtId.setBounds(147, 56, 45, 19);
		this.add(txtId);
		txtId.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(66, 106, 45, 13);
		this.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(147, 102, 212, 19);
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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(66, 159, 113, 36);
		this.add(btnAdd);

	}
}
