import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.JPanel;
import java.net.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.applet.*;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.nio.file.*;
import java.nio.charset.Charset;
import java.util.*;
import java.io.*;
import javax.sound.sampled.*;



public class Game extends JFrame {
	AudioClip audioClip;
	URL audioUrl;
	String player = "";
	private JFrame game;
	private JTextField txtName;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.game.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		game = new JFrame();
		game.setTitle("The Cool Project");
		game.setSize(1100, 700);
		
		//here
		try {
			audioUrl = new URL("file: " + new File(".").getCanonicalPath() + "//sounds//undersea.mid");
			audioClip = Applet.newAudioClip(audioUrl);
			audioClip.play();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1100, 700);
		game.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel creators = new JLabel("By: Harmanjot Singh and Joshua Sjah");
	    creators.setForeground(new Color(255, 255, 255));
		creators.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		creators.setBounds(100, 600, 700, 57); 
		panel.add(creators);
		
		
		JLabel lblNewLabel_5 = new JLabel("ENTER NAME");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_5.setBounds(399, 364, 323, 57);
		panel.add(lblNewLabel_5);
		
		txtName = new JTextField();
		txtName.setText("Name...");
		txtName.setBounds(490, 433, 130, 26);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kids", "Adult"}));
		comboBox.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		comboBox.setMaximumRowCount(2);
		comboBox.setBounds(490, 546, 130, 27);
		panel.add(comboBox);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel gamePanel = new GamePanel(txtName.getText(), comboBox.getSelectedIndex());
				game.remove(panel);
                game.getContentPane().add(gamePanel);
                game.revalidate();
                game.repaint();
			}
		});
		
		
		
		btnPlay.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		btnPlay.setBounds(477, 486, 159, 48);
		panel.add(btnPlay);
		
		JButton highScore = new JButton("High Score");
		highScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    JFrame showScores = new Scores(); //test
			    showScores.setVisible(true);
			    showScores.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
			    
			}
		});
		highScore.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		highScore.setBounds(799, 603, 117, 41);
		panel.add(highScore);
		
		
		JLabel lblColorGame = new JLabel("COLOR GAME");
		lblColorGame.setForeground(new Color(255, 255, 255));
		lblColorGame.setBounds(306, 57, 583, 95);
		panel.add(lblColorGame);
		lblColorGame.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 70));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(362, 156, 385, 152);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setLabelFor(game.getContentPane());
		lblNewLabel_4.setIcon(new ImageIcon("images/kids.png"));
		
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
		
		try {
			   audioUrl=new URL("file:" + new File(".").getCanonicalPath()
			                                 + "//sounds//undersea.mid");

	           audioClip=Applet.newAudioClip(audioUrl);
	           audioClip.play();
		   }catch(Exception e){
	            System.out.println(e.toString());
	       }
			
	}
}
