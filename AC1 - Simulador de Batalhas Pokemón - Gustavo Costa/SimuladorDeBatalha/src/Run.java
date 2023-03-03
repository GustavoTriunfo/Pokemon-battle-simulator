import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Run extends JFrame {

	private JPanel contentPane;
	private JLabel RunningPika;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Run frame = new Run();
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
	public Run() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Run.class.getResource("/Images/Poké_Ball_icon.svg.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		 try {
			  File file = new File("Lavender-Town-_Original-Japanese-Version-from-Pokemon-Red-and-Green_.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			  Clip clipRun = AudioSystem.getClip();
			 // int LOOP_CONTINUOUSLY = -1;
			  clipRun.open(audioStream);
			  
			  clipRun.loop(-1);
		
		JLabel BotaoBack = new JLabel("");
		BotaoBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pokemon login = new Pokemon();
                login.setVisible(true);
                clipRun.stop();
                dispose();          
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				BotaoBack.setIcon(new ImageIcon(Run.class.getResource("/Running/backProntoEntered.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BotaoBack.setIcon(new ImageIcon(Run.class.getResource("/Running/backPronto.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				BotaoBack.setIcon(new ImageIcon(Run.class.getResource("/Running/backProntoPressed.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				BotaoBack.setIcon(new ImageIcon(Run.class.getResource("/Running/backProntoEntered.png")));
			}
		});
		BotaoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotaoBack.setIcon(new ImageIcon(Run.class.getResource("/Running/backPronto.png")));
		BotaoBack.setBounds(191, 35, 295, 156);
		contentPane.add(BotaoBack);
			  
			  
		JLabel RunningPika = new JLabel("");
		RunningPika.setIcon(new ImageIcon(Run.class.getResource("/Running/PikaParado.gif")));
		RunningPika.setBounds(337, 182, 449, 320);
		contentPane.add(RunningPika);
		
		
		JLabel BotaoExit = new JLabel("");
		BotaoExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				BotaoExit.setIcon(new ImageIcon(Run.class.getResource("/Running/ExitEntered.png")));
				
					
				RunningPika.setIcon(new ImageIcon(Run.class.getResource("/Running/PikaIndo.gif")));
				
//				try {
//					wait(100);
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				} 
				
				
				RunningPika.setIcon(new ImageIcon(Run.class.getResource("/Running/ScaredGif.gif")));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BotaoExit.setIcon(new ImageIcon(Run.class.getResource("/Running/Exit.png")));
				RunningPika.setIcon(new ImageIcon(Run.class.getResource("/Running/PikaVoltando.gif")));
				RunningPika.setIcon(new ImageIcon(Run.class.getResource("/Running/PikaParado.gif")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				BotaoExit.setIcon(new ImageIcon(Run.class.getResource("/Running/ExitPressed.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				BotaoExit.setIcon(new ImageIcon(Run.class.getResource("/Running/ExitEntered.png")));
			}
		});
		BotaoExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotaoExit.setIcon(new ImageIcon(Run.class.getResource("/Running/Exit.png")));
		BotaoExit.setBounds(544, 35, 350, 156);
		contentPane.add(BotaoExit);
		
		
		JLabel Shadow = new JLabel("");
		Shadow.setIcon(new ImageIcon(Run.class.getResource("/Running/Oval.png")));
		Shadow.setBounds(195, 201, 1003, 487);
		contentPane.add(Shadow);
		
		JLabel Fundo = new JLabel("");

		  Fundo.setIcon(new ImageIcon(Pokemon.class.getResource("/Running/G1Preto.jpg")));
		
		
		Fundo.setBounds(0, 0, 1013, 625);
		contentPane.add(Fundo);
		setBounds(100, 100, 1013, 625);
		setLocationRelativeTo(null);
		
		 }catch (UnsupportedAudioFileException ex){
             ex.printStackTrace();                 
		  }catch (IOException ez) {
			  ez.printStackTrace();
		  }catch (LineUnavailableException ea){
             ea.printStackTrace();       
	}
	}
}
