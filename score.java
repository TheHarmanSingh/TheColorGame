//keeps track of the score and name of the player who obtained the score
public class score {
  private String name;
  private int score;
  
  public score(String name, int score) {
	this.name = name;
	this.score = score;
  }
  
  public String getName() {
	return name;
  }
  
  public int getScore() {
	return score;  
  }
  
  public String toString() {
	return name + " " + score;
  }
}