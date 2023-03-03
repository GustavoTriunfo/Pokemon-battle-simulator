import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vencedor1 extends JFrame {

	private JPanel contentPane;
	public JLabel PokemonVencedor;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Vencedor1 frame = new Vencedor1("um");
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	public Vencedor1(String pok) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vencedor1.class.getResource("/Images/Poké_Ball_icon.svg.png")));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1013, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBackground(new Color(0,0,0,0));
		
		JLabel Back = new JLabel("");
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Back.setIcon(new ImageIcon(Vencedor1.class.getResource("/ImagensVencedor1/BackVencedorEntered.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Back.setIcon(new ImageIcon(Vencedor1.class.getResource("/ImagensVencedor1/backVencedor.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Back.setIcon(new ImageIcon(Vencedor1.class.getResource("/ImagensVencedor1/BackVencedorPressed.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Back.setIcon(new ImageIcon(Vencedor1.class.getResource("/ImagensVencedor1/BackVencedorEntered.png")));
			}
		});
		Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Back.setIcon(new ImageIcon(Vencedor1.class.getResource("/ImagensVencedor1/backVencedor.png")));
		Back.setBounds(50, 516, 190, 99);
		contentPane.add(Back);
		
		JLabel PokeVence = new JLabel("");
		PokeVence.setBounds(382, 137, 272, 238);
		contentPane.add(PokeVence);
		PokeVence.setIcon(new ImageIcon(Vencedor1.class.getResource("")));
		//Pokemon pathFile = new Pokemon("path");
		String Path = Pokemon.pathDaImage;
		
		
		
		
		if(pok.equals("um")) {
			PokeVence.setIcon(new ImageIcon(Vencedor1.class.getResource(Path)));
		} else if(pok.equals("dois")) {
			PokeVence.setIcon(new ImageIcon(Vencedor1.class.getResource("/PokemonsBatalha/pk8.png")));
		}
		
		
		JLabel FundoAsas = new JLabel("");
		FundoAsas.setIcon(new ImageIcon(Vencedor1.class.getResource("/ImagensVencedor1/vitoriaPok-removebg-preview.png")));
		FundoAsas.setHorizontalAlignment(SwingConstants.CENTER);
		FundoAsas.setBounds(94, 63, 829, 494);
		contentPane.add(FundoAsas);
		
		JLabel FundoTrofeu = new JLabel("");
		FundoTrofeu.setHorizontalAlignment(SwingConstants.CENTER);
		FundoTrofeu.setIcon(new ImageIcon(Vencedor1.class.getResource("/ImagensVencedor1/trofeu.png")));
		FundoTrofeu.setBounds(94, 63, 829, 494);
		contentPane.add(FundoTrofeu);
		
		JLabel FundoConfetti = new JLabel("");
		FundoConfetti.setHorizontalAlignment(SwingConstants.CENTER);
		FundoConfetti.setIcon(new ImageIcon(Vencedor1.class.getResource("/ImagensVencedor1/vit.gif")));
		FundoConfetti.setBounds(94, 63, 829, 494);
		contentPane.add(FundoConfetti);
		
		JLabel FundoImage = new JLabel("");
		FundoImage.setIcon(new ImageIcon(Vencedor1.class.getResource("/ImagensVencedor1/gif party.gif")));
		FundoImage.setBounds(0, 0, 1013, 625);
		setLocationRelativeTo(null);
		contentPane.add(FundoImage);
	}
}
