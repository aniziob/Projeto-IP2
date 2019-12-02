package Tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Main.AtualizarLista;
import Main.Carrinho;
import Main.Medicamento;
import Repositorio.RepositorioAtualizarLista;
import Repositorio.RepositorioCarrinho;
import Repositorio.RepositorioMedicamento;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListarProdutos extends JFrame {

	private JPanel contentPane;
	private RepositorioMedicamento rep = new RepositorioMedicamento();
	private JTextField textID;
	
	private RepositorioCarrinho recar = new RepositorioCarrinho();
	private JTextField textQuant;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarProdutos frame = new ListarProdutos();
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
	public ListarProdutos() {
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 199);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "QUANTIDADE", "PRE\u00C7O", "PROMO\u00C7\u00C3O"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(71);
		table.getColumnModel().getColumn(4).setPreferredWidth(73);
		scrollPane.setViewportView(table);
		for(int i = 0; i < RepositorioMedicamento.repMed.size(); i++) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.addRow(new Object [] {(RepositorioMedicamento.repMed.get(i).getId()),(RepositorioMedicamento.repMed.get(i).getNome()),
					RepositorioMedicamento.repMed.get(i).getQuantidade(),RepositorioMedicamento.repMed.get(i).getPreço(),RepositorioMedicamento
					.repMed.get(i).getPromo()});
			scrollPane.setColumnHeaderView(table);
		}
		scrollPane.setViewportView(table);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal obj = new Principal();
				obj.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnAddAoCarrinho = new JButton("Add ao Carrinho");
		btnAddAoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
					int ID= Integer.parseInt(textID.getText());
					int Quant= Integer.parseInt(textQuant.getText());
					int VerifID = RepositorioCarrinho.Verificar(RepositorioMedicamento.repMed.get(ID).getNome());//vai verificar se já o produto no carrinho
					if(RepositorioCarrinho.buscarID(ID)==true) {
						if(RepositorioMedicamento.repMed.get(ID).getQuantidade()!=0) {//verificar se tem no stoque
							if(Quant > 0) {//verificando se a quantida que o adm quer é maior que 0
							if(Quant <= RepositorioMedicamento.repMed.get(ID).getQuantidade()) {// virificando se quantidade que o adm quer é menor que a quantidade em etoque		
									if(VerifID !=-1) {//se for diferente de -1 é pq o produto existe
										RepositorioMedicamento.repMed.get(ID).setQuantidade1(-Quant);
										RepositorioCarrinho.car.get(VerifID).setQuantidade1(Quant);
										JOptionPane.showMessageDialog(null, "Produto adicionado no carrinho");
										ListarProdutos obj = new ListarProdutos();
										obj.setVisible(true);
										dispose();
										
									}else {
										RepositorioMedicamento.repMed.get(ID).setQuantidade1(-Quant);
										RepositorioMedicamento.repMed.get(ID).setQuantRemove(Quant);
										JOptionPane.showMessageDialog(null, "Produto adicionado no carrinho");
										Carrinho m1 = new Carrinho (RepositorioCarrinho.car.size(),RepositorioMedicamento.repMed.get(ID).getNome(),Quant,RepositorioMedicamento.repMed.get(ID).getPreço(),RepositorioMedicamento.repMed.get(ID).getPromo());
										RepositorioCarrinho.addNoCarrinho(m1);
										ListarProdutos obj = new ListarProdutos();
										obj.setVisible(true);
										dispose();
									}
								}
								else
									JOptionPane.showMessageDialog(null,"Quantidade de produto é maior que a quante em estoque!");
							}
							else
								JOptionPane.showMessageDialog(null,"Digite ao menos uma Quantidade!");
						}
						else {
							JOptionPane.showMessageDialog(null,"Acabou o produto em estoque");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Esse pruduto não exite!");
					}
				
				}
				catch(java.lang.NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Digite o ID do produto para ser adicionado no carrinho!");
				}
				}
				catch(IndexOutOfBoundsException exception) {
					JOptionPane.showMessageDialog(null, "Esse produto não existe, virifique o ID!");
				}
				
			}
		});
		btnAddAoCarrinho.setBounds(287, 227, 137, 23);
		contentPane.add(btnAddAoCarrinho);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(139, 230, 24, 18);
		contentPane.add(lblId);
		
		textID = new JTextField();
		textID.setBounds(160, 229, 40, 21);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblQuant = new JLabel("Quant.");
		lblQuant.setBounds(204, 231, 46, 14);
		contentPane.add(lblQuant);
		
		textQuant = new JTextField();
		textQuant.setBounds(239, 230, 40, 20);
		contentPane.add(textQuant);
		textQuant.setColumns(10);
	}
}
