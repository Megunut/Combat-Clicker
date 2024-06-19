/*
 * Class ScoreCounter
 * Manages and displays user score
 * @author Sean Alexander Porras
 */

package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreCounter {
	//Score counter fields
	private int score;
	
	//GUI related variables
	private JPanel scorePanel;
	private JLabel scoreLabel;
	static JPanel northLeftPanel;
	
	
	public ScoreCounter(){
		this.score = 0;
		this.addScorePanel();
	}
	
	public void addScorePanel() {
		JPanel panel = getPanel();
		panel.setLayout(new GridLayout());
		
		scorePanel = new JPanel();
		scorePanel.setLayout(new BorderLayout());
		scorePanel.setBackground(new Color(0xfcf8c7));
		panel.add(scorePanel);
			
		//creates JLabel object which will display the score 
		scoreLabel = new JLabel();
		scoreLabel.setText("<html>&emsp SCORE: <html>" + score);
		scoreLabel.setHorizontalAlignment(JLabel.LEFT);
		scoreLabel.setFont(new Font("Arial",Font.BOLD,30));
			
		scorePanel.add(scoreLabel);
	}
	
	public static void setPanel(JPanel panel) {
		northLeftPanel = panel;
	}
	
	public JPanel getPanel(){
		return northLeftPanel;
	}
	
	//updates score when an enemy is killed
	public void setScore(int scoreIncrease) {
		score += scoreIncrease;
		this.updateScoreCounter();
	}
	
	public void updateScoreCounter() {
		scoreLabel.setText("<html>&emsp SCORE: <html>" + score);
	}
	
	
	
}
