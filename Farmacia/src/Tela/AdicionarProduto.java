package Tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Repositorio.RepositorioMedicamento;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textQuant;
	private static RepositorioMedicamento r = new RepositorioMedicamento();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarProduto frame = new AdicionarProduto();
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
	public AdicionarProduto() {
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(32, 111, 161, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textQuant = new JTextField();
		textQuant.setBounds(242, 111, 37, 20);
		contentPane.add(textQuant);
		textQuant.setColumns(10);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do Produto");
		lblNomeDoProduto.setBounds(32, 80, 102, 20);
		contentPane.add(lblNomeDoProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(233, 80, 74, 20);
		contentPane.add(lblQuantidade);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal obj = new Principal();
				obj.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(25, 228, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int Quant = Integer.parseInt((textQuant.getText()));
					String nome = textNome.getText();
					int IndexBus = RepositorioMedicamento.buscar(nome);
					if(IndexBus!=-1){
						if(Quant>0) {
							RepositorioMedicamento.repMed.get(IndexBus).setQuantidade1(Quant);
							JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
						}
						else
							JOptionPane.showMessageDialog(null, "Quatidade tem que ser maior que 0!");
					}
					else
					JOptionPane.showMessageDialog(null, "Esse produto não existe!");
				}
				catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Não pode deixar os campos em branco e digite apenas números para quantade !");
				}
				}
		});
		btnAdicionar.setBounds(233, 228, 89, 23);
		contentPane.add(btnAdicionar);
	}
}
