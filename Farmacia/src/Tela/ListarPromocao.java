package Tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Repositorio.RepositorioCompra;
import Repositorio.RepositorioMedicamento;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarPromocao extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarPromocao frame = new ListarPromocao();
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
	public ListarPromocao() {
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 11, 390, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "QUANTIDADE", "PRE\u00C7O", "PROMO\u00C7AO"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(49);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(68);
		table.getColumnModel().getColumn(4).setPreferredWidth(76);
		scrollPane.setViewportView(table);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		for(int i = 0; i < RepositorioMedicamento.repMed.size(); i++) {
			if(RepositorioMedicamento.repMed.get(i).getPromo()!="") {
			model.addRow(new Object [] {RepositorioMedicamento.repMed.get(i).getId(),RepositorioMedicamento.repMed.get(i).getNome(),RepositorioMedicamento.repMed.get(i).getQuantidade(),RepositorioMedicamento.repMed.get(i).getPreço(),RepositorioMedicamento.repMed.get(i).getPromo()});
			}
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
	}
}
