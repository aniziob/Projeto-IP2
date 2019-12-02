package Tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Arquivo.ManipuladorArquivo;
import Main.AtualizarLista;
import Main.Carrinho;
import Main.Compra;
import Main.Hora;
import Main.Medicamento;
import Repositorio.RepositorioAtualizarLista;
import Repositorio.RepositorioCarrinho;
import Repositorio.RepositorioCompra;
import Repositorio.RepositorioMedicamento;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;



public class CarrinhoTela extends JFrame {


	private JPanel contentPane;
	private JTextField textID;
	
	private Carrinho car = new Carrinho();
	private JTextField textQuant;

	private double total = 0;
	private Hora hora = new Hora();
	private String a ="";
	private JTable table;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarrinhoTela frame = new CarrinhoTela();
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
	public CarrinhoTela() {
		
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter foratadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data= hoje.format(foratadorBarra);
		String horas=hora.hora();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 471, 189);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "QUANTIDADE", "PRE\u00C7O", "TOTAL", "PROMO\u00C7\u00C3O"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(48);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(79);
		table.getColumnModel().getColumn(3).setPreferredWidth(64);
		table.getColumnModel().getColumn(4).setPreferredWidth(66);
		table.getColumnModel().getColumn(5).setPreferredWidth(73);
		scrollPane.setViewportView(table);
		
