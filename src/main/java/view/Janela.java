package view;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class Janela {


	public static void main(String[] args) throws SQLException {

		JFrame frame = new JFrame("CRUD Básico");
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabbedPane.setBounds(0, 0, 586, 363);
		
		//inserir a tab no frame
		frame.getContentPane().add(tabbedPane);

		Create inserir = new Create();
		tabbedPane.addTab("Inserir", null, inserir, null);


 		Read listar = new Read();
		tabbedPane.addTab("Listar", null, listar, null);


		Update atualizar = new Update();
		tabbedPane.addTab("Atualizar", null, atualizar, null);

		Delete deletar = new Delete();
		tabbedPane.addTab("Deletar", null, deletar, null);

	}
	
}



