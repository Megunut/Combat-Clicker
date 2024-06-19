/*
 * Class Enemy
 * Parent class for enemy objects, contains enemy related fields and methods
 * @author Sean Alexander Porras
 */

package finalproject;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class Enemy extends JFrame implements MouseListener{
	//enemy sprites
	protected ImageIcon sprite;
	protected ImageIcon spriteAttacked;
	protected ImageIcon spriteDodged;
	protected ImageIcon spriteBlocked;
	
	//GUI related variables
	private JPanel enemyPanel;
	private JPanel enemyHPBarPanel;
	private JPanel enemyAtkPanel;
	private JLabel enemyLabel;
	protected JProgressBar enemyAtkIndicator;
	protected JProgressBar enemyHPBar;
	
	//static variables
	static JPanel centerPanel;
	static ScoreCounter scoreCount;
	static WinCondition goal;
	static ResultChecker result;
	static int enemyCount;
	private static Weapon equippedWeapon;
	
	//enemy fields
	protected String enemyType;
	protected int enemyHP;
	protected int enemyAttack;
	protected int enemyEvasion;
	protected int enemyDefense;
	protected int enemyPoints;
	protected int enemyAtkSpeed;
	protected int enemyAtkTimer;
	protected boolean isAttacking;
	
	public Enemy(){
		enemyCount += 1;
		this.enemyEvasion = 0;
		this.enemyDefense = 0;
		this.isAttacking = true;
	}
	
	public static void createScoreCounter() {
		scoreCount = new ScoreCounter();
	}
	
	public static void createWinCondition() {
		goal = new WinCondition();
	}
	
	public static void createResultChecker() {
		result = new ResultChecker();
	}
	
	public static void getEquippedWeapon(Weapon weapon) {
		equippedWeapon = weapon;
	}
	
	public int getAtk() {
		return this.enemyAttack;
	}
	
	public int getAtkSpeed() {
		return this.enemyAtkSpeed;
	}
	
	public static void setPanel(JPanel panel) {
		centerPanel = panel;
	}
	
	public JPanel getPanel(){
		return centerPanel;
	}
	
	//creates JPanel where an enemy will be placed
	public void addEnemyPanel() {
		JPanel panel = getPanel();
		panel.setLayout(new GridLayout());
		
		enemyPanel = new JPanel();
		enemyPanel.setLayout(new BorderLayout());
		enemyPanel.setBackground(new Color(0xfbf49b));
		panel.add(enemyPanel);
		this.addHPBar();
		this.addAtkIndicator();
			
		//creates JLabel object which will hold the sprite image 
		enemyLabel = new JLabel();
		enemyLabel.setIcon(sprite);
		enemyLabel.setHorizontalAlignment(JLabel.CENTER);
		enemyLabel.setVerticalAlignment(JLabel.TOP);
		enemyLabel.addMouseListener(this);
			
		enemyPanel.add(enemyLabel);
	}
	
	//JProgress Bar that shows how much health an enemy has
	public void addHPBar() {
		enemyHPBarPanel = new JPanel();
		enemyHPBarPanel.setBackground(new Color(0xfbf49b));
		enemyPanel.add(enemyHPBarPanel,BorderLayout.NORTH);
		enemyHPBar = new JProgressBar(0,enemyHP);
		enemyHPBar.setValue(enemyHP);
		enemyHPBar.setForeground(Color.GREEN);
		enemyHPBarPanel.add(enemyHPBar);
	}
	
	//JProgress Bar that shows when an enemy will attack
	public void addAtkIndicator() {
		enemyAtkPanel = new JPanel();
		enemyAtkPanel.setBackground(new Color(0xfbf49b));
		enemyPanel.add(enemyAtkPanel,BorderLayout.SOUTH);
		enemyAtkIndicator = new JProgressBar(0,enemyAtkTimer);
		enemyAtkIndicator.setValue(enemyAtkTimer);
		enemyAtkIndicator.setForeground(Color.BLUE);
		enemyAtkPanel.add(enemyAtkIndicator);	
	}
	
	//when enemy dying will cause a new one to be created
	//killing an enemy increases the score and becomes closer to reaching the goal
	public void enemyDeath() {
		JPanel panel = getPanel();
		panel.remove(enemyPanel);
		this.stopEnemyAttack();
		//this.enemyAttack = 0;
		this.enemyHP = 0;
		enemyCount -= 1;
		scoreCount.setScore(this.enemyPoints);
		goal.setGoal(1);
		result.checkWin(goal.getGoal());
		
		panel.validate();	//refreshes JPanel when an enemy dies
	}
	
	public void stopEnemyAttack() {
			this.isAttacking = false;
	}
	
	//allows user to attack enemy, but has a chance to fail the attack 
	//depending on the enemy type and user's equipped weapon
	public int userAttacked(){
		Random random = new Random();
		int success = 1;
		int dodged = 2;
		int blocked = 3;
		int randomNumberHolder = random.nextInt(100)+1;
		
		int blockCheck = this.enemyDefense - equippedWeapon.weaponArmorPen;
		int dodgeCheck = this.enemyEvasion - equippedWeapon.weaponAccuracy;
		//checks if attack is either blocked or dodged by enemy
		if (dodgeCheck > 0 && randomNumberHolder <= dodgeCheck) {
			return dodged;
		}else if (blockCheck > 0 && randomNumberHolder <= blockCheck){
			return blocked;
		}return success;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		//label.setIcon(spriteAttacked);
		
	}
	
	//user attacks when they click an enemy using the mouse
	//attack results are dependent on userAttacked()
	//catches NullPointerException caused when no weapon was equipped
	@Override
	public void mousePressed(MouseEvent e){
		try {
			int attackResult = this.userAttacked();
			int currentSP = SP.getCurrentSP();
			if (currentSP < equippedWeapon.weaponSPCost) {
				return;
			}
			SP.updateSPBar(equippedWeapon.weaponSPCost);	
			switch (attackResult) {
			case 1: //Enemy damaged
				enemyLabel.setIcon(spriteAttacked);
				this.enemyHP -= equippedWeapon.weaponAtk;
				this.enemyHPBar.setValue(enemyHP);
				break;
			case 2: //Enemy dodged
				enemyLabel.setIcon(spriteDodged);
				break;
			case 3: //Enemy blocked
				enemyLabel.setIcon(spriteBlocked);
				break;		
			}
	
			if (this.enemyHP <= 0) {
				enemyDeath();
			}
		}catch (NullPointerException f) {
			System.out.println("You can't attack without equipping a weapon!");		
		}		
	}
	
	//resets enemy sprite to default after click
	@Override
	public void mouseReleased(MouseEvent e) {
		enemyLabel.setIcon(sprite);	
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}

}
