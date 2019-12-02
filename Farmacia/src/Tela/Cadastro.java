package Tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Usuario;
import Repositorio.RepositorioMedicamento;
import Repositorio.RepositorioUsuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField IntIdade;
	

	private Usuario usu= new Usuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(10, 79, 290, 28);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 54, 64, 28);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 118, 48, 14);
		contentPane.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(10, 135, 290, 28);
		contentPane.add(textCPF);
		textCPF.setColumns(10);

		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal obj = new Principal();
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnVoltar.setBounds(10, 267, 89, 23);
		contentPane.add(btnVoltar);
	
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					int CPFNull=0;
					int nomeNull=0;
					int idade = Integer.parseInt(IntIdade.getText());
					String CPF = textCPF.getText();
					String auxNull ="";
				
				
					if(textCPF.getText().equals(auxNull)) {
						CPFNull=1;
					}
					 if(textNome.getText().equals(auxNull)) {
						nomeNull=1;
					}
					if(CPFNull==0) {
						if(nomeNull==0) {
							if(RepositorioUsuario.buscar(CPF)!=true) {
								if(RepositorioUsuario.addUsuario(usu,idade)==true) {
									JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso!");
									usu.setNome(textNome.getText());
									usu.setCpf(textCPF.getText());
									usu.setIdade(idade);
									dispose();
									Cadastro obj3 = new Cadastro();
									obj3.setVisible(true);	
									dispose();
								}
								else {
									JOptionPane.showMessageDialog(null, "Usuario precisa ter no minimo 18 anos!");
								}	
							}
							else {
								JOptionPane.showMessageDialog(null, "Esse CPF já estar Cadastrado!");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "O nome não pode ficar em branco!");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Digite um CPF!");
					}
				}
				catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos e em Idade digite apenas número!");
				}
			}
		});
		btnNewButton.setBounds(178, 267, 98, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(10, 174, 48, 14);
		contentPane.add(lblIdade);
		
		IntIdade = new JTextField();
		IntIdade.setBounds(10, 199, 48, 28);
		contentPane.add(IntIdade);
		IntIdade.setColumns(10);
	}
}
