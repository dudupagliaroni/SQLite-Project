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

public class Delete extends JPanel {

	private JTextField txtBuscarId;
	JLabel lblOutput;
	static int id;

	public Delete() {
		setLayout(null);

		JLabel lblBuscarID = new JLabel("Buscar por ID");
		lblBuscarID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscarID.setBounds(46, 56, 105, 27);
		add(lblBuscarID);

		txtBuscarId = new JTextField();
		txtBuscarId.setBounds(161, 57, 55, 25);
		add(txtBuscarId);
		txtBuscarId.setColumns(10);

		lblOutput = new JLabel("Output");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOutput.setBounds(46, 139, 105, 20);
		add(lblOutput);

		JButton btnBuscarId = new JButton("Buscar");
		btnBuscarId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = Integer.parseInt(txtBuscarId.getText());
				PersonDao pDao = new PersonDao();
				try {
					Person p = pDao.getById(id);
					lblOutput.setText(p.getName());
					

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnBuscarId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscarId.setBounds(226, 56, 85, 26);
		add(btnBuscarId);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PersonDao pDao = new PersonDao();
				try {
					pDao.delete(id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeletar.setBounds(46, 215, 105, 27);
		add(btnDeletar);

	}

}
