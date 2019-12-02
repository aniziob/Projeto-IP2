package Tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exceptions.UsuarioNaoExisteException;
import Main.Usuario;
import Repositorio.RepositorioUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textIdade;
	private JTextField textCPF;
	private Usuario usu= new Usuario();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarUsuario frame = new AlterarUsuario();
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
	public AlterarUsuario() {
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 44, 64, 23);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(10, 78, 256, 31);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Idade");
		lblNewLabel_1.setBounds(10, 187, 64, 23);
		contentPane.add(lblNewLabel_1);
		
		textIdade = new JTextField();
		textIdade.setBounds(10, 221, 64, 31);
		contentPane.add(textIdade);
		textIdade.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int CPFNull=0;
					int nomeNull=0;
					int aux = Integer.parseInt(textIdade.getText());
					String auxNull ="";
				
				
					if(textCPF.getText().equals(auxNull)) {
						CPFNull=1;
					}
					if(textNome.getText().equals(auxNull)) {
						nomeNull=1;
					}
					if(CPFNull==0) {
						if(nomeNull==0) {
							if(RepositorioUsuario.addUsuario(usu,aux)==true) {
								int index =usu.getIndex();
								RepositorioUsuario.nomes.remove(index);
								JOptionPane.showMessageDialog(null, "Usuario Alterado com Sucesso!");
								usu.setNome(textNome.getText());
								usu.setCpf(textCPF.getText());
								usu.setIdade(aux);
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
							JOptionPane.showMessageDialog(null, "O nome não pode ficar em branco!");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Digite um CPF!");
					}
				}
				catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos e em Idade digite apenas números!");
				}	
			}
		});
		btnNewButton_1.setBounds(194, 303, 94, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alterar obj = new Alterar();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 303, 94, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 123, 48, 14);
		contentPane.add(lblCpf);
		
		textCPF = new JTextField();
		textCPF.setBounds(8, 146, 258, 31);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
	}
}