		for(int i = 0; i < RepositorioCarrinho.car.size(); i++) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.addRow(new Object [] {(RepositorioCarrinho.car.get(i).getID()),(RepositorioCarrinho.car.get(i).getNome()),
			RepositorioCarrinho.car.get(i).getQuantidade(),RepositorioCarrinho.car.get(i).getPreço(),(RepositorioCarrinho.car.get(i).getPreço()*RepositorioCarrinho.car.get(i).getQuantidade()),RepositorioCarrinho.car.get(i).getPromo()});
			scrollPane.setColumnHeaderView(table);
			total+=(RepositorioCarrinho.car.get(i).getPreço()*RepositorioCarrinho.car.get(i).getQuantidade());
			}
		scrollPane.setViewportView(table);
		a = RepositorioCarrinho.format(total);	///Label do total!
		textQuant = new JTextField();
		textQuant.setBounds(387, 211, 38, 20);
		contentPane.add(textQuant);
		textQuant.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total:"+ a);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 211, 153, 23);
		contentPane.add(lblNewLabel);
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal obj = new Principal();
				obj.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 239, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i<RepositorioCarrinho.car.size(); i++) {//Passando a lista carrinho para um lista de compra
					Compra m1 = new Compra(RepositorioCompra.compr.size()-1,RepositorioCarrinho.car.get(i).getNome(),RepositorioCarrinho.car.get(i).getQuantidade(),(RepositorioCarrinho.car.get(i).getQuantidade()*RepositorioCarrinho.car.get(i).getPreço()),data,horas);
					RepositorioCompra.addCompra(m1);
				}//fim copia
				
				for(int i = 0; i<RepositorioCarrinho.car.size(); i++) {//Passando a lista carrinho para um lista de compra
					RepositorioCarrinho.car.get(i).setQuantidade(0);	
				}
				
				String Nomes=""; String quant=""; int Quantidades=0; String QuantidadesNome =""; double Preccos=0; String pre="";
				
				for(int i =0; i< RepositorioCarrinho.car.size();i++) {
					Nomes = Nomes + "|"+ RepositorioCarrinho.car.get(i).getNome();
					QuantidadesNome = QuantidadesNome + "|" +RepositorioCompra.compr.get(i).getQuantidade();
					Quantidades = Quantidades  + RepositorioCompra.compr.get(i).getQuantidade();
					quant = quant +"|"+ RepositorioCompra.compr.get(i).getQuantidade();
					Preccos = Preccos  +  (RepositorioCarrinho.car.get(i).getPreço() * Quantidades);
					pre = pre +"|"+ RepositorioCarrinho.format(RepositorioCarrinho.car.get(i).getPreço());
					
				
				}
				String Preccos2 = RepositorioCarrinho.format(total);
				
				RepositorioCarrinho.car.removeAll(RepositorioCarrinho.car);//limpando o carrinho!
				String arq = "D:\\Usuário\\Vitorvx\\Desktop\\NotaFiscal.txt";
				String textoR = ManipuladorArquivo.leitor(arq);
					if(textoR.isEmpty()) {
						String Inf =("NOME       : " + Nomes +"|\n"+
								"PREÇO      : " + pre+"|\n"+
								"QUANTIDADES: "+quant 
								+ "\n" + "TOTAL      : " +Preccos2 +"\n" + "DATA       : " +
								data+ "\n" + "HORAS      : "+horas);
						ManipuladorArquivo.Write(arq, Inf);
					}
					else {
						ManipuladorArquivo.deleteTree("D:\\Usuário\\Vitorvx\\Desktop\\NotaFiscal.txt");
						String Inf =("NOME       :" + Nomes +"|\n"+"QUANTIDADES:"+QuantidadesNome + "|\n" + "TOTAL      :" +Preccos2 +"\n" + "DATA       :" +data+ "\n" + "HORAS      :"+horas);
						ManipuladorArquivo.Write(arq, Inf);
					}

				JOptionPane.showMessageDialog(null, "Venda Efetuada com Sucesso!");
				CarrinhoTela obj = new CarrinhoTela();
				obj.setVisible(true);
				dispose();
		}
		});
		btnComprar.setBounds(374, 239, 89, 23);
		contentPane.add(btnComprar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						int ID = Integer.parseInt(textID.getText());
						int VerifID=0;
						int Quant = Integer.parseInt(textQuant.getText());
						if(Quant > RepositorioCarrinho.car.get(ID).getQuantidade()) {
							car.setIndexRemove(ID);
							car.setIndexQuantRmove(Quant);
							RemoverDoCarrinho obj3 = new RemoverDoCarrinho();
							obj3.setVisible(true);
							dispose();	
						}
						else{
							if(Quant>0) {
								VerifID = RepositorioMedicamento.VerificarPorNome(RepositorioCarrinho.car.get(ID).getNome());
								RepositorioCarrinho.car.get(ID).setQuantidade1(-Quant);
								RepositorioMedicamento.repMed.get(VerifID).setQuantidade1(Quant);
								if(RepositorioCarrinho.car.get(ID).getQuantidade()==0) {
									RepositorioCarrinho.car.remove(ID);
									for(int i = 0; i<RepositorioCarrinho.car.size(); i++) {//Passando a lista carrinho para um lista auxiliar
										AtualizarLista m1 = new AtualizarLista (RepositorioAtualizarLista.att.size()-1,RepositorioCarrinho.car.get(i).getNome(),RepositorioCarrinho.car.get(i).getQuantidade(),RepositorioCarrinho.car.get(i).getPreço(),RepositorioMedicamento
												.repMed.get(i).getPromo());
										RepositorioAtualizarLista.addNaLista(m1);
										RepositorioAtualizarLista.att.get(i).toString();		
									}//fim copia
									RepositorioCarrinho.car.removeAll(RepositorioCarrinho.car);
									for(int i = 0; i<RepositorioAtualizarLista.att.size(); i++) {
										Carrinho m1 = new Carrinho (RepositorioCarrinho.car.size(),RepositorioAtualizarLista.att.get(i).getNome(),RepositorioAtualizarLista.att.get(i).getQuantidade(),RepositorioAtualizarLista.att.get(i).getPreço(),RepositorioMedicamento
												.repMed.get(i).getPromo());
										RepositorioCarrinho.addNoCarrinho(m1);
									}
									RepositorioAtualizarLista.att.removeAll(RepositorioAtualizarLista.att);
									JOptionPane.showMessageDialog(null, "Quantidade Removida com sucesso!");
									scrollPane.setViewportView(table);
									CarrinhoTela obj3 = new CarrinhoTela();
									obj3.setVisible(true);
									dispose();
								}
								else {
									if(Quant <0 || Quant ==0) {
										JOptionPane.showMessageDialog(null, "Digite ao menos uma quantidade!");
									}
									else {
										if(Quant <0 || Quant ==0) {
											JOptionPane.showMessageDialog(null, "Digite ao menos uma quantidade!");
										}
										JOptionPane.showMessageDialog(null, "Quantidade Removida com sucesso!");
										CarrinhoTela obj3 = new CarrinhoTela();
										obj3.setVisible(true);
										dispose();
									}
									
								}
							}
							else {
								if(Quant <0 || Quant ==0) {
									JOptionPane.showMessageDialog(null, "Digite ao menos uma quantidade!");
								}
								else {
									if(Quant <0 || Quant ==0) {
										JOptionPane.showMessageDialog(null, "Digite ao menos uma quantidade!");
									}
									CarrinhoTela obj3 = new CarrinhoTela();
									obj3.setVisible(true);
									dispose();
								}
								
							}
					 	}
					}
					catch(NumberFormatException exception){
						JOptionPane.showMessageDialog(null, "Digite o ID e a Quantidade, apenas números Ou Verifique o ID do produto!");
					}
					
				}
				catch(IndexOutOfBoundsException exception ) {
					JOptionPane.showMessageDialog(null, "Esse produto não existe no carrinho!");
				}
			
			}
		});
		btnRemover.setBounds(273, 239, 89, 23);
		contentPane.add(btnRemover);
		
		textID = new JTextField();
		textID.setBounds(297, 211, 38, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(275, 214, 48, 14);
		contentPane.add(lblId);
		
		JLabel lblQuant = new JLabel("Quant.");
		lblQuant.setBounds(345, 214, 48, 14);
		contentPane.add(lblQuant);
	}
}
