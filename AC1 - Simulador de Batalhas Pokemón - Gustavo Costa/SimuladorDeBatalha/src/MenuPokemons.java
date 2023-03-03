import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import java.awt.Color;

public class MenuPokemons extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MenuPokemons frame = new MenuPokemons();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MenuPokemons() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPokemons.class.getResource("/Images/Poké_Ball_icon.svg.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 521, 823);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(0, 0, 55));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setBounds(0, 0, 480, 635);
		contentPane.add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(480, 10, 17, 625);
		contentPane.add(scrollBar);
		setLocationRelativeTo(null);
	}
}
