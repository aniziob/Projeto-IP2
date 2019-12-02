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

import Main.Usuario;
import Repositorio.RepositorioUsuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarUsuariosCadastrados extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Usuario usu= new Usuario();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarUsuariosCadastrados frame = new ListarUsuariosCadastrados();
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
	public ListarUsuariosCadastrados() {
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 196);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "CPF", "IDADE"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(165);
		table.getColumnModel().getColumn(1).setPreferredWidth(99);
		table.getColumnModel().getColumn(2).setPreferredWidth(57);
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
		for(int i = 0; i < RepositorioUsuario.nomes.size(); i++) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.addRow(new Object [] {(RepositorioUsuario.nomes.get(i).getNome()),(RepositorioUsuario.nomes.get(i).getCpf()),(RepositorioUsuario.nomes.get(i).getIdade())});
			}
		
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);

		}
}
