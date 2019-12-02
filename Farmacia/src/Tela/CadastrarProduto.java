package Tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.AtualizarLista;
import Main.Medicamento;
import Repositorio.RepositorioMedicamento;
import Repositorio.RepositorioUsuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textProduto;
	
	static private RepositorioMedicamento rep = new RepositorioMedicamento();
	
	private JTextField textQuant;
	private JTextField textPreç;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarProduto frame = new CadastrarProduto();
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
	public CadastrarProduto() {
		setTitle("MyPharma");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textProduto = new JTextField();
		textProduto.setBounds(46, 110, 224, 20);
		contentPane.add(textProduto);
		textProduto.setColumns(10);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do produto");
		lblNomeDoProduto.setBounds(46, 87, 119, 14);
		contentPane.add(lblNomeDoProduto);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal obj = new Principal();
				obj.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 299, 89, 23);
		contentPane.add(btnVoltar);
	
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					//Fazer uma validação de nomes antes de cadastrar o produto
					int ID = RepositorioMedicamento.repMed.size();//Integer.parseInt(textID.getText());
					int Quant = Integer.parseInt(textQuant.getText());
					double Preç = Double.parseDouble(textPreç.getText());
					int auxNull=0;
					String produto = textProduto.getText();
					String verificarNull="";
				
					if(verificarNull.equals(produto)) {
						auxNull=1;
					}
					boolean busca = RepositorioMedicamento.Verificar(produto);
					if(busca!=true) {
						if(Quant >0 && Preç>0 && auxNull ==0) {
							Cadastrar(textProduto.getText(),ID,Quant,Preç);
							JOptionPane.showMessageDialog(null,"Produto Cadastrado com sucesso!");
						
							CadastrarProduto obj3 = new CadastrarProduto();
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
					else
						JOptionPane.showMessageDialog(null,"Esse produto já estar cadastrado!");
				}
				catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(null,"Preencha todos os campos e Preço/Quantidade só digite apenas números!");
				}	
			}
		});
		btnNewButton.setBounds(198, 299, 103, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblQuantidades = new JLabel("Quantidades");
		lblQuantidades.setBounds(42, 141, 96, 20);
		contentPane.add(lblQuantidades);
		
		textQuant = new JTextField();
		textQuant.setBounds(46, 172, 52, 20);
		contentPane.add(textQuant);
		textQuant.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(46, 203, 59, 20);
		contentPane.add(lblPreo);
		
		textPreç = new JTextField();
		textPreç.setBounds(46, 229, 67, 20);
		contentPane.add(textPreç);
		textPreç.setColumns(10);
	}
	public void Cadastrar(String nome, int ID, int Quant, double Preç ) {
		
		Medicamento a1 = new Medicamento(ID,nome,Quant,Preç,"");
		rep.addMedicamento(a1);
	}
}