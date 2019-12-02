package Tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import Repositorio.RepositorioMedicamento;
import Repositorio.RepositorioPromocao;


public class Promoção extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textDESC;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Promoção frame = new Promoção();
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
	public Promoção() {
		

	
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(135, 204, 38, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textDESC = new JTextField();
		textDESC.setBounds(252, 204, 33, 20);
		contentPane.add(textDESC);
		textDESC.setColumns(10);
		
		JLabel lblNome = new JLabel("ID");
		lblNome.setBounds(135, 181, 51, 20);
		contentPane.add(lblNome);
		
		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setBounds(252, 184, 67, 14);
		contentPane.add(lblDesconto);
		
		JLabel label = new JLabel("%");
		label.setBounds(289, 207, 48, 14);
		contentPane.add(label);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int ID= Integer.parseInt(textID.getText());
				float Desc = Float.parseFloat(textDESC.getText());
			
				if(RepositorioMedicamento.buscar(ID)==true) {
			
					if(Desc > 0 && Desc <= 100) {
						RepositorioPromocao.desconto(ID, Desc);
						JOptionPane.showMessageDialog(null,"Promoção adicionada!" );									
						Promoção obj = new Promoção();//Atualiza a tela de promoção
						obj.setVisible(true);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "O desconto tem que ser de 1 a 100!");
				}
				else
					JOptionPane.showMessageDialog(null, "Esse produto não existe!");
			}
				catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Não pode deixar os campos em branco e digite apenas números!");	
				}
			}
		});
		btnCadastrar.setBounds(312, 201, 95, 23);
		contentPane.add(btnCadastrar);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 163);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "QUANTIDADE", "PRE\u00C7O", "PROMO\u00C7\u00C3O"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Float.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(54);
		table.getColumnModel().getColumn(1).setPreferredWidth(135);
		table.getColumnModel().getColumn(2).setPreferredWidth(82);
		table.getColumnModel().getColumn(3).setPreferredWidth(71);
		table.getColumnModel().getColumn(4).setPreferredWidth(77);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ID= Integer.parseInt(textID.getText());
					if(RepositorioMedicamento.buscar(ID)==true) {			
						RepositorioPromocao.removerPromocao(ID);
						JOptionPane.showMessageDialog(null,"Promoção Removida!" );	
						Promoção obj = new Promoção();//Atualiza a tela de promoção
						obj.setVisible(true);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "Esse produto não existe!");
				}
				catch(NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "Não pode deixar os campos em branco e digite apenas números!");	
				}
				
			}
		});
		btnNewButton.setBounds(312, 232, 95, 23);
		contentPane.add(btnNewButton);
		for(int i = 0; i < RepositorioMedicamento.repMed.size(); i++) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.addRow(new Object [] {(RepositorioMedicamento.repMed.get(i).getId()),(RepositorioMedicamento.repMed.get(i).getNome()),
					RepositorioMedicamento.repMed.get(i).getQuantidade(),RepositorioMedicamento.repMed.get(i).getPreço(),RepositorioMedicamento.repMed.get(i).getPromo()});
			scrollPane.setViewportView(table);
		}
	}
}
