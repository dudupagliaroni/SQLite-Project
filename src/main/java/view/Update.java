package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.eduardopagliaroni.database.Person;
import com.eduardopagliaroni.database.PersonDao;

public class Update extends JPanel {
	private JTextField txtBuscarId;
	private JTextField txtNovoNome;
	private JLabel lblRetornoNome;
	private JButton btnBuscarId;
	static int id;

	public Update() {
		setLayout(null);

		JLabel lblBuscarID = new JLabel("Buscar por ID");
		lblBuscarID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscarID.setBounds(46, 38, 105, 27);
		add(lblBuscarID);

		txtBuscarId = new JTextField();
		txtBuscarId.setBounds(161, 39, 55, 25);
		add(txtBuscarId);
		txtBuscarId.setColumns(10);

		txtNovoNome = new JTextField();
		txtNovoNome.setBounds(161, 170, 267, 27);
		add(txtNovoNome);
		txtNovoNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Output");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(46, 103, 94, 27);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Novo\r Nome");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(46, 168, 105, 27);
		add(lblNewLabel_1);

		lblRetornoNome = new JLabel("Nome");
		lblRetornoNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRetornoNome.setBounds(161, 105, 261, 22);
		add(lblRetornoNome);
		
		JButton btnBuscarId = new JButton("Buscar");
		btnBuscarId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscarId.setBounds(226, 38, 85, 26);
		add(btnBuscarId);
		btnBuscarId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = Integer.parseInt(txtBuscarId.getText());
				PersonDao pDao = new PersonDao();
				try {
					Person p = pDao.getById(id);
					lblRetornoNome.setText(p.getName());

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PersonDao pDao = new PersonDao();
				id = Integer.parseInt(txtBuscarId.getText());
				String novoNome = txtNovoNome.getText();
				Person p = new Person(id, novoNome);
				try {
					pDao.update(p, id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtualizar.setBounds(46, 233, 121, 27);
		add(btnAtualizar);



	}
}
