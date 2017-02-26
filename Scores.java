import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Scores extends JFrame{
  private JPanel contents;
  
  public Scores() {	
	//create the frame  
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 600, 600);
	contents = new JPanel();
	contents.setBackground(Color.BLACK);
	contents.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contents);
	contents.setLayout(null);
	
	JLabel title = new JLabel("High Scores", SwingConstants.CENTER);
	title.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
	title.setForeground(Color.WHITE);
	title.setBounds(6, 41, 600, 100);
	contents.add(title);
	ArrayList<score> scoreList;
	
	try{
	    File file = new File("src/test.txt"); 
        Scanner input = new Scanner(file);
        scoreList = new ArrayList<score>(6);
        if(input.hasNext()) {
            while(input.hasNext()) {
                scoreList.add(new score(input.next(), input.nextInt()));
            }
        }
        if(scoreList.size() < 6){
            while(scoreList.size()<6) {
        	    scoreList.add(new score("N/A", 0));  
            }
        }
        
	    JLabel scoreOne = new JLabel("1. " + (scoreList.get(0)).toString());
	    scoreOne.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
	    scoreOne.setForeground(Color.WHITE);
	    scoreOne.setBounds(6, 41, 600, 200);
	    contents.add(scoreOne);
	    
	    JLabel scoreTwo = new JLabel("2. " + scoreList.get(1).toString());
	    scoreTwo.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
	    scoreTwo.setForeground(Color.WHITE);
	    scoreTwo.setBounds(6, 41, 600, 300);
	    contents.add(scoreTwo);
	    
	    JLabel scoreThree = new JLabel("3. " + scoreList.get(2).toString());
	    scoreThree.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
	    scoreThree.setForeground(Color.WHITE);
	    scoreThree.setBounds(6, 41, 600, 400);
	    contents.add(scoreThree);
	    
	    JLabel scoreFour = new JLabel("4. " + scoreList.get(3).toString());
	    scoreFour.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
	    scoreFour.setForeground(Color.WHITE);
	    scoreFour.setBounds(6, 41, 600, 500);
	    contents.add(scoreFour);
	    
	    JLabel scoreFive = new JLabel("5. " + scoreList.get(4).toString());
	    scoreFive.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
	    scoreFive.setForeground(Color.WHITE);
	    scoreFive.setBounds(6, 41, 600, 600);
	    contents.add(scoreFive);
	    
	    JLabel scoreSix = new JLabel("6. " + scoreList.get(5).toString());
	    scoreSix.setFont(new Font("Apple Chancery", Font.BOLD | Font.ITALIC, 20));
	    scoreSix.setForeground(Color.WHITE);
	    scoreSix.setBounds(6, 41, 600, 700);
	    contents.add(scoreSix);
        }
    catch(IOException error) {
        System.out.println(error);
    }
  }
  public static void trackScore(score currentScore) {
	  ArrayList<score> scoreList;
	  try{
		    File file = new File("src/test.txt"); 
	        Scanner input = new Scanner(file);
	        scoreList = new ArrayList<score>(6);
	        if(input.hasNext()) {
	            while(input.hasNext()) {
	                scoreList.add(new score(input.next(), input.nextInt()));
	            }
	        }
	        if(scoreList.size() < 6){
	            while(scoreList.size() < 6) {
	        	    scoreList.add(new score("N/A", 0));  
	            }
	        }
	        for(int i=0; i<scoreList.size(); i++) {
	        	if(currentScore.getScore() >= (scoreList.get(i)).getScore() && i<6) { //compares the scores  
	        	    scoreList.remove(5); //remove the lowest score in the file
	        	    scoreList.add(i, currentScore); //puts the score in where it belongs as long as it is higher than the lowest score
	        	    break;
	        	}
	        
	        }
	        String[] newScores = new String[6]; //helps create a list for the new file
	        for(int i=0; i<scoreList.size(); i++) {
	        	newScores[i] = (scoreList.get(i)).toString(); //rewrites the scores onto the file
	        }
	        
	        Path filePath = Paths.get("src/test.txt"); //path to create the file
	        java.util.List<String> lines = Arrays.asList(newScores); //list to create the file
	        Files.write(filePath, lines, Charset.forName("UTF-8")); //creates the file with the new scores
	    }	
	    catch(IOException e) {
	        System.out.println(e);
	    }
	    
  }
}