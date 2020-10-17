package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Update extends JPanel{
	private JTextField txtBuscarId;
	private JTextField textField;
	
	public Update() {
		setLayout(null);
		
		JLabel lblBuscarID = new JLabel("Buscar por ID");
		lblBuscarID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscarID.setBounds(46, 50, 105, 27);
		add(lblBuscarID);
		
		txtBuscarId = new JTextField();
		txtBuscarId.setBounds(161, 50, 55, 25);
		add(txtBuscarId);
		txtBuscarId.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(161, 139, 267, 27);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Output");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(46, 102, 94, 27);
		add(lblNewLabel);
		
		JButton btnBuscarId = new JButton("Buscar");
		btnBuscarId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscarId.setBounds(226, 50, 85, 26);
		add(btnBuscarId);
		
		JLabel lblNewLabel_1 = new JLabel("Novo\r Nome");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(35, 146, 105, 27);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(161, 102, 261, 22);
		add(lblNewLabel_2);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAtualizar.setBounds(46, 219, 121, 27);
		add(btnAtualizar);
		
	}
}
