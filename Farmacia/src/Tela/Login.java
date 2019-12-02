package Tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.Medicamento;
import Repositorio.RepositorioMedicamento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JTextField textSenha;
	private JButton btnFinalizar;
	static private RepositorioMedicamento rep = new RepositorioMedicamento();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("MyPharma");
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(122, 40, 101, 29);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(122, 116, 48, 14);
		contentPane.add(lblSenha);
		
		textLogin = new JTextField();
		textLogin.setBounds(122, 80, 167, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		textSenha = new JTextField();
		textSenha.setBounds(122, 141, 167, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textLogin.getText().equals("adm")&&textSenha.getText().equals("123456")) {
					
					Medicamento a1 = new Medicamento(0,"Dipirona",6,(float) 4.65,"");
					rep.addMedicamento(a1);
					Medicamento a2 = new Medicamento(1,"Suprin",12,(float) 14.95,"");
					rep.addMedicamento(a2);
					Medicamento a3 = new Medicamento(2,"Platin",21,(float) 19.23,"");
					rep.addMedicamento(a3);
					Medicamento a4 = new Medicamento(3,"Ecos",4,(float) 16.03,"");
					rep.addMedicamento(a4);
					Medicamento a5 = new Medicamento(4,"Fraldas M",33,(float) 95.09,"");
					rep.addMedicamento(a5);
					Medicamento a6 = new Medicamento(5,"Fraldas G",48,(float) 112.84,"");
					rep.addMedicamento(a6);
					JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema!");
					Principal obj = new Principal();
					obj.setVisible(true);	
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Acesso Negado!");
					Login obj = new Login();
					obj.setVisible(true);	
					dispose();
				}
			}
		});
		btnEntrar.setBounds(211, 200, 89, 23);
		contentPane.add(btnEntrar);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setToolTipText("");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login obj = new Login();
				obj.setVisible(false);	
				dispose();
			}
		});
		btnFinalizar.setBounds(108, 200, 89, 23);
		contentPane.add(btnFinalizar);
	}
}
