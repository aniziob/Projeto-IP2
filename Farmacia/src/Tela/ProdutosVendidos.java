package Tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Main.Hora;
import Repositorio.RepositorioCompra;
import Repositorio.RepositorioMedicamento;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class ProdutosVendidos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Hora hora = new Hora();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutosVendidos frame = new ProdutosVendidos();
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
	public ProdutosVendidos() {
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Quantidade", "Pre\u00E7o Total", "Data", "Horas"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Float.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(121);
		table.getColumnModel().getColumn(1).setPreferredWidth(76);
		table.getColumnModel().getColumn(2).setPreferredWidth(78);
		table.getColumnModel().getColumn(3).setPreferredWidth(78);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
	
		for(int i = 0; i < RepositorioCompra.compr.size(); i++) {
			
			model.addRow(new Object [] {(RepositorioCompra.compr.get(i).getNome()),RepositorioCompra.compr.get(i).getQuantidade(),RepositorioCompra.compr.get(i).getTotal(),RepositorioCompra.compr.get(i).getData(),RepositorioCompra.compr.get(i).getHora()});
		
		}
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
	}
}
