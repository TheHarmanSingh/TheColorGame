import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class read extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public read(int difficulty) {
		if(difficulty == 1) {
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setBounds(100, 100, 600, 297);
		    contentPane = new JPanel();
		    contentPane.setBackground(Color.BLACK);
		    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		    setContentPane(contentPane);
		    contentPane.setLayout(null);
		
		    JLabel lblNewLabel = new JLabel("1. A name of colour will scroll through the screen\n");
		    lblNewLabel.setForeground(Color.WHITE);
		    lblNewLabel.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		    lblNewLabel.setBounds(6, 41, 600, 71);
		    contentPane.add(lblNewLabel);
		
		    JLabel lblNewLabel_1 = new JLabel("2. Guess the colour of the font.\n");
		    lblNewLabel_1.setForeground(Color.WHITE);
		    lblNewLabel_1.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		    lblNewLabel_1.setBounds(6, 92, 425, 49);
		    contentPane.add(lblNewLabel_1);
		
		    JLabel lblNewLabel_2 = new JLabel("3. Choose the alphabetical form of that colour from options");
		    lblNewLabel_2.setForeground(Color.WHITE);
		    lblNewLabel_2.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		    lblNewLabel_2.setBounds(6, 141, 600, 30);
		    contentPane.add(lblNewLabel_2);
		
		    JLabel lblNewLabel_3 = new JLabel("How To Play");
		    lblNewLabel_3.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		    lblNewLabel_3.setForeground(Color.WHITE);
		    lblNewLabel_3.setBounds(151, 19, 129, 30);
		    contentPane.add(lblNewLabel_3);
		    
		    JLabel lblNewLabel_4 = new JLabel("4. The Game ends if you get the score of 100.");
		    lblNewLabel_4.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		    lblNewLabel_4.setForeground(Color.WHITE);
		    lblNewLabel_4.setBounds(6, 192, 600, 30);
		    contentPane.add(lblNewLabel_4);
		
	    }
		else if(difficulty == 10) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 600, 297);
			contentPane = new JPanel();
			contentPane.setBackground(Color.BLACK);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("1. A name of a fruit will scroll across the screen.\n");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel.setBounds(6, 41, 600, 71);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("2. You have to figure out what color the fruit is.\n");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel_1.setBounds(6, 92, 600, 49);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("3. Choose a color by clicking one of the color buttons.");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel_2.setBounds(6, 141, 600, 30);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("How To Play");
			lblNewLabel_3.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setBounds(151, 19, 129, 30);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("4. The Game ends if you get the score of 30.");
		    lblNewLabel_4.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
		    lblNewLabel_4.setForeground(Color.WHITE);
		    lblNewLabel_4.setBounds(6, 192, 600, 30);
		    contentPane.add(lblNewLabel_4);
		}
	}
}
