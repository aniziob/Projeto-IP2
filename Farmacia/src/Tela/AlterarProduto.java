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

public class AlterarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textProduto;
	private JTextField textQuant;
	private JTextField textPreç;
	static private RepositorioMedicamento rep = new RepositorioMedicamento();
	private Medicamento rep2 = new Medicamento();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarProduto frame = new AlterarProduto();
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
	public AlterarProduto() {
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do Produto");
		lblNomeDoProduto.setBounds(30, 87, 103, 21);
		contentPane.add(lblNomeDoProduto);
		
		textProduto = new JTextField();
		textProduto.setBounds(30, 119, 204, 21);
		contentPane.add(textProduto);
		textProduto.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(30, 161, 74, 14);
		contentPane.add(lblQuantidade);
		
		textQuant = new JTextField();
		textQuant.setBounds(30, 177, 57, 31);
		contentPane.add(textQuant);
		textQuant.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(30, 228, 57, 21);
		contentPane.add(lblPreo);
		
		textPreç = new JTextField();
		textPreç.setBounds(30, 247, 57, 31);
		contentPane.add(textPreç);
		textPreç.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alterar obj = new Alterar();
				obj.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(15, 310, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				int ID = RepositorioMedicamento.repMed.size();//Integer.parseInt(textID.getText());
				int Quant = Integer.parseInt(textQuant.getText());
				float Preç = Float.parseFloat(textPreç.getText());
				int index = rep2.getIndex();
				int aux=0;
				String produto = textProduto.getText();
				String verificarNull="";
			
				if(verificarNull.equals(produto)) {
					aux=1;
				}
				
				if(Quant >0 && Preç>0 && aux ==0) {
					RepositorioMedicamento.repMed.remove(index);
					Cadastrar(textProduto.getText(),ID,Quant,Preç);
					JOptionPane.showMessageDialog(null,"Produto Alterado com sucesso!");
				
					AlterarProduto obj3 = new AlterarProduto();
					obj3.setVisible(true);	
					dispose();
				}
				else {
					if(Quant<=0) {
						JOptionPane.showMessageDialog(null,"Tem que ter ao menos uma quantidade de produto!");
					}
					else if(Preç <= 0) {
						JOptionPane.showMessageDialog(null,"O preço do produto não pode ser 0,00 !");
					}
					
					else {
						JOptionPane.showMessageDialog(null,"O nome do produto não pode ficar em branco!");
					}
				}
			}
			catch(NumberFormatException exception) {
				JOptionPane.showMessageDialog(null,"Preencha todos os campos e Preço/Quantidade só digite apenas números!");
			}
			}
		
		});
		btnAlterar.setBounds(199, 310, 89, 23);
		contentPane.add(btnAlterar);
	}
	public void Cadastrar(String nome, int ID, int Quant, float Preç ) {
		
		Medicamento a1 = new Medicamento(ID,nome,Quant,Preç,"");
		rep.addMedicamento(a1);
	}
}