package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class Janela {


	public static void main(String[] args) {

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

		Inserir inserir = new Inserir();
		tabbedPane.addTab("Inserir", null, inserir, null);


 		Listar listar = new Listar();
		tabbedPane.addTab("Listar", null, listar, null);


		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Atualizar", null, panel_2, null);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Deletar", null, panel_3, null);

	}
	
}



