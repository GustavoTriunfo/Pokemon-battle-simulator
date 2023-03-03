import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class BotaoPokemon extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BotaoPokemon frame = new BotaoPokemon();
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
	public BotaoPokemon() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BotaoPokemon.class.getResource("/Images/Poké_Ball_icon.svg.png")));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setBackground(new Color(0,0,0,0));
		
		JLabel BX = new JLabel("");
		BX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				BX.setIcon(new ImageIcon(BotaoPokemon.class.getResource("/Images/BX Pressed.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BX.setIcon(new ImageIcon(BotaoPokemon.class.getResource("/Images/BX (2).png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				BX.setIcon(new ImageIcon(BotaoPokemon.class.getResource("/Images/BX Entered.png")));
			}
		});
		BX.setIcon(new ImageIcon(BotaoPokemon.class.getResource("/Images/BX (2).png")));
		BX.setBounds(466, 0, 67, 61);
		contentPane.add(BX);
		
		JLabel Pokemon = new JLabel("");
		Pokemon.setIcon(new ImageIcon(BotaoPokemon.class.getResource("/Images/PikaCard.png")));
		Pokemon.setBounds(31, 37, 450, 628);
		contentPane.add(Pokemon);
	}
}
