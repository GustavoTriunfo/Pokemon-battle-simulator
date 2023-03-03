
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;


import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class Pokemon extends JFrame 
{

		private static String nome;
		private static String tipo;
		private static int vida;
		private static int vida1;
		private static int vida2;
		public static String pathDaImage; 
		private static JPanel contentPane;
		private static JTextField digNome1 = new JTextField("Pokemon1");
		private static JTextField digTipo1;
		private static JTextField digNome2 = new JTextField("Pokemon2");
		private static JTextField digTipo2;
		private static JButton BotaoBatalha;
		public int i = 0;      
		public JLabel selecaoPok1DireitaJLabel;
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pokemon frame = new Pokemon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	public Pokemon(String string) {
		
		List<String> pokemonSelecao = new ArrayList<String>();
         String path = System.getProperty("java.class.path");
         
			File[] files = new File(path + "\\PokemonsBatalha").listFiles();
			
			//If this pathname does not denote a directory, then listFiles() returns null. 

			for (File file : files) {
			    if (file.isFile()) {
			    	pokemonSelecao.add(file.getName());
			    	
			    }
			}
			
			 String pathFile = "\\PokemonsBatalha\\" +  pokemonSelecao.get(i).toString();
			  
			
	}
	
	public Pokemon(JTextField digNome, JTextField digTipo)
	{
		if (tipo == "fogo") {
			vida = 180;
			
		} else if(tipo =="agua") {
			vida = 195;
			
		} else if(tipo =="terra") {
			vida = 220;
			
		} else if(tipo =="ar") {
			vida = 225;
			
		} else {
			vida = 200;
		}
	
	}
		/**
		 * Create the frame.
		 */
		public Pokemon() {
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage(Pokemon.class.getResource("/Images/Poké_Ball_icon.svg.png")));
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			
			try {
			 File fileAudio = new File("Pokemon-Red_-Yellow_-Blue-Arrumado.wav");
			  AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileAudio);
			  Clip clip = AudioSystem.getClip();
			  clip.open(audioStream);
			  clip.loop(-1);
			 
			  /////////////////////////////////////////////////////////////////////////////////////////
			  
			  List<String> pokemonSelecao = new ArrayList<String>();

              String path = System.getProperty("java.class.path");
              
				File[] files = new File(path + "\\PokemonsBatalha").listFiles();
				
				//If this pathname does not denote a directory, then listFiles() returns null. 

				for (File file : files) {
				    if (file.isFile()) {
				    	pokemonSelecao.add(file.getName());
				    	
				    }
				}
				
				 String pathFile = "\\PokemonsBatalha\\" +  pokemonSelecao.get(i).toString();
				
//				  selecaoPok1DireitaJLabel.setIcon(new ImageIcon(Pokemon.class.getResource("")));
				  //pathDaImage = pathFile;
				  ///////////////////////////////////////////////////////////////////////////////////
				
			setTitle("Simulador de Batalhas Pokemón");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1013, 625);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setLocationRelativeTo(null);
		
			
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel Pokedex = new JLabel("");
			Pokedex.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			Pokedex.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					Pokedex.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/menuPainted.png")));
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					MenuPokemons menuP = new MenuPokemons();
                    menuP.setVisible(true);
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Pokedex.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/PokedexPressed.png")));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					Pokedex.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/menu1 (1) (2).png")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					Pokedex.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/menu1 (1) (2).png")));
				}
			});
			
			JLabel FightB = new JLabel("");
			FightB.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(e.getSource()==FightB ) {
						if(vida1 > vida2) {
							Vencedor1 vencedor = new Vencedor1("um");
		                    vencedor.setVisible(true);
		                    
							int vidaRes1 = vida1 - vida2;
							String nome1 = digNome1.getText();
							JOptionPane.showMessageDialog(null, "O Pokemon "+ nome1 + " é o vencedor!" + "\n" + " Vida restante do vencedor: " + vidaRes1);
							

						} else if(vida1 < vida2){
							Vencedor1 vencedor1 = new Vencedor1("dois");
		                    vencedor1.setVisible(true);
							
							int vidaRes2 = vida2 - vida1;
							String nome2 = digNome2.getText();
							JOptionPane.showMessageDialog(null, "O Pokemon "+ nome2 + " é o vencedor!" + "\n" + " Vida restante do vencedor: " + vidaRes2);
							
						} else if(vida1 == vida2) {
							JOptionPane.showMessageDialog(null, "Os Pokemons empataram!");
						}
						
					}
				
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					FightB.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/batalhaBotaoNovoMaisV.png")));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					FightB.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/batalhaBotaoNovoAzul.png")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					FightB.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/batalhaBotaoNovo.png")));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					FightB.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/batalhaBotaoNovo.png")));
				}
			});
			
			JLabel RunB = new JLabel("");
			RunB.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Run run = new Run();
					run.setVisible(true);
					clip.stop();
					dispose();
					
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					RunB.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/RunClicou.png")));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					RunB.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/RunV.png")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					RunB.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/Run1.png")));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					RunB.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/RunClicou.png")));
				}
			
			});
			
			JLabel PokeBotao = new JLabel("");
			PokeBotao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			PokeBotao.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					BotaoPokemon PKB = new BotaoPokemon();
                    PKB.setVisible(true);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					PokeBotao.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/pokebotaoPressed.png")));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					PokeBotao.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/pokebotao.png")));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					PokeBotao.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/pokebotaoAzul.png")));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					PokeBotao.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/pokebotaoPressed.png")));
				}
			});
			
			JLabel FundoMenuCompleto = new JLabel("");
			FundoMenuCompleto.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/FundoCompleto.jpg")));
			FundoMenuCompleto.setBounds(724, 383, 46, 95);
			contentPane.add(FundoMenuCompleto);
			
			JLabel BagButton = new JLabel("");
			BagButton.setBounds(594, 385, 128, 51);
			contentPane.add(BagButton);
			BagButton.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/BagButton.png")));
			BagButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			BagButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Sua Mochila está vazia!");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				BagButton.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/BagButtonPressed.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BagButton.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/BagButton.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				BagButton.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/BagButtonPressedTrue.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				BagButton.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/BagButtonPressed.png")));
			}
		});
			
			
			PokeBotao.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/pokebotao.png")));
			PokeBotao.setBounds(465, 427, 128, 58);
			contentPane.add(PokeBotao);
			RunB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			RunB.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/Run1.png")));
			RunB.setBounds(594, 427, 128, 58);
			contentPane.add(RunB);
			FightB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			FightB.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/batalhaBotaoNovo.png")));
			FightB.setBounds(465, 385, 133, 51);
			contentPane.add(FightB);
			
			JLabel Textotxt = new JLabel("");
			Textotxt.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/Battle.jpg")));
			Textotxt.setBounds(214, 383, 526, 95);
			contentPane.add(Textotxt);
			Pokedex.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/menu1 (1) (2).png")));
			Pokedex.setBounds(769, 260, 189, 58);
			contentPane.add(Pokedex);
			
			JLabel selecaoPok1EsquerdaJLabel_1 = new JLabel("");
			selecaoPok1EsquerdaJLabel_1.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/Battle.png")));
			selecaoPok1EsquerdaJLabel_1.setBounds(269, 245, 214, 128);
			contentPane.add(selecaoPok1EsquerdaJLabel_1);
			
			JLabel selecaoPok1DireitaJLabel = new JLabel("");
			selecaoPok1DireitaJLabel.setIcon(null);
			selecaoPok1DireitaJLabel.setBounds(490, 29, 266, 240);
			contentPane.add(selecaoPok1DireitaJLabel);
			
				JLabel arrowEsquerda = new JLabel("");
				arrowEsquerda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				arrowEsquerda.addMouseListener(new MouseAdapter() {
				
					@Override
					public void mouseClicked(MouseEvent e) {
						 EfeitoSonoroArrows();

					
						i--;	
			              if(i < 0) {
			            	  i = pokemonSelecao.size() - 1;
			              }

						String pathFile = "\\PokemonsBatalha\\" +  pokemonSelecao.get(i).toString();
					
						  selecaoPok1DireitaJLabel.setIcon(new ImageIcon(Pokemon.class.getResource(pathFile)));
								
						  pathDaImage = pathFile;

					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						
						arrowEsquerda.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/arrowEsquerdaVermelho.png")));
						
					}
					@Override
					public void mouseExited(MouseEvent e) {
						arrowEsquerda.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/arrowEsquerda (1).png")));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						arrowEsquerda.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/arrowEsquerdaClicado.png")));
		             
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						 arrowEsquerda.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/arrowEsquerdaVermelho.png")));
					}
				});
				arrowEsquerda.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/arrowEsquerda (1).png")));
				arrowEsquerda.setBounds(780, 151, 100, 105);
				contentPane.add(arrowEsquerda);
			
			
			
						JLabel arrowDireita = new JLabel("");
						
						arrowDireita.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						arrowDireita.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e){
								 EfeitoSonoroArrows();
									
								  i++;		
					              if(i==pokemonSelecao.size()) {
					            	  i = 0;
					              }
								String pathFile = "\\PokemonsBatalha\\" +  pokemonSelecao.get(i).toString();
							
								  selecaoPok1DireitaJLabel.setIcon(new ImageIcon(Pokemon.class.getResource(pathFile)));
								  
								  pathDaImage = pathFile;
							}
				              
					
						
							@Override
							public void mouseEntered(MouseEvent e) {
								arrowDireita.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/arrowDireitaVermelho.png")));
							}
							@Override
							public void mouseExited(MouseEvent e) {
								arrowDireita.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/arrowDireita (1).png")));
							}
							@Override
							public void mousePressed(MouseEvent e) {
								arrowDireita.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/arrowDireitaClicado.png")));
//					           
//					             
							}
							@Override
							public void mouseReleased(MouseEvent e) {
								 arrowDireita.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/arrowDireitaVermelho.png")));
							}
						});
						arrowDireita.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/arrowDireita (1).png")));
						arrowDireita.setBounds(889, 151, 100, 105);
						contentPane.add(arrowDireita);
						
		
			
		
			
			JLabel titulo = new JLabel("");
			titulo.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/tituloCerto.png")));
			titulo.setBounds(339, -13, 390, 156);
			contentPane.add(titulo);
			
			JLabel Pokemon2txt = new JLabel(digNome2.getText());
			Pokemon2txt.setHorizontalAlignment(SwingConstants.RIGHT);
			Pokemon2txt.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
			Pokemon2txt.setBounds(509, 329, 100, 26);
			contentPane.add(Pokemon2txt);
			
			JLabel Pokemon1txt = new JLabel(digNome1.getText());
			Pokemon1txt.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
			Pokemon1txt.setBounds(380, 187, 100, 26);
			contentPane.add(Pokemon1txt);
			
              //////////////////////////////////////////////////////////////////////////////////////
			
				/* botão imprimir1*/
				JButton BotaoImprime1 = new JButton("Imprimir");
				BotaoImprime1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent f) {
						
						if(f.getSource()==BotaoImprime1) {
							
							if(digTipo1.equals(null)) {
								JOptionPane.showMessageDialog(null, "O campo Tipo está vazio. Por favor prencha com um tipo válido. ");
							}
							else if(digTipo1.getText().equals("terra")) {
								vida1 = 220;
							} else if(digTipo1.getText().equals("ar")) {
								vida1 = 225;
							} else if(digTipo1.getText().equals("agua") || digTipo1.getText().equals("água")) {
								vida1 = 195;
							}else if(digTipo1.getText().equals("fogo")) {
								vida1 = 180;
							}
							else {
								vida1 = 200;
							}
							String nome1 = digNome1.getText();
							String tipo1 = digTipo1.getText();
							JOptionPane.showMessageDialog(null, "Pokemón: " + nome1 + "\n" + "Tipo: " + tipo1 +  "\n" + "Vida: " + vida1);
							 Pokemon1txt.setText(nome1);
						}
					}
				});
				BotaoImprime1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
				BotaoImprime1.setBounds(243, 212, 100, 21);
				contentPane.add(BotaoImprime1);
				
             //////////////////////////////////////////////////////////////////////////////////////
				
						JButton BotaoImprime2 = new JButton("Imprimir");
						BotaoImprime2.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent g) {
								
								if(g.getSource()==BotaoImprime2) {
										
										if(digTipo2.equals(null)) {
											JOptionPane.showMessageDialog(null, "O campo Tipo está vazio. Por favor prencha com um tipo válido. ");
										}
										else if(digTipo2.getText().equalsIgnoreCase("terra")) {
											vida2 = 220;
										} else if(digTipo2.getText().equalsIgnoreCase("ar")) {
											vida2 = 225;
										} else if(digTipo2.getText().equalsIgnoreCase("agua") || digTipo2.getText().equalsIgnoreCase("água")) {
											vida2 = 195;
										}else if(digTipo2.getText().equalsIgnoreCase("fogo")) {
											vida2 = 180;
										}
										
										else {
											vida2 = 200;
										}
										String nome2 = digNome2.getText();
										String tipo2 = digTipo2.getText();
										JOptionPane.showMessageDialog(null, "Pokemón: " + nome2 + "\n" + "Tipo: " + tipo2 +  "\n" + "Vida: " + vida2);
										Pokemon2txt.setText(nome2);
								}
							}
						});
						BotaoImprime2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
						BotaoImprime2.setBounds(633, 352, 100, 21);
						contentPane.add(BotaoImprime2);
								
           //////////////////////////////////////////////////////////////////////////////////////
								
			
			digNome2 = new JTextField();
			digNome2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
			digNome2.setColumns(10);
			digNome2.setBounds(682, 269, 74, 19);
			contentPane.add(digNome2);
			
			JLabel Nome2 = new JLabel("Nome:");
			Nome2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
			Nome2.setBounds(633, 263, 55, 26);
			contentPane.add(Nome2);
			
			digTipo2 = new JTextField();
			digTipo2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
			digTipo2.setColumns(10);
			digTipo2.setBounds(682, 299, 74, 19);
			contentPane.add(digTipo2);
			
			JLabel Tipo2 = new JLabel("Tipo:");
			Tipo2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
			Tipo2.setBounds(643, 293, 39, 26);
			contentPane.add(Tipo2);
			
			digTipo1 = new JTextField();
			digTipo1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
			digTipo1.setColumns(10);
			digTipo1.setBounds(269, 160, 74, 19);
			contentPane.add(digTipo1);
			
			JLabel Tipo1 = new JLabel("Tipo:");
			Tipo1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
			Tipo1.setBounds(230, 154, 39, 26);
			contentPane.add(Tipo1);
			
			digNome1 = new JTextField();
			digNome1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 14));
			digNome1.setBounds(269, 130, 74, 19);
			contentPane.add(digNome1);
			digNome1.setColumns(10);
			
			JLabel Nome1 = new JLabel("Nome:");
			Nome1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
			Nome1.setBounds(220, 124, 55, 26);
			contentPane.add(Nome1);
			
			JLabel Batalha = new JLabel("");
			Batalha.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/batalha vazio.png")));
			Batalha.setBounds(214, 127, 556, 351);
			contentPane.add(Batalha);
			
			JLabel Fundo = new JLabel("");
			Fundo.setIcon(new ImageIcon(Pokemon.class.getResource("/Images/fundoroxogif.gif")));
			Fundo.setBounds(0, 0, 1001, 591);
			contentPane.add(Fundo);
			 }catch (UnsupportedAudioFileException ex){
                 ex.printStackTrace();                 
			  }catch (IOException ez) {
				  ez.printStackTrace();
			  }catch (LineUnavailableException ea){
                 ea.printStackTrace();       
		}
			
			}	
		
		public static void EfeitoSonoroArrows() {
			 try {
				  File file = new File("SoundEffect.wav");
				  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
				  Clip clipEfeito = AudioSystem.getClip();
				  clipEfeito.open(audioStream);
				  clipEfeito.start();
				  clipEfeito.setMicrosecondPosition(0);
				  }catch (UnsupportedAudioFileException ex){
                       ex.printStackTrace();                 
				  }catch (IOException ez) {
					  ez.printStackTrace();
				  }catch (LineUnavailableException ea){
                       ea.printStackTrace();       
			}
		}

}

	
	
	