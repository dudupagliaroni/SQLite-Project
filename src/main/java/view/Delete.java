package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Delete extends JPanel{

	private JTextField txtBuscarId;
	private JTextField textField;
	
	public Delete() {
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
		textField.setBounds(46, 139, 256, 27);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Output");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(46, 109, 105, 20);
		add(lblNewLabel);
		
		JButton btnBuscarId = new JButton("Buscar");
		btnBuscarId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscarId.setBounds(226, 50, 85, 26);
		add(btnBuscarId);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeletar.setBounds(46, 184, 105, 27);
		add(btnDeletar);
		
	}
	
}
