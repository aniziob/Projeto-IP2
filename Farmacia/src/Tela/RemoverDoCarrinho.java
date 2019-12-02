package Tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.AtualizarLista;
import Main.Carrinho;
import Repositorio.RepositorioAtualizarLista;
import Repositorio.RepositorioCarrinho;
import Repositorio.RepositorioMedicamento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoverDoCarrinho extends JFrame {
	private Carrinho car= new Carrinho();
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverDoCarrinho frame = new RemoverDoCarrinho();
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
	public RemoverDoCarrinho() {
		setTitle("MyPharma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAQuantidadeQue = new JLabel("A quantidade que voc\u00EA deseja remover, \u00E9 maior que a quantidade que tem no seu carrinho.");
		lblAQuantidadeQue.setBounds(10, 11, 700, 23);
		contentPane.add(lblAQuantidadeQue);
		
		JButton btnNewButton = new JButton("Sim");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = car.getIndexRemove();
				int VerifID=RepositorioMedicamento.VerificarPorNome(RepositorioCarrinho.car.get(ID).getNome());
				int Quant = Carrinho.getIndexQuantRmove();
				Carrinho.setIndexContRemove(+1);
				
				RepositorioCarrinho.car.get(ID).setQuantidade1(-Quant);
				RepositorioMedicamento.repMed.get(VerifID).setQuantidade1(Quant-1);
				RepositorioCarrinho.car.remove(ID);
				for(int i = 0; i<RepositorioCarrinho.car.size(); i++) {//Passando a lista carrinho para um lista auxiliar
					AtualizarLista m1 = new AtualizarLista (RepositorioAtualizarLista.att.size()-1,RepositorioCarrinho.car.get(i).getNome(),RepositorioCarrinho.car.get(i).getQuantidade(),RepositorioCarrinho.car.get(i).getPreço(),RepositorioCarrinho.car.get(i).getPromo());
					RepositorioAtualizarLista.addNaLista(m1);	
				}//fim copia
				RepositorioCarrinho.car.removeAll(RepositorioCarrinho.car);
				
				for(int i = 0; i<RepositorioAtualizarLista.att.size(); i++) {
					Carrinho m1 = new Carrinho (RepositorioCarrinho.car.size(),RepositorioAtualizarLista.att.get(i).getNome(),RepositorioAtualizarLista.att.get(i).getQuantidade(),RepositorioAtualizarLista.att.get(i).getPreço(),RepositorioAtualizarLista.att.get(i).getPromo());
					RepositorioCarrinho.addNoCarrinho(m1);
					System.out.println(m1);
				}
				
				RepositorioAtualizarLista.att.removeAll(RepositorioAtualizarLista.att);
				
				JOptionPane.showMessageDialog(null,"Removido com sucesso!");
			
				CarrinhoTela obj3 = new CarrinhoTela();
				obj3.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(83, 77, 116, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("N\u00E3o");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarrinhoTela obj3 = new CarrinhoTela();
				obj3.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(308, 80, 116, 26);
		contentPane.add(btnNewButton_1);
		
		JLabel lblVocDesejaRemover = new JLabel(" Voc\u00EA deseja remover esse produto?");
		lblVocDesejaRemover.setBounds(166, 34, 246, 14);
		contentPane.add(lblVocDesejaRemover);
	}
}
