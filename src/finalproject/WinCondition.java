/*
 * Class WinCondition
 * Responsible for managing the win condition of the game
 * @author Sean Alexander Porras
 */

package finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinCondition {
	//Win condition fields
	private int goal;
	
	//GUI related variables
	private JPanel goalPanel;
	private JLabel goalLabel;
	static JPanel northRightPanel;
	
	
	public WinCondition(){
		this.goal = 15;
		this.addgoalPanel();
	}
	
	public static void setPanel(JPanel panel) {
		northRightPanel = panel;
	}
	
	public JPanel getPanel(){
		return northRightPanel;
	}
	
	public void addgoalPanel() {
		JPanel panel = getPanel();
		panel.setLayout(new GridLayout());
		
		goalPanel = new JPanel();
		goalPanel.setLayout(new BorderLayout());
		goalPanel.setBackground(new Color(0xfcf8c7));
		panel.add(goalPanel);
		
		//Label that shows the goal
		goalLabel = new JLabel();
		goalLabel.setText("<html>&emsp DEFEAT 15 <br/>&emsp REMAINING: <html>" + goal);
		goalLabel.setHorizontalAlignment(JLabel.LEFT);
		goalLabel.setFont(new Font("Arial",Font.BOLD,30));
		goalPanel.revalidate();
			
		goalPanel.add(goalLabel);
	}
	
	//updates goal whenever an enemy is killed
	public void setGoal(int goalDecrease) {
		goal -= goalDecrease;
		this.updateGoal();
	}
	
	public void updateGoal() {
		goalLabel.setText("<html>&emsp DEFEAT 15 <br/>&emsp REMAINING: <html>" + goal);
	}
	
	public int getGoal() {
		return goal;
	}
}
