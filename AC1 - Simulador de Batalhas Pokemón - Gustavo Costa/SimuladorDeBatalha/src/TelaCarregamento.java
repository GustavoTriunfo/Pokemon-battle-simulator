import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Point;

public class TelaCarregamento extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCarregamento frame = new TelaCarregamento();
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
	public TelaCarregamento() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 625);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCarregamento.class.getResource("/Images/Poké_Ball_icon.svg.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBackground(new Color(0,0,0,0));
		setBounds(100, 100, 1013, 625);
		setLocationRelativeTo(null);
	
		JProgressBar progressBar = new JProgressBar(0,100);
		progressBar.setStringPainted(true);
		progressBar.setValue(100);
		progressBar.setEnabled(false);
		progressBar.setForeground(new Color(32, 177, 255));
		progressBar.setBounds(307, 422, 424, 29);
		contentPane.add(progressBar);
		
		  new Thread(){
	            public void run(){
	                for (int i = 0; i < 101; i++) {
	                    progressBar.setValue(i);
	                    try {
	                        sleep(100);
	                        
	                        if(i == 100){
	                            Pokemon login = new Pokemon();
	                            login.setVisible(true);
	                            dispose();                            
	                        }
	                    } catch (InterruptedException ex) {
	                        ex.printStackTrace();
	                    }
	                }                
	            }
	        }.start();
	        
	        JLabel ImagemFundo = new JLabel("");
			ImagemFundo.setIcon(new ImageIcon(TelaCarregamento.class.getResource("/Images/TelaCarregamento Pronta (1) (1).jpg")));
			ImagemFundo.setBounds(0, 0, 1013, 625);
			contentPane.add(ImagemFundo);
		
		
	    }
		
		
		
		
		
	
}
	



