package Tela;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Usuario;
import Repositorio.RepositorioUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Main.Carrinho;
import Main.Medicamento;
import Main.Usuario;
import Repositorio.RepositorioMedicamento;
import Repositorio.RepositorioUsuario;

public class Alterar extends JFrame {

	private JPanel contentPane;
	private JTextField textCPF;
	private JTextField textID;
	private Usuario usu= new Usuario();

	
	private Medicamento rep = new Medicamento();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alterar frame = new Alterar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Alterar() {
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Usu\u00E1rio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(RepositorioUsuario.buscar(textCPF.getText())==true) {
				usu.setIndex(RepositorioUsuario.buscarAlterar(textCPF.getText())); 
				AlterarUsuario obj = new AlterarUsuario();
				obj.setVisible(true);
				dispose();				
			}
			else { 
				JOptionPane.showMessageDialog(null,"Esse Usuário não existe!");
			}
		
		}
		});
		btnNewButton.setBounds(10, 107, 144, 60);
		contentPane.add(btnNewButton);
		
		JLabel lblOu = new JLabel("OU");
		lblOu.setBounds(195, 130, 48, 14);
		contentPane.add(lblOu);
		
		JButton btnNewButton_1 = new JButton("Produto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				int ID =Integer.parseInt(textID.getText());
				
				if(RepositorioMedicamento.buscar(ID)==true ){
					int index = RepositorioMedicamento.buscarAlterar(ID);
					rep.setIndex(index);
					AlterarProduto obj = new AlterarProduto();
					obj.setVisible(true);
					dispose();
				}
				else {
					 JOptionPane.showMessageDialog(null, "Esse produto não existe!");
				 }	
			}
			catch(NumberFormatException exeException){
				JOptionPane.showMessageDialog(null, "Esse produto não existe!");
			}
		}
		});
		btnNewButton_1.setBounds(253, 107, 144, 60);
		contentPane.add(btnNewButton_1);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF");
		lblDigiteOCpf.setBounds(10, 41, 126, 24);
		contentPane.add(lblDigiteOCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(10, 76, 144, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblDigiteOId = new JLabel("Digite o ID");
		lblDigiteOId.setBounds(347, 44, 77, 19);
		contentPane.add(lblDigiteOId);
		
		textID = new JTextField();
		textID.setBounds(349, 76, 48, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal obj = new Principal();
				obj.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(159, 227, 89, 23);
		contentPane.add(btnVoltar);
	}
}