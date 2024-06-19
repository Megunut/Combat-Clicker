/*
 * Class ResultChecker
 * Checks if the player has already won or lost
 * @author Sean Alexander Porras
 */

package finalproject;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ResultChecker {
	private boolean hasWon;
	private boolean hasLost;
	
	public ResultChecker(){
		this.hasWon = false;
	}
	
	//displays message and closes the program when user has won
	public void checkWin(int goal) {
		if (goal <= 0 && this.hasLost != true) {
			this.hasWon = true;
			this.gameOver();
			JLabel winner = new JLabel("Congratulations! You won!");
			winner.setFont(new Font("Arial",Font.BOLD,25));
			JOptionPane.showMessageDialog(null, winner, "The game has ended...", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
	}
	
	//displays message and closes the program when user has lost
	public void checkLose(int currentHP) {
		if (currentHP <= 0 && this.hasWon != true) {
			this.hasLost = true;
			this.gameOver();
			JLabel loser = new JLabel("You died! Better luck next time...");
			loser.setFont(new Font("Arial",Font.BOLD,25));
			JOptionPane.showMessageDialog(null, loser, "The game has ended...", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
	}
	
	//stops HP&SP regeneration and Enemy attacks
	public void gameOver() {
		ResourceBar.setStopRegen();
		for (Enemy x: EnemySpawner.getEnemies()) {
			x.enemyAtkSpeed = 100000;
			x.enemyAttack = 0;
			x.isAttacking = false;
		}
	}
}
