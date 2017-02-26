import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;

public class GamePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private Timer timer;
	private JPanel panel;
	private JLabel word = new JLabel();
	private int correct;
	private int wrong;
	private JLabel correctNum = new JLabel();
	private JLabel wrongNum = new JLabel();
	private boolean pause = true;
	private int hard;
	private int limit;
	
	public GamePanel(String name, int level) {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1100, 700);
		add(panel);
		panel.setLayout(null);
		
		
		JLabel welcome = new JLabel("Welcome "+name);
		welcome.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 40));
		welcome.setForeground(Color.YELLOW);
		welcome.setBounds(321, 0, 480, 75);
		panel.add(welcome);
		
		
		word.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 30));
		word.setForeground(Color.WHITE);
		word.setBounds(190, 150, 150, 50);
		panel.add(word);
		
		hard = 10;
		switch(level) {
		case 0:
			hard = 10;
			limit = 30;
			break;
		case 1:
			hard = 5;
			limit = 100;
			break;
		}
		
		
				timer = new Timer(hard, new ActionListener(){  
		            @Override
		            public void actionPerformed(ActionEvent e){
		                word.setLocation(word.getLocation().x+1, word.getLocation().y);  
		                if (word.getLocation().x >= 850) {
		                	word.setText(changeWord());;
		                	changeColor();
		                	word.setLocation(190, word.getLocation().y);
		                }
		                
		                if (wrong >= 3) {
		                	word.setBounds(word.getLocation().x, word.getLocation().y, 500, 100);
		                	word.setText("Game Over!!Your Score is "+correct);
		                	if (word.getLocation().x == 600) 
		                		word.setLocation(190, word.getLocation().y);
		                	word.setForeground(Color.WHITE);
		                	pause = true;
		                	timer.stop();
		                	Scores.trackScore(new score(name, correct)); //keeps track of the scores
		                }
		                if(correct == limit) {
		                	pause = true;
		                	timer.stop();
		                	if(hard == 10) {
		                	    word.setText("Game over! You've reached the score of 30!");
		                	    word.setBounds(word.getLocation().x, word.getLocation().y, 800, 100);
		                	    if (word.getLocation().x == 600) 
			                		word.setLocation(190, word.getLocation().y);
		                	    Scores.trackScore(new score(name, correct)); //keeps track of the scores
		                	}
		                	if(hard == 5) {
		                	    word.setText("Game over! You've reached the score of 100!");
		                	    word.setBounds(word.getLocation().x, word.getLocation().y, 800, 100);
		                	    if (word.getLocation().x == 600) 
			                		word.setLocation(190, word.getLocation().y);
		                	    Scores.trackScore(new score(name, correct)); //keeps track of the scores
		                	}
		                	
		                }
		                word.revalidate();
		                word.repaint();
		            }               
		        }); 
		
		JButton stop = new JButton("STOP");
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pause = true;
				timer.stop();
				word.setText("");;
            	changeColor();
            	word.setLocation(190, word.getLocation().y);
			}
		});
		
		correctNum.setText("0");
		correctNum.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 60));
		correctNum.setForeground(Color.GREEN);
		correctNum.setBounds(124, 553, 100, 100);
		panel.add(correctNum);
		
		wrongNum.setText("0");
		wrongNum.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 60));
		wrongNum.setForeground(Color.RED);
		wrongNum.setBounds(847, 553, 100, 100);
		panel.add(wrongNum);
		
		stop.setIcon(new ImageIcon("images/stop.gif"));
		stop.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		stop.setForeground(Color.BLACK);
		stop.setBounds(303, 508, 145, 29); 
		panel.add(stop); 
		
		JButton play = new JButton("PLAY");
		
		
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				word.setText(changeWord());
				changeColor();
				pause = false;
				timer.start();
			}
		}); 
		
		
		play.setIcon(new ImageIcon("images/play.gif"));
		play.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		play.setForeground(Color.BLACK);
		play.setBounds(611, 553, 145, 29); 
		panel.add(play);
		 
		
		JButton menu = new JButton("Read Me");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame read = new read(hard);
				read.setVisible(true);
				read.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
			}
		});
		menu.setIcon(new ImageIcon("images/Shutdown.gif"));
		menu.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		menu.setBounds(611, 508, 145, 29); 
		panel.add(menu);
		
		JButton highScore = new JButton("High Score");
		highScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JFrame showScores = new Scores(); //test
			    showScores.setVisible(true);
			    showScores.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);    
			}
		});
		highScore.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		highScore.setBounds(303, 553, 145, 29); 
		panel.add(highScore);
		
		JButton blue = new JButton("BLUE");
		blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pause == false) { //test
				    if (word.getForeground() == Color.blue) {
					    if (wrong < 3 ) {
						    correct();
					        word.setText(changeWord()); //trial
					        changeColor();
					        word.setLocation(190, word.getLocation().y);
					    }
				    } 
				    else 
					    wrong();
			    }
			}
		});
		blue.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		if(hard == 10) {
		     blue.setForeground(Color.BLUE);
		}
		else if(hard == 5) {
			blue.setForeground(Color.RED);
		}
		blue.setBounds(276, 316, 117, 50);
		panel.add(blue);
		
		JButton white = new JButton("WHITE");
		white.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pause == false) { //test
				    if (word.getForeground() == Color.white) {
					     if (wrong < 3 ) {
						     correct();
					         word.setText(changeWord()); //trial
					         changeColor();
					         word.setLocation(190, word.getLocation().y);
					    }
				    } 
				        else 
					wrong();
			    }
			}
		});
		if(hard == 10) {
		    white.setForeground(Color.WHITE);
		}
		else if(hard == 5) {
			white.setForeground(Color.MAGENTA);
		}
		white.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		white.setBounds(397, 378, 117, 50);
		panel.add(white);
		
		JButton red = new JButton("RED");
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pause == false) { //test
				    if (word.getForeground() == Color.red) {
					    if (wrong < 3 ) {
						    correct();
						    word.setText(changeWord()); //trial
						    changeColor();
						    word.setLocation(190, word.getLocation().y);
					    }
				    } 
				    else 
					    wrong();
			    }
			}
		});
		if(hard == 10) {
		    red.setForeground(Color.RED);
		}
		else if(hard == 5) {
		    red.setForeground(Color.YELLOW);
		}
		red.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		red.setBounds(508, 317, 117, 49);
		panel.add(red);
		
		JButton green = new JButton("GREEN");
		green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pause == false) { //test
				    if (word.getForeground() == Color.green) {
					    if (wrong < 3 ) {
						    correct();
						    word.setText(changeWord()); //trial
						    changeColor();
						    word.setLocation(190, word.getLocation().y);
					    }
				    } 
				        else 
					        wrong();
			    }
			}
		});
		if(hard == 10) {
		    green.setForeground(Color.GREEN);
		}
		else if(hard == 5) {
		    green.setForeground(Color.BLUE);
		}
		green.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		green.setBounds(731, 316, 117, 50);
		panel.add(green);
		
		JButton yellow = new JButton("YELLOW");
		yellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pause == false) { //test
				     if (word.getForeground() == Color.yellow) {
					    if (wrong < 3 ) {
						    correct();
						    word.setText(changeWord()); //trial
						    changeColor();
						    word.setLocation(190, word.getLocation().y);
					}
				} 
				    else 
					    wrong();
			    }
			}
		});
		if(hard == 10) {
		    yellow.setForeground(Color.YELLOW);
		}
		else if(hard == 5) {
		    yellow.setForeground(Color.GREEN);
		}
		yellow.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		yellow.setBounds(626, 378, 117, 50);
		panel.add(yellow);
		
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("images/border.png"));
		lblNewLabel_7.setBounds(84, 87, 987, 166);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("images/wrong.png"));
		lblNewLabel_5.setBounds(809, 427, 208, 140);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("images/correct.png"));
		lblNewLabel_4.setBounds(114, 421, 163, 110);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 337, 514, 341);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("images/background.gif"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(442, 0, 658, 345);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("images/background.gif"));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(451, 343, 649, 335);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("images/background.gif"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 516, 345);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("images/background.gif"));
		
		
	}
	
	public void changeColor() {
	    if(hard == 10) {
	    	String[] words = {" ", "Apple", "Blueberry", "Coconut", "Banana", "Lime"};
	    	for(int i=1; i<words.length; i++) {
	    	    if((word.getText()).equals(words[i])) {
	    	    	switch(i) {
	    	    	case 1:
	    	    		word.setForeground(Color.RED);
	    	    		break;
	    	    	case 2:
	    	    		word.setForeground(Color.BLUE);
	    	    		break;
	    	    	case 3:
	    	    		word.setForeground(Color.WHITE);
	    	    		break;
	    	    	case 4:
	    	    		word.setForeground(Color.YELLOW);
	    	    		break;
	    	    	case 5 :
	    	    		word.setForeground(Color.GREEN);
	    	    	    break;
	    	    	}
	            }
	    	}
	    }
		if(hard == 5) {
		    int rand = (int) ((Math.random()*5) + 1);
		    switch (rand) {
		    case 1: 
			    word.setForeground(Color.WHITE);
			    break;
		    case 2: 
			    word.setForeground(Color.RED);
			    break;
		    case 3: 
			    word.setForeground(Color.BLUE);
			    break;
		    case 4: 
			    word.setForeground(Color.YELLOW);
			    break;
		    case 5: 
			    word.setForeground(Color.GREEN);
			    break;
		    }
		}
	}	
		
	
	public String changeWord() {
		if(hard == 10) {
		    String[] words = {" ", "Apple", "Blueberry", "Coconut", "Banana", "Lime"};
		    int rand = ((int) (Math.random()*5) + 1);
		    return words[rand];
		}
		if(hard == 5) {
			String[] words = {"", "RED", "BLUE", "WHITE", "YELLOW", "GREEN"};
		    int rand = ((int) (Math.random()*5) + 1);
		    return words[rand];
		}
		return " ";
	}
	
	public void correct() {
		correct++;
		correctNum.setText(Integer.toString(correct));
		correctNum.repaint();
	}
	
	public void wrong() {
		wrong++;
		if(wrong <= 3) {
		    wrongNum.setText(Integer.toString(wrong));	
			wrongNum.repaint();
		}
	}

}
